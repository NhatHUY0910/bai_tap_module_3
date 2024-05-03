CREATE DATABASE baitap_nghile;

USE baitap_nghile; 

CREATE TABLE cars (
    id INT AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(10) NOT NULL,
    name VARCHAR(100) NOT NULL,
    producer VARCHAR(50) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    avatar LONGBLOB
);

INSERT INTO cars (code, name, producer, price, avatar)
VALUES
    ('BIKE001', 'Mountain Bike', 'Calli', 599.99, LOAD_FILE('D:\CodeGym\module_3\luyen_tap_code\baitap_trenlop\baitap_nghile_1\image1_database.png')),
    ('AUDI001', 'Audi Q8', 'Audi', 68000.00, LOAD_FILE('"D:\CodeGym\module_3\luyen_tap_code\baitap_trenlop\baitap_nghile_1\image2_database.png"')),
    ('LAMB001', 'Lamborghini Aventador', 'Lamborghini', 417826.00, LOAD_FILE('"D:\CodeGym\module_3\luyen_tap_code\baitap_trenlop\baitap_nghile_1\image3_database.png"')),
    ('KAWA001', 'Kawasaki Ninja ZX-6R', 'Kawasaki', 9999.00, LOAD_FILE('"D:\CodeGym\module_3\luyen_tap_code\baitap_trenlop\baitap_nghile_1\image4_database.jpg"')),
    ('PORS001', 'Porsche 718 Cayman', 'Porsche', 59900.00, LOAD_FILE('"D:\CodeGym\module_3\luyen_tap_code\baitap_trenlop\baitap_nghile_1\image5_database.png"'));
    
    SELECT * FROM cars;

