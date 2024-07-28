package org.example.citydatabase.service;

import org.example.citydatabase.dto.AddHouseRequestDto;
import org.example.citydatabase.entity.House;

public interface HouseService {

    House getHouse(Long houseId);

    House addHouse(AddHouseRequestDto dto);

    void deleteHouse(Long houseId);
}
