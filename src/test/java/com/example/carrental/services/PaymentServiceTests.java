package com.example.carrental.services;


import com.example.carrental.models.Car;
import com.example.carrental.models.Location;
import com.example.carrental.models.Payment;
import com.example.carrental.repositories.PaymentRepository;
import com.example.carrental.services.impl.PaymentServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

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

    @Test
    public void createPaymentTest(){

        Payment payment = new Payment();

        paymentService.create(payment);

        verify(paymentRepository,times(1)).save(payment);

    }

    @Test
    public void updatePaymentTest(){

        Payment payment = new Payment();
        payment.setPrice(150);
        payment.setDate(LocalDate.of(2023,1,21));
        payment.setCompleted(true);

        when(paymentRepository.getById(payment.getId())).thenReturn(payment);

        paymentService.update(payment.getId(), payment);

        verify(paymentRepository,times(1)).save(payment);

    }

    @Test
    public void getByIdPaymentTest(){

        Payment payment = new Payment();
        payment.setId(5);

        when(paymentRepository.getById(5)).thenReturn(payment);
        Payment retrievedUser = paymentService.getById(5);

        Assert.assertEquals(payment, retrievedUser);
        verify(paymentRepository,times(1)).getById(5);
    }

    @Test
    public void getPaymentTest(){

        Payment payment = new Payment();
        List<Payment> PaymentList = new ArrayList<>();
        PaymentList.add(payment);

        when(paymentRepository.findAll()).thenReturn(PaymentList);
        paymentService.getAll();

        Assert.assertEquals(1, PaymentList.size());
        verify(paymentRepository,times(1)).findAll();
    }

    @Test
    public void SetCompleteTest(){
        Payment payment = new Payment();
        payment.setCompleted(false);

        paymentService.complete(payment);
        verify(paymentRepository,times(1)).save(payment);
    }
}
