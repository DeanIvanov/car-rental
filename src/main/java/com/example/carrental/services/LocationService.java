package com.example.carrental.services;

import com.example.carrental.models.Location;

import java.util.List;

public interface LocationService {

    void create(Location location);

    void update(Location location);

    void delete(Location location);

    List<Location> getAll();

    Location getById(int id);

    List<Location> getByName(String name);

    List<Location> getLocation(String search);

}
