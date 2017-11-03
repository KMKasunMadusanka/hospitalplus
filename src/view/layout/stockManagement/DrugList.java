/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.layout.stockManagement;

import Controller.StockManagement.DrugController;
import Controller.StockManagement.OrderController;
import java.awt.Color;
import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.DrugModel;
import model.OrderModel;
import org.apache.log4j.Logger;
import util.Config;
import static util.DBUtil.getXMLData;
import util.Util;
import static util.messageAlert.getMessageAlert;

/**
 *
 * @author EnTeRs
 */
public class DrugList extends javax.swing.JFrame {

    private static DrugList self;

    Config cnf = new Config();
    public Logger LOG;

    private List<Integer> qtyLowRows = new ArrayList<>();

    public DrugList() {
        initComponents();
        self = this;

        //initialize log file
        LOG = cnf.getLogger(DrugList.class);

        resetJframe();
        getDrugsInit();
        setupDrugTable();
    }

    public static DrugList getInstance() {
        if (self == null) {
            self = new DrugList();
        }

        return self;
    }

    public final void resetJframe() {
        util.Util.Clear(DrugListPanel);
        dlUpdateSelectedBtn.setEnabled(false);
        dlDeleteSelectedBtn.setEnabled(false);
    }

    public class MonCellRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value,
                    isSelected, hasFocus, row, column);

            if (column == 9 && qtyLowRows.contains(row)) {
                System.out.println(column);
                System.out.println(row);
                setBackground(Color.RED);
            } else if (isSelected) {
                setBackground(Color.BLUE);
                setForeground(Color.WHITE);
            } else {
                setBackground(Color.WHITE);
                setForeground(Color.BLACK);
            }
            return this;
        }
    }

    public void setupDrugTable() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        //dlDrugTable.setDefaultRenderer(String.class, centerRenderer);

        ((DefaultTableCellRenderer) dlDrugTable.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);

        dlDrugTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        Util.resizeColumnWidth(dlDrugTable);
        dlDrugTable.setDefaultRenderer(Object.class, new MonCellRenderer());
    }

    public void getDrugsInit() {
        try {
            DefaultTableModel model = (DefaultTableModel) dlDrugTable.getModel();
            model.setRowCount(0);
            List<DrugModel> drugs = DrugController.getInstance().allDrugs();
            for (int r = 0; r < drugs.size(); r++) {
                Object[] row = {drugs.get(r).getId(),
                    drugs.get(r).getName(),
                    drugs.get(r).getCategory(),
                    drugs.get(r).getType(),
                    drugs.get(r).getPrice(),
                    drugs.get(r).getRemarks(),
                    drugs.get(r).getDrugLevel(),
                    drugs.get(r).getReorderLevel(),
                    drugs.get(r).getWeight()};
                model.addRow(row);
            }
        } catch (SQLException ex) {
            LOG.error(ex);
        }

        for (int z = 0; z < dlDrugTable.getRowCount(); z++) {
            dlDrugTable.setValueAt(0, z, 9);
        }
        try {
            List<OrderModel> orders = OrderController.getInstance().allOrders("false");
            for (int q = 0; q < dlDrugTable.getRowCount(); q++) {
                for (int s = 0; s < orders.size(); s++) {
                    if (dlDrugTable.getValueAt(q, 1).toString().equals(orders.get(s).getDrug())) {
                        int qtyTotal = (int) dlDrugTable.getValueAt(q, 9) + orders.get(s).getQty();
                        dlDrugTable.setValueAt(qtyTotal, q, 9);
                        if ((int) dlDrugTable.getValueAt(q, 7) >= (int) dlDrugTable.getValueAt(q, 9)) {
                            qtyLowRows.add(q);
                        }
                    }
                }
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

        DrugListPanel = new javax.swing.JPanel();
        dlTitleLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dlDrugTable = new javax.swing.JTable();
        dlSearchLabel = new javax.swing.JLabel();
        dlSearchInput = new javax.swing.JTextField();
        dlSearchTypeCheckbox = new javax.swing.JCheckBox();
        dlSearchNameCheckbox = new javax.swing.JCheckBox();
        dlSearchCategoryCheckbox = new javax.swing.JCheckBox();
        dlUpdateSelectedBtn = new javax.swing.JButton();
        dlDeleteSelectedBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(1765, 770));
        setMinimumSize(new java.awt.Dimension(1765, 770));
        setPreferredSize(new java.awt.Dimension(1765, 770));
        getContentPane().setLayout(null);

        DrugListPanel.setBackground(new java.awt.Color(0, 0, 0));
        DrugListPanel.setMaximumSize(new java.awt.Dimension(1765, 770));
        DrugListPanel.setMinimumSize(new java.awt.Dimension(1765, 770));
        DrugListPanel.setLayout(null);

        dlTitleLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        dlTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        dlTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dlTitleLabel.setText("Drug List");
        DrugListPanel.add(dlTitleLabel);
        dlTitleLabel.setBounds(0, 30, 1760, 50);

        dlDrugTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dlDrugTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Category", "Type", "Price(Rs.)", "Remarks", "Danger Level", "Reorder Level", "Weight", "Qty."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dlDrugTable.setRowHeight(20);
        dlDrugTable.getTableHeader().setReorderingAllowed(false);
        dlDrugTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dlDrugTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dlDrugTable);
        if (dlDrugTable.getColumnModel().getColumnCount() > 0) {
            dlDrugTable.getColumnModel().getColumn(0).setMinWidth(20);
            dlDrugTable.getColumnModel().getColumn(0).setPreferredWidth(20);
            dlDrugTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            dlDrugTable.getColumnModel().getColumn(3).setPreferredWidth(30);
            dlDrugTable.getColumnModel().getColumn(4).setPreferredWidth(25);
            dlDrugTable.getColumnModel().getColumn(6).setPreferredWidth(25);
            dlDrugTable.getColumnModel().getColumn(7).setPreferredWidth(25);
            dlDrugTable.getColumnModel().getColumn(8).setPreferredWidth(50);
            dlDrugTable.getColumnModel().getColumn(9).setPreferredWidth(25);
        }

        DrugListPanel.add(jScrollPane1);
        jScrollPane1.setBounds(30, 180, 1710, 480);

        dlSearchLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dlSearchLabel.setForeground(new java.awt.Color(255, 255, 255));
        dlSearchLabel.setText("Search");
        DrugListPanel.add(dlSearchLabel);
        dlSearchLabel.setBounds(30, 120, 120, 30);

        dlSearchInput.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                dlSearchInputCaretUpdate(evt);
            }
        });
        DrugListPanel.add(dlSearchInput);
        dlSearchInput.setBounds(160, 120, 300, 30);

        dlSearchTypeCheckbox.setBackground(new java.awt.Color(0, 0, 0));
        dlSearchTypeCheckbox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dlSearchTypeCheckbox.setForeground(new java.awt.Color(255, 255, 255));
        dlSearchTypeCheckbox.setText("Type");
        DrugListPanel.add(dlSearchTypeCheckbox);
        dlSearchTypeCheckbox.setBounds(700, 120, 90, 30);

        dlSearchNameCheckbox.setBackground(new java.awt.Color(0, 0, 0));
        dlSearchNameCheckbox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dlSearchNameCheckbox.setForeground(new java.awt.Color(255, 255, 255));
        dlSearchNameCheckbox.setText("Name");
        DrugListPanel.add(dlSearchNameCheckbox);
        dlSearchNameCheckbox.setBounds(500, 120, 80, 30);

        dlSearchCategoryCheckbox.setBackground(new java.awt.Color(0, 0, 0));
        dlSearchCategoryCheckbox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dlSearchCategoryCheckbox.setForeground(new java.awt.Color(255, 255, 255));
        dlSearchCategoryCheckbox.setText("Category");
        DrugListPanel.add(dlSearchCategoryCheckbox);
        dlSearchCategoryCheckbox.setBounds(590, 120, 90, 30);

        dlUpdateSelectedBtn.setText("Update");
        dlUpdateSelectedBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlUpdateSelectedBtnActionPerformed(evt);
            }
        });
        DrugListPanel.add(dlUpdateSelectedBtn);
        dlUpdateSelectedBtn.setBounds(1490, 110, 110, 40);

        dlDeleteSelectedBtn.setText("Delete");
        dlDeleteSelectedBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlDeleteSelectedBtnActionPerformed(evt);
            }
        });
        DrugListPanel.add(dlDeleteSelectedBtn);
        dlDeleteSelectedBtn.setBounds(1630, 110, 110, 40);

        getContentPane().add(DrugListPanel);
        DrugListPanel.setBounds(0, 0, 1765, 770);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dlDrugTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dlDrugTableMouseClicked
        if (dlDrugTable.getSelectedRow() > -1) {
            dlUpdateSelectedBtn.setEnabled(true);
            dlDeleteSelectedBtn.setEnabled(true);
        } else {
            dlUpdateSelectedBtn.setEnabled(false);
            dlDeleteSelectedBtn.setEnabled(false);
        }
    }//GEN-LAST:event_dlDrugTableMouseClicked

    private void dlDeleteSelectedBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlDeleteSelectedBtnActionPerformed
        try {
            DrugController.getInstance().remove(Integer.parseInt(
                    dlDrugTable.getValueAt(dlDrugTable.getSelectedRow(), 0).toString()));
            getDrugsInit();
            getMessageAlert(String.format(getXMLData("StockMsg", "message", "removedMsg"), "Drug"), "success");
        } catch (SQLException ex) {
            getMessageAlert(getXMLData("StockMsg", "message", "somethingWrong"), "error");
            LOG.error(ex);
        }
    }//GEN-LAST:event_dlDeleteSelectedBtnActionPerformed

    private void dlUpdateSelectedBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlUpdateSelectedBtnActionPerformed
        DrugModel selectedDrug = new DrugModel(dlDrugTable.getValueAt(dlDrugTable.getSelectedRow(), 1).toString(),
                Integer.parseInt(dlDrugTable.getValueAt(dlDrugTable.getSelectedRow(), 2).toString()),
                Integer.parseInt(dlDrugTable.getValueAt(dlDrugTable.getSelectedRow(), 3).toString()),
                Integer.parseInt(dlDrugTable.getValueAt(dlDrugTable.getSelectedRow(), 4).toString()),
                dlDrugTable.getValueAt(dlDrugTable.getSelectedRow(), 5).toString(),
                Integer.parseInt(dlDrugTable.getValueAt(dlDrugTable.getSelectedRow(), 6).toString()),
                Integer.parseInt(dlDrugTable.getValueAt(dlDrugTable.getSelectedRow(), 7).toString()),
                dlDrugTable.getValueAt(dlDrugTable.getSelectedRow(), 8).toString());
        selectedDrug.setId(Integer.parseInt(dlDrugTable.getValueAt(dlDrugTable.getSelectedRow(), 0).toString()));

        new UpdateDrugItem(selectedDrug).setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_dlUpdateSelectedBtnActionPerformed

    private void dlSearchInputCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_dlSearchInputCaretUpdate
        Util.filterDataFromJTable(dlDrugTable, dlSearchInput.getText());
    }//GEN-LAST:event_dlSearchInputCaretUpdate

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
            java.util.logging.Logger.getLogger(DrugList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DrugList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DrugList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DrugList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DrugList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DrugListPanel;
    private javax.swing.JButton dlDeleteSelectedBtn;
    private javax.swing.JTable dlDrugTable;
    private javax.swing.JCheckBox dlSearchCategoryCheckbox;
    private javax.swing.JTextField dlSearchInput;
    private javax.swing.JLabel dlSearchLabel;
    private javax.swing.JCheckBox dlSearchNameCheckbox;
    private javax.swing.JCheckBox dlSearchTypeCheckbox;
    private javax.swing.JLabel dlTitleLabel;
    private javax.swing.JButton dlUpdateSelectedBtn;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}