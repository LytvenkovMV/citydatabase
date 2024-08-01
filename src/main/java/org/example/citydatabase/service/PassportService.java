package org.example.citydatabase.service;

import org.example.citydatabase.dto.passport.GetPassportResponseDto;
import org.example.citydatabase.entity.Passport;

public interface PassportService {

    GetPassportResponseDto getPassportDto(Long passportId);

    Passport addPassport();

    void deletePassport(Long passportId);
}
