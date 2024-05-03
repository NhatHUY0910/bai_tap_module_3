CREATE DATABASE baitap_nghile;

USE baitap_nghile;

CREATE TABLE cars (
    id INT AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(20),
    name VARCHAR(100),
    producer VARCHAR(50),
    price double,
    avatar LONGBLOB
);

INSERT INTO cars (code, name, producer, price, avatar) VALUES
('BC001', 'Bicycle', 'Brand A', 599.99, LOAD_FILE('D:\CodeGym\module_3\luyen_tap_code\baitap_trenlop\baitap_nghile_1\image1_database.png')),
('AC001', 'Audi Car', 'Audi', 59999.99, LOAD_FILE('D:\CodeGym\module_3\luyen_tap_code\baitap_trenlop\baitap_nghile_1\image2_database.png')),
('LC001', 'Lamborghini Car', 'Lamborghini', 299999.99, LOAD_FILE('D:\CodeGym\module_3\luyen_tap_code\baitap_trenlop\baitap_nghile_1\image3_database.png')),
('MC001', 'Motorcycle', 'Brand B', 9999.99, LOAD_FILE('D:\CodeGym\module_3\luyen_tap_code\baitap_trenlop\baitap_nghile_1\image4_database.jpg')),
('PC001', 'Porsche Car', 'Porsche', 11999.99, LOAD_FILE('D:\CodeGym\module_3\luyen_tap_code\baitap_trenlop\baitap_nghile_1\image5_database.png'));


SELECT * FROM baitap_nghile.cars;

