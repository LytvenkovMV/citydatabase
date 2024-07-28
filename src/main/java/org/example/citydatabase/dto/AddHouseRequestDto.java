package org.example.citydatabase.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddHouseRequestDto {

    @JsonProperty("cadastr_number")
    private Integer cadastrNumber;

    @JsonProperty("address")
    private String address;

    @JsonProperty("cadastr_price")
    private BigDecimal cadastrPrice;

    @JsonProperty("persons_id")
    private Long[] personsId;
}
