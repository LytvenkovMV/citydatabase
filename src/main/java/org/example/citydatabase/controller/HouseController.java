package org.example.citydatabase.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.citydatabase.dto.house.AddHouseRequestDto;
import org.example.citydatabase.dto.house.GetHouseResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "API для домов")
@RequestMapping("/city/api/houses")
public interface HouseController {

    @Operation(summary = "Получить дом")
    @GetMapping("/{id}")
    ResponseEntity<GetHouseResponseDto> getHouse(Long houseId);

    @Operation(summary = "Добавить дом")
    @PostMapping
    ResponseEntity<GetHouseResponseDto> addHouse(AddHouseRequestDto requestDto);

    @Operation(summary = "Обновить дом")
    @PutMapping("/{id}")
    ResponseEntity<GetHouseResponseDto> updateHouse(Long houseId, AddHouseRequestDto requestDto);

    @Operation(summary = "Удалить дом")
    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteHouse(Long houseId);
}
