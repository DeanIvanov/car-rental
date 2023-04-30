package com.example.carrental.services;

import com.example.carrental.models.Car;
import com.example.carrental.models.Location;
import com.example.carrental.models.User;
import com.example.carrental.repositories.CarRepository;
import com.example.carrental.repositories.LocationRepository;
import com.example.carrental.repositories.PaymentRepository;
import com.example.carrental.services.impl.CarServiceImpl;
import com.example.carrental.services.impl.LocationServiceImpl;
import com.example.carrental.services.impl.PaymentServiceImpl;
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
    public void getByT0ransmissionCarTest() {
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

//    @Test
//    public void getByLocationCarTest() {
//        Car car = new Car();
//        Location location = new Location();
//        car.setLocation(location);
//        List<Car> CarList = new ArrayList<>();
//        CarList.add(car);
//
//        when(carRepository.findAllByLocation(location)).thenReturn(CarList);
//        carService.getByLocation(location.getName());
//
//
//        Assert.assertEquals(1, CarList.size());
//        verify(carRepository, times(1)).findAllByLocation(location);
//    }
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
}

