package com.example.onlinecourses.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = OCAttachment.ENTITY_NAME)
@Table(name = OCAttachment.TABLE_NAME)
public class OCAttachment extends OCAbstractEntity {
    public static final String ENTITY_NAME = "OCAttachment";
    public static final String TABLE_NAME = "OCAttachment";
    public static final String COLUMN_SYSID_NAME = "sysId";
    public static final String COLUMN_SOURCE_TABLE_NAME = "sourceTable";
    public static final String COLUMN_SOURCE_TABLE_SYSID_NAME = "sourceTableSysId";
    public static final String COLUMN_ATTACHMENT_NAME = "attachment";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = COLUMN_SYSID_NAME, nullable = false)
    private Long sysId;

    @Column(name = COLUMN_SOURCE_TABLE_NAME)
    private String sourceTable;

    @Column(name = COLUMN_SOURCE_TABLE_SYSID_NAME)
    private Long sourceTableSysId;

    @Lob
    @Column(name = COLUMN_ATTACHMENT_NAME)
    private Blob attachment;

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }
}