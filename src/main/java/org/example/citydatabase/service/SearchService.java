package org.example.citydatabase.service;

import org.example.citydatabase.dto.car.GetCarResponseDto;
import org.example.citydatabase.dto.passport.GetPassportResponseDto;
import org.example.citydatabase.dto.person.GetPersonResponseDto;

import java.util.List;

public interface SearchService {

    List<GetCarResponseDto> searchPersonCars(Long personId);

    List<GetPersonResponseDto> searchPersonsByHousesOnStreet(String streetName);

    List<GetPassportResponseDto> searchPassportWithSurnameStartingWith(Character startChar);
}
