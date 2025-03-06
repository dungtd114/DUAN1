/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAnProject.responses;

/**
 *
 * @author Admin
 */
public class HoaDonChiTietResponses {
    private Integer idHoaDonChiTiet;
    private Integer idHoaDon;
    private Integer idSanPhamChiTiet;
    private String tenSanPham;
    private Integer soLuong;
    private float donGia;

    public HoaDonChiTietResponses() {
    }

    public HoaDonChiTietResponses(Integer idHoaDonChiTiet, Integer idHoaDon, Integer idSanPhamChiTiet, String tenSanPham, Integer soLuong, float donGia) {
        this.idHoaDonChiTiet = idHoaDonChiTiet;
        this.idHoaDon = idHoaDon;
        this.idSanPhamChiTiet = idSanPhamChiTiet;
        this.tenSanPham = tenSanPham;
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

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
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

    public HoaDonChiTietResponses(Integer idSanPhamChiTiet, String tenSanPham, Integer soLuong, float donGia) {
        this.idSanPhamChiTiet = idSanPhamChiTiet;
        this.tenSanPham = tenSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public HoaDonChiTietResponses(Integer idSanPhamChiTiet, Integer soLuong, float donGia) {
        this.idSanPhamChiTiet = idSanPhamChiTiet;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public HoaDonChiTietResponses(float donGia) {
        this.donGia = donGia;
    }

   

    
    

    @Override
    public String toString() {
        return "HoaDonChiTietResponses{" + "idHoaDonChiTiet=" + idHoaDonChiTiet + ", idHoaDon=" + idHoaDon + ", idSanPhamChiTiet=" + idSanPhamChiTiet + ", tenSanPham=" + tenSanPham + ", soLuong=" + soLuong + ", donGia=" + donGia + '}';
    }
    
}
