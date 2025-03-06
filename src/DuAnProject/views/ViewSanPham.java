/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package DuAnProject.views;

import DuAnProject.entity.ChiTietSanPham;
import DuAnProject.entity.MauSac;
import DuAnProject.entity.NhaCungCap;
import DuAnProject.entity.SanPham;
import DuAnProject.entity.SanPhamChiTiet;
import DuAnProject.entity.TacGia;
import DuAnProject.entity.TheLoai;
import DuAnProject.repo.ChiTietSanPhamRepo;
import DuAnProject.repositoris.MauSacRepository;
import DuAnProject.repositoris.NhaCCRepository;
import DuAnProject.repositoris.SanPhamRepository;
import DuAnProject.repositoris.TacGiaReposotory;
import DuAnProject.repositoris.TheLoaiRepository;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author quyet
 */
public class ViewSanPham extends javax.swing.JPanel {

    //
    private SanPhamRepository repo = new SanPhamRepository();
    ArrayList<SanPhamChiTiet> listSPCT = new ArrayList<>();
    private DefaultTableModel dtm1 = new DefaultTableModel();
    private DefaultTableModel dtm2 = new DefaultTableModel();
    private ArrayList<SanPham> listsp = new ArrayList<>();
    //
    private DefaultComboBoxModel<MauSac> dcbmMS;
    private DefaultComboBoxModel<TacGia> dcbmTG;
    private DefaultComboBoxModel<TheLoai> dcbmTL;
    private DefaultComboBoxModel<NhaCungCap> dcbmNCC;
    private ChiTietSanPhamRepo chiTietSanPhamRepo = new ChiTietSanPhamRepo();
    private MauSacRepository mauSacRepository = new MauSacRepository();
    private TheLoaiRepository theLoaiRepository = new TheLoaiRepository();
    private TacGiaReposotory tacGiaReposotory = new TacGiaReposotory();
    private NhaCCRepository nhaCCRepository = new NhaCCRepository();
    private ArrayList<ChiTietSanPham> listChiTietSP = new ArrayList<>();
    // thuoctinh
    private DefaultComboBoxModel<MauSac> thuoctinhMS;
    private DefaultComboBoxModel<TacGia> thuoctinhTG;
    private DefaultComboBoxModel<TheLoai> thuoctinhTL;
    private DefaultComboBoxModel<NhaCungCap> thuoctinhNCC;
    private DefaultTableModel dtmMS = new DefaultTableModel();
    private DefaultTableModel dtmTG = new DefaultTableModel();
    private DefaultTableModel dtmTL = new DefaultTableModel();
    private DefaultTableModel dtmNCC = new DefaultTableModel();
    private ArrayList<MauSac> listMS = new ArrayList<>();
    private ArrayList<TacGia> listTG = new ArrayList<>();
    private ArrayList<TheLoai> listTL = new ArrayList<>();
    private ArrayList<NhaCungCap> listNCC = new ArrayList<>();

    /**
     * Creates new form ViewSanPham
     */
    public ViewSanPham() {
        initComponents();
        listsp = repo.getAll();
        dtm1 = (DefaultTableModel) tblSanPham.getModel();
        showDataTableSP1(listsp);
        detailSP1(listsp.size() - 2);
        //
        dcbmMS = (DefaultComboBoxModel) cbbMauSacSPCT.getModel();
        dcbmTG = (DefaultComboBoxModel) cbbTGSPCT.getModel();
        dcbmTL = (DefaultComboBoxModel) cbbTheLoaiSPCT.getModel();
        dcbmNCC = (DefaultComboBoxModel) cbbNCCSPCT.getModel();
        showCbbMauSac();
        showCbbTG();
        showCbbTheLoai();
        showCbbNCC();
        listChiTietSP = chiTietSanPhamRepo.getAll();
        dtm2 = (DefaultTableModel) tblSPCT.getModel();
        showDataTableSPCT2(chiTietSanPhamRepo.getAll());
        detailCTSP2(listChiTietSP.size() - 1);

        //thuoctinh
        
        listMS = mauSacRepository.getAll();
        dtmMS = (DefaultTableModel) tblMauSac.getModel();
//        loadCbbMauSac();
        fillMauSac(listMS);
        detailThuocTinhMS(listMS.size() - 1);

        listTG = tacGiaReposotory.getAll();
        dtmTG = (DefaultTableModel) tblTacGia.getModel();
//        loadCbbTG();
        fillTacGia(listTG);
        detailThuocTinhTG(listTG.size() - 1);

        listTL = theLoaiRepository.getAll();
        dtmTL = (DefaultTableModel) tblTheLoai.getModel();
 //       loadCbbTheLoai();
        fillTheLoai(listTL);
        detailThuocTinhTheLoai(listTL.size() - 1);

        listNCC = nhaCCRepository.getAll();
        dtmNCC = (DefaultTableModel) tblNCC.getModel();
      //  loadCbbNCC();
        fillNCC(listNCC);
        detailThuocTinhNCC(listNCC.size() - 1);
    }

    //sản phẩm
    private void showDataTableSP1(ArrayList<SanPham> list) {
        dtm1.setRowCount(0);
        for (SanPham sp : list) {
            dtm1.addRow(new Object[]{
                sp.getiDSanPham(), sp.getMaSanPham(), sp.getTenSanPham(), sp.isTrangThai() ? "Còn Hàng" : "Hết Hàng"
            });
        }
    }

    private void detailSP1(int index) {
        SanPham sp = listsp.get(index);
        txtMaSp.setText(sp.getMaSanPham());
        txtTenSp.setText(sp.getTenSanPham());
        boolean trangThai = sp.isTrangThai();
        if (trangThai == true) {
            rdnCon.setSelected(true);
        } else {
            rdbHet.setSelected(true);
        }
    }

    private SanPham getFormDataSP1() {
        String maSanPham = txtMaSp.getText();
        String tenSanPham = txtTenSp.getText();
        boolean trangThai = rdnCon.isSelected();
        SanPham sp = new SanPham(WIDTH, maSanPham, tenSanPham, trangThai);
        return sp;
    }

    public boolean validateSP() {
        if (txtMaSp.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã trống");
            return false;
        }
        if (txtTenSp.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên trống");
            return false;
        }
        return true;
    }
    // chi tiết sản phẩm

