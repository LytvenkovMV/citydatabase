package org.example.citydatabase.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.citydatabase.dto.car.GetCarResponseDto;
import org.example.citydatabase.dto.passport.GetPassportResponseDto;
import org.example.citydatabase.dto.person.GetPersonResponseDto;
import org.example.citydatabase.service.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "API для поиска")
@RestController
@RequestMapping("/api/city/search")
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @Operation(summary = "Найти все машины жителя")
    @GetMapping("/persons/{id}/cars")
    ResponseEntity<List<GetCarResponseDto>> searchPersonCars(@PathVariable(name = "id") Long personId) {
        List<GetCarResponseDto> cars = searchService.searchPersonCars(personId);

        return ResponseEntity.ok(cars);
    }

    @Operation(summary = "Найти всех жителей, которым принадлежат дома на указаной улице")
    @GetMapping("/persons/houses")
    ResponseEntity<List<GetPersonResponseDto>> searchPersonsByHousesOnStreet(@RequestParam(name = "street_name") String streetName) {
        List<GetPersonResponseDto> persons = searchService.searchPersonsByHousesOnStreet(streetName);

        return ResponseEntity.ok(persons);
    }


    @Operation(summary = "Найти все паспорта, в которых фамилия владельца начинается на указаную букву")
    @GetMapping("/persons/passports/")
    ResponseEntity<List<GetPassportResponseDto>> searchPassportWithSurnameStartingWith(@RequestParam(name = "surname_start_char") Character startChar) {
        List<GetPassportResponseDto> passports = searchService.searchPassportWithSurnameStartingWith(startChar);

        return ResponseEntity.ok(passports);
    }
}
