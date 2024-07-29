package org.example.citydatabase.service;

import org.example.citydatabase.entity.Passport;

public interface PassportService {

    Passport addPassport();

    void deletePassport(Long passportId);
}
