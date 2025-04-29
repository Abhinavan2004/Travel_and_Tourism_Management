create database Travel_And_Tourism_Management_DB ;

use Travel_And_Tourism_Management_DB  ;

show tables ;

create table customer (username varchar(20), 
                       id int , 
					   id_number int , 
                       name varchar(40), 
                       gender varchar(10), 
                       country varchar(20) , 
                       address varchar(40) , 
                       contact_no varchar(20), 
                       email varchar(20)) ;
select * from customer ;


CREATE TABLE account (
    username VARCHAR(50) PRIMARY KEY,
    name VARCHAR(100),
    password VARCHAR(100),
    security VARCHAR(255),
    answer VARCHAR(100),
    contact_no varchar(20)
);





CREATE TABLE bookpackage (
    username VARCHAR(50) NOT NULL,
    package VARCHAR(100),
    persons INT,
    id VARCHAR(50),
    id_number VARCHAR(50),
    contact_no VARCHAR(20),
    price VARCHAR(20)
);



CREATE TABLE hotelpackage (
    username VARCHAR(50) NOT NULL,
    hotelname VARCHAR(100),
    persons INT,
    no_days INT,
    food VARCHAR(20),
    ac_nac VARCHAR(20),
    id VARCHAR(50),
    id_number VARCHAR(50),
    contact_no VARCHAR(20),
    price VARCHAR(20)
);


                           