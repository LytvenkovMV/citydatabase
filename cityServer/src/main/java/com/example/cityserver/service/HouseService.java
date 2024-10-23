package com.example.cityserver.service;

import com.example.cityserver.dto.house.AddHouseRequestDto;
import com.example.cityserver.dto.house.GetHouseResponseDto;
import com.example.cityserver.entity.House;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

import java.util.List;

public interface HouseService {

    House getHouse(@Positive Long houseId);

    List<House> getHousesBy(
            @NotBlank
            @Pattern(regexp = "[А-Я,а-я]")
            String streetName);

    GetHouseResponseDto getHouseDto(@Positive Long houseId);

    GetHouseResponseDto addHouse(@Valid AddHouseRequestDto dto);

    GetHouseResponseDto updateHouse(@Positive Long houseId, @Valid AddHouseRequestDto dto);

    void deleteHouse(@Positive Long houseId);
}
