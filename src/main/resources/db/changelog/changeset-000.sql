-- liquibase formatted sql

-- changeset create-employee:1
create table trackers (
    id int primary key,
    name varchar(30) not null unique,
    url varchar(100),
    url_type varchar(10),
    headers varchar(100),
    params varchar(100),
    body varchar(100),
    login_url varchar(100)
)