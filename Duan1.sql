create database DuAn1
go
use DuAn1
 --Create table Nhan_vien
CREATE TABLE Nhan_vien (
    IDNhanVien nvarchar(10) PRIMARY KEY,
    IDTaiKhoan nvarchar(10) NOT NULL,
    IDChucVu nvarchar(10) NOT NULL,
    TenNhanVien NVARCHAR(255) NOT NULL,
    GioiTinh bit not NULL,
    NgaySinh DATE not NULL,
    SoDienThoai NVARCHAR(15) not NULL,
    Email NVARCHAR(255) NULL,
    DiaChi Nvarchar(550) not NULL,
    TrangThai bit default 0
    
);
 --Create table Tai_Khoan
CREATE TABLE Tai_Khoan (
    IDTaiKhoan nvarchar(10) PRIMARY KEY,
    TaiKhoan NVARCHAR(255) NOT NULL,
    MatKhau NVARCHAR(255) NOT NULL,
    TenNhanVien NVARCHAR(255) NOT NULL
);
 --Create table Chuc_vu
CREATE TABLE Chuc_vu (
    IDChucVu nvarchar(10) PRIMARY KEY,
    TenChucVu NVARCHAR(255) NOT NULL,
    MoTa Nvarchar(550) NULL
);
 --Create table Khach_hang
CREATE TABLE Khach_hang (
    IDKhachHang nvarchar(10) PRIMARY KEY,
    TenKhachHang NVARCHAR(255) NOT NULL,
    GioiTinh bit not NULL,
    SoDienThoai NVARCHAR(15) not NULL,
    DiaChi Nvarchar(550) not NULL,
    TrangThai NVARCHAR(50) NULL
);
 --Create table San_pham
CREATE TABLE San_pham (
    IDSanPham nvarchar(10) PRIMARY KEY,
    TenSanPham NVARCHAR(255) NOT NULL,
    TrangThai NVARCHAR(50) not NULL,
    ThanhTien float NOT NULL
);
 --Create table Chi_tiet_san_pham
CREATE TABLE Chi_tiet_san_pham (
    IDChiTietSanPham nvarchar(10) PRIMARY KEY,
    TenSanPham NVARCHAR(255) NOT NULL,
    AnhSanPham NVARCHAR(255) NULL,
    SoLuongTon INT NOT NULL,
    GiaNhap float NOT NULL,
    NhaXuatBan NVARCHAR(255) NULL,
    IDDoDay nvarchar(10) NOT NULL,
    IDSanPham nvarchar(10) NOT NULL,
    IDNhaCungCap nvarchar(10) NOT NULL,
    IDKichThuoc nvarchar(10) NOT NULL,
    IDChuBien nvarchar(10) NOT NULL,    
);
 --Create table Nha_Cung_Cap
CREATE TABLE Nha_Cung_Cap (
    IDNhaCungCap nvarchar(10) PRIMARY KEY,
    Ten NVARCHAR(255) NOT NULL,
    Sodienthoai NVARCHAR(15) NULL,
    DiaChi Nvarchar(550) NULL
);

 --Create table Mau_sac
CREATE TABLE Chu_bien (
    IDChuBien nvarchar(10) PRIMARY KEY,
    Ten NVARCHAR(255) NOT NULL,
    MoTa Nvarchar(550) NULL
);

 --Create table Do_day
CREATE TABLE Do_day (
    IDDoDay nvarchar(10) PRIMARY KEY,
    DoDay NVARCHAR(255) NOT NULL,
    MoTa Nvarchar(550) NULL
);

 --Create table Chat_lieu
CREATE TABLE Kich_thuoc (
    IDKichThuoc nvarchar(10) PRIMARY KEY,
    ChieuRong NVARCHAR(25) NOT NULL,
	ChieuCao NVARCHAR(25) NOT NULL,
    MoTa Nvarchar(550) NULL
);
 --Create table Hoa_don
