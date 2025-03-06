/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAnProject.entity;

/**
 *
 * @author Admin
 */
public class ModelKhachHang {
    private Integer IDKhachHang;
    private String MaKhachHang;
    private String TenKhachHang;
    private String ngaySinh;
    private boolean GioiTinh;
    private String DiaChi;
    private String SoDienThoai;
    private String Email;

    public ModelKhachHang() {
    }

    public ModelKhachHang(Integer IDKhachHang, String MaKhachHang, String TenKhachHang, String ngaySinh, boolean GioiTinh, String DiaChi, String SoDienThoai, String Email) {
        this.IDKhachHang = IDKhachHang;
        this.MaKhachHang = MaKhachHang;
        this.TenKhachHang = TenKhachHang;
        this.ngaySinh = ngaySinh;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.SoDienThoai = SoDienThoai;
        this.Email = Email;
    }
    public ModelKhachHang( String MaKhachHang, String TenKhachHang, String ngaySinh, boolean GioiTinh, String DiaChi, String SoDienThoai, String Email) {
        this.MaKhachHang = MaKhachHang;
        this.TenKhachHang = TenKhachHang;
        this.ngaySinh = ngaySinh;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.SoDienThoai = SoDienThoai;
        this.Email = Email;
    }
    public Integer getIDKhachHang() {
        return IDKhachHang;
    }

    public void setIDKhachHang(Integer IDKhachHang) {
        this.IDKhachHang = IDKhachHang;
    }

    public String getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(String MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String toString() {
        return "ModelKhachHang{" + "IDKhachHang=" + IDKhachHang + ", MaKhachHang=" + MaKhachHang + ", TenKhachHang=" + TenKhachHang + ", ngaySinh=" + ngaySinh + ", GioiTinh=" + GioiTinh + ", DiaChi=" + DiaChi + ", SoDienThoai=" + SoDienThoai + ", Email=" + Email + '}';
    }

    

    
    
    
}
