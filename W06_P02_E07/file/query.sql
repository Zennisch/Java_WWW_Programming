USE master;

CREATE DATABASE WWW_W06_P02_E07;

USE WWW_W06_P02_E07;

CREATE TABLE DANHMUC
(
    MADM        VARCHAR(10) PRIMARY KEY,
    TENDANHMUC  NVARCHAR(50) NOT NULL,
    NGUOIQUANLY NVARCHAR(50) NOT NULL,
    GHICHU      NVARCHAR(100)
)

CREATE TABLE TINTUC
(
    MATT      VARCHAR(10) PRIMARY KEY,
    TIEUDE    NVARCHAR(100) NOT NULL,
    NOIDUNGTT NVARCHAR(1000) NOT NULL,
    LIENKET   NVARCHAR(100) NOT NULL,
    MADM      VARCHAR(10) NOT NULL,
    FOREIGN KEY (MADM) REFERENCES DANHMUC (MADM)
)

INSERT INTO DANHMUC
VALUES ('DM001', N'Chính trị', N'Nguyễn Văn A', N'Chính trị');
INSERT INTO DANHMUC
VALUES ('DM002', N'Kinh tế', N'Nguyễn Văn B', N'Kinh tế');
INSERT INTO DANHMUC
VALUES ('DM003', N'Xã hội', N'Nguyễn Văn C', N'Xã hội');
INSERT INTO DANHMUC
VALUES ('DM004', N'Văn hóa', N'Nguyễn Văn D', N'Văn hóa');
INSERT INTO DANHMUC
VALUES ('DM005', N'Giáo dục', N'Nguyễn Văn E', N'Giáo dục');
INSERT INTO DANHMUC
VALUES ('DM006', N'Khoa học', N'Nguyễn Văn F', N'Khoa học');
INSERT INTO DANHMUC
VALUES ('DM007', N'Thể thao', N'Nguyễn Văn G', N'Thể thao');
INSERT INTO DANHMUC
VALUES ('DM008', N'Văn học', N'Nguyễn Văn H', N'Văn học');
INSERT INTO DANHMUC
VALUES ('DM009', N'Âm nhạc', N'Nguyễn Văn I', N'Âm nhạc');
INSERT INTO DANHMUC
VALUES ('DM010', N'Phim ảnh', N'Nguyễn Văn J', N'Phim ảnh');

INSERT INTO TINTUC
VALUES ('TT001', N'Tin chính trị 1', N'Nội dung tin chính trị 1', N'http://www.tinchinhtri1.com', 'DM001');
INSERT INTO TINTUC
VALUES ('TT002', N'Tin chính trị 2', N'Nội dung tin chính trị 2', N'http://www.tinchinhtri2.com', 'DM001');
INSERT INTO TINTUC
VALUES ('TT003', N'Tin kinh tế 1', N'Nội dung tin kinh tế 1', N'http://www.tinkinhte1.com', 'DM002');
INSERT INTO TINTUC
VALUES ('TT004', N'Tin kinh tế 2', N'Nội dung tin kinh tế 2', N'http://www.tinkinhte2.com', 'DM002');
INSERT INTO TINTUC
VALUES ('TT005', N'Tin xã hội 1', N'Nội dung tin xã hội 1', N'http://www.tinxahoi1.com', 'DM003');
INSERT INTO TINTUC
VALUES ('TT006', N'Tin xã hội 2', N'Nội dung tin xã hội 2', N'http://www.tinxahoi2.com', 'DM003');
INSERT INTO TINTUC
VALUES ('TT007', N'Tin văn hóa 1', N'Nội dung tin văn hóa 1', N'http://www.tinvanhoa1.com', 'DM004');
INSERT INTO TINTUC
VALUES ('TT008', N'Tin văn hóa 2', N'Nội dung tin văn hóa 2', N'http://www.tinvanhoa2.com', 'DM004');
INSERT INTO TINTUC
VALUES ('TT009', N'Tin giáo dục 1', N'Nội dung tin giáo dục 1', N'http://www.tingiaoduc1.com', 'DM005');
INSERT INTO TINTUC
VALUES ('TT010', N'Tin giáo dục 2', N'Nội dung tin giáo dục 2', N'http://www.tingiaoduc2.com', 'DM005');
INSERT INTO TINTUC
VALUES ('TT011', N'Tin khoa học 1', N'Nội dung tin khoa học 1', N'http://www.tinkhoahoc1.com', 'DM006');
INSERT INTO TINTUC
VALUES ('TT012', N'Tin khoa học 2', N'Nội dung tin khoa học 2', N'http://www.tinkhoahoc2.com', 'DM006');
INSERT INTO TINTUC
VALUES ('TT013', N'Tin thể thao 1', N'Nội dung tin thể thao 1', N'http://www.tinthethao1.com', 'DM007');
INSERT INTO TINTUC
VALUES ('TT014', N'Tin thể thao 2', N'Nội dung tin thể thao 2', N'http://www.tinthethao2.com', 'DM007');
INSERT INTO TINTUC
VALUES ('TT015', N'Tin văn học 1', N'Nội dung tin văn học 1', N'http://www.tinvanhoc1.com', 'DM008');
INSERT INTO TINTUC
VALUES ('TT016', N'Tin văn học 2', N'Nội dung tin văn học 2', N'http://www.tinvanhoc2.com', 'DM008');
INSERT INTO TINTUC
VALUES ('TT017', N'Tin âm nhạc 1', N'Nội dung tin âm nhạc 1', N'http://www.tinamnhac1.com', 'DM009');
INSERT INTO TINTUC
VALUES ('TT018', N'Tin âm nhạc 2', N'Nội dung tin âm nhạc 2', N'http://www.tinamnhac2.com', 'DM009');
INSERT INTO TINTUC
VALUES ('TT019', N'Tin phim ảnh 1', N'Nội dung tin phim ảnh 1', N'http://www.tinphimanh1.com', 'DM010');
INSERT INTO TINTUC
VALUES ('TT020', N'Tin phim ảnh 2', N'Nội dung tin phim ảnh 2', N'http://www.tinphimanh2.com', 'DM010');
