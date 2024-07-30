package org.example.citydatabase.mapper;

import org.example.citydatabase.dto.car.AddCarRequestDto;
import org.example.citydatabase.dto.car.GetCarResponseDto;
import org.example.citydatabase.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "person", ignore = true)
    Car fromAddCarRequestDto(AddCarRequestDto dto);

    GetCarResponseDto fromCar(Car car);
}