CREATE TABLE Hoa_don (
    IDHoaDon nvarchar(10) PRIMARY KEY,
    IDKhachHang nvarchar(10) NOT NULL,
    IDNhanVien nvarchar(10) NOT NULL,
    NgayTao DATE NOT NULL,
    NgayKetThuc DATE not NULL,
    Tinh_trang NVARCHAR(50) not NULL    
);
 --Create table Hoa_don_Chi_tiet
CREATE TABLE Hoa_don_Chi_tiet (
    IDHoaDonChiTiet nvarchar(10) PRIMARY KEY,
	SoLuong int NOT NULL,
    DonGia float NOT NULL,
    IDChiTietSanPham nvarchar(10) NOT NULL,   
    IDHoaDon nvarchar(10) NOT NULL
	
);
--Nối bảng
alter table Nhan_vien add FOREIGN KEY (IDTaiKhoan) REFERENCES Tai_Khoan(IDTaiKhoan)
alter table Nhan_vien add FOREIGN KEY (IDChucVu) REFERENCES Chuc_vu(IDChucVu)
alter table Chi_tiet_san_pham add FOREIGN KEY (IDDoDay) REFERENCES Do_day(IDDoDay)
alter table Chi_tiet_san_pham add FOREIGN KEY ( IDSanPham) REFERENCES San_pham( IDSanPham)
alter table Chi_tiet_san_pham add FOREIGN KEY (IDNhaCungCap) REFERENCES Nha_Cung_Cap(IDNhaCungCap)
alter table Chi_tiet_san_pham add FOREIGN KEY (IDKichThuoc) REFERENCES Kich_thuoc(IDKichThuoc)
alter table Chi_tiet_san_pham add FOREIGN KEY (IDChuBien) REFERENCES Chu_bien(IDChuBien)
alter table Hoa_don add FOREIGN KEY (IDKhachHang) REFERENCES Khach_hang(IDKhachHang)
alter table Hoa_don add FOREIGN KEY (IDNhanVien) REFERENCES Nhan_vien(IDNhanVien)
alter table Hoa_don_Chi_tiet add FOREIGN KEY (IDChiTietSanPham) REFERENCES Chi_tiet_san_pham(IDChiTietSanPham)
alter table Hoa_don_Chi_tiet add FOREIGN KEY (IDHoaDon) REFERENCES Hoa_don(IDHoaDon)
--Nhập dữ liệu

--đăng nhập
INSERT INTO Tai_Khoan(IDTaiKhoan,TaiKhoan,MatKhau,TenNhanVien)
VALUES 
    ('DN001', 'user1', 'password1', 'Nguyễn Văn A'),
    ('DN002', 'user2', 'password2', 'Trần Thị B'),
    ('DN003', 'user3', 'password3', 'Lê Văn C'),
    ('DN004', 'user4', 'password4', 'Phạm Thị D'),
    ('DN005', 'user5', 'password5', 'Hoàng Văn E'),
	('DN006', 'user6', 'password6', 'Đinh Văn T')
--Chức vụ
INSERT INTO Chuc_vu (IDChucVu,TenChucVu,MoTa)
VALUES 
    ('CV001', 'Bảo vệ', null),
    ('CV002', 'Nhân viên', null),
    ('CV003', 'Quản lý', 'Quản lý nhân viên'),
    ('CV004', 'Thu ngân', 'Thanh toán sản phẩm');
	--Nhân viên
