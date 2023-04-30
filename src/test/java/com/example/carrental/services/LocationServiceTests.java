package com.example.carrental.services;

import com.example.carrental.exceptions.DuplicateEntityException;
import com.example.carrental.exceptions.InvalidUserInputException;
import com.example.carrental.models.Car;
import com.example.carrental.models.Location;
import com.example.carrental.models.User;
import com.example.carrental.repositories.LocationRepository;
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

    @Test
    public void createLocationTest(){

        Location location = new Location();

        locationService.create(location);

        verify(locationRepository,times(1)).save(location);

    }
    @Test
    public void updateLocationTest(){

        Location location = new Location();
        location.setName("test");
        location.setPhone("0885123465");

        when(locationRepository.getById(location.getId())).thenReturn(location);

        locationService.update(location.getId(), location);

        verify(locationRepository,times(1)).save(location);

    }

//    @Test(expected = DuplicateEntityException.class)
//    public void createLocationDuplicateTest(){
//        Location location = new Location();
//        location.setName("test");
//        location.setPhone("0885123465");
//        Location location2 = new Location();
//        location2.setName("test");
//        location2.setPhone("0885123465");
//    }

    @Test
    public void getAllLocationsTest(){

        Location location = new Location();
        List<Location> Locationlist = new ArrayList<>();
        Locationlist.add(location);

        when(locationRepository.findAll()).thenReturn(Locationlist);
        locationService.getAll();

        Assert.assertEquals(1, Locationlist.size());
        verify(locationRepository,times(1)).findAll();

    }

    @Test
    public void getByIdLocationTest(){

        Location location = new Location();
        location.setId(5);

        when(locationRepository.getById(5)).thenReturn(location);
        Location retrievedUser = locationService.getById(5);

        Assert.assertEquals(location, retrievedUser);
        verify(locationRepository,times(1)).getById(5);
    }

    @Test
    public void getLocationTest(){

        Location location = new Location();
        location.setName("test");
        location.setPhone("0885123465");
        List<Location> Locationlist = new ArrayList<>();
        Locationlist.add(location);



        when(locationRepository.findAllByPhoneLikeOrNameLike("test", "test")).thenReturn(Locationlist);
        locationService.getLocation("test");

        Assert.assertEquals(1, Locationlist.size());
        verify(locationRepository,times(1)).findAllByPhoneLikeOrNameLike("test","test");
    }
}
