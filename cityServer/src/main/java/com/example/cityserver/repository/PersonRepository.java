package com.example.cityserver.repository;

import com.example.cityserver.entity.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query(value = "SELECT * FROM persons WHERE surname LIKE :ch%"
            , nativeQuery = true)
    List<Person> findAllBySurnameStartingWith(@Param("ch") Character ch);
}
