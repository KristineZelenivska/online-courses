package com.example.onlinecourses.repository;

import com.example.onlinecourses.model.OCPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OCPersonRepository extends JpaRepository<OCPerson, Long> {
    
}