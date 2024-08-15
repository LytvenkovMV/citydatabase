package org.example.citydatabase.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "middlename")
    private String middlename;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    private Passport passport;

    @OneToMany(mappedBy = "person",
            cascade = CascadeType.ALL)
    private List<Car> cars;

    @ManyToMany
    @JoinTable(name = "persons_houses"
            , joinColumns = @JoinColumn(name = "person_id")
            , inverseJoinColumns = @JoinColumn(name = "house_id")
    )
    private List<House> houses;
}
