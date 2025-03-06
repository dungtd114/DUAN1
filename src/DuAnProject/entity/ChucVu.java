/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAnProject.entity;

/**
 *
 * @author Lenovo
 */
public class ChucVu {
    private Integer idChucVu;
    private String maChucVu;
    private String tenChucVu;

    public ChucVu() {
    }
    public ChucVu(Integer idChucVu, String maChucVu, String tenChucVu) {
        this.idChucVu = idChucVu;
        this.maChucVu = maChucVu;
        this.tenChucVu = tenChucVu;
    }

    public int getIdChucVu() {
        return idChucVu;
    }

    public void setIdChucVu(Integer idChucVu) {
        this.idChucVu = idChucVu;
    }

    public String getMaChucVu() {
        return maChucVu;
    }

    public void setMaChucVu(String maChucVu) {
        this.maChucVu = maChucVu;
    }

    public String getTenChucVu() {
        return tenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    } 
    
}
