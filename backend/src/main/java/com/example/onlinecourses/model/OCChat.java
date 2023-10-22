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
@Entity(name = OCChat.ENTITY_NAME)
@Table(name = OCChat.TABLE_NAME)
public class OCChat extends OCAbstractEntity {
    public static final String ENTITY_NAME = "OCChat";
    public static final String TABLE_NAME = "OCChat";
    public static final String COLUMN_SYSID_NAME = "sysId";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = COLUMN_SYSID_NAME, nullable = false)
    private Long sysId;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "creatorPerson_sysId", nullable = false)
    private OCPerson creatorPerson;

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }
}