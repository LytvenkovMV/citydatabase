package com.example.cityserver.service.impl;

import com.example.cityserver.dto.passport.GetPassportResponseDto;
import com.example.cityserver.entity.Passport;
import com.example.cityserver.mapper.PassportMapper;
import com.example.cityserver.repository.PassportRepository;
import com.example.cityserver.service.PassportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PassportServiceImpl implements PassportService {

    private final PassportRepository repository;
    private final PassportMapper mapper;

    @Value("${cityserver.passportservice.office-code}")
    private static String officeCode;

    @Value("${cityserver.passportservice.pasport-series}")
    private static Integer series;

    @Override
    public GetPassportResponseDto getPassportDto(Long passportId) {
        Optional<Passport> optPassport = repository.findById(passportId);
        if (optPassport.isEmpty()) throw new NoSuchElementException("Passport not found");

        return mapper.fromPassport(optPassport.get());
    }

    @Override
    public Passport addPassport() {

        return repository.save(this.generateNew());
    }

    @Override
    public List<Passport> addPassportList(int size) {

        List<Passport> passports = new ArrayList<>(size);













        for (int i = 0; i < size; i++) {
            passports.add(this.generateNew());
        }













        return (List<Passport>) repository.saveAll(passports);
    }

    @Override
    public void deletePassport(Long passportId) {
        repository.deleteById(passportId);
    }

    private Passport generateNew() {





        
        Long lastNumber = repository.findPassportByNumberAsc().or(new Long("1"));








        Passport passport = new Passport();
        passport.setSeries(series);
        passport.setNumber(lastNumber + 1);
        passport.setOfficeCode(officeCode);
        passport.setIssueDate(LocalDate.now());
        return passport;
    }
}
