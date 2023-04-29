package com.example.carrental.services;

import com.example.carrental.models.Car;
import com.example.carrental.models.Order;
import com.example.carrental.repositories.OrderRepository;
import com.example.carrental.repositories.UserRepository;
import com.example.carrental.services.impl.OrderServiceImpl;
import com.example.carrental.services.impl.UserServiceImpl;
import org.aspectj.weaver.ast.Or;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTests {

    @Mock
    OrderRepository orderRepository;

    @Mock
    UserRepository userRepository;

    @InjectMocks
    OrderServiceImpl orderService;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    public void deleteOrderTest(){

        Order order = new Order();
        orderService.delete(order);

        verify(orderRepository,times(1)).delete(order);


    }
}
