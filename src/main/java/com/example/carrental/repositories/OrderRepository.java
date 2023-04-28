package com.example.carrental.repositories;

import com.example.carrental.models.Order;
import com.example.carrental.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    Order getById(int id);

    List<Order> findAll();

    List<Order> findAllByCompleted(boolean completed);

    List<Order> findAllByStartDateBetweenOrEndDateBetween(LocalDate startMin, LocalDate startMax, LocalDate endMin, LocalDate endMax);

    List<Order> findAllByUser(User user);

    List<Order> findAllByUserId(int id);

    List<Order> findAllByCarId(int id);

    boolean existsByUserIdAndActiveAndCompleted(int id, boolean active, boolean completed);

    Order findTopByOrderByIdDesc();

    Optional<Order> findOrderByActiveAndCompletedAndUserId(boolean active, boolean completed, int id);

}