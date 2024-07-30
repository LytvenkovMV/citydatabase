package org.example.citydatabase.service;

import org.example.citydatabase.dto.house.AddHouseRequestDto;
import org.example.citydatabase.dto.house.GetHouseResponseDto;
import org.example.citydatabase.entity.House;

public interface HouseService {

    GetHouseResponseDto getHouse(Long houseId);

    GetHouseResponseDto addHouse(AddHouseRequestDto dto);

    void deleteHouse(Long houseId);
}
