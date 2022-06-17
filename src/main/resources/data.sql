INSERT INTO Bike (name, brand, price, color) VALUES
('Aspect 960', 'Scott', 5699, 'gray'),
('Picton I', 'Head', 8999, 'yellow'),
('Legos II', 'Head', 20799.96, 'green'),
('Marlin 8', 'Trek', 7799, 'red'),
('Marlin 6', 'Trek', 5399, 'factory orange'),
('Traverse 1.5', 'Fuji', 4999.99, 'blue'),
('Feather', 'Fuji', 5000, 'red'),
('Mankind NXS', 'BMX', 3519.99, 'gray'),
('STY STR', 'BMX', 3699.89, 'black'),
('Nevada 26 1.9 V-brake', 'Fuji', 3299.99, 'black');

INSERT INTO Receipt (id, created_at) VALUES
(1, '2022-06-07 12:12:00');

INSERT INTO RECEIPT_ITEMS (bike_id, receipt_id, quantity) VALUES
(1, 1, 1),
(2, 1, 1);