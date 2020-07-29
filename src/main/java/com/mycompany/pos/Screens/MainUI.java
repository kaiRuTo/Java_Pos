/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pos.Screens;

import com.mycompany.pos.Screens.Constants.DialogStatus.Status;
import com.mycompany.pos.Screens.Dialog.NCCTheoSanPhamDialog;
import com.mycompany.pos.Screens.Dialog.SanPhamTheoNCCDialog;
import com.mycompany.pos.Screens.Dialog.ThemDonHangDialog;
import com.mycompany.pos.Screens.Dialog.ThongTinDonHangDialog;
import com.mycompany.pos.Screens.Dialog.ThongTinKhachHangDialog;
import com.mycompany.pos.Screens.Dialog.ThongTinSanPhamDialog;
import com.mycompany.pos.Screens.Dialog.ThongTinThuongHieuDialog;
import com.mycompany.pos.Screens.Dialog.ThongTinCouponDialog;
import com.mycompany.pos.Screens.Dialog.TaoAccountDialog;
import com.mycompany.pos.SwingApplication;
import com.mycompany.pos.entity.Coupon;
import com.mycompany.pos.entity.Customer;
import com.mycompany.pos.entity.Orders;
import com.mycompany.pos.entity.Product;
import com.mycompany.pos.entity.ProductInvoice;
import com.mycompany.pos.entity.Stock;
import com.mycompany.pos.entity.Supplier;
import com.mycompany.pos.entity.User;
import com.mycompany.pos.service.CouponService;
import com.mycompany.pos.service.CustomerService;
import com.mycompany.pos.service.ProductInvoiceService;
import com.mycompany.pos.service.OrdersService;
import com.mycompany.pos.service.ProductService;
import com.mycompany.pos.service.StockService;
import com.mycompany.pos.service.SupplierService;
import com.mycompany.pos.service.UserService;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Paint;
import java.math.BigInteger;
import java.sql.ResultSetMetaData;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author luuhiep
 */
@Component
public class MainUI extends javax.swing.JFrame {
    private CustomerService _customerService;
    private ProductService _productService;
    private OrdersService _ordersService;
    private ProductInvoiceService _productInvoiceService;
    private SupplierService _supplierService;
    private CouponService _couponService;
    private UserService _accountService;
    private StockService _stockService;
    
    private List<Customer> _listCustomer;
    private List<Product> _listProduct;
    private List<ProductInvoice> _listProductInvoice;
    private List<Orders> _listOrder;
    private List<Supplier> _listSupplier;
    private List<Coupon> _listCoupon;
    private List<User>  _listUser;
    private List<Stock>  _listStock;
    
    private ThongTinCouponDialog _thongTinCouponDialog;
    private ThongTinKhachHangDialog _thongTinKhachHangDialog;
    private ThongTinSanPhamDialog _thongTinSanPhamDialog;                    
    private ThongTinThuongHieuDialog _thongTinThuongHieuDialog;               
    private ThemDonHangDialog _themDonHangDialog;           
    private ThongTinDonHangDialog _thongTinDonHangDialog;
    private NCCTheoSanPhamDialog _nccTheoSanPhamDialog;
    private SanPhamTheoNCCDialog _sanPhamTheoNCCDialog;
    private TaoAccountDialog _taoAccountDialog;

    /**
     * Creates new form NewJFrame
     */
    public MainUI() {
        initComponents();
      

    }
    
