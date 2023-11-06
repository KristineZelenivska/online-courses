package com.example.onlinecourses.repository;

import com.example.onlinecourses.model.OCCourse;
import com.example.onlinecourses.model.OCPersonCourses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OCPersonCoursesRepository extends JpaRepository<OCPersonCourses, Long> {
    List<OCPersonCourses> findByPerson_User_Email(String email);

    List<OCPersonCourses> findByCourseAndResponsibleTrue(OCCourse course);
}