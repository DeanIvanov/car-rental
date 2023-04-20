package com.example.carrental.repositories;

import com.example.carrental.models.Car;
import com.example.carrental.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {



}