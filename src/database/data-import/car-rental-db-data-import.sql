use `car-rental`;

-- Dummy Data Import for Table Locations

INSERT INTO `locations` (`location_id`, `name`, `phone`)
VALUES
    (4, 'Burgas', '0885123456'),
    (5, 'Pleven', '0885123456');

-- Dummy Data Import for Table Users

INSERT INTO `users` (`user_id`, `name`, `surname`, `username`, `password`, `phone`, `address`, `dob`, `license_number`,
                   `license_category`, `enabled`)
VALUES
    (3, 'Vevay', 'Heinreich', 'vheinreich2@aol.com', '$2a$10$w6VAEGILgYJUTctlSRg2zeVvBDEl5N/68L3BPhl6gZJ36BbCT9FO6', '0885123456', '38750 Jenna Street', '1987-11-10 19:28:49', 86016243, 'A2', true),
    (4, 'Barnett', 'Staig', 'bstaig3@tinypic.com', '$2a$10$w6VAEGILgYJUTctlSRg2zeVvBDEl5N/68L3BPhl6gZJ36BbCT9FO6', '0885123456', '07212 American Ash Center', '1961-01-24 10:39:05', 20226825, 'B1', true),
    (5, 'Kenna', 'Gutman', 'kgutman4@issuu.com', '$2a$10$w6VAEGILgYJUTctlSRg2zeVvBDEl5N/68L3BPhl6gZJ36BbCT9FO6', '0885123456', '926 Twin Pines Park', '1993-01-06 19:57:42', 668307, 'C', true),
    (6, 'Randy', 'Hildrew', 'rhildrew5@pen.io', '$2a$10$w6VAEGILgYJUTctlSRg2zeVvBDEl5N/68L3BPhl6gZJ36BbCT9FO6', '0885123456', '9067 International Place', '1996-02-27 04:47:56', 89468728, 'A2', true),
    (7, 'Egbert', 'Estevez', 'eestevez6@fotki.com', '$2a$10$w6VAEGILgYJUTctlSRg2zeVvBDEl5N/68L3BPhl6gZJ36BbCT9FO6', '0885123456', '81563 Welch Avenue', '1983-01-21 14:17:39', 91930231, 'B2', true),
    (8, 'Lula', 'Neilson', 'lneilson7@oaic.gov.au', '$2a$10$w6VAEGILgYJUTctlSRg2zeVvBDEl5N/68L3BPhl6gZJ36BbCT9FO6', '0885123456', '729 Sachs Street', '1979-09-23 20:05:10', 75757104, 'C', true),
    (9, 'Tabbatha', 'De Vere', 'tdevere8@booking.com', '$2a$10$w6VAEGILgYJUTctlSRg2zeVvBDEl5N/68L3BPhl6gZJ36BbCT9FO6', '0885123456', '19361 Arizona Court', '1982-10-26 05:01:21', 88687040, 'A1', true),
    (10, 'Allie', 'Ortega', 'aortega9@intel.com', '$2a$10$w6VAEGILgYJUTctlSRg2zeVvBDEl5N/68L3BPhl6gZJ36BbCT9FO6', '0885123456', '94408 Dorton Trail', '1995-04-03 06:09:30', 50454972, 'B2', true),
    (11, 'Boyd', 'Casetta', 'bcasetta0@google.it', '$2a$10$w6VAEGILgYJUTctlSRg2zeVvBDEl5N/68L3BPhl6gZJ36BbCT9FO6', '0885123456', '08010 Pierstorff Avenue', '1975-04-30 19:43:31', 59736211, 'C', true),
    (12, 'Clemmie', 'Fisby', 'cfisby1@latimes.com', '$2a$10$w6VAEGILgYJUTctlSRg2zeVvBDEl5N/68L3BPhl6gZJ36BbCT9FO6', '0885123456', '38 Holy Cross Drive', '1970-10-30 16:33:53', 77657506, 'D', true);

-- Dummy Data Import for Table Authorities

INSERT INTO `authorities` (`username`, `authority`)
VALUES
    ('vheinreich2@aol.com', 'ROLE_USER'),
    ('bstaig3@tinypic.com', 'ROLE_USER'),
    ('kgutman4@issuu.com', 'ROLE_USER'),
    ('rhildrew5@pen.io', 'ROLE_USER'),
    ('eestevez6@fotki.com', 'ROLE_USER'),
    ('lneilson7@oaic.gov.au', 'ROLE_USER'),
    ('tdevere8@booking.com', 'ROLE_USER'),
    ('aortega9@intel.com', 'ROLE_USER'),
    ('bcasetta0@google.it', 'ROLE_USER'),
    ('cfisby1@latimes.com', 'ROLE_USER');

