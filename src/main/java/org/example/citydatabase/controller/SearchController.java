package org.example.citydatabase.controller;

import lombok.RequiredArgsConstructor;
import org.example.citydatabase.entity.Car;
import org.example.citydatabase.entity.Passport;
import org.example.citydatabase.entity.Person;
import org.example.citydatabase.service.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city/search")
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/cars/byperson/{id}")
    ResponseEntity<List<Car>> searchPersonCars(@PathVariable(name = "id") Long personId) {
        List<Car> cars = searchService.searchPersonCars(personId);

        return ResponseEntity.ok(cars);
    }

    @GetMapping("/persons/byhouse/onstreet")
    ResponseEntity<List<Person>> searchPersonByHouseOnStreet(@RequestParam(name = "name") String streetName) {
        List<Person> persons = searchService.searchPersonByHouseOnStreet(streetName);

        return ResponseEntity.ok(persons);
    }


    @GetMapping("passports/byperson/withsurname")
    ResponseEntity<List<Passport>> searchPassportByPersonWithSurnameStarts(@RequestParam(name = "start") Character startChar) {
        List<Passport> passports = searchService.searchPassportByPersonWithSurnameStarts(startChar);

        return ResponseEntity.ok(passports);
    }
}
