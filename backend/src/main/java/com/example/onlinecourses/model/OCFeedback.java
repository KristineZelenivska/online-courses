package com.example.onlinecourses.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = OCFeedback.ENTITY_NAME)
public class OCFeedback extends OCComment {
    public static final String ENTITY_NAME = "OCFeedback";
    public static final String COLUMN_RATING_NAME = "rating";

    @Column(name = COLUMN_RATING_NAME, precision = 10, scale = 2)
    private BigDecimal rating;
    @Override
    public Long getSysId() {
        return super.getSysId();
    }
}