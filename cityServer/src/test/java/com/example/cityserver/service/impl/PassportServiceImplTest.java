package com.example.cityserver.service.impl;

import com.example.cityserver.entity.Passport;
import com.example.cityserver.mapper.PassportMapper;
import com.example.cityserver.repository.PassportRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PassportServiceImplTest {

    @Mock
    private PassportRepository repository;

    @Mock
    private PassportMapper mapper;

    @InjectMocks
    private PassportServiceImpl service;

    @Value("${cityserver.passportservice.office-code}")
    private String officeCode;

    @Value("${cityserver.passportservice.pasport-series}")
    private Integer series;

    @Test
    void addPassport() {

        // given
        final long MAX_NUMBER = 777;


        Passport passport = new Passport();
        passport.setId(1L);
        passport.setNumber(MAX_NUMBER + 1);
        passport.setSeries(series);
        passport.setOfficeCode(officeCode);



        // when
        when(repository.findMaxNumber()).thenReturn(Optional.of(MAX_NUMBER));
        when(repository.save(any(Passport.class))).thenReturn(passport);

        Passport testedPassport = service.addPassport();



        // then
        assertEquals(MAX_NUMBER + 1, testedPassport.getNumber());
        assertEquals(series, testedPassport.getSeries());
        assertEquals(officeCode, testedPassport.getOfficeCode());
    }
}
