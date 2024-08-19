package com.example.cityserver.dto.person;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.cityserver.dto.car.GetCarResponseDto;
import com.example.cityserver.dto.house.GetHouseResponseDto;
import com.example.cityserver.dto.passport.GetPassportResponseDto;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetPersonResponseDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("middlename")
    private String middlename;

    @JsonProperty("birth_date")
    private String birthDate;

    @JsonProperty("passport")
    private GetPassportResponseDto passport;

    @JsonProperty("cars")
    private List<GetCarResponseDto> cars;

    @JsonProperty("houses")
    private List<GetHouseResponseDto> houses;
}
