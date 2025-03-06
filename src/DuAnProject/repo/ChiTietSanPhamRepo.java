/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAnProject.repo;
import DuAnProject.conncet.DBCONNCET;
import DuAnProject.entity.ChiTietSanPham;
import DuAnProject.entity.MauSac;
import DuAnProject.entity.NhaCungCap;
import DuAnProject.entity.SanPham;
import DuAnProject.entity.TacGia;
import DuAnProject.entity.TheLoai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author quyet
 */
public class ChiTietSanPhamRepo {
    public ArrayList<ChiTietSanPham> getAll() {
        String sql = """
                     SELECT spct.IDSanPhamChiTiet, sp.MaSanPham, sp.TenSanPham, tg.TenTG, tl.TenTheLoai, spct.NamPhatHanh, ms.TenMauSac, spct.SoLuongTon,
                            spct.GiaNhap, spct.GiaBan, ncc.TenNhaCungCap, sp.TrangThai
                     FROM SanPhamChiTiet spct
                     INNER JOIN SanPham sp ON sp.IDSanPham = spct.IDSanPham
                     LEFT JOIN MauSac ms ON ms.IDMauSac = spct.IDMauSac
                     INNER JOIN TheLoai tl ON tl.IDTheLoai = spct.IDTheLoai
                     INNER JOIN TacGia tg ON tg.IDTacGia = spct.IDTacGia
                     INNER JOIN NhaCungCap ncc ON ncc.IDNhaCungCap = spct.IDNhaCungCap;""";
        ArrayList<ChiTietSanPham> listCtsp = new ArrayList<>();
        
        try(Connection con = DBCONNCET.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
                ) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getString(2));
                sp.setTenSanPham(rs.getString(3));
                TacGia tg = new TacGia();
                tg.setTenTacGia(rs.getString(4));
                TheLoai tl = new TheLoai();
                tl.setTenTheLoai(rs.getString(5));
                MauSac ms = new MauSac();
                ms.setTenMauSac(rs.getString(7));
                NhaCungCap ncc = new NhaCungCap();
                ncc.setTenNcc(rs.getString(11));
                ChiTietSanPham ctsp = new ChiTietSanPham();
                ctsp.setSanPham(sp);
                ctsp.setTacGia(tg);
                ctsp.setTheLoai(tl);
                ctsp.setMauSac(ms);
                ctsp.setnCC(ncc);
                ctsp.setNamPH(rs.getInt(6));
                ctsp.setSoLuongTon(rs.getInt(8));
                ctsp.setGiaNhap(rs.getDouble(9));
                ctsp.setGiaBan(rs.getDouble(10));
                ctsp.setIdSpct(rs.getInt(1));
                
                listCtsp.add(ctsp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCtsp;
    }
    
