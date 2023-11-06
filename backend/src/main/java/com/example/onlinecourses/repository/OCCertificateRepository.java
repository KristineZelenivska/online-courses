package com.example.onlinecourses.repository;

import com.example.onlinecourses.model.OCCertificate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OCCertificateRepository extends JpaRepository<OCCertificate, Long> {
}