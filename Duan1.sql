Create Database DuAn1_PRO1041
go
use DuAn1_PRO1041
go

-- T?o b?ng ChucVu
CREATE TABLE ChucVu (
    IDChucVu INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    MaChucVu NVARCHAR(20)  NULL,
    TenChucVu NVARCHAR(100)  NULL
);


CREATE TABLE NhaCungCap (
    IDNhaCungCap INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    MaNhaCungCap NVARCHAR(50)  NULL,
    TenNhaCungCap NVARCHAR(100)  NULL,
	TrangThai BIT  NULL
);

-- T?o b?ng MauSac
CREATE TABLE MauSac (
    IDMauSac INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    MaMauSac NVARCHAR(50)  NULL,
    TenMauSac NVARCHAR(100)  NULL,
	TrangThai BIT  NULL
);

-- T?o b?ng TacGia
CREATE TABLE TacGia (
    IDTacGia INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    MaTG NVARCHAR(50) NOT NULL,
    TenTG NVARCHAR(100) NOT NULL,
	TrangThai BIT  NULL
);

-- T?o b?ng TheLoai
CREATE TABLE TheLoai (
    IDTheLoai INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    MaTheLoai NVARCHAR(50)  NULL,
    TenTheLoai NVARCHAR(100)  NULL,
	TrangThai BIT  NULL
);
-- T?o b?ng Voucher
CREATE TABLE Voucher (
    IDVoucher INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    MaVoucher NVARCHAR(50)  NULL,
    GiamPhanTram int  NULL,
	SoLanSuDung int  NULL
);

-- T?o b?ng SanPham
CREATE TABLE SanPham (
    IDSanPham INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    MaSanPham NVARCHAR(50)  NULL,
    TenSanPham NVARCHAR(100)  NULL,
    TrangThai BIT  NULL
);
-- T?o b?ng SanPhamChiTiet
CREATE TABLE SanPhamChiTiet (
    IDSanPhamChiTiet INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    IDNhaCungCap INT NULL,
    IDSanPham INT NULL,
    IDTheLoai INT NULL,
    IDTacGia INT NULL,
    IDMauSac INT NULL,
    SoLuongTon INT  NULL,
    GiaNhap FLOAT  NULL,
    GiaBan FLOAT  NULL,
    NamPhatHanh INT  NULL,
    FOREIGN KEY (IDNhaCungCap) REFERENCES NhaCungCap(IDNhaCungCap),
    FOREIGN KEY (IDSanPham) REFERENCES SanPham(IDSanPham),
    FOREIGN KEY (IDTheLoai) REFERENCES TheLoai(IDTheLoai),
    FOREIGN KEY (IDTacGia) REFERENCES TacGia(IDTacGia),
    FOREIGN KEY (IDMauSac) REFERENCES MauSac(IDMauSac)
);

-- T?o b?ng KhachHang
CREATE TABLE KhachHang (
    IDKhachHang INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    MaKhachHang NVARCHAR(50)  NULL,
    TenKhachHang NVARCHAR(100)  NULL,
    NgaySinh DATE NULL,
    GioiTinh BIT  NULL,
    DiaChi NVARCHAR(200) NULL,
    SDT NVARCHAR(15) NULL,
    Email NVARCHAR(100) NULL
);

-- T?o b?ng NhanVien
CREATE TABLE NhanVien (
    IDNhanVien INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    IDChucVu INT NULL,
    MaNhanVien NVARCHAR(50)  NULL,
    TenNhanVien NVARCHAR(100)  NULL,
    GioiTinh BIT  NULL,
    NgaySinh DATE  NULL,
    DiaChi NVARCHAR(200) NULL,
    SDT VARCHAR(15)  NULL,
    MatKhau VARCHAR(50)  NULL,
    TrangThai BIT  NULL,
    FOREIGN KEY (IDChucVu) REFERENCES ChucVu(IDChucVu)
);


