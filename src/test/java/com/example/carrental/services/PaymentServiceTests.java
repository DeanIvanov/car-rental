package com.example.carrental.services;


import com.example.carrental.models.Car;
import com.example.carrental.models.Payment;
import com.example.carrental.repositories.PaymentRepository;
import com.example.carrental.services.impl.PaymentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceTests {

    @Mock
    PaymentRepository paymentRepository;

    @InjectMocks
    PaymentServiceImpl paymentService;



    @Test
    public void deletePaymentTest(){

        Payment payment = new Payment();
        paymentService.delete(payment);

        verify(paymentRepository,times(1)).delete(payment);


    }




}
