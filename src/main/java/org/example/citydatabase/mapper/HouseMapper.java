package org.example.citydatabase.mapper;

import org.example.citydatabase.dto.house.AddHouseRequestDto;
import org.example.citydatabase.dto.house.GetHouseResponseDto;
import org.example.citydatabase.entity.House;
import org.example.citydatabase.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HouseMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "persons", ignore = true)
    House fromAddHouseRequestDto(AddHouseRequestDto dto);

    @Mapping(target = "personIds", expression = "java(getPersonIds(house))")
    GetHouseResponseDto fromHouse(House house);

    default List<Long> getPersonIds(House house) {
        return house.getPersons().stream()
                .map(Person::getId)
                .toList();
    }
}
