CREATE DATABASE Quan_ly_dang_ky_xe_may_oto
use Quan_ly_dang_ky_xe_may_oto

CREATE TABLE Account_Management(Account VARCHAR(12) NOT NULL,
                                 Pass VARCHAR(50)NOT NULL
								 CONSTRAINT PK_Acc PRIMARY KEY(Account))


INSERT INTO Account_Management
VALUES ('049049999999','uaalocaigida'),
        ('096069696969','khongbiet'),
		('055075555555','a1b2c3d4'),
		('206666666','206666666')
	



SELECT * FROM Account_Management

CREATE TABLE Oto(MaDinhDanh NVARCHAR(50) NOT NULL,
                 TenChuXe NVARCHAR(50) NOT NULL,
                 NhanHieu NVARCHAR(50) NOT NULL,
				 SoMay NVARCHAR(50) NOT NULL,
				 SoKhung NVARCHAR(50) NOT NULL,
				 SoLoai NVARCHAR(50) NOT NULL,
				 MauSon NVARCHAR(50) NOT NULL,
				 BienSo NVARCHAR(50) NOT NULL,
				 DungTich INT NOT NULL,
				 NgayDangKy Date NOT NULL)

CREATE TABLE Xemay(MaDinhDanh NVARCHAR(50) NOT NULL,
                 TenChuXe NVARCHAR(50) NOT NULL,
                 NhanHieu NVARCHAR(50) NOT NULL,
				 SoMay NVARCHAR(50) NOT NULL,
				 SoKhung NVARCHAR(50) NOT NULL,
				 SoLoai NVARCHAR(50) NOT NULL,
				 MauSon NVARCHAR(50) NOT NULL,
				 BienSo NVARCHAR(50) NOT NULL,
				 DungTich INT NOT NULL,
				 NgayDangKy Date NOT NULL)


SELECT * FROM Oto
WHERE MaDinhDanh = 0



INSERT INTO Oto
VALUES ('049049999999','uaalocaigida')

