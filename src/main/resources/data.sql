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

-- INSERT INTO BIKE (name, brand, price, color) VALUES
-- ('Aspect 960', 'Scott', 5699, 'gray'),
-- ('Aspect 960', 'Scott', 5699, 'green'),
-- ('Picton I', 'Head', 8999, 'yellow'),
-- ('Legos II', 'Head', 20799.96, 'green'),
-- ('Marlin 8', 'Trek', 7799, 'red'),
-- ('Marlin 6', 'Trek', 5399, 'factory orange'),
-- ('Traverse 1.5', 'Fuji', 4999.99, 'blue'),
-- ('Feather', 'Fuji', 5000, 'red'),
-- ('Mankind NXS', 'BMX', 3519.99, 'gray'),
-- ('STY STR', 'BMX', 3699.89, 'black'),
-- ('Nevada 26 1.9 V-brake', 'Fuji', 3299.99, 'black');

INSERT INTO SALES_ORDER (created_at) VALUES
('2022-06-18 12:00:00');

INSERT INTO ORDER_ITEM (bike_id, sales_order_id, quantity) VALUES
(1, 1, 1),
(2, 1, 1),
(3, 1, 1);

INSERT INTO ROLE (name) VALUES
('User'),
('Manager'),
('Admin');

INSERT INTO APP_USER (username, password, role_id) VALUES
('johndoe', 'pass1', 1),
('janedoe', 'pass2', 1),
('pperic', 'pass3', 1),
('iivic', 'pass4', 1);