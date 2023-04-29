package com.example.carrental.services;

import com.example.carrental.repositories.CarRepository;
import com.example.carrental.repositories.LocationRepository;
import com.example.carrental.repositories.PaymentRepository;
import com.example.carrental.services.impl.CarServiceImpl;
import com.example.carrental.services.impl.LocationServiceImpl;
import com.example.carrental.services.impl.PaymentServiceImpl;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


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


}

