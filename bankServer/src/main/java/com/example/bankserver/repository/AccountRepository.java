package com.example.bankserver.repository;

import com.example.bankserver.entity.Account;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AccountRepository {

    private final DSLContext dsl;

    public Account insert(Account account) {
//        return dsl.insertInto(Accounts.ACCOUNTS)
//                .set(dsl.newRecord(Accounts.ACCOUNTS, account))
//                .returning()
//                .fetchOne()
//                .into(Account.class);

        return null;
    }

    public Account find(Long id) {
//        return dsl.selectFrom(Accounts.ACCOUNTS)
//                .where(Accounts.ACCOUNTS.ID.eq(id))
//                .fetchAny()
//                .into(Account.class);

        return null;
    }
}
