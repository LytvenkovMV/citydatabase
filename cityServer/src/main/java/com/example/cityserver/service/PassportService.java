package com.example.cityserver.service;

import com.example.cityserver.dto.passport.GetPassportResponseDto;
import com.example.cityserver.entity.Passport;

public interface PassportService {

    GetPassportResponseDto getPassportDto(Long passportId);

    Passport addPassport();

    void deletePassport(Long passportId);
}
