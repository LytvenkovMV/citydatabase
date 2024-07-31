package org.example.citydatabase.dto.person;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.citydatabase.dto.car.GetCarResponseDto;
import org.example.citydatabase.dto.house.GetHouseResponseDto;
import org.example.citydatabase.dto.passport.GetPassportResponseDto;

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
