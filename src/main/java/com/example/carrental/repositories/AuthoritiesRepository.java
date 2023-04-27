package com.example.carrental.repositories;

import com.example.carrental.models.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities, Integer> {

    Authorities getByUsername(String username);

}
