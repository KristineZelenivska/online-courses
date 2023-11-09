package com.example.onlinecourses.controller;

import com.example.onlinecourses.dto.UserDTO;
import com.example.onlinecourses.exceptions.UserException;
import com.example.onlinecourses.model.OCPerson;
import com.example.onlinecourses.security.OCUserDetails;
import com.example.onlinecourses.security.dto.AuthRequest;
import com.example.onlinecourses.security.dto.AuthResponse;
import com.example.onlinecourses.security.jwt.JwtService;
import com.example.onlinecourses.service.OCUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = {"http://localhost:3000"})
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
    public ResponseEntity<?> addNewUser(@RequestBody UserDTO user) {
        try {
            return ResponseEntity.ok(service.addUser(user));
        } catch (UserException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage() + " , please contact administrator!");
        }
    }


    @GetMapping("/admin/adminProfile")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String adminProfile() {
        return "Welcome to Admin Profile";
    }

    @PostMapping("/generateToken")
    public ResponseEntity<?> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        OCUserDetails user = service.loadUserByUsername(authRequest.getEmail());
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            AuthResponse res = new AuthResponse(jwtService.generateToken(authRequest.getEmail()), user.getUser().getEmail(), service.getUserProfile(authRequest.getEmail()).getPersonRole());
            return ResponseEntity.ok(res);
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }
}
