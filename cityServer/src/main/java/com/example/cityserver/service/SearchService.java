package com.example.cityserver.service;

import com.example.cityserver.dto.car.GetCarResponseDto;
import com.example.cityserver.dto.passport.GetPassportResponseDto;
import com.example.cityserver.dto.person.GetPersonResponseDto;

import java.util.List;

public interface SearchService {

    List<GetCarResponseDto> searchPersonCars(Long personId);

    List<GetPersonResponseDto> searchPersonsByHousesOnStreet(String streetName);

    List<GetPassportResponseDto> searchPassportWithSurnameStartingWith(Character startChar);
}
