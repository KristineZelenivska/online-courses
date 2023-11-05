package com.example.onlinecourses.controller;

import com.example.onlinecourses.dto.UserDTO;
import com.example.onlinecourses.model.OCPerson;
import com.example.onlinecourses.security.dto.AuthRequest;
import com.example.onlinecourses.security.jwt.JwtService;
import com.example.onlinecourses.service.OCUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = { "http://localhost:3000"})
public class OCUserController {
    @Autowired
    private OCUserService service;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        OCPerson person = service.login(authRequest);
        if (person != null) {
            return ResponseEntity.ok(person);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Username or password");
    }

    @PostMapping("/addNewUser")
    public String addNewUser(@RequestBody UserDTO user) {
        return service.addUser(user);
    }

    @GetMapping("/user/userProfile/")
    public ResponseEntity<?> userProfile(@RequestParam String email) {
        OCPerson person = service.getUserProfile(email);
        if (person != null) {
            return ResponseEntity.ok(person);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User profile with this email not found!");
    }

/*    @GetMapping("/admin/adminProfile")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String adminProfile() {
        return "Welcome to Admin Profile";
    }

    @PostMapping("/generateToken")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }*/
}
