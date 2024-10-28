package com.example.cityserver.service.impl;

import com.example.cityserver.service.ReportsService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ReportsServiceImpl implements ReportsService {

    private static final String PERSONS_FILE_PATH = "static/image.jpeg";

    @Override
    public byte[] getPersonReport() {

        Path path;
        byte[] bytes;
        try {
            URL url = getClass().getClassLoader().getResource(PERSONS_FILE_PATH);
            path = Paths.get(url.toURI());
            bytes = Files.readAllBytes(path);
        } catch (URISyntaxException | IOException | NullPointerException e) {
            e.printStackTrace();

            throw new RuntimeException();
        }

        return bytes;
    }
}
