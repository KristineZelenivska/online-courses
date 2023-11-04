package com.example.onlinecourses.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = COLUMN_SYSID_NAME, nullable = false)
    private Long sysId;

    @Column(name = COLUMN_PASSWORD_NAME, nullable = false)
    private String password;

    @Column(name = COLUMN_EMAIL_NAME, nullable = false, unique = true)
    private String email;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OCUserGroups> userGroups = new ArrayList<>();

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }
}