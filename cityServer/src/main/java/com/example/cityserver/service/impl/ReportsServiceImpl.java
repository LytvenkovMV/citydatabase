package com.example.cityserver.service.impl;

import com.example.cityserver.service.JxlsService;
import com.example.cityserver.service.ReportsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class ReportsServiceImpl implements ReportsService {

    private static final String PERSONS_FILE_PATH = "static/jxls/reports/persons_report.xlsx";
    private static final String HOUSES_FILE_PATH = "static/jxls/reports/houses_report.xlsx";
    private static final String CARS_FILE_PATH = "static/jxls/reports/cars_report.xlsx";
    private final JxlsService jxlsService;

    @Override
    public byte[] getPersonsReport() {
        jxlsService.generatePersonsReport();

        return getReportBytes(PERSONS_FILE_PATH);
    }

    @Override
    public byte[] getHousesReport() {
        jxlsService.generateHousesReport();

        return getReportBytes(HOUSES_FILE_PATH);
    }

    @Override
    public byte[] getCarsReport() {
        jxlsService.generateCarsReport();

        return getReportBytes(CARS_FILE_PATH);
    }

    private byte[] getReportBytes(String filePath) {
        Path path = null;
        byte[] bytes = new byte[]{};
        try {
            URL url = getClass().getClassLoader().getResource(filePath);
            if (url != null) {
                path = Paths.get(url.toURI());
            }
            if (path != null) {
                bytes = Files.readAllBytes(path);
            }
        } catch (URISyntaxException | IOException | NullPointerException e) {
            e.printStackTrace();

            throw new RuntimeException();
        }
        return bytes;
    }
}
