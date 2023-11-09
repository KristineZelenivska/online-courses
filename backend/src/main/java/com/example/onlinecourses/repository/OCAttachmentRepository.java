package com.example.onlinecourses.repository;

import com.example.onlinecourses.model.OCAttachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OCAttachmentRepository extends JpaRepository<OCAttachment, Long> {
    List<OCAttachment> findBySourceTableAndSourceTableSysId(String sourceTable, Long sourceTableSysId);

}