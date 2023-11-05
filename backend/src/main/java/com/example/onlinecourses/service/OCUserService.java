package com.example.onlinecourses.service;

import com.example.onlinecourses.dto.UserDTO;
import com.example.onlinecourses.model.OCPerson;
import com.example.onlinecourses.model.OCUser;
import com.example.onlinecourses.repository.OCPersonRepository;
import com.example.onlinecourses.repository.OCUserRepository;
import com.example.onlinecourses.security.OCUserDetails;
import com.example.onlinecourses.security.dto.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OCUserService implements UserDetailsService {
    @Autowired
    OCUserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    OCPersonRepository personRepository;
    @Autowired
    PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<OCUser> userDetail = userRepository.findByEmail(email);
        return userDetail.map(OCUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User with " + email + " not found!"));
    }

    public OCPerson getUserProfile(String email){
        List<OCPerson> personList = personRepository.findByUser_Email(email);
        if (!personList.isEmpty()) {
            return personList.get(0);
        }
        return null;
    }

    public OCPerson login(AuthRequest authRequest) {
        String email = authRequest.getEmail();
        String password = authRequest.getPassword();
        Optional<OCUser> user = userRepository.findByEmail(email);
        if (user.isPresent() && encoder.matches(password, user.get().getPassword())) {
            List<OCPerson> personList = personRepository.findByUser_Email(email);
            if (!personList.isEmpty()) {
                return personList.get(0);
            }
        }
        return null;
    }

    public String addUser(UserDTO user) {
        try {
            validateUser(user);
        } catch (Exception e) {
            return e.getMessage();
        }

        OCUser ocUser = new OCUser();
        ocUser.setPassword(passwordEncoder.encode(user.getPassword()));
        ocUser.setEmail(user.getEmail());
        userRepository.save(ocUser);

        OCPerson ocPerson = new OCPerson();
        ocPerson.setUser(ocUser);
        ocPerson.setName(user.getName());
        ocPerson.setSurname(user.getSurname());

        personRepository.save(ocPerson);

        return "User Added Successfully";
    }

    private void validateUser(UserDTO user) throws Exception {
        if (user == null) {
            throw new Exception("User is not provided");
        }
        if (user.getName() == null || user.getPassword() == null || user.getEmail() == null) {
            throw new Exception("User attributes not provided!");
        }
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new Exception("User with this user name registered!");
        }
    }
}
