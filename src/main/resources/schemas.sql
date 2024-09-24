create table users(
    id varchar(255) primary key ,
    name varchar(255) not null ,
    email varchar(255) not null
);
insert into users values ('1','Dara','Dara@.com');

create table products(
                      pro_id varchar(225) primary key ,
                      userId varchar(225) not null ,
                      pro_name varchar(255) not null ,
                      price double precision not null,
    foreign key (userId) references users (id) ON DELETE CASCADE
);
insert into products (pro_id,userId,pro_name,price) values (4,2 , 'Java' , '23');

create table if not exists orders (
    id SERIAL primary key ,
    buy varchar (255) not null
);
insert into orders values ('4','process');