INSERT INTO Nhan_vien (IDNhanVien,IDTaiKhoan,IDChucVu ,TenNhanVien ,GioiTinh ,NgaySinh ,SoDienThoai ,Email ,DiaChi ,TrangThai)
VALUES 
    ('NV001', 'DN001', 'CV001', 'Nguyễn Văn A', 0, '1990-01-15', '0901234567', 'nva@example.com', 'Cầu Giấy, Hà Nội', 1),
    ('NV002', 'DN002', 'CV002', 'Trần Thị B', 1, '1995-05-20', '0987654321', 'ttb@example.com', 'Nam Từ Liêm, Hà Nội', 1),
    ('NV003', 'DN003', 'CV003', 'Lê Văn C', 0, '1988-11-10', '0978123456', 'lvc@example.com', 'Hà Đông, Hà Nội', 1),
    ('NV004', 'DN004', 'CV002', 'Phạm Thị D', 1, '1992-09-25', '0912345678', 'ptd@example.com', 'Cầu Giấy, Hà Nội', 0),
    ('NV005', 'DN005', 'CV004', 'Hoàng Văn E', 0, '1998-03-05', '0956781234', 'hve@example.com', 'Bắc Từ Liêm, Hà Nội', 1),
	('NV006', 'DN006', 'CV002', 'Đinh Văn T', 0, '1998-07-06', '0956781578', 'hvoe@example.com', 'Thanh Xuân, Hà Nội', 1)
	
	--khách hàng
INSERT INTO Khach_hang (IDKhachHang, TenKhachHang, GioiTinh, SoDienThoai, DiaChi, TrangThai)
VALUES
    ('KH001', 'Phạm Văn A', 1, '0901234567', 'Hai Bà Trưng, Hà Nội', NULL),
    ('KH002', 'Lê Thị B', 0, '0912345678', 'Kiều Mai, Hà Nội', NULL),
    ('KH003', 'Nguyễn Văn C', 1, '0923456789', 'Mỹ Đình, Hà Nội', NULL),
    ('KH004', 'Trần Thị D', 0, '0934567890', 'Tây Hồ, Hà Nội', null),
    ('KH005', 'Hoàng Văn F', 1, '0945678901', 'Thanh Xuân, Hà Nội',null);
	--Sản phẩm
	
INSERT INTO San_pham (IDSanPham, TenSanPham, TrangThai,ThanhTien) 
VALUES
('SP001', 'Sách Tiếng Việt 1 (Tập 1)', 'Đang bán', 21000),
('SP002', 'Sách Tiếng Việt 1 (Tập 2)', 'Đang bán', 21000),
('SP003', 'Sách Toán 1', 'Có giới hạn', 19000),
('SP004', 'Sách Tiếng Việt 2 (Tập 1)', 'Có giới hạn', 17000),
('SP005', 'Sách Tiếng Việt 2 (Tập 2)', 'Đang bán', 20000),
('SP006', 'Sách Toán 2', 'Đang bán', 12000),
('SP007', 'Sách Tiếng Việt 3 (Tập 1)', 'Đang bán', 12000),
('SP008', 'Sách Tiếng Việt 3 (Tập 2)', 'Ngưng bán', 17000),
('SP009', 'Sách Toán 3', 'Ngưng bán', 18000),
('SP010', 'Sách Tiếng Việt 4 (Tập 1)', 'Đang bán', 22000),
('SP011', 'Sách Tiếng Việt 4 (Tập 2)', 'Có giới hạn', 21000),
('SP012', 'Sách giáo khoa Địa lớp 6', 'Đang bán', 32000),
('SP013', 'Sách giáo khoa Sinh học lớp 6', 'Đang bán', 28000),
('SP014', 'Sách giáo khoa Vật lí lớp 6', 'Có giới hạn', 25000),
('SP015', 'Sách giáo khoa Toán(Tập 1) lớp 6', 'Tạm hết hàng', 25000),
('SP016', 'Sách giáo khoa Lịch sử lớp 7', 'Đang bán', 28000),
('SP017', 'Sách giáo khoa Địa lớp 7', 'Đang bán', 32000),
('SP018', 'Sách giáo khoa Sinh học lớp 7', 'Đang bán', 28000),
('SP019', 'Sách giáo khoa Vật lí lớp 7', 'Có giới hạn', 25000),
('SP020', 'Sách giáo khoa Toán(Tập 1) lớp 7', 'Đang bán', 25000),
('SP021', 'Sách giáo khoa Lịch sử lớp 8', 'Có giới hạn', 30000),
('SP022', 'Sách giáo khoa Địa lớp 8', 'Có giới hạn', 30000),
('SP023', 'Sách giáo khoa Sinh học lớp 8', 'Đang bán', 40000),
('SP024', 'Sách giáo khoa Vật lí lớp 8', 'Đang bán', 25000),
('SP025', 'Sách giáo khoa Toán(Tập 1) lớp 8', 'Đang bán', 28000),
('SP026', 'Sách giáo khoa Lịch sử lớp 9', 'Đang bán', 32000),
('SP027', 'Sách giáo khoa Địa lớp 9', 'Đang bán', 21000),
('SP028', 'Sách giáo khoa Sinh học lớp 9', 'Đang bán', 37000),
('SP029', 'Sách giáo khoa Vật lí lớp 9', 'Đang bán', 18000),
('SP030', 'Sách giáo khoa Toán(Tập 1) lớp 9', 'Đang bán', 29000),
('SP031', 'Sách giáo khoa Toán Đại Số 10', 'Tạm hết hàng', 39000),
('SP032', 'Sách giáo khoa Văn(Tập 1) 10', 'Đang bán', 40000),
('SP033', 'Sách giáo khoa Lịch sử 10', 'Đang bán', 28000),
('SP034', 'Sách giáo khoa Địa lý 10', 'Có giới hạn', 25000),
('SP035', 'Sách giáo khoa Sinh học 10', 'Đang bán', 35000),
('SP036', 'Sách giáo khoa Vật lí 10', 'Có giới hạn', 35000),
('SP037', 'Sách giáo khoa Hóa học 10', 'Có giới hạn', 35000),
('SP038', 'Sách giáo khoa Toán Đại Số 11', 'Đang bán', 25000),
('SP039', 'Sách giáo khoa Văn(Tập 1) 11', 'Đang bán', 30000),
('SP040', 'Sách giáo khoa Lịch sử 11', 'Đang bán', 36000);

