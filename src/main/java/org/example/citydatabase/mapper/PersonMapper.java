package org.example.citydatabase.mapper;

import org.example.citydatabase.dto.person.AddPersonRequestDto;
import org.example.citydatabase.dto.person.GetPersonResponseDto;
import org.example.citydatabase.entity.Person;
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
