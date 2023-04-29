package com.example.carrental.services;

import com.example.carrental.models.Car;
import com.example.carrental.models.Location;
import com.example.carrental.repositories.LocationRepository;
import com.example.carrental.services.impl.LocationServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LocationServiceTests {

    @Mock
    LocationRepository locationRepository;

    @InjectMocks
    LocationServiceImpl locationService;


    @Test
    public void deleteLocationTest(){

        Location location = new Location();
        locationService.delete(location);

        verify(locationRepository,times(1)).delete(location);


    }





}
