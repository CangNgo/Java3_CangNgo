use master 
go 

CREATE DATABASE QLSV 
GO 
USE QLSV 
GO 

CREATE TABLE NGUOIDUNG(
	TENDANGNHAP VARCHAR(50), 
	MATKHAU NVARCHAR(50) NOT NULL, 
	VAITRO VARCHAR(10), 
	PRIMARY KEY(TENDANGNHAP)
);
GO

CREATE TABLE SINHVIEN(
	MASINHVIEN VARCHAR(10), 
	HOTEN NVARCHAR(255) NOT NULL, 
	EMAIL VARCHAR(100) NOT NULL, 
	SODT VARCHAR(13) NOT NULL,
	GIOITINH NVARCHAR(3) CHECK (GIOITINH IN (N'NAM', N'NỮ')) NOT NULL,
	DIACHI NVARCHAR(255) NULL, 
	HINH VARCHAR(100) NULL, 
	PRIMARY KEY (MASINHVIEN)

);
GO

CREATE TABLE BANGDIEM(
	MA INT IDENTITY(1,1),
	MASINHVIEN VARCHAR(10) NOT NULL,
	TIENGANH FLOAT NOT NULL, 
	TINHOC FLOAT NOT NULL,
	GDTC FLOAT NOT NULL, 
	PRIMARY KEY(MA),
	FOREIGN KEY(MASINHVIEN) REFERENCES SINHVIEN(MASINHVIEN)
);
GO
--CHÈN DỮ LIỆU BẢNG BANGDIEM
INSERT INTO BANGDIEM (MASINHVIEN, TIENGANH, TINHOC, GDTC) VALUES
( 'SV001', 8.5, 7.0, 9.0),
( 'SV002', 9.0, 8.0, 7.5),
( 'SV003', 7.5, 9.0, 8.0),
( 'SV004', 8.0, 7.5, 8.5),
('SV005', 9.0, 8.5, 9.0),
( 'SV006', 7.0, 8.0, 7.5),
( 'SV007', 8.5, 7.0, 8.0),
( 'SV008', 8.0, 8.5, 7.5),
( 'SV009', 9.0, 9.0, 8.5),
( 'SV010', 8.5, 8.0, 9.0);
--CHÈN DỮ LIỆU BẢNG NGUOIDUNG
insert into NGUOIDUNG(TENDANGNHAP,MATKHAU,VAITRO)
values	('Cang', 'cang123','admin'),
		('Lien', 'Lienchuachong','user'),
		('Linh', 'Linhu','user'),
		('Lan', 'Thangban','user');

go

INSERT INTO NGUOIDUNG (TENDANGNHAP, MATKHAU, VAITRO) VALUES
('User1', 'user123', 'user'),
('User2', 'pass123', 'user'),
('User3', '123456', 'user'),
('User4', 'abcdef', 'user'),
('User5', 'password', 'user');

-- Chèn dữ liệu vào bảng SINHVIEN
INSERT INTO SINHVIEN (MASINHVIEN, HOTEN, EMAIL, SODT, GIOITINH, DIACHI, HINH) VALUES
('SV001', N'Nguyễn Văn A', 'nguyenvana@example.com', '1234567890', N'NAM', N'Hà Nội', 'avatar1.jpg'),
('SV002', N'Trần Thị B', 'tranthib@example.com', '0987654321', N'NỮ', N'Hồ Chí Minh', 'avatar2.jpg'),
('SV003', N'Phạm Văn C', 'phamvanc@example.com', '0123456789', N'NAM', N'Đà Nẵng', 'avatar3.jpg'),
('SV004', N'Lê Thị D', 'lethid@example.com', '0912345678', N'NỮ', N'Hải Phòng', 'avatar4.jpg'),
('SV005', N'Hồ Văn E', 'hovane@example.com', '0901234567', N'NAM', N'Bình Dương', 'avatar5.jpg'),
('SV006', N'Đặng Thị F', 'dangthif@example.com', '0976543210', N'NỮ', N'Cần Thơ', 'avatar6.jpg'),
('SV007', N'Trương Văn G', 'truongvang@example.com', '0898765432', N'NAM', N'Hải Dương', 'avatar7.jpg'),
('SV008', N'Mai Thị H', 'maithih@example.com', '0887654321', N'NỮ', N'Huế', 'avatar8.jpg'),
('SV009', N'Vũ Văn I', 'vuvani@example.com', '0965432109', N'NAM', N'Bắc Giang', 'avatar9.jpg'),
('SV010', N'Nguyễn Thị K', 'nguyenthik@example.com', '0954321098', N'NỮ', N'Lào Cai', 'avatar10.jpg');


