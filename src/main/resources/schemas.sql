create table users(
<<<<<<< HEAD
    id varchar(255) primary key ,
=======
    id SERIAL primary key ,
>>>>>>> bfa91f78b39852771aef21e2b289256caef1a25a
    name varchar(255) not null ,
    email varchar(255) not null
);
insert into users values ('1','Dara','Dara@.com');

create table products(
<<<<<<< HEAD
                      pro_id varchar(225) primary key ,
                      userId varchar(225) not null ,
                      pro_name varchar(255) not null ,
                      price double precision not null,
    foreign key (userId) references users (id) ON DELETE CASCADE
);
insert into products (pro_id,userId,pro_name,price) values (4,2 , 'Java' , '23');
=======
                      pro_id SERIAL primary key ,
                      userId INTEGER not null ,
                      pro_name varchar(255) not null ,
                      price double precision not null,
    foreign key (userId) references users (id)
);
insert into products values ('3','1','Water','0.5');
>>>>>>> bfa91f78b39852771aef21e2b289256caef1a25a

create table if not exists orders (
    id SERIAL primary key ,
    buy varchar (255) not null
);
insert into orders values ('4','process');