package com.example.carrental.services;

import com.example.carrental.exceptions.DuplicateEntityException;
import com.example.carrental.models.Car;
import com.example.carrental.models.Location;
import com.example.carrental.repositories.CarRepository;
import com.example.carrental.repositories.LocationRepository;
import com.example.carrental.services.impl.CarServiceImpl;
import com.example.carrental.services.impl.LocationServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class CarServiceTests {

    @Mock
    CarRepository carRepository;

    @Mock
    LocationRepository locationRepository;

    @InjectMocks
    CarServiceImpl carService;

    @InjectMocks
    LocationServiceImpl locationService;

    @Test
    public void deleteCarTest() {

        Car car = new Car();
        carService.delete(car);

        verify(carRepository, times(1)).delete(car);


    }

    @Test
    public void createCarTest() {

        Car car = new Car();

        carService.create(1, car);

        verify(carRepository, times(1)).save(car);

    }

    @Test(expected = DuplicateEntityException.class)
    public void createCarShouldThrowExceptionWhenRegistrationNumberAlreadyExistsTest(){

        Car car = new Car();
        car.setRegistrationNumber("12345678");

        when(carRepository.existsByRegistrationNumber(car.getRegistrationNumber())).thenReturn(true);
        carService.create(car.getId(), car);

        verify(carRepository, times(1)).save(car);

    }

    @Test
    public void updateCarTest() {

        Car car = new Car();
        car.setName("test");
        car.setModel("test");
        car.setType(1);
        car.setColor("green");
        car.setLocation(locationRepository.getById(1));
        car.setTransmission("automatic");
        car.setPrice(200);
        car.setSeats(2);
        car.setRegistrationNumber("12345678");
        car.setServiceDate(LocalDate.of(2023, 1, 21));
        car.setAvailable(true);

        when(carRepository.getById(car.getId())).thenReturn(car);

        carService.update(car.getId(), car);

        verify(carRepository, times(1)).save(car);

    }

    @Test
    public void getAllCarsTest() {

        Car car = new Car();
        List<Car> CarsList = new ArrayList<>();
        CarsList.add(car);

        when(carRepository.findAll()).thenReturn(CarsList);
        carService.getAll();

        Assert.assertEquals(1, CarsList.size());
        verify(carRepository, times(1)).findAll();

    }

    @Test
    public void getByIdCarTest() {

        Car car = new Car();
        car.setId(5);

        when(carRepository.getById(5)).thenReturn(car);
        Car retrievedUser = carService.getById(5);

        Assert.assertEquals(car, retrievedUser);
        verify(carRepository, times(1)).getById(5);
    }

    @Test
    public void getByNameCarTest() {
        Car car = new Car();
        car.setName("test");
        car.setModel("test");
        List<Car> CarList = new ArrayList<>();
        CarList.add(car);

        when(carRepository.findAllByNameLikeOrModelLike("test", "test")).thenReturn(CarList);
        carService.getByName("test");


        Assert.assertEquals(1, CarList.size());
        verify(carRepository, times(1)).findAllByNameLikeOrModelLike("test", "test");
    }
    @Test
    public void getByColorCarTest() {
        Car car = new Car();
        car.setColor("blue");
        List<Car> CarList = new ArrayList<>();
        CarList.add(car);

        when(carRepository.findAllByColor("blue")).thenReturn(CarList);
        carService.getByColor("blue");


        Assert.assertEquals(1, CarList.size());
        verify(carRepository, times(1)).findAllByColor("blue");
    }
    @Test
    public void getByTransmissionCarTest() {
        Car car = new Car();
        car.setTransmission("manual");
        List<Car> CarList = new ArrayList<>();
        CarList.add(car);

        when(carRepository.findAllByTransmission("manual")).thenReturn(CarList);
        carService.getByTransmission("manual");


        Assert.assertEquals(1, CarList.size());
        verify(carRepository, times(1)).findAllByTransmission("manual");
    }

    @Test
    public void getByTypeCarTest() {
        Car car = new Car();
        car.setType(1);
        List<Car> CarList = new ArrayList<>();
        CarList.add(car);

        when(carRepository.findAllByType(1)).thenReturn(CarList);
        carService.getByType(1);


        Assert.assertEquals(1, CarList.size());
        verify(carRepository, times(1)).findAllByType(1);
    }
    @Test
    public void getBySeatsCarTest() {
        Car car = new Car();
        car.setSeats(5);
        List<Car> CarList = new ArrayList<>();
        CarList.add(car);

        when(carRepository.findAllBySeatsBetween(4,6)).thenReturn(CarList);
        carService.getBySeats(4,6);


        Assert.assertEquals(1, CarList.size());
        verify(carRepository, times(1)).findAllBySeatsBetween(4,6);
    }

    @Test
    public void getByLocationCarTest() {
        Car car = new Car();
        Location location = new Location();
        car.setLocation(location);
        List<Car> carList = new ArrayList<>();
        carList.add(car);
        List<Location> locationList = new ArrayList<>();
        locationList.add(location);

        when(locationRepository.findAllByPhoneLikeOrNameLike(location.getName(),location.getName())).thenReturn(locationList);
        when(carRepository.findAllByLocation(locationList.get(0))).thenReturn(carList);
        carService.getByLocation(location.getName());

        Assert.assertEquals(1,carList.size());
        verify(carRepository, times(1)).findAllByLocation(locationList.get(0));
    }

@Test
public void getByAvailabilityCarTest() {
    Car car = new Car();
    car.setAvailable(true);
    List<Car> CarList = new ArrayList<>();
    CarList.add(car);

    when(carRepository.findAllByAvailable(true)).thenReturn(CarList);
    carService.getByAvailability(true);


    Assert.assertEquals(1, CarList.size());
    verify(carRepository, times(1)).findAllByAvailable(true);
}
    @Test
    public void getByAvailabilityForLocationIdCarTest() {
        Car car = new Car();
        car.setAvailable(true);
        Location location = new Location();
        List<Car> CarList = new ArrayList<>();
        CarList.add(car);
        when(carRepository.findAllByAvailableAndLocationId(true, location.getId())).thenReturn(CarList);
        carService.getAvailableForLocationId(true, location.getId());


        Assert.assertEquals(1, CarList.size());
        verify(carRepository, times(1)).findAllByAvailableAndLocationId(true, location.getId());
    }

    @Test
    public void changeCarAvailabilityIfUnavailableTest() {

        Car car = new Car();
        car.setAvailable(false);

        carService.changeAvailability(car);
        verify(carRepository,times(1)).save(car);
    }

    @Test
    public void changeCarAvailabilityIfAvailableTest() {

        Car car = new Car();
        car.setAvailable(true);

        carService.changeAvailability(car);
        verify(carRepository,times(1)).save(car);
    }

    @Test
    public void changeCarLocationTest(){

        Car car = new Car();
        Location location = new Location();
        car.setLocation(location);
        Location newLocation = new Location();

        when(carRepository.getById(car.getId())).thenReturn(car);
        carService.changeLocation(newLocation, car);

        verify(carRepository,times(1)).save(car);
    }

    @Test
    public void changeCarServiceDateTest(){

        Car car = new Car();
        LocalDate date = LocalDate.now();
        car.setServiceDate(date);
        LocalDate newDate = LocalDate.now();

        when(carRepository.getById(car.getId())).thenReturn(car);
        carService.changeServiceDate(newDate, car);

        verify(carRepository,times(1)).save(car);
    }


}

