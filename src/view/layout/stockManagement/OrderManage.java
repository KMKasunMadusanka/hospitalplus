/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.layout.stockManagement;

import Controller.StockManagement.DrugController;
import Controller.StockManagement.OrderController;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.DrugCategoryModel;
import model.DrugModel;
import model.OrderModel;
import model.SupplierModel;
import org.apache.log4j.Logger;
import util.Config;
import util.DBUtil;
import static util.DBUtil.getXMLData;
import util.Util;
import static util.messageAlert.getMessageAlert;

/**
 *
 * @author EnTeRs
 */
public class OrderManage extends javax.swing.JFrame {

    private static OrderManage self;

    Config cnf = new Config();
    public Logger LOG;

    public OrderManage() {
        initComponents();
        self = this;

        //initialize log file
        LOG = cnf.getLogger(OrderManage.class);

        resetJframe();
        getSuppliersInit();
        getDrugsInit();
        getPendingOrderInit();
        setupDrugTable();
    }

    public static OrderManage getInstance() {
        if (self == null) {
            self = new OrderManage();
        }

        return self;
    }

    public final void resetJframe() {
        util.Util.Clear(OrderManagePanel);
        omDeleteOrderItemBtn1.setEnabled(false);
        omOrderReceivedBtn.setEnabled(false);
    }

    private void setupDrugTable() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        omOrdersTable.setDefaultRenderer(String.class, centerRenderer);
        omPendingOrdersTable.setDefaultRenderer(String.class, centerRenderer);

        ((DefaultTableCellRenderer) omOrdersTable.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
        ((DefaultTableCellRenderer) omPendingOrdersTable.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);

        omOrdersTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        omPendingOrdersTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        Util.resizeColumnWidth(omOrdersTable);
        Util.resizeColumnWidth(omPendingOrdersTable);
    }

    private void getSuppliersInit() {
        omSupplierSelector.removeAllItems();

        SupplierModel supplier1 = new SupplierModel("Olympus", "hasitha.bigwig@gmail.com");
        SupplierModel supplier2 = new SupplierModel("NexaHealth", "yashvida.1007@gmail.com");
        SupplierModel supplier3 = new SupplierModel("MedHomeTown", "kmkasunmadushanka@gmail.com");
        omSupplierSelector.addItem(supplier1);
        omSupplierSelector.addItem(supplier2);
        omSupplierSelector.addItem(supplier3);
    }

    private void getDrugsInit() {
        omDrugSelector.removeAllItems();

        try {
            List<DrugModel> drugs = DrugController.getInstance().allDrugs();
            for (int c = 0; c < drugs.size(); c++) {
                omDrugSelector.addItem(drugs.get(c));
            }
        } catch (SQLException ex) {
            LOG.error(ex);
        }
    }

