package com.example.onlinecourses.controller;

import com.example.onlinecourses.dto.OCCourseDto;
import com.example.onlinecourses.service.OCCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@CrossOrigin(origins = {"http://localhost:3000"})
public class OCCoursesController {


    @Autowired
    private OCCourseService courseService;

    @PostMapping("/myCourses")
    public ResponseEntity<?> login(@RequestParam String email) {
        try {
            List<OCCourseDto> courseDto = courseService.getPersonCourses(email);
            return ResponseEntity.ok(courseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
