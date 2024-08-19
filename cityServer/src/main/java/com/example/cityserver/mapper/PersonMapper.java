package com.example.cityserver.mapper;

import com.example.cityserver.dto.person.AddPersonRequestDto;
import com.example.cityserver.dto.person.GetPersonResponseDto;
import com.example.cityserver.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        uses = {CarMapper.class, HouseMapper.class, PassportMapper.class})
public interface PersonMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "passport", ignore = true)
    @Mapping(target = "cars", expression = "java(new ArrayList<Car>())")
    @Mapping(target = "houses", expression = "java(new ArrayList<House>())")
    Person personFromAddPersonRequestDto(AddPersonRequestDto dto);

    GetPersonResponseDto fromPerson(Person person);
}
