package com.example.cityserver.service;

import com.example.cityserver.dto.passport.GetPassportResponseDto;
import com.example.cityserver.entity.Passport;

import java.util.List;

public interface PassportService {

    GetPassportResponseDto getPassportDto(Long passportId);

    Passport addPassport();

    List<Passport> addPassportList(int size);

    void deletePassport(Long passportId);
}