-- T?o b?ng HoaDon
CREATE TABLE HoaDon (
    IDHoaDon INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    IDKhachHang INT null,
    IDNhanVien INT null,
	IDVoucher int null,
    NgayTao DATE  NULL,
    NgayThanhToan DATE NULL,
    TinhTrang BIT  NULL,
    NguoiNhan NVARCHAR(100)  NULL,
    SDT VARCHAR(15)  NULL,
    TongTien FLOAT  NULL,
	TienSauKhiGiam float null,
    FOREIGN KEY (IDKhachHang) REFERENCES KhachHang(IDKhachHang),
    FOREIGN KEY (IDNhanVien) REFERENCES NhanVien(IDNhanVien),
	FOREIGN KEY (IDVoucher) REFERENCES Voucher(IDVoucher)
);
-- T?o b?ng HoaDonChiTiet
CREATE TABLE HoaDonChiTiet (
    IDHoaDonChiTiet INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    IDHoaDon INT  NULL,
    IDSanPhamChiTiet INT  NULL,
    SoLuong INT  NULL,
    DonGia FLOAT  NULL,
    FOREIGN KEY (IDHoaDon) REFERENCES HoaDon(IDHoaDon),
    FOREIGN KEY (IDSanPhamChiTiet) REFERENCES SanPhamChiTiet(IDSanPhamChiTiet)
);

-- Nh?p li?u cho b?ng ChucVu
INSERT INTO ChucVu (MaChucVu, TenChucVu) VALUES
('CV01', N'Quản lý'),
('CV02', N'Nhân viên')

-- Nh?p li?u cho b?ng MauSac
INSERT INTO MauSac (MaMauSac, TenMauSac,TrangThai) VALUES
('MS01', N'Hồng',1),
('MS02', N'Xanh Dươnng',1),
('MS03', N'Vàng',1),
('MS04', N'Trắng',1),
('MS05', N'Cam',1),
('MS06', N'Xanh Lá',1),
('MS07', N'Nâu',1),
('MS08', N'Tím',1)
-- Nh?p li?u cho b?ng TacGia
INSERT INTO TacGia (MaTG, TenTG, TrangThai) VALUES
('TG001', N'Nguyễn Minh Thuyết',1),
('TG002', N'Đỗ Đình Hoan',1),
('TG003', N'Nguyễn Dược',1),
('TG004', N'Nguyễn Quang Vinh',1),
('TG005', N'Vũ Quang',1),
('TG006', N'Phan Đức Chính',1),
('TG007', N'Phan Ngọc Liên',1),
('TG008', N'Trần Văn Hạo',1),
('TG009', N'Phan Trọng Luận',1),
('TG010', N'Lê Thông',1),
('TG011', N'Nguyễn Thành Đạt',1),
('TG012', N'Lương Duyên Bình',1),
('TG013', N'Nguyễn Xuân Trường',1);

--Nhà cung c?p
 INSERT INTO NhaCungCap (MaNhaCungCap, TenNhaCungCap, TrangThai)
