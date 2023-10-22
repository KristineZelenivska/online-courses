package com.example.onlinecourses.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = OCCourse.ENTITY_NAME)
@Table(name = OCCourse.TABLE_NAME)
public class OCCourse extends OCAbstractEntity {
    public static final String ENTITY_NAME = "OCCourse";
    public static final String TABLE_NAME = "OCCourse";
    public static final String COLUMN_SYSID_NAME = "sysId";
    public static final String COLUMN_NAME_NAME = "name";
    public static final String COLUMN_OPENCOURSE_NAME = "openCourse";
    public static final String COLUMN_ENDDATE_NAME = "endDate";
    public static final String COLUMN_DESCRIPTION_NAME = "description";
    public static final String COLUMN_MODULES_NAME = "modules";
    public static final String COLUMN_PRICE_NAME = "price";

    @Id
    @Column(name = COLUMN_SYSID_NAME, nullable = false)
    private Long sysId;

    @Column(name = COLUMN_NAME_NAME, nullable = false)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "courseCategory_sys_Id", nullable = false)
    private OCCourseCategory courseCategory;

    @Column(name = COLUMN_OPENCOURSE_NAME)
    private Boolean openCourse;

    @Column(name = COLUMN_ENDDATE_NAME)
    private Date endDate;

    @Lob
    @Column(name = COLUMN_DESCRIPTION_NAME)
    private String description;

    @Column(name = COLUMN_MODULES_NAME, nullable = false)
    @JdbcTypeCode(SqlTypes.SMALLINT)
    private Integer modules;

    @Column(name = COLUMN_PRICE_NAME, precision = 10, scale = 2)
    private BigDecimal price;

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }
}