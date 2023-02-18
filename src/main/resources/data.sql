INSERT INTO COLOR (name) VALUES
('gray'),
('green'),
('yellow'),
('red'),
('factory orange'),
('blue'),
('black');

INSERT INTO BRAND (name) VALUES
('Scott'),
('Head'),
('Trek'),
('Fuji'),
('BMX');

INSERT INTO BIKE (name, brand_id, price, color_id) VALUES
 ('Aspect 960', 1, 5699, 1),
 ('Aspect 960', 1, 5699, 2),
 ('Picton I', 2, 8999, 3),
 ('Legos II', 2, 20799.96, 2),
 ('Marlin 8', 3, 7799, 4),
 ('Marlin 6', 3, 5399, 5),
 ('Traverse 1.5', 4, 4999.99, 6),
 ('Feather', 4, 5000, 4),
 ('Mankind NXS', 5, 3519.99, 1),
 ('STY STR', 5, 3699.89, 7),
 ('Nevada 26 1.9 V-brake', 4, 3299.99, 7);

INSERT INTO SALES_ORDER (created_at) VALUES
('2022-06-18 12:00:00');

INSERT INTO ORDER_ITEM (bike_id, sales_order_id, quantity) VALUES
(1, 1, 1),
(2, 1, 1),
(3, 1, 1);

INSERT INTO ROLE (name) VALUES
('CUSTOMER'),
('MANAGER');

INSERT INTO APP_USER (username, password, locked, enabled, role_id) VALUES
('johndoe', '$2a$12$6bCIsO178dVODCYjDvP09eEAtwbEDbAxXKF0lB4snGYG/UKTHne2q', false, true, 1), --pass1
('janedoe', '$2a$12$PuOOl6jfXDB/GIZHdqr1Her4KA1QvLXDY8YreNWcnfl1YFvpY4tDq', false, true, 1), --pass2
('pperic', '$2a$12$TE6SbiT.cLBIxMD17XAB/Od1dyYjezrdGlYycnUTERSED6p4MIxSq', false, true, 2), --pass3
('iivic', '$2a$12$S0g/fU3yrO47v4fsugaZ6O2oLrGahj4MUGxSCc5.WXT66ZGDgvWL.', false, true, 1); --pass4