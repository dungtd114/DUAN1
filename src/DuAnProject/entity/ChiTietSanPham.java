/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAnProject.entity;

/**
 *
 * @author quyet
 */
public class ChiTietSanPham {
    private Integer idSpct;
    private SanPham sanPham;
    private Integer soLuongTon;
    private Double giaNhap;
    private Double giaBan;
    private Integer namPH;
    private MauSac mauSac;
    private TacGia tacGia;
    private TheLoai theLoai;
    private NhaCungCap nCC;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(Integer idSpct, SanPham sanPham, Integer soLuongTon, Double giaNhap, Double giaBan, Integer namPH, MauSac mauSac, TacGia tacGia, TheLoai theLoai, NhaCungCap nCC) {
        this.idSpct = idSpct;
        this.sanPham = sanPham;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.namPH = namPH;
        this.mauSac = mauSac;
        this.tacGia = tacGia;
        this.theLoai = theLoai;
        this.nCC = nCC;
    }

    public Integer getIdSpct() {
        return idSpct;
    }

    public void setIdSpct(Integer idSpct) {
        this.idSpct = idSpct;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public Integer getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(Integer soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public Double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public Double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }

    public Integer getNamPH() {
        return namPH;
    }

    public void setNamPH(Integer namPH) {
        this.namPH = namPH;
    }

    public MauSac getMauSac() {
        return mauSac;
    }

    public void setMauSac(MauSac mauSac) {
        this.mauSac = mauSac;
    }

    public TacGia getTacGia() {
        return tacGia;
    }

    public void setTacGia(TacGia tacGia) {
        this.tacGia = tacGia;
    }

    public TheLoai getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(TheLoai theLoai) {
        this.theLoai = theLoai;
    }

    public NhaCungCap getnCC() {
        return nCC;
    }

    public void setnCC(NhaCungCap nCC) {
        this.nCC = nCC;
    }

    public ChiTietSanPham(SanPham sanPham, Integer soLuongTon, Double giaNhap, Double giaBan, Integer namPH, MauSac mauSac, TacGia tacGia, TheLoai theLoai, NhaCungCap nCC) {
        this.sanPham = sanPham;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.namPH = namPH;
        this.mauSac = mauSac;
        this.tacGia = tacGia;
        this.theLoai = theLoai;
        this.nCC = nCC;
    }

    @Override
    public String toString() {
        return "ChiTietSanPham{" + "idSpct=" + idSpct + ", sanPham=" + sanPham + ", soLuongTon=" + soLuongTon + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + ", namPH=" + namPH + ", mauSac=" + mauSac + ", tacGia=" + tacGia + ", theLoai=" + theLoai + ", nCC=" + nCC + '}';
    }

    
}
