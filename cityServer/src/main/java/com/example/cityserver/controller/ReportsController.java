package com.example.cityserver.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Tag(name = "API для файловых отчетов")
public interface ReportsController {

    @Operation(summary = "Получить список всех машин в виде excel файла")
    @RequestMapping("city/api/reports/persons")
    ResponseEntity<ByteArrayResource> getPersonsReport();
}
