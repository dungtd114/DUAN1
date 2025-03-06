/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAnProject.responses;

/**
 *
 * @author Admin
 */
public class SanPhamChiTietReponses {
     private Integer idSPCT;
    private Integer idNCC;
    private String maNCC;
    private String tenNCC;
    private Integer idSP;
    private String maSP;
    private String tenSP;
    private Integer idTheLoai;
    private String maTheLoai;
    private String tenTheLoai;
    private Integer idTacGia;
    private String maTacGia;
    private String tenTacGia;
    private Integer idMauSac;
    private String maMauSac;
    private String tenMauSac;
    private Integer soLuongTon;
    private float giaNhap;
    private float giaBan;
    private Integer namPhatHanh;
    private boolean trangThai;

    public SanPhamChiTietReponses() {
    }

    public SanPhamChiTietReponses(Integer idSPCT, Integer idNCC, String maNCC, String tenNCC, Integer idSP, String maSP, String tenSP, Integer idTheLoai, String maTheLoai, String tenTheLoai, Integer idTacGia, String maTacGia, String tenTacGia, Integer idMauSac, String maMauSac, String tenMauSac, Integer soLuongTon, float giaNhap, float giaBan, Integer namPhatHanh, boolean trangThai) {
        this.idSPCT = idSPCT;
        this.idNCC = idNCC;
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.idSP = idSP;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.idTheLoai = idTheLoai;
        this.maTheLoai = maTheLoai;
        this.tenTheLoai = tenTheLoai;
        this.idTacGia = idTacGia;
        this.maTacGia = maTacGia;
        this.tenTacGia = tenTacGia;
        this.idMauSac = idMauSac;
        this.maMauSac = maMauSac;
        this.tenMauSac = tenMauSac;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.namPhatHanh = namPhatHanh;
        this.trangThai = trangThai;
    }

    public Integer getIdSPCT() {
        return idSPCT;
    }

    public void setIdSPCT(Integer idSPCT) {
        this.idSPCT = idSPCT;
    }

    public Integer getIdNCC() {
        return idNCC;
    }

    public void setIdNCC(Integer idNCC) {
        this.idNCC = idNCC;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public Integer getIdSP() {
        return idSP;
    }

    public void setIdSP(Integer idSP) {
        this.idSP = idSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public Integer getIdTheLoai() {
        return idTheLoai;
    }

    public void setIdTheLoai(Integer idTheLoai) {
        this.idTheLoai = idTheLoai;
    }

    public String getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(String maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public Integer getIdTacGia() {
        return idTacGia;
    }

    public void setIdTacGia(Integer idTacGia) {
        this.idTacGia = idTacGia;
    }

    public String getMaTacGia() {
        return maTacGia;
    }

    public void setMaTacGia(String maTacGia) {
        this.maTacGia = maTacGia;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public Integer getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(Integer idMauSac) {
        this.idMauSac = idMauSac;
    }

    public String getMaMauSac() {
        return maMauSac;
    }

    public void setMaMauSac(String maMauSac) {
        this.maMauSac = maMauSac;
    }

    public String getTenMauSac() {
        return tenMauSac;
    }

    public void setTenMauSac(String tenMauSac) {
        this.tenMauSac = tenMauSac;
    }

    public Integer getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(Integer soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(float giaNhap) {
        this.giaNhap = giaNhap;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public Integer getNamPhatHanh() {
        return namPhatHanh;
    }

    public void setNamPhatHanh(Integer namPhatHanh) {
        this.namPhatHanh = namPhatHanh;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "SanPhamChiTietReponses{" + "idSPCT=" + idSPCT + ", idNCC=" + idNCC + ", maNCC=" + maNCC + ", tenNCC=" + tenNCC + ", idSP=" + idSP + ", maSP=" + maSP + ", tenSP=" + tenSP + ", idTheLoai=" + idTheLoai + ", maTheLoai=" + maTheLoai + ", tenTheLoai=" + tenTheLoai + ", idTacGia=" + idTacGia + ", maTacGia=" + maTacGia + ", tenTacGia=" + tenTacGia + ", idMauSac=" + idMauSac + ", maMauSac=" + maMauSac + ", tenMauSac=" + tenMauSac + ", soLuongTon=" + soLuongTon + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + ", namPhatHanh=" + namPhatHanh + ", trangThai=" + trangThai + '}';
    }

    
    
}
