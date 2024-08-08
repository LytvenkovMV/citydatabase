package org.example.citydatabase.controller.impl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.citydatabase.controller.HouseController;
import org.example.citydatabase.dto.house.AddHouseRequestDto;
import org.example.citydatabase.dto.house.GetHouseResponseDto;
import org.example.citydatabase.service.HouseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "API для домов")
@RestController
@RequestMapping("/city/api/houses")
@RequiredArgsConstructor
public class HouseControllerImpl implements HouseController {

    private final HouseService service;

    @Override
    @Operation(summary = "Получить дом")
    @GetMapping("/{id}")
    public ResponseEntity<GetHouseResponseDto> getHouse(@PathVariable(name = "id") Long houseId) {
        GetHouseResponseDto responseDto = service.getHouseDto(houseId);

        return ResponseEntity.ok(responseDto);
    }

    @Override
    @Operation(summary = "Добавить дом")
    @PostMapping
    public ResponseEntity<GetHouseResponseDto> addHouse(@RequestBody AddHouseRequestDto requestDto) {
        Long houseId = service.addHouse(requestDto);

        return ResponseEntity.ok(service.getHouseDto(houseId));
    }

    @Override
    @Operation(summary = "Обновить дом")
    @PutMapping("/{id}")
    public ResponseEntity<GetHouseResponseDto> updateHouse(@PathVariable(name = "id") Long houseId,
                                                           @RequestBody AddHouseRequestDto requestDto) {
        service.updateHouse(houseId, requestDto);

        return ResponseEntity.ok(service.getHouseDto(houseId));
    }

    @Override
    @Operation(summary = "Удалить дом")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHouse(@PathVariable(name = "id") Long houseId) {
        service.deleteHouse(houseId);

        return ResponseEntity.ok("House deleted!");
    }
}
