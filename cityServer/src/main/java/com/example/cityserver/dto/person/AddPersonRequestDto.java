package com.example.cityserver.dto.person;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddPersonRequestDto {

    @NotBlank
    @Pattern(regexp = "^[А-Я][а-я]{1,29}$")
    @JsonProperty("name")
    private String name;

    @NotBlank
    @Pattern(regexp = "^[А-Я][а-я]{1,39}$")
    @Size(min = 2, max = 50)
    @JsonProperty("surname")
    private String surname;

    @Pattern(regexp = "^[А-Я][а-я]{1,29}$")
    @JsonProperty("middlename")
    private String middlename;

    @Past
    @JsonProperty("birth_date")
    private LocalDate birthDate;

    @ArraySchema(minItems = 0, maxItems = 100, schema = @Schema(minimum = "1"))
    @JsonProperty("houses_id")
    private List<Long> housesId;
}
