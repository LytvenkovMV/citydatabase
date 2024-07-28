package org.example.citydatabase.repository;

import org.example.citydatabase.entity.PersonHouse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonHouseRepository extends CrudRepository<PersonHouse, Long> {

    void deleteAllByHouseId(Long houseId);
    void deleteAllByPersonId(Long personId);
}
