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
@Entity(name = OCCourseTest.ENTITY_NAME)
@Table(name = OCCourseTest.TABLE_NAME)
public class OCCourseTest extends OCAbstractEntity {
    public static final String ENTITY_NAME = "OCCourseTest";
    public static final String TABLE_NAME = "OCCourseTest";
    public static final String COLUMN_SYSID_NAME = "sysId";
    public static final String COLUMN_NAME_NAME = "name";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = COLUMN_SYSID_NAME, nullable = false)
    private Long sysId;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "module_sysId", nullable = false)
    private OCModule module;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_sysId")
    private OCCourse course;

    @Column(name = COLUMN_NAME_NAME)
    private String name;

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

}