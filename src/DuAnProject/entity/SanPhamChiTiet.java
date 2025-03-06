/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAnProject.entity;

/**
 *
 * @author Admin
 */
public class SanPhamChiTiet {
    private Integer idSPCT;
    private Integer idNCC;
    private Integer idSP;
    private Integer idTheLoai;
    private Integer idTacGia;
    private Integer idMauSac;
    private Integer soLuongTon;
    private float giaNhap;
    private float giaBan;
    private Integer namPhatHanh;

    public SanPhamChiTiet() {
    }

    public SanPhamChiTiet(Integer idSPCT, Integer idNCC, Integer idSP, Integer idTheLoai, Integer idTacGia, Integer idMauSac, Integer soLuongTon, float giaNhap, float giaBan, Integer namPhatHanh) {
        this.idSPCT = idSPCT;
        this.idNCC = idNCC;
        this.idSP = idSP;
        this.idTheLoai = idTheLoai;
        this.idTacGia = idTacGia;
        this.idMauSac = idMauSac;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.namPhatHanh = namPhatHanh;
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

    public Integer getIdSP() {
        return idSP;
    }

    public void setIdSP(Integer idSP) {
        this.idSP = idSP;
    }

    public Integer getIdTheLoai() {
        return idTheLoai;
    }

    public void setIdTheLoai(Integer idTheLoai) {
        this.idTheLoai = idTheLoai;
    }

    public Integer getIdTacGia() {
        return idTacGia;
    }

    public void setIdTacGia(Integer idTacGia) {
        this.idTacGia = idTacGia;
    }

    public Integer getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(Integer idMauSac) {
        this.idMauSac = idMauSac;
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

    public SanPhamChiTiet(Integer idNCC, Integer idSP, Integer idTheLoai, Integer idTacGia, Integer idMauSac, Integer soLuongTon, float giaNhap, float giaBan, Integer namPhatHanh) {
        this.idNCC = idNCC;
        this.idSP = idSP;
        this.idTheLoai = idTheLoai;
        this.idTacGia = idTacGia;
        this.idMauSac = idMauSac;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.namPhatHanh = namPhatHanh;
    }

    @Override
    public String toString() {
        return "SanPhamChiTiet{" + "idSPCT=" + idSPCT + ", idNCC=" + idNCC + ", idSP=" + idSP + ", idTheLoai=" + idTheLoai + ", idTacGia=" + idTacGia + ", idMauSac=" + idMauSac + ", soLuongTon=" + soLuongTon + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + ", namPhatHanh=" + namPhatHanh + '}';
    }
    
}
