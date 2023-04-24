-- tables

-- Table: authorities
CREATE TABLE authorities (
    username varchar(50)  NOT NULL,
    authority varchar(25)  NOT NULL
);

-- Table: cars
CREATE TABLE cars (
    car_id int(5)  NOT NULL AUTO_INCREMENT,
    type int(5)  NOT NULL,
    name varchar(15)  NOT NULL,
    model varchar(15)  NOT NULL,
    color varchar(15)  NOT NULL,
    location_id int(5)  NULL,
    transmission varchar(15)  NOT NULL,
    price double(10,2)  NOT NULL,
    seats int(5)  NOT NULL,
    registration_number varchar(8)  NOT NULL,
    car_picture blob NULL,
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
    price double(10,2)  NOT NULL,
    location_id int(5)  NULL,
    payment_type int(5)  NOT NULL,
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
    name varchar(15)  NOT NULL,
    surname varchar(20)  NOT NULL,
    email varchar(50)  NOT NULL,
    password varchar(68)  NOT NULL,
    phone varchar(13)  NOT NULL,
    address varchar(100)  NOT NULL,
    dob datetime  NULL,
    license_number varchar(8)  NOT NULL,
    license_category varchar(2)  NOT NULL,
    blocked bit  not null default 0,
    UNIQUE INDEX users_unique_keys (email),
    CONSTRAINT users_pk PRIMARY KEY (user_id)
);


-- foreign keys

-- Reference: authorities_users (table: authorities)
ALTER TABLE authorities ADD CONSTRAINT authorities_users FOREIGN KEY authorities_users (username)
    REFERENCES users (email);

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

-- Temps added
INSERT INTO `car-rental`.locations (location_id, name, phone)
VALUES (1, 'Sofia', '0885123456');

INSERT INTO `car-rental`.locations (location_id, name, phone)
VALUES (2, 'Ruse', '0885123456');

INSERT INTO `car-rental`.locations (location_id, name, phone)
VALUES (3, 'Varna', '0885123465');

INSERT INTO `car-rental`.users (user_id, name, surname, email, password, phone, address, dob, license_number,
                                license_category, blocked)
VALUES (1, 'temp', 'temp', 'temp@gmail.com', '123456789', '0123456789', 'Temp Address', '1990-01-01 00:00:00',
        '12345678', 'B1', true);

INSERT INTO `car-rental`.payments (payment_id, date, price, completed)
VALUES (1, '1990-01-01 00:00:00', 0, true);

INSERT INTO `car-rental`.cars (car_id, type, name, model, color, location_id, transmission, price, seats,
                               registration_number, car_picture, service_date, available)
VALUES (1, 3, 'Temp', 'Temp', 'red', 1, 'Manual', 0, 1, '12345678', null, '1990-01-01 00:00:00', false);

