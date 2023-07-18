CREATE DATABASE java6;
use java6;

CREATE TABLE NguyenLieu(
    MaNguyenLieu NVARCHAR(55) PRIMARY key,
    TenNguyenLieu NVARCHAR(255) not null,

)
CREATE TABLE HangHoa(
    MaHang NVARCHAR(55) PRIMARY KEY NOT NULL,
    TenHang NVARCHAR(255) not null,
    MaNguyenLieu NVARCHAR(55) not null,
    SoLuong int not null,
    DonGiaNhap FLOAT not null,
    DonGiaBan FLOAT not null,
    Anh IMAGE not NULL,
    GhiChu NVARCHAR(255),
    FOREIGN key(MaNguyenLieu) REFERENCES NguyenLieu(MaNguyenLieu)
)

CREATE TABLE KhachHang(
    MaKhach NVARCHAR(55) PRIMARY KEY,
    TenKhach NVARCHAR(55) not null,
    DiaChi NVARCHAR(255) not null,
    DienThoai NVARCHAR(11) not null,
 
)
CREATE TABLE HoaDonBan(
MaHoaDonBan NVARCHAR(55) PRIMARY KEY,
NgayBan DATE not null,
MaKhach NVARCHAR(55) not null,
TongTien FLOAT not null,
MaNhanVien NVARCHAR(55) not null,
 FOREIGN key(MaKhach) REFERENCES KhachHang(MaKhach),
FOREIGN key(MaNhanVien) REFERENCES Nhanvien(MaNhanVien),
)
CREATE TABLE ChiTietHoaDonBan(
    MaHoaDonBan NVARCHAR(55) NOT NULL,
    MaHang NVARCHAR(55) not null,
    SoLuong int not null,
    DonGia FLOAT not null,
    GiamGia FLOAT not null,
    ThanhTien FLOAT not null,
    FOREIGN KEY(MaHang) REFERENCES HangHoa(MaHang),
    FOREIGN KEY(MaHoaDonBan) REFERENCES HoaDonBan(MaHoaDonBan),

)
CREATE TABLE Nhanvien(
    MaNhanVien NVARCHAR(55) PRIMARY key NOT NULL,
    TenNhanVien NVARCHAR(255) NOT null,
    GioiTinh BIT not NULL,
    DiaChi NVARCHAR(255) not NULL,
    SDT NVARCHAR(11) not null,
    NgaySinh date not NULL,
)
create table Account(
    id int not null PRIMARY key,
    username NVARCHAR(55) not null,
    fullname NVARCHAR(55) not null,
    email NVARCHAR(55) not null,
    addmin bit NOT null,
    activated BIT NOT null,
)

insert into NguyenLieu
 VALUES('NL001','ga ran'),
 ('NL002','ga chien'),
 ('NL003','Khoai tây ')


insert into HangHoa 
VALUES('HH001','cánh gà rán','NL001',20,200000,5000000,'sdasdwaff',''),
('HH002','dui gà rán','NL002',20,200000,5000000,'sdasdwaff',''),
('HH003','Khoai tây chiên','NL003',20,200000,5000000,'sdasdwaff','')

insert into khachhang values('KH01','Nguyen Van A','731 Tran Hung Dao, Q5, TpHCM','8823451'),
('KH02','Tran Ngoc Han','23/5 Nguyen Trai, Q5, TpHCM','908256478'),
('KH03','Tran Ngoc Linh','45 Nguyen Canh Chan, Q1, TpHCM','938776266')


insert into HoaDonBan values('1001','2020-11-11','KH001','NV001',320000),
('1002','2020-11-11','KH01','NV002',840000),
('1003','2020-11-11','KH02','NV001',100000),
('1004','2020-11-11','KH02','NV001',180000)

