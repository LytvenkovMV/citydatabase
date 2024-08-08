package com.example.bankserver.controller.impl;

import com.example.bankserver.controller.AccountController;
import com.example.bankserver.dto.AddAccountRequestDto;
import com.example.bankserver.dto.GetAccountResponseDto;
import com.example.bankserver.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("bank/api/accounts")
@RequiredArgsConstructor
public class AccountControllerImpl implements AccountController {

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
