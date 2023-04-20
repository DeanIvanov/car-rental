package com.example.carrental.repositories;

import com.example.carrental.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    Payment getById(int id);

    List<Payment> findAll();

}