    private void getPendingOrderInit() {
        try {
            DefaultTableModel model = (DefaultTableModel) omPendingOrdersTable.getModel();
            model.setRowCount(0);
            List<OrderModel> orders = OrderController.getInstance().allOrders("true");
            for (int r = 0; r < orders.size(); r++) {
                Object[] row = {orders.get(r).getId(),
                    orders.get(r).getSupplier(),
                    orders.get(r).getDrug(),
                    orders.get(r).getQty()};
                model.addRow(row);
            }
        } catch (SQLException ex) {
            LOG.error(ex);
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

        OrderManagePanel = new javax.swing.JPanel();
        omPendingSubtitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        omPendingOrdersTable = new javax.swing.JTable();
        omOrderReceivedBtn = new javax.swing.JButton();
        omSupplierSelector = new javax.swing.JComboBox<>();
        omSupplierLabel = new javax.swing.JLabel();
        omDrugLabel = new javax.swing.JLabel();
        omDrugSelector = new javax.swing.JComboBox<>();
        omQtyLabel = new javax.swing.JLabel();
        omQtyInput = new javax.swing.JSpinner();
        omAddOrderItemBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        omOrdersTable = new javax.swing.JTable();
        omTitleLabel = new javax.swing.JLabel();
        omAddSubtitle = new javax.swing.JLabel();
        omSendFullOrderBtn = new javax.swing.JButton();
        omDeleteOrderItemBtn1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(1765, 770));
        getContentPane().setLayout(null);

        OrderManagePanel.setBackground(new java.awt.Color(0, 0, 0));
        OrderManagePanel.setMaximumSize(new java.awt.Dimension(1765, 770));
        OrderManagePanel.setMinimumSize(new java.awt.Dimension(1765, 770));
        OrderManagePanel.setLayout(null);

        omPendingSubtitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        omPendingSubtitle.setForeground(new java.awt.Color(255, 255, 255));
        omPendingSubtitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        omPendingSubtitle.setText("Pending Orders");
        OrderManagePanel.add(omPendingSubtitle);
        omPendingSubtitle.setBounds(700, 100, 970, 40);

        omPendingOrdersTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        omPendingOrdersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Supplier", "Drug", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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
        omPendingOrdersTable.setRowHeight(20);
        omPendingOrdersTable.getTableHeader().setReorderingAllowed(false);
        omPendingOrdersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                omPendingOrdersTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(omPendingOrdersTable);

        OrderManagePanel.add(jScrollPane1);
        jScrollPane1.setBounds(700, 170, 970, 480);

        omOrderReceivedBtn.setText("Order Received");
        omOrderReceivedBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                omOrderReceivedBtnActionPerformed(evt);
            }
        });
        OrderManagePanel.add(omOrderReceivedBtn);
        omOrderReceivedBtn.setBounds(1490, 680, 180, 40);

        OrderManagePanel.add(omSupplierSelector);
        omSupplierSelector.setBounds(280, 170, 300, 30);

        omSupplierLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        omSupplierLabel.setForeground(new java.awt.Color(255, 255, 255));
        omSupplierLabel.setText("Supplier");
        OrderManagePanel.add(omSupplierLabel);
        omSupplierLabel.setBounds(100, 170, 150, 30);

        omDrugLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        omDrugLabel.setForeground(new java.awt.Color(255, 255, 255));
        omDrugLabel.setText("Drug");
        OrderManagePanel.add(omDrugLabel);
        omDrugLabel.setBounds(100, 240, 150, 30);

        OrderManagePanel.add(omDrugSelector);
        omDrugSelector.setBounds(280, 240, 300, 30);

        omQtyLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        omQtyLabel.setForeground(new java.awt.Color(255, 255, 255));
        omQtyLabel.setText("Quantity");
        OrderManagePanel.add(omQtyLabel);
        omQtyLabel.setBounds(100, 310, 150, 30);

        omQtyInput.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        OrderManagePanel.add(omQtyInput);
        omQtyInput.setBounds(280, 310, 300, 30);

        omAddOrderItemBtn.setText("Add Order Item");
        omAddOrderItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                omAddOrderItemBtnActionPerformed(evt);
            }
        });
        OrderManagePanel.add(omAddOrderItemBtn);
        omAddOrderItemBtn.setBounds(170, 370, 150, 40);

        omOrdersTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        omOrdersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supplier", "Drug", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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
        omOrdersTable.setRowHeight(20);
        omOrdersTable.getTableHeader().setReorderingAllowed(false);
        omOrdersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                omOrdersTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(omOrdersTable);

        OrderManagePanel.add(jScrollPane2);
        jScrollPane2.setBounds(90, 450, 490, 200);

        omTitleLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        omTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        omTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        omTitleLabel.setText("Order Manage");
        OrderManagePanel.add(omTitleLabel);
        omTitleLabel.setBounds(0, 30, 1760, 50);

        omAddSubtitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        omAddSubtitle.setForeground(new java.awt.Color(255, 255, 255));
        omAddSubtitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        omAddSubtitle.setText("Add Orders");
        OrderManagePanel.add(omAddSubtitle);
        omAddSubtitle.setBounds(100, 100, 490, 40);

        omSendFullOrderBtn.setText("Send Full Order");
        omSendFullOrderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                omSendFullOrderBtnActionPerformed(evt);
            }
        });
        OrderManagePanel.add(omSendFullOrderBtn);
        omSendFullOrderBtn.setBounds(240, 680, 180, 40);

        omDeleteOrderItemBtn1.setText("Delete Order Item");
        omDeleteOrderItemBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                omDeleteOrderItemBtn1ActionPerformed(evt);
            }
        });
        OrderManagePanel.add(omDeleteOrderItemBtn1);
        omDeleteOrderItemBtn1.setBounds(350, 370, 150, 40);

        getContentPane().add(OrderManagePanel);
        OrderManagePanel.setBounds(0, 0, 1765, 770);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void omPendingOrdersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_omPendingOrdersTableMouseClicked
        if (omPendingOrdersTable.getSelectedRow() > -1) {
            omOrderReceivedBtn.setEnabled(true);
        } else {
            omOrderReceivedBtn.setEnabled(false);
        }
    }//GEN-LAST:event_omPendingOrdersTableMouseClicked

    private void omOrderReceivedBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_omOrderReceivedBtnActionPerformed
        try {
            boolean dbStatus = OrderController.getInstance().update(
                    (int) omPendingOrdersTable.getValueAt(omPendingOrdersTable.getSelectedRow(), 0),
                    "false");
            if (dbStatus) {
                getPendingOrderInit();
                getMessageAlert(String.format(getXMLData("StockMsg", "message", "updatedMsg"), "Order"), "success");
            } else {
                getMessageAlert(getXMLData("StockMsg", "message", "somethingWrong"), "error");
            }
        } catch (SQLException ex) {
            getMessageAlert(getXMLData("StockMsg", "message", "somethingWrong"), "error");
            LOG.error(ex);
        }
    }//GEN-LAST:event_omOrderReceivedBtnActionPerformed

    private void omAddOrderItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_omAddOrderItemBtnActionPerformed
        if ((int) omQtyInput.getValue() > 0) {
            try {
                DefaultTableModel model = (DefaultTableModel) omOrdersTable.getModel();

                SupplierModel supplierobj = (SupplierModel) omSupplierSelector.getSelectedItem();
                DrugModel drugobj = (DrugModel) omDrugSelector.getSelectedItem();
                Object[] row = {supplierobj.getName(),
                    drugobj.getName(),
                    omQtyInput.getValue()};
                model.addRow(row);
                omQtyInput.setValue(0);
            } catch (Exception ee) {
                LOG.error(ee);
            }
        } else {
            getMessageAlert(String.format(getXMLData("StockMsg", "message", "numberzero"), "Quantity"), "error");
        }
    }//GEN-LAST:event_omAddOrderItemBtnActionPerformed

    private void omOrdersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_omOrdersTableMouseClicked
        if (omOrdersTable.getSelectedRow() > -1) {
            omDeleteOrderItemBtn1.setEnabled(true);
        } else {
            omDeleteOrderItemBtn1.setEnabled(false);
        }
    }//GEN-LAST:event_omOrdersTableMouseClicked

    private void omSendFullOrderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_omSendFullOrderBtnActionPerformed
        if (omOrdersTable.getRowCount() > 0) {

            List<String> supEmails = new ArrayList<>();
            List<String> drugEmailMsg = new ArrayList<>();
            SupplierModel supplierobj = new SupplierModel("", "");

            for (int s = 0; s < omOrdersTable.getRowCount(); s++) {
                String supplierName = (String) omOrdersTable.getValueAt(s, 0);
                for (int b = 0; b < omSupplierSelector.getItemCount(); b++) {
                    if (supplierName.equals(omSupplierSelector.getItemAt(b).getName())) {
                        supplierobj = (SupplierModel) omSupplierSelector.getItemAt(b);
                        break;
                    }
                }
                if (!supEmails.contains(supplierobj.getEmail())) {
                    supEmails.add(supplierobj.getEmail());
                    drugEmailMsg.add("Hi, \n\n" + omOrdersTable.getValueAt(s, 1).toString() + " - " + omOrdersTable.getValueAt(s, 2).toString());
                } else {
                    for (int a = 0; a < supEmails.size(); a++) {
                        if (supEmails.get(a).equals(supplierobj.getEmail())) {
                            drugEmailMsg.set(a, drugEmailMsg.get(a) + "\n"
                                    + omOrdersTable.getValueAt(s, 1).toString()
                                    + " - " + omOrdersTable.getValueAt(s, 2).toString());
                            break;
                        }
                    }
                }
            }

            boolean orderaddStatus = false;
            for (int n = 0; n < omOrdersTable.getRowCount(); n++) {
                try {
                    OrderModel order = new OrderModel(omOrdersTable.getValueAt(n, 0).toString(),
                            omOrdersTable.getValueAt(n, 1).toString(),
                            (int) omOrdersTable.getValueAt(n, 2),
                            "true");
                    orderaddStatus = OrderController.getInstance().save(order);
                } catch (SQLException ex) {
                    getMessageAlert(getXMLData("StockMsg", "message", "somethingWrong"), "error");
                    LOG.error(ex);
                }
            }

            if (orderaddStatus) {
                getMessageAlert(String.format(getXMLData("StockMsg", "message", "addedMsg"), "Orders"), "success");
                getPendingOrderInit();
                setupDrugTable();
            } else {
                getMessageAlert(getXMLData("StockMsg", "message", "somethingWrong"), "error");
            }

            boolean emailStatus = false;
            for (int e = 0; e < supEmails.size(); e++) {
                try {
                    emailStatus = Util.mailSender(supEmails.get(e),
                            "New Drug Order Request", drugEmailMsg.get(e) + "\n\n Thank You.");
                } catch (IOException ex) {
                    getMessageAlert(getXMLData("StockMsg", "message", "somethingWrong"), "error");
                    LOG.error(ex);
                }
            }
            if (emailStatus) {
                getMessageAlert(getXMLData("StockMsg", "message", "emaildone"), "success");
                DefaultTableModel model = (DefaultTableModel) omOrdersTable.getModel();
                model.setRowCount(0);
            } else {
                getMessageAlert(getXMLData("StockMsg", "message", "somethingWrong"), "error");
            }
        } else {
            getMessageAlert(getXMLData("StockMsg", "message", "emptyorders"), "error");
        }
    }//GEN-LAST:event_omSendFullOrderBtnActionPerformed

    private void omDeleteOrderItemBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_omDeleteOrderItemBtn1ActionPerformed
        DefaultTableModel model = (DefaultTableModel) this.omOrdersTable.getModel();
        model.removeRow(omOrdersTable.getSelectedRow());
    }//GEN-LAST:event_omDeleteOrderItemBtn1ActionPerformed

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
            java.util.logging.Logger.getLogger(OrderManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderManage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel OrderManagePanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton omAddOrderItemBtn;
    private javax.swing.JLabel omAddSubtitle;
    private javax.swing.JButton omDeleteOrderItemBtn1;
    private javax.swing.JLabel omDrugLabel;
    private javax.swing.JComboBox<DrugModel> omDrugSelector;
    private javax.swing.JButton omOrderReceivedBtn;
    private javax.swing.JTable omOrdersTable;
    private javax.swing.JTable omPendingOrdersTable;
    private javax.swing.JLabel omPendingSubtitle;
    private javax.swing.JSpinner omQtyInput;
    private javax.swing.JLabel omQtyLabel;
    private javax.swing.JButton omSendFullOrderBtn;
    private javax.swing.JLabel omSupplierLabel;
    private javax.swing.JComboBox<SupplierModel> omSupplierSelector;
    private javax.swing.JLabel omTitleLabel;
    // End of variables declaration//GEN-END:variables
}