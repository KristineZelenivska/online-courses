package com.example.onlinecourses.dto;

import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * DTO for {@link com.example.onlinecourses.model.OCFeedback}
 */
@Value
public class OCFeedbackDto implements Serializable {
    OCPersonDto person;
    String comment;
    Timestamp creationTime;
    BigDecimal rating;

    /**
     * DTO for {@link com.example.onlinecourses.model.OCPerson}
     */
    @Value
    public static class OCPersonDto implements Serializable {
        Long sysId;
        String name;
        String surname;
        String personRole;
    }
}