package org.example.citydatabase.controller.impl;

import lombok.RequiredArgsConstructor;
import org.example.citydatabase.controller.HouseController;
import org.example.citydatabase.dto.house.AddHouseRequestDto;
import org.example.citydatabase.dto.house.GetHouseResponseDto;
import org.example.citydatabase.service.HouseService;
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
        GetHouseResponseDto responseDto = service.getHouseDto(houseId);

        return ResponseEntity.ok(responseDto);
    }

    @Override
    public ResponseEntity<GetHouseResponseDto> addHouse(@RequestBody AddHouseRequestDto requestDto) {
        Long houseId = service.addHouse(requestDto);

        return ResponseEntity.ok(service.getHouseDto(houseId));
    }

    @Override
    public ResponseEntity<GetHouseResponseDto> updateHouse(@PathVariable(name = "id") Long houseId,
                                                           @RequestBody AddHouseRequestDto requestDto) {
        service.updateHouse(houseId, requestDto);

        return ResponseEntity.ok(service.getHouseDto(houseId));
    }

    @Override
    public ResponseEntity<String> deleteHouse(@PathVariable(name = "id") Long houseId) {
        service.deleteHouse(houseId);

        return ResponseEntity.ok("House deleted!");
    }
}
