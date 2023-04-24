package com.example.carrental.services.impl;

import com.example.carrental.exceptions.DuplicateEntityException;
import com.example.carrental.models.Car;
import com.example.carrental.models.Location;
import com.example.carrental.repositories.CarRepository;
import com.example.carrental.services.CarService;
import com.example.carrental.services.LocationService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;
    private LocationService locationService;

    public CarServiceImpl(CarRepository carRepository, LocationService locationService) {
        this.carRepository = carRepository;
        this.locationService = locationService;
    }

    @Override
    public void create(int id, Car car, MultipartFile multipartFile) {
        if(carRepository.existsByRegistrationNumber(car.getRegistrationNumber())){
            throw new DuplicateEntityException(String.format("Car with registration number %s already exists!", car.getRegistrationNumber()));
        }

        if(!multipartFile.isEmpty()){
            String carImage = uploadFile(multipartFile);
            car.setCarPicture(carImage);
        }

//        update(newCar.getId(), car, multipartFile);

        carRepository.save(car);
    }

    @Override
    public void update(int id, Car car, MultipartFile multipartFile) {
        Car newCar = carRepository.getById(id);
        if(!multipartFile.isEmpty()){
            String carImage = uploadFile(multipartFile);
            newCar.setCarPicture(carImage);
        }
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

    @Override
    public void delete(Car car) {
        carRepository.delete(car);
    }

    @Override
    public void changeAvailability(Car car) {
        if(car.isAvailable()){
            car.setAvailable(false);
        } else {
            car.setAvailable(true);
        }
        carRepository.save(car);
    }

    @Override
    public void changeLocation(Location location, Car car) {
        Car newCar = carRepository.getById(car.getId());
        newCar.setLocation(car.getLocation());
        carRepository.save(newCar);
    }

    @Override
    public void changeServiceDate(LocalDate date, Car car) {
        Car newCar = carRepository.getById(car.getId());
        newCar.setServiceDate(car.getServiceDate());
        carRepository.save(newCar);
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public Car getById(int id) {
        return carRepository.getById(id);
    }

    @Override
    public List<Car> getByName(String name) {
        return carRepository.findAllByNameLikeOrModelLike(name, name);
    }

    @Override
    public List<Car> getByColor(String color) {
        return carRepository.findAllByColor(color);
    }

    @Override
    public List<Car> getByTransmission(int transmission) {
        return carRepository.findAllByTransmission(transmission);
    }

    @Override
    public List<Car> getByType(int type) {
        return carRepository.findAllByType(type);
    }

    @Override
    public List<Car> getBySeats(int min, int max) {
        return carRepository.findAllBySeatsBetween(min, max);
    }

    @Override
    public List<Car> getByLocation(String name) {
        Location location = locationService.getLocation(name).get(0);
        return carRepository.findAllByLocation(location);
    }

    @Override
    public List<Car> getByAvailability(boolean available) {
        return carRepository.findAllByAvailable(available);
    }



    private String uploadFile(MultipartFile file) {
        if(!file.isEmpty()){
            try {
                byte[] bytes = file.getBytes();
                String rootPath = "C:\\uploads";
                File dir = new File("C:/");
                if(!dir.exists()){
                    dir.mkdirs();
                }
                String name = String.valueOf("/uploads/"+new Date().getTime()) + ".jpg";
                File serverFile = new File(dir.getAbsolutePath()
                        +File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);

                return name;
            }
            catch (IOException e){
                e.printStackTrace();
            }
        } else {
            return "/uploads/car.jpg";
        }
        return null;
    }

}
