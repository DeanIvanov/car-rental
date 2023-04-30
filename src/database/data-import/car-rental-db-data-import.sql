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
    (2, 1, 'Ford', 'Fusion', 'Green', 2, 'Manual', 34.99, 5, 'C6131PP', '2022-07-26 11:07:39', true),
    (3, 1, 'Volvo', 'XC60', 'Blue', 3, 'Automatic', 24.99, 5, 'CA6183BE', '2022-04-24 06:17:55', true),
    (4, 1, 'Kia', 'Forte', 'Red', 4, 'Automatic', 24.99, 5, 'C1512AC', '2023-02-18 04:59:17', true),
    (5, 1, 'Volkswagen', 'Jetta', 'Red', 5, 'Automatic', 39.99, 5, 'C7231XK', '2023-03-23 00:40:14', true),
    (6, 2, 'Dacia', 'Duster', 'Black', 1, 'Automatic', 24.99, 5, 'C1351HM', '2023-02-18 12:18:44', true),
    (7, 2, 'Skoda', 'Yeti', 'Yellow', 2, 'Manual', 44.99, 5, 'C7112KK', '2022-10-17 12:56:56', true),
    (8, 2, 'Fiat', 'Panda', 'Black', 3, 'Automatic', 34.99, 5, 'C7981TC', '2022-08-14 21:41:29', true),
    (9, 2, 'Kia', 'Carens', 'Red', 4, 'Manual', 29.99, 5, 'C5614BE', '2022-04-13 01:23:23', true),
    (10, 2, 'Mercedes', 'GLC-Class', 'Green', 5, 'Manual', 49.99, 5, 'C6451PO', '2023-01-21 15:21:09', true),
    (11, 1, 'Toyota', 'Corolla', 'Red', 1, 'Automatic', 34.99, 5, 'C9133YE', '2022-09-29 19:49:33', true);

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