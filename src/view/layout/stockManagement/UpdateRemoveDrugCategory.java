/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.layout.stockManagement;

import Controller.StockManagement.DrugCategoryController;
import java.sql.SQLException;
import model.DrugCategoryModel;
import org.apache.log4j.Logger;
import util.Config;
import static util.DBUtil.getXMLData;
import static util.Util.getScreenSizrRatio;
import static util.messageAlert.getMessageAlert;

/**
 *
 * @author EnTeRs
 */
public class UpdateRemoveDrugCategory extends javax.swing.JFrame {

    static int ScreenW = (int) getScreenSizrRatio()[0];
    static int ScreenH = (int) getScreenSizrRatio()[1];

    Config cnf = new Config();
    public Logger LOG;

    int selectedDrugCategoryId;

    public UpdateRemoveDrugCategory(DrugCategoryModel drugCategory) {
        initComponents();
        this.setLocation((ScreenW - this.getWidth()) / 2,
                (ScreenH - this.getHeight()) / 2);

        //initialize log file
        LOG = cnf.getLogger(UpdateRemoveDrugCategory.class);

        selectedDrugCategoryId = drugCategory.getId();
        urdcDrugCatNameInput.setText(drugCategory.getName());
        urdcDrugCatDescInput.setText(drugCategory.getDescription());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UpdateRemoveDrugCategoryPanel = new javax.swing.JPanel();
        urdcTitleLabel = new javax.swing.JLabel();
        urdcDrugCatNameLabel = new javax.swing.JLabel();
        urdcUpdateBtn = new javax.swing.JButton();
        urdcCloseBtn = new javax.swing.JButton();
        urdcDrugCatNameInput = new javax.swing.JTextField();
        urdcRemoveBtn = new javax.swing.JButton();
        urdcDrugCatDescLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        urdcDrugCatDescInput = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(800, 400));
        setMinimumSize(new java.awt.Dimension(800, 400));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(null);

        UpdateRemoveDrugCategoryPanel.setBackground(new java.awt.Color(0, 0, 0));
        UpdateRemoveDrugCategoryPanel.setMaximumSize(new java.awt.Dimension(800, 400));
        UpdateRemoveDrugCategoryPanel.setMinimumSize(new java.awt.Dimension(800, 400));
        UpdateRemoveDrugCategoryPanel.setPreferredSize(new java.awt.Dimension(800, 400));
        UpdateRemoveDrugCategoryPanel.setLayout(null);

        urdcTitleLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        urdcTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        urdcTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        urdcTitleLabel.setText("Update/Remove Drug Category");
        UpdateRemoveDrugCategoryPanel.add(urdcTitleLabel);
        urdcTitleLabel.setBounds(0, 30, 800, 50);

        urdcDrugCatNameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        urdcDrugCatNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        urdcDrugCatNameLabel.setText("Drug Category Name");
        UpdateRemoveDrugCategoryPanel.add(urdcDrugCatNameLabel);
        urdcDrugCatNameLabel.setBounds(120, 140, 180, 30);

        urdcUpdateBtn.setText("Update");
        urdcUpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urdcUpdateBtnActionPerformed(evt);
            }
        });
        UpdateRemoveDrugCategoryPanel.add(urdcUpdateBtn);
        urdcUpdateBtn.setBounds(230, 310, 140, 40);

        urdcCloseBtn.setText("X");
        urdcCloseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urdcCloseBtnActionPerformed(evt);
            }
        });
        UpdateRemoveDrugCategoryPanel.add(urdcCloseBtn);
        urdcCloseBtn.setBounds(740, 10, 40, 40);
        UpdateRemoveDrugCategoryPanel.add(urdcDrugCatNameInput);
        urdcDrugCatNameInput.setBounds(310, 140, 300, 30);

        urdcRemoveBtn.setText("Remove");
        urdcRemoveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urdcRemoveBtnActionPerformed(evt);
            }
        });
        UpdateRemoveDrugCategoryPanel.add(urdcRemoveBtn);
        urdcRemoveBtn.setBounds(410, 310, 140, 40);

        urdcDrugCatDescLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        urdcDrugCatDescLabel.setForeground(new java.awt.Color(255, 255, 255));
        urdcDrugCatDescLabel.setText("Description");
        UpdateRemoveDrugCategoryPanel.add(urdcDrugCatDescLabel);
        urdcDrugCatDescLabel.setBounds(120, 200, 180, 30);

        urdcDrugCatDescInput.setColumns(20);
        urdcDrugCatDescInput.setRows(3);
        jScrollPane1.setViewportView(urdcDrugCatDescInput);

        UpdateRemoveDrugCategoryPanel.add(jScrollPane1);
        jScrollPane1.setBounds(310, 200, 300, 70);

        getContentPane().add(UpdateRemoveDrugCategoryPanel);
        UpdateRemoveDrugCategoryPanel.setBounds(0, 0, 800, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void urdcCloseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urdcCloseBtnActionPerformed
        dispose();
    }//GEN-LAST:event_urdcCloseBtnActionPerformed

    private void urdcUpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urdcUpdateBtnActionPerformed
        try {
            DrugCategoryModel drugCategory = new DrugCategoryModel(urdcDrugCatNameInput.getText(), urdcDrugCatDescInput.getText());
            drugCategory.setId(selectedDrugCategoryId);
            DrugCategoryController.getInstance().update(drugCategory);
            AddDrugItem.getInstance().getCategoriesInit();
            AddDrugItem.getInstance().asiDrugCatVali.setVisible(false);
            getMessageAlert(String.format(getXMLData("StockMsg", "message", "updatedMsg"), "Drug Category"), "success");
            dispose();
        } catch (SQLException ex) {
            getMessageAlert(getXMLData("StockMsg", "message", "somethingWrong"), "error");
            LOG.error(ex);
        }
    }//GEN-LAST:event_urdcUpdateBtnActionPerformed

    private void urdcRemoveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urdcRemoveBtnActionPerformed
        try {
            DrugCategoryController.getInstance().remove(selectedDrugCategoryId);
            AddDrugItem.getInstance().getCategoriesInit();
            AddDrugItem.getInstance().asiDrugCatVali.setVisible(false);
            getMessageAlert(String.format(getXMLData("StockMsg", "message", "removedMsg"), "Drug Category"), "success");
            dispose();
        } catch (SQLException ex) {
            getMessageAlert(getXMLData("StockMsg", "message", "somethingWrong"), "error");
            LOG.error(ex);
        }
    }//GEN-LAST:event_urdcRemoveBtnActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        AddDrugItem.getInstance().setEnabled(true);
        AddDrugItem.getInstance().toFront();
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(UpdateRemoveDrugCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateRemoveDrugCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateRemoveDrugCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateRemoveDrugCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DrugCategoryModel drugCategory = null;
                new UpdateRemoveDrugCategory(drugCategory).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel UpdateRemoveDrugCategoryPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton urdcCloseBtn;
    private javax.swing.JTextArea urdcDrugCatDescInput;
    private javax.swing.JLabel urdcDrugCatDescLabel;
    private javax.swing.JTextField urdcDrugCatNameInput;
    private javax.swing.JLabel urdcDrugCatNameLabel;
    private javax.swing.JButton urdcRemoveBtn;
    private javax.swing.JLabel urdcTitleLabel;
    private javax.swing.JButton urdcUpdateBtn;
    // End of variables declaration//GEN-END:variables
}
