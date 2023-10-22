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
@Entity(name = OCQuestion.ENTITY_NAME)
@Table(name = OCQuestion.TABLE_NAME)
public class OCQuestion extends OCAbstractEntity {
    public static final String ENTITY_NAME = "OCQuestion";
    public static final String TABLE_NAME = "OCQuestion";
    public static final String COLUMN_SYSID_NAME = "sysId";
    public static final String COLUMN_QUESTION_NAME = "question";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = COLUMN_SYSID_NAME, nullable = false)
    private Long sysId;

    @Lob
    @Column(name = COLUMN_QUESTION_NAME, nullable = false)
    private String question;

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }
}