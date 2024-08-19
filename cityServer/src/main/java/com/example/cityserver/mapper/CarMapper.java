package com.example.cityserver.mapper;

import com.example.cityserver.dto.car.AddCarRequestDto;
import com.example.cityserver.dto.car.GetCarResponseDto;
import com.example.cityserver.entity.Car;
import com.example.cityserver.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarMapper {

    @Mapping(target = "id", ignore = true)
    Car fromAddCarRequestDtoAndPerson(AddCarRequestDto dto, Person person);

    @Mapping(target = "personId", expression = "java(car.getPerson().getId())")
    GetCarResponseDto fromCar(Car car);
}
