package com.example.onlinecourses.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = OCPersonCourses.ENTITY_NAME)
@Table(name = OCPersonCourses.TABLE_NAME)
public class OCPersonCourses extends OCAbstractEntity {
    public static final String ENTITY_NAME = "OCPersonCourses";
    public static final String TABLE_NAME = "OCPersonCourses";
    public static final String COLUMN_SYSID_NAME = "sysId";
    public static final String COLUMN_RESPONSIBLE_NAME = "responsible";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = COLUMN_SYSID_NAME, nullable = false)
    private Long sysId;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "person_sysId", nullable = false)
    private OCPerson person;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_sys_Id")
    private OCCourse course;

    @Column(name = COLUMN_RESPONSIBLE_NAME)
    private Boolean responsible;

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        OCPersonCourses that = (OCPersonCourses) o;
        return getSysId() != null && Objects.equals(getSysId(), that.getSysId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}