/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAnProject.repositoris;

import DuAnProject.DAO.HoaDonChiTietBean;
import DuAnProject.DAO.ThongKe;
import DuAnProject.DAO.ThongKeDao;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Admin
 */
public class QuanLyThongKe {
    private ThongKe thongKe = null;

    public QuanLyThongKe() {
        thongKe = new ThongKeDao();
    }
    public void setDateToChart1(JPanel jpnItem) {
    List<HoaDonChiTietBean> listItem = thongKe.getListByHoaDon();
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    
    if (listItem != null) {
        for (HoaDonChiTietBean item : listItem) {
            // Lấy giá trị ngày thanh toán
            String ngayThanhToan = item.getNgayThanhToan();
            // Kiểm tra xem ngày thanh toán có phải là null không
            if (ngayThanhToan != null) {
                dataset.addValue(item.getSoSanPham(), "Khách Hàng", ngayThanhToan);
            } else {
                // Nếu ngày thanh toán là null, bạn có thể ghi lại hoặc bỏ qua
//                System.err.println("Ngày thanh toán là null cho hóa đơn: " + item);
            }
        }
        
        JFreeChart chart = ChartFactory.createAreaChart(
            "Biểu đồ thống kê số lượng khách mua hàng".toUpperCase(),
            "Thời gian", 
            "Số lượng",
            dataset
        );
        
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 300));
        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }
}

    


}
