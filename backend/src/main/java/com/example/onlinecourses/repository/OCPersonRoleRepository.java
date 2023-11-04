package com.example.onlinecourses.repository;

import com.example.onlinecourses.model.OCPersonRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OCPersonRoleRepository extends JpaRepository<OCPersonRole, Long> {
    Optional<OCPersonRole> findByName(String name);

}