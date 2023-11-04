package com.example.onlinecourses.repository;

import com.example.onlinecourses.model.OCUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OCUserRepository extends JpaRepository<OCUser, Long> {
    Optional<OCUser> findByEmail(String email);

}