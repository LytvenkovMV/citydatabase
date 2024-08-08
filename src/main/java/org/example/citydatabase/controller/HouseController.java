package org.example.citydatabase.controller;

import org.example.citydatabase.dto.house.AddHouseRequestDto;
import org.example.citydatabase.dto.house.GetHouseResponseDto;
import org.springframework.http.ResponseEntity;

public interface HouseController {

    ResponseEntity<GetHouseResponseDto> getHouse(Long houseId);

    ResponseEntity<GetHouseResponseDto> addHouse(AddHouseRequestDto requestDto);

    ResponseEntity<GetHouseResponseDto> updateHouse(Long houseId, AddHouseRequestDto requestDto);

    ResponseEntity<String> deleteHouse(Long houseId);
}
