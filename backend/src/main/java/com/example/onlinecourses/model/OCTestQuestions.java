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
@Entity(name = OCTestQuestions.ENTITY_NAME)
@Table(name = OCTestQuestions.TABLE_NAME)
public class OCTestQuestions extends OCAbstractEntity {
    public static final String ENTITY_NAME = "OCTestQuestions";
    public static final String TABLE_NAME = "OCTestQuestions";
    public static final String COLUMN_SYSID_NAME = "sysId";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = COLUMN_SYSID_NAME, nullable = false)
    private Long sysId;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "courseTest_sysId", nullable = false)
    private OCCourseTest courseTest;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_sysId")
    private OCQuestion question;

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }
}