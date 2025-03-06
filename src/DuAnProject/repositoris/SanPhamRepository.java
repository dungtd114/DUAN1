/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAnProject.repositoris;

import DuAnProject.conncet.DBCONNCET;
import DuAnProject.entity.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author quyet
 */
public class SanPhamRepository {

    public ArrayList<SanPham> getAll() {
        String sql = """
                     SELECT [IDSanPham]
                           ,[MaSanPham]
                           ,[TenSanPham]
                           ,[TrangThai]
                       FROM [dbo].[SanPham]""";
        ArrayList<SanPham> list = new ArrayList<>();
        try (Connection con = DBCONNCET.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setiDSanPham(rs.getInt(1));
                sp.setMaSanPham(rs.getString(2));
                sp.setTenSanPham(rs.getString(3));
                sp.setTrangThai(rs.getBoolean(4));
                list.add(sp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
     public ArrayList<SanPham> search(String tenSP) {
        String sql = """
                     SELECT [IDSanPham]
                           ,[MaSanPham]
                           ,[TenSanPham]
                           ,[TrangThai]
                       FROM [dbo].[SanPham]
                        where TenSanPham like ?
                     """;
        ArrayList<SanPham> list = new ArrayList<>();
        try (Connection con = DBCONNCET.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, "%"+tenSP+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setiDSanPham(rs.getInt(1));
                sp.setMaSanPham(rs.getString(2));
                sp.setTenSanPham(rs.getString(3));
                sp.setTrangThai(rs.getBoolean(4));
                list.add(sp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
     public SanPham getSPByMa(String maSP) {
        String sql = """
                     SELECT [IDSanPham]
                           ,[MaSanPham]
                           ,[TenSanPham]
                           ,[TrangThai]
                       FROM [dbo].[SanPham]
                        where MaSanPham like ?
                     """;
        try (Connection con = DBCONNCET.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1,maSP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new SanPham(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getBoolean(4));                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean add(SanPham sp){
        String sql = """
                     INSERT INTO [dbo].[SanPham]
                                ([MaSanPham]
                                ,[TenSanPham]
                                ,[TrangThai])
                          VALUES
                                (?,?,?)""";
        int check = 0 ;
        try (Connection con = DBCONNCET.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, sp.getMaSanPham());
            ps.setObject(2, sp.getTenSanPham());
            ps.setObject(3, sp.isTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
    public boolean update(SanPham sp, int idSP){
        String sql = """
                     UPDATE [dbo].[SanPham]
                        SET [MaSanPham] = ?
                           ,[TenSanPham] = ?
                           ,[TrangThai] = ?
                      WHERE IDSanPham = ?""";
        int check = 0 ;
        try (Connection con = DBCONNCET.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, sp.getMaSanPham());
            ps.setObject(2, sp.getTenSanPham());
            ps.setObject(3, sp.isTrangThai());
            ps.setObject(4, idSP);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
    public boolean delete(int index){
        String sql = """
                     DELETE FROM [dbo].[SanPham]
                           WHERE IDSanPham = ?""";
        int check = 0 ;
        try (Connection con = DBCONNCET.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, index);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

     public SanPham getOne(String ma) {
        String sql = """
                     SELECT [IDSanPham]
                                                ,[MaSanPham]
                                                ,[TenSanPham]
                                                ,[TrangThai]
                                            FROM [dbo].[SanPham]
                     where MaSanPham = ?""";
        try(Connection con = DBCONNCET.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
                ) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setiDSanPham(rs.getInt(1));
                sp.setMaSanPham(rs.getString(2));
                sp.setTenSanPham(rs.getString(3));
                sp.setTrangThai(rs.getBoolean(4));
                return sp;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        //System.out.println(new SanPhamRepository().getSPByMa("SP042"));
    }
}