    public boolean addSpct(ChiTietSanPham ctsp){
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
                                (?,?,?,?,?,?,?,?,?)""";
        int check = 0 ;
        try(Connection con = DBCONNCET.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
                ) {
            ps.setObject(1, ctsp.getnCC().getIdNcc());
            ps.setObject(2, ctsp.getSanPham().getiDSanPham());
            ps.setObject(3, ctsp.getTheLoai().getiDTheLoai());
            ps.setObject(4, ctsp.getTacGia().getIdTacGia());
            ps.setObject(5, ctsp.getMauSac().getIdMauSac());
            ps.setObject(6, ctsp.getSoLuongTon());
            ps.setObject(7, ctsp.getGiaNhap());
            ps.setObject(8, ctsp.getGiaBan());
            ps.setObject(9, ctsp.getNamPH());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
    
    public boolean updateSpct(int index, ChiTietSanPham ctsp) {
        String sql = """
                     UPDATE [dbo].[SanPhamChiTiet]
                        SET [IDNhaCungCap] = ?
                           ,[IDSanPham] = ?
                           ,[IDTheLoai] = ?
                           ,[IDTacGia] = ?
                           ,[IDMauSac] = ?
                           ,[SoLuongTon] = ?
                           ,[GiaNhap] = ?
                           ,[GiaBan] = ?
                           ,[NamPhatHanh] = ?
                      WHERE IDSanPhamChiTiet = ?""";
        int check = 0;
    try (Connection con = DBCONNCET.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)
            ) {
        ps.setObject(1, ctsp.getnCC().getIdNcc());
        ps.setObject(2, ctsp.getSanPham().getiDSanPham());
        ps.setObject(3, ctsp.getTheLoai().getiDTheLoai());
        ps.setObject(4, ctsp.getTacGia().getIdTacGia());
        ps.setObject(5, ctsp.getMauSac().getIdMauSac());
        ps.setObject(6, ctsp.getSoLuongTon());
        ps.setObject(7, ctsp.getGiaNhap());
        ps.setObject(8, ctsp.getGiaBan());
        ps.setObject(9, ctsp.getNamPH());
        
        ps.setObject(10, index);

        check = ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return check > 0;
    }
    
    public boolean deleteSpct(int id) {
         String sql = """
                 DELETE FROM [dbo].[SanPhamChiTiet]
                       WHERE IDSanPhamChiTiet = ? """;  
    
    int check = 0;
    try (Connection con = DBCONNCET.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)
            ) {
        ps.setInt(1, id);

        check = ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return check > 0;
    }
    
    public ArrayList<ChiTietSanPham> searchGia(double giaMin, double giaMax){
        String sql = """
                     SELECT spct.IDSanPhamChiTiet, sp.MaSanPham, sp.TenSanPham, tg.TenTG, tl.TenTheLoai, spct.NamPhatHanh, ms.TenMauSac, spct.SoLuongTon,
                            spct.GiaNhap, spct.GiaBan, ncc.TenNhaCungCap, sp.TrangThai
                     FROM SanPhamChiTiet spct
                     INNER JOIN SanPham sp ON sp.IDSanPham = spct.IDSanPham
                     LEFT JOIN MauSac ms ON ms.IDMauSac = spct.IDMauSac
                     INNER JOIN TheLoai tl ON tl.IDTheLoai = spct.IDTheLoai
                     INNER JOIN TacGia tg ON tg.IDTacGia = spct.IDTacGia
                     INNER JOIN NhaCungCap ncc ON ncc.IDNhaCungCap = spct.IDNhaCungCap
                     where spct.GiaNhap between ? and ?""";
       ArrayList<ChiTietSanPham> listCtsp2 = new ArrayList<>();
        
        try(Connection con = DBCONNCET.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
                ) {
            ps.setObject(1, giaMin);
            ps.setObject(2, giaMax);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getString(2));
                sp.setTenSanPham(rs.getString(3));
                TacGia tg = new TacGia();
                tg.setTenTacGia(rs.getString(4));
                TheLoai tl = new TheLoai();
                tl.setTenTheLoai(rs.getString(5));
                MauSac ms = new MauSac();
                ms.setTenMauSac(rs.getString(7));
                NhaCungCap ncc = new NhaCungCap();
                ncc.setTenNcc(rs.getString(11));
                ChiTietSanPham ctsp = new ChiTietSanPham();
                ctsp.setIdSpct(rs.getInt(1));
                ctsp.setSanPham(sp);
                ctsp.setTacGia(tg);
                ctsp.setTheLoai(tl);
                ctsp.setMauSac(ms);
                ctsp.setnCC(ncc);
                ctsp.setNamPH(rs.getInt(6));
                ctsp.setSoLuongTon(rs.getInt(8));
                ctsp.setGiaNhap(rs.getDouble(9));
                ctsp.setGiaBan(rs.getDouble(10));
                listCtsp2.add(ctsp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCtsp2; 
    }      
     public static void main(String[] args) {
         System.out.println(new ChiTietSanPhamRepo().searchGia(21000, 25000));
    }
   
}
