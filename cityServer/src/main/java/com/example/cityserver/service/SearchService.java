package com.example.cityserver.service;

import com.example.cityserver.dto.car.GetCarResponseDto;
import com.example.cityserver.dto.passport.GetPassportResponseDto;
import com.example.cityserver.dto.person.GetPersonResponseDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.util.List;

public interface SearchService {

    List<GetCarResponseDto> searchPersonCars(@Positive Long personId);

    List<GetPersonResponseDto> searchPersonsByHousesOnStreet(@NotBlank String streetName);

    List<GetPassportResponseDto> searchPassportWithSurnameStartingWith(@NotBlank Character startChar);
}
