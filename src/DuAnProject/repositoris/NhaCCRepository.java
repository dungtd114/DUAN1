/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAnProject.repositoris;

import DuAnProject.conncet.DBCONNCET;
import DuAnProject.entity.NhaCungCap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author quyet
 */
public class NhaCCRepository {

    public ArrayList<NhaCungCap> getAll() {
        String sql = """
                     SELECT [IDNhaCungCap]
                           ,[MaNhaCungCap]
                           ,[TenNhaCungCap]
                           ,[TrangThai]
                       FROM [dbo].[NhaCungCap]""";
        ArrayList<NhaCungCap> listncc = new ArrayList<>();
        try (Connection con = DBCONNCET.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4));
                listncc.add(ncc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listncc;
    }

    public boolean add(NhaCungCap ncc) {
        String sql = """
                     INSERT INTO [dbo].[NhaCungCap]
                                ([MaNhaCungCap]
                                ,[TenNhaCungCap]
                                ,[TrangThai])
                          VALUES
                                (?,?,?)""";
        int check = 0;
        try (Connection con = DBCONNCET.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ncc.getMaNcc());
            ps.setObject(2, ncc.getTenNcc());
            ps.setObject(3, ncc.isTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean update(int index, NhaCungCap ncc) {
        String sql = """
                     UPDATE [dbo].[NhaCungCap]
                        SET [MaNhaCungCap] = ?
                           ,[TenNhaCungCap] = ?
                           ,[TrangThai] = ?
                      WHERE IDNhaCungCap = ?""";
        int check = 0;
        try (Connection con = DBCONNCET.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ncc.getMaNcc());
            ps.setObject(2, ncc.getTenNcc());
            ps.setObject(3, ncc.isTrangThai());
            ps.setObject(4, index);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean delete(int id) {
        String sql = """
                     DELETE FROM [dbo].[NhaCungCap]
                           WHERE IDNhaCungCap = ? """;
        int check = 0;
        try (Connection con = DBCONNCET.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
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
                         SELECT [MaNhaCungCap]                                                  
                          FROM [dbo].[NhaCungCap]
                         where TenNhaCungCap = ?""";

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
}
