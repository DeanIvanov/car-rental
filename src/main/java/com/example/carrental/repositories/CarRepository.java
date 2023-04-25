package com.example.carrental.repositories;

import com.example.carrental.models.Car;
import com.example.carrental.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    Car getById(int id);

    List<Car> findAll();

    List<Car> findAllByNameLikeOrModelLike(String name, String model);

    List<Car> findAllByColor(String color);

    List<Car> findAllByTransmission(String transmission);

    List<Car> findAllByType(int type);

    List<Car> findAllBySeatsBetween(int min, int max);

    List<Car> findAllByLocation(Location location);

    List<Car> findAllByAvailable(boolean available);

    boolean existsByRegistrationNumber(String number);

    List<Car> findAllByAvailableAndLocationId(boolean available, int id);

}