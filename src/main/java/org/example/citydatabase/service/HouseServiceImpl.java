package org.example.citydatabase.service;

import lombok.RequiredArgsConstructor;
import org.example.citydatabase.dto.house.AddHouseRequestDto;
import org.example.citydatabase.dto.house.GetHouseResponseDto;
import org.example.citydatabase.entity.House;
import org.example.citydatabase.entity.Person;
import org.example.citydatabase.mapper.HouseMapper;
import org.example.citydatabase.repository.HouseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService {

    private final EntityProvider entityProvider;
    private final PersonHouseService personHouseService;

    private final HouseRepository houseRepository;
    private final HouseMapper mapper;

    @Override
    public House getHouseEntity(Long houseId) {
        Optional<House> optHouse = houseRepository.findById(houseId);
        if (optHouse.isEmpty()) throw new NoSuchElementException("House not found");

        return optHouse.get();
    }

    @Override
    public GetHouseResponseDto getHouse(Long houseId) {
        House house = getHouseEntity(houseId);

        return mapper.fromHouse(house);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public GetHouseResponseDto addHouse(AddHouseRequestDto dto) {
        House house = mapper.fromAddHouseRequestDto(dto);
        houseRepository.save(house);

        for (Long personId : dto.getPersonsId()) {
            Person person = entityProvider.getPersonById(personId);
            if (person == null) throw new NoSuchElementException("Person not found");

            personHouseService.addPersonHouse(person, house);
        }

        return mapper.fromHouse(house);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void deleteHouse(Long houseId) {
        Optional<House> optHouse = houseRepository.findById(houseId);
        if (optHouse.isEmpty()) throw new NoSuchElementException("House not found");

        personHouseService.deleteAllByHouseId(houseId);
        houseRepository.delete(optHouse.get());
    }
}