-- Dummy Data Import for Table Cars

INSERT INTO `cars` (`car_id`, `type`, `name`, `model`, `color`, `location_id`, `transmission`, `price`, `seats`,
                  `registration_number`, `service_date`, `available`)
VALUES
    (2, 1, 'Ford', 'Fusion', 'Green', 2, 'Manual', 34.99, 5, 'C6131PP', '2022-07-26 00:00:00', true),
    (3, 1, 'Volvo', 'XC60', 'Blue', 3, 'Automatic', 24.99, 5, 'CA6183BE', '2022-04-24 00:00:00', true),
    (4, 1, 'Kia', 'Forte', 'Red', 4, 'Automatic', 24.99, 5, 'C1512AC', '2023-02-18 00:00:00', true),
    (5, 1, 'Volkswagen', 'Jetta', 'Red', 5, 'Automatic', 39.99, 5, 'C7231XK', '2023-03-23 00:00:00', true),
    (6, 2, 'Dacia', 'Duster', 'Black', 1, 'Automatic', 24.99, 5, 'C1351HM', '2023-02-18 00:00:00', true),
    (7, 2, 'Skoda', 'Yeti', 'Yellow', 2, 'Manual', 44.99, 5, 'C7112KK', '2022-10-17 00:00:00', true),
    (8, 2, 'Fiat', 'Panda', 'Black', 3, 'Automatic', 34.99, 5, 'C7981TC', '2022-08-14 00:00:00', true),
    (9, 2, 'Kia', 'Carens', 'Red', 4, 'Manual', 29.99, 5, 'C5614BE', '2022-04-13 00:00:00', true),
    (10, 2, 'Mercedes', 'GLC-Class', 'Green', 5, 'Manual', 49.99, 5, 'C6451PO', '2023-01-21 00:00:00', true),
    (11, 1, 'Toyota', 'Corolla', 'Red', 1, 'Automatic', 34.99, 5, 'C9133YE', '2022-09-29 00:00:00', true),
    (12, 2, 'Volkswagen', 'Tiguan', 'Grey', 2, 'Manual', 106.67, 5, 'C5808TE', '2023-01-01 00:00:00', true),
    (13, 1, 'Renault', 'Clio', 'Grey', 3, 'Manual', 117.08, 5, 'C6122UH', '2023-01-06 00:00:00', true),
    (14, 1, 'Renault', 'Clio', 'Red', 5, 'Automatic', 88.73, 5, 'C8246MH', '2023-01-02 00:00:00', true),
    (15, 1, 'Volkswagen', 'Golf', 'Grey', 1, 'Manual', 101.11, 5, 'C7132KO', '2023-01-04 00:00:00', true),
    (16, 1, 'Volkswagen', 'Golf', 'Grey', 1, 'Manual', 80.22, 5, 'C5138PE', '2023-01-03 00:00:00', true),
    (17, 1, 'Volkswagen', 'Golf', 'Black', 3, 'Automatic', 85.66, 5, 'C3550EP', '2023-01-02 00:00:00', true),
    (18, 1, 'Volkswagen', 'Golf', 'White', 4, 'Automatic', 99.46, 5, 'C2760OK', '2023-01-03 00:00:00', true),
    (19, 1, 'Volkswagen', 'Golf', 'Red', 4, 'Manual', 97.27, 5, 'C6882MC', '2023-01-02 00:00:00', true),
    (20, 1, 'Mazda', '3', 'Grey', 4, 'Manual', 100.99, 5, 'C1366MK', '2023-01-01 00:00:00', true),
    (21, 2, 'Kia', 'Sorento', 'Grey', 5, 'Automatic', 117.44, 5, 'C4713CH', '2023-01-06 00:00:00', true),
    (22, 1, 'Audi', 'A2', 'Grey', 2, 'Manual', 89.34, 5, 'C1328EA', '2023-01-01 00:00:00', true),
    (23, 1, 'Audi', 'A3', 'Grey', 4, 'Automatic', 114.11, 5, 'C3070CA', '2023-01-02 00:00:00', true),
    (24, 1, 'Honda', 'Civic', 'White', 1, 'Manual', 81.17, 5, 'C2828CB', '2023-01-06 00:00:00', true),
    (25, 1, 'Fiat', 'Panda', 'Red', 1, 'Manual', 9.99, 5, 'C3543BK', '2020-01-02 00:00:00', true),
    (26, 1, 'Audi', 'A6', 'Grey', 5, 'Manual', 95.75, 5, 'C7538KP', '2023-01-05 00:00:00', true),
    (27, 1, 'BMW', '5', 'White', 1, 'Automatic', 97.41, 5, 'C3987ET', '2023-01-02 00:00:00', true),
    (28, 1, 'BMW', '5', 'Grey', 5, 'Automatic', 115.48, 5, 'C8541TT', '2023-01-06 00:00:00', true),
    (29, 1, 'Skoda', 'Octavia', 'White', 2, 'Manual', 113.56, 5, 'C4013EA', '2023-01-01 00:00:00', true),
    (30, 1, 'Skoda', 'Octavia', 'Red', 4, 'Manual', 108.51, 5, 'C1871AK', '2023-01-03 00:00:00', true),
    (31, 1, 'Volkswagen', 'Passat', 'Black', 3, 'Manual', 94.95, 5, 'C2477PO', '2023-01-03 00:00:00', true),
    (32, 1, 'Volkswagen', 'Passat', 'Grey', 5, 'Manual', 103.45, 5, 'C3876OT', '2023-01-01 00:00:00', true),
    (33, 1, 'Volkswagen', 'Passat', 'Grey', 4, 'Automatic', 88.52, 5, 'C4515XK', '2023-01-06 00:00:00', true),
    (34, 1, 'Mercedes', 'AMG', 'White', 4, 'Automatic', 249.99, 5, 'C1690HA', '2023-01-02 00:00:00', true),
    (35, 1, 'BMW', 'M8', 'Grey', 2, 'Automatic', 299.99, 5, 'C4777TO', '2023-01-01 00:00:00', true),
    (36, 1, 'Ford', 'Explorer', 'Grey', 1, 'Manual', 100.14, 5, 'C3551PO', '2023-01-04 00:00:00', true),
    (37, 1, 'Toyota', 'Corolla', 'White', 1, 'Automatic', 105.25, 5, 'C6645KM', '2023-01-03 00:00:00', true),
    (38, 1, 'Toyota', 'Corolla', 'Red', 5, 'Automatic', 88.6, 5, 'C9683HA', '2023-01-01 00:00:00', true),
    (39, 1, 'Toyota', 'Camry', 'Black', 5, 'Manual', 97.03, 5, 'C1527TA', '2023-01-06 00:00:00', true),
    (40, 2, 'Toyota', 'Tokoma', 'Black', 1, 'Manual', 85.77, 5, 'C5714MX', '2023-01-01 00:00:00', true),
    (41, 2, 'Dacia', 'Duster', 'Red', 3, 'Automatic', 116.73, 5, 'C0395HA', '2023-01-01 00:00:00', true);


