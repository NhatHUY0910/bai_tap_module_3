-- create database shop;

use shop;

-- CREATE TABLE products (
--     id INT AUTO_INCREMENT PRIMARY KEY,
--     name VARCHAR(255) NOT NULL,
--     price double NOT NULL,
--     quantity INT NOT NULL,
--     type VARCHAR(50) NOT NULL,
--     country VARCHAR(50) NOT NULL
-- );

-- CREATE TABLE accounts (
--     userName VARCHAR(50) PRIMARY KEY,
--     password VARCHAR(50) NOT NULL,
--     gender VARCHAR(10) NOT NULL,
--     birth varchar(50) NOT NULL,
--     address VARCHAR(255) NOT NULL,
--     role VARCHAR(20) DEFAULT 'customer',
--     wallet double 
-- );-- 

-- INSERT INTO products (name, price, quantity, type, country) VALUES
--     ('iPhone 13 Pro Max', 1099.99, 100, 'Smartphone', 'USA'),
--     ('Samsung Galaxy S22 Ultra', 1199.99, 80, 'Smartphone', 'South Korea'),
--     ('Sony WH-1000XM4', 349.99, 50, 'Headphones', 'Japan'),
--     ('Dell XPS 13', 1299.99, 30, 'Laptop', 'USA'),
--     ('Apple Watch Series 7', 399.99, 70, 'Smartwatch', 'USA'),
--     ('Canon EOS R6', 2499.99, 20, 'Camera', 'Japan'),
--     ('Nintendo Switch OLED', 349.99, 60, 'Gaming Console', 'Japan'),
--     ('Bose QuietComfort 35 II', 299.99, 40, 'Headphones', 'USA'),
--     ('Microsoft Surface Pro 8', 1099.99, 25, 'Tablet', 'USA'),
--     ('Sony PlayStation 5', 499.99, 15, 'Gaming Console', 'Japan');


-- INSERT INTO accounts (userName, password, gender, birth, address, role, wallet) VALUES
--     ('john_doe', 'password123', 'Male', '1990-05-15', '123 Main St, New York, NY 10001', 'customer', 500.00),
--     ('jane_smith', 'qwerty456', 'Female', '1985-11-22', '456 Oak Ave, Los Angeles, CA 90001', 'customer', 1000.00),
--     ('bob_johnson', 'abc123xyz', 'Male', '1978-03-10', '789 Maple Rd, Chicago, IL 60601', 'customer', 250.00),
--     ('admin_user', 'admin_pass', 'Male', '1975-07-01', 'admin_address', 'admin', 0.00),
--     ('emily_davis', 'password456', 'Female', '1992-09-18', '321 Pine St, Seattle, WA 98101', 'customer', 750.00);


-- SELECT * FROM shop.products;
SELECT * FROM shop.accounts;

