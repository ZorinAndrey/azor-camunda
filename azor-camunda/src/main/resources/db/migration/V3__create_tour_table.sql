create table tour
(
    id      bigserial primary key,
    user_id bigint not null references user_account (id)
);