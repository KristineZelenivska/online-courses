package com.example.onlinecourses.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "oc_group")
public class OCGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sys_id", nullable = false)
    private Long sysId;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

}