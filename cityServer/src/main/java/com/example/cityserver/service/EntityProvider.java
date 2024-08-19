package com.example.cityserver.service;

import com.example.cityserver.entity.House;
import com.example.cityserver.entity.Person;

public interface EntityProvider {

    Person getPersonById(Long personId);

    House getHouseById(Long houseId);
}
