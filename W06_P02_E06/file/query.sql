USE master

CREATE DATABASE WWW_W06_P02_E06;

USE WWW_W06_P02_E06;

CREATE TABLE GIANGVIEN (
   MAGV NVARCHAR(10) PRIMARY KEY,
   TENGV NVARCHAR(50),
   LINHVUCNGHIENCUU NVARCHAR(50),
   SODIENTHOAI NVARCHAR(10),
);

CREATE TABLE DETAI (
   MADT NVARCHAR(10) PRIMARY KEY,
   TENDT NVARCHAR(127),
   NAMDANGKY INT,
   MOTADETAI NVARCHAR(255),
   MAGV NVARCHAR(10),
   FOREIGN KEY (MAGV) REFERENCES GIANGVIEN(MAGV) ON DELETE CASCADE ON UPDATE CASCADE
)

INSERT INTO GIANGVIEN VALUES (N'GV0001', N'Nguyễn Bùi Thanh Hòa', N'Lĩnh vực về Khoa học cơ bản', '0909123456');
INSERT INTO GIANGVIEN VALUES (N'GV0002', N'Hồ Huỳnh Thùy An', N'Lĩnh vực về Công nghệ thông tin', '0918456894');
INSERT INTO GIANGVIEN VALUES (N'GV0003', N'Lê Hoàng Hóa', N'Lĩnh vực về Kỹ thuật phần mềm', '0988345576');
INSERT INTO GIANGVIEN VALUES (N'GV0004', N'Trần Bảo Châu', N'Lĩnh vực về Hệ thống thông tin', '0914324578');
INSERT INTO GIANGVIEN VALUES (N'GV0005', N'Nguyễn Lê Giao', N'Lĩnh vực về Khoa học máy tính', '0978123453');
INSERT INTO GIANGVIEN VALUES (N'GV0006', N'Hoàng Thị Ngọc Ánh', N'Điện tử công nghiệp', '0988765434');

INSERT INTO DETAI VALUES (N'DT0001', N'Tìm hiểu Mikrotik Router', 2016, N'Tìm hiểu Mikrotik Router và xây dựng Demo hệ thống Hotspot Gateway cho dịch vụ Internet LAN Wifi có chứng thực trình bày các nội dung về các khái quát về công nghệ Wireless LAN', N'GV0002');
INSERT INTO DETAI VALUES (N'DT0002', N'Xây dựng website thương mại điện tử', 2015, N'Thiết kế và xây dựng website thương mại điện tử cho công ty X', N'GV0004');
INSERT INTO DETAI VALUES (N'DT0003',N'Xây dựng hệ thống quản lý hệ thống siêu thị Coop Mart', 2015, N'Nhiệm vụ của đề tài là trình bày, phân tích và thiết kế phần mềm về tổ chức siêu thị, xác định mô hình hoạt động, xác định hiện trạng và phạm vi của hệ thống.', N'GV0003');
INSERT INTO DETAI VALUES (N'DT0004', N'Xây dựng phần mềm quản lý nhân sự, tiền lương', 2015, N'Phân tích, thiết kế, xây dựng phần mềm quản lý nhân sự, tiền lương cho công ty Y', N'GV0004');
INSERT INTO DETAI VALUES (N'DT0005', N'Xây dựng ứng dụng quản lý thư viện', 2015, N'Phân tích, thiết kế, xây dựng phần mềm quản lý thư viện cho trường cao đẳng N', N'GV0004');
