/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package DuAnProject.views;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import DuAnProject.entity.HoaDon;
import DuAnProject.entity.HoaDonChiTiet;
import DuAnProject.entity.KhachHang;
import DuAnProject.entity.SanPham;
import DuAnProject.entity.SanPhamChiTiet;
import DuAnProject.repositoris.HoaDonChiTietRepository;
import DuAnProject.repositoris.HoaDonRepository;
import DuAnProject.repositoris.KhachHangRepository;
import DuAnProject.repositoris.SanPhamChiTietRepository;
import DuAnProject.repositoris.SanPhamRepository;
import DuAnProject.responses.HoaDonChiTietResponses;
import DuAnProject.responses.SanPhamChiTietReponses;
import java.util.List;
import javax.swing.JTextField;
/**
 *
 * @author quyet
 */
public class ViewBanHang extends javax.swing.JPanel {

    SanPhamChiTietRepository spctr = new SanPhamChiTietRepository();
    HoaDonChiTietRepository chiTietRepository = new HoaDonChiTietRepository();
    HoaDonChiTiet hdct2 = new HoaDonChiTiet();
    HoaDonRepository hoaDonRepository = new HoaDonRepository();
    KhachHangRepository khr = new KhachHangRepository();
    HoaDon hd = new HoaDon();
    DefaultTableModel dtmSP;
    DefaultTableModel dtmHD = new DefaultTableModel();
    DefaultTableModel dtmGH;
    ArrayList<SanPhamChiTietReponses> listSPCTR = new ArrayList<>();
    ArrayList<HoaDonRepository> listHDR = new ArrayList<>();
    ArrayList<HoaDonChiTiet> listHDCT = new ArrayList<>();
    ArrayList<HoaDonChiTietResponses> listHDCTR = new ArrayList<>();
    ArrayList<KhachHang> listKH = new ArrayList<>();
    ArrayList<SanPhamChiTiet> listSPCT = new ArrayList<>();
    /**
     * Creates new form ViewBanHang
     */
    public ViewBanHang() {        
        initComponents();
        listSPCTR = spctr.getAllSPCTR();
        dtmSP = (DefaultTableModel)tb_SP.getModel();
        dtmGH = (DefaultTableModel)tb_GH.getModel();
        dtmHD = (DefaultTableModel)tbHoaDon.getModel();
        showDataTableSP(listSPCTR);
        showDataTableHD(hoaDonRepository.getAllSPCTT());
        
        setupListeners();
    }
    public void showDataTableSP(ArrayList<SanPhamChiTietReponses> list){
        dtmSP.setRowCount(0);
        for (SanPhamChiTietReponses sanPhamChiTietReponses : list) {
            dtmSP.addRow(new Object[]{
                sanPhamChiTietReponses.getIdSP(),
                sanPhamChiTietReponses.getTenSP(),
                sanPhamChiTietReponses.getSoLuongTon(),
                sanPhamChiTietReponses.getGiaBan()
            });
        }
        
    }
    public void showDataTableGH(ArrayList<HoaDonChiTietResponses> list){
        dtmGH.setRowCount(0);
        for (HoaDonChiTietResponses hoaDonChiTietResponses : list) {
            dtmGH.addRow(new Object[]{
                hoaDonChiTietResponses.getIdSanPhamChiTiet(),
                hoaDonChiTietResponses.getTenSanPham(),
                hoaDonChiTietResponses.getSoLuong(),
                hoaDonChiTietResponses.getDonGia()
            });
        }
    }
    public void showDataTableHD(ArrayList<HoaDon> list){
        dtmHD.setRowCount(0);
        for (HoaDon hoaDon : list) {
            dtmHD.addRow(new Object[]{
                hoaDon.getIdHoaDon(),
                hoaDon.getNgayTao(),
                hoaDon.getNguoiNhan(),
                hoaDon.getSoDienThoai()
            });
        }
    }
//    public void detail(int index){
//        HoaDonChiTietResponses hdctr = chiTietRepository.getAllByIdHD().get(index); 
//        String soLuongStr = JOptionPane.showInputDialog(null, "Mời bạn nhập số lượng sản phẩm:");
//        // Kiểm tra nếu người dùng hủy bỏ hoặc nhập không hợp lệ       
//        
//    }
//    public HoaDonChiTiet getFromData(int index){
//        SanPhamChiTietReponses spctr = listSPCTR.get(index);
//        String idSP = spctr.getIdSP()+"";
//        String soLuongStr = JOptionPane.showInputDialog(null, "Mời bạn nhập số lượng sản phẩm:");
//        // Kiểm tra nếu người dùng hủy bỏ hoặc nhập không hợp lệ
//        if (soLuongStr == null || soLuongStr.trim().isEmpty()) {
//            JOptionPane.showMessageDialog(this,"Bạn đã hủy bỏ hoặc không nhập số lượng.");
//            
//        }
//        // Chuyển đổi số lượng thành kiểu integer
//        int soLuong = Integer.parseInt(soLuongStr);        
//        String donGia = spctr.getGiaBan()+"";
//        String DonGia = (soLuong*Float.valueOf(donGia))+"";
//        HoaDonChiTiet hdct = new HoaDonChiTiet(Integer.valueOf(idSP), soLuong, Float.valueOf(DonGia));        
//        return hdct;      
//   }
    
        
//    
    public HoaDonChiTiet getFromData(int index) {
    SanPhamChiTietReponses spctr = listSPCTR.get(index);
    String idSP = spctr.getIdSP() + "";

    int soLuong;
    do {
        String soLuongStr = JOptionPane.showInputDialog(null, "Mời bạn nhập số lượng sản phẩm:");       
        try { 
            soLuong = Integer.parseInt(soLuongStr);
            if (soLuong < 0) {
               JOptionPane.showMessageDialog(this, "Vui lòng nhập");  
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng là số nguyên.");
            soLuong = -1; // Đặt giá trị âm để lặp lại        
        }
        
        
    } while (soLuong < 0);

    float donGia;
        donGia = Float.parseFloat(spctr.getGiaBan()+"");
    

    HoaDonChiTiet hdct = new HoaDonChiTiet(Integer.valueOf(idSP), soLuong, donGia);
    return hdct;
}
    public float donGia(int idSP) {
    for (SanPhamChiTietReponses spctr : listSPCTR) {
        if (spctr.getIdSP() == idSP) {
            return spctr.getGiaBan();
        }
    }
    return 0.0f; // Giá trị mặc định nếu không tìm thấy sản phẩm
}
    public HoaDonChiTiet getFromDataGH() {
        
    int idSP = Integer.valueOf(tb_GH.getValueAt(tb_GH.getSelectedRow(), 0).toString());

    int soLuong;
    do {
        String soLuongStr = JOptionPane.showInputDialog(null, "Mời bạn nhập số lượng sản phẩm:");
        try {
            soLuong = Integer.parseInt(soLuongStr);
            if (soLuong < 0) {
                JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn hoặc bằng 0.");
            }
         
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng là số nguyên.");
            soLuong = -1; // Đặt giá trị âm để lặp lại
        }
    } while (soLuong < 0);
       float donGia = donGia(idSP);

    // Tính tổng giá
    float tongGia = soLuong * donGia;

        
          HoaDonChiTiet hdct = new HoaDonChiTiet(Integer.valueOf(idSP), soLuong, tongGia);
           return hdct;
}
    
    public HoaDon getThongTinKhachHang(){
        String sDT = txtSDT.getText().trim();
        KhachHang kh = khr.timKiemSoDienThoai(sDT);
        int idKH = kh.getIdKhachHang();
        String sdt = kh.getSoDienThoai();
        String hoTen = kh.getTenKhachHang();
        HoaDon hd = new HoaDon(idKH,hoTen, sdt);
        return hd;
    }
    public KhachHang getThongTinKhachHangSDT(){
        String sdt = txtSDT.getText();
        String hoTen = txtHoTen.getText();
        KhachHang kh = new KhachHang(hoTen, sdt);
        return kh;
    }
        
    public void tongTien(ArrayList<HoaDon>list){
        float tienHang=0;
        for (HoaDon hoaDon : list) {
            tienHang = hoaDon.getTongTien();
        };
        lbTienHang.setText(tienHang+"");
    }
     
    private void thongTinThanhToan() {
        float tienKhach = 0;
         String text = txtTienKhach.getText();

    // Kiểm tra xem chuỗi có rỗng không
    if (text != null && !text.trim().isEmpty()) {
        try {
            // Chuyển đổi chuỗi thành số
            tienKhach = Float.parseFloat(text);
            // Tiến hành xử lý với giaTri
        } catch (NumberFormatException e) {
            // Xử lý trường hợp không thể chuyển đổi thành số
           
        }
    } else {
        // Xử lý trường hợp chuỗi rỗng
    }
        String tienHang = lbTienHang.getText().trim();
        float tongGia = 0;
        if (!tienHang.isEmpty()) {
            tongGia = Float.parseFloat(tienHang);
        }
        float change = tienKhach - tongGia;
        float tienConThieu = tienKhach - tongGia;
        // Cập nhật các thông tin vào JLabel
        if (tienKhach < tongGia) {
            lb_TienTra.setText(" 0 VND");
            lbTienThieu.setText(String.format(" %.2f VND", tienConThieu));
        } else {
            lb_TienTra.setText(String.format(" %.2f VND", change));
            lbTienThieu.setText(" 0 VND");
        }
    }
    
    private void setupListeners() {
        // Lắng nghe thay đổi trong ô nhập tiền mặt
        txtTienKhach.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
               thongTinThanhToan();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                thongTinThanhToan();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                thongTinThanhToan();
            }
        });        
    }
    private void searchBooks() {
    String tenSach = txt_TenSP.getText().trim();
    listSPCTR = spctr.timSach(tenSach); // Gọi phương thức timSach để tìm sách theo tên
    showDataTableSP(listSPCTR); // Hiển thị kết quả lên bảng
}
    private void timKiemSach() {
    txt_TenSP.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            searchBooks();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            searchBooks();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            // Not used for plain text components
        }
    });
}
    public boolean checktxt(){
        if (txtSDT.getText().equals("")) {
           JOptionPane.showMessageDialog(this, "Mời bạn nhập số điện thoại");
           return false;
       } else if(txtHoTen.getText().isEmpty()) {
           JOptionPane.showMessageDialog(this, "Mời bạn nhập tên");
           return false;
       }else{
           return true;
       }
    }
    
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTaoGH = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_GH = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_SP = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTienKhach = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lbTienHang = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lb_TienTra = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbTienThieu = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnThanhToan = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnCapNhat = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        txtHoTen = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txt_TenSP = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbHoaDon = new javax.swing.JTable();
        btnXoaHDC = new javax.swing.JButton();

        btnTaoGH.setText("Tạo hoá đơn");
        btnTaoGH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoGHActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Giỏ hàng"));

        tb_GH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Đơn Giá"
            }
        ));
        tb_GH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_GHMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_GH);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản phẩm"));

        tb_SP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Sản Phẩm", "Tên Sản Phẩm", "Số Lượng Tồn", "Giá Bán"
            }
        ));
        tb_SP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_SPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_SP);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Tiền khách hàng đưa");

        jLabel3.setText("Tổng tiền hàng");

        jLabel9.setText("Tiền phải trả");

        jLabel4.setText("Tiền thiếu");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("THANH TOÁN");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(lb_TienTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lbTienHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(1, 1, 1))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lbTienThieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTienKhach)
                        .addGap(3, 3, 3))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTienKhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTienHang, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_TienTra, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(lbTienThieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThanhToan.setText("THANH TOÁN");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(btnThanhToan)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin khách hàng"));

        jLabel6.setText("SDT");

        jLabel7.setText("Họ tên");

        btnCapNhat.setText("Cập nhật thông tin");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtSDT))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtHoTen))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(btnTimKiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(btnCapNhat)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCapNhat)
                    .addComponent(btnTimKiem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        jLabel5.setText("Tên Sản Phẩm");

        txt_TenSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_TenSPMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_TenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_TenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Hoá Đơn Chờ"));

        tbHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Hoá Đơn", "Ngày Tạo", "Tên Khách Hàng", "SDT"
            }
        ));
        tbHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHoaDonMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbHoaDon);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnXoaHDC.setText("Xoá hoá đơn");
        btnXoaHDC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaHDCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTaoGH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXoaHDC)
                        .addGap(30, 30, 30))
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTaoGH)
                            .addComponent(btnXoaHDC))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaoGHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoGHActionPerformed
        // TODO add your handling code here:
        HoaDonRepository donRepository = new HoaDonRepository();
        donRepository.TaoHoaDon();
        JOptionPane.showMessageDialog(this, "Tạo giỏ hàng thành công");
        dtmGH.setRowCount(0);
        showDataTableHD(hoaDonRepository.getAllSPCTT());
    }//GEN-LAST:event_btnTaoGHActionPerformed

    private void tb_SPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_SPMouseClicked
        // TODO add your handling code here:
       int index = tb_SP.getSelectedRow();     
    int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm đơn hàng không?", "Xác nhận", JOptionPane.YES_NO_OPTION);

    int selectedRowHD = tbHoaDon.getSelectedRow();
    int selectedRowSP = tb_SP.getSelectedRow();

    // Kiểm tra nếu bảng hóa đơn hoặc bảng sản phẩm không có hàng nào được chọn
    if (selectedRowHD == -1 || selectedRowSP == -1) {
        JOptionPane.showMessageDialog(null, "Vui lòng chọn một hàng từ bảng hóa đơn và bảng sản phẩm.");
        return;
    }

    // Kiểm tra nếu bảng hóa đơn không có dữ liệu
    if (tbHoaDon.getRowCount() <= 0) {
        JOptionPane.showMessageDialog(null, "Bảng hóa đơn không có dữ liệu.");
        return;
    }

    // Lấy ID hóa đơn từ bảng hóa đơn
    int idHD = Integer.parseInt(tbHoaDon.getValueAt(selectedRowHD, 0).toString());

    // Kiểm tra lựa chọn của người dùng
    if (option == JOptionPane.YES_OPTION) {
        // Lấy thông tin chi tiết từ dữ liệu người dùng nhập
        HoaDonChiTiet hdct = getFromData(index); // Lấy thông tin từ index và tạo đối tượng HoaDonChiTiet
        if (hdct != null) {
    boolean found = false; // Cờ để kiểm tra nếu ID đã được tìm thấy
    for (HoaDonChiTietResponses hoaDonChiTiet : chiTietRepository.getAllByIdHDon(idHD)) {
       if (hdct.getIdSanPhamChiTiet()==(hoaDonChiTiet.getIdSanPhamChiTiet())) {
            int soLuongDau = chiTietRepository.getAllByIdHDon(idHD).get(index).getSoLuong();
            int soLuongChot = soLuongDau + hdct.getSoLuong();
            chiTietRepository.suaGHver2(soLuongChot, chiTietRepository.getAllByIdHDon(idHD).get(index).getIdHoaDonChiTiet());
            spctr.suaSLT(hdct.getSoLuong(), hdct.getIdSanPhamChiTiet());
            showDataTableSP(spctr.getAllSPCTR());
            showDataTableGH(chiTietRepository.getAllByIdHDon(idHD));
            found = true;
            break; // Nếu bạn chỉ cần tìm thấy một kết quả
       }
    }
    if (!found) {    
        if (hdct.getSoLuong()<=listSPCTR.get(index).getSoLuongTon()) {
            // Thêm sản phẩm vào hóa đơn
        chiTietRepository.themSP(idHD);
        // Kiểm tra nếu hdct không null
        if (hdct != null) { 
                chiTietRepository.suaSP(hdct); 

            // Cập nhật số lượng sản phẩm chi tiết
            spctr.suaSLT(hdct.getSoLuong(), hdct.getIdSanPhamChiTiet());

            // Hiển thị lại dữ liệu trong bảng
            showDataTableSP(spctr.getAllSPCTR());
            showDataTableGH(chiTietRepository.getAllByIdHDon(idHD)); // Hiển thị lại dữ liệu đơn hàng

            // Tính lại tổng tiền
            tongTien(hoaDonRepository.tongTienSP(idHD));
            
        }else {
            // Thông báo lỗi nếu người dùng hủy bỏ hoặc nhập dữ liệu không hợp lệ
            JOptionPane.showMessageDialog(null, "Bạn đã hủy bỏ hoặc không nhập thông tin đơn hàng hợp lệ.");
        }
        }else{
            JOptionPane.showMessageDialog(this, "Số lượng cần nhỏ hơn hoặc bằng số lượng tồn");
        }
        }
}
    } else {
        System.out.println("Bạn đã chọn NO.");
    }
    }//GEN-LAST:event_tb_SPMouseClicked

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        //float tienThieu = Float.valueOf(lbTienThieu.getText());
        
        try {
        String tienKhachText = txtTienKhach.getText().trim();
        String tienHangText = lbTienHang.getText().trim();
        if (tienKhachText.isEmpty() || tienHangText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ số tiền", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        float tienKhach = Float.parseFloat(tienKhachText);
        float tienHang = Float.parseFloat(tienHangText);

        if (tienKhach >= tienHang) {
            int idHD = Integer.valueOf(tbHoaDon.getValueAt(tbHoaDon.getSelectedRow(), 0).toString());
            
            hoaDonRepository.thanhToan(idHD);
           
            JOptionPane.showMessageDialog(this, "Thanh toán thành công");
           
            showDataTableHD(hoaDonRepository.getAllSPCTT());
            dtmGH.setRowCount(0);

            lbTienHang.setText("");
            lb_TienTra.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Mời bạn đưa số tiền lớn hơn tiền hàng", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Số tiền không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
    }

        
        
        
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void txt_TenSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_TenSPMouseClicked
        // TODO add your handling code here:
        timKiemSach();
        
    }//GEN-LAST:event_txt_TenSPMouseClicked

    private void tb_GHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_GHMouseClicked
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa số lượng đơn hàng k?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        int idHD = Integer.valueOf(tbHoaDon.getValueAt(tbHoaDon.getSelectedRow(), 0).toString());
        
       if (option == JOptionPane.YES_OPTION) {
             int index = tb_GH.getSelectedRow();
             int soLuongDau = chiTietRepository.getAllByIdHDon(idHD).get(index).getSoLuong();
             HoaDonChiTiet hdct1 = getFromDataGH();
            chiTietRepository.suaGH(hdct1, chiTietRepository.getAllByIdHDon(idHD).get(index).getIdHoaDonChiTiet());
            if (hdct1.getSoLuong()==0) {
                    chiTietRepository.xoaGH(chiTietRepository.getAllByIdHDon(idHD).get(index).getIdHoaDonChiTiet());
                    int soLuongChot = soLuongDau - hdct1.getSoLuong();
                    spctr.congSPT(soLuongChot, hdct1.getIdSanPhamChiTiet());
                     tongTien(hoaDonRepository.tongTienSP(idHD));
                    showDataTableSP(spctr.getAllSPCTR());
                    showDataTableGH(chiTietRepository.getAllByIdHDon(idHD));
            }else{
                int soLuongChot = soLuongDau - hdct1.getSoLuong();
                spctr.congSPT(soLuongChot, hdct1.getIdSanPhamChiTiet());
                tongTien(hoaDonRepository.tongTienSP(idHD));
                showDataTableSP(spctr.getAllSPCTR());
                showDataTableGH(chiTietRepository.getAllByIdHDon(idHD));
            }
      } else {
          
       }
      

        
    }//GEN-LAST:event_tb_GHMouseClicked

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        String SDT = txtSDT.getText().trim();        
        if (SDT.equals("")) {
            JOptionPane.showMessageDialog(this, "Mời bạn nhập số điện thoại");
        } else {
            KhachHang kh = khr.timKiemSoDienThoai(SDT); // Gọi phương thức timSach để tìm sách theo tên
            txtHoTen.setText(kh.getTenKhachHang());
        }
    
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // TODO add your handling code here:        
        if (checktxt()==true) {
            
            String SDT = txtSDT.getText().trim();
           KhachHang kh = khr.timKiemSoDienThoai(SDT);
        if (kh == null) {
            khr.addTenSDT(getThongTinKhachHangSDT());
        }           
        int idHD = Integer.valueOf(tbHoaDon.getValueAt(tbHoaDon.getSelectedRow(), 0).toString()); 
            hoaDonRepository.capNhatSoDienThoai(getThongTinKhachHang(), idHD);           
        JOptionPane.showMessageDialog(this, "Cập nhật thành công");      
       showDataTableHD(hoaDonRepository.getAllSPCTT());        
        
        
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void tbHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHoaDonMouseClicked
        // TODO add your handling code here:
        int indexs = Integer.valueOf(tbHoaDon.getValueAt(tbHoaDon.getSelectedRow(), 0).toString());
        showDataTableGH(chiTietRepository.getAllByIdHDon(indexs));
        tongTien(hoaDonRepository.tongTienSP(indexs));
    }//GEN-LAST:event_tbHoaDonMouseClicked

    private void btnXoaHDCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaHDCActionPerformed
        // TODO add your handling code here:        
      int index = tbHoaDon.getSelectedRow(); 
       int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn xoá hoá đơn chờ không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
       if (option == JOptionPane.YES_OPTION) {
        if (index >= 0 && index < hoaDonRepository.getAllSPCTT().size()) { 
            int idHoaDon = hoaDonRepository.getAllSPCTT().get(index).getIdHoaDon(); 
            List<HoaDonChiTiet> listHDCT = chiTietRepository.getHDByIDHD(idHoaDon); 
            for (HoaDonChiTiet hdct : listHDCT) {
                spctr.congSPT(hdct.getSoLuong(), hdct.getIdSanPhamChiTiet()); 
                chiTietRepository.xoaGH(hdct.getIdHoaDonChiTiet());
            }            
        } else {
            JOptionPane.showMessageDialog(this, "Lựa chọn không hợp lệ hoặc không có hàng nào được chọn.");
        }
       chiTietRepository.XoaHD(hoaDonRepository.getAllSPCTT().get(index).getIdHoaDon());
       hoaDonRepository.XoaHD(hoaDonRepository.getAllSPCTT().get(index).getIdHoaDon());
       }
        showDataTableHD(hoaDonRepository.getAllSPCTT());
        showDataTableSP(spctr.getAllSPCTR());                     
        dtmGH.setRowCount(0);
        
   
    }//GEN-LAST:event_btnXoaHDCActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnTaoGH;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoaHDC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbTienHang;
    private javax.swing.JLabel lbTienThieu;
    private javax.swing.JLabel lb_TienTra;
    private javax.swing.JTable tbHoaDon;
    private javax.swing.JTable tb_GH;
    private javax.swing.JTable tb_SP;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTienKhach;
    private javax.swing.JTextField txt_TenSP;
    // End of variables declaration//GEN-END:variables

    
}
