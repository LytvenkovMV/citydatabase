package com.example.bankserver.entity;

import lombok.Data;

@Data
public class Account {

    private Long id;
    private Long personId;
    private Integer balance;
}
