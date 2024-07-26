package org.example.citydatabase.mapper;

import org.example.citydatabase.dto.AddPersonRequestDto;
import org.example.citydatabase.entity.Passport;
import org.example.citydatabase.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(target = "id", ignore = true)
    Person personFromAddPersonRequestDto(AddPersonRequestDto dto);

    @Mapping(target = "id", ignore = true)
    Passport passportFromAddPersonRequestDto(AddPersonRequestDto dto);
}
