package com.example.cityserver.mapper;

import com.example.cityserver.dto.passport.GetPassportResponseDto;
import com.example.cityserver.entity.Passport;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PassportMapper {

    GetPassportResponseDto fromPassport(Passport passport);
}
