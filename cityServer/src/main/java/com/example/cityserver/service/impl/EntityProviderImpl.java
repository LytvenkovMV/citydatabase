package com.example.cityserver.service.impl;

import com.example.cityserver.entity.House;
import com.example.cityserver.entity.Person;
import com.example.cityserver.service.EntityProvider;
import com.example.cityserver.service.HouseService;
import com.example.cityserver.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class EntityProviderImpl implements EntityProvider {

    @Autowired
    @Lazy
    private PersonService personService;

    @Autowired
    @Lazy
    private HouseService houseService;

    @Override
    public Person getPersonById(Long personId) {

        return personService.getPerson(personId);
    }

    @Override
    public House getHouseById(Long houseId) {

        return houseService.getHouse(houseId);
    }
}
