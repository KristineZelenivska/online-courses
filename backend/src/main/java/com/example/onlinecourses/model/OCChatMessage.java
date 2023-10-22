package com.example.onlinecourses.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = OCChatMessage.ENTITY_NAME)
@Table(name = OCChatMessage.TABLE_NAME)
public class OCChatMessage extends OCAbstractEntity {
    public static final String ENTITY_NAME = "OCChatMessage";
    public static final String TABLE_NAME = "OCChatMessage";
    public static final String COLUMN_SYSID_NAME = "sysId";
    public static final String COLUMN_CREATIONTIME_NAME = "creationTime";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = COLUMN_SYSID_NAME, nullable = false)
    private Long sysId;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "chat_sysId", nullable = false)
    private OCChat chat;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "comment_sysId", nullable = false)
    private OCComment comment;

    @Column(name = COLUMN_CREATIONTIME_NAME, nullable = false)
    private Timestamp creationTime;

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }
}