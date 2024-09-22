CREATE DATABASE WWW_W05_P02_E05;
USE W05_P02_E05;

CREATE TABLE Book (
    id INT IDENTITY(1,1) PRIMARY KEY,
    title NVARCHAR(255),
    image NVARCHAR(255),
    price DECIMAL(10,2),
    quantity INT,
    description NVARCHAR(255)
);

CREATE TABLE Orders (
    id INT IDENTITY(1,1) PRIMARY KEY,
);

CREATE TABLE OrderDetail(
    order_id INT,
    book_id INT,
    quantity INT,
    FOREIGN KEY (order_id) REFERENCES Orders(id),
    FOREIGN KEY (book_id) REFERENCES Book(id),
    PRIMARY KEY (order_id, book_id)
);

INSERT INTO Book (title, image, price, quantity, description) VALUES
(N'Thành phố đi vắng', 'image_1.jpg', 75000.00, 10, 'Thành phố đi vắng'),
(N'Ngày xưa có một chuyện tình', 'image_2.jpg', 135000.00, 10, 'Ngày xưa có một chuyện tình'),
(N'Crying in trees', 'image_3.jpg', 210000.00, 10, 'Crying in trees'),
(N'Have a good day', 'image_4.jpg', 190000.00, 10, 'Have a good day'),
(N'Ma thuật của vật chất', 'image_5.jpg', 190000.00, 10, 'Ma thuật của vật chất');