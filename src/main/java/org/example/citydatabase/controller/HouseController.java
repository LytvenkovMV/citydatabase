package org.example.citydatabase.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.citydatabase.dto.house.AddHouseRequestDto;
import org.example.citydatabase.dto.house.GetHouseResponseDto;
import org.example.citydatabase.service.HouseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "API для домов")
@RestController
@RequestMapping("/city/api/houses")
@RequiredArgsConstructor
public class HouseController {

    private final HouseService service;

    @Operation(summary = "Получить дом")
    @GetMapping("/{id}")
    ResponseEntity<GetHouseResponseDto> getHouse(@PathVariable(name = "id") Long houseId) {
        GetHouseResponseDto responseDto = service.getHouseDto(houseId);

        return ResponseEntity.ok(responseDto);
    }

    @Operation(summary = "Добавить дом")
    @PostMapping
    ResponseEntity<GetHouseResponseDto> addHouse(@RequestBody AddHouseRequestDto requestDto) {
        GetHouseResponseDto responseDto = service.addHouse(requestDto);

        return ResponseEntity.ok(responseDto);
    }

    @Operation(summary = "Обновить дом")
    @PutMapping("/{id}")
    ResponseEntity<GetHouseResponseDto> updateHouse(@PathVariable(name = "id") Long houseId,
                                                    @RequestBody AddHouseRequestDto requestDto) {
        GetHouseResponseDto responseDto = service.updateHouse(houseId, requestDto);

        return ResponseEntity.ok(responseDto);
    }

    @Operation(summary = "Удалить дом")
    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteHouse(@PathVariable(name = "id") Long houseId) {
        service.deleteHouse(houseId);

        return ResponseEntity.ok("House deleted!");
    }
}
