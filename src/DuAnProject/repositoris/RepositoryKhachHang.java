/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAnProject.repositoris;

import DuAnProject.conncet.DBCONNCET;
import DuAnProject.entity.ModelKhachHang;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
/**
 *
 * @author Admin
 */
public class RepositoryKhachHang {
  public ArrayList<ModelKhachHang> getAll() {
        String sql = """
                     SELECT [IDKhachHang]
                            ,[MaKhachHang]
                            ,[TenKhachHang]
                            ,[NgaySinh]
                            ,[GioiTinh]
                            ,[DiaChi]
                            ,[SDT]
                            ,[Email]
                            FROM [dbo].[KhachHang]""";
        ArrayList<ModelKhachHang> list = new ArrayList<>();
        try (Connection con = DBCONNCET.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
             ModelKhachHang kh = new ModelKhachHang();
             kh.setIDKhachHang(rs.getInt(1));
             kh.setMaKhachHang(rs.getString(2));
             kh.setTenKhachHang(rs.getString(3));
             kh.setNgaySinh(rs.getString(4));
             kh.setGioiTinh(rs.getBoolean(5));
             kh.setDiaChi(rs.getString(6));
             kh.setSoDienThoai(rs.getString(7));
             kh.setEmail(rs.getString(8));
                list.add(kh);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
   public boolean add(ModelKhachHang kh){
       String sql = """
                  INSERT INTO [dbo].[KhachHang]
                                          ([MaKhachHang]
                                          ,[TenKhachHang]
                                          ,[NgaySinh]
                                          ,[GioiTinh]
                                          ,[DiaChi]
                                          ,[SDT]
                                          ,[Email])
                                    
                         VALUES (?,?,?,?,?,?,?);
                    """;
       int check = 0;
        try (Connection con = DBCONNCET.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ps.setObject(1,kh.getMaKhachHang() );
            ps.setObject(2,kh.getTenKhachHang());
            ps.setObject(3, kh.getNgaySinh());
            ps.setObject(4,kh.isGioiTinh());
            ps.setObject(5,kh.getDiaChi());
            ps.setObject(6,kh.getSoDienThoai());
            ps.setObject(7,kh.getEmail());
            check = ps.executeUpdate();  
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
   }
    public boolean delete(int idKH){
        String sql = """
                    DELETE FROM [dbo].[KhachHang]
                                WHERE IDKhachHang = ?
                     
                     """;
        int check = 0;
        try (Connection con = DBCONNCET.getConnection();PreparedStatement ps = con.prepareStatement(sql)){
            ps.setObject(1, idKH);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check >0;
    }
     public boolean update(int idKH,ModelKhachHang kh){
        String sql = """
                   UPDATE [dbo].[KhachHang]
                                   SET [MaKhachHang] = ?
                                      ,[TenKhachHang] = ?
                                      ,[NgaySinh] =?
                                      ,[GioiTinh] = ?
                                      ,[DiaChi] = ?
                                      ,[SDT] = ?
                                      ,[Email] = ?
                           WHERE IDKhachHang = ?
                     
                     """;
        int check = 0;
        try (Connection con = DBCONNCET.getConnection();PreparedStatement ps = con.prepareStatement(sql)){
             ps.setObject(1,kh.getMaKhachHang());
            ps.setObject(2, kh.getTenKhachHang());
            ps.setObject(3, kh.getNgaySinh());
            ps.setObject(4, kh.isGioiTinh());
            ps.setObject(5, kh.getDiaChi());
            ps.setObject(6, kh.getSoDienThoai());
            ps.setObject(7, kh.getEmail());
            ps.setObject(8, idKH);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check >0;
    }
      public static void main(String[] args) {
         System.out.println(new RepositoryKhachHang().getAll());
         //ModelKhachHang kh = new ModelKhachHang("KH08", "Du Khanh An", "1980-01-01", true, "TP HCM", "09871555", "a@gmail.com");
          //System.out.println( new RepositoryKhachHang().add(kh));
         // System.out.println(new RepositoryKhachHang().delete("KH06"));
          //System.out.println(new RepositoryKhachHang().update("KH06", kh));
    }
}
