package com.example.onlinecourses.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = OCPaymentDetails.ENTITY_NAME)
@Table(name = OCPaymentDetails.TABLE_NAME)
public class OCPaymentDetails extends OCAbstractEntity {
    public static final String ENTITY_NAME = "OCPaymentDetails";
    public static final String TABLE_NAME = "OCPaymentDetails";
    public static final String COLUMN_SYSID_NAME = "sysId";
    public static final String COLUMN_BANK_NAME = "bank";
    public static final String COLUMN_CREDITCARD_NAME = "creditCard";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = COLUMN_SYSID_NAME, nullable = false)
    private Long sysId;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "person_sysId", nullable = false)
    private OCPerson person;

    @Column(name = COLUMN_BANK_NAME)
    private String bank;

    @Column(name = COLUMN_CREDITCARD_NAME)
    private String creditCard;

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }
}