package org.example.citydatabase.controller;

import lombok.RequiredArgsConstructor;
import org.example.citydatabase.dto.AddHouseRequestDto;
import org.example.citydatabase.entity.House;
import org.example.citydatabase.service.HouseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("citydatabase/house")
@RequiredArgsConstructor
public class HouseController {

    private final HouseService service;

    @GetMapping("/{id}")
    ResponseEntity<House> getHouse(@PathVariable(name = "id") Long houseId) {
        House house = service.getHouse(houseId);

        return ResponseEntity.ok(house);
    }

    @PostMapping("/")
    ResponseEntity<House> addHouse(AddHouseRequestDto dto) {
        House house = service.addHouse(dto);

        return ResponseEntity.ok(house);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteHouse(@PathVariable(name = "id") Long houseId){
        service.deleteHouse(houseId);

        return ResponseEntity.ok("House deleted!");
    }
}
