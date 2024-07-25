package org.example.citydatabase.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "persons")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "number")
    private Integer number;

    @Column(name = "office_code")
    private Integer officeCode;

    @Column(name = "issue_date")
    private Date issueDate;
}
