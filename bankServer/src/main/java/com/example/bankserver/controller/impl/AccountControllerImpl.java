package com.example.bankserver.controller.impl;

import com.example.bankserver.client.PersonClient;
import com.example.bankserver.controller.AccountController;
import com.example.bankserver.dto.AddAccountRequestDto;
import com.example.bankserver.dto.GetAccountResponseDto;
import com.example.bankserver.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
public class AccountControllerImpl implements AccountController {

    private final PersonClient personClient;
    private final AccountService service;

    public ResponseEntity<GetAccountResponseDto> getAccount(@PathVariable(name = "id") Long accountId) {

        return ResponseEntity.ok(service.getAccount(accountId));
    }

    public ResponseEntity<GetAccountResponseDto> addAccount(@RequestBody AddAccountRequestDto dto) {

        ResponseEntity<String> clientResponse = personClient.getPerson(dto.getPersonId());
        if (!clientResponse.getStatusCode().is2xxSuccessful()) throw new NoSuchElementException("Person not found");

        return ResponseEntity.ok(service.addAccount(dto));
    }
}
