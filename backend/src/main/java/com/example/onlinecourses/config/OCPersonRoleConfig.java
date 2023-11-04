package com.example.onlinecourses.config;

import com.example.onlinecourses.enums.PersonRoleEnum;
import com.example.onlinecourses.model.OCPersonRole;
import com.example.onlinecourses.repository.OCPersonRoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class OCPersonRoleConfig implements CommandLineRunner {

    private final OCPersonRoleRepository personRoleRepository;

    public OCPersonRoleConfig(OCPersonRoleRepository personRoleRepository) {
        this.personRoleRepository = personRoleRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        initializePersonRoles();
    }

    private void initializePersonRoles() {
        for (PersonRoleEnum role : PersonRoleEnum.values()) {
            createPersonRole(role.getRoleName());
        }
    }

    private void createPersonRole(String roleName) {
        if (personRoleRepository.findByName(roleName).isEmpty()) {
            OCPersonRole personRole = new OCPersonRole();
            personRole.setName(roleName);
            personRoleRepository.save(personRole);
        }
    }
}
