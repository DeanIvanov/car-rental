package com.example.carrental.services;

import com.example.carrental.models.Car;

import java.util.List;

public interface CarService {

    void create(int id, Car car);

    void update(int id, Car car);

    void delete(Car car);

    List<Car> getAll();

    Car getById(int id);

    List<Car> getByModel(String model);

    List<Car> getByColor(String color);

    List<Car> getByTransmission(String transmission);

    List<Car> getByType(int type);

    List<Car> getBySeats(int seats);

    List<Car> getByLocation(String location);

    List<Car> getByAvailability(boolean available);

}
