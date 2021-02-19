create table if not exists persons
(
    id int auto_increment
    primary key,
    firstName varchar(50) null,
    lastName varchar(50) null,
    street varchar(50) null,
    city varchar(50) null,
    postal_code varchar(50) null,
    birthday varchar(50) null,
    image varchar(50) null
    );