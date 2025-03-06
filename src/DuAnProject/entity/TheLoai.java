/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAnProject.entity;

/**
 *
 * @author quyet
 */
public class TheLoai {
    private Integer iDTheLoai;
    private String maTheLoai;
    private String tenTheLoai;
    private boolean trangThai;

    public TheLoai() {
    }

    public TheLoai(Integer iDTheLoai, String maTheLoai, String tenTheLoai, boolean trangThai) {
        this.iDTheLoai = iDTheLoai;
        this.maTheLoai = maTheLoai;
        this.tenTheLoai = tenTheLoai;
        this.trangThai = trangThai;
    }
    
    public TheLoai(String maTheLoai, String tenTheLoai, boolean trangThai) {
       
        this.maTheLoai = maTheLoai;
        this.tenTheLoai = tenTheLoai;
        this.trangThai = trangThai;
    }

    public Integer getiDTheLoai() {
        return iDTheLoai;
    }

    public void setiDTheLoai(Integer iDTheLoai) {
        this.iDTheLoai = iDTheLoai;
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

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return this.tenTheLoai;
    }
    
    
}
