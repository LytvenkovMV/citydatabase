package org.example.citydatabase.service;

import lombok.RequiredArgsConstructor;
import org.example.citydatabase.entity.Passport;
import org.example.citydatabase.repository.PassportRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class PassportServiceImpl implements PassportService {

    private final PassportRepository repository;

    @Value("${citydatabase.passportservice.office-code}")
    private String officeCode;

    @Value("${citydatabase.passportservice.pasport-series}")
    private Integer series;

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
