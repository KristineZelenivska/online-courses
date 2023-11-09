package com.example.onlinecourses.controller;

import com.example.onlinecourses.model.OCPerson;
import com.example.onlinecourses.service.OCUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = {"http://localhost:3000"})
public class OCPersonController {
    @Autowired
    private OCUserService service;
    @GetMapping("/userProfile/")
    public ResponseEntity<?> userProfile(@RequestParam String email) {
        OCPerson person = service.getUserProfile(email);
        if (person != null) {
            return ResponseEntity.ok(person);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User profile with this email not found!");
    }
}
