package org.example.citydatabase.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddPersonRequestDto {
    @JsonProperty("name")
    private String name;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("middlename")
    private String middlename;

    @JsonProperty("birth_date")
    private String birthDate;

    @JsonProperty("passport_number")
    private Integer passportNumber;

    @JsonProperty("passport_code")
    private Integer passportOfficeCode;

    @JsonProperty("passport_date")
    private String passportIssueDate;

    @JsonProperty("houses_id")
    private Long[] housesId;
}
