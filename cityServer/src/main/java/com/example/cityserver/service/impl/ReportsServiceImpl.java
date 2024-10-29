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
    private final JxlsService jxlsService;

    @Override
    public byte[] getPersonReport() {

        jxlsService.generatePersonsReport();

        Path path = null;
        byte[] bytes = new byte[]{};
        try {
            URL url = getClass().getClassLoader().getResource(PERSONS_FILE_PATH);
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
