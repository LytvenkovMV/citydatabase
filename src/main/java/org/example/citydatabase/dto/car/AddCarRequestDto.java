package org.example.citydatabase.dto.car;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddCarRequestDto {

    @JsonProperty("gos_number")
    private String gosNumber;

    @JsonProperty("brand")
    private String brand;

    @JsonProperty("model")
    private String model;

    @JsonProperty("color")
    private String color;

    @JsonProperty("owner_id")
    private Long personId;
}
