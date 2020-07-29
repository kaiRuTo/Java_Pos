/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pos.Screens.Dialog;

import com.mycompany.pos.entity.ImportInvoice;
import com.mycompany.pos.entity.Product;
import com.mycompany.pos.entity.Supplier;
import com.mycompany.pos.service.CustomerService;
import com.mycompany.pos.service.ImportInvoiceService;
import com.mycompany.pos.service.OrdersService;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UnknownFormatConversionException;
import java.util.Vector;
import javax.swing.JFrame;
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
public class ThemSanPhamTheoNCCDialog extends javax.swing.JFrame {
    private List<Product> _listProduct;
    private List<Product> _listProductInOrder;
    private List<Soluong> _listSoluong;
    private Supplier _supplier;
    
    private ImportInvoiceService _importInvoiceService;
    
    
    /**
     * Creates new form ThemDonHangDialog
     */
    public ThemSanPhamTheoNCCDialog() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    
    @Autowired
    public ThemSanPhamTheoNCCDialog(ImportInvoiceService importInvoiceService) {
        this._importInvoiceService = importInvoiceService;
        initComponents();
        addListener();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbSL = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbTongTien = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableProducts = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

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
                false, false, false, false, true, false
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
        tableProductInOrder.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableProductInOrderKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tableProductInOrder);
        if (tableProductInOrder.getColumnModel().getColumnCount() > 0) {
            tableProductInOrder.getColumnModel().getColumn(0).setResizable(false);
            tableProductInOrder.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableProductInOrder.getColumnModel().getColumn(3).setResizable(false);
            tableProductInOrder.getColumnModel().getColumn(3).setPreferredWidth(30);
        }

        jLabel1.setFont(new java.awt.Font("Open Sans", 0, 36)); // NOI18N
        jLabel1.setText("Sản phẩm");

        jButton1.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jButton1.setText("THÊM VÀO KHO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel2.setText("NCC");

        jLabel3.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel3.setText("SL sản phẩm");

        jLabel5.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel5.setText("LƯU HIỆP");

        lbSL.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        lbSL.setText("200");

        jLabel8.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel8.setText("Tổng tiền");

        lbTongTien.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        lbTongTien.setText("200.000Đ");

        tableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Sản phẩm", "Giá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
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

        jButton2.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jButton2.setText("XOÁ SẢN PHẨM");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTongTien, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel8))
                                        .addGap(103, 103, 103)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbSL)
                                            .addComponent(jLabel5)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(783, 783, 783)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
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
                                .addComponent(jLabel5))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(lbSL))
                            .addGap(18, 18, 18)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(lbTongTien))
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
        addCurrenadtProductToStockTmp();
    }//GEN-LAST:event_tableProductsMouseClicked

    private void tableProductInOrderKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableProductInOrderKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tableProductInOrderKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int row = tableProductInOrder.getSelectedRow();
        
        long productId = _listProductInOrder.get(row).getIdProduct();
        
        _listProductInOrder.remove(row);
        
        _listSoluong.removeIf(n -> (n.id ==productId));
        
        reloadTableProductInOrder();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        for (Product c: _listProductInOrder){
            ImportInvoice importInvoice = new ImportInvoice();
            importInvoice.setCreatedAt(new Date());
            importInvoice.setOrderedAt(new Date());
            importInvoice.setProduct(c);
//            importInvoice.setSupplier(_supplier);
            
             int index = -1 ;
            for (int j = 0; j<_listSoluong.size(); j ++){
                if ((long)_listSoluong.get(j).id == c.getIdProduct()){
                    index = j;
                    break;
                }
            }
            
            if (index >=0){
                importInvoice.setQuantity(_listSoluong.get(index).soluong);
            } else{
                importInvoice.setQuantity((long)1);
            }
            
            _importInvoiceService.save(importInvoice);
            
        }
        this.dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ThemSanPhamTheoNCCDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemSanPhamTheoNCCDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemSanPhamTheoNCCDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemSanPhamTheoNCCDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemSanPhamTheoNCCDialog().setVisible(true);
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbSL;
    private javax.swing.JLabel lbTongTien;
    private javax.swing.JTable tableProductInOrder;
    private javax.swing.JTable tableProducts;
    // End of variables declaration//GEN-END:variables
    
    public void clearData(){
        tableProductInOrder.clearSelection();
        _listProductInOrder.clear();
    }
    
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
    }
    
    public void setListProductWithSupplier(List<Product> listProduct, Supplier supplier) {
        _supplier = supplier;
        _listProduct = listProduct;
        _listProductInOrder = new ArrayList<Product>();
        _listSoluong = new ArrayList<Soluong>();
        
        loadListProduct();
    }
    
    private void loadListProduct(){
        DefaultTableModel d = (DefaultTableModel)tableProducts.getModel();
        d.setRowCount(0);
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        int i = 0;
        for(Product c: _listProduct) {
            Vector vector = new Vector();
            vector.add(i);
            
            vector.add(c.getName());
            vector.add(c.getPrice());
            
           
            i++;
            d.addRow(vector);
        }
    }
    
    private void addCurrenadtProductToStockTmp(){
        int selectedIndex = tableProducts.getSelectedRow();
       
        Product product = _listProduct.get(selectedIndex);
        
        if (!_listProductInOrder.contains(product)){
            _listProductInOrder.add(product);
            Soluong soLuong = new Soluong();
            soLuong.id = product.getIdProduct();
            soLuong.soluong = 1;
            
            _listSoluong.add(soLuong);
        }
       
        reloadTableProductInOrder();
    }
    
    private void reloadTableProductInOrder(){
        DefaultTableModel _d = (DefaultTableModel)tableProductInOrder.getModel();
        DefaultTableModel d = (DefaultTableModel)tableProductInOrder.getModel();
        d.setRowCount(0);
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        long tongHoaDon = 0;
        long tongSL = 0;
        int i = 0;
        for(Product c: _listProductInOrder) {
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
                vector.add(_listSoluong.get(index).soluong);
                long tongTien = _listSoluong.get(index).soluong *  c.getPrice().longValue();
                vector.add(tongTien);
                tongSL = tongSL + _listSoluong.get(index).soluong;
                tongHoaDon = tongHoaDon + tongTien;
            } else {
                Soluong soLuong = new Soluong();
                soLuong.id = c.getIdProduct();
                soLuong.soluong = 1;

                _listSoluong.add(soLuong);
                
                vector.add(1);
                vector.add( c.getPrice().longValue());
                
                
                tongSL = tongSL + 1;
                tongHoaDon = tongHoaDon + c.getPrice().longValue();
            }
            
           
           
            i++;
            d.addRow(vector);
        }
        
        lbTongTien.setText(String.format("%d", tongHoaDon));
        lbSL.setText(String.format("%d", tongSL));
        
        
    }
    
    class Soluong{
        public long id;
        public long soluong;
        public Soluong(){
            
        };
    }
}