VALUES
('NCC01', N'An Lộc',  1),
('NCC02', N'Hải Hà',  1),
('NCC03', N'Bảo Khang',  1),
('NCC04', N'Minh Khôi',  1),
('NCC05', N'Duy Nam',  1)
--Th? lo?i
INSERT INTO TheLoai (MaTheLoai, TenTheLoai, TrangThai) VALUES
('TL01', N'Cấp 1',1),
('TL02', N'Cấp 2',1),
('TL03', N'Cấp 3',1)
--S?n Ph?m
INSERT INTO SanPham (MaSanPham, TenSanPham, TrangThai) VALUES
('SP001', N'Sách Tiếng Việt 1 (Tập 1)', 1),
('SP002', N'Sách Tiếng Việt 1 (Tập 2)', 1),
('SP003', N'Sách Toán 1', 1),
('SP004', N'Sách Tiếng Việt 2 (Tập 1)', 1),
('SP005', N'Sách Tiếng Việt 2 (Tập 2)', 1),
('SP006', N'Sách Toán 2', 1),
('SP007', N'Sách Tiếng Việt 3 (Tập 1)', 1),
('SP008', N'Sách Tiếng Việt 3 (Tập 2)', 1),
('SP009', N'Sách Toán 3', 1),
('SP010', N'Sách Tiếng Việt 4 (Tập 1)', 1),
('SP011', N'Sách Tiếng Việt 4 (Tập 2)', 1),
('SP012', N'Sách giáo khoa Địa lớp 6', 1),
('SP013', N'Sách giáo khoa Sinh học lớp 6', 1),
('SP014', N'Sách giáo khoa Vật lí lớp 6', 1),
('SP015', N'Sách giáo khoa Toán(Tập 1) lớp 6', 1),
('SP016', N'Sách giáo khoa Lịch sử lớp 7', 1),
('SP017', N'Sách giáo khoa Địa lớp 7', 1),
('SP018', N'Sách giáo khoa Sinh học lớp 7', 1),
('SP019', N'Sách giáo khoa Vật lí lớp 7', 1),
('SP020', N'Sách giáo khoa Toán(Tập 1) lớp 7', 1),
('SP021', N'Sách giáo khoa Lịch sử lớp 8', 1),
('SP022', N'Sách giáo khoa Địa lớp 8', 1),
('SP023', N'Sách giáo khoa Sinh học lớp 8', 1),
('SP024', N'Sách giáo khoa Vật lí lớp 8', 1),
('SP025', N'Sách giáo khoa Toán(Tập 1) lớp 8', 1),
('SP026', N'Sách giáo khoa Lịch sử lớp 9', 1),
('SP027', N'Sách giáo khoa Địa lớp 9', 1),
('SP028', N'Sách giáo khoa Sinh học lớp 9', 1),
('SP029', N'Sách giáo khoa Vật lí lớp 9', 1),
('SP030', N'Sách giáo khoa Toán(Tập 1) lớp 9', 1),
('SP031', N'Sách giáo khoa Toán Đại Số 10', 1),
('SP032', N'Sách giáo khoa Văn(Tập 1) 10', 1),
('SP033', N'Sách giáo khoa Lịch sử 10', 1),
('SP034', N'Sách giáo khoa Địa lý 10', 1),
('SP035', N'Sách giáo khoa Sinh học 10', 1),
('SP036', N'Sách giáo khoa Vật lí 10', 1),
('SP037', N'Sách giáo khoa Hóa học 10', 1),
('SP038', N'Sách giáo khoa Toán Đại Số 11', 1),
('SP039', N'Sách giáo khoa Văn(Tập 1) 11', 1),
('SP040', N'Sách giáo khoa Lịch sử 11', 1);
--S?n ph?m chi ti?t
INSERT INTO SanPhamChiTiet (IDNhaCungCap, IDSanPham, IDTheLoai, IDTacGia, IDMauSac, SoLuongTon, GiaNhap, GiaBan, NamPhatHanh) VALUES
	(1, 1, 1, 1, 3, 50, 19000, 21000, 2021),
    (2, 2, 1, 1, 1, 55, 19000, 21000, 2021),
    (3, 3, 1, 2, 2, 54, 18000, 19000, 2020),
    (4, 4, 1, 1, 3, 21, 16500, 17000, 2019),
    (5, 5, 1, 1, 2, 21, 19000, 21000, 2021),
    (1, 6, 1, 2, 2, 21, 11000, 12000, 2018),
    (1, 7, 1, 1, 6, 21, 11500, 15000, 2021),
    (1, 8, 1, 1, 1, 21, 17000, 19000, 2022),
    (1, 9, 1, 2, 3, 21, 18000, 19500, 2017),
    (2, 10, 1, 1, 3, 55, 21000, 22000, 2022),
    (2, 11, 1, 1, 1, 55, 21000, 22000, 2023),
    (2, 12, 2, 3, 7, 68, 31000, 32000, 2021),
    (2, 13, 2, 4, 6, 68, 27000, 28000, 2023),
    (3, 14, 2, 5, 2, 68, 24000, 25000, 2021),
    (3, 15, 2, 6, 3, 68, 24500, 25000, 2022),
    (3, 16, 2, 7, 7, 68, 27000, 28000, 2020),
    (3, 17, 2, 3, 2, 68, 29000, 30000, 2022),
    (4, 18, 2, 4, 6, 68, 27000, 28000, 2023),
    (4, 19, 2, 5, 2, 68, 24000, 25000, 2021),
    (3, 20, 2, 6, 2, 68, 24000, 25000, 2019),
    (2, 21, 2, 7, 7, 68, 29000, 30000, 2022),
    (1, 22, 2, 3, 1, 68, 29000, 30000, 2022),
    (1, 23, 2, 4, 2, 68, 38000, 39000, 2021),
    (2, 24, 2, 5, 6, 68, 24000, 25000, 2022),
    (2, 25, 2, 6, 7, 68, 28000, 29000, 2023),
    (2, 26, 2, 7, 6, 68, 30000, 31000, 2023),
    (3, 27, 2, 3, 2, 68, 20000, 20000, 2023),
    (3, 28, 2, 4, 2, 68, 35500, 36000, 2020),
    (4,  29, 2, 5, 7, 68, 16500, 17000, 2020),
    (5, 30, 2, 6, 8, 68, 28000, 29000, 2022),
	(5, 31, 3, 8, 2, 54, 38000, 38000, 2021),
	(5, 32, 3, 9, 1, 55, 38000, 38500, 2020),
    (5, 33, 3, 7, 7, 54, 24000, 25500, 2023),
    (4, 34, 3, 10, 2, 68, 24000, 25500, 2022),
    (4, 35, 3, 11, 6, 68, 28000, 29000, 2022),
    (5, 36, 3, 12, 6, 54, 26000, 27000, 2021),
    (1, 37, 3, 13, 2, 54, 28000, 29000, 2020),
    (2, 38, 3, 8, 1, 54, 20000, 21000, 2023),
    (3, 39, 3, 9, 5, 55, 29500, 30000, 2023),
    (5, 40, 3, 7, 7, 68, 34000, 35400, 2021 );
