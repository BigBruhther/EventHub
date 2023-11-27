create database concertdb;
use concertdb;

create table User(
    userID int primary key auto_increment,
    name varchar(255) not null,
    email varchar(255) not null,
    password varchar(255) not null
);

create table Artist(
    artistID int primary key,
    name varchar(255) not null,
    genre varchar(255) not null
);

create table Concert(
    name varchar(255) primary key,
    cDate date,
    price int
);

create table Venue(
    vId int primary key,
    address varchar(255),
    vName varchar(255)
);

-- Add more SQL code here or alter as needed.

select * from User;
