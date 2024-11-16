package com.example.cityserver.service.impl;

import com.example.cityserver.entity.Car;
import com.example.cityserver.entity.House;
import com.example.cityserver.entity.Person;
import com.example.cityserver.repository.CarRepository;
import com.example.cityserver.repository.HouseRepository;
import com.example.cityserver.repository.PersonRepository;
import com.example.cityserver.service.JxlsService;
import lombok.RequiredArgsConstructor;
import org.jxls.builder.JxlsOutputFile;
import org.jxls.transform.poi.JxlsPoiTemplateFillerBuilder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class JxlsServiceImpl implements JxlsService {

    private static final String PERSONS_TEMPLATE_FILE_PATH = "cityServer/src/main/resources/static/jxls/templates/persons_template.xlsx";
    private static final String HOUSES_TEMPLATE_FILE_PATH = "cityServer/src/main/resources/static/jxls/templates/houses_template.xlsx";
    private static final String CARS_TEMPLATE_FILE_PATH = "cityServer/src/main/resources/static/jxls/templates/cars_template.xlsx";
    private static final String PERSONS_REPORT_FILE_PATH = "cityServer/src/main/resources/static/jxls/reports/persons_report.xlsx";
    private static final String HOUSES_REPORT_FILE_PATH = "cityServer/src/main/resources/static/jxls/reports/houses_report.xlsx";
    private static final String CARS_REPORT_FILE_PATH = "cityServer/src/main/resources/static/jxls/reports/cars_report.xlsx";
    private final PersonRepository personRepository;
    private final HouseRepository houseRepository;
    private final CarRepository carRepository;

    @Override
    public void generatePersonsReport() {
        Map<String, Object> data = new HashMap<>();
        Iterable<Person> persons = personRepository.findAll();
        data.put("persons", persons);

        generateReport(data, PERSONS_TEMPLATE_FILE_PATH, PERSONS_REPORT_FILE_PATH);
    }

    @Override
    public void generateHousesReport() {
        Map<String, Object> data = new HashMap<>();
        Iterable<House> houses = houseRepository.findAll();
        data.put("houses", houses);

        generateReport(data, HOUSES_TEMPLATE_FILE_PATH, HOUSES_REPORT_FILE_PATH);
    }

    @Override
    public void generateCarsReport() {
        Map<String, Object> data = new HashMap<>();
        Iterable<Car> cars = carRepository.findAll();
        data.put("cars", cars);

        generateReport(data, CARS_TEMPLATE_FILE_PATH, CARS_REPORT_FILE_PATH);
    }

    private static void generateReport(Map<String, Object> data, String templatePath, String reportPath) {
        try {
            JxlsPoiTemplateFillerBuilder.newInstance()
                    .withTemplate(templatePath)
                    .build()
                    .fill(data, new JxlsOutputFile(new File(reportPath)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();

            throw new RuntimeException(e);
        }
    }
}
