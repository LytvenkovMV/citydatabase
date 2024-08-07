package com.example.bankserver.service;

import com.example.bankserver.dto.AddAccountRequestDto;
import com.example.bankserver.dto.GetAccountResponseDto;

public interface AccountService {

    Long addAccount(AddAccountRequestDto dto);

    GetAccountResponseDto getAccount(Long id);
}
