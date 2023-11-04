package com.example.onlinecourses.listeners;

import com.example.onlinecourses.enums.PersonRoleEnum;
import com.example.onlinecourses.model.OCPerson;
import jakarta.persistence.PrePersist;

public class OCPersonEventListener {

    @PrePersist
    public void prePersist(Object o) {
        if (o instanceof OCPerson ocPerson) {
            if (ocPerson.getPersonRole() == null) {
                ocPerson.setPersonRole(PersonRoleEnum.USER.getRoleName());
            }
        }
    }
}