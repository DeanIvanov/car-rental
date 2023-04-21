package com.example.carrental.controllers;

import com.example.carrental.services.PaymentService;
import org.springframework.stereotype.Controller;

@Controller
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }



}
