package com.example.onlinecourses.model;

import com.example.onlinecourses.listeners.OCPersonEventListener;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = OCPerson.ENTITY_NAME)
@Table(name = OCPerson.TABLE_NAME)
@EntityListeners(OCPersonEventListener.class)
public class OCPerson extends OCAbstractEntity {
    public static final String ENTITY_NAME = "OCPerson";
    public static final String TABLE_NAME = "OCPerson";
    public static final String COLUMN_SYSID_NAME = "sysId";
    public static final String COLUMN_NAME_NAME = "name";
    public static final String COLUMN_SURNAME_NAME = "surname";
    public static final String COLUMN_BIRTHDAY_NAME = "birthDay";
    public static final String COLUMN_PERSONROLE_NAME = "person_role";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = COLUMN_SYSID_NAME, nullable = false)
    private Long sysId;

    @Column(name = COLUMN_NAME_NAME, nullable = false)
    private String name;

    @Column(name = COLUMN_SURNAME_NAME, nullable = false)
    private String surname;

    @Column(name = COLUMN_BIRTHDAY_NAME)
    private Date birthDay;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "user_sysId", nullable = false)
    private OCUser user;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OCPersonCourses> personCourses = new ArrayList<>();

    @Column(name = COLUMN_PERSONROLE_NAME, nullable = false)
    private String personRole;

    public String getFullName(){
        return name + " " + surname;
    }
    @Override
    public String getTableName() {
        return TABLE_NAME;
    }
}