--Nhà cung cấp
INSERT INTO Nha_Cung_Cap (IDNhaCungCap, Ten, Sodienthoai, DiaChi)
VALUES
('NCC01', 'An Lộc', '0123456781', 'Hai Bà Trưng, Hà Nội'),
('NCC02', 'Hải Hà', '0123456782', 'Thanh Xuân, Hà Nội'),
('NCC03', 'Bảo Khang', '0123456783', 'Ba Đình, Hà Nội'),
('NCC04', 'Minh Khôi', '0123456784', 'Hoàng Mai, Hà Nội'),
('NCC05', 'Duy Nam', '0123456785', 'Đống Đa, Hà Nội')
 
 --Độ dày
	INSERT INTO Do_day (IDDoDay, DoDay, MoTa)
VALUES
    ('DD001', '4mm', 'Thường dành cho sách giáo tiểu học'),
    ('DD002', '5mm', 'Thường là sách lớp 3'),
    ('DD003', '15mm', 'Thường là sách toán'),
    ('DD004', '8mm', 'Thường là sách văn'),
    ('DD005', '6mm', 'Thường là sách bộ môn');

--Kích thước
INSERT INTO Kich_thuoc (IDKichThuoc, ChieuRong, ChieuCao, MoTa)
VALUES
    ('KT001', '19cm', '26.5cm', 'Kích thước sách giáo khoa lớp 3'),
    ('KT002', '19cm', '28cm', 'Kích thước sách giáo khoa lớp 6'),
    ('KT003', '17cm', '24 cm', 'Kích thước sách giáo khoa lớp 7'),
    ('KT004', '17cm', '24 cm', 'Kích thước sách giáo khoa lớp 12')

