package com.example.onlinecourses.dto;

import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link com.example.onlinecourses.model.OCCourse}
 */

@Value
public class OCCourseDto implements Serializable {
    Long sysId;
    String name;
    Boolean openCourse;
    String description;
    BigDecimal price;
    String teacherName;
    String courseCategoryName;
}