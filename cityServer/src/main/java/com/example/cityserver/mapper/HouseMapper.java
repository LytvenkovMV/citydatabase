package com.example.cityserver.mapper;

import com.example.cityserver.dto.house.AddHouseRequestDto;
import com.example.cityserver.dto.house.GetHouseResponseDto;
import com.example.cityserver.entity.House;
import com.example.cityserver.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface HouseMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "persons", ignore = true)
    House fromAddHouseRequestDto(AddHouseRequestDto dto);

    @Mapping(target = "personIds", expression = "java(getPersonIds(house))")
    GetHouseResponseDto fromHouse(House house);

    default List<Long> getPersonIds(House house) {
        if (house.getPersons() == null) return new ArrayList<>();

        return house.getPersons().stream()
                .map(Person::getId)
                .distinct()
                .sorted()
                .toList();
    }
}
