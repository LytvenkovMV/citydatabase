package com.example.bankserver.service.impl;

import com.example.bankserver.dto.AddAccountRequestDto;
import com.example.bankserver.dto.GetAccountResponseDto;
import com.example.bankserver.entity.Account;
import com.example.bankserver.repository.AccountRepository;
import com.example.bankserver.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;

    @Override
    public GetAccountResponseDto addAccount(AddAccountRequestDto dto) {

        Account a = new Account();
        a.setPersonId(dto.getPersonId());
        a.setBalance(dto.getBalance());

        a = repository.insert(a);

        GetAccountResponseDto responseDto = new GetAccountResponseDto();
        responseDto.setId(a.getId());
        responseDto.setPersonId(a.getPersonId());
        responseDto.setBalance(a.getBalance());

        return responseDto;
    }

    @Override
    public void addAccountList(List<Integer> personIds) {

        try {
            List<Account> accounts = personIds.stream()
                    .map(id -> {
                        Account a = new Account();
                        a.setPersonId(Integer.toUnsignedLong(id));
                        a.setBalance(500);
                        return a;
                    })
                    .toList();

            repository.insertAll(accounts);
        } catch (Exception e) {
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
