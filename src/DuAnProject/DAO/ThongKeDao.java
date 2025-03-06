/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAnProject.DAO;

import DuAnProject.conncet.DBCONNCET;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ThongKeDao implements ThongKe{

    @Override
    public List<HoaDonChiTietBean> getListByHoaDon() {
        try {
            Connection con = DBCONNCET.getConnection();
            String sql = """
                         select NgayThanhToan, COUNT(*) as soLuong from hoadon group by NgayThanhToan
                          """;
            List<HoaDonChiTietBean> list = new ArrayList<>();
            PreparedStatement prs = con.prepareCall(sql);
            ResultSet rs = prs.executeQuery();
            while (rs.next()) {
                HoaDonChiTietBean Bean = new HoaDonChiTietBean();
                Bean.setNgayThanhToan(rs.getString("NgayThanhToan"));
                Bean.setSoSanPham(rs.getInt("soLuong"));
                list.add(Bean);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
