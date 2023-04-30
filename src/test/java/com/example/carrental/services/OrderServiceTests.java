package com.example.carrental.services;

import com.example.carrental.models.*;
import com.example.carrental.repositories.OrderRepository;
import com.example.carrental.repositories.UserRepository;
import com.example.carrental.services.impl.OrderServiceImpl;
import com.example.carrental.services.impl.UserServiceImpl;
import org.aspectj.weaver.ast.Or;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

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
    public void createOrderTest(){

        Order order = new Order();
        order.setUser(new User());

        orderService.create(1, order);

        verify(orderRepository,times(1)).save(order);

    }
    @Test
    public void updateOrderTest() {

        Order order = new Order();
        Car car = new Car();
        User user = new User();
        Payment payment = new Payment();
        Location location = new Location();
        order.setUser(user);
        order.setCar(car);
        order.setStartDate(LocalDate.of(2023,12,1));
        order.setEndDate(LocalDate.of(2023,12,2));
        order.setLocation(location);
        order.setPrice(150);
        order.setPayment(payment);
        order.setPaymentType(1);
        order.setCompleted(false);
        order.setActive(true);


        when(orderRepository.getById(car.getId())).thenReturn(order);

        orderService.update(car.getId(), order);

        verify(orderRepository, times(1)).save(order);

    }

    @Test
    public void deleteOrderTest(){

        Order order = new Order();
        orderService.delete(order);

        verify(orderRepository,times(1)).delete(order);


    }
    @Test
    public void SetCompleteOrderTest(){
        Order order = new Order();
        order.setCompleted(false);

        orderService.completeOrder(order);
        verify(orderRepository,times(1)).save(order);
    }
    @Test
    public void SetIncompleteOrderTest(){
        Order order = new Order();
        order.setCompleted(true);

        orderService.completeOrder(order);
        verify(orderRepository,times(1)).save(order);
    }

    @Test
    public void getAllOrdersTest(){

        Order order = new Order();
        List<Order> OrderList = new ArrayList<>();
        OrderList.add(order);

        when(orderRepository.findAll()).thenReturn(OrderList);
        orderService.getAll();

        Assert.assertEquals(1, OrderList.size());
        verify(orderRepository,times(1)).findAll();

    }

    @Test
    public void getByIdOrderTest(){

        Order order = new Order();
        order.setId(5);

        when(orderRepository.getById(5)).thenReturn(order);
        Order retrievedUser = orderService.getById(5);

        Assert.assertEquals(order, retrievedUser);
        verify(orderRepository,times(1)).getById(5);

    }

    @Test
    public void getByUserOrderTest(){

        Order order = new Order();
        User user = new User();
        order.setUser(user);
        List<Order> OrderList = new ArrayList<>();
        OrderList.add(order);

        when(orderRepository.findAllByUser(user)).thenReturn(OrderList);
        orderService.getByUser(user);


        Assert.assertEquals(1, OrderList.size());
        verify(orderRepository,times(1)).findAllByUser(user);

    }

    @Test
    public void getByUserIdOrderTest(){

        Order order = new Order();
        User user = new User();
        order.setUser(user);
        List<Order> OrderList = new ArrayList<>();
        OrderList.add(order);

        when(orderRepository.findAllByUserId(user.getId())).thenReturn(OrderList);
        orderService.getByUserId(user.getId());


        Assert.assertEquals(1, OrderList.size());
        verify(orderRepository,times(1)).findAllByUserId(user.getId());

    }
    @Test
    public void getCarIdOrderTest(){

        Order order = new Order();
        User user = new User();
        Car car = new Car();
        order.setUser(user);
        order.setCar(car);
        List<Order> OrderList = new ArrayList<>();
        OrderList.add(order);

        when(orderRepository.findAllByCarId(car.getId())).thenReturn(OrderList);
        orderService.getByCarId(car.getId());


        Assert.assertEquals(1, OrderList.size());
        verify(orderRepository,times(1)).findAllByCarId(car.getId());

    }
    @Test
    public void getActiveOrderTest(){

        Order order = new Order();
        order.setCompleted(false);
        order.setActive(true);
        List<Order> OrderList = new ArrayList<>();
        OrderList.add(order);

        when(orderRepository.findAllByCompleted(false)).thenReturn(OrderList);
        orderService.getActive();

        Assert.assertEquals(1, OrderList.size());
        verify(orderRepository,times(1)).findAllByCompleted(false);

    }
    @Test
    public void getByDateOrderTest(){

        Order order = new Order();
        order.setStartDate(LocalDate.of(2023,12,1));
        order.setEndDate(LocalDate.of(2023,12,2));
        List<Order> OrderList = new ArrayList<>();
        OrderList.add(order);

        when(orderRepository.findAllByStartDateBetweenOrEndDateBetween(LocalDate.of(2023,12,1),(LocalDate.of(2023,12,2)),(LocalDate.of(2023,12,1)),(LocalDate.of(2023,12,2)))).thenReturn(OrderList);
        orderService.getByDate((LocalDate.of(2023,12,1)),(LocalDate.of(2023,12,2)));


        Assert.assertEquals(1, OrderList.size());
        verify(orderRepository,times(1)).findAllByStartDateBetweenOrEndDateBetween(LocalDate.of(2023,12,1),(LocalDate.of(2023,12,2)),(LocalDate.of(2023,12,1)),(LocalDate.of(2023,12,2)));

    }

    @Test
    public void getLatestOrderTest(){

        Order order = new Order();
        order.setId(5);

        when(orderRepository.findTopByOrderByIdDesc()).thenReturn(order);
        Order retrievedUser = orderService.getLatestOrder();

        Assert.assertEquals(order, retrievedUser);
        verify(orderRepository,times(1)).findTopByOrderByIdDesc();

    }
//    @Test
//    public void calculateTotalPriceTest(){
//
//        Order order = new Order();
//        order.setStartDate(LocalDate.of(2023,12,1));
//        order.setEndDate(LocalDate.of(2023,12,2));
//        Car car = new Car();
//        car.setPrice(5);
//
//        when(orderRepository.findAll()).thenReturn(order);
//        Order retrievedUser = orderService.getLatestOrder();
//
//        Assert.assertEquals(order, retrievedUser);
//        verify(orderRepository,times(1)).findTopByOrderByIdDesc();
//
//    }
//    @Test
//    public void getActiveForUserOrderTest(){
//
//        Order order = new Order();
//        User user = new User();
//        order.setUser(user);
//        order.setActive(true);
//        order.setCompleted(false);
//        List<Order> OrderList = new ArrayList<>();
//        OrderList.add(order);
//
//        when(orderRepository.findOrderByActiveAndCompletedAndUserId(true,false, user.getId())).thenReturn(order);
//        orderService.getActive();
//
//
//        Assert.assertEquals(1, OrderList.size());
//        verify(orderRepository,times(1)).findOrderByActiveAndCompletedAndUserId(true,false, user.getId());
//
//    }
}
