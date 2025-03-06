/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAnProject.entity;

/**
 *
 * @author Admin
 */
public class HoaDonChiTiet {

    private Integer idHoaDonChiTiet;
    private Integer idHoaDon;
    private Integer idSanPhamChiTiet;
    private Integer soLuong;
    private float donGia;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(Integer idHoaDonChiTiet, Integer idHoaDon, Integer idSanPhamChiTiet, Integer soLuong, float donGia) {
        this.idHoaDonChiTiet = idHoaDonChiTiet;
        this.idHoaDon = idHoaDon;
        this.idSanPhamChiTiet = idSanPhamChiTiet;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public HoaDonChiTiet(Integer idSanPhamChiTiet, Integer soLuong, float donGia) {
        this.idSanPhamChiTiet = idSanPhamChiTiet;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }
    

    public Integer getIdHoaDonChiTiet() {
        return idHoaDonChiTiet;
    }

    public void setIdHoaDonChiTiet(Integer idHoaDonChiTiet) {
        this.idHoaDonChiTiet = idHoaDonChiTiet;
    }

    public Integer getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(Integer idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public Integer getIdSanPhamChiTiet() {
        return idSanPhamChiTiet;
    }

    public void setIdSanPhamChiTiet(Integer idSanPhamChiTiet) {
        this.idSanPhamChiTiet = idSanPhamChiTiet;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public HoaDonChiTiet(Integer idHoaDon) {
        this.idHoaDon = idHoaDon;
    }    
    

    @Override
    public String toString() {
        return "HoaDonChiTiet{" + "idHoaDonChiTiet=" + idHoaDonChiTiet + ", idHoaDon=" + idHoaDon + ", idSanPhamChiTiet=" + idSanPhamChiTiet + ", soLuong=" + soLuong + ", donGia=" + donGia + '}';
    }
    
    
}
