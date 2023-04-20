package com.example.carrental.services.impl;

import com.example.carrental.exceptions.DuplicateEntityException;
import com.example.carrental.models.Location;
import com.example.carrental.repositories.LocationRepository;
import com.example.carrental.services.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public void create(Location location) {
        if(locationRepository.existsByName(location.getName())) {
            throw new DuplicateEntityException(String.format("Location with the name of %s already exists!", location.getName()));
        }
        locationRepository.save(location);
    }

    @Override
    public void update(int id, Location location) {
        Location newLocation = locationRepository.getById(id);
        newLocation.setName(location.getName());
        newLocation.setPhone(location.getPhone());
        locationRepository.save(newLocation);
    }

    @Override
    public void delete(Location location) {
        locationRepository.delete(location);
    }

    @Override
    public List<Location> getAll() {
        return locationRepository.findAll();
    }

    @Override
    public Location getById(int id) {
        return locationRepository.getById(id);
    }

    @Override
    public List<Location> getLocation(String search) {
        return locationRepository.findAllByPhoneLikeOrNameLike(search, search);
    }

}
