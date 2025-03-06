/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAnProject.entity;

/**
 *
 * @author quyet
 */
public class MauSac {
    private Integer idMauSac;
    private String maMauSac;
    private String tenMauSac;
    private boolean trangThai;

    public MauSac() {
    }
    
    public MauSac(String maMauSac, String tenMauSac, boolean trangThai) {
        
        this.maMauSac = maMauSac;
        this.tenMauSac = tenMauSac;
        this.trangThai = trangThai;
    }

    public MauSac(Integer idMauSac, String maMauSac, String tenMauSac, boolean trangThai) {
        this.idMauSac = idMauSac;
        this.maMauSac = maMauSac;
        this.tenMauSac = tenMauSac;
        this.trangThai = trangThai;
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

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return this.tenMauSac;
    }
    
    
}