--Chủ biên
INSERT INTO Chu_bien (IDChuBien, Ten, MoTa) VALUES
('CB001', 'Nguyễn Minh Thuyết', 'Sách tiếng việt tiểu học'),
('CB002', 'Đỗ Đình Hoan', 'Sách toán tiểu học'),
('CB003', 'Nguyễn Dược', 'Sách Địa THCS'),
('CB004', 'Nguyễn Quang Vinh', 'Sách Sinh THCS'),
('CB005', 'Vũ Quang', 'Sách Vật lí THCS'),
('CB006', 'Phan Đức Chính', 'Sách Toán THCS'),
('CB007', 'Phan Ngọc Liên', 'Sách Sử THCS&THPT'),
('CB008', 'Trần Văn Hạo', 'Sách Toán THPT'),
('CB009', 'Phan Trọng Luận', 'Sách Văn THPT'),
('CB010', 'Lê Thông', 'Sách Địa THPT'),
('CB011', 'Nguyễn Thành Đạt', 'Sách Sinh THPT'),
('CB012', 'Lương Duyên Bình', 'Sách Vật lí THPT'),
('CB013', 'Nguyễn Xuân Trường', 'Sách Hoá THPT');

--Chi tiết SP
	INSERT INTO Chi_tiet_san_pham (IDChiTietSanPham, TenSanPham, AnhSanPham, SoLuongTon, GiaNhap, NhaXuatBan, IDDoDay, IDSanPham, IDNhaCungCap, IDKichThuoc, IDChuBien)
