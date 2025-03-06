/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAnProject.DAO;

/**
 *
 * @author Admin
 */
public class HoaDonChiTietBean {
    private String ngayThanhToan;
    private int soSanPham;

    public HoaDonChiTietBean() {
    }

    public HoaDonChiTietBean(String ngayThanhToan, int soSanPham) {
        this.ngayThanhToan = ngayThanhToan;
        this.soSanPham = soSanPham;
    }

    
    public String getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public int getSoSanPham() {
        return soSanPham;
    }

    public void setSoSanPham(int soSanPham) {
        this.soSanPham = soSanPham;
    }
    
}
