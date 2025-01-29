package com.example.cityserver.service.impl;

import com.example.cityserver.entity.Passport;
import com.example.cityserver.repository.PassportRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PassportServiceImplUnitTest {

    @Mock
    private PassportRepository repository;

    @InjectMocks
    private PassportServiceImpl service;

    @Value("${cityserver.passportservice.office-code}")
    private String officeCode;

    @Value("${cityserver.passportservice.pasport-series}")
    private Integer series;

    private static final long MAX_NUMBER = 777;
    private Passport passport;

    @BeforeEach
    void init() {
        passport = new Passport();
        passport.setId(1L);
        passport.setNumber(MAX_NUMBER + 1);
        passport.setSeries(series);
        passport.setOfficeCode(officeCode);
    }

    @Test
    @DisplayName("Test the new passport is generated and saved with  max number from DB")
    void addPassport() {

        // when
        when(repository.findMaxNumber()).thenReturn(Optional.of(MAX_NUMBER));
        when(repository.save(any(Passport.class))).thenReturn(passport);

        Passport testedPassport = service.addPassport();

        // then
        verify(repository).findMaxNumber();
        verify(repository).save(any(Passport.class));
        assertEquals(MAX_NUMBER + 1, testedPassport.getNumber());
        assertEquals(series, testedPassport.getSeries());
        assertEquals(officeCode, testedPassport.getOfficeCode());
    }
}
