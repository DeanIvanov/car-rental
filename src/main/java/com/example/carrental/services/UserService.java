package com.example.carrental.services;

import com.example.carrental.models.Order;
import com.example.carrental.models.User;

import java.util.List;

public interface UserService {


    void create(int id, User user);

    void update(int id, User user);

    void delete(User user);

    void block(User user);

    List<User> getAll();

    User getByEmail(String email);

    User getById(int id);

//    User getCurrentUser();

    List<User> getUser(String search);

    List<Order> getOrder(User user);

//    String encodePass(String password);

}
