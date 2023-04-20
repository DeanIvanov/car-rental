package com.example.carrental.services.impl;

import com.example.carrental.models.Order;
import com.example.carrental.models.User;
import com.example.carrental.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {




    @Override
    public void create(int id, User user) {

    }

    @Override
    public void update(int id, User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void block(User user) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public List<User> getByEmail(String email) {
        return null;
    }

    @Override
    public List<User> getCurrentUser() {
        return null;
    }

    @Override
    public List<User> getUser(String search) {
        return null;
    }

    @Override
    public List<Order> getOrder(User user) {
        return null;
    }

}
