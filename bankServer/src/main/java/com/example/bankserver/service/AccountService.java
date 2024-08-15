package com.example.bankserver.service;

import com.example.bankserver.dto.AddAccountRequestDto;
import com.example.bankserver.dto.GetAccountResponseDto;

public interface AccountService {

    GetAccountResponseDto addAccount(AddAccountRequestDto dto);

    GetAccountResponseDto getAccount(Long id);
}
