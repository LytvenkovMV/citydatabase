package com.example.cityserver.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "passports")
@Getter
@Setter
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
