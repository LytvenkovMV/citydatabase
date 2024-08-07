package com.example.bankserver.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAccountResponseDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("person_id")
    private Long personId;

    @JsonProperty("curr_balance")
    private Integer balance;
}
