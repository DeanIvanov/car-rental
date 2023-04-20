package com.example.carrental.repositories;

import com.example.carrental.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User getById(int id);

    List<User> getByEmail(String email);

    boolean existsByEmail(String email);

    List<User> findAll();

    List<User> findAllByEmailLikeOrPhoneLikeOrNameLikeOrSurnameLike(String email, String phone, String name, String surname);

    List<User> findAllByBlocked(boolean blocked);



}
