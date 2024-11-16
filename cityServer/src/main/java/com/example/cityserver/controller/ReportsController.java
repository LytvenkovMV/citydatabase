package com.example.cityserver.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "API для файловых отчетов")
public interface ReportsController {

    @Operation(summary = "Получить список всех жителей в виде excel файла")
    @RequestMapping("city/api/reports/persons")
    ResponseEntity<ByteArrayResource> getPersonsReport();

    @Operation(summary = "Получить список всех домов в виде excel файла")
    @RequestMapping("city/api/reports/houses")
    ResponseEntity<ByteArrayResource> getHousesReport();

    @Operation(summary = "Получить список всех машин в виде excel файла")
    @RequestMapping("city/api/reports/cars")
    ResponseEntity<ByteArrayResource> getCarsReport();
}
