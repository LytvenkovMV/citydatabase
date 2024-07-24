package org.example.citydatabase.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "middlename")
    private String middlename;

    @Column(name = "birth_date")
    private Date birthDate;

    @OneToOne(mappedBy = "passports")
    @JoinColumn(name = "passport_id")
    private Integer passportId;
}
