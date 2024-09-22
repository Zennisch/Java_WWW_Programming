CREATE DATABASE W05_P02_E05;
USE W05_P02_E05;
CREATE TABLE Book (
    id INT IDENTITY(1,1),
    title NVARCHAR(255),
    image NVARCHAR(255),
    price DECIMAL(10,2),
    quantity INT,
    description NVARCHAR(255)
);
