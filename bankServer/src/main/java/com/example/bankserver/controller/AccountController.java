package com.example.bankserver.controller;

import com.example.bankserver.dto.AddAccountRequestDto;
import com.example.bankserver.dto.GetAccountResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AccountController {

    @GetMapping("bank/api/accounts/{id}")
    ResponseEntity<GetAccountResponseDto> getAccount(@PathVariable(name = "id") Long accountId);

    @PostMapping("bank/api/accounts")
    ResponseEntity<GetAccountResponseDto> addAccount(@RequestBody AddAccountRequestDto dto);
}
