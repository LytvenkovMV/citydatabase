package com.example.cityserver.repository;

import com.example.cityserver.entity.PersonHouse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonHouseRepository extends CrudRepository<PersonHouse, Long> {

    List<PersonHouse> findAllByPersonId(Long personId);

    List<PersonHouse> findAllByHouseId(Long houseId);

    void deleteAllByHouseId(Long houseId);

    void deleteAllByPersonId(Long personId);
}
