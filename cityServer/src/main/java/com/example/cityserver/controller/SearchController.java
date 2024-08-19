package com.example.cityserver.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.example.cityserver.dto.car.GetCarResponseDto;
import com.example.cityserver.dto.passport.GetPassportResponseDto;
import com.example.cityserver.dto.person.GetPersonResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Tag(name = "API для поиска")
public interface SearchController {

    @Operation(summary = "Найти все машины жителя")
    @GetMapping("/city/api/search/persons/{id}/cars")
    ResponseEntity<List<GetCarResponseDto>> searchPersonCars(@PathVariable(name = "id") Long personId);

    @Operation(summary = "Найти всех жителей, которым принадлежат дома на указаной улице")
    @GetMapping("/city/api/search/persons/houses")
    ResponseEntity<List<GetPersonResponseDto>> searchPersonsByHousesOnStreet(@RequestParam(name = "street_name") String streetName);


    @Operation(summary = "Найти все паспорта, в которых фамилия владельца начинается на указаную букву")
    @GetMapping("/city/api/search/persons/passports")
    ResponseEntity<List<GetPassportResponseDto>> searchPassportWithSurnameStartingWith(@RequestParam(name = "surname_start_char") Character startChar);
}
