package com.example.onlinecourses.repository;

import com.example.onlinecourses.model.OCPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OCPersonRepository extends JpaRepository<OCPerson, Long> {
    List<OCPerson> findByUser_Email(String email);
}