package com.example.onlinecourses.listeners;

import com.example.onlinecourses.model.OCComment;
import jakarta.persistence.PrePersist;

import java.sql.Timestamp;
import java.util.Date;

public class OCCommentListener {
    @PrePersist
    public void prePersist(Object o) {
        if (o instanceof OCComment ocComment) {
            ocComment.setCreationTime(new Timestamp(new Date().getTime()));
        }
    }
}
