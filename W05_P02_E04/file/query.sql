CREATE TABLE Product
(
    id    int identity(1,1),
    name  nvarchar(128),
    image nvarchar(128),
    price decimal(10, 2),
    primary key (id)
)

INSERT INTO Product VALUES (N'Thành phố đi vắng', 'image_1.jpg', 75000)
 INSERT INTO Product VALUES (N'Ngày xưa có một chuyện tình', 'image_2.jpg', 135000)
 INSERT INTO Product VALUES (N'Crying in trees', 'image_3.jpg', 210000)
 INSERT INTO Product VALUES (N'Have a good day', 'image_4.jpg', 190000)
 INSERT INTO Product VALUES (N'Ma thuật của vật chất', 'image_5.jpg', 190000)
