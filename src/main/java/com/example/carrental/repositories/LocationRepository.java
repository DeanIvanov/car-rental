package com.example.carrental.repositories;

import com.example.carrental.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

    Location getById(int id);

    List<Location> findALl();

    List<Location> findAllByPhoneLikeOrNameLike(String phone, String name);

    boolean existsByName(String name);
}