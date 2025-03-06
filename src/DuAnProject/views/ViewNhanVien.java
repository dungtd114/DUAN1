/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package DuAnProject.views;
import DuAnProject.entity.ChucVu;
import DuAnProject.entity.NhanVien;
import DuAnProject.repositoris.ChucVuRepository;
import DuAnProject.repositoris.NhanVienRepository;
import DuAnProject.repositoris.SanPhamRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author quyet
 */
public class ViewNhanVien extends javax.swing.JPanel {
    private List<ChucVu> chucVuList = new ArrayList<>();
        ArrayList<NhanVien> list = new ArrayList<>();
        DefaultTableModel model = new DefaultTableModel();
         NhanVienRepository nv= new NhanVienRepository();
      private   DefaultComboBoxModel dcbm;
         private ChucVuRepository chucVuRepository;
         private ArrayList<NhanVien> danhSachNhanVienGoc = new ArrayList<>();
         
    public ViewNhanVien() {
        initComponents();
        chucVuRepository = new ChucVuRepository(); 
        dcbm = (DefaultComboBoxModel)cbbChucVu.getModel();
        showCbb();
        loadData();      
    }
    private void showCbb(){
        dcbm.removeAllElements();
        for(ChucVu cv : chucVuRepository.getAll()){
            dcbm.addElement(cv.getTenChucVu());
        }
    }
 private void loadData() {
    List<NhanVien> danhSachNhanVien = nv.getAll();
    model = (DefaultTableModel) tbnv.getModel();
    danhSachNhanVienGoc.clear();
    danhSachNhanVienGoc.addAll(danhSachNhanVien);
    model.setRowCount(0);

    ArrayList<ChucVu> danhSachChucVu = (ArrayList<ChucVu>) chucVuRepository.getAll();
    Map<Integer, String> chucVuMap = new HashMap<>();
    for (ChucVu cv : danhSachChucVu) {
        chucVuMap.put(cv.getIdChucVu(), cv.getTenChucVu());
    }

    for (NhanVien nv : danhSachNhanVien) {
        String tenChucVu = chucVuMap.getOrDefault(nv.getIDChucVu(), "Không xác định");
        model.addRow(new Object[]{
            nv.getMaNhanVien(),
            nv.getTenNhanVien(),
            nv.isGioiTinh() ? "Nam" : "Nữ",
            nv.getNgaySinh(),
            nv.getDiaChi(),
            nv.getSDT(),
            tenChucVu,
            nv.isTrangThai() ? "Đang Làm" : "Nghỉ Làm",
            nv.getMatKhau()
        });
    }
    }
    public boolean check1(){
        if (txtMa.getText().trim().equals("")&&txtDiaChi.getText().trim().equals("")&&txtNgaySinh.getText().trim().equals("")&&txtSDT.getText().trim().equals("")&&txtTen.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống thông tin");
            return false;
        }else {
           return true;
        }
    }
     public boolean check2(){
    for (NhanVien nhanVien : list) {
                String ma = txtMa.getText().trim();
                if (ma.equals(nhanVien.getMaNhanVien())) {
                    JOptionPane.showMessageDialog(this,"Mã Không được trùng");
                    return false;
                }
            }
          return true;
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbnv = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        rdDangLam = new javax.swing.JRadioButton();
        rdNghi = new javax.swing.JRadioButton();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        cbbChucVu = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JTextField();

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tbnv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Nhân Viên", "Họ Và Tên", "Giới Tính", "Ngày Sinh", "Địa Chỉ", "Số Điện Thoại", "Chức Vụ", "Trạng Thái", "Mật Khẩu"
            }
        ));
        tbnv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbnvMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbnv);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel1.setText("Mã Nhân Viên");

        jLabel2.setText("Tên Nhân Viên");

        jLabel3.setText("Giới Tính");

        jLabel4.setText("Ngày Sinh");

        jLabel5.setText("Địa Chỉ");

        jLabel6.setText("Số Điện Thoại");

        jLabel7.setText("Trạng Thái");

        buttonGroup2.add(rdDangLam);
        rdDangLam.setText("Đang Làm");

        buttonGroup2.add(rdNghi);
        rdNghi.setText("Nghỉ Việc");

        buttonGroup1.add(rdNam);
        rdNam.setText("Nam");

        buttonGroup1.add(rdNu);
        rdNu.setText("Nữ");

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Làm Mới");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Mã Nhân Viên");

        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DuAnProject/icon/timkiem.png"))); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTimKiem)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        cbbChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản Lý", "Nhân Viên" }));

        jLabel9.setText("Chức Vụ");

        jLabel10.setText("Mật Khẩu");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMa)
                            .addComponent(txtTen)
                            .addComponent(txtNgaySinh)
                            .addComponent(txtDiaChi)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtMatKhau, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(rdNam)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdNu))
                                    .addComponent(cbbChucVu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(87, 87, 87))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(rdDangLam)
                        .addGap(18, 18, 18)
                        .addComponent(rdNghi)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(rdNam)
                            .addComponent(rdNu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cbbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(rdDangLam)
                    .addComponent(rdNghi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
  String maNhanVien = txtMa.getText().trim();
    if (maNhanVien.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên cần sửa!");
        return;
    }

    String tenNhanVien = txtTen.getText().trim();
    boolean gioiTinh = rdNam.isSelected(); 
    String diaChi = txtDiaChi.getText().trim();
    String sdt = txtSDT.getText().trim();
    String tenChucVu = cbbChucVu.getSelectedItem().toString(); 
    boolean trangThai = rdDangLam.isSelected();
    String ngaySinhText = txtNgaySinh.getText().trim();
     String matkhau = txtMatKhau.getText().trim();
    
    if (tenNhanVien.isEmpty() || diaChi.isEmpty() || sdt.isEmpty() || ngaySinhText.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!");
        return;
    }
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    dateFormat.setLenient(false);
    Date ngaySinh = null;
    try {
        ngaySinh = dateFormat.parse(ngaySinhText);
    } catch (ParseException e) {
        JOptionPane.showMessageDialog(this, "Định dạng ngày sinh không hợp lệ! Vui lòng nhập theo định dạng yyyy-MM-dd.");
        return;
    }
    NhanVien nhanVien = new NhanVien();
    nhanVien.setMaNhanVien(maNhanVien);
    nhanVien.setTenNhanVien(tenNhanVien);
    nhanVien.setGioiTinh(gioiTinh);
    nhanVien.setDiaChi(diaChi);
    nhanVien.setSDT(sdt);
    nhanVien.setNgaySinh(ngaySinh);
    nhanVien.setTrangThai(trangThai);
    nhanVien.setMatKhau(matkhau);

   ChucVuRepository Repo = new ChucVuRepository();
    List<ChucVu> danhSachChucVu = Repo.getAll();
int idChucVu = -1;

for (ChucVu chucVu : danhSachChucVu) {
    if (chucVu.getTenChucVu().equalsIgnoreCase(tenChucVu)) {
        idChucVu = chucVu.getIdChucVu();
        break;
    }
}

if (idChucVu == -1) {
    JOptionPane.showMessageDialog(this, "Chức vụ không hợp lệ!");
    return;
}
nhanVien.setIDChucVu(idChucVu);

    NhanVienRepository nhanVienRepo = new NhanVienRepository();
    boolean success = nhanVienRepo.updateNhanVien(nhanVien);

    if (success) {
        JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
        loadData();
        clearFields();
    } else {
        JOptionPane.showMessageDialog(this, "Cập nhật thất bại! Vui lòng thử lại.");
    }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tbnvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbnvMouseClicked
   int selectedRow = tbnv.getSelectedRow();

if (selectedRow >= 0) {
    DefaultTableModel model = (DefaultTableModel) tbnv.getModel();
    String maNhanVien = (model.getValueAt(selectedRow, 0) != null) ? model.getValueAt(selectedRow, 0).toString() : "";
    String tenNhanVien = (model.getValueAt(selectedRow, 1) != null) ? model.getValueAt(selectedRow, 1).toString() : "";
    String gioiTinh = (model.getValueAt(selectedRow, 2) != null) ? model.getValueAt(selectedRow, 2).toString() : "";
    String ngaySinh = (model.getValueAt(selectedRow, 3) != null) ? model.getValueAt(selectedRow, 3).toString() : "";
    String diaChi = (model.getValueAt(selectedRow, 4) != null) ? model.getValueAt(selectedRow, 4).toString() : "";
    String sdt = (model.getValueAt(selectedRow, 5) != null) ? model.getValueAt(selectedRow, 5).toString() : "";
    String tenChucVu = (model.getValueAt(selectedRow, 6) != null) ? model.getValueAt(selectedRow, 6).toString() : "";
    String trangThai = (model.getValueAt(selectedRow, 7) != null) ? model.getValueAt(selectedRow, 7).toString() : "";
    String matkhau = (model.getValueAt(selectedRow  , 8) !=null) ? model.getValueAt(selectedRow, 8).toString() : "";

    txtMa.setText(maNhanVien);
    txtTen.setText(tenNhanVien);
    txtNgaySinh.setText(ngaySinh);
    txtDiaChi.setText(diaChi);
    txtSDT.setText(sdt);
    txtMatKhau.setText(matkhau);

    rdNam.setSelected("Nam".equals(gioiTinh));
    rdNu.setSelected("Nữ".equals(gioiTinh));

    rdDangLam.setSelected("Đang Làm".equals(trangThai));
    rdNghi.setSelected(!"Đang Làm".equals(trangThai));

    DefaultComboBoxModel modelCbb = (DefaultComboBoxModel) cbbChucVu.getModel();
    if (modelCbb.getIndexOf(tenChucVu) != -1) {
        cbbChucVu.setSelectedItem(tenChucVu);
    } else {
        JOptionPane.showMessageDialog(this, "Chức vụ không hợp lệ");
    }
}
        
    }//GEN-LAST:event_tbnvMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
 
          if (check1() == true) {
        if (check2() == true) {
            String maNhanVien = txtMa.getText().trim();
            String tenNhanVien = txtTen.getText().trim();
            boolean gioiTinh = rdNam.isSelected();
            Date ngaySinh = null;

            String ngaySinhStr = txtNgaySinh.getText().trim();
            if (ngaySinhStr != null && !ngaySinhStr.isEmpty()) {
                try {
                    ngaySinh = new SimpleDateFormat("yyyy-MM-dd").parse(ngaySinhStr);
                } catch (ParseException e) {
                    JOptionPane.showMessageDialog(this, "Ngày sinh không hợp lệ. Định dạng: yyyy-MM-dd");
                    return;
                }
            }

            String diaChi = txtDiaChi.getText().trim();
            String sdt = txtSDT.getText().trim();
            String tenChucVu = (String) cbbChucVu.getSelectedItem();
            boolean trangThai = rdDangLam.isSelected();
            String matkhau = txtMatKhau.getText().trim();

            if (tenNhanVien.isEmpty() || diaChi.isEmpty() || sdt.isEmpty() || matkhau.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!");
                return;
            }

            NhanVienRepository repository = new NhanVienRepository();
            if (repository.isMaNhanVienExists(maNhanVien)) {
                JOptionPane.showMessageDialog(this, "Mã nhân viên đã tồn tại!");
                return;
            }

            NhanVien nv = new NhanVien();
            nv.setMaNhanVien(maNhanVien);
            nv.setTenNhanVien(tenNhanVien);
            nv.setGioiTinh(gioiTinh);
            nv.setNgaySinh(ngaySinh);
            nv.setDiaChi(diaChi);
            nv.setSDT(sdt);
            nv.setTrangThai(trangThai);
            nv.setMatKhau(matkhau);

            int idChucVu = repository.getIDChucVuByName(tenChucVu);
            if (idChucVu != -1) {
                nv.setIDChucVu(idChucVu);

                boolean result = repository.addNhanVien(nv);

                if (result) {
                    JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công!");
                    clearFields();
                    updateTable((ArrayList<NhanVien>) repository.getAll());
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm nhân viên thất bại!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Chức vụ không hợp lệ!");
            }
        }
    }
}
private Integer getSelectedChucVuId() {
    ChucVu selectedChucVu = (ChucVu) cbbChucVu.getSelectedItem();
    return (selectedChucVu != null) ? selectedChucVu.getIdChucVu() : null;
    }//GEN-LAST:event_btnThemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        clearFields();
         updateTable(danhSachNhanVienGoc);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
String maNhanVien = txtMa.getText().trim();
    String tenNhanVien = txtTen.getText().trim();
    Boolean gioiTinh = rdNam.isSelected();

    int confirm = JOptionPane.showConfirmDialog(this, 
            "Bạn có chắc chắn muốn xóa nhân viên không?", 
            "Xác Nhận Xóa", 
            JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
        NhanVienRepository repository = new NhanVienRepository();
        boolean success = repository.deleteNhanVien(maNhanVien.isEmpty() ? null : maNhanVien, 
                                                   tenNhanVien.isEmpty() ? null : tenNhanVien, 
                                                   gioiTinh);
        if (success) {
            JOptionPane.showMessageDialog(this, "Nhân viên đã được xóa thành công.");
            loadData();
        } else {
            JOptionPane.showMessageDialog(this, "Xóa nhân viên thất bại.");
        }
    }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
   String maNhanVien = txtTimKiem.getText().trim();

    if (maNhanVien.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập mã nhân viên để tìm kiếm.", "Thiếu Thông Tin", JOptionPane.WARNING_MESSAGE);
        return;
    }

    NhanVien nhanVien = nv.getNhanVienByMa(maNhanVien);

    DefaultTableModel model = (DefaultTableModel) tbnv.getModel();
    model.setRowCount(0);

    if (nhanVien != null) {
        model.addRow(new Object[]{
            nhanVien.getMaNhanVien(),
            nhanVien.getTenNhanVien(),
            nhanVien.isGioiTinh() ? "Nam" : "Nữ",
            nhanVien.getNgaySinh() != null ? new SimpleDateFormat("yyyy-MM-dd").format(nhanVien.getNgaySinh()) : "",
            nhanVien.getDiaChi(),
            nhanVien.getSDT(),
            nhanVien.getChucVu() != null ? nhanVien.getChucVu().getTenChucVu() : "Chưa có chức vụ",
            nhanVien.isTrangThai() ? "Đang Làm" : "Nghỉ Làm",
            nhanVien.getMatKhau()
        });
    } else {
        JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên với mã: " + maNhanVien, "Không Tìm Thấy", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_btnTimKiemActionPerformed
 private void clearFields() {
    txtMa.setText("");
    txtTen.setText("");
    txtNgaySinh.setText("");
    txtDiaChi.setText("");
    txtSDT.setText("");
    cbbChucVu.setSelectedIndex(0);
    buttonGroup1.clearSelection();
    buttonGroup2.clearSelection();
    txtMatKhau.setText("");
}
 private void updateTable(ArrayList<NhanVien> danhSachNhanVien) {
   DefaultTableModel model = (DefaultTableModel) tbnv.getModel();
    model.setRowCount(0);

    for (NhanVien nv : danhSachNhanVien) {
        model.addRow(new Object[]{
            nv.getMaNhanVien(),
            nv.getTenNhanVien(),
            nv.isGioiTinh() ? "Nam" : "Nữ",
            nv.getNgaySinh() != null ? new SimpleDateFormat("yyyy-MM-dd").format(nv.getNgaySinh()) : "",
            nv.getDiaChi(),
            nv.getSDT(),
            nv.getChucVu() != null ? nv.getChucVu().getTenChucVu() : "Chưa có chức vụ",
            nv.isTrangThai() ? "Đang Làm" : "Nghỉ Việc",
             nv.getMatKhau()
        });
    }
}
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbChucVu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdDangLam;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNghi;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JTable tbnv;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

}
