/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAnProject.repositoris;
import DuAnProject.conncet.DBCONNCET;
import java.sql.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import DuAnProject.entity.HoaDon;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class HoaDonRepository {
   public ArrayList<HoaDon>getAllSP(){
       String sql = """
                    select IDHoaDon, IDKhachHang, IDNhanVien, NgayTao, 
                    NgayThanhToan,TinhTrang, NguoiNhan, SDT, TongTien from HoaDon
                    """;
       ArrayList<HoaDon> list = new ArrayList<>();
       try(Connection con = DBCONNCET.getConnection(); 
                PreparedStatement prs = con.prepareStatement(sql)) {
           ResultSet rs = prs.executeQuery();
           while (rs.next()) {               
               list.add(new HoaDon(rs.getInt(1), rs.getInt(2), rs.getInt(3),
                       rs.getDate(4), rs.getDate(5), rs.getBoolean(6), rs.getString(7), 
                       rs.getString(8), rs.getFloat(9)));
           }
       } catch (Exception e) {
           e.printStackTrace(System.out);
       }
       return list;
   }
    public ArrayList<HoaDon>getAllSPCTT(){
       String sql = """
                    select IDHoaDon, IDKhachHang, IDNhanVien, NgayTao, 
                    NgayThanhToan,TinhTrang, NguoiNhan, SDT, TongTien from HoaDon
                    where TinhTrang = 0
                    """;
       ArrayList<HoaDon> list = new ArrayList<>();
       try(Connection con = DBCONNCET.getConnection(); 
                PreparedStatement prs = con.prepareStatement(sql)) {
           ResultSet rs = prs.executeQuery();
           while (rs.next()) {               
               list.add(new HoaDon(rs.getInt(1), rs.getInt(2), rs.getInt(3),
                       rs.getDate(4), rs.getDate(5), rs.getBoolean(6), rs.getString(7), 
                       rs.getString(8), rs.getFloat(9)));
           }
       } catch (Exception e) {
           e.printStackTrace(System.out);
       }
       return list;
   }
     public ArrayList<HoaDon>getAllSPDTT(){
       String sql = """
                    select IDHoaDon, IDKhachHang, IDNhanVien, NgayTao, 
                    NgayThanhToan,TinhTrang, NguoiNhan, SDT, TongTien from HoaDon
                    where TinhTrang = 1
                    """;
       ArrayList<HoaDon> list = new ArrayList<>();
       try(Connection con = DBCONNCET.getConnection(); 
                PreparedStatement prs = con.prepareStatement(sql)) {
           ResultSet rs = prs.executeQuery();
           while (rs.next()) {               
               list.add(new HoaDon(rs.getInt(1), rs.getInt(2), rs.getInt(3),
                       rs.getDate(4), rs.getDate(5), rs.getBoolean(6), rs.getString(7),
                       rs.getString(8), rs.getFloat(9)));
           }
       } catch (Exception e) {
           e.printStackTrace(System.out);
       }
       return list;
   }
   public ArrayList<HoaDon>searchSP(int idHD){
       String sql = """
                    select IDHoaDon, IDKhachHang, IDNhanVien, NgayTao, 
                    NgayThanhToan,TinhTrang, NguoiNhan, SDT, TongTien from HoaDon
                    where IDHoaDon = ?
                    """;
       ArrayList<HoaDon> list = new ArrayList<>();
       try(Connection con = DBCONNCET.getConnection(); 
                PreparedStatement prs = con.prepareStatement(sql)) {
           prs.setObject(1, idHD);
           ResultSet rs = prs.executeQuery();
           while (rs.next()) {               
               list.add(new HoaDon(rs.getInt(1), rs.getInt(2), rs.getInt(3),
                       rs.getDate(4), rs.getDate(5), rs.getBoolean(6), rs.getString(7),
                       rs.getString(8), rs.getFloat(9)));
           }
       } catch (Exception e) {
           e.printStackTrace(System.out);
       }
       return list;
   }
   public boolean TaoHoaDon(){
       String sql = """
                    insert into HoaDon(NgayTao,TinhTrang,TongTien)
                    values (CAST(GETDATE() AS DATE),0,0)
                    """;
       int check =0;
       try(Connection con = DBCONNCET.getConnection(); 
                PreparedStatement prs = con.prepareStatement(sql)) {
           
           check = prs.executeUpdate();
       } catch (Exception e) {
           e.printStackTrace(System.out);
       }
       return check>0;
   }
   public boolean thanhToan(int idHD){
       String sql = """
                    update HoaDon
                    set	NgayThanhToan = CONVERT(DATE, GETDATE()),
                    	TinhTrang = 1,
                        TongTien = (select SUM(DonGia) from HoaDonChiTiet hdct where hdct.IDHoaDon = ?)	
                    where IDHoaDon = ?
                    """;
       int check =0;
       try(Connection con  = DBCONNCET.getConnection(); 
                PreparedStatement prs = con.prepareStatement(sql)) {
           prs.setObject(1, idHD);
           prs.setObject(2, idHD);
           check = prs.executeUpdate();
       } catch (Exception e) {
           e.printStackTrace(System.out);
       }
       return check>0;
   }
   public boolean XoaHD(int idHD){
       String sql = """
                    DELETE FROM [dbo].[HoaDon]
                          WHERE IDHoaDon = ?
                    """;
       
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
//   public boolean soDienThoai(){
//       String sql = """
//                    UPDATE HoaDon 
//                    SET IDKhachHang = (SELECT IDKhachHang FROM KhachHang WHERE KhachHang.SDT = HoaDon.SDT),
//                        NguoiNhan = (SELECT TenKhachHang FROM KhachHang WHERE KhachHang.SDT = HoaDon.SDT),
//                        DiaChi = (SELECT DiaChi FROM KhachHang WHERE KhachHang.SDT = HoaDon.SDT)
//                    WHERE EXISTS (SELECT 1 FROM KhachHang WHERE KhachHang.SDT = HoaDon.SDT)
//                    """;
//       int check =0;
//       try(Connection con = DBCONNCET.getConnection(); 
//                PreparedStatement prs = con.prepareStatement(sql)) {
//           check = prs.executeUpdate();
//       } catch (Exception e) {
//           e.printStackTrace(System.out);
//       }
//       return check>0;
//   }
   public boolean capNhatSoDienThoai(HoaDon hd, int idHD){
       String sql = """
                   update HoaDon
                        set IDKhachHang= ?,
                            NguoiNhan = ?,
                            SDT = ?
                        where IDHoaDon = ?
                    """;
       int check =0;
       try(Connection con = DBCONNCET.getConnection(); 
                PreparedStatement prs = con.prepareStatement(sql)) {
           prs.setObject(1, hd.getIdKhachHang());
           prs.setObject(2, hd.getNguoiNhan());          
           prs.setObject(3, hd.getSoDienThoai());          
           prs.setObject(4, idHD);          
           check = prs.executeUpdate();
       } catch (Exception e) {
           e.printStackTrace(System.out);
       }
       return check>0;
   }
   public ArrayList<HoaDon>tongTienSP(int idHD){
       String sql = """
                    select SUM(DonGia) from HoaDonChiTiet hdct where hdct.IDHoaDon = ?
                    """;
       ArrayList<HoaDon> list = new ArrayList<>();
       try(Connection con = DBCONNCET.getConnection(); 
                PreparedStatement prs = con.prepareStatement(sql)) {
           prs.setObject(1, idHD);
           ResultSet rs = prs.executeQuery();
           while (rs.next()) {               
               list.add(new HoaDon(rs.getFloat(1)));
           }
       } catch (Exception e) {
           e.printStackTrace(System.out);
       }
       return list;
   }    
   
    public static void main(String[] args) {
//        HoaDon hd = new HoaDon(1, "dung", "0001");
//        System.out.println(new HoaDonRepository().capNhatSoDienThoai(hd, 1));
    }
}
