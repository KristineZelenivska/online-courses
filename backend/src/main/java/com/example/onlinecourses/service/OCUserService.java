package com.example.onlinecourses.service;

import com.example.onlinecourses.model.OCUser;
import com.example.onlinecourses.repository.OCUserRepository;
import com.example.onlinecourses.security.OCUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OCUserService implements UserDetailsService {
    @Autowired
    OCUserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<OCUser> userDetail = userRepository.findByUsername(username);
        return userDetail.map(OCUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
    }

    public String addUser(OCUser ocUser) {
        try {
            validateUser(ocUser);
        } catch (Exception e) {
            return e.getMessage();
        }
        ocUser.setPassword(passwordEncoder.encode(ocUser.getPassword()));
        userRepository.save(ocUser);
        return "User Added Successfully";
    }

    private void validateUser(OCUser user) throws Exception {
        if (user == null) {
            throw new Exception("User is null");
        }
        if (user.getUsername() == null || user.getPassword() == null || user.getEmail() == null) {
            throw new Exception("User attributes not provided!");
        }
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new Exception("User with this user name registered!");
        }
    }
}
