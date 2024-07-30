package org.example.citydatabase.mapper;

import org.example.citydatabase.dto.person.AddPersonRequestDto;
import org.example.citydatabase.dto.person.GetPersonResponseDto;
import org.example.citydatabase.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "passport", ignore = true)
    @Mapping(target = "cars", ignore = true)
    @Mapping(target = "houses", ignore = true)
    Person personFromAddPersonRequestDto(AddPersonRequestDto dto);

    GetPersonResponseDto fromPerson(Person person);
}
