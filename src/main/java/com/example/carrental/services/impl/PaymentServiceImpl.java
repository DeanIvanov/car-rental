package com.example.carrental.services.impl;

import com.example.carrental.models.Payment;
import com.example.carrental.repositories.PaymentRepository;
import com.example.carrental.services.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void create(Payment payment) {
        paymentRepository.save(payment);
    }

    @Override
    public void update(int id, Payment payment) {
        Payment newPayment = paymentRepository.getById(id).get(0);
        newPayment.setPrice(payment.getPrice());
        paymentRepository.save(newPayment);
    }

    @Override
    public void delete(Payment payment) {
        paymentRepository.delete(payment);
    }

    @Override
    public void complete(Payment payment) {
        if(!payment.isCompleted()){
            payment.setCompleted(true);
            paymentRepository.save(payment);
        }
    }

    @Override
    public Payment getById(int id) {
        return paymentRepository.getById(id).get(0);
    }

    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }


//    @Override
//    public HttpStatus sendRequestApi(Card card, User user, double amount, String description){
//        final String url = "http://localhost:8081/payment";
//
//        if(amount < 0 ){
//            throw new IllegalArgumentException("Money should be bigger than 0!");
//        }
//        Transaction transaction = new Transaction();
//        transaction.setAmount(amount);
//        transaction.setCurrency("BGN");
//        transaction.setReceiver(user);
//        transaction.setSender(user);
//        transaction.setCard(card);
//        transaction.setVerified(true);
//        transaction.setDescription(description);
//        transaction.setDate(LocalDateTime.now());
//        transactionRepository.save(transaction);
//        RestTemplate restTemplate = new RestTemplate();
//
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("x-api-key", "1");
//        httpHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
//
//        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//
//        HttpEntity<Transaction> request = new HttpEntity<>(transaction,httpHeaders);
//        return  restTemplate.exchange(url, HttpMethod.POST,request,Transaction.class).getStatusCode();
//    }

}
