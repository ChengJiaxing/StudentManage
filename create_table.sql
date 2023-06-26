create schema StudentDB;
create table StudentDB.student
(
    id           int auto_increment
        primary key,
    student_id   mediumtext   not null,
    name         varchar(50)  null,
    gender       varchar(10)  null,
    phone_number varchar(20)  null,
    email        varchar(50)  null,
    address      varchar(100) null,
    class_name   varchar(50)  null,
    grade        varchar(10)  null,
    major        varchar(50)  null,
    counselor    varchar(50)  null,
    constraint student_id_uindex
        unique (id)
);

create table StudentDB.user
(
    id       int auto_increment
        primary key,
    username varchar(50)  not null,
    password varchar(100) not null,
    constraint username
        unique (username)
);

