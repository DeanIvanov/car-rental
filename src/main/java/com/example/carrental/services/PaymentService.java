package com.example.carrental.services;

import com.example.carrental.models.Payment;
import org.springframework.http.HttpStatus;

public interface PaymentService {

    void create(int id, Payment payment);

    void update(int id, Payment payment);

    void delete(Payment payment);

    void complete(int id, Payment payment);

    Payment getById(int id);

//    HttpStatus sendRequestApi(Card card, User user, double amount, String description);

}
