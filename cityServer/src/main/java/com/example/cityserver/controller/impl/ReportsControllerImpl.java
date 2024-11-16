package com.example.cityserver.controller.impl;

import com.example.cityserver.controller.ReportsController;
import com.example.cityserver.service.ReportsService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReportsControllerImpl implements ReportsController {

    private final ReportsService service;

    @Override
    public ResponseEntity<ByteArrayResource> getPersonsReport() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=persons.xlsx");

        byte[] bytes = service.getPersonsReport();

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(bytes.length)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new ByteArrayResource(bytes));
    }

    @Override
    public ResponseEntity<ByteArrayResource> getHousesReport() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=houses.xlsx");

        byte[] bytes = service.getHousesReport();

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(bytes.length)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new ByteArrayResource(bytes));
    }

    @Override
    public ResponseEntity<ByteArrayResource> getCarsReport() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=cars.xlsx");

        byte[] bytes = service.getCarsReport();

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(bytes.length)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new ByteArrayResource(bytes));
    }
}
