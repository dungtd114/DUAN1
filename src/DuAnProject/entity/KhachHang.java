/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAnProject.entity;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class KhachHang {
    private Integer idKhachHang;
    private String maKhachHang;
    private String tenKhachHang;
    private Date ngaySinh;
    private boolean gioiTinh;
    private String diaChi;
    private String soDienThoai;
    private String email;

    public KhachHang() {
    }

    public KhachHang(Integer idKhachHang, String maKhachHang, String tenKhachHang, Date ngaySinh, boolean gioiTinh, String diaChi, String soDienThoai, String email) {
        this.idKhachHang = idKhachHang;
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.email = email;
    }

    public KhachHang(Integer idKhachHang, String tenKhachHang, String diaChi, String soDienThoai) {
        this.idKhachHang = idKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }

    public Integer getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(Integer idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public KhachHang(String tenKhachHang, String soDienThoai) {
        this.tenKhachHang = tenKhachHang;
        this.soDienThoai = soDienThoai;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "idKhachHang=" + idKhachHang + ", maKhachHang=" + maKhachHang + ", tenKhachHang=" + tenKhachHang + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", soDienThoai=" + soDienThoai + ", email=" + email + '}';
    }
    
}
