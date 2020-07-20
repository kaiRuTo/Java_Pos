/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pos.Screens.Dialog;

import com.mycompany.pos.entity.Customer;
import com.mycompany.pos.entity.Product;
import com.mycompany.pos.entity.Orders;
import com.mycompany.pos.entity.ProductInvoice;
import com.mycompany.pos.entity.Stock;
import com.mycompany.pos.service.CustomerService;
import com.mycompany.pos.service.OrdersService;
import com.mycompany.pos.service.ProductInvoiceService;
import com.mycompany.pos.service.ProductService;
import com.mycompany.pos.service.StockService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UnknownFormatConversionException;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author luuhiep
 */
@Component
public class ThemDonHangDialog extends javax.swing.JFrame {
    private TimKhachHangDialog _timKhachHangDialog;
    
    private Customer _customer;
    
    private List<Product> _listProduct;
    private List<Product> _listProductInOrder;
    private List<Stock> _listStock;
    private List<Soluong> _listSoluong;
    
    private ProductService _productService;
    private OrdersService _orderService;
    private StockService _stockService;
    private ProductInvoiceService _productInvoiceService;
    
    
    /**
     * Creates new form ThemDonHangDialog
     */
    public ThemDonHangDialog() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    
    @Autowired
    public ThemDonHangDialog(   TimKhachHangDialog      timKhachHangDialog,
                                ProductService          productService, 
                                OrdersService           ordersService,
                                StockService            stockService,
                                ProductInvoiceService   productInvoiceService) {
        this._timKhachHangDialog = timKhachHangDialog;
        this._productInvoiceService = productInvoiceService;
        this._productService = productService;
        this._orderService = ordersService;
        this._stockService = stockService;
        initComponents();
        addListener();
        _listSoluong = new ArrayList<Soluong>();
        _listProductInOrder = new ArrayList<Product>();
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProductInOrder = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbCustomerName = new javax.swing.JLabel();
        lbGiaTien = new javax.swing.JLabel();
        lbGiamGia = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbTongTien = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableProducts = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tableProductInOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên sản phẩm", "Giá", "VAT", "Số lượng", "Tổng tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProductInOrder.setRowHeight(24);
        tableProductInOrder.setSize(new java.awt.Dimension(600, 64));
        jScrollPane1.setViewportView(tableProductInOrder);
        if (tableProductInOrder.getColumnModel().getColumnCount() > 0) {
            tableProductInOrder.getColumnModel().getColumn(0).setResizable(false);
            tableProductInOrder.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableProductInOrder.getColumnModel().getColumn(3).setResizable(false);
            tableProductInOrder.getColumnModel().getColumn(3).setPreferredWidth(30);
        }

        jLabel1.setFont(new java.awt.Font("Open Sans", 0, 36)); // NOI18N
        jLabel1.setText("Đơn hàng");

        jButton1.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jButton1.setText("THANH TOÁN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jButton2.setText("CHỌN KHÁCH HÀNG");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel2.setText("Khách hàng");

        jLabel3.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel3.setText("Giá tiền");

        jLabel4.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel4.setText("Giảm giá");

        lbCustomerName.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        lbCustomerName.setText("Chưa chọn");

        lbGiaTien.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        lbGiaTien.setText("0");

        lbGiamGia.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        lbGiamGia.setText("0");

        jLabel8.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel8.setText("Tổng tiền");

        lbTongTien.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        lbTongTien.setText("0");

        tableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Sản phẩm", "Giá", "Số lượng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProducts.setRowHeight(24);
        tableProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableProducts);
        if (tableProducts.getColumnModel().getColumnCount() > 0) {
            tableProducts.getColumnModel().getColumn(0).setResizable(false);
            tableProducts.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableProducts.getColumnModel().getColumn(1).setResizable(false);
            tableProducts.getColumnModel().getColumn(1).setPreferredWidth(60);
        }

        jLabel10.setText("Tìm sản phẩm:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel8)))
                                .addGap(103, 103, 103)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbGiaTien)
                                    .addComponent(lbCustomerName)
                                    .addComponent(lbGiamGia)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbTongTien)
                                        .addGap(2, 2, 2))))
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(783, 783, 783)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(lbCustomerName))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(lbGiaTien))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbGiamGia)
                                .addComponent(jLabel4))
                            .addGap(18, 18, 18)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbTongTien)
                                .addComponent(jLabel8))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductsMouseClicked
        // TODO add your handling code here:
        
        addCurrentProductToOrder();
        
    }//GEN-LAST:event_tableProductsMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (_listProductInOrder.size()<=0){
            
            JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm");
            return;
            
        }
        if (_customer  == null){
            
            JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng");
            return;
        }
        Orders order = new Orders();
        order.setCreatedAt(new Date());
        order.setOrderedAt(new Date());
        
        order.setCustomer(_customer);
        order = _orderService.save(order);
        
        for (Product  p: _listProductInOrder){
            ProductInvoice productInvoice = new ProductInvoice();
            productInvoice.setOrders(order);
            productInvoice.setProduct(p);
            
            int index = -1 ;
            for (int j = 0; j<_listSoluong.size(); j ++){
                if ((long)_listSoluong.get(j).id == p.getIdProduct()){
                    index = j;
                    break;
                }
            }
            
            if (index >=0){
                productInvoice.setQuantity(_listSoluong.get(index).soluong);
            } else{
                productInvoice.setQuantity((long)1);
            }
            
            productInvoice.setPrice(p.getPrice());
            productInvoice.setVat(p.getVat());
            
            _productInvoiceService.save(productInvoice);
            
            
            index = -1 ;
            for (int j = 0; j<_listStock.size(); j ++){
                if ((long)_listStock.get(j).getProduct().getIdProduct() == p.getIdProduct()){
                    index = j;
                    break;
                }
            }
            
            if (index >= 0){
                Stock stock = _listStock.get(index);
                stock.setQuantity(stock.getQuantity() - _listSoluong.get(index).soluong);
                
                _stockService.save(stock);
            }
            
        }
            

        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        _timKhachHangDialog.loadListCustomer();
        _timKhachHangDialog.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ThemDonHangDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemDonHangDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemDonHangDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemDonHangDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemDonHangDialog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbCustomerName;
    private javax.swing.JLabel lbGiaTien;
    private javax.swing.JLabel lbGiamGia;
    private javax.swing.JLabel lbTongTien;
    private javax.swing.JTable tableProductInOrder;
    private javax.swing.JTable tableProducts;
    // End of variables declaration//GEN-END:variables
    
    
    
    private void addListener(){
        tableProductInOrder.getModel().addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
                int row = tableProductInOrder.getSelectedRow();
                int column = tableProductInOrder.getSelectedColumn();

                if (row <= -1 || column <=-1){
                    return ;
                }
                
                try {
                    // resul is the new value to insert in the DB
                    long resul = Integer.parseInt(tableProductInOrder.getValueAt(row, column).toString());
                    // id is the primary key of my DB
                    long id = _listProductInOrder.get(row).getIdProduct();


                    tableProductInOrder.clearSelection();

                    for(Soluong c: _listSoluong) {
                        if (c.id == id){
                            Soluong sltmp = new Soluong();
                            sltmp.id = c.id;
                            sltmp.soluong = resul;
                            if (canGetFromStock(sltmp))
                                c.soluong = resul;
                            reloadTableProductInOrder();
                            break;
                        }
                    }
                } catch (UnknownFormatConversionException ex) {
                    tableProductInOrder.clearSelection();
                    return ;
                }
                
            }
        });
        
        _timKhachHangDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                // your code