VALUES
    ('CTSP001', 'Sách Tiếng Việt 1 (Tập 1)', NUll, 100, 19000, 'NXB Giáo dục', 'DD004', 'SP001', 'NCC01', 'KT001', 'CB001'),
    ('CTSP002', 'Sách Tiếng Việt 1 (Tập 2)', null, 120, 19000, 'NXB Giáo dục', 'DD004', 'SP002', 'NCC02', 'KT001', 'CB001'),
    ('CTSP003', 'Sách Toán 1', null, 80, 18000, 'NXB Giáo dục', 'DD003', 'SP003', 'NCC03', 'KT001', 'CB002'),
    ('CTSP004', 'Sách Tiếng Việt 2 (Tập 1)', null, 90, 16500, 'NXB Giáo dục', 'DD001', 'SP004', 'NCC04', 'KT001', 'CB001'),
    ('CTSP005', 'Sách Tiếng Việt 2 (Tập 2)', null, 110, 19000, 'NXB Giáo dục', 'DD001', 'SP005', 'NCC05', 'KT001', 'CB001'),
    ('CTSP006', 'Sách Toán 2', null, 95, 11000, 'NXB Giáo dục', 'DD001', 'SP006', 'NCC01', 'KT001', 'CB002'),
    ('CTSP007', 'Sách Tiếng Việt 3 (Tập 1)', null, 85, 11500, 'NXB Giáo dục', 'DD001', 'SP007', 'NCC01', 'KT001', 'CB001'),
    ('CTSP008', 'Sách Tiếng Việt 3 (Tập 2)', null, 75, 17000, 'NXB Giáo dục', 'DD001', 'SP008', 'NCC01', 'KT001', 'CB001'),
    ('CTSP009', 'Sách Toán 3', null, 70, 18000, 'NXB Giáo dục', 'DD001', 'SP009', 'NCC03', 'KT001', 'CB002'),
    ('CTSP010', 'Sách Tiếng Việt 4 (Tập 1)', null, 65, 21000, 'NXB Giáo dục', 'DD004', 'SP010', 'NCC03', 'KT001', 'CB001'),
    ('CTSP011', 'Sách Tiếng Việt 4 (Tập 2)', null, 60, 21000, 'NXB Giáo dục', 'DD004', 'SP011', 'NCC01', 'KT001', 'CB001'),
    ('CTSP012', 'Sách giáo khoa Địa lớp 6', null, 55, 31000, 'NXB Giáo dục', 'DD005', 'SP012', 'NCC02', 'KT002', 'CB003'),
    ('CTSP013', 'Sách giáo khoa Sinh học lớp 6', null, 105, 27000, 'NXB Giáo dục', 'DD005', 'SP013', 'NCC03', 'KT002', 'CB004'),
    ('CTSP014', 'Sách giáo khoa Vật lí lớp 6', null, 115, 24000, 'NXB Giáo dục', 'DD005', 'SP014', 'NCC04', 'KT002', 'CB005'),
    ('CTSP015', 'Sách giáo khoa Toán(Tập 1) lớp 6', null, 100, 24500, 'NXB Giáo dục', 'DD005', 'SP015', 'NCC05', 'KT002', 'CB006'),
    ('CTSP016', 'Sách giáo khoa Lịch sử lớp 7', null, 95, 27000, 'NXB Giáo dục', 'DD005', 'SP016', 'NCC04', 'KT003', 'CB007'),
    ('CTSP017', 'Sách giáo khoa Địa lớp 7', null, 90, 29000, 'NXB Giáo dục', 'DD005', 'SP017', 'NCC01', 'KT003', 'CB003'),
    ('CTSP018', 'Sách giáo khoa Sinh học lớp 7', null, 85, 27000, 'NXB Giáo dục', 'DD005', 'SP018', 'NCC05', 'KT003', 'CB004'),
    ('CTSP019', 'Sách giáo khoa Vật lí lớp 7', null, 80, 24000, 'NXB Giáo dục', 'DD005', 'SP019', 'NCC02', 'KT003', 'CB005'),
    ('CTSP020', 'Sách giáo khoa Toán(Tập 1) lớp 7', null, 75, 24000, 'NXB Giáo dục', 'DD005', 'SP020', 'NCC02', 'KT003', 'CB006'),
    ('CTSP021', 'Sách giáo khoa Lịch sử lớp 8', null, 70, 29000, 'NXB Giáo dục', 'DD005', 'SP021', 'NCC02', 'KT003', 'CB007'),
    ('CTSP022', 'Sách giáo khoa Địa lớp 8', null, 65, 29000, 'NXB Giáo dục', 'DD005', 'SP022', 'NCC05', 'KT003', 'CB003'),
    ('CTSP023', 'Sách giáo khoa Sinh học lớp 8', null, 60, 38000, 'NXB Giáo dục', 'DD005', 'SP023', 'NCC05', 'KT003', 'CB004'),
    ('CTSP024', 'Sách giáo khoa Vật lí lớp 8', null, 55, 24000, 'NXB Giáo dục', 'DD005', 'SP024', 'NCC04', 'KT003', 'CB005'),
    ('CTSP025', 'Sách giáo khoa Toán(Tập 1) lớp 8', null, 110, 28000, 'NXB Giáo dục', 'DD005', 'SP025', 'NCC05', 'KT003', 'CB006'),
    ('CTSP026', 'Sách giáo khoa Lịch sử lớp 9', null, 105, 30000, 'NXB Giáo dục', 'DD005', 'SP026', 'NCC03', 'KT003', 'CB007'),
    ('CTSP027', 'Sách giáo khoa Địa lớp 9', null, 100, 20000, 'NXB Giáo dục', 'DD005', 'SP027', 'NCC02', 'KT004', 'CB003'),
    ('CTSP028', 'Sách giáo khoa Sinh học lớp 9', null, 95, 35500, 'NXB Giáo dục', 'DD005', 'SP028', 'NCC01', 'KT004', 'CB004'),
    ('CTSP029',  'Sách giáo khoa Vật lí lớp 9', null, 90, 16500, 'NXB Giáo dục', 'DD005', 'SP029', 'NCC02', 'KT003', 'CB005'),
    ('CTSP030', 'Sách giáo khoa Toán(Tập 1) lớp 9', null, 85, 28000, 'NXB Giáo dục', 'DD005', 'SP030', 'NCC03', 'KT003', 'CB006'),
	('CTSP031', 'Sách giáo khoa Toán Đại Số 10', null, 85, 38000, 'NXB Giáo dục', 'DD003', 'SP031', 'NCC01', 'KT003', 'CB008'),
	('CTSP032', 'Sách giáo khoa Văn(Tập 1) 10', null, 85, 38000, 'NXB Giáo dục', 'DD004', 'SP032', 'NCC02', 'KT004', 'CB009'),
    ('CTSP033',  'Sách giáo khoa Lịch sử 10', null, 70, 24000, 'NXB Giáo dục', 'DD003', 'SP033', 'NCC03', 'KT004', 'CB007'),
    ('CTSP034', 'Sách giáo khoa Địa lý 10', null, 65, 24000, 'NXB Giáo dục', 'DD005', 'SP034', 'NCC04', 'KT004', 'CB010'),
    ('CTSP035', 'Sách giáo khoa Sinh học 10', null, 60, 28000, 'NXB Giáo dục', 'DD005', 'SP035', 'NCC05', 'KT002', 'CB011'),
    ('CTSP036', 'Sách giáo khoa Vật lí 10', null, 105, 26000, 'NXB Giáo dục', 'DD003', 'SP036', 'NCC04', 'KT004', 'CB012'),
    ('CTSP037', 'Sách giáo khoa Hóa học 10', null, 100, 28000, 'NXB Giáo dục', 'DD003', 'SP037', 'NCC05', 'KT002', 'CB013'),
    ('CTSP038', 'Sách giáo khoa Toán Đại Số 11', null, 95, 20000, 'NXB Giáo dục', 'DD003', 'SP038', 'NCC05', 'KT001', 'CB008'),
    ('CTSP039', 'Sách giáo khoa Văn(Tập 1) 11', null, 90, 29500, 'NXB Giáo dục', 'DD004', 'SP039', 'NCC04', 'KT001', 'CB009'),
    ('CTSP040', 'Sách giáo khoa Lịch sử 11', null, 85, 34000, 'NXB Giáo dục', 'DD005', 'SP040', 'NCC05', 'KT002', 'CB007');

	
	--hoá đơn
	--INSERT INTO Hoa_don (IDHoaDon, IDKhachHang, IDNhanVien, NgayTao, NgayKetThuc, Tinh_trang)
