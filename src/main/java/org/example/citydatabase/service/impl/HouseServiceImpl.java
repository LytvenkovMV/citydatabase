package org.example.citydatabase.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.citydatabase.dto.house.AddHouseRequestDto;
import org.example.citydatabase.dto.house.GetHouseResponseDto;
import org.example.citydatabase.entity.House;
import org.example.citydatabase.entity.Person;
import org.example.citydatabase.mapper.HouseMapper;
import org.example.citydatabase.repository.HouseRepository;
import org.example.citydatabase.service.EntityProvider;
import org.example.citydatabase.service.HouseService;
import org.example.citydatabase.service.PersonHouseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService {

    private final EntityProvider entityProvider;
    private final PersonHouseService personHouseService;

    private final HouseRepository repository;
    private final HouseMapper mapper;

    @Override
    public House getHouse(Long houseId) {
        Optional<House> optHouse = repository.findById(houseId);
        if (optHouse.isEmpty()) throw new NoSuchElementException("House not found");

        return optHouse.get();
    }

    @Override
    public List<House> getHousesBy(String streetName) {
        return repository.findAllByStreetName(streetName);
    }

    @Override
    public GetHouseResponseDto getHouseDto(Long houseId) {
        Optional<House> optHouse = repository.findById(houseId);
        if (optHouse.isEmpty()) throw new NoSuchElementException("House not found");

        return mapper.fromHouse(optHouse.get());
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Long addHouse(AddHouseRequestDto dto) {
        House house = mapper.fromAddHouseRequestDto(dto);
        repository.save(house);

        for (Long personId : dto.getPersonsId()) {
            Person person = entityProvider.getPersonById(personId);
            if (person != null) personHouseService.addPersonHouse(person, house);
        }

        return house.getId();
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void updateHouse(Long houseId, AddHouseRequestDto dto) {
        if (!repository.existsById(houseId)) throw new NoSuchElementException("House not found");

        House house = mapper.fromAddHouseRequestDto(dto);
        house.setId(houseId);
        repository.save(house);

        personHouseService.deleteAllByHouseId(houseId);
        for (Long personId : dto.getPersonsId()) {
            Person person = entityProvider.getPersonById(personId);
            if (person != null) personHouseService.addPersonHouse(person, house);
        }
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT)
    public void deleteHouse(Long houseId) {
        Optional<House> optHouse = repository.findById(houseId);
        if (optHouse.isEmpty()) throw new NoSuchElementException("House not found");

        personHouseService.deleteAllByHouseId(houseId);
        repository.delete(optHouse.get());
    }
}
