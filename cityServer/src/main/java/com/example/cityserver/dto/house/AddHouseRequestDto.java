package com.example.cityserver.dto.house;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddHouseRequestDto {

    @Positive
    @Min(1)
    @Max(9999)
    @JsonProperty("cadastr_number")
    private Integer cadastrNumber;

    @NotEmpty
    @Size(min = 5, max = 150)
    @JsonProperty("address")
    private String address;

    @PositiveOrZero
    @JsonProperty("cadastr_price")
    private BigDecimal cadastrPrice;

    @ArraySchema(minItems = 0, maxItems = 100, schema = @Schema(minimum = "1"))
    @JsonProperty("persons_id")
    private List<Long> personsId;
}
