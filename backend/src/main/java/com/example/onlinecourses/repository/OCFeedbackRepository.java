package com.example.onlinecourses.repository;

import com.example.onlinecourses.model.OCFeedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OCFeedbackRepository extends JpaRepository<OCFeedback, Long> {
    List<OCFeedback> findBySourceTableAndSourceTableSysId(String sourceTable, Long sourceTableSysId);
}