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
@Entity(name = OCCertificate.ENTITY_NAME)
@Table(name = OCCertificate.TABLE_NAME)
public class OCCertificate extends OCAbstractEntity {
    public static final String ENTITY_NAME = "OCCertificate";
    public static final String TABLE_NAME = "OCCertificate";
    public static final String COLUMN_SYSID_NAME = "sysId";
    public static final String COLUMN_ISSUER_NAME = "issuer";
    public static final String COLUMN_ISSUEDATE_NAME = "issueDate";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = COLUMN_SYSID_NAME, nullable = false)
    private Long sysId;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "person_sysId", nullable = false)
    private OCPerson person;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "course_sys_Id", nullable = false)
    private OCCourse course;

    @Column(name = COLUMN_ISSUER_NAME, nullable = false)
    private String issuer;

    @Column(name = COLUMN_ISSUEDATE_NAME, nullable = false)
    private Date issueDate;

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }
}