package com.example.bankserver.controller;

import com.example.bankserver.dto.AddAccountRequestDto;
import com.example.bankserver.dto.GetAccountResponseDto;
import org.springframework.http.ResponseEntity;

public interface AccountController {

    ResponseEntity<GetAccountResponseDto> getAccount(Long accountId);

    ResponseEntity<GetAccountResponseDto> addAccount(AddAccountRequestDto dto);
}
