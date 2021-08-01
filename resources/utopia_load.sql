INSERT INTO airplane_type
    (max_capacity)
VALUES
    (180), -- A320: 20, 40, 120
    (467), -- B747: 50, 100, 317
    (853); -- A380: 150, 200, 503


INSERT INTO airplane
    (type_id)
VALUES
    (1),
    (1),
    (1),
    (1),
    (1),
    (1),
    (1),
    (1),
    (1),
    (1),
    (1),
    (1),
    (2),
    (2),
    (2),
    (2),
    (2),
    (2),
    (3),
    (3);


INSERT INTO airport
    (iata_id, city)
VALUES
    ('ITO', 'Hilo'),
    ('HNL', 'Honolulu'),
    ('OGG', 'Kahului'),
    ('KOA', 'Kalaoa'),
    ('LIH', 'Lihue');


INSERT INTO route
    (origin_id, destination_id)
VALUES
    ('ITO', 'HNL'),
    ('ITO', 'OGG'),
    ('ITO', 'LIH'),
    ('HNL', 'ITO'),
    ('HNL', 'OGG'),
    ('HNL', 'KOA'),
    ('HNL', 'LIH'),
    ('OGG', 'ITO'),
    ('OGG', 'HNL'),
    ('OGG', 'LIH'),
    ('KOA', 'HNL'),
    ('LIH', 'ITO'),
    ('LIH', 'OGG'),
    ('LIH', 'HNL');


INSERT INTO flight
    (route_id, airplane_id, departure_time, reserved_seats, seat_price)
VALUES
    (1, 1, '2021-08-03 10:15:00', 0, 150.0),
    (4, 2, '2021-08-03 09:30:00', 0, 125.0),
    (4, 3, '2021-08-03 10:15:00', 0, 150.0),
    (5, 13, '2021-08-03 13:45:00', 0, 100.0),
    (5, 14, '2021-08-03 18:20:00', 0, 110.0),
    (5, 15, '2021-08-03 19:20:00', 0, 120.0),
    (6, 4, '2021-08-03 12:30:00', 0, 180.0),
    (7, 5, '2021-08-03 10:20:00', 0, 165.0),
    (7, 6, '2021-08-03 14:55:00', 0, 185.0),
    (8, 7, '2021-08-03 13:00:00', 0, 95.0),
    (9, 16, '2021-08-03 10:05:00', 0, 110.0),
    (11, 8, '2021-08-03 11:40:00', 0, 190.0),
    (14, 9, '2021-08-03 12:10:00', 0, 170.0);


INSERT INTO booking
    (is_active, confirmation_code)
VALUES
    (1, 'aaaaaaaaaa0000000001'),
    (1, 'aaaaaaaaaa0000000002'),
    (1, 'aaaaaaaaaa0000000003'),
    (1, 'aaaaaaaaaa0000000004'),
    (1, 'aaaaaaaaaa0000000005'),
    (1, 'aaaaaaaaaa0000000006'),
    (1, 'aaaaaaaaaa0000000007'),
    (1, 'aaaaaaaaaa0000000008'),
    (1, 'aaaaaaaaaa0000000009'),
    (1, 'aaaaaaaaaa0000000010');


INSERT INTO flight_bookings
    (flight_id, booking_id)
VALUES
    (1, 1),
    (1, 2),
    (1, 3),
    (2, 4),
    (2, 5),
    (3, 6),
    (5, 7),
    (5, 8),
    (6, 9),
    (9, 10);


INSERT INTO booking_payment
    (booking_id, stripe_id, refunded)
VALUES
    (1, 'aaaaaaaaaaaaaaaaaaaa00000000000000000001', 0),
    (2, 'aaaaaaaaaaaaaaaaaaaa00000000000000000002', 0),
    (3, 'aaaaaaaaaaaaaaaaaaaa00000000000000000003', 0),
    (4, 'aaaaaaaaaaaaaaaaaaaa00000000000000000004', 0),
    (5, 'aaaaaaaaaaaaaaaaaaaa00000000000000000005', 0),
    (6, 'aaaaaaaaaaaaaaaaaaaa00000000000000000006', 0),
    (7, 'aaaaaaaaaaaaaaaaaaaa00000000000000000007', 0),
    (8, 'aaaaaaaaaaaaaaaaaaaa00000000000000000008', 0),
    (9, 'aaaaaaaaaaaaaaaaaaaa00000000000000000009', 0),
    (10, 'aaaaaaaaaaaaaaaaaaaa00000000000000000010', 0);


INSERT INTO passenger
    (booking_id, given_name, family_name, dob, gender, address)
VALUES
    (1, 'Julian Paulo', 'Torres', '1994-09-25', 'Male', 'Honolulu, HI'),
    (2, 'Zilca', 'Torres', '1953-05-13', 'Female', 'Ewa Beach, HI'),
    (3, 'Paul', 'Torres', '1965-02-08', 'Male', 'Ewa Beach, HI'),
    (4, 'Rashad', 'Hicks', '1995-05-12', 'Male', 'Kapolei, HI'),
    (5, 'Danielle', 'Montano', '1996-06-12', 'Female', 'Kapolei, HI'),
    (6, 'Alex', 'Fonseca', '1983-01-28', 'Male', 'Honolulu, HI'),
    (7, 'Gray', 'Goodhue', '1993-10-03', 'Male', 'Waianae, HI'),
    (8, 'Alisha', 'Evans', '1994-02-23', 'Female', 'Las Vegas, NV'),
    (9, 'Sabine', 'Ah Sing', '1964-09-10', 'Female', 'Ewa Beach, HI'),
    (10, 'Bree', 'Ember', '1999-01-29', 'Female', 'Honolulu, HI');


INSERT INTO booking_guest
    (booking_id, contact_email, contact_phone)
VALUES
    (1, 'juliannogueira@yahoo.com', '8082778085'),
    (4, 'rashad.hicks@gmail.com', '8082172209');


INSERT INTO user_role
    (name)
VALUES
    ('Employee'),
    ('Administrator'),
    ('Traveler');


INSERT INTO user
    (role_id, given_name, family_name, username, email, password, phone)
VALUES
    (1, 'Chance', 'Nakamini', 'cnakamini', 'chance.nakamini@utopia.com', 'takeachance', '8082337199'),
    (1, 'Heather', 'Bautista', 'hbautista', 'heather.bautista@utopia.com', 'feather96706', '8083180148'),
    (1, 'Alottah', 'Aloha', 'aaloha', 'alotta.aloha@utopia.com', '2muchaloha', '8084698089'),
    (2, 'Chee', 'Pono', 'cpono', 'chee.pono@utopia.com', 'shootsbrah', '8084690912'),
    (2, 'Wai', 'Kiki', 'wkiki', 'wai.kiki@utopia.com', 'waikiki808', '8085100718'),
    (3, 'Alisha', 'Evans', 'aevans', 'alisha_evans@gmail.com', 'innerpeace13', '7023411370'),
    (3, 'Sabine', 'Ah Sing', 'sahsing', 'sabine_ah_sing@hotmail.com', 'frankfurt64', '8082128337');


INSERT INTO booking_agent
    (booking_id, agent_id)
VALUES
    (2, 1),
    (3, 1),
    (5, 2),
    (6, 3),
    (7, 3),
    (10, 3);


INSERT INTO booking_user
    (booking_id, user_id)
VALUES
    (8, 6),
    (9, 7);
