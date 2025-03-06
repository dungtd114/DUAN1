/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAnProject.entity;

import java.util.Date;

/**
 *
 * @author quyet
 */
public class NhanVien {
    private Integer iDNhanVien;
    private String maNhanVien;
    private String tenNhanVien;
    private boolean gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String SDT;
    private String matKhau;
    private Integer IDChucVu;
    private boolean trangThai;
    private ChucVu ChucVu;
    public NhanVien() {
    }

    public NhanVien(Integer iDNhanVien, String maNhanVien, String tenNhanVien, boolean gioiTinh, Date ngaySinh, String diaChi, String SDT, String matKhau, Integer IDChucVu, boolean trangThai, ChucVu ChucVu) {
        this.iDNhanVien = iDNhanVien;
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.SDT = SDT;
        this.matKhau = matKhau;
        this.IDChucVu = IDChucVu;
        this.trangThai = trangThai;
	this.ChucVu = ChucVu;
    }

    public Integer getiDNhanVien() {
        return iDNhanVien;
    }

    public void setiDNhanVien(Integer iDNhanVien) {
        this.iDNhanVien = iDNhanVien;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public Integer getIDChucVu() {
        return IDChucVu;
    }

    public void setIDChucVu(Integer IDChucVu) {
        this.IDChucVu = IDChucVu;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }    

    public ChucVu getChucVu() {
        return ChucVu;
    }

    public void setChucVu(ChucVu ChucVu) {
        this.ChucVu = ChucVu;
    }
}
