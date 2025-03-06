/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAnProject.entity;

/**
 *
 * @author quyet
 */
public class TacGia {
    private Integer idTacGia;
    private String maTacGia;
    private String tenTacGia;
    private boolean trangThai;

    public TacGia() {
    }

    public TacGia(Integer idTacGia, String maTacGia, String tenTacGia, boolean trangThai) {
        this.idTacGia = idTacGia;
        this.maTacGia = maTacGia;
        this.tenTacGia = tenTacGia;
        this.trangThai = trangThai;
    }
    
    public TacGia(String maTacGia, String tenTacGia, boolean trangThai) {
        
        this.maTacGia = maTacGia;
        this.tenTacGia = tenTacGia;
        this.trangThai = trangThai;
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

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    
    @Override
    public String toString() {
        return this.tenTacGia;
    }
    
    
}
