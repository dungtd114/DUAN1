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
import DuAnProject.entity.HoaDonChiTiet;
import DuAnProject.responses.HoaDonChiTietResponses;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HoaDonChiTietRepository {

  
    public ArrayList<HoaDonChiTiet> getAllHDCT() {
        String sql = """
                     select IDHoaDonChiTiet, IDHoaDon, IDSanPhamChiTiet, SoLuong, DonGia from HoaDonChiTiet
                     """;
        ArrayList<HoaDonChiTiet> list = new ArrayList<>();
        try (Connection con = DBCONNCET.getConnection(); PreparedStatement prs = con.prepareStatement(sql)) {
            ResultSet rs = prs.executeQuery();
            while (rs.next()) {
                list.add(new HoaDonChiTiet(
                        rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getFloat(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<HoaDonChiTiet> getIDHD() {
        String sql = """
                     select Max(IDHoaDon)
                     from HoaDonChiTiet
                     """;
        ArrayList<HoaDonChiTiet> list = new ArrayList<>();
        try (Connection con = DBCONNCET.getConnection(); PreparedStatement prs = con.prepareStatement(sql)) {
            ResultSet rs = prs.executeQuery();
            while (rs.next()) {
                list.add(new HoaDonChiTiet(rs.getInt(1)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

 public List<HoaDonChiTiet> getHDByIDHD(int idHD) {
    String sql = """
                 SELECT IDHoaDonChiTiet, IDHoaDon, IDSanPhamChiTiet, SoLuong, DonGia 
                 FROM HoaDonChiTiet 
                 WHERE IDHoaDon = ?
                 """;
    List<HoaDonChiTiet> listHDCT = new ArrayList<>();
    
    try (Connection con = DBCONNCET.getConnection(); 
         PreparedStatement prs = con.prepareStatement(sql)) {
        prs.setInt(1, idHD);
        ResultSet rs = prs.executeQuery();
        
        while (rs.next()) {
            HoaDonChiTiet hdct = new HoaDonChiTiet(
                rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getFloat(5));
            listHDCT.add(hdct); 
        }
    } catch (SQLException e) {
        e.printStackTrace(); 
    }
    
    return listHDCT;
}
    public ArrayList<HoaDonChiTietResponses> getAllByIdHDon(int hDon) {
        String sql = """
                     select ct.IDHoaDonChiTiet,IDHoaDon,ct.IDSanPhamChiTiet, sp.TenSanPham ,ct.SoLuong, ct.DonGia
                     from HoaDonChiTiet ct, SanPhamChiTiet spct, SanPham sp
                     where spct.IDSanPhamChiTiet = ct.IDSanPhamChiTiet and spct.IDSanPham = sp.IDSanPham and IDHoaDon = ?             
                     """;
        ArrayList<HoaDonChiTietResponses> list = new ArrayList<>();
        try (Connection con = DBCONNCET.getConnection(); 
                PreparedStatement prs = con.prepareStatement(sql)) {
            prs.setObject(1, hDon);
            ResultSet rs = prs.executeQuery();
            while (rs.next()) {
                list.add(new HoaDonChiTietResponses(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getFloat(6)));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }
    
    public boolean themSP(int idHoaDon){
        String sql = """
                     INSERT INTO HoaDonChiTiet(IDHoaDon)
                     select hd.IDHoaDon from HoaDon hd where hd.IDHoaDon = ?
                     """;
        int check = 0;
        try (Connection con = DBCONNCET.getConnection(); 
                PreparedStatement prs = con.prepareStatement(sql)) {
            prs.setObject(1, idHoaDon);
            check = prs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check>0;
    }
    public boolean suaSP(HoaDonChiTiet chiTiet){
        String sql = """
                     UPDATE HoaDonChiTiet
                     	SET IDSanPhamChiTiet = ?,
                            SoLuong = ?,
                            DonGia = ?
                      WHERE IDSanPhamChiTiet is NULL
                     """;
        int check = 0;
        try (Connection con = DBCONNCET.getConnection(); 
                PreparedStatement prs = con.prepareStatement(sql)) {
            prs.setObject(1, chiTiet.getIdSanPhamChiTiet());
            prs.setObject(2, chiTiet.getSoLuong());
            prs.setObject(3, chiTiet.getDonGia());
            check = prs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check>0;
    }
    public boolean xoaGH(int idHDCT){
        String sql = """
                     DELETE FROM HoaDonChiTiet
                           WHERE IDHoaDonChiTiet = ?
                     """;
        int check = 0;
        try (Connection con = DBCONNCET.getConnection(); 
                PreparedStatement prs = con.prepareStatement(sql)) {
            prs.setObject(1, idHDCT);       
            check = prs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check>0;
    }
    public boolean suaGH(HoaDonChiTiet chiTiet, int idHDCT){
        String sql = """
                     update HoaDonChiTiet
                     set IDSanPhamChiTiet =?,
                     	SoLuong = ?,
                     	DonGia = ?
                     where IDHoaDonChiTiet = ?
                     """;
        int check = 0;
        try (Connection con = DBCONNCET.getConnection(); 
                PreparedStatement prs = con.prepareStatement(sql)) { 
            prs.setObject(1, chiTiet.getIdSanPhamChiTiet());
            prs.setObject(2, chiTiet.getSoLuong());
            prs.setObject(3, chiTiet.getDonGia());
            prs.setObject(4, idHDCT);
            check = prs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check>0;
    }
    public boolean suaGHver2(int idSL, int idHDCT){
        String sql = """
                     update HoaDonChiTiet
                     set SoLuong = ?                     	
                     where IDHoaDonChiTiet = ?
                     """;
        int check = 0;
        try (Connection con = DBCONNCET.getConnection(); 
                PreparedStatement prs = con.prepareStatement(sql)) { 
            prs.setObject(1, idSL);
            prs.setObject(2, idHDCT);
            check = prs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check>0;
    }
    public boolean XoaHD(int idHD){
       String sql = "DELETE FROM HoaDonChiTiet WHERE IDHoaDon = ?";
       int check =0;
       try(Connection con = DBCONNCET.getConnection(); 
                PreparedStatement prs = con.prepareStatement(sql)) {
           prs.setObject(1, idHD);
           check = prs.executeUpdate();
       } catch (Exception e) {
           e.printStackTrace(System.out);
       }
       return check>0;
   }
    public static void main(String[] args) {
//        HoaDonChiTiet chiTiet = new HoaDonChiTiet(1, 2, 0);
       // System.out.println(new HoaDonChiTietRepository().getIDHD());
    }
}
