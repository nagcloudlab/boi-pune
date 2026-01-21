


create table accounts
(
    account_number          serial       primary key,
    account_holder_name  varchar(100) not null,
    balance     numeric(15, 2) default 0.00 not null,
    created_at  timestamp    default current_timestamp not null
);
insert into accounts (account_holder_name, balance) values
('Alice', 1000.00),
('Bob', 500.00),
('Charlie', 750.00);
select * from accounts;