-- Nh?p li?u cho b?ng KhachHang
INSERT INTO KhachHang (MaKhachHang, TenKhachHang, NgaySinh, GioiTinh, DiaChi, SDT, Email) VALUES
('KH01', N'Nguyễn Văn A', '1980-01-01', 1, N'Hà Nội', '0912345678', 'vana@gmail.com'),
('KH02', N'Trần Thị B', '1985-02-02', 0, N'Hải Phòng', '0923456789', 'thib@gmail.com'),
('KH03', N'Lê Văn C', '1990-03-03', 1, N'Đà Nẵng', '0934567890', 'vanc@gmail.com'),
('KH04', N'Phạm Thị D', '1995-04-04', 0, N'TP HCM', '0945678901', 'thid@gmail.com'),
('KH05', N'Hoàng Văn E', '2000-05-05', 1, N'Cần Thơ', '0956789012', 'vane@gmail.com');

-- Nh?p li?u cho b?ng NhanVien
INSERT INTO NhanVien (IDChucVu, MaNhanVien, TenNhanVien, GioiTinh, NgaySinh, DiaChi, SDT, MatKhau, TrangThai) VALUES
(2, 'NV01', N'Nguyễn Văn Q', 1, '1980-06-06', N'Hà Nội', '0901234567', 'matkhau1@', 1),
(2, 'NV02', N'Trần Thị W', 0, '1985-07-07', N'Hải Phòng', '0902345678', 'matkhau2@', 1),
(2, 'NV03', N'Lê Văn E', 1, '1990-08-08', N'Đà Nẵng', '0903456789', 'matkhau3@', 1),
(2, 'NV04', N'Phạm Thị R', 0, '1995-09-09', N'TP HCM', '0904567890', 'matkhau4@', 1),
(1, 'NV05', N'Hoàng Văn T', 1, '2000-10-10', N'Cần Thơ', '0905678901', 'matkhau5@', 1);

--Voucher
INSERT INTO Voucher (MaVoucher, GiamPhanTram, SoLanSuDung)
VALUES	
	('VOUCHER2024', 15, 5),
	('SUMMER2024', 10, 2),
	('WINTER2024', 20, 4);
