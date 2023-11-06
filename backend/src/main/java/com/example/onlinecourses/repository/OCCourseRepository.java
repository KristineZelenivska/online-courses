package com.example.onlinecourses.repository;

import com.example.onlinecourses.model.OCCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OCCourseRepository extends JpaRepository<OCCourse, Long> {
}