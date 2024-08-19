package com.example.cityserver.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.example.cityserver.dto.house.AddHouseRequestDto;
import com.example.cityserver.dto.house.GetHouseResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "API для домов")
public interface HouseController {

    @Operation(summary = "Получить дом")
    @GetMapping("/city/api/houses/{id}")
    ResponseEntity<GetHouseResponseDto> getHouse(@PathVariable(name = "id") Long houseId);

    @Operation(summary = "Добавить дом")
    @PostMapping("/city/api/houses")
    ResponseEntity<GetHouseResponseDto> addHouse(@RequestBody AddHouseRequestDto requestDto);

    @Operation(summary = "Обновить дом")
    @PutMapping("/city/api/houses/{id}")
    ResponseEntity<GetHouseResponseDto> updateHouse(@PathVariable(name = "id") Long houseId,
                                                    @RequestBody AddHouseRequestDto requestDto);

    @Operation(summary = "Удалить дом")
    @DeleteMapping("/city/api/houses/{id}")
    ResponseEntity<String> deleteHouse(@PathVariable(name = "id") Long houseId);
}
