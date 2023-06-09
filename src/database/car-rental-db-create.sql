-- create database and database-specific user

DROP DATABASE IF EXISTS `car-rental`;
CREATE DATABASE IF NOT EXISTS `car-rental`;
USE `car-rental`;
CREATE USER IF NOT EXISTS `super`@`%` IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON `car-rental`.* TO `super`@`%`;

-- create all tables

-- Table: authorities
CREATE TABLE authorities (
    username varchar(50)  NOT NULL,
    authority varchar(25)  NOT NULL
);

-- Table: cars
CREATE TABLE cars (
    car_id int(5)  NOT NULL AUTO_INCREMENT,
    type int(5)  NULL,
    name varchar(15)  NULL,
    model varchar(15)  NULL,
    color varchar(15)  NULL,
    location_id int(5)  NULL,
    transmission varchar(15)  NULL,
    price double(10,2)  NULL,
    seats int(5)  NULL,
    registration_number varchar(8)  NULL,
    service_date datetime  NULL,
    available bit  NOT NULL DEFAULT 1,
    CONSTRAINT cars_pk PRIMARY KEY (car_id)
);

-- Table: locations
CREATE TABLE locations (
    location_id int(5)  NOT NULL AUTO_INCREMENT,
    name varchar(15)  NOT NULL,
    phone varchar(13)  NOT NULL,
    CONSTRAINT locations_pk PRIMARY KEY (location_id)
);

-- Table: orders
CREATE TABLE orders (
    order_id int(5)  NOT NULL AUTO_INCREMENT,
    car_id int(5)  NULL,
    user_id int(5)  NULL,
    start_date datetime  NOT NULL,
    end_date datetime  NOT NULL,
    price double(10,2)  NULL,
    location_id int(5)  NULL,
    payment_type int(5)  NULL,
    payment_id int(5)  NULL,
    completed bit  not null default 0,
    active bit  not null default 0,
    CONSTRAINT orders_pk PRIMARY KEY (order_id)
);

-- Table: payments
CREATE TABLE payments (
    payment_id int(5)  NOT NULL AUTO_INCREMENT,
    date datetime  NOT NULL,
    price double(10,2)  NOT NULL,
    completed bit  not null default 0,
    CONSTRAINT payments_pk PRIMARY KEY (payment_id)
);

-- Table: users
CREATE TABLE users (
    user_id int  NOT NULL AUTO_INCREMENT,
    name varchar(15)  NULL,
    surname varchar(20)  NULL,
    username varchar(50)  NOT NULL,
    password varchar(68)  NOT NULL,
    phone varchar(13)  NULL,
    address varchar(100)  NULL,
    dob datetime  NULL,
    license_number varchar(8)  NULL,
    license_category varchar(2)  NULL,
    enabled bit  not null default 1,
    UNIQUE INDEX users_unique_keys (username),
    CONSTRAINT users_pk PRIMARY KEY (user_id)
);


-- add all foreign keys

-- Reference: authorities_users (table: authorities)
ALTER TABLE authorities ADD CONSTRAINT authorities_users FOREIGN KEY authorities_users (username)
    REFERENCES users (username);

-- Reference: cars_locations (table: cars)
ALTER TABLE cars ADD CONSTRAINT cars_locations FOREIGN KEY cars_locations (location_id)
    REFERENCES locations (location_id);

-- Reference: orders_cars (table: orders)
ALTER TABLE orders ADD CONSTRAINT orders_cars FOREIGN KEY orders_cars (car_id)
    REFERENCES cars (car_id);

-- Reference: orders_locations (table: orders)
ALTER TABLE orders ADD CONSTRAINT orders_locations FOREIGN KEY orders_locations (location_id)
    REFERENCES locations (location_id);

-- Reference: orders_payments (table: orders)
ALTER TABLE orders ADD CONSTRAINT orders_payments FOREIGN KEY orders_payments (payment_id)
    REFERENCES payments (payment_id);

-- Reference: orders_users (table: orders)
ALTER TABLE orders ADD CONSTRAINT orders_users FOREIGN KEY orders_users (user_id)
    REFERENCES users (user_id);

-- add baseline data
INSERT INTO locations (location_id, name, phone)
VALUES (1, 'Sofia', '0885123456');

INSERT INTO locations (location_id, name, phone)
VALUES (2, 'Ruse', '0885123456');

INSERT INTO locations (location_id, name, phone)
VALUES (3, 'Varna', '0885123465');

INSERT INTO users (user_id, name, surname, username, password, phone, address, dob, license_number,
                   license_category, enabled)
VALUES (1, 'admin', 'adminov', 'admin@gmail.com', '$2a$10$w6VAEGILgYJUTctlSRg2zeVvBDEl5N/68L3BPhl6gZJ36BbCT9FO6', '0885123456', 'Admin Headquarters', '1990-01-01 00:00:00',
        '12345678', 'B1', true);

INSERT INTO users (user_id, name, surname, username, password, phone, address, dob, license_number,
                   license_category, enabled)
VALUES (2, 'user', 'userov', 'user@gmail.com', '$2a$10$w6VAEGILgYJUTctlSRg2zeVvBDEl5N/68L3BPhl6gZJ36BbCT9FO6', '0885123456', 'User Headquarters', '1990-01-01 00:00:00',
        '12345678', 'B1', true);

INSERT INTO payments (payment_id, date, price, completed)
VALUES (1, '1990-01-01 00:00:00', 0, true);

INSERT INTO cars (car_id, type, name, model, color, location_id, transmission, price, seats,
                               registration_number, service_date, available)
VALUES (1, 3, 'Car', 'Temp', 'red', 1, 'Manual', 0, 1, '12345678', '1990-01-01 00:00:00', false);

INSERT INTO authorities (username, authority)
VALUES ('admin@gmail.com', 'ROLE_ADMIN');

INSERT INTO authorities (username, authority)
VALUES ('user@gmail.com', 'ROLE_USER');

