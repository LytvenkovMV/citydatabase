package com.example.cityserver.dto.car;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddCarRequestDto {

    @NotBlank
    @Pattern(regexp = "^[А-Х][0-9]{3}(?<!0{3})[А-Х]{2}[0-9]{2,3}$")
    @JsonProperty("gos_number")
    private String gosNumber;

    @NotBlank
    @JsonProperty("brand")
    private String brand;

    @NotBlank
    @JsonProperty("model")
    private String model;

    @NotBlank
    @JsonProperty("color")
    private String color;

    @Positive
    @JsonProperty("owner_id")
    private Long personId;
}