//                _screenTDH.clearData();
                Customer customer = _timKhachHangDialog.getCurrentCustomer();
                if (customer != null){
                    _customer = customer;
                    lbCustomerName.setText(_customer.getFirstName());
                }
            }
        });
    }
    
    
    public void clearData(){
        _listProductInOrder.clear();
        _listSoluong.clear();
        _customer = null;
        lbCustomerName.setText("Chưa chọn");
        lbGiaTien.setText("0");
        lbGiamGia.setText("0");
        lbTongTien.setText("0");
    }

    public void loadList(){
        loadListProduct();
        loadListStock();
        
        loadTableProduct();
    }

    private void loadListStock() {
        List<Stock> listStock = _stockService.findAll();
        _listStock = listStock;
    }
    
    
    private void loadListProduct(){
        List<Product> listProduct = _productService.findAll();
        _listProduct = listProduct;  
    }

    private void loadTableProduct() {    
        DefaultTableModel d = (DefaultTableModel)tableProducts.getModel();
        d.setRowCount(0);
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        int i = 1;
        for(Product c: _listProduct) {
            Vector vector = new Vector();
            vector.add(i);
            
            if (!c.getStockable()){
                continue;
            }
            
            vector.add(c.getName());
            vector.add(c.getPrice());
            
            long allStock = 0;
            for(Stock s: _listStock){
                allStock = allStock + s.getQuantity();
            }
            
            if (allStock <= 0) {
                continue;
            }
            
            vector.add(allStock);
            
           
            i++;
            d.addRow(vector);
        }
    }
    
    private void addCurrentProductToOrder(){
        int selectedIndex = tableProducts.getSelectedRow();
       
        Product product = _listProduct.get(selectedIndex);
        
        if (!_listProductInOrder.contains(product)){
            _listProductInOrder.add(product);
            Soluong soLuong = new Soluong();
            soLuong.id = product.getIdProduct();
            soLuong.soluong = 1;
            
            if (canGetFromStock(soLuong))
                _listSoluong.add(soLuong);
        } else {
           for (Soluong sl: _listSoluong){
               if (sl.id == product.getIdProduct()){
                   Soluong sltmp = new Soluong();
                   sltmp.id = sl.id;
                   sltmp.soluong = sl.soluong + 1;
                   if (canGetFromStock(sltmp))
                        sl.soluong = sl.soluong + 1;
               }
           }
        }
        
        
        reloadTableProductInOrder();
    }
    
    private boolean canGetFromStock(Soluong sl){
        int index = -1 ;
        for (int j = 0; j<_listStock.size(); j ++){
            if ((long)_listStock.get(j).getProduct().getIdProduct() == sl.id    ){
                if (sl.soluong <= _listStock.get(j).getQuantity())
                    return true;
                return false;
            }
        }
        return false;
    }
    
    
    private void reloadTableProductInOrder(){
        DefaultTableModel _d = (DefaultTableModel)tableProductInOrder.getModel();
        DefaultTableModel d = (DefaultTableModel)tableProductInOrder.getModel();
        d.setRowCount(0);
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        long tongHoaDon = 0;
        long tongSL = 0;
        int i = 1;
        for(Product c: _listProduct) {
            Vector vector = new Vector();
            vector.add(i);
            
            vector.add(c.getName());
            vector.add(c.getPrice().longValue());
            vector.add(c.getVat());
            
            int index = -1 ;
            for (int j = 0; j<_listSoluong.size(); j ++){
                if ((long)_listSoluong.get(j).id == c.getIdProduct()){
                    index = j;
                    break;
                }
            }
            
            if (index >= 0){
                long soluong = _listSoluong.get(index).soluong;
                double VAT = ( 1.0 + c.getVat().longValue()/100.0);
                double  dongia = c.getPrice().longValue() * VAT;
                long tongTien = soluong *  (long)dongia;
                
                vector.add(soluong);
                vector.add(tongTien);
                
                tongHoaDon = tongHoaDon + tongTien;
            } else {
                
                Soluong soLuong = new Soluong();
                soLuong.id = c.getIdProduct();
                soLuong.soluong = 1;
                
                _listSoluong.add(soLuong);
                
                vector.add(1);
                vector.add(  c.getPrice().longValue() * ( 1.0 + c.getVat().longValue()/100));
                
                double VAT = ( 1.0 + c.getVat().longValue()/100.0);
                double dongia = c.getPrice().longValue() * VAT;
                
                tongHoaDon = tongHoaDon + (long)dongia;
            }
            
           
           
            i++;
            d.addRow(vector);
        }
        
        lbGiaTien.setText(String.format("%d", tongHoaDon));
        lbTongTien.setText(String.format("%d", tongHoaDon));
        
    }
    
    
    class Soluong{
        public long id;
        public long soluong;
        public Soluong(){
            
        };
    }


}
