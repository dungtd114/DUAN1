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
public class HoaDon {
    private Integer idHoaDon;
    private Integer idKhachHang;
    private Integer idNhanVien;
    private Date ngayTao;
    private Date ngayThanhToan;
    private boolean tinhTrang;
    private String nguoiNhan;
    private String soDienThoai;
    private float tongTien;
    public HoaDon() {
    }

    public HoaDon(Integer idHoaDon, Integer idKhachHang, Integer idNhanVien, Date ngayTao, Date ngayThanhToan, boolean tinhTrang, String nguoiNhan, String soDienThoai, float tongTien) {
        this.idHoaDon = idHoaDon;
        this.idKhachHang = idKhachHang;
        this.idNhanVien = idNhanVien;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tinhTrang = tinhTrang;
        this.nguoiNhan = nguoiNhan;
        this.soDienThoai = soDienThoai;
        this.tongTien = tongTien;
    }

    public Integer getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(Integer idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public Integer getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(Integer idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public Integer getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(Integer idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getNguoiNhan() {
        return nguoiNhan;
    }

    public void setNguoiNhan(String nguoiNhan) {
        this.nguoiNhan = nguoiNhan;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "idHoaDon=" + idHoaDon + ", idKhachHang=" + idKhachHang + ", idNhanVien=" + idNhanVien + ", ngayTao=" + ngayTao + ", ngayThanhToan=" + ngayThanhToan + ", tinhTrang=" + tinhTrang + ", nguoiNhan=" + nguoiNhan + ", soDienThoai=" + soDienThoai + ", tongTien=" + tongTien + '}';
    }

    public HoaDon(float tongTien) {
        this.tongTien = tongTien;
    }

    public HoaDon(Integer idKhachHang, String nguoiNhan, String soDienThoai) {
        this.idKhachHang = idKhachHang;
        this.nguoiNhan = nguoiNhan;
        this.soDienThoai = soDienThoai;
    }

    

    
    
}
