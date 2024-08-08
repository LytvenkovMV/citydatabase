package com.example.bankserver.controller;

import com.example.bankserver.dto.AddAccountRequestDto;
import com.example.bankserver.dto.GetAccountResponseDto;
import com.example.bankserver.entity.Account;
import com.example.bankserver.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("bank/api/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService service;

    @GetMapping("/{id}")
    public ResponseEntity<GetAccountResponseDto> getAccount(@PathVariable(name = "id") Long accountId) {

        return ResponseEntity.ok(service.getAccount(accountId));
    }

    @PostMapping
    public ResponseEntity<GetAccountResponseDto> addAccount(@RequestBody AddAccountRequestDto dto) {
        Long id = service.addAccount(dto);

        return ResponseEntity.ok(service.getAccount(id));
    }
}
