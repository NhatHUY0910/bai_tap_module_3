
-- create schema school_abc;

use school_abc;

-- create table sach (
--   masach int primary key,
--   tensach varchar(255),
--   tacgia varchar(255),
--   mota text,
--   soluong int
-- );

-- create table hocSinh (
--   mahocsinh int primary key,
--   hoten varchar(255),
--   lop varchar(255)
-- );

-- create table themuonsach (
--   mamuonsach int primary key,
--   masach int,
--   mahocsinh int,
--   trangthai boolean,
--   ngaymuon date,
--   ngaytra date,
--   foreign key (masach) references sach(masach),
--   foreign key (mahocsinh) references hocsinh(mahocsinh)
-- );

-- insert into sach (masach, tensach, tacgia, mota, soluong)
-- values (1, 'Sách 1', 'Tác giả 1', 'Mô tả sách 1', 10),
--        (2, 'Sách 2', 'Tác giả 2', 'Mô tả sách 2', 15),
--        (3, 'Sách 3', 'Tác giả 3', 'Mô tả sách 3', 20),
--        (4, 'Sách 4', 'Tác giả 4', 'Mô tả sách 4', 5),
--        (5, 'Sách 5', 'Tác giả 5', 'Mô tả sách 5', 8),
--        (6, 'Sách 6', 'Tác giả 6', 'Mô tả sách 6', 12),
--        (7, 'Sách 7', 'Tác giả 7', 'Mô tả sách 7', 3),
--        (8, 'Sách 8', 'Tác giả 8', 'Mô tả sách 8', 6),
--        (9, 'Sách 9', 'Tác giả 9', 'Mô tả sách 9', 9),
--        (10, 'Sách 10', 'Tác giả 10', 'Mô tả sách 10', 11);

-- insert into hocsinh (mahocsinh, hoten, lop)
-- values (1, 'Học sinh 1', 'Lớp 1'),
--        (2, 'Học sinh 2', 'Lớp 2'),
--        (3, 'Học sinh 3', 'Lớp 3'),
--        (4, 'Học sinh 4', 'Lớp 4'),
--        (5, 'Học sinh 5', 'Lớp 5');

insert into themuonsach (mamuonsach, masach, mahocsinh, trangthai, ngaymuon, ngaytra)
values (1, 1, 1, true, '2022-01-01', '2022-01-10'),
       (2, 2, 1, false, '2022-02-01', '2022-02-10'),
       (3, 3, 2, true, '2022-03-01', '2022-03-10'),
       (4, 4, 3, false, '2022-04-01', '2022-04-10'),
       (5, 5, 4, true, '2022-05-01', '2022-05-10'),
       (6, 6, 5, false, '2022-06-01', '2022-06-10');
       
       -- select * from sach;
       -- select * from hocsinh;
       select * from themuonsach;

