package com.example.carrental.services;

import com.example.carrental.exceptions.InvalidUserInputException;
import com.example.carrental.models.Order;
import com.example.carrental.models.User;
import com.example.carrental.repositories.UserRepository;
import com.example.carrental.services.impl.UserServiceImpl;
import org.aspectj.weaver.ast.Or;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;

import static org.mockito.Mockito.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public void updateUserTest(){

        User user = new User();
        user.setName("test");
        user.setSurname("testov");
        user.setUsername("tester@gmail.com");
        user.setPassword("12345678");
        user.setPhone("0123456789");
        user.setAddress("Test Headquarters");
        user.setDob(LocalDate.now());
        user.setLicenseNumber("12345678");
        user.setLicenseCategory("B1");
        user.setEnabled(true);

        when(userRepository.getById(user.getId())).thenReturn(user);

        userService.update(user.getId(), user);

        verify(userRepository,times(1)).save(user);

    }

    @Test(expected = InvalidUserInputException.class)
    public void updateUserShouldThrowException_whenUserNameTooShort(){

        User user = new User();
        user.setName("t");
        user.setSurname("testov");
        user.setUsername("tester@gmail.com");
        user.setPassword("12345678");
        user.setPhone("0123456789");
        user.setAddress("Test Headquarters");
        user.setDob(LocalDate.now());
        user.setLicenseNumber("12345678");
        user.setLicenseCategory("B1");
        user.setEnabled(true);

        when(userRepository.getById(user.getId())).thenReturn(user);

        userService.update(user.getId(), user);

        verify(userRepository,times(1)).save(user);

    }

    @Test(expected = InvalidUserInputException.class)
    public void updateUserShouldThrowException_whenUserNameTooLong(){

        User user = new User();
        user.setName("test12345678901234567890");
        user.setSurname("testov");
        user.setUsername("tester@gmail.com");
        user.setPassword("12345678");
        user.setPhone("0123456789");
        user.setAddress("Test Headquarters");
        user.setDob(LocalDate.now());
        user.setLicenseNumber("12345678");
        user.setLicenseCategory("B1");
        user.setEnabled(true);

        when(userRepository.getById(user.getId())).thenReturn(user);

        userService.update(user.getId(), user);

        verify(userRepository,times(1)).save(user);

    }

    @Test(expected = InvalidUserInputException.class)
    public void updateUserShouldThrowException_whenUserSurNameTooShort(){

        User user = new User();
        user.setName("test");
        user.setSurname("t");
        user.setUsername("tester@gmail.com");
        user.setPassword("12345678");
        user.setPhone("0123456789");
        user.setAddress("Test Headquarters");
        user.setDob(LocalDate.now());
        user.setLicenseNumber("12345678");
        user.setLicenseCategory("B1");
        user.setEnabled(true);

        when(userRepository.getById(user.getId())).thenReturn(user);

        userService.update(user.getId(), user);

        verify(userRepository,times(1)).save(user);

    }

    @Test(expected = InvalidUserInputException.class)
    public void updateUserShouldThrowException_whenUserSurNameTooLong(){

        User user = new User();
        user.setName("test");
        user.setSurname("testov12345678901234567890");
        user.setUsername("tester@gmail.com");
        user.setPassword("12345678");
        user.setPhone("0123456789");
        user.setAddress("Test Headquarters");
        user.setDob(LocalDate.now());
        user.setLicenseNumber("12345678");
        user.setLicenseCategory("B1");
        user.setEnabled(true);

        when(userRepository.getById(user.getId())).thenReturn(user);

        userService.update(user.getId(), user);

        verify(userRepository,times(1)).save(user);

    }

    @Test(expected = InvalidUserInputException.class)
    public void updateUserShouldThrowException_whenUserAddressTooShort(){

        User user = new User();
        user.setName("test");
        user.setSurname("testov");
        user.setUsername("tester@gmail.com");
        user.setPassword("12345678");
        user.setPhone("0123456789");
        user.setAddress("T");
        user.setDob(LocalDate.now());
        user.setLicenseNumber("12345678");
        user.setLicenseCategory("B1");
        user.setEnabled(true);

        when(userRepository.getById(user.getId())).thenReturn(user);

        userService.update(user.getId(), user);

        verify(userRepository,times(1)).save(user);

    }

    @Test(expected = InvalidUserInputException.class)
    public void updateUserShouldThrowException_whenUserAddressTooLong(){

        User user = new User();
        user.setName("test");
        user.setSurname("testov");
        user.setUsername("tester@gmail.com");
        user.setPassword("12345678");
        user.setPhone("0123456789");
        user.setAddress("Test HeadquartersTest HeadquartersTest HeadquartersTest HeadquartersTest HeadquartersTest HeadquartersTest HeadquartersTest HeadquartersTest HeadquartersTest HeadquartersTest HeadquartersTest HeadquartersTest HeadquartersTest HeadquartersTest HeadquartersTest HeadquartersTest HeadquartersTest HeadquartersTest HeadquartersTest HeadquartersTest HeadquartersTest HeadquartersTest HeadquartersTest HeadquartersTest Headquarters");
        user.setDob(LocalDate.now());
        user.setLicenseNumber("12345678");
        user.setLicenseCategory("B1");
        user.setEnabled(true);

        when(userRepository.getById(user.getId())).thenReturn(user);

        userService.update(user.getId(), user);

        verify(userRepository,times(1)).save(user);

    }

    @Test
    public void deleteUserTest(){

        User user = new User();

        userService.delete(user);

        verify(userRepository,times(1)).delete(user);

    }

    @Test
    public void enableUserTest(){

        User user = new User();
        user.setEnabled(false);

        userService.enable(user);

        verify(userRepository,times(1)).save(user);

    }

    @Test
    public void disableUserTest(){

        User user = new User();
        user.setEnabled(true);

        userService.enable(user);

        verify(userRepository,times(1)).save(user);

    }

    @Test
    public void getAllTest(){

        User user = new User();
        List<User> userList = new ArrayList<>();
        userList.add(user);

        when(userRepository.findAll()).thenReturn(userList);
        userService.getAll();

        Assert.assertEquals(1, userList.size());
        verify(userRepository,times(1)).findAll();

    }

    @Test
    public void getByUsernameTest(){

        User user = new User();
        user.setUsername("testthisuser@gmail.com");

        when(userRepository.getByUsername("testthisuser@gmail.com")).thenReturn(user);
        User retrievedUser = userService.getByUsername("testthisuser@gmail.com");

        Assert.assertEquals(user, retrievedUser);
        verify(userRepository,times(1)).getByUsername("testthisuser@gmail.com");

    }

    @Test
    public void getByIdTest(){

        User user = new User();
        user.setId(5);

        when(userRepository.getById(5)).thenReturn(user);
        User retrievedUser = userService.getById(5);

        Assert.assertEquals(user, retrievedUser);
        verify(userRepository,times(1)).getById(5);

    }

    @Test
    public void getUserTest(){

        User user = new User();
        user.setName("test");
        user.setSurname("testov");
        user.setPhone("0123456789");
        user.setUsername("testuser@gmail.com");
        List<User> userList = new ArrayList<>();
        userList.add(user);


        when(userRepository.findAllByUsernameLikeOrPhoneLikeOrNameLikeOrSurnameLike("test", "test", "test", "test")).thenReturn(userList);
        userService.getUser("test");

        Assert.assertEquals(1, userList.size());
        verify(userRepository,times(1)).findAllByUsernameLikeOrPhoneLikeOrNameLikeOrSurnameLike("test","test","test","test");
    }

    @Test
    public void getUserOrderTest(){

        User user = new User();
        Order order = new Order();
        List<Order> orderList = new ArrayList<>();
        orderList.add(order);

        when(userRepository.getById(user.getId())).thenReturn(user);
        userService.getById(user.getId());
        userService.getOrder(user);

        Assert.assertEquals(1, orderList.size());

        verify(userRepository,times(1)).getById(user.getId());



    }






}