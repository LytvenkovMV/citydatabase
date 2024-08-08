package com.example.bankserver.repository;

import com.example.bankserver.entity.Account;
import com_2fexample_2fbankserver_2fjook.tables.Accounts;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AccountRepository {

    private final DSLContext dsl;

    public Account insert(Account account) {

        return null;

    }

    public Account find(Long id) {
        Accounts accounts = Accounts.ACCOUNTS;

        Account acc = (Account) dsl
                .select(accounts.ID, accounts.PERSON_ID, accounts.BALANCE)
                .from(accounts)
                .fetch();

        return acc;
    }
}
