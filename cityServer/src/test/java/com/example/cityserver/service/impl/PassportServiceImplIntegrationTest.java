package com.example.cityserver.service.impl;

import com.example.cityserver.entity.Passport;
import com.example.cityserver.repository.PassportRepository;
import com.example.cityserver.service.PassportService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
class PassportServiceImplIntegrationTest {

    @Autowired
    private PassportRepository repository;

    @Autowired
    private PassportService service;

    private Long number = 0L;
    @Value("${cityserver.passportservice.office-code}")
    private String officeCode;

    @Value("${cityserver.passportservice.pasport-series}")
    private Integer series;

    @Test
    @DisplayName("Test the new passport is generated and saved")
    void addPassport() {

        // when

        Passport tested = service.addPassport();
        Passport actual = repository.findById(tested.getId()).orElseThrow(NoSuchElementException::new);

        // then

        assertEquals(number, actual.getNumber());
        assertEquals(series, actual.getSeries());
        assertEquals(officeCode, actual.getOfficeCode());
    }
}
