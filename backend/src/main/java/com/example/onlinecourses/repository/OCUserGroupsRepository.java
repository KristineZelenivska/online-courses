package com.example.onlinecourses.repository;

import com.example.onlinecourses.model.OCUserGroups;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OCUserGroupsRepository extends JpaRepository<OCUserGroups, Long> {
}