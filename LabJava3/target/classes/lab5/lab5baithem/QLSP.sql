use master 
go	
CREATE DATABASE QLSP
GO
USE QLSP
GO 

CREATE TABLE DANHMUC(
	MADM NVARCHAR(30),
	TENDM NVARCHAR(30), 
	ISDELETE SMALLINT,
	PRIMARY KEY(MADM)
);
GO
CREATE TABLE SANPHAM(
	 MASP NVARCHAR(30) , 
	TENSP NVARCHAR(50) NOT NULL, 
	SOLUONG INT NOT NULL, 
	 DONGIA FLOAT NOT NULL, 
	MADM NVARCHAR(30), 
	ISDELETE SMALLINT,
	PRIMARY KEY (MASP),
	FOREIGN KEY(MADM) REFERENCES DANHMUC(MADM)
);
GO
