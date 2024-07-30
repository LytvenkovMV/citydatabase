package org.example.citydatabase.dto.person;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @JsonProperty("houses_id")
    private List<Long> housesId;
}
