package org.example.citydatabase.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.citydatabase.dto.car.GetCarResponseDto;
import org.example.citydatabase.dto.passport.GetPassportResponseDto;
import org.example.citydatabase.dto.person.GetPersonResponseDto;
import org.example.citydatabase.entity.Car;
import org.example.citydatabase.entity.Passport;
import org.example.citydatabase.entity.Person;
import org.example.citydatabase.service.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "API для поиска")
@RestController
@RequestMapping("/city/search")
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @Operation(summary = "Найти все машины жителя")
    @GetMapping("/cars/byperson/{id}")
    ResponseEntity<List<GetCarResponseDto>> searchPersonCars(@PathVariable(name = "id") Long personId) {
        List<GetCarResponseDto> cars = searchService.searchPersonCars(personId);

        return ResponseEntity.ok(cars);
    }

    @Operation(summary = "Найти всех жителей, которым принадлежат дома на указаной улице")
    @GetMapping("/persons/byhouse/onstreet")
    ResponseEntity<List<GetPersonResponseDto>> searchPersonByHouseOnStreet(@RequestParam(name = "name") String streetName) {
        List<GetPersonResponseDto> persons = searchService.searchPersonByHouseOnStreet(streetName);

        return ResponseEntity.ok(persons);
    }


    @Operation(summary = "Найти все паспорта, в которых фамилия владельца начинается на указаную букву")
    @GetMapping("passports/byperson/withsurname")
    ResponseEntity<List<GetPassportResponseDto>> searchPassportByPersonWithSurnameStarts(@RequestParam(name = "start") Character startChar) {
        List<GetPassportResponseDto> passports = searchService.searchPassportByPersonWithSurnameStarts(startChar);

        return ResponseEntity.ok(passports);
    }
}
