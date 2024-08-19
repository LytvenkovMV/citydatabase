package com.example.cityserver.controller.impl;

import lombok.RequiredArgsConstructor;
import com.example.cityserver.controller.SearchController;
import com.example.cityserver.dto.car.GetCarResponseDto;
import com.example.cityserver.dto.passport.GetPassportResponseDto;
import com.example.cityserver.dto.person.GetPersonResponseDto;
import com.example.cityserver.service.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class SearchControllerImpl implements SearchController {

    private final SearchService searchService;

    public ResponseEntity<List<GetCarResponseDto>> searchPersonCars(@PathVariable(name = "id") Long personId) {
        List<GetCarResponseDto> cars = searchService.searchPersonCars(personId);

        return ResponseEntity.ok(cars);
    }

    public ResponseEntity<List<GetPersonResponseDto>> searchPersonsByHousesOnStreet(@RequestParam(name = "street_name") String streetName) {
        List<GetPersonResponseDto> persons = searchService.searchPersonsByHousesOnStreet(streetName);

        return ResponseEntity.ok(persons);
    }

    public ResponseEntity<List<GetPassportResponseDto>> searchPassportWithSurnameStartingWith(@RequestParam(name = "surname_start_char") Character startChar) {
        List<GetPassportResponseDto> passports = searchService.searchPassportWithSurnameStartingWith(startChar);

        return ResponseEntity.ok(passports);
    }
}
