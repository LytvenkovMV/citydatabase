package com.example.cityserver.service;

public interface ReportsService {

    byte[] getPersonsReport();

    byte[] getHousesReport();

    byte[] getCarsReport();
}