    @Autowired
    public MainUI(  ThongTinDonHangDialog       thongTinDonHangDialog,
                    ThongTinKhachHangDialog     thongTinKhachHangDialog, 
                    ThongTinSanPhamDialog       thongTinSanPhamDialog,
                    ThongTinThuongHieuDialog    thongTinThuongHieuDialog,
                    ThemDonHangDialog           themDonHangDialog,
                    NCCTheoSanPhamDialog        nccTheoSanPhamDialog,
                    SanPhamTheoNCCDialog        sanPhamTheoNCCDialog,
                    ThongTinCouponDialog        thongTinCouponDialog,
                    TaoAccountDialog            taoAccountDialog,
                    CustomerService             customerService,
                    ProductService              productService,
                    OrdersService               ordersService,
                    ProductInvoiceService       productInvoiceService,
                    SupplierService             supplierService,
                    CouponService               couponService,
                    UserService                 userService,
                    StockService                stockService
    ) {
        initComponents();
        this._customerService = customerService;
        this._productService = productService;
        this._ordersService = ordersService;
        this._productInvoiceService = productInvoiceService;
        this._supplierService = supplierService;
        this._couponService = couponService;
        this._accountService = userService;
        this._stockService = stockService;
        
        this._thongTinDonHangDialog = thongTinDonHangDialog;
        this._thongTinKhachHangDialog = thongTinKhachHangDialog;
        this._thongTinSanPhamDialog = thongTinSanPhamDialog;
        this._thongTinThuongHieuDialog = thongTinThuongHieuDialog;
        this._themDonHangDialog = themDonHangDialog;
        this._nccTheoSanPhamDialog = nccTheoSanPhamDialog;
        this._sanPhamTheoNCCDialog = sanPhamTheoNCCDialog;
        this._thongTinCouponDialog = thongTinCouponDialog;
        this._taoAccountDialog = taoAccountDialog;
        
        setListener();
        
        loadDataThongKe();
        
        loadTable();
        jSpinField11.setVisible(false);
        jSpinField14.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableOrder = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        btnChinhSuaDonHang = new javax.swing.JButton();
        btnThemDonHang = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnThemSanPham = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btnXoaSanPham = new javax.swing.JButton();
        btnChinhSuaSanPham = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableProduct = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        btnThemThuongHieu = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btnXoaThuongHieu = new javax.swing.JButton();
        btnChinhSuaThuongHieu = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableSupplier = new javax.swing.JTable();
        btnThemThuongHieu1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        btnThemKhuyenMai = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        btnXoaKhuyenMai = new javax.swing.JButton();
        btnChinhSuaKhuyenMai = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableCoupon = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        btnThemKhachHang = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btnXoaKhachHang = new javax.swing.JButton();
        btnChinhSuaKhachHang = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableKhachHang = new javax.swing.JTable();
        btnThemKhachHang1 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        btnThemAccount = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        btnXoaAccount = new javax.swing.JButton();
        btnChinhSuaAccount = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableUser = new javax.swing.JTable();
        btnReloadAccount = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jSpinField1 = new com.toedter.components.JSpinField();
        jSpinField2 = new com.toedter.components.JSpinField();
        jSpinField3 = new com.toedter.components.JSpinField();
        btnReloadAccount2 = new javax.swing.JButton();
        jSpinField5 = new com.toedter.components.JSpinField();
        jSpinField6 = new com.toedter.components.JSpinField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jSpinField11 = new com.toedter.components.JSpinField();
        jSpinField12 = new com.toedter.components.JSpinField();
        jSpinField13 = new com.toedter.components.JSpinField();
        btnReloadAccount5 = new javax.swing.JButton();
        jSpinField14 = new com.toedter.components.JSpinField();
        jSpinField15 = new com.toedter.components.JSpinField();
        jSpinField16 = new com.toedter.components.JSpinField();
        jLabel17 = new javax.swing.JLabel();
        btnReloadAccount6 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTongDonHang = new javax.swing.JLabel();
        txtTongDoanhThu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1200, 800));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tableOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên khách hàng", "SDT", "Ngày", "Tông giá trị đơn hàng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableOrder);

        jLabel8.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel8.setText("Đơn hàng ");

        btnChinhSuaDonHang.setText("Thông Tin");
        btnChinhSuaDonHang.setMaximumSize(new java.awt.Dimension(70, 20));
        btnChinhSuaDonHang.setMinimumSize(new java.awt.Dimension(70, 20));
        btnChinhSuaDonHang.setPreferredSize(new java.awt.Dimension(70, 20));
        btnChinhSuaDonHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChinhSuaDonHangActionPerformed(evt);
            }
        });

        btnThemDonHang.setText("Thêm");
        btnThemDonHang.setMaximumSize(new java.awt.Dimension(70, 20));
        btnThemDonHang.setMinimumSize(new java.awt.Dimension(70, 20));
        btnThemDonHang.setPreferredSize(new java.awt.Dimension(70, 20));
        btnThemDonHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDonHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 917, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThemDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnChinhSuaDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(btnChinhSuaDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Đơn hàng", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        btnThemSanPham.setText("Thêm");
        btnThemSanPham.setMaximumSize(new java.awt.Dimension(70, 20));
        btnThemSanPham.setMinimumSize(new java.awt.Dimension(70, 20));
        btnThemSanPham.setPreferredSize(new java.awt.Dimension(70, 20));
        btnThemSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSanPhamActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel9.setText("Sản phẩm");

        btnXoaSanPham.setText("Xoá");
        btnXoaSanPham.setMaximumSize(new java.awt.Dimension(70, 20));
        btnXoaSanPham.setMinimumSize(new java.awt.Dimension(70, 20));
        btnXoaSanPham.setPreferredSize(new java.awt.Dimension(70, 20));
        btnXoaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSanPhamActionPerformed(evt);
            }
        });

        btnChinhSuaSanPham.setText("Chỉnh sửa");
        btnChinhSuaSanPham.setMaximumSize(new java.awt.Dimension(70, 20));
        btnChinhSuaSanPham.setMinimumSize(new java.awt.Dimension(70, 20));
        btnChinhSuaSanPham.setPreferredSize(new java.awt.Dimension(70, 20));
        btnChinhSuaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChinhSuaSanPhamActionPerformed(evt);
            }
        });

        tableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Sản phẩm", "Nhà cung cấp", "Giá tiền", "VAT", "Số lượng", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableProduct);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 917, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnChinhSuaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(btnChinhSuaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sản phẩm", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        btnThemThuongHieu.setText("Thêm");
        btnThemThuongHieu.setMaximumSize(new java.awt.Dimension(70, 20));
        btnThemThuongHieu.setMinimumSize(new java.awt.Dimension(70, 20));
        btnThemThuongHieu.setPreferredSize(new java.awt.Dimension(70, 20));
        btnThemThuongHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemThuongHieuActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel10.setText("Nhà cung cấp");

        btnXoaThuongHieu.setText("Xoá");
        btnXoaThuongHieu.setMaximumSize(new java.awt.Dimension(70, 20));
        btnXoaThuongHieu.setMinimumSize(new java.awt.Dimension(70, 20));
        btnXoaThuongHieu.setPreferredSize(new java.awt.Dimension(70, 20));
        btnXoaThuongHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaThuongHieuActionPerformed(evt);
            }
        });

        btnChinhSuaThuongHieu.setText("Chỉnh sửa");
        btnChinhSuaThuongHieu.setMaximumSize(new java.awt.Dimension(70, 20));
        btnChinhSuaThuongHieu.setMinimumSize(new java.awt.Dimension(70, 20));
        btnChinhSuaThuongHieu.setPreferredSize(new java.awt.Dimension(70, 20));
        btnChinhSuaThuongHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChinhSuaThuongHieuActionPerformed(evt);
            }
        });

        tableSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Tên nhà cung cấp", "SDT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tableSupplier);
        if (tableSupplier.getColumnModel().getColumnCount() > 0) {
            tableSupplier.getColumnModel().getColumn(0).setResizable(false);
            tableSupplier.getColumnModel().getColumn(0).setPreferredWidth(30);
        }

        btnThemThuongHieu1.setText("Nhập hàng");
        btnThemThuongHieu1.setMaximumSize(new java.awt.Dimension(70, 20));
        btnThemThuongHieu1.setMinimumSize(new java.awt.Dimension(70, 20));
        btnThemThuongHieu1.setPreferredSize(new java.awt.Dimension(70, 20));
        btnThemThuongHieu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemThuongHieu1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 917, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThemThuongHieu1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThemThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnChinhSuaThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(btnChinhSuaThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemThuongHieu1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Nhà cung cấp", jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        btnThemKhuyenMai.setText("Thêm");
        btnThemKhuyenMai.setMaximumSize(new java.awt.Dimension(70, 20));
        btnThemKhuyenMai.setMinimumSize(new java.awt.Dimension(70, 20));
        btnThemKhuyenMai.setPreferredSize(new java.awt.Dimension(70, 20));
        btnThemKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKhuyenMaiActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel11.setText("Khuyến mãi");

        btnXoaKhuyenMai.setText("Xoá");
        btnXoaKhuyenMai.setMaximumSize(new java.awt.Dimension(70, 20));
        btnXoaKhuyenMai.setMinimumSize(new java.awt.Dimension(70, 20));
        btnXoaKhuyenMai.setPreferredSize(new java.awt.Dimension(70, 20));
        btnXoaKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaKhuyenMaiActionPerformed(evt);
            }
        });

        btnChinhSuaKhuyenMai.setText("Chỉnh sửa");
        btnChinhSuaKhuyenMai.setMaximumSize(new java.awt.Dimension(70, 20));
        btnChinhSuaKhuyenMai.setMinimumSize(new java.awt.Dimension(70, 20));
        btnChinhSuaKhuyenMai.setPreferredSize(new java.awt.Dimension(70, 20));
        btnChinhSuaKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChinhSuaKhuyenMaiActionPerformed(evt);
            }
        });

        tableCoupon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Code", "Phần trâm giảm giá", "Ngày tạo", "Ngày hết hạn", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tableCoupon);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 917, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThemKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnChinhSuaKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(btnChinhSuaKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Khuyến mãi", jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        btnThemKhachHang.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        btnThemKhachHang.setText("Thêm");
        btnThemKhachHang.setMaximumSize(new java.awt.Dimension(70, 20));
        btnThemKhachHang.setMinimumSize(new java.awt.Dimension(70, 20));
        btnThemKhachHang.setPreferredSize(new java.awt.Dimension(70, 20));
        btnThemKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKhachHangActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel12.setText("Khách hàng");

        btnXoaKhachHang.setText("Xoá");
        btnXoaKhachHang.setMaximumSize(new java.awt.Dimension(70, 20));
        btnXoaKhachHang.setMinimumSize(new java.awt.Dimension(70, 20));
        btnXoaKhachHang.setPreferredSize(new java.awt.Dimension(70, 20));
        btnXoaKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaKhachHangActionPerformed(evt);
            }
        });

        btnChinhSuaKhachHang.setText("Chỉnh sửa");
        btnChinhSuaKhachHang.setMaximumSize(new java.awt.Dimension(70, 20));
        btnChinhSuaKhachHang.setMinimumSize(new java.awt.Dimension(70, 20));
        btnChinhSuaKhachHang.setPreferredSize(new java.awt.Dimension(70, 20));
        btnChinhSuaKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChinhSuaKhachHangActionPerformed(evt);
            }
        });

        tableKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên", "Họ", "Ngày Sinh", "SDT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tableKhachHang);
        if (tableKhachHang.getColumnModel().getColumnCount() > 0) {
            tableKhachHang.getColumnModel().getColumn(2).setHeaderValue("Họ");
            tableKhachHang.getColumnModel().getColumn(3).setHeaderValue("Ngày Sinh");
            tableKhachHang.getColumnModel().getColumn(4).setHeaderValue("SDT");
        }

        btnThemKhachHang1.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        btnThemKhachHang1.setText("Tải lại");
        btnThemKhachHang1.setMaximumSize(new java.awt.Dimension(70, 20));
        btnThemKhachHang1.setMinimumSize(new java.awt.Dimension(70, 20));
        btnThemKhachHang1.setPreferredSize(new java.awt.Dimension(70, 20));
        btnThemKhachHang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKhachHang1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 917, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThemKhachHang1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThemKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnChinhSuaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(btnChinhSuaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemKhachHang1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Khách hàng", jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        btnThemAccount.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        btnThemAccount.setText("Thêm");
        btnThemAccount.setMaximumSize(new java.awt.Dimension(70, 20));
        btnThemAccount.setMinimumSize(new java.awt.Dimension(70, 20));
        btnThemAccount.setPreferredSize(new java.awt.Dimension(70, 20));
        btnThemAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemAccountActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel13.setText("Tài khoản");

        btnXoaAccount.setText("Xoá");
        btnXoaAccount.setMaximumSize(new java.awt.Dimension(70, 20));
        btnXoaAccount.setMinimumSize(new java.awt.Dimension(70, 20));
        btnXoaAccount.setPreferredSize(new java.awt.Dimension(70, 20));
        btnXoaAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaAccountActionPerformed(evt);
            }
        });

        btnChinhSuaAccount.setText("Chỉnh sửa");
        btnChinhSuaAccount.setMaximumSize(new java.awt.Dimension(70, 20));
        btnChinhSuaAccount.setMinimumSize(new java.awt.Dimension(70, 20));
        btnChinhSuaAccount.setPreferredSize(new java.awt.Dimension(70, 20));
        btnChinhSuaAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChinhSuaAccountActionPerformed(evt);
            }
        });

        tableUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "STT", "Username"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tableUser);

        btnReloadAccount.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        btnReloadAccount.setText("Tải lại");
        btnReloadAccount.setMaximumSize(new java.awt.Dimension(70, 20));
        btnReloadAccount.setMinimumSize(new java.awt.Dimension(70, 20));
        btnReloadAccount.setPreferredSize(new java.awt.Dimension(70, 20));
        btnReloadAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadAccountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 917, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReloadAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThemAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnChinhSuaAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(btnChinhSuaAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReloadAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Tài khoản", jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel14.setText("Thống kê");

        jLabel5.setText("Doanh thu theo");

        jLabel6.setText("Thống kê sản phảm bán được trong ngày");

        jLabel15.setText("Xem so sánh Doanh thu theo");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngày", "Tháng", "Năm" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngày", "Tháng", "Năm" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jSpinField2.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jSpinField2CaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jSpinField2InputMethodTextChanged(evt);
            }
        });

        btnReloadAccount2.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        btnReloadAccount2.setText("Xem");
        btnReloadAccount2.setMaximumSize(new java.awt.Dimension(70, 20));
        btnReloadAccount2.setMinimumSize(new java.awt.Dimension(70, 20));
        btnReloadAccount2.setPreferredSize(new java.awt.Dimension(70, 20));
        btnReloadAccount2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadAccount2ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngày", "Tháng", "Năm" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        btnReloadAccount5.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        btnReloadAccount5.setText("Xem");
        btnReloadAccount5.setMaximumSize(new java.awt.Dimension(70, 20));
        btnReloadAccount5.setMinimumSize(new java.awt.Dimension(70, 20));
        btnReloadAccount5.setPreferredSize(new java.awt.Dimension(70, 20));
        btnReloadAccount5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadAccount5ActionPerformed(evt);
            }
        });

        jLabel17.setText("So với");

        btnReloadAccount6.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        btnReloadAccount6.setText("Xem");
        btnReloadAccount6.setMaximumSize(new java.awt.Dimension(70, 20));
        btnReloadAccount6.setMinimumSize(new java.awt.Dimension(70, 20));
        btnReloadAccount6.setPreferredSize(new java.awt.Dimension(70, 20));
        btnReloadAccount6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadAccount6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jSpinField11, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jSpinField12, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jSpinField13, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jSpinField14, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jSpinField15, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jSpinField16, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnReloadAccount5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jSpinField1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(jSpinField2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)))
                                .addComponent(jSpinField3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 262, Short.MAX_VALUE)
                                .addComponent(jSpinField5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addComponent(jSpinField6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnReloadAccount2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReloadAccount6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addGap(34, 34, 34)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnReloadAccount2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSpinField2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinField3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSpinField5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addComponent(jSpinField6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnReloadAccount6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addComponent(jLabel17))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSpinField11, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(jSpinField12, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(jSpinField13, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinField14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinField15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinField16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReloadAccount5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(367, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thống kê", jPanel10);

        jPanel1.setBackground(new java.awt.Color(55, 126, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(250, 800));

        jLabel1.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Doanh thu hôm nay");

        jLabel2.setFont(new java.awt.Font("Open Sans", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("OVERVIEW");

        jLabel4.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Đơn hàng hôm nay");

        txtTongDonHang.setFont(new java.awt.Font("Open Sans", 1, 28)); // NOI18N
        txtTongDonHang.setForeground(new java.awt.Color(255, 255, 255));
        txtTongDonHang.setText("200");

        txtTongDoanhThu.setFont(new java.awt.Font("Open Sans", 1, 28)); // NOI18N
        txtTongDoanhThu.setForeground(new java.awt.Color(255, 255, 255));
        txtTongDoanhThu.setText("200");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTongDoanhThu)
                    .addComponent(txtTongDonHang)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jLabel2)
                .addGap(42, 42, 42)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTongDonHang)
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTongDoanhThu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jTabbedPane1)
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jTabbedPane1))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemKhachHang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKhachHang1ActionPerformed
        // TODO add your handling code here:
        loadTableCustomer();
    }//GEN-LAST:event_btnThemKhachHang1ActionPerformed

    private void btnChinhSuaKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChinhSuaKhachHangActionPerformed
        // TODO add your handling code here:
        int selectedIndex = tableKhachHang.getSelectedRow();

        _thongTinKhachHangDialog.setStatus(Status.UPDATE);
        _thongTinKhachHangDialog.setCustomer(_listCustomer.get(selectedIndex));
        _thongTinKhachHangDialog.setVisible(true);
    }//GEN-LAST:event_btnChinhSuaKhachHangActionPerformed

    private void btnThemKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKhachHangActionPerformed
        // TODO add your handling code here:
        _thongTinKhachHangDialog.setStatus(Status.ADD);
        _thongTinKhachHangDialog.setVisible(true);
    }//GEN-LAST:event_btnThemKhachHangActionPerformed

    private void btnChinhSuaThuongHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChinhSuaThuongHieuActionPerformed
        // TODO add your handling code here:
        
        int selectedIndex = tableSupplier.getSelectedRow();
        _thongTinThuongHieuDialog.setStatus(Status.UPDATE);
        _thongTinThuongHieuDialog.setSupplier(_listSupplier.get(selectedIndex));
        _thongTinThuongHieuDialog.setVisible(true);
    }//GEN-LAST:event_btnChinhSuaThuongHieuActionPerformed

    private void btnThemThuongHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemThuongHieuActionPerformed
        // TODO add your handling code here:
        _thongTinThuongHieuDialog.setStatus(Status.ADD);
        _thongTinThuongHieuDialog.setVisible(true);
    }//GEN-LAST:event_btnThemThuongHieuActionPerformed

    private void btnChinhSuaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChinhSuaSanPhamActionPerformed
        // TODO add your handling code here:
        int selectedIndex = tableProduct.getSelectedRow();
        _thongTinSanPhamDialog.setStatus(Status.UPDATE);
        _thongTinSanPhamDialog.setProduct(_listProduct.get(selectedIndex));
        _thongTinSanPhamDialog.setVisible(true);
    }//GEN-LAST:event_btnChinhSuaSanPhamActionPerformed

    private void btnXoaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSanPhamActionPerformed
        // TODO add your handling code here:
        int dialogResult;
        dialogResult = JOptionPane.showConfirmDialog(
                null, 
                "Bạn có chắc là muốn xoá sản phẩm này?", 
                "Warning", 
                JOptionPane.YES_NO_OPTION);
        
        if (dialogResult == JOptionPane.YES_OPTION){
            _productService.delete(_listProduct.get(tableProduct.getSelectedRow()));
            loadTableProduct();
        }
    }//GEN-LAST:event_btnXoaSanPhamActionPerformed

    private void btnThemSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSanPhamActionPerformed
        // TODO add your handling code here:
        _thongTinSanPhamDialog.setStatus(Status.ADD);
        _thongTinSanPhamDialog.setVisible(true);
    }//GEN-LAST:event_btnThemSanPhamActionPerformed

    private void btnThemDonHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDonHangActionPerformed
        // TODO add your handling code here:
        _themDonHangDialog.loadList();
        _themDonHangDialog.setVisible(true);
        
    }//GEN-LAST:event_btnThemDonHangActionPerformed

    private void btnThemThuongHieu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemThuongHieu1ActionPerformed
        // TODO add your handling code here:
        int index = tableSupplier.getSelectedRow();
        if (index <0 && index >= _listSupplier.size()) 
        {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn nhà cung cấp");
            return;
        }
        
        _sanPhamTheoNCCDialog.setSupplier(_listSupplier.get(index));
        _sanPhamTheoNCCDialog.setVisible(true);
    }//GEN-LAST:event_btnThemThuongHieu1ActionPerformed

    private void btnChinhSuaDonHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChinhSuaDonHangActionPerformed
        // TODO add your handling code here:
        int index = tableOrder.getSelectedRow();
        _thongTinDonHangDialog.setOrderWithCustomer(_listOrder.get(index), _listOrder.get(index).getCustomer());
        _thongTinDonHangDialog.setVisible(true);
    }//GEN-LAST:event_btnChinhSuaDonHangActionPerformed

    private void btnThemKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKhuyenMaiActionPerformed
        // TODO add your handling code here:
        _thongTinCouponDialog.setRandom();
        _thongTinCouponDialog.setStatus(Status.ADD);
        _thongTinCouponDialog.setVisible(true);
    }//GEN-LAST:event_btnThemKhuyenMaiActionPerformed

    private void btnChinhSuaKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChinhSuaKhuyenMaiActionPerformed
        // TODO add your handling code here:
        
        int selectedIndex = tableCoupon.getSelectedRow();
        _thongTinCouponDialog.setStatus(Status.UPDATE);
        _thongTinCouponDialog.setCoupon(_listCoupon.get(selectedIndex));
        _thongTinCouponDialog.setVisible(true);
    }//GEN-LAST:event_btnChinhSuaKhuyenMaiActionPerformed

    private void btnThemAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemAccountActionPerformed
        // TODO add your handling code here:
        this._taoAccountDialog.setStatus(Status.ADD);
        this._taoAccountDialog.setVisible(true);
    }//GEN-LAST:event_btnThemAccountActionPerformed

    private void btnChinhSuaAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChinhSuaAccountActionPerformed
        // TODO add your handling code here:
        
        int selectedIndex = tableUser.getSelectedRow();
        _taoAccountDialog.setStatus(Status.UPDATE);
        _taoAccountDialog.setUser(_listUser.get(selectedIndex));
        this._taoAccountDialog.setVisible(true);
    }//GEN-LAST:event_btnChinhSuaAccountActionPerformed

    private void btnReloadAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadAccountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReloadAccountActionPerformed

    private void btnXoaThuongHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaThuongHieuActionPerformed
        // TODO add your handling code here:
        try {
            int dialogResult;
            dialogResult = JOptionPane.showConfirmDialog(
                    null, 
                    "Bạn có chắc là muốn xoá nhà cung cấp này?", 
                    "Warning", 
                    JOptionPane.YES_NO_OPTION);

            if (dialogResult == JOptionPane.YES_OPTION){
                _supplierService.delete(_listSupplier.get(tableSupplier.getSelectedRow()));
                loadTableBrand();
                
            }
        } catch (NullPointerException ex){
            
            JOptionPane.showMessageDialog(null, "Có gì đó không ổn");
        }
    }//GEN-LAST:event_btnXoaThuongHieuActionPerformed

    private void btnXoaKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaKhuyenMaiActionPerformed
        // TODO add your handling code here:
        try {
            int dialogResult;
            dialogResult = JOptionPane.showConfirmDialog(
                    null, 
                    "Bạn có chắc là muốn xoá khuyến mãi này?", 
                    "Warning", 
                    JOptionPane.YES_NO_OPTION);

            if (dialogResult == JOptionPane.YES_OPTION){
                _couponService.delete(_listCoupon.get(tableCoupon.getSelectedRow()));
                loadTableCoupon();
            }
        } catch (NullPointerException ex){
            
            JOptionPane.showMessageDialog(null, "Có gì đó không ổn");
        }
    }//GEN-LAST:event_btnXoaKhuyenMaiActionPerformed

    private void btnXoaKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaKhachHangActionPerformed
        // TODO add your handling code here:
        try {
            int dialogResult;
            dialogResult = JOptionPane.showConfirmDialog(
                    null, 
                    "Bạn có chắc là muốn xoá Khách hàng này?", 
                    "Warning", 
                    JOptionPane.YES_NO_OPTION);

            if (dialogResult == JOptionPane.YES_OPTION){
                _customerService.delete(_listCustomer.get(tableKhachHang.getSelectedRow()));
                loadTableCustomer();
            }
        } catch (NullPointerException ex){
            
            JOptionPane.showMessageDialog(null, "Có gì đó không ổn");
        }
    }//GEN-LAST:event_btnXoaKhachHangActionPerformed

    private void btnXoaAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaAccountActionPerformed
        // TODO add your handling code here:
        try {
            int dialogResult;
            dialogResult = JOptionPane.showConfirmDialog(
                    null, 
                    "Bạn có chắc là muốn xoá tài khoản này?", 
                    "Warning", 
                    JOptionPane.YES_NO_OPTION);

            if (dialogResult == JOptionPane.YES_OPTION){
                _accountService.delete(_listUser.get(tableUser.getSelectedRow()));
                loadTableUser();
            }
        } catch (NullPointerException ex){
            
            JOptionPane.showMessageDialog(null, "Có gì đó không ổn");
        }
    }//GEN-LAST:event_btnXoaAccountActionPerformed

    private void btnReloadAccount6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadAccount6ActionPerformed
        // TODO add your handling code here:
        LocalDateTime dateNow = LocalDateTime.now();
        
        
        int selectedIndex = jComboBox1.getSelectedIndex();
        
        int month = jSpinField5.getValue()-1;
        int year = jSpinField6.getValue()-1900;
        
        String name = "";
        
        ArrayList<Soluong> listSoluong = getDT(selectedIndex,month, year);
        
        switch (selectedIndex){
            case 0:
                name = String.format("Doanh thu trong tháng %d-%d", month+1, year+1900);
                break;
            case 1:
                name = String.format("Doanh thu trong năm %d", year+1900);
                break;
            case 2:
                name = String.format("Doanh thu theo năm %d", year+1900);
                break;
            default:
                break;
        }
        
        
        var series = new XYSeries(name);
        for (int i = 0; i<listSoluong.size(); i ++){
            long value = listSoluong.get(i).value.divide(BigInteger.valueOf(1000000)).longValueExact();
            series.add(listSoluong.get(i).key, value);
        }
        
        
        var dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        
        
        JFreeChart chart = createChart(dataset);
        chart.getPlot().setBackgroundPaint(Color.WHITE);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        
        ChartFrame charFrame = new ChartFrame("Doanh Thu",chart);
        charFrame.setVisible(true);
        charFrame.pack();
        
    }//GEN-LAST:event_btnReloadAccount6ActionPerformed

    private void btnReloadAccount5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadAccount5ActionPerformed
        // TODO add your handling code here:
        LocalDateTime dateNow = LocalDateTime.now();
        
        
        int selectedIndex = jComboBox2.getSelectedIndex();
        
        int month1 = jSpinField12.getValue()-1;
        int year1 = jSpinField13.getValue()-1900;
        
        String name1 = "";
        String name2 = "";
        
        ArrayList<Soluong> listSoluong1 = getDT(selectedIndex,month1, year1);
        
        
        
        int month2 = jSpinField15.getValue()-1;
        int year2 = jSpinField16.getValue()-1900;
        
        ArrayList<Soluong> listSoluong2 = getDT(selectedIndex,month2, year2);
        
        
        switch (selectedIndex){
            case 0:
                name1 = String.format("Doanh thu trong tháng %d-%d", month1+1, year1+1900);
                name2 = String.format("Doanh thu trong tháng %d-%d ", month2+1, year2+1900);
                break;
            case 1:
                name1 = String.format("Doanh thu trong năm %d", year1+1900);
                name2 = String.format("Doanh thu trong năm %d ", year2+1900);
                break;
            case 2:
                name1 = String.format("Doanh thu theo năm %d", year1+1900);
                name2 = String.format("Doanh thu theo năm %d ", year2+1900);
                break;
            default:
                break;
        }
        
        var series1 = new XYSeries(name1);
        for (int i = 0; i<listSoluong1.size(); i ++){
            series1.add(listSoluong1.get(i).key, listSoluong1.get(i).value.divide(BigInteger.valueOf(1000000)));
        }
        
        var series2 = new XYSeries(name2);
        for (int i = 0; i<listSoluong2.size(); i ++){
            series2.add(listSoluong2.get(i).key, listSoluong2.get(i).value.divide(BigInteger.valueOf(1000000)));
        }
        
        
        
        var dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        
        
        
        JFreeChart chart = createChart(dataset);
        chart.getPlot().setBackgroundPaint(Color.WHITE);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        
        ChartFrame charFrame = new ChartFrame("Doanh Thu",chart);
        charFrame.setVisible(true);
        charFrame.pack();
        
    }//GEN-LAST:event_btnReloadAccount5ActionPerformed

    
    private static double getHighestArrayValue(ArrayList<Long> array) {
        double max = 0;
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) > max) {
                max = array.get(i);
            }
        }
        return max;
    }

    
    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        int selectedIndex = jComboBox2.getSelectedIndex();
        switch (selectedIndex){
            case 0:
                jSpinField11.setVisible(false);
                jSpinField12.setVisible(true);
                jSpinField13.setVisible(true);
                
                jSpinField14.setVisible(false);
                jSpinField15.setVisible(true);
                jSpinField16.setVisible(true);
                break;
            case 1:
                
                jSpinField11.setVisible(false);
                jSpinField12.setVisible(false);
                jSpinField13.setVisible(true);
                
                jSpinField14.setVisible(false);
                jSpinField15.setVisible(false);
                jSpinField16.setVisible(true);
                break;
            case 2:
                jSpinField11.setVisible(false);
                jSpinField12.setVisible(false);
                jSpinField13.setVisible(true);
                
                jSpinField14.setVisible(false);
                jSpinField15.setVisible(false);
                jSpinField16.setVisible(true);
                
                break;
            default:
                return ;
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
         int selectedIndex = jComboBox1.getSelectedIndex();
        switch (selectedIndex){
            case 0:
                jSpinField5.setVisible(true);
                jSpinField6.setVisible(true);
                
                break;
            case 1:
                jSpinField5.setVisible(false);
                jSpinField6.setVisible(true);
                break;
            case 2:
                jSpinField5.setVisible(false);
                jSpinField6.setVisible(false);
                
                break;
            default:
                return ;
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
        int selectedIndex = jComboBox3.getSelectedIndex();
        switch (selectedIndex){
            case 0:
                jSpinField1.setVisible(true);
                jSpinField2.setVisible(true);
                jSpinField3.setVisible(true);
                
                break;
            case 1:
                jSpinField1.setVisible(false);
                jSpinField2.setVisible(true);
                jSpinField3.setVisible(true);
                break;
            case 2:
                jSpinField1.setVisible(false);
                jSpinField2.setVisible(false);
                jSpinField3.setVisible(true);
                
                break;
            default:
                return ;
        }
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void btnReloadAccount2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadAccount2ActionPerformed
        // TODO add your handling code here:
        ArrayList<Long> listSL;
        listSL = new ArrayList<>();
        ArrayList<BigInteger> listDoanhThu;
        listDoanhThu = new ArrayList<>();
        int selectedIndex = jComboBox3.getSelectedIndex();

        for(Product p: _listProduct) {
            long soluong = 0;
            BigInteger doanhThu = BigInteger.valueOf(0);
            for (ProductInvoice pi: _listProductInvoice){
                if (pi.getProduct().getIdProduct() == p.getIdProduct()){

                    int date = jSpinField1.getValue();
                    int month = jSpinField2.getValue()-1;
                    int year = jSpinField3.getValue()-1900;

                    Date orderDate = pi.getOrders().getOrderedAt();

                    switch (selectedIndex){
                        case 0:
                        if (orderDate.getDate() == date && orderDate.getMonth() == month && orderDate.getYear() == year){
                            soluong = soluong + pi.getQuantity();

                            long soluongSP = pi.getQuantity().longValue();
                            double VAT = ( 1.0 + pi.getVat().longValue()/100.0);
                            double  dongia = pi.getPrice().longValue() * VAT;
                            long giasanpham = soluongSP *  (long)dongia;

                            doanhThu = doanhThu.add(BigInteger.valueOf(giasanpham));

                        }
                        break;
                        case 1:
                        if (orderDate.getMonth() == month && orderDate.getYear() == year){
                            soluong = soluong + pi.getQuantity();

                            long soluongSP = pi.getQuantity().longValue();
                            double VAT = ( 1.0 + pi.getVat().longValue()/100.0);
                            double  dongia = pi.getPrice().longValue() * VAT;
                            long giasanpham = soluongSP *  (long)dongia;

                            doanhThu = doanhThu.add(BigInteger.valueOf(giasanpham));

                        }
                        break;
                        case 2:
                        if (orderDate.getYear() == year){
                            soluong = soluong + pi.getQuantity();

                            long soluongSP = pi.getQuantity().longValue();
                            double VAT = ( 1.0 + pi.getVat().longValue()/100.0);
                            double  dongia = pi.getPrice().longValue() * VAT;
                            long giasanpham = soluongSP *  (long)dongia;

                            doanhThu = doanhThu.add(BigInteger.valueOf(giasanpham));

                        }
                        break;
                        default:
                        return ;
                    }
                }
            }
            listSL.add(soluong);
            doanhThu = doanhThu.divide(BigInteger.valueOf(1000000));
            listDoanhThu.add(doanhThu);
        }

        CategoryDataset dataset = createDatasetAnalyzeProduct(_listProduct, listDoanhThu);

        JFreeChart chart=ChartFactory.createBarChart(
            "Doanh thu sản phẩm", //Chart Title
            "", // Category axis
            "1.000.000 VND", // Value axis
            dataset,
            PlotOrientation.VERTICAL,
            true,true,false
        );
        chart.getPlot().setBackgroundPaint(Color.WHITE);

        //          final CategoryPlot plot = chart.getCategoryPlot();
        //        ((BarRenderer) plot.getRenderer())
        //                .setBarPainter(new StandardBarPainter());
        //
        //        plot.setBackgroundPaint(Color.WHITE);
        //
        //        plot.setDomainGridlinesVisible(true);
        //        plot.setRangeGridlinesVisible(true);
        //
        //        plot.setDomainGridlineStroke(new BasicStroke(0.25f));
        //        plot.setRangeGridlineStroke(new BasicStroke(0.25f));
        //
        //        plot.setDomainGridlinePaint(new Color(204, 204, 204));
        //        plot.setRangeGridlinePaint(new Color(204, 204, 204));
        //
        //        CategoryItemRenderer renderer = new CustomRenderer();
        //        plot.setRenderer(renderer);
        //
        //        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        //        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        //        rangeAxis.setRange(0,getRoundedUpMultipleOfTen(getHighestArrayValue(listSL)));
        //        rangeAxis.setTickUnit(new NumberTickUnit(10));
        //
        //        final BarRenderer renderer1 = (BarRenderer) plot.getRenderer();
        //        renderer1.setDrawBarOutline(true);
        //        renderer1.setShadowVisible(false);
        //
        //        renderer1.setSeriesOutlinePaint(0, new Color(204, 121, 167));
        //        renderer1.setSeriesOutlinePaint(1, new Color(213, 94, 0));
        //        renderer1.setSeriesOutlineStroke(0, new BasicStroke(2.5f));

        //        renderer1.setBaseOutlineStroke(new BasicStroke(10f), true);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);

        PieDataset datasetPie = createDatasetAnalyzeProductPie(_listProduct, listSL);

        JFreeChart chartPie = ChartFactory.createPieChart(
            "Số lượng sản phẩm",
            datasetPie,
            true,
            true,
            false);

        chartPie.getPlot().setBackgroundPaint(Color.WHITE);

        //Format Label
        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
            "{0} : ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
        ((PiePlot) chartPie.getPlot()).setLabelGenerator(labelGenerator);

        ChartPanel piePanel = new ChartPanel(chartPie);
        piePanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        piePanel.setBackground(Color.white);

        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(0,2));
        frame.add(chartPanel);
        frame.add(piePanel);

        frame.pack();
        frame.setVisible(true);

        //        ChartFrame charFrame = new ChartFrame("sdas",chart);
        //        charFrame.setVisible(true);
        //        charFrame.pack();
    }//GEN-LAST:event_btnReloadAccount2ActionPerformed

    private void tableProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductMouseClicked
        // TODO add your handling code here:
        
        int selectedIndex = tableProduct.getSelectedRow();
        _nccTheoSanPhamDialog.setProduct(_listProduct.get(selectedIndex));
        _nccTheoSanPhamDialog.setVisible(true);
    }//GEN-LAST:event_tableProductMouseClicked

    private void jSpinField2InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jSpinField2InputMethodTextChanged
        // TODO add your handling code here:
        int maxValue  = getDaygetInAMonth(jSpinField2.getValue(), jSpinField3.getValue());
        jSpinField1.setMaximum(maxValue);
    }//GEN-LAST:event_jSpinField2InputMethodTextChanged

    private void jSpinField2CaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jSpinField2CaretPositionChanged
        // TODO add your handling code here:
         int maxValue  = getDaygetInAMonth(jSpinField2.getValue(), jSpinField3.getValue());
         jSpinField1.setMaximum(maxValue);
    }//GEN-LAST:event_jSpinField2CaretPositionChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChinhSuaAccount;
    private javax.swing.JButton btnChinhSuaDonHang;
    private javax.swing.JButton btnChinhSuaKhachHang;
    private javax.swing.JButton btnChinhSuaKhuyenMai;
    private javax.swing.JButton btnChinhSuaSanPham;
    private javax.swing.JButton btnChinhSuaThuongHieu;
    private javax.swing.JButton btnReloadAccount;
    private javax.swing.JButton btnReloadAccount2;
    private javax.swing.JButton btnReloadAccount5;
    private javax.swing.JButton btnReloadAccount6;
    private javax.swing.JButton btnThemAccount;
    private javax.swing.JButton btnThemDonHang;
    private javax.swing.JButton btnThemKhachHang;
    private javax.swing.JButton btnThemKhachHang1;
    private javax.swing.JButton btnThemKhuyenMai;
    private javax.swing.JButton btnThemSanPham;
    private javax.swing.JButton btnThemThuongHieu;
    private javax.swing.JButton btnThemThuongHieu1;
    private javax.swing.JButton btnXoaAccount;
    private javax.swing.JButton btnXoaKhachHang;
    private javax.swing.JButton btnXoaKhuyenMai;
    private javax.swing.JButton btnXoaSanPham;
    private javax.swing.JButton btnXoaThuongHieu;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
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
    private com.toedter.components.JSpinField jSpinField1;
    private com.toedter.components.JSpinField jSpinField11;
    private com.toedter.components.JSpinField jSpinField12;
    private com.toedter.components.JSpinField jSpinField13;
    private com.toedter.components.JSpinField jSpinField14;
    private com.toedter.components.JSpinField jSpinField15;
    private com.toedter.components.JSpinField jSpinField16;
    private com.toedter.components.JSpinField jSpinField2;
    private com.toedter.components.JSpinField jSpinField3;
    private com.toedter.components.JSpinField jSpinField5;
    private com.toedter.components.JSpinField jSpinField6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tableCoupon;
    private javax.swing.JTable tableKhachHang;
    private javax.swing.JTable tableOrder;
    private javax.swing.JTable tableProduct;
    private javax.swing.JTable tableSupplier;
    private javax.swing.JTable tableUser;
    private javax.swing.JLabel txtTongDoanhThu;
    private javax.swing.JLabel txtTongDonHang;
    // End of variables declaration//GEN-END:variables
    
    private void setListener(){
        _thongTinKhachHangDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                // your code
                _thongTinKhachHangDialog.clearData();
                loadTableCustomer();
            }
        });
         
        this._thongTinSanPhamDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                // your code
                _thongTinSanPhamDialog.clearData();
                loadTableProduct();
            }
        });
        this._nccTheoSanPhamDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                // your code
                loadTableStock();
                loadTableProduct();
            }
        });
        this._thongTinThuongHieuDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                // your code
                _thongTinThuongHieuDialog.clearData();
                loadTableBrand();
            }
        });
        
        this._themDonHangDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                // your code
                _themDonHangDialog.clearData();
                loadTableOrder();
            }
        });
        this._thongTinCouponDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                // your code
                _thongTinCouponDialog.clearData();
                loadTableCoupon();
            }
        });
        this._taoAccountDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                // your code
                _taoAccountDialog.clearData();
                loadTableUser();
            }
        });
        this._thongTinKhachHangDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                // your code
                _thongTinKhachHangDialog.clearData();
                loadTableCustomer();
            }
        });
    }
    
    private void loadTable() {
        loadTableStock();
        loadTableOrder();
        loadTableProduct();
        loadTableBrand();
        loadTableCoupon();
        loadTableUser();
        loadTableCustomer();
    }
    
    private void loadTableOrder(){
        
        List<Orders> listOrders = _ordersService.findAll();
        List<ProductInvoice> listProductInvoice = _productInvoiceService.findAll();
        _listOrder = listOrders;
        _listProductInvoice = listProductInvoice;
        DefaultTableModel d = (DefaultTableModel)tableOrder.getModel();
        d.setRowCount(0);
        
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm dd/MM/yyyy");
        int i = 1;
        long TongDonHangTrongHomNay = 0;
        long TongThuNhapTrongHomNay = 0;
        
        for(Orders c: _listOrder) {
            Vector vector = new Vector();
            vector.add(i);
            
          
            vector.add(c.getCustomer().getFirstName());
            vector.add(c.getCustomer().getPhone());
            vector.add(formatter.format(c.getOrderedAt()));
            long tongTien = 0;
            for (ProductInvoice pi: _listProductInvoice){
                if (pi.getOrders().getIdOrders().equals(c.getIdOrders())){
                    
                    long soluong = pi.getQuantity().longValue();
                    double VAT = ( 1.0 + pi.getVat().longValue()/100.0);
                    double  dongia = pi.getPrice().longValue() * VAT;
                    long giasanpham = soluong *  (long)dongia;
                    
                    tongTien = tongTien + giasanpham;
                }
            }
            if (c.getCoupon() != null){
                double giamGia = ( 1.0 - c.getCoupon().getDiscountPercentage()/100.0);
                tongTien = (long)(tongTien * giamGia);
            }
            
            Date toDay = new Date();
            
            if (c.getOrderedAt().getDate() == toDay.getDate() && c.getOrderedAt().getMonth() == toDay.getMonth() && c.getOrderedAt().getYear() == toDay.getYear() ){
                TongDonHangTrongHomNay = TongDonHangTrongHomNay + 1;
                TongThuNhapTrongHomNay = TongThuNhapTrongHomNay + tongTien;
            }
            vector.add(tongTien);
            
           
            i++;
            d.addRow(vector);
        }
        txtTongDonHang.setText(String.format("%,d", TongDonHangTrongHomNay));
        txtTongDoanhThu.setText(String.format("%,d VND", TongThuNhapTrongHomNay));
        
    }

    private void loadTableProduct(){
        
        List<Product> listProduct = _productService.findAll();
        _listProduct = listProduct;
        DefaultTableModel d = (DefaultTableModel)tableProduct.getModel();
        d.setRowCount(0);
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        int i = 1;
        for(Product c: listProduct) {
            Vector vector = new Vector();
            vector.add(i);
            
          
            vector.add(c.getName());
            
            vector.add(c.getSupplier().getName());
            
            vector.add(String.format("%,d", c.getPrice().longValue()));
            vector.add(c.getVat());
            
            
            long allStock = 0;
            for(Stock s: _listStock){
                if (s.getProduct().getIdProduct().equals(c.getIdProduct()))
                    allStock = allStock + s.getQuantity();
            }
            
            vector.add(String.format("%,d", allStock));
            vector.add(c.getStockable()?"Đang hoạt động": "Ngừng hoạt động");
            
            
           
            i++;
            d.addRow(vector);
        }
    }

    private void loadTableBrand(){
        
        List<Supplier> listSupplier = _supplierService.findAll();
        _listSupplier = listSupplier;
        DefaultTableModel d = (DefaultTableModel)tableSupplier.getModel();
        d.setRowCount(0);
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        int i = 1;
        for(Supplier c: listSupplier) {
            Vector vector = new Vector();
            vector.add(i);
            
          
            vector.add(c.getName());
            vector.add(c.getPhone());
           
            i++;
            d.addRow(vector);
        }
    }

    private void loadTableCoupon(){
        List<Coupon> listCoupon = _couponService.findAll();
        _listCoupon = listCoupon;
        DefaultTableModel d = (DefaultTableModel)tableCoupon.getModel();
        d.setRowCount(0);
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        int i = 1;
        for(Coupon c: listCoupon) {
            Vector vector = new Vector();
            vector.add(i);
            
          
            vector.add(c.getCode());
            vector.add(c.getDiscountPercentage());
            vector.add(formatter.format(c.getCreatedAt()));
            vector.add(formatter.format(c.getExpiryDate()));
            vector.add(c.getIsUsed()? "Đã được sủa dụng": "Chưa sử dụng");
            
           
            i++;
            d.addRow(vector);
        }
    }
    
    private void loadTableCustomer(){
        List<Customer> listCustomer = _customerService.findAll();
        _listCustomer = listCustomer;
        DefaultTableModel d = (DefaultTableModel)tableKhachHang.getModel();
        d.setRowCount(0);
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        int i = 1;
        for(Customer c: listCustomer) {
            Vector vector = new Vector();
            vector.add(i);
            
          
            vector.add(c.getFirstName());
            vector.add(c.getLastName());
            
            Date birthday = c.getBirthday(); 
            if (birthday != null)
                vector.add(formatter.format(birthday));
            else 
                vector.add("");
            
            vector.add(c.getPhone());
           
            i++;
            d.addRow(vector);
        }
    }
    
    private void loadTableUser(){
        List<User> listUser = _accountService.findAll();
        _listUser = listUser;
        DefaultTableModel d = (DefaultTableModel)tableUser.getModel();
        d.setRowCount(0);
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        int i = 1;
        for(User c: listUser) {
            Vector vector = new Vector();
            vector.add(i);
            
          
            vector.add(c.getUsername());
            
            i++;
            d.addRow(vector);
        }
    }
    
    private void loadTableStock(){
        List<Stock> listStock = _stockService.findAll();
        _listStock = listStock;
    }

    private void setMaxDay() {
        jSpinField1.setMaximum(30);
        jSpinField1.setMinimum(3);
    }
    
    
    
    private XYDataset createDataset() {

        var series1 = new XYSeries("2014");
        series1.add(18, 530);
        series1.add(20, 580);
        series1.add(25, 740);
        series1.add(30, 901);
        series1.add(40, 1300);
        series1.add(50, 2219);

        var series2 = new XYSeries("2016");
        series2.add(18, 567);
        series2.add(20, 612);
        series2.add(25, 800);
        series2.add(30, 980);
        series2.add(40, 1210);
        series2.add(50, 2350);

        var dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);

        return dataset;
    }

    private JFreeChart createChart(final XYDataset dataset) {

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Doanh thu theo năm giữa năm này và năm trước",
                "",
                "1.000.000 VND",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();

        var renderer = new XYLineAndShapeRenderer();

        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesStroke(1, new BasicStroke(2.0f));

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);
        plot.setRangeGridlinesVisible(false);
        plot.setDomainGridlinesVisible(false);

        chart.getLegend().setFrame(BlockBorder.NONE);

        chart.setTitle(new TextTitle("",
                        new Font("Serif", Font.BOLD, 18)
                )
        );

        return chart;
    }
    
    private CategoryDataset createDatasetAnalyzeProduct(List<Product> listProduct, List<BigInteger> listSoluong) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for(int i = 0; i< listSoluong.size(); i++){
            dataset.addValue(listSoluong.get(i), listProduct.get(i).getName(), "");
        }

        return dataset;
    }    
    
    private PieDataset createDatasetAnalyzeProductPie(List<Product> listProduct, List<Long> listSoluong) {
        
        DefaultPieDataset dataset=new DefaultPieDataset();
       
        for(int i = 0; i< listSoluong.size(); i++){
            dataset.setValue( listProduct.get(i).getName(), listSoluong.get(i));
        }

        return dataset;
    }
    
     static class CustomRenderer extends BarRenderer {

        private Paint[] colors;

        int transparency = 95;

        // http://www.cookbook-r.com/Graphs/Colors_(ggplot2)/
        public CustomRenderer() {
            this.colors = new Paint[] { new Color(1, 158, 115, transparency),
                    new Color(240, 228, 66, transparency),
                    new Color(0, 114, 178, transparency),
                    new Color(213, 94, 0, transparency),
                    new Color(204, 121, 167, transparency) };
        }

        public Paint getItemPaint(final int row, final int column) {
            return this.colors[column % this.colors.length];
        }
    }
     
    private int getDaygetInAMonth(int month, int year){
        YearMonth yearMonthObject = YearMonth.of(year, month);
        int daysInMonth = yearMonthObject.lengthOfMonth(); //28  
        return daysInMonth;
    }
     

    private static double getRoundedUpMultipleOfTen(double number) {
        return ((number + 9) / 10) * 10;
    }

    private ArrayList<Soluong> getDT(int selectedIndex,int month, int year){
        LocalDateTime dateNow = LocalDateTime.now();
        
        ArrayList<Soluong> listSoluong = new ArrayList();
        
        String name = "";
        
        switch (selectedIndex){
            case 0:
                name = String.format("Doanh thu trong tháng %d-%d", month, year);
                
                for (int i = 0 ; i < getDaygetInAMonth(month, year); i++){
                   
                 BigInteger doanhThu = BigInteger.valueOf(0);
                    
                    for (ProductInvoice pi: _listProductInvoice){
                        
                        Date orderDate = pi.getOrders().getOrderedAt();
                        int orderDay = orderDate.getDate();
                        int orderMonth = orderDate.getMonth();
                        int orderYear = orderDate.getYear();
                        
                        if (i + 1 ==  orderDay && orderMonth == month && orderYear == year){

                               long soluongSP = pi.getQuantity().longValue();
                               double VAT = ( 1.0 + pi.getVat().longValue()/100.0);
                               double  dongia = pi.getPrice().longValue() * VAT;
                               long giasanpham = soluongSP *  (long)dongia;
                               
                               
                                if (pi.getOrders().getCoupon() != null){
                                    double giamGia = ( 1.0 - pi.getOrders().getCoupon().getDiscountPercentage()/100.0);
                                    giasanpham = (long)(giasanpham * giamGia);
                                }
                               

                               doanhThu = doanhThu.add(BigInteger.valueOf(giasanpham));

                           }    
                    }
                    
                    
                    
                    listSoluong.add(new Soluong(i+1, doanhThu));
                }
                break;
            case 1:
                name = String.format("Doanh thu trong năm %d", year);
                for (int i = 0 ; i < 12; i++){
                    
                 BigInteger doanhThu = BigInteger.valueOf(0);
                    for (ProductInvoice pi: _listProductInvoice){
                        
                        Date orderDate = pi.getOrders().getOrderedAt();
                        int orderMonth = orderDate.getMonth();
                        int orderYear = orderDate.getYear();
                        
                        if (orderMonth == i && orderYear == year){

                               long soluongSP = pi.getQuantity().longValue();
                               double VAT = ( 1.0 + pi.getVat().longValue()/100.0);
                               double  dongia = pi.getPrice().longValue() * VAT;
                               long giasanpham = soluongSP *  (long)dongia;

                                if (pi.getOrders().getCoupon() != null){
                                    double giamGia = ( 1.0 - pi.getOrders().getCoupon().getDiscountPercentage()/100.0);
                                    giasanpham = (long)(giasanpham * giamGia);
                                }
                               

                               doanhThu = doanhThu.add(BigInteger.valueOf(giasanpham));

                           }    
                    }
                    
                    
                    
                    listSoluong.add(new Soluong(i+1, doanhThu));
                }
                
                break;
            case 2:
                name = String.format("Doanh thu theo năm %d", year);
                int maxYear = Integer.MIN_VALUE;
                int minYear = Integer.MAX_VALUE;

                for (Orders o: _listOrder){
                    maxYear = (o.getOrderedAt().getYear()>maxYear) ? o.getOrderedAt().getYear() : maxYear;
                    minYear = (o.getOrderedAt().getYear()<minYear) ? o.getOrderedAt().getYear() : minYear;
                }
                
                for (int i  = minYear; i<= maxYear; i++){
                    
                 BigInteger doanhThu = BigInteger.valueOf(0);
                 
                    for (ProductInvoice pi: _listProductInvoice){
                        
                        Date orderDate = pi.getOrders().getOrderedAt();
                        int orderYear = orderDate.getYear();
                        
                        if ( i == orderYear){

                               long soluongSP = pi.getQuantity().longValue();
                               double VAT = ( 1.0 + pi.getVat().longValue()/100.0);
                               double  dongia = pi.getPrice().longValue() * VAT;
                               long giasanpham = soluongSP *  (long)dongia;

                                if (pi.getOrders().getCoupon() != null){
                                    double giamGia = ( 1.0 - pi.getOrders().getCoupon().getDiscountPercentage()/100.0);
                                    giasanpham = (long)(giasanpham * giamGia);
                                }
                               

                               doanhThu = doanhThu.add(BigInteger.valueOf(giasanpham));

                           }    
                    }
                    
                    
                    
                    listSoluong.add(new Soluong(i, doanhThu));
                }
                break;
            default:
                break;
        }
        
        return listSoluong;
    }
    
    private void loadDataThongKe(){
        Date date = new Date();
        
        jSpinField1.setValue(date.getDate());
        jSpinField2.setValue(date.getMonth()+1);
        jSpinField3.setValue(date.getYear()+1900);
        
        jSpinField5.setValue(date.getMonth()+1);
        jSpinField6.setValue(date.getYear()+1900);
        
        jSpinField11.setValue(date.getDate());
        jSpinField12.setValue(date.getMonth()+1);
        jSpinField13.setValue(date.getYear()+1900);
        
        jSpinField14.setValue(date.getDate());
        jSpinField15.setValue(date.getMonth());
        jSpinField16.setValue(date.getYear()+1900);
        
    }
    
    class Soluong {
        public int key;
        public BigInteger value;
        
        Soluong(){
            
        }
        
        Soluong(int key, BigInteger value){
            this.key = key;
            this.value= value;
        }
    }
    
}
