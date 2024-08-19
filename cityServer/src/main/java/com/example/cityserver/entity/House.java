package com.example.cityserver.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Table(name = "houses")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cadastr_number")
    private Integer cadastrNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "cadastr_price")
    private BigDecimal cadastrPrice;

    @ManyToMany
    @JoinTable(name = "persons_houses"
            , joinColumns = @JoinColumn(name = "house_id")
            , inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    List<Person> persons;
}
