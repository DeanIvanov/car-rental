package com.example.carrental.services;

import com.example.carrental.repositories.OrderRepository;
import com.example.carrental.repositories.UserRepository;
import com.example.carrental.services.impl.OrderServiceImpl;
import com.example.carrental.services.impl.UserServiceImpl;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

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


}
