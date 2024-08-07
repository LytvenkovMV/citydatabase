package org.example.citydatabase.mapper;

import org.example.citydatabase.dto.car.AddCarRequestDto;
import org.example.citydatabase.dto.car.GetCarResponseDto;
import org.example.citydatabase.entity.Car;
import org.example.citydatabase.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarMapper {

    @Mapping(target = "id", ignore = true)
    Car fromAddCarRequestDtoAndPerson(AddCarRequestDto dto, Person person);

    @Mapping(target = "personId", expression = "java(car.getPerson().getId())")
    GetCarResponseDto fromCar(Car car);
}
