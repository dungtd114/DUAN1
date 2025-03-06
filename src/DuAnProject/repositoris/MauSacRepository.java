/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAnProject.repositoris;
import DuAnProject.conncet.DBCONNCET;
import DuAnProject.entity.MauSac;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author quyet
 */
public class MauSacRepository {
    public ArrayList<MauSac> getAll(){
        String sql = """
                     SELECT [IDMauSac]
                           ,[MaMauSac]
                           ,[TenMauSac]
                           ,[TrangThai]
                       FROM [dbo].[MauSac]""";
        ArrayList<MauSac> listms = new ArrayList<>();
        try(Connection con = DBCONNCET.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
                ) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                MauSac ms = new MauSac(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4));
                listms.add(ms);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listms;
    }
    
    public boolean add(MauSac ms){
        String sql = """
                     INSERT INTO [dbo].[MauSac]
                                ([MaMauSac]
                                ,[TenMauSac]
                                ,[TrangThai])
                          VALUES
                                (?,?,?)""";
        int check = 0 ;
        try(Connection con = DBCONNCET.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
                ) {
            ps.setObject(1, ms.getMaMauSac());
            ps.setObject(2, ms.getTenMauSac());
            ps.setObject(3, ms.isTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0 ;
    }
    
    public boolean update(int index, MauSac ms){
        String sql = """
                     UPDATE [dbo].[MauSac]
                        SET [MaMauSac] = ?
                           ,[TenMauSac] = ?
                           ,[TrangThai] = ?
                      WHERE IDMauSac = ?""";
        int check = 0 ;
        try(Connection con = DBCONNCET.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
                ) {
            ps.setObject(1, ms.getMaMauSac());
            ps.setObject(2, ms.getTenMauSac());
            ps.setObject(3, ms.isTrangThai());
            ps.setObject(4, index);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0 ;
    }
    
    public boolean delete(int id) {
        String sql = """
                     DELETE FROM [dbo].[MauSac]
                           WHERE IDMauSac = ? """;
        int check = 0 ;
        try(Connection con = DBCONNCET.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
                ) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0 ;
    }
    
    public boolean checkTrungMS(String name1) {
        try {
            Connection con = DBCONNCET.getConnection();
            String sql = """
                         SELECT [MaMauSac]                                                  
                          FROM [dbo].[MauSac]
                         where TenMauSac = ?""";

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
