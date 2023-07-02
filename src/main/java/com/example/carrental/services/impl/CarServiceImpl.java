package com.example.carrental.services.impl;

import com.example.carrental.exceptions.DuplicateEntityException;
import com.example.carrental.models.Car;
import com.example.carrental.models.Location;
import com.example.carrental.repositories.CarRepository;
import com.example.carrental.repositories.LocationRepository;
import com.example.carrental.services.CarService;
import com.example.carrental.services.LocationService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;
    private LocationRepository locationRepository;

    public CarServiceImpl(CarRepository carRepository, LocationRepository locationRepository) {
        this.carRepository = carRepository;
        this.locationRepository = locationRepository;
    }

    /*
    * Checks if car registration number already exists in the database, sets car availability and saves the
    * new car to the database through the repository class.
    * */
    @Override
    public void create(int id, Car car) {
        if(carRepository.existsByRegistrationNumber(car.getRegistrationNumber())){
            throw new DuplicateEntityException(String.format("Car with registration number %s already exists!", car.getRegistrationNumber()));
        }
        car.setAvailable(true);

        carRepository.save(car);
    }

    /*
    * Updates each property of a car object and saves it in the database through the repository class.
    * */
    @Override
    public void update(int id, Car car) {
        Car newCar = carRepository.getById(id);

        newCar.setName(car.getName());
        newCar.setModel(car.getModel());
        newCar.setType(car.getType());
        newCar.setColor(car.getColor());
        newCar.setLocation(car.getLocation());
        newCar.setTransmission(car.getTransmission());
        newCar.setPrice(car.getPrice());
        newCar.setSeats(car.getSeats());
        newCar.setRegistrationNumber(car.getRegistrationNumber());
        newCar.setServiceDate(car.getServiceDate());
        newCar.setAvailable(car.isAvailable());

        carRepository.save(newCar);
    }

    /*
    * Deletes a car through the repository class.
    * */
    @Override
    public void delete(Car car) {
        carRepository.delete(car);
    }

    /*
    * Flips the availability status of the car and updates it in the database.
    * */
    @Override
    public void changeAvailability(Car car) {
        if(car.isAvailable()){
            car.setAvailable(false);
        } else {
            car.setAvailable(true);
        }
        carRepository.save(car);

    }

    /*
    * Updates the location property of the car object and updates it in the database.
    * */
    @Override
    public void changeLocation(Location location, Car car) {
        Car newCar = carRepository.getById(car.getId());
        newCar.setLocation(car.getLocation());
        carRepository.save(newCar);
    }

    /*
    * Updates the service date property of the car object and updates it in the database.
    * */
    @Override
    public void changeServiceDate(LocalDate date, Car car) {
        Car newCar = carRepository.getById(car.getId());
        newCar.setServiceDate(car.getServiceDate());
        carRepository.save(newCar);
    }

    /*
    * Gets a list of all car objects from the database.
    * */
    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    /*
    * Gets a single car object by its ID from the database.
    * */
    @Override
    public Car getById(int id) {
        return carRepository.getById(id);
    }

    /*
    * Gets a list of all car objects that match the searched name or model.
    * */
    @Override
    public List<Car> getByName(String name) {
        return carRepository.findAllByNameLikeOrModelLike(name, name);
    }

    /*
    * Gets a list of all car objects that match the searched color name.
    * */
    @Override
    public List<Car> getByColor(String color) {
        return carRepository.findAllByColor(color);
    }

    /*
    * Gets a list of all car objects that match the searched transmission type.
    * */
    @Override
    public List<Car> getByTransmission(String transmission) {
        return carRepository.findAllByTransmission(transmission);
    }

    /*
    * Gets a list of all car objects that match the searched vehicle type.
    * */
    @Override
    public List<Car> getByType(int type) {
        return carRepository.findAllByType(type);
    }

    /*
    * Gets a list of all car objects that match the searched number of seats between the minimum and maximum value.
    * */
    @Override
    public List<Car> getBySeats(int min, int max) {
        return carRepository.findAllBySeatsBetween(min, max);
    }

    /*
    * Gets a list of all car objects that match the searched location name.
    * */
    @Override
    public List<Car> getByLocation(String name) {
        Location location = locationRepository.findAllByPhoneLikeOrNameLike(name, name).get(0);
        return carRepository.findAllByLocation(location);
    }

    /*
    * Gets a list of all car objects that match the searched availability.
    * */
    @Override
    public List<Car> getByAvailability(boolean available) {
        return carRepository.findAllByAvailable(available);
    }

    /*
    * Gets a list of all car objects that match the searched location ID and availability.
    * */
    @Override
    public List<Car> getAvailableForLocationId(boolean available, int id) {
        return carRepository.findAllByAvailableAndLocationId(available, id);
    }

}
