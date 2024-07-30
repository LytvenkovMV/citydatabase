package org.example.citydatabase.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.citydatabase.dto.AddHouseRequestDto;
import org.example.citydatabase.entity.House;
import org.example.citydatabase.service.HouseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Для жителей")
@RestController
@RequestMapping("/city/house")
@RequiredArgsConstructor
public class HouseController {

    private final HouseService service;

    @Operation(summary = "Получить дом")
    @GetMapping("/{id}")
    ResponseEntity<House> getHouse(@PathVariable(name = "id") Long houseId) {
        House house = service.getHouse(houseId);

        return ResponseEntity.ok(house);
    }

    @Operation(summary = "Добавить дом")
    @PostMapping("/")
    ResponseEntity<House> addHouse(AddHouseRequestDto dto) {
        House house = service.addHouse(dto);

        return ResponseEntity.ok(house);
    }

    @Operation(summary = "Удалить дом")
    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteHouse(@PathVariable(name = "id") Long houseId) {
        service.deleteHouse(houseId);

        return ResponseEntity.ok("House deleted!");
    }
}
