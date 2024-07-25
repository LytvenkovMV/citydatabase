package org.example.citydatabase.entity;

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
    private Integer id;

    @Column(name = "cadastr_number")
    private String cadastrNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "cadastr_price")
    private BigDecimal cadastrPrice;

    @ManyToMany
    List<Person> persons;
}
