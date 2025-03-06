/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAnProject.repositoris;
import DuAnProject.conncet.DBCONNCET;
import static DuAnProject.conncet.DBCONNCET.getConnection;
import DuAnProject.entity.ChucVu;
import DuAnProject.entity.NhanVien;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author quyet
 */
public class NhanVienRepository {
public List<NhanVien> getAll() {
    List<NhanVien> lists = new ArrayList<>();

    String sql = """
              SELECT 
                  n.IDNhanVien,
                  n.MaNhanVien,
                  n.TenNhanVien,
                  n.GioiTinh,
                  n.NgaySinh,
                  n.DiaChi,
                  n.SDT,
                  n.MatKhau,
                  n.IDChucVu,
                  c.MaChucVu,
                  c.TenChucVu,
                  n.TrangThai
              FROM 
                  NhanVien n
              JOIN 
                  ChucVu c ON n.IDChucVu = c.IDChucVu
              """;

    try (Connection conn = getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery()) {

        while (rs.next()) {
            NhanVien nhanVien = new NhanVien();
            nhanVien.setiDNhanVien(rs.getInt("IDNhanVien"));
            nhanVien.setMaNhanVien(rs.getString("MaNhanVien"));
            nhanVien.setTenNhanVien(rs.getString("TenNhanVien"));
            nhanVien.setGioiTinh(rs.getBoolean("GioiTinh"));
            nhanVien.setNgaySinh(rs.getDate("NgaySinh"));
            nhanVien.setDiaChi(rs.getString("DiaChi"));
            nhanVien.setSDT(rs.getString("SDT"));
            nhanVien.setMatKhau(rs.getString("MatKhau"));
            nhanVien.setIDChucVu(rs.getInt("IDChucVu")); 
            nhanVien.setTrangThai(rs.getBoolean("TrangThai"));

            // Thêm thông tin chức vụ vào đối tượng NhanVien nếu cần
            ChucVu chucVu = new ChucVu();
            chucVu.setMaChucVu(rs.getString("MaChucVu")); // Cột từ bảng ChucVu
            chucVu.setTenChucVu(rs.getString("TenChucVu")); // Cột từ bảng ChucVu
            nhanVien.setChucVu(chucVu); // Giả sử bạn có setter cho ChucVu trong lớp NhanVien

            lists.add(nhanVien);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lists;
 }
 
    
    
    public boolean checkCredential(String username, String password) {
        String sql = "SELECT MaNhanVien, MatKhau FROM NhanVien WHERE MaNhanVien = ? AND MatKhau = ?";
        try(Connection con = DBCONNCET.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return true;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return false; 
    }
public boolean addNhanVien(NhanVien nv) {
    String sql = "INSERT INTO NhanVien (MaNhanVien, TenNhanVien, GioiTinh, NgaySinh, DiaChi, SDT, IDChucVu, TrangThai,MatKhau) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";

    try (Connection conn = getConnection(); 
          PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, nv.getMaNhanVien());
        pstmt.setString(2, nv.getTenNhanVien());
        pstmt.setBoolean(3, nv.isGioiTinh());
        
        // Kiểm tra ngày sinh có phải là null không
        if (nv.getNgaySinh() != null) {
            pstmt.setDate(4, new java.sql.Date(nv.getNgaySinh().getTime()));
        } else {
            pstmt.setNull(4, Types.DATE); 
        }

        pstmt.setString(5, nv.getDiaChi());
        pstmt.setString(6, nv.getSDT());
        pstmt.setInt(7, nv.getIDChucVu());
        pstmt.setBoolean(8, nv.isTrangThai());
       pstmt.setString(9, nv.getMatKhau());
        int rowsAffected = pstmt.executeUpdate();
        return rowsAffected > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
 public boolean deleteNhanVien(String maNhanVien, String tenNhanVien, Boolean gioiTinh) {
    StringBuilder sql = new StringBuilder("DELETE FROM NhanVien WHERE 1=1");
    
    if (maNhanVien != null && !maNhanVien.isEmpty()) {
        sql.append(" AND MaNhanVien = ?");
    }
    if (tenNhanVien != null && !tenNhanVien.isEmpty()) {
        sql.append(" AND TenNhanVien = ?");
    }
    if (gioiTinh != null) {
        sql.append(" AND GioiTinh = ?");
    }

    try (Connection conn = getConnection(); 
         PreparedStatement ps = conn.prepareStatement(sql.toString())) {

        int index = 1;
        
        if (maNhanVien != null && !maNhanVien.isEmpty()) {
            ps.setString(index++, maNhanVien);
        }
        if (tenNhanVien != null && !tenNhanVien.isEmpty()) {
            ps.setString(index++, tenNhanVien);
        }
        if (gioiTinh != null) {
            ps.setBoolean(index++, gioiTinh);
        }

        int rowsAffected = ps.executeUpdate();
        return rowsAffected > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
 public NhanVien getNhanVienByMa(String maNhanVien) {
    String sql = """
        SELECT 
            n.IDNhanVien,
            n.MaNhanVien,
            n.TenNhanVien,
            n.GioiTinh,
            n.NgaySinh,
            n.DiaChi,
            n.SDT,
            n.MatKhau,
            n.IDChucVu,
            c.MaChucVu,
            c.TenChucVu,
            n.TrangThai
        FROM 
            NhanVien n
        JOIN 
            ChucVu c ON n.IDChucVu = c.IDChucVu
        WHERE 
            n.MaNhanVien = ?
        """;

    try (Connection con = DBCONNCET.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, maNhanVien);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            ChucVu chucVu = new ChucVu();
            chucVu.setMaChucVu(rs.getString("MaChucVu"));
            chucVu.setTenChucVu(rs.getString("TenChucVu"));

            NhanVien nhanVien = new NhanVien(
                rs.getInt("IDNhanVien"),
                rs.getString("MaNhanVien"),
                rs.getString("TenNhanVien"),
                rs.getBoolean("GioiTinh"),
                rs.getDate("NgaySinh"),
                rs.getString("DiaChi"),
                rs.getString("SDT"),
                rs.getString("MatKhau"),
                rs.getInt("IDChucVu"),
                rs.getBoolean("TrangThai"),
                chucVu
            );

            return nhanVien;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
public boolean updateNhanVien(NhanVien nhanVien) {
     String sql = """
        UPDATE NhanVien
        SET 
            TenNhanVien = ?, 
            GioiTinh = ?, 
            NgaySinh = ?, 
            DiaChi = ?, 
            SDT = ?, 
            IDChucVu = ?, 
            TrangThai = ?,
             MatKhau = ?
        WHERE MaNhanVien = ?
    """;

    try (Connection conn = getConnection(); 
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, nhanVien.getTenNhanVien());
        ps.setBoolean(2, nhanVien.isGioiTinh());
        
        // Kiểm tra ngày sinh có phải là null không
        if (nhanVien.getNgaySinh() != null) {
            ps.setDate(3, new java.sql.Date(nhanVien.getNgaySinh().getTime()));
        } else {
            ps.setNull(3, Types.DATE);
        }
        
        ps.setString(4, nhanVien.getDiaChi());
        ps.setString(5, nhanVien.getSDT());
        ps.setInt(6, nhanVien.getIDChucVu());
        ps.setBoolean(7, nhanVien.isTrangThai());
        ps.setString(8,nhanVien.getMatKhau());
        ps.setString(9, nhanVien.getMaNhanVien());

        int rowsAffected = ps.executeUpdate();
        return rowsAffected > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
public int getIDChucVuByName(String tenChucVu) {
    String sql = "SELECT IDChucVu FROM ChucVu WHERE TenChucVu = ?";
    try (Connection conn = getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, tenChucVu);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("IDChucVu");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return -1; 
}
public boolean isMaNhanVienExists(String maNhanVien) {
        String sql = "SELECT 1 FROM NhanVien WHERE MaNhanVien = ?";
        
        try (Connection conn = getConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maNhanVien);
            ResultSet rs = ps.executeQuery();
            return rs.next(); 
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}