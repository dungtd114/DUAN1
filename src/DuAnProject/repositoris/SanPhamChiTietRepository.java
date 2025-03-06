/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAnProject.repositoris;

import DuAnProject.conncet.DBCONNCET;
import java.sql.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import DuAnProject.entity.SanPhamChiTiet;
import DuAnProject.responses.SanPhamChiTietReponses;

/**
 *
 * @author Admin
 */
public class SanPhamChiTietRepository {

    public ArrayList<SanPhamChiTiet> getAllSPCT() {
        String sql = """
                 SELECT [IDSanPhamChiTiet]
                       ,[IDNhaCungCap]
                       ,[IDSanPham]
                       ,[IDTheLoai]
                       ,[IDTacGia]
                       ,[IDMauSac]
                       ,[SoLuongTon]
                       ,[GiaNhap]
                       ,[GiaBan]
                       ,[NamPhatHanh]
                   FROM [dbo].[SanPhamChiTiet]
                 """;
        ArrayList<SanPhamChiTiet> list = new ArrayList<>();
        try (Connection con = DBCONNCET.getConnection();
                PreparedStatement prs = con.prepareStatement(sql)) {
            ResultSet rs = prs.executeQuery();
            while (rs.next()) {
                list.add(new SanPhamChiTiet(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
                        rs.getInt(6), rs.getInt(7), rs.getFloat(8), rs.getFloat(9), rs.getInt(10)));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public boolean addSPCT(SanPhamChiTiet spct) {
        String sql = """
                 INSERT INTO [dbo].[SanPhamChiTiet]
                             ([IDNhaCungCap]
                              ,[IDSanPham]
                              ,[IDTheLoai]
                              ,[IDTacGia]
                              ,[IDMauSac]
                              ,[SoLuongTon]
                              ,[GiaNhap]
                              ,[GiaBan]
                              ,[NamPhatHanh])
                  VALUES
                            (?,?,?,?,?,?,?,?,?)
                 """;
       int check = 0;
        try (Connection con = DBCONNCET.getConnection();
                PreparedStatement prs = con.prepareStatement(sql)) {
            
            prs.setObject(1, spct.getIdNCC());
            prs.setObject(2, spct.getIdSP());
            prs.setObject(3, spct.getIdTheLoai());
            prs.setObject(4, spct.getIdTacGia());
            prs.setObject(5, spct.getIdMauSac());
            prs.setObject(6, spct.getSoLuongTon());
            prs.setObject(7, spct.getGiaNhap());
            prs.setObject(8, spct.getGiaBan());
            prs.setObject(9, spct.getNamPhatHanh());
            check = prs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check>0;
    }

    public SanPhamChiTiet getSPCTById(int idSPCT) {
        String sql = """
                 SELECT [IDSanPhamChiTiet]
                       ,[IDNhaCungCap]
                       ,[IDSanPham]
                       ,[IDTheLoai]
                       ,[IDTacGia]
                       ,[IDMauSac]
                       ,[SoLuongTon]
                       ,[GiaNhap]
                       ,[GiaBan]
                       ,[NamPhatHanh]
                   FROM [dbo].[SanPhamChiTiet]
                 where IDSanPhamChiTiet = ?
                 """;
        try (Connection con = DBCONNCET.getConnection();
                PreparedStatement prs = con.prepareStatement(sql)) {
            prs.setObject(1, idSPCT);
            ResultSet rs = prs.executeQuery();
            while (rs.next()) {
                return new SanPhamChiTiet(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
                        rs.getInt(6), rs.getInt(7), rs.getFloat(8), rs.getFloat(9), rs.getInt(10));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public ArrayList<SanPhamChiTietReponses> getAllSPCTR() {
        String sql = """
                 select spct.IDSanPhamChiTiet, spct.IDNhaCungCap, ncc.MaNhaCungCap, ncc.TenNhaCungCap,
                 spct.IDSanPham, sp.MaSanPham, sp.TenSanPham, spct.IDTheLoai, tl.MaTheLoai, tl.TenTheLoai,
                 spct.IDTacGia, tg.MaTG, tg.TenTG, spct.IDMauSac, ms.MaMauSac, ms.TenMauSac,spct.SoLuongTon,
                 spct.GiaNhap, GiaBan, NamPhatHanh, sp.TrangThai
                 from SanPhamChiTiet spct
                 inner join NhaCungCap ncc on ncc.IDNhaCungCap = spct.IDNhaCungCap
                 inner join SanPham sp on sp.IDSanPham = spct.IDSanPham
                 inner join TheLoai tl on tl.IDTheLoai = spct.IDTheLoai
                 inner join TacGia tg on tg.IDTacGia = spct.IDTacGia
                 inner join MauSac ms on ms.IDMauSac = spct.IDMauSac
                 """;
        ArrayList<SanPhamChiTietReponses> list = new ArrayList<>();
        try (Connection con = DBCONNCET.getConnection();
                PreparedStatement prs = con.prepareStatement(sql)) {
            ResultSet rs = prs.executeQuery();
            while (rs.next()) {
                list.add(new SanPhamChiTietReponses(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getString(6), rs.getString(7),
                        rs.getInt(8), rs.getString(9), rs.getString(10),
                        rs.getInt(11), rs.getString(12), rs.getString(13),
                        rs.getInt(14), rs.getString(15), rs.getString(16),
                        rs.getInt(17), rs.getFloat(18), rs.getFloat(19), rs.getInt(20), rs.getBoolean(21)));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public boolean suaSLT(int soLuong, int idSP) {
        String sql = """
                 UPDATE SanPhamChiTiet
                    SET SoLuongTon = SoLuongTon - ?
                  WHERE IDSanPhamChiTiet = ?
                 """;
        int check = 0;
        try (Connection con = DBCONNCET.getConnection();
                PreparedStatement prs = con.prepareStatement(sql)) {
            prs.setObject(1, soLuong);
            prs.setObject(2, idSP);
            check = prs.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean congSPT(int soLuong, int idSP) {
        String sql = """
                 UPDATE SanPhamChiTiet
                    SET SoLuongTon = SoLuongTon + ?
                  WHERE IDSanPhamChiTiet = ?
                 """;
        int check = 0;
        try (Connection con = DBCONNCET.getConnection();
                PreparedStatement prs = con.prepareStatement(sql)) {
            prs.setObject(1, soLuong);
            prs.setObject(2, idSP);
            check = prs.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public ArrayList<SanPhamChiTietReponses> timSach(String tenSach) {
        String sql = """
                 select spct.IDSanPhamChiTiet, spct.IDNhaCungCap, ncc.MaNhaCungCap, ncc.TenNhaCungCap,
                 spct.IDSanPham, sp.MaSanPham, sp.TenSanPham, spct.IDTheLoai, tl.MaTheLoai, tl.TenTheLoai,
                 spct.IDTacGia, tg.MaTG, tg.TenTG, spct.IDMauSac, ms.MaMauSac, ms.TenMauSac,spct.SoLuongTon,
                 spct.GiaNhap, GiaBan, NamPhatHanh, sp.TrangThai
                 from SanPhamChiTiet spct
                 inner join NhaCungCap ncc on ncc.IDNhaCungCap = spct.IDNhaCungCap
                 inner join SanPham sp on sp.IDSanPham = spct.IDSanPham
                 inner join TheLoai tl on tl.IDTheLoai = spct.IDTheLoai
                 inner join TacGia tg on tg.IDTacGia = spct.IDTacGia
                 inner join MauSac ms on ms.IDMauSac = spct.IDMauSac
                 where sp.TenSanPham like ?
                 """;
        ArrayList<SanPhamChiTietReponses> list = new ArrayList<>();
        try (Connection con = DBCONNCET.getConnection();
                PreparedStatement prs = con.prepareStatement(sql)) {
            prs.setObject(1, "%" + tenSach + "%");
            ResultSet rs = prs.executeQuery();
            while (rs.next()) {
                list.add(new SanPhamChiTietReponses(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getString(6), rs.getString(7),
                        rs.getInt(8), rs.getString(9), rs.getString(10),
                        rs.getInt(11), rs.getString(12), rs.getString(13),
                        rs.getInt(14), rs.getString(15), rs.getString(16),
                        rs.getInt(17), rs.getFloat(18), rs.getFloat(19), rs.getInt(20), rs.getBoolean(21)));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public static void main(String[] args) {
        //System.out.println(new SanPhamChiTietRepository().timSach("ti"));
    }
}
