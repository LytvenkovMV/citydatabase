package com.example.bankserver.service.impl;

import com.example.bankserver.dto.AddAccountRequestDto;
import com.example.bankserver.dto.GetAccountResponseDto;
import com.example.bankserver.entity.Account;
import com.example.bankserver.kafka.PersonsMessagingService;
import com.example.bankserver.repository.AccountRepository;
import com.example.bankserver.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final PersonsMessagingService messagingService;
    private final AccountRepository repository;
    private final Logger logger = LoggerFactory.getLogger(AccountService.class);

    @Override
    public GetAccountResponseDto addAccount(AddAccountRequestDto dto) {

        Account a = new Account();
        a.setPersonId(dto.getPersonId());
        a.setBalance(dto.getBalance());

        a = repository.insert(a);
        logger.info("Account successfully added.");

        GetAccountResponseDto responseDto = new GetAccountResponseDto();
        responseDto.setId(a.getId());
        responseDto.setPersonId(a.getPersonId());
        responseDto.setBalance(a.getBalance());

        return responseDto;
    }

    @Override
    public void addAccountList(Long[] personIds) {
        List<Account> accounts = Arrays.stream(personIds)
                .map(id -> {
                    Account a = new Account();
                    a.setPersonId(id);
                    a.setBalance(500);
                    return a;
                })
                .toList();
        try {
            repository.insertAll(accounts);
            logger.info("Account list successfully added.");
        } catch (Exception e) {
            repository.deleteAll(accounts.stream()
                    .map(Account::getPersonId)
                    .toList());

            messagingService.sendPersons(personIds);
            logger.error("Unable to add account list. Rollback request!");

            throw new RuntimeException(e);
        }
    }

    @Override
    public GetAccountResponseDto getAccount(Long id) {

        Account a = repository.find(id);
        GetAccountResponseDto dto = new GetAccountResponseDto();
        dto.setId(a.getId());
        dto.setPersonId(a.getPersonId());
        dto.setBalance(a.getBalance());

        return dto;
    }
}
