package com.example.onlinecourses.listeners;

import com.example.onlinecourses.enums.PersonRoleEnum;
import com.example.onlinecourses.model.OCPerson;
import com.example.onlinecourses.model.OCPersonRole;
import com.example.onlinecourses.repository.OCPersonRoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class PersonPreInsertListener implements PreInsertEventListener {
    @Autowired
    OCPersonRoleRepository personRoleRepository;
    @Override
    public boolean onPreInsert(PreInsertEvent preInsertEvent) {
        Object entity = preInsertEvent.getEntity();
        if (entity instanceof OCPerson) {
            OCPerson ocPerson = (com.example.onlinecourses.model.OCPerson) entity;
            if(ocPerson.getPersonRole() == null) {
                Optional<OCPersonRole> userRoleOptional = personRoleRepository.findByName(PersonRoleEnum.USER.getRoleName());
                ocPerson.setPersonRole(userRoleOptional.get());
                return true;
            }
        }
        return false;
    }
}