/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAnProject.repositoris;

import DuAnProject.conncet.DBCONNCET;
import DuAnProject.entity.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class KhachHangRepository {
    public ArrayList<KhachHang> getAll(){
        String sql = """
                    select IDKhachHang, MaKhachHang, TenKhachHang, NgaySinh, GioiTinh, DiaChi, SDT, Email
                    from KhachHang
                    """;
       ArrayList<KhachHang> list = new ArrayList<>();
       try(Connection con = DBCONNCET.getConnection(); 
                PreparedStatement prs = con.prepareStatement(sql)) {
           ResultSet rs = prs.executeQuery();
           while (rs.next()) {               
               list.add(new KhachHang(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getDate(4),
                       rs.getBoolean(5), rs.getString(6), rs.getString(7), rs.getString(8)));
           }
       } catch (Exception e) {
           e.printStackTrace(System.out);
       }
       return list;
    }
    public boolean addTenSDT(KhachHang kh){
        String sql = """
                    INSERT INTO [dbo].[KhachHang]
                               ([TenKhachHang]
                               ,[SDT])
                         VALUES
                               (?,?)
                    """;
       int check =0;
       try(Connection con = DBCONNCET.getConnection(); 
                PreparedStatement prs = con.prepareStatement(sql)) {
           prs.setObject(1, kh.getTenKhachHang());
           prs.setObject(2, kh.getSoDienThoai());
           check = prs.executeUpdate();
       } catch (Exception e) {
           e.printStackTrace(System.out);
       }
       return check>0;
    }
    public KhachHang timKiemSoDienThoai(String SDT){
       String sql = """
                   select IDKhachHang, MaKhachHang, TenKhachHang, NgaySinh, GioiTinh, DiaChi, SDT, Email
                    from KhachHang
                    where SDT like ?
                    """;
       try(Connection con = DBCONNCET.getConnection(); 
            PreparedStatement prs = con.prepareStatement(sql)) {
           prs.setObject(1, "%" + SDT + "%");          
           ResultSet rs = prs.executeQuery();
           while (rs.next()) {               
               return new KhachHang(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getDate(4),
                       rs.getBoolean(5), rs.getString(6), rs.getString(7), rs.getString(8));
           }
       } catch (Exception e) {
           e.printStackTrace(System.out);
       }
       return null;
   }
    public static void main(String[] args) {
        System.out.println(new KhachHangRepository().timKiemSoDienThoai("0123456789"));
    }
}
