/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAnProject.entity;

/**
 *
 * @author quyet
 */
public class SanPham {
    private Integer iDSanPham;
    private String maSanPham;
    private String tenSanPham;
    private boolean trangThai;

    public SanPham() {
    }

    public SanPham(Integer iDSanPham, String maSanPham, String tenSanPham, boolean trangThai) {
        this.iDSanPham = iDSanPham;
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.trangThai = trangThai;
    }

    public Integer getiDSanPham() {
        return iDSanPham;
    }

    public void setiDSanPham(Integer iDSanPham) {
        this.iDSanPham = iDSanPham;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public SanPham(String maSanPham, String tenSanPham, boolean trangThai) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.trangThai = trangThai;
    }

   

    @Override
    public String toString() {
        return "SanPham{" + "iDSanPham=" + iDSanPham + ", maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", trangThai=" + trangThai + '}';
    }
    
    
}
