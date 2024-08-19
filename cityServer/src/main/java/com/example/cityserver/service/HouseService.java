package com.example.cityserver.service;

import com.example.cityserver.dto.house.AddHouseRequestDto;
import com.example.cityserver.dto.house.GetHouseResponseDto;
import com.example.cityserver.entity.House;

import java.util.List;

public interface HouseService {

    House getHouse(Long houseId);

    List<House> getHousesBy(String streetName);

    GetHouseResponseDto getHouseDto(Long houseId);

    GetHouseResponseDto addHouse(AddHouseRequestDto dto);

    GetHouseResponseDto updateHouse(Long houseId, AddHouseRequestDto dto);

    void deleteHouse(Long houseId);
}
