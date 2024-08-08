package com.example.bankserver.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddAccountRequestDto {

    @JsonProperty("person_id")
    private Long personId;

    @JsonProperty("init_balance")
    private Integer balance;
}
