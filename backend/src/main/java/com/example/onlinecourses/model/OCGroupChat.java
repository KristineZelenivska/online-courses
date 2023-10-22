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
@Entity(name = OCGroupChat.ENTITY_NAME)
@Table(name = OCGroupChat.TABLE_NAME)
public class OCGroupChat extends OCAbstractEntity {
    public static final String ENTITY_NAME = "OCGroupChat";
    public static final String TABLE_NAME = "OCGroupChat";
    public static final String COLUMN_SYSID_NAME = "sysId";

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_sysId")
    private OCPerson person;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "chat_sysId", nullable = false)
    private OCChat chat;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = COLUMN_SYSID_NAME, nullable = false)
    private Long sysId;

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }
}