package com.example.onlinecourses.repository;

import com.example.onlinecourses.model.OCComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OCCommentRepository extends JpaRepository<OCComment, Long> {
    List<OCComment> findBySourceTableAndSourceTableSysId(String sourceTable, Long sourceTableSysId);

}