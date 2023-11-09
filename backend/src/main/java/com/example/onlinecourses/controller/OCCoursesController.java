package com.example.onlinecourses.controller;

import com.example.onlinecourses.dto.OCCourseDto;
import com.example.onlinecourses.dto.OCFeedbackDto;
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

    @GetMapping("/myCourses")
    public ResponseEntity<?> getUserCourses(@RequestParam String email) {
        try {
            List<OCCourseDto> courseDto = courseService.getPersonCoursesDTO(email);
            return ResponseEntity.ok(courseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @GetMapping("/course")
    public ResponseEntity<?> openCourse(@RequestParam Long id) {
        try {
            OCCourseDto courseDto = courseService.getCourse(id);
            return ResponseEntity.ok(courseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/course/search")
    public ResponseEntity<?> search(@RequestParam String searchText, @RequestParam String teacherName) {
        try {
            OCCourseDto courseDto = courseService.getCourse(1L);
            return ResponseEntity.ok(courseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/course/reviews")
    public ResponseEntity<?> getCourseReviews(@RequestParam Long sysId) {
        try {
            List<OCFeedbackDto> feedbacks = courseService.getCourseFeedback(sysId);
            return ResponseEntity.ok(feedbacks);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
