package com.example.carrental.services;

import com.example.carrental.models.Payment;

import java.util.List;

public interface PaymentService {

    void create(Payment payment);

    void update(int id, Payment payment);

    void delete(Payment payment);

    void complete(Payment payment);

    Payment getById(int id);

    List<Payment> getAll();

//    HttpStatus sendRequestApi(Card card, User user, double amount, String description);

}
