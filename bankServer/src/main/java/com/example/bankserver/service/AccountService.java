package com.example.bankserver.service;

import com.example.bankserver.dto.AddAccountRequestDto;
import com.example.bankserver.dto.GetAccountResponseDto;

import java.util.List;

public interface AccountService {

    GetAccountResponseDto addAccount(AddAccountRequestDto dto);

    void addAccountList(List<Integer> personIds);

    GetAccountResponseDto getAccount(Long id);
}
