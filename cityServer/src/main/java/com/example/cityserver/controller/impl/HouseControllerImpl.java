package com.example.cityserver.controller.impl;

import lombok.RequiredArgsConstructor;
import com.example.cityserver.controller.HouseController;
import com.example.cityserver.dto.house.AddHouseRequestDto;
import com.example.cityserver.dto.house.GetHouseResponseDto;
import com.example.cityserver.service.HouseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HouseControllerImpl implements HouseController {

    private final HouseService service;

    @Override
    public ResponseEntity<GetHouseResponseDto> getHouse(@PathVariable(name = "id") Long houseId) {
        GetHouseResponseDto dto = service.getHouseDto(houseId);

        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<GetHouseResponseDto> addHouse(@RequestBody AddHouseRequestDto requestDto) {
        GetHouseResponseDto dto = service.addHouse(requestDto);

        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<GetHouseResponseDto> updateHouse(@PathVariable(name = "id") Long houseId,
                                                           @RequestBody AddHouseRequestDto requestDto) {
        GetHouseResponseDto dto = service.updateHouse(houseId, requestDto);

        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<String> deleteHouse(@PathVariable(name = "id") Long houseId) {
        service.deleteHouse(houseId);

        return ResponseEntity.ok("House deleted!");
    }
}
