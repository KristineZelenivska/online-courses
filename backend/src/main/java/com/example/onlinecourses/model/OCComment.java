package com.example.onlinecourses.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = OCComment.ENTITY_NAME)
@Table(name = OCComment.TABLE_NAME)
public class OCComment extends OCAbstractEntity {
    public static final String ENTITY_NAME = "OCComment";
    public static final String TABLE_NAME = "OCComment";
    public static final String COLUMN_SYSID_NAME = "sysId";
    public static final String COLUMN_COMMENT_NAME = "comment";
    public static final String COLUMN_SOURCE_TABLE_NAME = "sourceTable";
    public static final String COLUMN_SOURCE_TABLE_SYSID_NAME = "sourceTableSysId";
    public static final String COLUMN_CREATIONTIME_NAME = "creationTime";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = COLUMN_SYSID_NAME, nullable = false)
    private Long sysId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_sysId")
    private OCPerson person;

    @Column(name = COLUMN_COMMENT_NAME)
    private String comment;

    @Column(name = COLUMN_SOURCE_TABLE_NAME)
    private String sourceTable;

    @Column(name = COLUMN_SOURCE_TABLE_SYSID_NAME)
    private Long sourceTableSysId;

    @Column(name = COLUMN_CREATIONTIME_NAME, nullable = false)
    private Timestamp creationTime;

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }
}