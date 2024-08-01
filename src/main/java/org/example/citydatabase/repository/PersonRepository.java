package org.example.citydatabase.repository;

import org.example.citydatabase.entity.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query(value = "SELECT * FROM persons"
            , nativeQuery = true)
    List<Person> findAllBySurnameStartingWith(Character c);
}
