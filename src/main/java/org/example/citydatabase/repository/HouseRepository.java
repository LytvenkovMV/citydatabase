package org.example.citydatabase.repository;

import org.example.citydatabase.entity.House;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepository extends CrudRepository<House, Long> {

    @Query(value = "select h from House h where h.address ilike %?1%")
    List<House> findAllByStreetName(String streetName);
}