--VALUES
--('HD01', 'KH01', 'NV001', '2023-01-01', '2023-01-02', 'Completed'),
--('HD02', 'KH02', 'NV002', '2023-01-02', '2023-01-03', 'Pending'),
--('HD03', 'KH03', 'NV003', '2023-01-03', '2023-01-04', 'Completed'),
--('HD04', 'KH04', 'NV004', '2023-01-04', '2023-01-05', 'Pending'),
--('HD05', 'KH05', 'NV005', '2023-01-05', '2023-01-06', 'Completed'),
--('HD06', 'KH06', 'NV06', '2023-01-06', '2023-01-07', 'Pending'),
--('HD07', 'KH07', 'NV07', '2023-01-07', '2023-01-08', 'Completed'),
--('HD08', 'KH08', 'NV08', '2023-01-08', '2023-01-09', 'Pending'),
--('HD09', 'KH09', 'NV09', '2023-01-09', '2023-01-10', 'Completed'),
--('HD10', 'KH10', 'NV10', '2023-01-10', '2023-01-11', 'Pending');
	---Hoá đơn chi tiết 
	--INSERT INTO Hoa_don_Chi_tiet (IDHoaDonChiTiet, NgayTao, IDChiTiet, SoLuong, IDHoaDon)
--VALUES
--('HDC01', '2023-01-01', 'CT01', '10', 'HD01'),
--('HDC02', '2023-01-02', 'CT02', '20', 'HD02'),
--('HDC03', '2023-01-03', 'CT03', '30', 'HD03'),
--('HDC04', '2023-01-04', 'CT04', '40', 'HD04'),
--('HDC05', '2023-01-05', 'CT05', '50', 'HD05'),
--('HDC06', '2023-01-06', 'CT06', '60', 'HD06'),
--('HDC07', '2023-01-07', 'CT07', '70', 'HD07'),
--('HDC08', '2023-01-08', 'CT08', '80', 'HD08'),
--('HDC09', '2023-01-09', 'CT09', '90', 'HD09'),
--('HDC10', '2023-01-10', 'CT10', '100', 'HD10');

	