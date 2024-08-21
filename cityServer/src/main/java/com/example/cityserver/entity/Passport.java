package com.example.cityserver.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "passports")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "series")
    private Integer series;

    @Column(name = "number")
    private Long number;

    @Column(name = "office_code")
    private String officeCode;

    @Column(name = "issue_date")
    private LocalDate issueDate;
}
