/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAnProject.repositoris;

import DuAnProject.conncet.DBCONNCET;
import DuAnProject.entity.ChucVu;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Lenovo
 */
public class ChucVuRepository {

    public List<ChucVu> getAll() {
        List<ChucVu> lists = new ArrayList<>();
        String sql = """
                      select IDChucVu, MaChucVu,TenChucVu 
                      from ChucVu
                      """;
        try (Connection conn = DBCONNCET.getConnection(); 
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChucVu cv = new ChucVu(rs.getInt(1), rs.getString(2), rs.getString(3));
                lists.add(cv);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lists;
    }
    public static void main(String[] args) {
        System.out.print(new ChucVuRepository().getAll());
    }
}
