package com.example.carrental.services;

import com.example.carrental.models.User;
import com.example.carrental.repositories.UserRepository;
import com.example.carrental.services.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;

import static org.mockito.Mockito.*;
import java.time.LocalDate;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTests {

    @Mock
    UserRepository userRepository;

    @Mock
    UserDetailsManager userDetailsManager;

    @Mock
    PasswordEncoder passwordEncoder;

    @InjectMocks
    UserServiceImpl userService;


    @Test
    public void deleteUserTest(){

        User user = new User();

        userService.delete(user);

        verify(userRepository,times(1)).delete(user);


    }





}
