create table accounts
(
    id        bigserial primary key,
    person_id bigint,
    balance   bigint
);