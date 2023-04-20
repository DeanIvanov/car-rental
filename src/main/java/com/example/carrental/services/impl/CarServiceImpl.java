package com.example.carrental.services.impl;

import com.example.carrental.models.Car;
import com.example.carrental.services.CarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {


    @Override
    public void create(int id, Car car) {

    }

    @Override
    public void update(int id, Car car) {

    }

    @Override
    public void delete(Car car) {

    }

    @Override
    public List<Car> getAll() {
        return null;
    }

    @Override
    public Car getById(int id) {
        return null;
    }

    @Override
    public List<Car> getByModel(String model) {
        return null;
    }

    @Override
    public List<Car> getByColor(String color) {
        return null;
    }

    @Override
    public List<Car> getByTransmission(String transmission) {
        return null;
    }

    @Override
    public List<Car> getByType(int type) {
        return null;
    }

    @Override
    public List<Car> getBySeats(int seats) {
        return null;
    }

    @Override
    public List<Car> getByLocation(String location) {
        return null;
    }

    @Override
    public List<Car> getByAvailability(boolean available) {
        return null;
    }

}
