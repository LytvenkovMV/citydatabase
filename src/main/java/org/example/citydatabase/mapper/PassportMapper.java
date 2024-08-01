package org.example.citydatabase.mapper;

import org.example.citydatabase.dto.passport.GetPassportResponseDto;
import org.example.citydatabase.entity.Passport;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PassportMapper {

    GetPassportResponseDto fromPassport(Passport passport);
}
