create table users(
    id SERIAL primary key ,
    name varchar(255) not null ,
    email varchar(255) not null
);
insert into users values ('1','Dara','Dara@.com')