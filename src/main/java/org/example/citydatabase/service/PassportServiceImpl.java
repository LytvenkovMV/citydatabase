package org.example.citydatabase.service;

import lombok.RequiredArgsConstructor;
import org.example.citydatabase.dto.passport.GetPassportResponseDto;
import org.example.citydatabase.entity.Passport;
import org.example.citydatabase.entity.Person;
import org.example.citydatabase.mapper.PassportMapper;
import org.example.citydatabase.repository.PassportRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PassportServiceImpl implements PassportService {

    private final PassportRepository repository;
    private final PassportMapper mapper;

    @Value("${citydatabase.passportservice.office-code}")
    private String officeCode;

    @Value("${citydatabase.passportservice.pasport-series}")
    private Integer series;

    @Override
    public GetPassportResponseDto getPassportDto(Long passportId) {
        Optional<Passport> optPassport = repository.findById(passportId);
        if (optPassport.isEmpty()) throw new NoSuchElementException("Passport not found");

        return mapper.fromPassport(optPassport.get());
    }

    @Override
    public Passport addPassport() {
        Passport passport = new Passport();
        passport.setSeries(series);
        passport.setOfficeCode(officeCode);
        passport.setIssueDate((new Date()));

        repository.save(passport);

        return passport;
    }

    @Override
    public void deletePassport(Long passportId) {
        repository.deleteById(passportId);
    }
}
