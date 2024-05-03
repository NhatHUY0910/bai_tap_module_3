-- CREATE DATABASE baitap_nghile;

USE baitap_nghile; 

-- CREATE TABLE cars (
--     id INT AUTO_INCREMENT PRIMARY KEY,
--     code VARCHAR(10) UNIQUE,
--     name VARCHAR(100) NOT NULL,
--     producer VARCHAR(50) NOT NULL,
--     price DECIMAL(10,2) NOT NULL,
--     avatar VARCHAR(255)
-- ); 

INSERT INTO cars (code, name, producer, price, avatar)
VALUES
    ('CAR001', 'Civic', 'Honda', 25000.00, 'https://example.com/civic.jpg'),
    ('CAR002', 'Corolla', 'Toyota', 22500.00, 'https://example.com/corolla.jpg'),
    ('CAR003', '3 Series', 'BMW', 35000.00, 'https://example.com/bmw3series.jpg'),
    ('CAR004', 'Mustang', 'Ford', 30000.00, 'https://example.com/mustang.jpg'),
    ('CAR005', 'Accord', 'Honda', 27500.00, 'https://example.com/accord.jpg');
    
    SELECT * FROM cars;

