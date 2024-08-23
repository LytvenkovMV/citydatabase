package com.example.cityserver.service.impl;

import com.example.cityserver.dto.house.AddHouseRequestDto;
import com.example.cityserver.dto.house.GetHouseResponseDto;
import com.example.cityserver.entity.House;
import com.example.cityserver.entity.Person;
import com.example.cityserver.mapper.HouseMapper;
import com.example.cityserver.repository.HouseRepository;
import com.example.cityserver.service.HouseService;
import com.example.cityserver.service.PersonHouseService;
import com.example.cityserver.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService {

    @Autowired
    @Lazy
    private PersonService personService;

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
    public GetHouseResponseDto addHouse(AddHouseRequestDto dto) {
        House house = mapper.fromAddHouseRequestDto(dto);
        repository.save(house);

        List<Person> persons = dto.getPersonsId().stream()
                .distinct()
                .map(personService::getPerson)
                .toList();
        house.setPersons(personHouseService.updatePersonsInHouseWithId(house, persons));

        return mapper.fromHouse(house);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public GetHouseResponseDto updateHouse(Long houseId, AddHouseRequestDto dto) {
        if (!repository.existsById(houseId)) throw new NoSuchElementException("House not found");

        House house = mapper.fromAddHouseRequestDto(dto);
        house.setId(houseId);
        repository.save(house);

        List<Person> persons = dto.getPersonsId().stream()
                .distinct()
                .map(personService::getPerson)
                .toList();
        house.setPersons(personHouseService.updatePersonsInHouseWithId(house, persons));

        return mapper.fromHouse(house);
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
