/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAnProject.repositoris;
import DuAnProject.conncet.DBCONNCET;
import DuAnProject.entity.TheLoai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author quyet
 */
public class TheLoaiRepository {
    public ArrayList<TheLoai> getAll(){
        String sql = """
                     SELECT [IDTheLoai]
                           ,[MaTheLoai]
                           ,[TenTheLoai]
                           ,[TrangThai]
                       FROM [dbo].[TheLoai]""";
        ArrayList<TheLoai> listtl = new ArrayList<>();
        try(Connection con = DBCONNCET.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
                ) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                TheLoai tl = new TheLoai(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4));
                listtl.add(tl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listtl;
    }
    
    public boolean add(TheLoai tl){
        String sql = """
                     INSERT INTO [dbo].[TheLoai]
                                ([MaTheLoai]
                                ,[TenTheLoai]
                                ,[TrangThai])
                          VALUES
                                (?,?,?)""";
        int check = 0 ;
        try(Connection con = DBCONNCET.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
                ) {
            ps.setObject(1, tl.getMaTheLoai());
            ps.setObject(2, tl.getTenTheLoai());
            ps.setObject(3, tl.isTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
    
    public boolean update(int index, TheLoai tl) {
        String sql = """
                     UPDATE [dbo].[TheLoai]
                        SET [MaTheLoai] = ?
                           ,[TenTheLoai] = ?
                           ,[TrangThai] = ?
                      WHERE IDTheLoai = ?""";
        int check = 0 ;
        try(Connection con = DBCONNCET.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
                ) {
            ps.setObject(1, tl.getMaTheLoai());
            ps.setObject(2, tl.getTenTheLoai());
            ps.setObject(3, tl.isTrangThai());
            ps.setObject(4, index);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
    
    public boolean delete(int id) {
        String sql = """
                     DELETE FROM [dbo].[TheLoai]
                           WHERE IDTheLoai = ?""";
        int check = 0 ;
        try(Connection con = DBCONNCET.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
                ) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
    
    public boolean checkTrungNCC(String name) {
        try {
            Connection con = DBCONNCET.getConnection();
            String sql = """
                         SELECT [MaTheLoai]                                                  
                          FROM [dbo].[TheLoai]
                         where TenTheLoai = ?""";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ps.setObject(1, name);
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static void main(String[] args) {
        TheLoai tl = new TheLoai("maTheLoai", "tenTheLoai", true);
        System.out.println(new TheLoaiRepository().add(tl));
    }
}
