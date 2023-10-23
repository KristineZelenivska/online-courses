package com.example.onlinecourses.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "oc_user_groups")
public class OCUserGroups {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sys_id", nullable = false)
    private Long sysId;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "group_sys_id", nullable = false)
    private OCGroup group;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "user_sys_id", nullable = false)
    private OCUser user;

}