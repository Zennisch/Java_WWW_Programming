CREATE
DATABASE WWW_W07_P02_E08;

USE WWW_W07_P02_E08;

create table DienThoai
(
    MaDienThoai  int identity not null,
    CauHinh      varchar(255),
    NamSanXuat   int,
    TenDienThoai varchar(255),
    MaNhaCungCap int,
    primary key (MaDienThoai)
)

create table NhaCungCap
(
    MaNhaCungCap  int identity not null,
    DiaChi        varchar(255),
    SoDienThoai   varchar(255),
    TenNhaCungCap varchar(255),
    primary key (MaNhaCungCap)
)

alter table DienThoai add constraint FK60ut1d1nvn43g911ct38bslk2 foreign key (MaNhaCungCap) references NhaCungCap

-- Add 5 records to NhaCungCap
insert into NhaCungCap (DiaChi, SoDienThoai, TenNhaCungCap) values ('New York', '123456789', 'Apple')
insert into NhaCungCap (DiaChi, SoDienThoai, TenNhaCungCap) values ('California', '987654321', 'Samsung')
insert into NhaCungCap (DiaChi, SoDienThoai, TenNhaCungCap) values ('Texas', '543216789', 'Nokia')
insert into NhaCungCap (DiaChi, SoDienThoai, TenNhaCungCap) values ('Florida', '987651234', 'Sony')
insert into NhaCungCap (DiaChi, SoDienThoai, TenNhaCungCap) values ('Washington', '654321987', 'LG')

-- Add 20 records to DienThoai
insert into DienThoai (CauHinh, NamSanXuat, TenDienThoai, MaNhaCungCap) values ('A', 2010, 'iPhone 4', 1)
insert into DienThoai (CauHinh, NamSanXuat, TenDienThoai, MaNhaCungCap) values ('B', 2011, 'Galaxy S2', 2)
insert into DienThoai (CauHinh, NamSanXuat, TenDienThoai, MaNhaCungCap) values ('C', 2012, 'Lumia 920', 3)
insert into DienThoai (CauHinh, NamSanXuat, TenDienThoai, MaNhaCungCap) values ('D', 2013, 'Xperia Z', 4)
insert into DienThoai (CauHinh, NamSanXuat, TenDienThoai, MaNhaCungCap) values ('E', 2014, 'G2', 5)
insert into DienThoai (CauHinh, NamSanXuat, TenDienThoai, MaNhaCungCap) values ('F', 2015, 'iPhone 6', 1)
insert into DienThoai (CauHinh, NamSanXuat, TenDienThoai, MaNhaCungCap) values ('G', 2016, 'Galaxy S7', 2)
insert into DienThoai (CauHinh, NamSanXuat, TenDienThoai, MaNhaCungCap) values ('H', 2017, 'Lumia 950', 3)
insert into DienThoai (CauHinh, NamSanXuat, TenDienThoai, MaNhaCungCap) values ('I', 2018, 'Xperia XZ', 4)
insert into DienThoai (CauHinh, NamSanXuat, TenDienThoai, MaNhaCungCap) values ('J', 2019, 'G3', 5)
insert into DienThoai (CauHinh, NamSanXuat, TenDienThoai, MaNhaCungCap) values ('K', 2020, 'iPhone 12', 1)
insert into DienThoai (CauHinh, NamSanXuat, TenDienThoai, MaNhaCungCap) values ('L', 2021, 'Galaxy S21', 2)
insert into DienThoai (CauHinh, NamSanXuat, TenDienThoai, MaNhaCungCap) values ('M', 2022, 'Lumia 1020', 3)
insert into DienThoai (CauHinh, NamSanXuat, TenDienThoai, MaNhaCungCap) values ('N', 2023, 'Xperia 1', 4)
insert into DienThoai (CauHinh, NamSanXuat, TenDienThoai, MaNhaCungCap) values ('O', 2024, 'G4', 5)
insert into DienThoai (CauHinh, NamSanXuat, TenDienThoai, MaNhaCungCap) values ('P', 2025, 'iPhone 13', 1)
insert into DienThoai (CauHinh, NamSanXuat, TenDienThoai, MaNhaCungCap) values ('Q', 2026, 'Galaxy S22', 2)
insert into DienThoai (CauHinh, NamSanXuat, TenDienThoai, MaNhaCungCap) values ('R', 2027, 'Lumia 1120', 3)
insert into DienThoai (CauHinh, NamSanXuat, TenDienThoai, MaNhaCungCap) values ('S', 2028, 'Xperia 2', 4)
insert into DienThoai (CauHinh, NamSanXuat, TenDienThoai, MaNhaCungCap) values ('T', 2029, 'G5', 5)
