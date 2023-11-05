package com.example.onlinecourses.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class UserException extends Exception {
    public UserException(String message) {
        super(message);
    }
}
