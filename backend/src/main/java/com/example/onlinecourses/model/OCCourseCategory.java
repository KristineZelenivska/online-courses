package com.example.onlinecourses.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = OCCourseCategory.ENTITY_NAME)
@Table(name = OCCourseCategory.TABLE_NAME)
public class OCCourseCategory {
    public static final String ENTITY_NAME = "OCCourseCategory";
    public static final String TABLE_NAME = "OCCourseCategory";
    public static final String COLUMN_SYSID_NAME = "sysId";
    public static final String COLUMN_NAME_NAME = "name";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = COLUMN_SYSID_NAME, nullable = false)
    private Long sysId;

    @Column(name = COLUMN_NAME_NAME, nullable = false)
    private String name;

}