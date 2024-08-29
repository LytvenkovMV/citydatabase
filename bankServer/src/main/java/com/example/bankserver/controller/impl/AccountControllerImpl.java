package com.example.bankserver.controller.impl;

import com.example.bankserver.client.PersonClient;
import com.example.bankserver.controller.AccountController;
import com.example.bankserver.dto.AddAccountRequestDto;
import com.example.bankserver.dto.GetAccountResponseDto;
import com.example.bankserver.service.AccountService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger logger = LoggerFactory.getLogger(AccountController.class);

    public ResponseEntity<GetAccountResponseDto> getAccount(@PathVariable(name = "id") Long accountId) {

        return ResponseEntity.ok(service.getAccount(accountId));
    }

    public ResponseEntity<GetAccountResponseDto> addAccount(@RequestBody AddAccountRequestDto dto) {
        try {
            personClient.getPerson(dto.getPersonId());
        } catch (FeignException e) {
            logger.error("Unable to add account. Person not found.");
            throw new NoSuchElementException("Person not found");
        }

        return ResponseEntity.ok(service.addAccount(dto));
    }
}
