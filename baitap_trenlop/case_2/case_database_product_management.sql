create schema product_management;

use product_management;

create table products (
    id int auto_increment primary key,
    name varchar(255) not null,
    price double not null,
    producer varchar(255),
    categories varchar(255) not null,
    shipper varchar(255),
    image varchar(255)
    
    -- foreign key (producer) references producers(id),
--     foreign key (categories) references categories(id),
--     foreign key (shipper) references shippers(id)
);

create table producers (
    id int auto_increment primary key,
    name varchar(255) not null,
    address varchar(255),
    country varchar(100)
);

create table categories (
    id int auto_increment primary key,
    name varchar(100) not null,
    description text
);

create table shippers (
    id int auto_increment primary key,
    name varchar(100) not null,
    age int
);



insert into products (name, price, producer, categories, shipper, image)
values
    ('Laptop Dell XPS 13', 1499.99, 'Dell Inc.', 'Laptops', 'Đức', 'D:\CodeGym\module_3\home_code\case_2\database_img\product_img_1.jpg'),
    ('iPhone 14 Pro Max', 1099.00, 'Apple Inc.', 'Smartphones', 'Quý', 'D:\CodeGym\module_3\home_code\case_2\database_img\product_img_2.jpg'),
    ('Samsung Galaxy S22 Ultra', 1199.99, 'Samsung Electronics Co., Ltd.', 'Smartphones', 'Trường', 'D:\CodeGym\module_3\home_code\case_2\database_img\product_img_3.png'),
    ('Sony WH-1000XM5', 399.99, 'Sony Corporation', 'Headphones', 'Hiếu', 'D:\CodeGym\module_3\home_code\case_2\database_img\product_img_4.png'),
    ('Bose QuietComfort 45', 329.00, 'Bose Corporation', 'Headphones', 'Quân', 'D:\CodeGym\module_3\home_code\case_2\database_img\product_img_5.jpg'),
    ('Instant Pot Duo Plus', 119.95, 'Dell Inc.', 'Kitchen Appliances', 'Đức', 'D:\CodeGym\module_3\home_code\case_2\database_img\product_img_6.jpg'),
    ('KitchenAid Stand Mixer', 349.99, 'Apple Inc.', 'Kitchen Appliances', 'Quý', 'D:\CodeGym\module_3\home_code\case_2\database_img\product_img_7.jpg'),
    ('Fitbit Versa 3', 229.95, 'Samsung Electronics Co., Ltd.', 'Wearable Technology', 'Trường', 'D:\CodeGym\module_3\home_code\case_2\database_img\product_img_8.jpg'),
    ('Beats Studio Buds', 149.95, 'Sony Corporation', 'Headphones', 'Hiếu', 'D:\CodeGym\module_3\home_code\case_2\database_img\product_img_9.jpg'),
    ('Kindle Paperwhite', 139.99, 'Bose Corporation', 'Wearable Technology', 'Quân', 'D:\CodeGym\module_3\home_code\case_2\database_img\product_img_10.jpg');


insert into producers (name, address, country)
values
    ('Dell Inc.', '1 Dell Way, Round Rock, TX 78682, USA', 'USA'),
    ('Apple Inc.', '1 Apple Park Way, Cupertino, CA 95014, USA', 'USA'),
    ('Samsung Electronics Co., Ltd.', '129 Samsung-ro, Yeongtong-gu, Suwon-si, Gyeonggi-do, South Korea', 'South Korea'),
    ('Sony Corporation', '1-7-1 Konan, Minato-ku, Tokyo 108-0075, Japan', 'Japan'),
    ('Bose Corporation', 'The Mountain, Framingham, MA 01701, USA', 'USA');


insert into categories (name, description)
values
    ('Laptops', 'Portable computers for personal and professional use'),
    ('Smartphones', 'Mobile devices with advanced computing capabilities'),
    ('Headphones', 'Audio devices for listening to music or other audio content'),
    ('Kitchen Appliances', 'Devices and tools used for cooking and food preparation'),
    ('Wearable Technology', 'Smart devices worn on the body for tracking activities or health');


insert into shippers (name, age)
values
    ('Đức', 49),
    ('Quý', 61),
    ('Trường', 73),
    ('Hiếu', 35),
    ('Quân', 55);


---------- Tạo_Stored_Procedure ----------

delimiter $$
create procedure GetProductsWithProducers()
begin
    select
        p.name as 'Product Name',
        p.price as 'Price',
        pr.name as 'Producer Name',
        pr.address as 'Producer Address',
        pr.country as 'Producer Country'
    from
        products p
        left join producers pr on p.producer = pr.name;
end$$
delimiter ;

call GetProductsWithProducers();


delimiter $$
create procedure GetProducersWithProducts()
begin
    select
        pr.name as 'Producer Name',
        pr.address as 'Producer Address',
        pr.country as 'Producer Country',
        p.name as 'Product Name',
        p.price as 'Price'
    from
        producers pr
        right join products p on p.producer = pr.name;
end$$
delimiter ;

-- call GetProducersWithProducts();


delimiter $$
create procedure GetProductsWithCategoriesAndShippers()
begin
    select
        p.name as 'Product Name',
        p.price as 'Price',
        c.name as 'Category Name',
        c.description as 'Category Description',
        s.name as 'Shipper Name',
        s.age as 'Shipper Age'
    from
        products p
        join categories c on p.categories = c.name
        join shippers s on p.shipper = s.name;
end$$
delimiter ;

-- call GetProductsWithCategoriesAndShippers();



-- SELECT * FROM products;
--     select * from producers;
--     select * from categories;
--     select * from shippers;


