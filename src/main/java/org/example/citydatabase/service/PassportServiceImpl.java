package org.example.citydatabase.service;

import lombok.RequiredArgsConstructor;
import org.example.citydatabase.entity.Passport;
import org.example.citydatabase.repository.PassportRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class PassportServiceImpl implements PassportService {

    private final PassportRepository repository;

    @Value("${citydatabase.passportservice.office-code}")
    private String officeCode;

    @Override
    public Passport addPassport() {








        Passport passport = new Passport();
        passport.setIssueDate((new Date()));
        passport.setOfficeCode(officeCode);
        /////////////passport.setNumber(456666666666666666666666);
        repository.save(passport);
















        return passport;
    }

    @Override
    public void deletePassport(Long passportId) {
        repository.deleteById(passportId);
    }
}
