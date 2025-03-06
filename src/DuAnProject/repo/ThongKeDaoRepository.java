/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAnProject.repo;

import DuAnProject.DAO.HoaDonChiTietBean;
import DuAnProject.DAO.ThongKe;
import DuAnProject.DAO.ThongKeDao;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ThongKeDaoRepository implements ThongKeRepository{

    private ThongKe thongKe = null;

    public ThongKeDaoRepository() {
        thongKe = new ThongKeDao();
    }
    
    @Override
    public List<HoaDonChiTietBean> getListByHoaDon() {
       return thongKe.getListByHoaDon();
    }
    
}
