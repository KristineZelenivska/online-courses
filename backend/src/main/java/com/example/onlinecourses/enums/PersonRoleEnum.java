package com.example.onlinecourses.enums;

import lombok.Getter;

@Getter
public enum PersonRoleEnum {
    ADMIN("ADMIN"),
    USER("USER"),
    TEACHER("TEACHER");

    private final String roleName;

    PersonRoleEnum(String roleName) {
        this.roleName = roleName;
    }
}
