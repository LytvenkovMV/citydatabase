package com.example.cityserver.repository;

import com.example.cityserver.entity.House;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepository extends CrudRepository<House, Long> {

    @Query(value = "select h from House h where h.address ilike %:str%")
    List<House> findAllByStreetName(@Param("str") String streetName);
}
