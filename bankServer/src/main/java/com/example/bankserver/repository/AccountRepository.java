package com.example.bankserver.repository;

import com.example.bankserver.entity.Account;
import com_2fexample_2fbankserver_2fjook.tables.Accounts;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AccountRepository {

    private final DSLContext dsl;
    private final Accounts accounts = Accounts.ACCOUNTS;

    public Account insert(Account account) {

        return dsl
                .insertInto(accounts)
                .set(dsl.newRecord(accounts, account))
                .returning()
                .fetchOne()
                .into(Account.class);
    }

    public void insertAll(List<Account> accounts) {

        for (Account a : accounts) this.insert(a);
    }

    public Account find(Long id) {

        return dsl
                .select(accounts.ID, accounts.PERSON_ID, accounts.BALANCE)
                .from(accounts)
                .where(accounts.ID.eq(id.intValue()))
                .fetchAny()
                .into(Account.class);
    }
}
