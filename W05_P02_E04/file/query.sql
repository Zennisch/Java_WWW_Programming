CREATE TABLE Product
(
    id    int identity(1,1),
    name  nvarchar(128),
    image nvarchar(128),
    price decimal(10, 2),
    primary key (id)
)