    private void showCbbMauSac() {
        dcbmMS.removeAllElements();
        for (MauSac ms : mauSacRepository.getAll()) {
            dcbmMS.addElement(ms);
        }
    }

    private void showCbbTG() {
        dcbmTG.removeAllElements();
        for (TacGia tg : tacGiaReposotory.getAll()) {
            dcbmTG.addElement(tg);
        }
    }

    private void showCbbTheLoai() {
        dcbmTL.removeAllElements();
        for (TheLoai tl : theLoaiRepository.getAll()) {
            dcbmTL.addElement(tl);
        }
    }

    private void showCbbNCC() {
        dcbmNCC.removeAllElements();
        for (NhaCungCap ncc : nhaCCRepository.getAll()) {
            dcbmNCC.addElement(ncc);
        }
    }

    private void showDataTableSPCT2(ArrayList<ChiTietSanPham> lists) {
        dtm2.setRowCount(0);
        for (ChiTietSanPham ctsp : lists) {
            dtm2.addRow(new Object[]{ctsp.getIdSpct(),
                ctsp.getSanPham().getMaSanPham(), ctsp.getSanPham().getTenSanPham(), ctsp.getTacGia().getTenTacGia(),
                ctsp.getTheLoai().getTenTheLoai(), ctsp.getNamPH(), ctsp.getMauSac().getTenMauSac(), ctsp.getSoLuongTon(),
                ctsp.getGiaNhap(), ctsp.getGiaBan(), ctsp.getnCC().getTenNcc(), ctsp.getSanPham().isTrangThai() ? "Còn hàng" : "Hết hàng"
            });
        }
    }

    private void detailCTSP2(int index) {
        if (index < 0 || index >= chiTietSanPhamRepo.getAll().size()) {
            // Kiểm tra chỉ số hợp lệ
            return;
        }
        ChiTietSanPham ctsp = listChiTietSP.get(index);
        txtMaSpct.setText(ctsp.getSanPham().getMaSanPham());
        if (ctsp.getTacGia() != null) {
            cbbTGSPCT.setSelectedItem(ctsp.getTacGia().getTenTacGia());
        }

        if (ctsp.getTheLoai() != null) {
            cbbTheLoaiSPCT.setSelectedItem(ctsp.getTheLoai().getTenTheLoai());
        }

        if (ctsp.getMauSac() != null) {
            cbbMauSacSPCT.setSelectedItem(ctsp.getMauSac().getTenMauSac());
        }

        if (ctsp.getnCC() != null) {
            cbbNCCSPCT.setSelectedItem(ctsp.getnCC().getTenNcc());
        }
        txtNamPH.setText(String.valueOf(ctsp.getNamPH()));
        txtSoLuongTon.setText(String.valueOf(ctsp.getSoLuongTon()));
        txtGiaNhap.setText(String.valueOf(ctsp.getGiaNhap()));
        txtGiaBan.setText(String.valueOf(ctsp.getGiaBan()));

        
    }

    private ChiTietSanPham getFormDataSPCT2() {
        int namPH;
        int soLuongTon;
        double giaNhap;
        double giaBan;
        try {
            namPH = Integer.parseInt(txtNamPH.getText().trim());
            soLuongTon = Integer.parseInt(txtSoLuongTon.getText().trim());
            giaNhap = Double.parseDouble(txtGiaNhap.getText().trim());
            giaBan = Double.parseDouble(txtGiaBan.getText().trim());
        } catch (NumberFormatException e) {
            return null;
        }
        TacGia tg = (TacGia) cbbTGSPCT.getSelectedItem();
        TheLoai tl = (TheLoai) cbbTheLoaiSPCT.getSelectedItem();
        MauSac ms = (MauSac) cbbMauSacSPCT.getSelectedItem();
        NhaCungCap ncc = (NhaCungCap) cbbNCCSPCT.getSelectedItem();
        String maSanPham = txtMaSpct.getText();        
        SanPham sp = repo.getSPByMa(maSanPham);
        ChiTietSanPham ctsp = new ChiTietSanPham(sp, soLuongTon, giaNhap, giaBan, namPH, ms, tg, tl, ncc);
        return ctsp;
    }

