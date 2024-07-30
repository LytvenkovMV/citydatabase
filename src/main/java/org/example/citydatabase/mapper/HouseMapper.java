package org.example.citydatabase.mapper;

import org.example.citydatabase.dto.car.GetCarResponseDto;
import org.example.citydatabase.dto.house.AddHouseRequestDto;
import org.example.citydatabase.dto.house.GetHouseResponseDto;
import org.example.citydatabase.entity.House;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HouseMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "persons", ignore = true)
    House fromAddHouseRequestDto(AddHouseRequestDto dto);

    GetHouseResponseDto fromHouse(House house);
}
