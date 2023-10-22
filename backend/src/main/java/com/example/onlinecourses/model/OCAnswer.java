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
@Entity(name = OCAnswer.ENTITY_NAME)
@Table(name = OCAnswer.TABLE_NAME)
public class OCAnswer extends OCAbstractEntity {
    public static final String ENTITY_NAME = "OCAnswer";
    public static final String TABLE_NAME = "OCAnswer";
    public static final String COLUMN_SYSID_NAME = "sysId";
    public static final String COLUMN_ANSWER_NAME = "answer";
    public static final String COLUMN_CORRECT_NAME = "correct";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = COLUMN_SYSID_NAME, nullable = false)
    private Long sysId;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "question_sysId", nullable = false)
    private OCQuestion question;

    @Column(name = COLUMN_ANSWER_NAME, nullable = false)
    private String answer;

    @Column(name = COLUMN_CORRECT_NAME)
    private Boolean correct;

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }
}