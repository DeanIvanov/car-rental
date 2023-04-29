package com.example.carrental.services.impl;

import com.example.carrental.exceptions.DuplicateEntityException;
import com.example.carrental.exceptions.InvalidUserInputException;
import com.example.carrental.models.Order;
import com.example.carrental.models.User;
import com.example.carrental.repositories.UserRepository;
import com.example.carrental.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private UserDetailsManager userDetailsManager;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, UserDetailsManager userDetailsManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsManager = userDetailsManager;
    }


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(int id, User user) {
        if(userRepository.existsByUsername(user.getUsername())) {
            throw new DuplicateEntityException(String.format("User with this email %s already exists!",user.getUsername()));
        }

        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_USER");
        org.springframework.security.core.userdetails.User userDetails =
                new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        passwordEncoder.encode(user.getPassword()),
                        authorities);

        userDetailsManager.createUser(userDetails);
        User newUser = userRepository.getByUsername(user.getUsername());

        update(newUser.getId(),user);

//        userRepository.save(user);

    }

    @Override
    public void update(int id, User user) {
        User newUser = userRepository.getById(id);
        newUser.setName(user.getName());
        newUser.setSurname(user.getSurname());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setDob(user.getDob());
        newUser.setPhone(user.getPhone());
        newUser.setAddress(user.getAddress());
        newUser.setLicenseNumber(user.getLicenseNumber());
        newUser.setLicenseCategory(user.getLicenseCategory());
        newUser.setEnabled(true);

        validateUserInput(newUser);
        userRepository.save(newUser);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void enable(User user) {
        if(user.isEnabled()){
            user.setEnabled(true);
        } else {
            user.setEnabled(false);
        }
        userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.getByUsername(username);
    }

    @Override
    public User getById(int id) {
        return userRepository.getById(id);
    }

    @Override
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return getByUsername(authentication.getName());
    }

    @Override
    public List<User> getUser(String search) {
        return userRepository.findAllByUsernameLikeOrPhoneLikeOrNameLikeOrSurnameLike(search, search, search, search);
    }

    @Override
    public List<Order> getOrder(User user) {
        return user.getOrderList();
    }


    private void validateUserInput(User user) {
        if(user.getName() == null || user.getName().length() < 2 || user.getName().length() > 15) {
            throw new InvalidUserInputException("Invalid user first name");
        }
        if(user.getSurname() == null || user.getSurname().length() < 4 || user.getSurname().length() > 20) {
            throw new InvalidUserInputException("Invalid user last name");
        }
        if(user.getAddress() == null || user.getAddress().length() < 10 || user.getAddress().length() > 100) {
            throw new InvalidUserInputException("Invalid user address");
        }
    }
}
