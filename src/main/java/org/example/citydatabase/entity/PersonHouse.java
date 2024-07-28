package org.example.citydatabase.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "persons_houses")
public class PersonHouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "house_id")
    private House house;
}
