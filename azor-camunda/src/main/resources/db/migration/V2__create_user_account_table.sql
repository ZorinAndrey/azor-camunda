CREATE TABLE user_account
(
    id       bigserial   not null,
    username varchar(50) not null,
    email    varchar(50) not null,
    money    numeric(9, 2) not null default 0.00,
    constraint pk_user_account_id primary key (id)
);