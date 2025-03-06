/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAnProject.repositoris;
import DuAnProject.conncet.DBCONNCET;
import DuAnProject.entity.TacGia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author quyet
 */
public class TacGiaReposotory {
    public ArrayList<TacGia> getAll() {
        String sql = """
                     SELECT [IDTacGia]
                           ,[MaTG]
                           ,[TenTG]
                           ,[TrangThai]
                       FROM [dbo].[TacGia]""";
        ArrayList<TacGia> listtg = new ArrayList<>();
        try(Connection con = DBCONNCET.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
                ) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                TacGia tg = new TacGia(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4));
                listtg.add(tg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listtg;
    }
    
    public boolean add(TacGia tg){
        String sql = """
                     INSERT INTO [dbo].[TacGia]
                                ([MaTG]
                                ,[TenTG]
                                ,[TrangThai])
                          VALUES
                                (?,?,?)""";
        int check = 0;
        try (Connection con = DBCONNCET.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
                ){
            ps.setObject(1, tg.getMaTacGia());
            ps.setObject(2, tg.getTenTacGia());
            ps.setObject(3, tg.isTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
    
    public boolean update(int index, TacGia tg){
        String sql = """
                     UPDATE [dbo].[TacGia]
                        SET [MaTG] = ?
                           ,[TenTG] = ?
                           ,[TrangThai] = ?
                      WHERE IDTacGia = ?""";
        int check = 0;
        try (Connection con = DBCONNCET.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
                ){
            ps.setObject(1, tg.getMaTacGia());
            ps.setObject(2, tg.getTenTacGia());
            ps.setObject(3, tg.isTrangThai());
            ps.setObject(4, index);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
    
    public boolean delete(int id) {
        String sql = """
                     DELETE FROM [dbo].[TacGia]
                           WHERE IDTacGia = ?""";
        int check = 0;
        try (Connection con = DBCONNCET.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
                ){
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
    public boolean checkTrungTG(String name1) {
        try {
            Connection con = DBCONNCET.getConnection();
            String sql = """
                         SELECT [MaTacGia]                                                  
                          FROM [dbo].[TacGia]
                         where TenTacGia = ?""";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ps.setObject(1, name1);
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
