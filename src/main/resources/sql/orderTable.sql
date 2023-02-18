create table orders(
    id varchar(32) primary key,
    price float(10) not null,
    status int(2) not null,
    request_user_id varchar(32) not null,
    accept_user_id varchar(32) not null
);
