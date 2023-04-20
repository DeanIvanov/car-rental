package com.example.carrental.repositories;

import com.example.carrental.models.Car;
import com.example.carrental.models.Order;
import com.example.carrental.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    Order getById(int id);

    List<Order> findAll();

    List<Order> findAllByCompleted(boolean completed);

    List<Order> findAllByStartDateBetweenOrEndDateBetween(Date startMin, Date startMax, Date endMin, Date endMax);

    List<Order> findAllByUser(User user);

    List<Order> findAllByCar(Car car);

//    List<Order>

}