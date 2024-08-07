package org.example.citydatabase.service;

import org.example.citydatabase.dto.house.AddHouseRequestDto;
import org.example.citydatabase.dto.house.GetHouseResponseDto;
import org.example.citydatabase.entity.House;

import java.util.List;

public interface HouseService {

    House getHouse(Long houseId);

    List<House> getHousesBy(String streetName);

    GetHouseResponseDto getHouseDto(Long houseId);

    Long addHouse(AddHouseRequestDto dto);

    void updateHouse(Long houseId, AddHouseRequestDto dto);

    void deleteHouse(Long houseId);
}
