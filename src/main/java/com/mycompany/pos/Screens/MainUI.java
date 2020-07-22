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
import com.mycompany.pos.entity.Supplier;
import com.mycompany.pos.entity.User;
import com.mycompany.pos.service.CouponService;
import com.mycompany.pos.service.CustomerService;
import com.mycompany.pos.service.ProductInvoiceService;
import com.mycompany.pos.service.OrdersService;
import com.mycompany.pos.service.ProductService;
import com.mycompany.pos.service.SupplierService;
import com.mycompany.pos.service.UserService;
import java.sql.ResultSetMetaData;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
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
    
    private List<Customer> _listCustomer;
    private List<Product> _listProduct;
    private List<ProductInvoice> _listProductInvoice;
    private List<Orders> _listOrder;
    private List<Supplier> _listSupplier;
    private List<Coupon> _listCoupon;
    private List<User>  _listUser;
    
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
                    UserService                 userService
    ) {
        initComponents();
        this._customerService = customerService;
        this._productService = productService;
        this._ordersService = ordersService;
        this._productInvoiceService = productInvoiceService;
        this._supplierService = supplierService;
        this._couponService = couponService;
        this._accountService = userService;
        
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
        
        loadTable();
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Sản phẩm", "Giá tiền", "VAT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
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
                "STT", "Tên nhà cung cấp", "SLug"
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

        jPanel1.setBackground(new java.awt.Color(55, 126, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(250, 800));

        jLabel1.setFont(new java.awt.Font("Open Sans", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Delivered Order");

        jLabel2.setFont(new java.awt.Font("Open Sans", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("OVERVIEW");

        jLabel3.setFont(new java.awt.Font("Open Sans", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("200");

        jLabel4.setFont(new java.awt.Font("Open Sans", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Order today");

        jLabel5.setFont(new java.awt.Font("Open Sans", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("200");

        jLabel6.setFont(new java.awt.Font("Open Sans", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cancelled Order");

        jLabel7.setFont(new java.awt.Font("Open Sans", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("200");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(35, 35, 35))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addComponent(jLabel7)
                    .addContainerGap(124, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jLabel2)
                .addGap(42, 42, 42)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(107, 107, 107)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(388, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addGap(345, 345, 345)))
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
        
        int selectedIndex = tableProduct.getSelectedRow();
        _thongTinSanPhamDialog.setStatus(Status.UPDATE);
        _thongTinSanPhamDialog.setProduct(_listProduct.get(selectedIndex));
        _thongTinSanPhamDialog.setVisible(true);
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
            return;
        
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
            }
        } catch (NullPointerException ex){
            
            JOptionPane.showMessageDialog(null, "Có gì đó không ổn");
        }
    }//GEN-LAST:event_btnXoaAccountActionPerformed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JTable tableCoupon;
    private javax.swing.JTable tableKhachHang;
    private javax.swing.JTable tableOrder;
    private javax.swing.JTable tableProduct;
    private javax.swing.JTable tableSupplier;
    private javax.swing.JTable tableUser;
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
    }
    
    private void loadTable() {
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
            
            vector.add(tongTien);
            
           
            i++;
            d.addRow(vector);
        }
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
            vector.add(c.getPrice());
            vector.add(c.getVat());
            
           
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
            vector.add(c.getSlug());
            
           
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

}
