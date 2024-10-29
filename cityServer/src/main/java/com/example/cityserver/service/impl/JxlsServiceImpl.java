package com.example.cityserver.service.impl;

import com.example.cityserver.entity.Person;
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

    private static final String TEMPLATES_FILE_PATH = "cityServer/src/main/resources/static/jxls/templates/";
    private static final String REPORTS_FILE_PATH = "cityServer/src/main/resources/static/jxls/reports/";
    private final PersonRepository personRepository;

    @Override
    public void generatePersonsReport() {

        Iterable<Person> persons = personRepository.findAll();

        Map<String, Object> data = new HashMap<>();
        data.put("persons", persons);

        try {
            JxlsPoiTemplateFillerBuilder.newInstance()
                    .withTemplate(TEMPLATES_FILE_PATH + "persons_template.xlsx")
                    .build()
                    .fill(data, new JxlsOutputFile(new File(REPORTS_FILE_PATH + "persons_report.xlsx")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();

            throw new RuntimeException(e);
        }
    }
}
