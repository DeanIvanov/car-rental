package com.example.carrental.services;

import com.example.carrental.models.Car;
import com.example.carrental.models.User;
import com.example.carrental.repositories.CarRepository;
import com.example.carrental.repositories.LocationRepository;
import com.example.carrental.repositories.PaymentRepository;
import com.example.carrental.services.impl.CarServiceImpl;
import com.example.carrental.services.impl.LocationServiceImpl;
import com.example.carrental.services.impl.PaymentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


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
    public void deleteCarTest(){

        Car car = new Car();
        carService.delete(car);

        verify(carRepository,times(1)).delete(car);


    }
}

