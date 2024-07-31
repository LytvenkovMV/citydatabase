package org.example.citydatabase.dto.passport;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class GetPassportResponseDto {

    @JsonProperty("passport_id")
    private Long id;

    @JsonProperty("passport_series")
    private Integer series;

    @JsonProperty("passport_number")
    private Long number;

    @JsonProperty("passport_office_code")
    private String officeCode;

    @JsonProperty("passport_issue_date")
    private Date issueDate;
}
