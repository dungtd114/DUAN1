/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAnProject.entity;

/**
 *
 * @author quyet
 */
public class NhaCungCap {
    private Integer idNcc;
    private String maNcc;
    private String tenNcc;
    private boolean trangThai;

    public NhaCungCap() {
    }

    public NhaCungCap(Integer idNcc, String maNcc, String tenNcc, boolean trangThai) {
        this.idNcc = idNcc;
        this.maNcc = maNcc;
        this.tenNcc = tenNcc;
        this.trangThai = trangThai;
    }
    
    public NhaCungCap(String maNcc, String tenNcc, boolean trangThai) {
        this.maNcc = maNcc;
        this.tenNcc = tenNcc;
        this.trangThai = trangThai;
    }

    public Integer getIdNcc() {
        return idNcc;
    }

    public void setIdNcc(Integer idNcc) {
        this.idNcc = idNcc;
    }

    public String getMaNcc() {
        return maNcc;
    }

    public void setMaNcc(String maNcc) {
        this.maNcc = maNcc;
    }

    public String getTenNcc() {
        return tenNcc;
    }

    public void setTenNcc(String tenNcc) {
        this.tenNcc = tenNcc;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return this.tenNcc;
    }
    
    
}