-- Dummy Data Import for Table Payments

INSERT INTO `payments` (`payment_id`, `date`, `price`, `completed`)
VALUES
    (2, '2022-11-18 13:03:29', 34.99, true),
    (3, '2022-11-23 02:43:11', 24.99, false),
    (4, '2023-01-15 13:21:56', 39.99, true),
    (5, '2023-01-23 10:43:03', 44.99, false),
    (6, '2022-12-25 14:54:15', 29.99, false);



-- Dummy Data Import for Table Orders

INSERT INTO `orders` (`order_id`, `car_id`, `user_id`, `start_date`, `end_date`, `price`, `location_id`, `payment_type`, `payment_id`, `completed`, `active`)
VALUES
    (1, 2, 3, '2023-04-25 12:00:00', '2023-04-26 12:00:00', 34.99, 1, 1, 2, true, true),
    (2, 3, 4, '2023-04-25 12:00:00', '2023-04-26 12:00:00', 24.99, 2, 1, 3, true, true),
    (3, 5, 5, '2023-04-25 12:00:00', '2023-04-26 12:00:00', 39.99, 3, 1, 4, true, true),
    (4, 7, 6, '2023-04-25 12:00:00', '2023-04-26 12:00:00', 44.99, 4, 1, 5, true, true),
    (5, 9, 7, '2023-04-25 12:00:00', '2023-04-26 12:00:00', 29.99, 5, 1, 6, true, true);