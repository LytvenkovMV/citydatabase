package com.example.cityserver.service.impl;

import com.example.cityserver.dto.passport.GetPassportResponseDto;
import com.example.cityserver.entity.Passport;
import com.example.cityserver.service.PassportService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
class PassportServiceImplIntegrationTest {

    @Autowired
    private PassportService service;

    private Long number = 1L;
    @Value("${cityserver.passportservice.office-code}")
    private String officeCode;

    @Value("${cityserver.passportservice.pasport-series}")
    private Integer series;

    @Test
    @DisplayName("Test the passport is get from database")
    void getPassportDto() {

        // when

        GetPassportResponseDto tested = service.getPassportDto(1L);

        // then
        assertEquals(1, tested.getNumber());
        assertEquals(1, tested.getSeries());
        assertEquals("1", tested.getOfficeCode());
        assertEquals("2000-01-01", tested.getIssueDate());
    }

    @Test
    @DisplayName("Test the new passport is generated and saved in database")
    void addPassport() {

        // when

        Passport tested = service.addPassport();

        // then

        assertEquals(number, tested.getNumber());
        assertEquals(series, tested.getSeries());
        assertEquals(officeCode, tested.getOfficeCode());
        assertEquals(LocalDate.now(), tested.getIssueDate());
    }
}
