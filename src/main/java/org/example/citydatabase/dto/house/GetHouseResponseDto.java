package org.example.citydatabase.dto.house;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetHouseResponseDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("cadastr_number")
    private Integer cadastrNumber;

    @JsonProperty("address")
    private String address;

    @JsonProperty("cadastr_price")
    private BigDecimal cadastrPrice;

    @JsonProperty("owners")
    private List<Long> personIds;
}
