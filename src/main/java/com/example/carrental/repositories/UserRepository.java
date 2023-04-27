package com.example.carrental.repositories;

import com.example.carrental.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User getById(int id);

    User getByUsername(String username);

    boolean existsByUsername(String username);

    List<User> findAll();

    List<User> findAllByUsernameLikeOrPhoneLikeOrNameLikeOrSurnameLike(String username, String phone, String name, String surname);

    List<User> findAllByEnabled(boolean enabled);



}
