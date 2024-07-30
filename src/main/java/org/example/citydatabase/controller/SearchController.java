package org.example.citydatabase.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
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
    ResponseEntity<List<Car>> searchPersonCars(@PathVariable(name = "id") Long personId) {
        List<Car> cars = searchService.searchPersonCars(personId);

        return ResponseEntity.ok(cars);
    }

    @Operation(summary = "Найти всех жителей, которым принадлежат дома на указаной улице")
    @GetMapping("/persons/byhouse/onstreet")
    ResponseEntity<List<Person>> searchPersonByHouseOnStreet(@RequestParam(name = "name") String streetName) {
        List<Person> persons = searchService.searchPersonByHouseOnStreet(streetName);

        return ResponseEntity.ok(persons);
    }


    @Operation(summary = "Найти все паспорта, в которых фамилия владельца начинается на указаную букву")
    @GetMapping("passports/byperson/withsurname")
    ResponseEntity<List<Passport>> searchPassportByPersonWithSurnameStarts(@RequestParam(name = "start") Character startChar) {
        List<Passport> passports = searchService.searchPassportByPersonWithSurnameStarts(startChar);

        return ResponseEntity.ok(passports);
    }
}
