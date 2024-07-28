package org.example.citydatabase.service;

import lombok.RequiredArgsConstructor;
import org.example.citydatabase.dto.AddHouseRequestDto;
import org.example.citydatabase.entity.House;
import org.example.citydatabase.entity.Person;
import org.example.citydatabase.entity.PersonHouse;
import org.example.citydatabase.mapper.HouseMapper;
import org.example.citydatabase.repository.HouseRepository;
import org.example.citydatabase.repository.PersonHouseRepository;
import org.example.citydatabase.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService {

    private final HouseRepository houseRepository;
    private final PersonRepository personRepository;
    private final PersonHouseRepository personHouseRepository;
    private final HouseMapper mapper;

    @Override
    public House getHouse(Long houseId) {
        return houseRepository.findById(houseId).orElseThrow();
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public House addHouse(AddHouseRequestDto dto) {
        House house = mapper.fromAddHouseRequestDto(dto);
        houseRepository.save(house);

        for (Long personId : dto.getPersonsId()) {
            Person person = personRepository.findById(personId).orElseThrow();

            PersonHouse personHouse = new PersonHouse();
            personHouse.setPerson(person);
            personHouse.setHouse(house);
            personHouseRepository.save(personHouse);
        }

        return house;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void deleteHouse(Long houseId) {
        House house = houseRepository.findById(houseId).orElseThrow();

        personHouseRepository.deleteAllByHouseId(houseId);
        houseRepository.delete(house);
    }
}
