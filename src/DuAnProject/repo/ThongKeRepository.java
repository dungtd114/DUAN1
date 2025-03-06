/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAnProject.repo;

import DuAnProject.DAO.HoaDonChiTietBean;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ThongKeRepository {
    public List<HoaDonChiTietBean> getListByHoaDon();
}
