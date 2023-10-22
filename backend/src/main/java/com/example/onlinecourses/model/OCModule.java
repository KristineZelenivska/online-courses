package com.example.onlinecourses.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = OCModule.ENTITY_NAME)
@Table(name = OCModule.TABLE_NAME)
public class OCModule extends OCAbstractEntity {
    public static final String ENTITY_NAME = "OCModule";
    public static final String TABLE_NAME = "OCModule";
    public static final String COLUMN_SYSID_NAME = "sysId";
    public static final String COLUMN_NAME_NAME = "name";
    public static final String COLUMN_ENDDATE_NAME = "endDate";
    public static final String COLUMN_INFOTYPE_NAME = "infoType";
    public static final String COLUMN_DESCRIPTION_NAME = "description";
    public static final String COLUMN_FILE_NAME = "file";

    @Id
    @Column(name = COLUMN_SYSID_NAME, nullable = false)
    private Long sysId;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "course_sys_Id", nullable = false)
    private OCCourse course;

    @Column(name = COLUMN_NAME_NAME, nullable = false)
    private String name;

    @Column(name = COLUMN_ENDDATE_NAME)
    private Date endDate;

    @Column(name = COLUMN_INFOTYPE_NAME)
    private String infoType;

    @Lob
    @Column(name = COLUMN_DESCRIPTION_NAME)
    private String description;

    @Column(name = COLUMN_FILE_NAME)
    private Boolean file;

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }
}