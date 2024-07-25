package org.example.citydatabase.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "gos_number")
    private String gosNumber;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "color")
    private String color;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
