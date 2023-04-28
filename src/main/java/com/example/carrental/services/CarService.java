package com.example.carrental.services;

import com.example.carrental.models.Car;
import com.example.carrental.models.Location;

import java.time.LocalDate;
import java.util.List;

public interface CarService {

    void create(int id, Car car);

    void update(int id, Car car);

    void delete(Car car);

    void changeAvailability(Car car);

    void changeLocation(Location location, Car car);

    void changeServiceDate(LocalDate date, Car car);

    List<Car> getAll();

    Car getById(int id);

    List<Car> getByName(String name);

    List<Car> getByColor(String color);

    List<Car> getByTransmission(String transmission);

    List<Car> getByType(int type);

    List<Car> getBySeats(int min, int max);

    List<Car> getByLocation(String location);

    List<Car> getByAvailability(boolean available);

    List<Car> getAvailableForLocationId(boolean available, int id);

}