    public boolean validateCTSPs() {
        if (txtMaSpct.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã trống");
            return false;
        }
        if (txtSoLuongTon.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số lượng trống");
            return false;
        } else {
            try {
                int sl = Integer.parseInt(txtSoLuongTon.getText());
                if (sl < 0) {
                    JOptionPane.showMessageDialog(this, "Số lượng phải lơn hơn 0");
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Số lượng phải là số nguyên");
                return false;
            }
        }
        if (txtNamPH.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Năm Phát Hành trống");
            return false;
        } else {
            try {
                int nam = Integer.parseInt(txtNamPH.getText());
                if (nam < 0) {
                    JOptionPane.showMessageDialog(this, "Năm phải lơn hơn 0");
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Năm phải là số nguyên");
                return false;
            }
        }

        if (txtGiaBan.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Giá Bán trống");
            return false;
        } else {
            try {
                double gia = Double.parseDouble(txtGiaBan.getText());
                if (gia < 0) {
                    JOptionPane.showMessageDialog(this, "Giá phải lớn hơn 0");
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Giá phải là số, không phải chữ");
                return false;
            }
        }
        if (txtGiaNhap.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Giá Nhập trống");
            return false;
        } else {
            try {
                double gia = Double.parseDouble(txtGiaNhap.getText());
                if (gia < 0) {
                    JOptionPane.showMessageDialog(this, "Giá phải lơn hơn 0");
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Giá phải là số, không phải chữ");
                return false;
            }
        }
        return true;
    }

    private boolean checkTrungCTSP(ChiTietSanPham ctsp) {
        for (ChiTietSanPham existingCTSP : listChiTietSP) {
            if (existingCTSP.getSanPham().getTenSanPham().equals(ctsp.getSanPham().getTenSanPham())
                    && existingCTSP.getTacGia().getTenTacGia().equals(ctsp.getTacGia().getTenTacGia())
                    && existingCTSP.getTheLoai().getTenTheLoai().equals(ctsp.getTheLoai().getTenTheLoai())
                    && existingCTSP.getnCC().getTenNcc().equals(ctsp.getnCC().getTenNcc())
                    && existingCTSP.getMauSac().getTenMauSac().equals(ctsp.getMauSac().getTenMauSac())) {
                return true;
            }
        }
        return false;
    }

    private void updateChiTietSanPhamTable() {
        listChiTietSP = chiTietSanPhamRepo.getAll();
        showDataTableSPCT2(listChiTietSP);
    }
    
    public boolean check0(){
        if (txtMaThuocTinh.getText().trim().equals("")&&txtTenThuocTinh.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống ô");
            return false;
        }
        return true;
    }
    public boolean checkMS(){
        for (MauSac mauSac : listMS) {
            String ten = txtMaThuocTinh.getText().trim();
            if (ten.equals(mauSac.getMaMauSac())) {
                JOptionPane.showMessageDialog(this, "Mã không được trùng");
                return false;                
            }
        }
        return true;
    }
    public boolean checkTL(){
        for (TheLoai theLoai : listTL) {
        String ten = txtMaThuocTinh.getText().trim();
            if (ten.equals(theLoai.getMaTheLoai())) {
                JOptionPane.showMessageDialog(this, "Mã không được trùng");
                return false;                
            }
        }
        return true;
    }
    public boolean checkNCC(){
        for (NhaCungCap nhaCungCap : listNCC) {           
        String ten = txtMaThuocTinh.getText().trim();
            if (ten.equals(nhaCungCap.getMaNcc())) {
                JOptionPane.showMessageDialog(this, "Mã không được trùng");
                return false;                
            }
        }
        return true;
    }
    public boolean checkTG(){
        for (TacGia tacGia : listTG) {
        String ten = txtMaThuocTinh.getText().trim();
            if (ten.equals(tacGia.getMaTacGia())) {
                JOptionPane.showMessageDialog(this, "Mã không được trùng");
                return false;                
            }
        }
        return true;
    }
    public boolean check1(){
        for (SanPhamChiTiet sanPhamChiTiet : listSPCT) {
            String maSanPham = txtMaSpct.getText();        
            SanPham sp = repo.getSPByMa(maSanPham);
            if (sp.getiDSanPham().equals(sanPhamChiTiet.getIdSP())) {
                JOptionPane.showMessageDialog(this, "Đã có sản phẩm này trong danh sách");
                return false;
            }
        }
        return true;
    }
    public  boolean check2(){
        for (SanPham sanPham : listsp) {
            String ma = txtMaSpct.getText().trim();
            if (ma.equals(sanPham.getMaSanPham())) {
                return true;
            }else{
                JOptionPane.showMessageDialog(this, "Mã bạn nhập không có");
                return false;
            }
        }
        return false;
    }
    public boolean validateCTSPGia() {
        if (txtGiaMin.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tiền min trống");
            return false;
        } else {
            try {
                double gia = Double.parseDouble(txtGiaMin.getText());
                if (gia < 0) {
                    JOptionPane.showMessageDialog(this, "Tiền min phải lớn hơn 0");
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Tiền min phải là số");
                return false;
            }
        }

        if (txtGiaMax.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tiền max trống");
            return false;
        } else {
            try {
                double gia = Double.parseDouble(txtGiaMax.getText());
                if (gia < 0) {
                    JOptionPane.showMessageDialog(this, "Tiền max phải lớn hơn 0");
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Tiền max phải là số");
                return false;
            }
        }
        if (Double.parseDouble(txtGiaMin.getText()) > Double.parseDouble(txtGiaMax.getText())) {
            JOptionPane.showMessageDialog(this, "Tiền max phải phải lớn hơn tiền min");
            return false;
        }
        return true;
    }

    // thuộc tính
    private void loadCbbMauSac() {
        thuoctinhMS.removeAllElements();
        for (MauSac ms : mauSacRepository.getAll()) {
            thuoctinhMS.addElement(ms);
        }
    }

    public void fillMauSac(ArrayList<MauSac> list) {
        dtmMS.setRowCount(0);
        for (MauSac mauSac : list) {
            dtmMS.addRow(new Object[]{
                mauSac.getMaMauSac(), mauSac.getTenMauSac(), mauSac.isTrangThai() ? "Còn Hoạt Động" : "Không Hoạt Động"
            });
        }
    }

    public void detailThuocTinhMS(int index) {
        txtMaThuocTinh.setText(tblMauSac.getValueAt(index, 0).toString());
        txtTenThuocTinh.setText(tblMauSac.getValueAt(index, 1).toString());
        if (tblMauSac.getValueAt(index, 2).toString().equals("Còn Hoạt Động")) {
            rdbConHDThuocTinh.setSelected(true);
        } else {
            rdbKhHDThuocTinh.setSelected(true);
        }
    }

    public MauSac getFormMauSac() {
        String maMauSac, tenMauSac;
        boolean trangThai;
        maMauSac = txtMaThuocTinh.getText();
        tenMauSac = txtTenThuocTinh.getText();
        if (rdbConHDThuocTinh.isSelected()) {
            trangThai = true;
        } else {
            trangThai = false;
        }
        return new MauSac(maMauSac, tenMauSac, trangThai);
    }

    private void loadCbbTG() {
        thuoctinhTG.removeAllElements();
        for (TacGia tg : tacGiaReposotory.getAll()) {
            thuoctinhTG.addElement(tg);
        }
    }

    public void fillTacGia(ArrayList<TacGia> list) {
        dtmTG.setRowCount(0);
        for (TacGia tg : list) {
            dtmTG.addRow(new Object[]{
                tg.getMaTacGia(), tg.getTenTacGia(), tg.isTrangThai() ? "Còn Hoạt Động" : "Không Hoạt Động"
            });
        }
    }

    public void detailThuocTinhTG(int index) {
        txtMaThuocTinh.setText(tblTacGia.getValueAt(index, 0).toString());
        txtTenThuocTinh.setText(tblTacGia.getValueAt(index, 1).toString());
        if (tblTacGia.getValueAt(index, 2).toString().equals("Còn Hoạt Động")) {
            rdbConHDThuocTinh.setSelected(true);
        } else {
            rdbKhHDThuocTinh.setSelected(true);
        }
    }

    public TacGia getFormTG() {
        String maTacGia, tenTacGia;
        boolean trangThai;
        maTacGia = txtMaThuocTinh.getText();
        tenTacGia = txtTenThuocTinh.getText();
        if (rdbConHDThuocTinh.isSelected()) {
            trangThai = true;
        } else {
            trangThai = false;
        }
        return new TacGia(maTacGia, tenTacGia, trangThai);

    }

    private void loadCbbTheLoai() {
        thuoctinhTL.removeAllElements();
        for (TheLoai tl : theLoaiRepository.getAll()) {
            thuoctinhTL.addElement(tl);
        }
    }

    public void fillTheLoai(ArrayList<TheLoai> list) {
        dtmTL.setRowCount(0);
        for (TheLoai tl : list) {
            dtmTL.addRow(new Object[]{
                tl.getMaTheLoai(), tl.getTenTheLoai(), tl.isTrangThai() ? "Còn Hoạt Động" : "Không Hoạt Động"
            });
        }
    }

    public void detailThuocTinhTheLoai(int index) {
        txtMaThuocTinh.setText(tblTheLoai.getValueAt(index, 0).toString());
        txtTenThuocTinh.setText(tblTheLoai.getValueAt(index, 1).toString());
        if (tblTheLoai.getValueAt(index, 2).toString().equals("Còn Hoạt Động")) {
            rdbConHDThuocTinh.setSelected(true);
        } else {
            rdbKhHDThuocTinh.setSelected(true);
        }
    }

    public TheLoai getFormTheloai() {
        String maTheLoai, tenTheLoai;
        boolean trangThai;
        maTheLoai = txtMaThuocTinh.getText();
        tenTheLoai = txtTenThuocTinh.getText();
        if (rdbConHDThuocTinh.isSelected()) {
            trangThai = true;
        } else {
            trangThai = false;
        }
        return new TheLoai(maTheLoai, tenTheLoai, trangThai);
    }

    private void loadCbbNCC() {
        thuoctinhNCC.removeAllElements();
        for (NhaCungCap ncc : nhaCCRepository.getAll()) {
            thuoctinhNCC.addElement(ncc);
        }
    }

    public void fillNCC(ArrayList<NhaCungCap> list) {
        dtmNCC.setRowCount(0);
        for (NhaCungCap ncc : list) {
            dtmNCC.addRow(new Object[]{
                ncc.getMaNcc(), ncc.getTenNcc(), ncc.isTrangThai() ? "Còn Hoạt Động" : "Không Hoạt Động"
            });
        }
    }

    public void detailThuocTinhNCC(int index) {
        txtMaThuocTinh.setText(tblNCC.getValueAt(index, 0).toString());
        txtTenThuocTinh.setText(tblNCC.getValueAt(index, 1).toString());
        if (tblNCC.getValueAt(index, 2).toString().equals("Còn Hoạt Động")) {
            rdbConHDThuocTinh.setSelected(true);
        } else {
            rdbKhHDThuocTinh.setSelected(true);
        }
    }

    public NhaCungCap getFormNCC() {
        String maNcc, tenNcc;
        boolean trangThai;
        maNcc = txtMaThuocTinh.getText();
        tenNcc = txtTenThuocTinh.getText();
        if (rdbConHDThuocTinh.isSelected()) {
            trangThai = true;
        } else {
            trangThai = false;
        }
        return new NhaCungCap(maNcc, tenNcc, trangThai);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlSP = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaSp = new javax.swing.JTextField();
        txtTenSp = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        rdnCon = new javax.swing.JRadioButton();
        rdbHet = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtTimKiemSP = new javax.swing.JTextField();
        btnTimKiemSP = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        pnlSPCT = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtMaSpct = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cbbMauSacSPCT = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        txtNamPH = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        cbbTheLoaiSPCT = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        cbbNCCSPCT = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        txtGiaNhap = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        cbbTGSPCT = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        txtSoLuongTon = new javax.swing.JTextField();
        btnThemSPCT = new javax.swing.JButton();
        btnSuaSPCT = new javax.swing.JButton();
        btnXoaSPCT = new javax.swing.JButton();
        btnLamMoiSPCT = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSPCT = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtGiaMin = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtGiaMax = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        btnSearchGiaTien = new javax.swing.JButton();
        btnLoadLaiTable = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTenThuocTinh = new javax.swing.JTextField();
        btnThemThuocTinh = new javax.swing.JButton();
        btnSuaThuocTinh = new javax.swing.JButton();
        btnXoaThuocTinh = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtMaThuocTinh = new javax.swing.JTextField();
        rdbConHDThuocTinh = new javax.swing.JRadioButton();
        rdbKhHDThuocTinh = new javax.swing.JRadioButton();
        btnClearThuocTinh = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        rb_MS = new javax.swing.JRadioButton();
        rb_TG = new javax.swing.JRadioButton();
        rb_NCC = new javax.swing.JRadioButton();
        rb_TL = new javax.swing.JRadioButton();
        pnlThuocTinh = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMauSac = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblTacGia = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblNCC = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblTheLoai = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(870, 703));

        jLabel2.setText("Mã sản phẩm");

        jLabel3.setText("Tên sản phẩm");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel4.setText("Trạng Thái");

        buttonGroup1.add(rdnCon);
        rdnCon.setText("Còn Hàng");

        buttonGroup1.add(rdbHet);
        rdbHet.setText("Hết Hàng");

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã Sách", "Tên Sách", "Trạng Thái"
            }
        ));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setText("Tên Sách");

        btnTimKiemSP.setText("Search");
        btnTimKiemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKiemSP, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(btnTimKiemSP)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiemSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiemSP))
                .addContainerGap())
        );

        btnLamMoi.setText("Refresh");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSPLayout = new javax.swing.GroupLayout(pnlSP);
        pnlSP.setLayout(pnlSPLayout);
        pnlSPLayout.setHorizontalGroup(
            pnlSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSPLayout.createSequentialGroup()
                .addGroup(pnlSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSPLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(pnlSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(pnlSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnThem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(pnlSPLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnLamMoi)))
                .addGap(18, 18, 18)
                .addGroup(pnlSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSPLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 211, Short.MAX_VALUE))
                    .addGroup(pnlSPLayout.createSequentialGroup()
                        .addGroup(pnlSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenSp, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(txtMaSp))
                        .addGroup(pnlSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlSPLayout.createSequentialGroup()
                                .addGap(175, 175, 175)
                                .addComponent(rdnCon)
                                .addGap(64, 64, 64)
                                .addComponent(rdbHet))
                            .addGroup(pnlSPLayout.createSequentialGroup()
                                .addGap(244, 244, 244)
                                .addComponent(jLabel4)))
                        .addContainerGap(182, Short.MAX_VALUE))
                    .addGroup(pnlSPLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(30, 30, 30))))
        );
        pnlSPLayout.setVerticalGroup(
            pnlSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSPLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnlSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(pnlSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(pnlSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTenSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rdnCon)
                        .addComponent(rdbHet)))
                .addGroup(pnlSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSPLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(btnThem))
                    .addGroup(pnlSPLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(pnlSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSPLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(btnSua)
                        .addGap(46, 46, 46)
                        .addComponent(btnXoa)
                        .addGap(49, 49, 49)
                        .addComponent(btnLamMoi)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlSPLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );

        jTabbedPane1.addTab("SẢN PHẨM", pnlSP);

        pnlSPCT.setPreferredSize(new java.awt.Dimension(870, 702));

        jPanel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel14.setText("Quản Lý Sản Phẩm");

        jLabel15.setText("MÃ");

        jLabel17.setText("Tác Giả");

        jLabel18.setText("Màu Sắc");

        cbbMauSacSPCT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel19.setText("Năm Phát Hành");

        jLabel20.setText("Thể Loại");

        cbbTheLoaiSPCT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel21.setText("NCC");

        cbbNCCSPCT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel22.setText("Giá Nhập");

        jLabel23.setText("Giá Bán");

        cbbTGSPCT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbTGSPCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTGSPCTActionPerformed(evt);
            }
        });

        jLabel24.setText("Số Lượng Tồn");

        btnThemSPCT.setText("Thêm");
        btnThemSPCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSPCTActionPerformed(evt);
            }
        });

        btnSuaSPCT.setText("Sửa");
        btnSuaSPCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaSPCTActionPerformed(evt);
            }
        });

        btnXoaSPCT.setText("Xóa");
        btnXoaSPCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSPCTActionPerformed(evt);
            }
        });

        btnLamMoiSPCT.setText("Làm Mới");
        btnLamMoiSPCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiSPCTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel15))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGap(82, 82, 82)
                                        .addComponent(txtNamPH, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(95, 95, 95)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel18)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel21)
                                            .addComponent(jLabel22))
                                        .addGap(30, 30, 30)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(cbbNCCSPCT, javax.swing.GroupLayout.Alignment.LEADING, 0, 193, Short.MAX_VALUE)
                                                .addComponent(cbbTheLoaiSPCT, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cbbMauSacSPCT, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(37, 37, 37)
                                                .addComponent(jLabel23)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(btnLamMoiSPCT)))
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(jLabel24)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtSoLuongTon))
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(jLabel17)
                                    .addGap(49, 49, 49)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbbTGSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtMaSpct, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(jLabel19)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(btnThemSPCT)
                        .addGap(31, 31, 31)
                        .addComponent(btnSuaSPCT)
                        .addGap(42, 42, 42)
                        .addComponent(btnXoaSPCT))
                    .addComponent(jLabel14))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtMaSpct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(cbbMauSacSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(cbbTheLoaiSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(cbbTGSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(cbbNCCSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addGap(18, 28, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNamPH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22)
                        .addComponent(jLabel23)
                        .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemSPCT)
                    .addComponent(btnSuaSPCT)
                    .addComponent(btnXoaSPCT)
                    .addComponent(btnLamMoiSPCT)))
        );

        jPanel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setText("Thông Tin Sản Phẩm");

        tblSPCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID SPCT", "Mã Sản Phẩm", "Tên Sản Phẩm", "Tác Giả", "Thể Loại", "Năm PH", "Màu Sắc", "Số Lượng Tồn", "Giá Nhập", "Giá Bán", "Nhà Cung Cấp"
            }
        ));
        tblSPCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSPCTMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblSPCT);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel11.setText("Giá Tiền Bán");

        jLabel12.setText("Từ");

        jLabel13.setText("Đến");

        jLabel25.setText("VND");

        jLabel26.setText("VND");

        btnSearchGiaTien.setText("Search");
        btnSearchGiaTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchGiaTienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(0, 585, Short.MAX_VALUE))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtGiaMin, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addGap(70, 70, 70)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtGiaMax, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSearchGiaTien)
                .addGap(52, 52, 52))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtGiaMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel13)
                    .addComponent(txtGiaMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(btnSearchGiaTien))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        btnLoadLaiTable.setText("Reset");
        btnLoadLaiTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadLaiTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLoadLaiTable)
                .addGap(26, 26, 26))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(btnLoadLaiTable)
                        .addGap(33, 33, 33))))
        );

        javax.swing.GroupLayout pnlSPCTLayout = new javax.swing.GroupLayout(pnlSPCT);
        pnlSPCT.setLayout(pnlSPCTLayout);
        pnlSPCTLayout.setHorizontalGroup(
            pnlSPCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlSPCTLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSPCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlSPCTLayout.setVerticalGroup(
            pnlSPCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSPCTLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("CHI TIẾT SẢN PHẨM", pnlSPCT);

        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setText("Thuộc Tính");

        jLabel7.setText("Tên Thuộc Tính ");

        btnThemThuocTinh.setText("Thêm");
        btnThemThuocTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemThuocTinhActionPerformed(evt);
            }
        });

        btnSuaThuocTinh.setText("Sửa");
        btnSuaThuocTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaThuocTinhActionPerformed(evt);
            }
        });

        btnXoaThuocTinh.setText("Xóa");
        btnXoaThuocTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaThuocTinhActionPerformed(evt);
            }
        });

        jLabel9.setText("Mã Thuộc Tính");

        buttonGroup2.add(rdbConHDThuocTinh);
        rdbConHDThuocTinh.setText("Còn Hoạt Động");

        buttonGroup2.add(rdbKhHDThuocTinh);
        rdbKhHDThuocTinh.setText("Không Hoạt Động");

        btnClearThuocTinh.setText("Clear");
        btnClearThuocTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearThuocTinhActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jLabel10.setText("Trạng Thái");

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Chọn thuộc tính"));

        buttonGroup4.add(rb_MS);
        rb_MS.setText("Màu Sắc");

        buttonGroup4.add(rb_TG);
        rb_TG.setText("Tác Giả");

        buttonGroup4.add(rb_NCC);
        rb_NCC.setText("Nhà Cung Cấp");

        buttonGroup4.add(rb_TL);
        rb_TL.setText("Thể Loại");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rb_MS)
                    .addComponent(rb_NCC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rb_TG)
                    .addComponent(rb_TL))
                .addGap(34, 34, 34))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_MS)
                    .addComponent(rb_TG))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_NCC)
                    .addComponent(rb_TL))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnThemThuocTinh))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel6))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel9))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(btnXoaThuocTinh)
                                        .addGap(37, 37, 37)
                                        .addComponent(btnSuaThuocTinh)
                                        .addGap(27, 27, 27)
                                        .addComponent(btnClearThuocTinh)
                                        .addGap(52, 52, 52)
                                        .addComponent(btnReset))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(rdbConHDThuocTinh)
                                        .addGap(30, 30, 30)
                                        .addComponent(rdbKhHDThuocTinh)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTenThuocTinh)
                                    .addComponent(txtMaThuocTinh, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)))))
                .addGap(52, 52, 52))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(txtMaThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbConHDThuocTinh)
                    .addComponent(rdbKhHDThuocTinh)
                    .addComponent(jLabel10))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuaThuocTinh)
                    .addComponent(btnXoaThuocTinh)
                    .addComponent(btnThemThuocTinh)
                    .addComponent(btnClearThuocTinh)
                    .addComponent(btnReset))
                .addGap(29, 29, 29))
        );

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblMauSac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Màu Sắc", "Tên Màu Sắc", "Trạng Thái"
            }
        ));
        tblMauSac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMauSacMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblMauSac);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 813, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
        );

        pnlThuocTinh.addTab("Màu Sắc", jPanel1);

        tblTacGia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Tác Giả", "Tên Tác Giả", "Trạng Thái"
            }
        ));
        tblTacGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTacGiaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblTacGia);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );

        pnlThuocTinh.addTab("Tác Giả", jPanel2);

        tblNCC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NCC", "TênNCC", "Trạng Thái"
            }
        ));
        tblNCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNCCMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblNCC);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );

        pnlThuocTinh.addTab("Nhà Cung Cấp", jPanel10);

        tblTheLoai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Thể Loại", "Tên Thể Loại", "Trạng Thái"
            }
        ));
        tblTheLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTheLoaiMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblTheLoai);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );

        pnlThuocTinh.addTab("Thể Loại", jPanel11);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlThuocTinh)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlThuocTinh))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("THUỘC TÍNH SẢN PHẨM", jPanel3);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DuAnProject/icon/285679_book_address_icon.png"))); // NOI18N
        jLabel1.setText("QUẢN LÝ SẢN PHẨM");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 859, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 715, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        showDataTableSP1(repo.getAll());
        
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        // TODO add your handling code here:
        int index = tblSanPham.getSelectedRow();
        detailSP1(index);
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        SanPham sp = getFormDataSP1();
        if (validateSP()) {
            if (repo.getOne(sp.getMaSanPham()) != null) {
                JOptionPane.showMessageDialog(this, "Mã Sản Phẩm Trùng");
                return;
            } else {
                int confirmed = JOptionPane.showConfirmDialog(this,
                        "Bạn có chắc chắn muốn thêm sản phẩm này?", "Xác nhận thêm sản phẩm",
                        JOptionPane.YES_NO_OPTION);
                if (confirmed == JOptionPane.YES_OPTION) {
                    if (repo.add(getFormDataSP1())) {
                        listsp = repo.getAll();
                        showDataTableSP1(listsp);
                        JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công");
                        updateChiTietSanPhamTable();
                    } else {
                        JOptionPane.showMessageDialog(this, "Thêm sản phẩm thất bại");
                    }
                }
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        int index = tblSanPham.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng dữ liệu nào");
        } else {
            int confirmed = JOptionPane.showConfirmDialog(this,
                    "Bạn có chắc chắn muốn sửa sản phẩm này?", "Xác nhận sửa sản phẩm",
                    JOptionPane.YES_NO_OPTION);
            if (confirmed == JOptionPane.YES_OPTION) {
                SanPham sp = getFormDataSP1();
                String ma = tblSanPham.getValueAt(index, 0).toString();
                if (repo.update(sp, listsp.get(index).getiDSanPham())) {
                    listsp = repo.getAll();
                    showDataTableSP1(listsp);
                    JOptionPane.showMessageDialog(this, "Sửa Sản Phẩm Thành Công");
                    updateChiTietSanPhamTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa Sản Phẩm Thất Bại");
                }
            }
        }

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int index = tblSanPham.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng dữ liệu nào");
        } else {
            int confirmed = JOptionPane.showConfirmDialog(this,
                    "Bạn có chắc chắn muốn xóa sản phẩm này?", "Xác nhận xóa sản phẩm",
                    JOptionPane.YES_NO_OPTION);
            if (confirmed == JOptionPane.YES_OPTION) {
                SanPham sp = getFormDataSP1();
                if (repo.delete(listsp.get(index).getiDSanPham())) {
                    listsp = repo.getAll();
                    showDataTableSP1(listsp);
                    JOptionPane.showMessageDialog(this, "Xóa Sản Phẩm Thành Công");
                    updateChiTietSanPhamTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa Sản Phẩm Thất Bại");
                }
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimKiemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemSPActionPerformed
        // TODO add your handling code here
        String tenSPTimKiem = txtTimKiemSP.getText().trim();
        if (tenSPTimKiem.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nhập mã sản phẩm để tìm kiếm.");
            return;
        }
        ArrayList<SanPham> timSp = repo.search(tenSPTimKiem);
        if (timSp.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm với mã: " + tenSPTimKiem);
        } else {
            showDataTableSP1(timSp);
            JOptionPane.showMessageDialog(this, "Tìm thấy sản phẩm với mã: " + tenSPTimKiem);
        }
    }//GEN-LAST:event_btnTimKiemSPActionPerformed

    private void tblSPCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSPCTMouseClicked
        // TODO add your handling code here:
        int index = tblSPCT.getSelectedRow();
        detailCTSP2(index);

    }//GEN-LAST:event_tblSPCTMouseClicked

    private void btnSearchGiaTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchGiaTienActionPerformed
        // TODO add your handling code here:
        if (validateCTSPGia()) {
            double giaMin = Double.parseDouble(txtGiaMin.getText());
            double giaMax = Double.parseDouble(txtGiaMax.getText());
            ArrayList<ChiTietSanPham> search = chiTietSanPhamRepo.searchGia(giaMin, giaMax);
            if (search.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm phù hợp", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                showDataTableSPCT2(search);
            }
        }
    }//GEN-LAST:event_btnSearchGiaTienActionPerformed

    private void btnLoadLaiTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadLaiTableActionPerformed
        // TODO add your handling code here:
        int confirmed = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc chắn muốn làm mới sản phẩm chi tiết ?", "Xác nhận làm mới !!!",
                JOptionPane.YES_NO_OPTION);
        if (confirmed == JOptionPane.YES_OPTION) {
            showDataTableSPCT2(chiTietSanPhamRepo.getAll());
           showCbbMauSac();
        showCbbTG();
        showCbbTheLoai();
        showCbbNCC();
        }
    }//GEN-LAST:event_btnLoadLaiTableActionPerformed

    // thuộc tính

    private void tblMauSacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMauSacMouseClicked
        // TODO add your handling code here:
        int index = tblMauSac.getSelectedRow();
        detailThuocTinhMS(index);
    }//GEN-LAST:event_tblMauSacMouseClicked

    private void tblTacGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTacGiaMouseClicked
        // TODO add your handling code here:
        int index = tblTacGia.getSelectedRow();
        detailThuocTinhTG(index);
    }//GEN-LAST:event_tblTacGiaMouseClicked

    private void tblNCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNCCMouseClicked
        // TODO add your handling code here:
        int index = tblNCC.getSelectedRow();
        detailThuocTinhNCC(index);
    }//GEN-LAST:event_tblNCCMouseClicked

    private void tblTheLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTheLoaiMouseClicked
        // TODO add your handling code here:
        int index = tblTheLoai.getSelectedRow();
        detailThuocTinhTheLoai(index);
    }//GEN-LAST:event_tblTheLoaiMouseClicked

    private void btnThemThuocTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemThuocTinhActionPerformed
        // TODO add your handling code here:
        if (check0()==true) {
            if (rb_MS.isSelected()) {
                if (checkMS()==true) {
                    mauSacRepository.add(getFormMauSac());
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            listMS = mauSacRepository.getAll();
            fillMauSac(listMS);
                }
            
        }else if(rb_NCC.isSelected()){
                if (checkNCC()==true) {
                    nhaCCRepository.add(getFormNCC());
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            listNCC = nhaCCRepository.getAll();
            fillNCC(listNCC);
                }
        }else if(rb_TG.isSelected()){
                if (checkTG()) {
                    tacGiaReposotory.add(getFormTG());
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            fillTacGia(tacGiaReposotory.getAll());
                }
        }else if(rb_TL.isSelected()){
                if (checkTL()) {
                    theLoaiRepository.add(getFormTheloai());
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            fillTheLoai(theLoaiRepository.getAll());
                }
        }else{
            JOptionPane.showMessageDialog(this, "Mời bạn chọn thuộc tính");
        }
        }
    }//GEN-LAST:event_btnThemThuocTinhActionPerformed

    private void btnXoaThuocTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaThuocTinhActionPerformed
        // TODO add your handling code here:
        if (rb_MS.isSelected()) {
            int index = tblMauSac.getSelectedRow();
            mauSacRepository.delete(listMS.get(index).getIdMauSac());
            JOptionPane.showMessageDialog(this, "Xoá thành công");
            listMS = mauSacRepository.getAll();
            fillMauSac(listMS);
        }else if(rb_NCC.isSelected()){
            int index = tblNCC.getSelectedRow();
            nhaCCRepository.delete(listNCC.get(index).getIdNcc());
            JOptionPane.showMessageDialog(this, "Xoá thành công");
            listNCC = nhaCCRepository.getAll();
            fillNCC(listNCC);
        }else if(rb_TG.isSelected()){
            int index = tblTacGia.getSelectedRow();
            tacGiaReposotory.delete(listTG.get(index).getIdTacGia());
            JOptionPane.showMessageDialog(this, "Xoá thành công");
            fillTacGia(tacGiaReposotory.getAll());
        }else if(rb_TL.isSelected()){
            int index = tblTheLoai.getSelectedRow();
            theLoaiRepository.delete(listTL.get(index).getiDTheLoai());
            JOptionPane.showMessageDialog(this, "Xoá thành công");
            fillTheLoai(theLoaiRepository.getAll());
        }else{
            JOptionPane.showMessageDialog(this, "Mời bạn chọn thuộc tính");
        }
    }//GEN-LAST:event_btnXoaThuocTinhActionPerformed

    private void btnSuaThuocTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaThuocTinhActionPerformed
        // TODO add your handling code here:
        if (check0()==true) {
            if (rb_MS.isSelected()) {
            int index = tblMauSac.getSelectedRow();
            mauSacRepository.update(listMS.get(index).getIdMauSac(),getFormMauSac());
            JOptionPane.showMessageDialog(this, "Sửa thành công");
            listMS = mauSacRepository.getAll();
            fillMauSac(listMS);
        }else if(rb_NCC.isSelected()){
            int index = tblNCC.getSelectedRow();
            nhaCCRepository.update(listNCC.get(index).getIdNcc(),getFormNCC());
            JOptionPane.showMessageDialog(this, "Sửa thành công");
            listNCC = nhaCCRepository.getAll();
            fillNCC(listNCC);
        }else if(rb_TG.isSelected()){
            int index = tblTacGia.getSelectedRow();
            tacGiaReposotory.update(listTG.get(index).getIdTacGia(), getFormTG());
            JOptionPane.showMessageDialog(this, "Sửa thành công");
            fillTacGia(tacGiaReposotory.getAll());
        }else if(rb_TL.isSelected()){
            int index = tblTheLoai.getSelectedRow();
            theLoaiRepository.update(listTL.get(index).getiDTheLoai(), getFormTheloai());
            JOptionPane.showMessageDialog(this, "Sửa thành công");
            fillTheLoai(theLoaiRepository.getAll());
        }else{
            JOptionPane.showMessageDialog(this, "Mời bạn chọn thuộc tính");
        }
        }
    }//GEN-LAST:event_btnSuaThuocTinhActionPerformed

    private void btnClearThuocTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearThuocTinhActionPerformed
        // TODO add your handling code here:
        txtMaThuocTinh.setText("");
        txtTenThuocTinh.setText("");
    }//GEN-LAST:event_btnClearThuocTinhActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        listMS = mauSacRepository.getAll();
            fillMauSac(listMS);
            listNCC = nhaCCRepository.getAll();
            fillNCC(listNCC);
            fillTacGia(tacGiaReposotory.getAll());
            fillTheLoai(theLoaiRepository.getAll());
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnLamMoiSPCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiSPCTActionPerformed
        // TODO add your handling code here:
        int confirmed = JOptionPane.showConfirmDialog(this,
            "Bạn có chắc chắn muốn làm mới sản phẩm chi tiết ?", "Xác nhận làm mới !!!",
            JOptionPane.YES_NO_OPTION);
        if (confirmed == JOptionPane.YES_OPTION) {
            txtMaSpct.setText("");
            txtNamPH.setText("");
            txtSoLuongTon.setText("");
            txtGiaNhap.setText("");
            txtGiaBan.setText("");
            if (dcbmTG.getSize() > 0) {
                cbbTGSPCT.setSelectedIndex(0);
            }
            if (dcbmTL.getSize() > 0) {
                cbbTheLoaiSPCT.setSelectedIndex(0);
            }
            if (dcbmMS.getSize() > 0) {
                cbbMauSacSPCT.setSelectedIndex(0);
            }
            if (dcbmNCC.getSize() > 0) {
                cbbNCCSPCT.setSelectedIndex(0);
            }
        }
    }//GEN-LAST:event_btnLamMoiSPCTActionPerformed

    private void btnXoaSPCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSPCTActionPerformed
        // TODO add your handling code here:
        int index = tblSPCT.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng dữ liệu nào");
        } else {
            int confirmed = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc chắn muốn xóa sản phẩm chi tiết này?", "Xác nhận xóa sản phẩm",
                JOptionPane.YES_NO_OPTION);
            if (confirmed == JOptionPane.YES_OPTION) {
                ChiTietSanPham ctsp = getFormDataSPCT2();
                if (chiTietSanPhamRepo.deleteSpct(listChiTietSP.get(index).getIdSpct())) {
                    listChiTietSP = chiTietSanPhamRepo.getAll();
                    showDataTableSPCT2(listChiTietSP);
                    JOptionPane.showMessageDialog(this, "Xóa Sản Phẩm Chi Tiết Thành Công");
                    updateChiTietSanPhamTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa Sản Phẩm Chi Tiết Thất Bại");
                }
            }
        }
    }//GEN-LAST:event_btnXoaSPCTActionPerformed

    private void btnSuaSPCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaSPCTActionPerformed
        // TODO add your handling code here:
        int index = tblSPCT.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng dữ liệu nào");
            return;
        } else {
            
            if (check1()==true) {
            int option = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc chắn muốn sửa chi tiết sản phẩm này không?",
                "Xác nhận",
                JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                ChiTietSanPham ctsp = getFormDataSPCT2();
                if (ctsp == null) {
                    return;
                }
                if (chiTietSanPhamRepo.updateSpct(listChiTietSP.get(index).getIdSpct(), ctsp)) {
                    listChiTietSP = chiTietSanPhamRepo.getAll();
                    showDataTableSPCT2(listChiTietSP);
                    JOptionPane.showMessageDialog(this, "Sửa Chi Tiết Sản Phẩm Thành Công");
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa chi tiết sản phẩm thất bại");
                }
            }
        }
            
        }
    }//GEN-LAST:event_btnSuaSPCTActionPerformed

    private void btnThemSPCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSPCTActionPerformed
        // TODO add your handling code here:
        ChiTietSanPham ctsp = getFormDataSPCT2();
        if (ctsp == null) {
            return;
        }
        if (check2()==true) {
            if (check1()==true) {
                int option = JOptionPane.showConfirmDialog(this,
            "Bạn có chắc chắn muốn thêm chi tiết sản phẩm này không?",
            "Xác nhận",
            JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            if (validateCTSPs()) {
                if (checkTrungCTSP(ctsp)) {
                    JOptionPane.showMessageDialog(this, "Chi tiết sản phẩm đã tồn tại, vui lòng kiểm tra lại", "Message", 2);
                    return;
                } else {
                    if (chiTietSanPhamRepo.addSpct(getFormDataSPCT2())) {
                        showDataTableSPCT2(chiTietSanPhamRepo.getAll());
                        JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công");
                    } else {
                        JOptionPane.showMessageDialog(this, "Thêm sản phẩm thất bại");
                    }
                }
            }
        }
            }
        }

    }//GEN-LAST:event_btnThemSPCTActionPerformed

    private void cbbTGSPCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTGSPCTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbTGSPCTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClearThuocTinh;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLamMoiSPCT;
    private javax.swing.JButton btnLoadLaiTable;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearchGiaTien;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSuaSPCT;
    private javax.swing.JButton btnSuaThuocTinh;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemSPCT;
    private javax.swing.JButton btnThemThuocTinh;
    private javax.swing.JButton btnTimKiemSP;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaSPCT;
    private javax.swing.JButton btnXoaThuocTinh;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JComboBox<String> cbbMauSacSPCT;
    private javax.swing.JComboBox<String> cbbNCCSPCT;
    private javax.swing.JComboBox<String> cbbTGSPCT;
    private javax.swing.JComboBox<String> cbbTheLoaiSPCT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel pnlSP;
    private javax.swing.JPanel pnlSPCT;
    private javax.swing.JTabbedPane pnlThuocTinh;
    private javax.swing.JRadioButton rb_MS;
    private javax.swing.JRadioButton rb_NCC;
    private javax.swing.JRadioButton rb_TG;
    private javax.swing.JRadioButton rb_TL;
    private javax.swing.JRadioButton rdbConHDThuocTinh;
    private javax.swing.JRadioButton rdbHet;
    private javax.swing.JRadioButton rdbKhHDThuocTinh;
    private javax.swing.JRadioButton rdnCon;
    private javax.swing.JTable tblMauSac;
    private javax.swing.JTable tblNCC;
    private javax.swing.JTable tblSPCT;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTable tblTacGia;
    private javax.swing.JTable tblTheLoai;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaMax;
    private javax.swing.JTextField txtGiaMin;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtMaSp;
    private javax.swing.JTextField txtMaSpct;
    private javax.swing.JTextField txtMaThuocTinh;
    private javax.swing.JTextField txtNamPH;
    private javax.swing.JTextField txtSoLuongTon;
    private javax.swing.JTextField txtTenSp;
    private javax.swing.JTextField txtTenThuocTinh;
    private javax.swing.JTextField txtTimKiemSP;
    // End of variables declaration//GEN-END:variables
}
