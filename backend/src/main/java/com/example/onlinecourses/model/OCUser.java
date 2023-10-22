package com.example.onlinecourses.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = OCUser.ENTITY_NAME)
@Table(name = OCUser.TABLE_NAME)
public class OCUser extends OCAbstractEntity {
    public static final String ENTITY_NAME = "OCUser";
    public static final String TABLE_NAME = "OCUser";
    public static final String COLUMN_SYSID_NAME = "sysId";
    public static final String COLUMN_USERNAME_NAME = "username";
    public static final String COLUMN_PASSWORD_NAME = "password";
    public static final String COLUMN_EMAIL_NAME = "email";

    @Id
    @Column(name = COLUMN_SYSID_NAME, nullable = false)
    private Long sysId;

    @Column(name = COLUMN_USERNAME_NAME, nullable = false, unique = true)
    private String username;

    @Column(name = COLUMN_PASSWORD_NAME, nullable = false)
    private String password;

    @Column(name = COLUMN_EMAIL_NAME, nullable = false, unique = true)
    private String email;

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }
}