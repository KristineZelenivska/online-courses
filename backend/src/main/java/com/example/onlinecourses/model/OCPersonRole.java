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
@Entity(name = OCPersonRole.ENTITY_NAME)
@Table(name = OCPersonRole.TABLE_NAME)
public class OCPersonRole extends OCAbstractEntity {
    public static final String ENTITY_NAME = "OCPersonRole";
    public static final String TABLE_NAME = "OCPersonRole";
    public static final String COLUMN_SYSID_NAME = "sysId";
    public static final String COLUMN_NAME_NAME = "name";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = COLUMN_SYSID_NAME, nullable = false)
    private Long sysId;

    @Column(name = COLUMN_NAME_NAME, nullable = false)
    private String name;

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }
}