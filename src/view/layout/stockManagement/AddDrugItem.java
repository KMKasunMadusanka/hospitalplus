/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.layout.stockManagement;

import Controller.StockManagement.DrugCategoryController;
import Controller.StockManagement.DrugController;
import Controller.StockManagement.DrugTypeController;
import java.sql.SQLException;
import java.util.List;
import model.DrugCategoryModel;
import model.DrugModel;
import model.DrugTypeModel;
import org.apache.log4j.Logger;
import util.Config;
import static util.DBUtil.getXMLData;
import util.Validation;
import static util.messageAlert.getMessageAlert;
import view.EmployeeManagement.LogIn;
import static view.EmployeeManagement.LogIn.UserType;
import view.layout.MainJFrame;

/**
 *
 * @author EnTeRs
 */
public class AddDrugItem extends javax.swing.JFrame {

    private static AddDrugItem self;

    Config cnf = new Config();
    public Logger LOG;

    public AddDrugItem() {
        initComponents();
        self = this;

        //initialize log file
        LOG = cnf.getLogger(AddDrugItem.class);

        getCategoriesInit();
        getTypsInit();

        resetJframe();
    }

    public static AddDrugItem getInstance() {
        if (self == null) {
            self = new AddDrugItem();
        }

        return self;
    }

    public final void resetJframe() {
        util.Util.Clear(AddStockItemPanel);
        asiDrugCatVali.setVisible(false);
        asiDrugNameVali.setVisible(false);
        asiDrugTypeVali.setVisible(false);
        asiDrugPriceVali.setVisible(false);
        asiDrugWeightVali.setVisible(false);
        
        if (LogIn.UserType.equalsIgnoreCase("admin")) {
            
        }
    }

    public final void getCategoriesInit() {
        asiDrugCategorySelector.removeAllItems();

        try {
            List<DrugCategoryModel> drugCategories = DrugCategoryController.getInstance().allDrugCategories();
            for (int c = 0; c < drugCategories.size(); c++) {
                asiDrugCategorySelector.addItem(drugCategories.get(c));
            }
            asiDrugCategorySelector.insertItemAt(new DrugCategoryModel("Select Category", ""), 0);
            asiDrugCategorySelector.setSelectedIndex(0);
        } catch (SQLException ex) {
            LOG.error(ex);
        }
    }

    public final void getTypsInit() {
        asiDrugTypeSelector.removeAllItems();

        try {
            List<DrugTypeModel> drugTypes = DrugTypeController.getInstance().allDrugTypes();
            for (int i = 0; i < drugTypes.size(); ++i) {
                asiDrugTypeSelector.addItem(drugTypes.get(i));
            }
            asiDrugTypeSelector.insertItemAt(new DrugTypeModel("Select Type", ""), 0);
            asiDrugTypeSelector.setSelectedIndex(0);
        } catch (SQLException ex) {
            LOG.error(ex);
        }
    }

    /**
     * *** START Validation Section ****
     */
    public boolean validateCategory() {
        if (asiDrugCategorySelector.getSelectedIndex() != 0) {
            asiDrugCatVali.setVisible(false);
            return true;
        } else {
            asiDrugCatVali.setVisible(true);
            return false;
        }
    }

    public boolean validateName() {
        if (Validation.ContainLetters(asiDrugNameInput.getText())) {
            asiDrugNameVali.setVisible(false);
            return true;
        } else {
            asiDrugNameVali.setVisible(true);
            return false;
        }
    }

    public boolean validateType() {
        if (asiDrugTypeSelector.getSelectedIndex() != 0) {
            asiDrugTypeVali.setVisible(false);
            return true;
        } else {
            asiDrugTypeVali.setVisible(true);
            return false;
        }
    }

    public boolean validatePrice() {
        if (Validation.ContainOnlyNumbers(asiDrugPriceInput.getText())) {
            asiDrugPriceVali.setVisible(false);
            return true;
        } else {
            asiDrugPriceVali.setVisible(true);
            return false;
        }
    }

    public boolean validateWeight() {
        if (Validation.ContainLettersAndNumbers(asiDrugWeightInput.getText())) {
            asiDrugWeightVali.setVisible(false);
            return true;
        } else {
            asiDrugWeightVali.setVisible(true);
            return false;
        }
    }
    /**
     * *** END Validation Section ****
     */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AddStockItemPanel = new javax.swing.JPanel();
        asiTitleLabel = new javax.swing.JLabel();
        asiDrugCategoryLabel = new javax.swing.JLabel();
        asiDrugCategorySelector = new javax.swing.JComboBox<>();
        asiDrugNameLabel = new javax.swing.JLabel();
        asiDrugNameInput = new javax.swing.JTextField();
        asiDrugTypeLabel = new javax.swing.JLabel();
        asiDrugTypeSelector = new javax.swing.JComboBox<>();
        asiDrugPriceLabel = new javax.swing.JLabel();
        asiDrugPriceInput = new javax.swing.JTextField();
        asiRemarksInput = new javax.swing.JTextField();
        asiRemarksLabel = new javax.swing.JLabel();
        asiDrugLevelInput = new javax.swing.JSpinner();
        asiDrugLevelLabel = new javax.swing.JLabel();
        asiReorderLevelInput = new javax.swing.JSpinner();
        asiReorderLevelLabel = new javax.swing.JLabel();
        asiDrugWeightInput = new javax.swing.JTextField();
        asiResetBtn = new javax.swing.JButton();
        asiInsertBtn = new javax.swing.JButton();
        asiDrugWeightLabel1 = new javax.swing.JLabel();
        asiUpdateRemoveCatBtn = new javax.swing.JButton();
        asiAddCatBtn = new javax.swing.JButton();
        asiAddTypeBtn = new javax.swing.JButton();
        asiUpdateRemoveTypeBtn = new javax.swing.JButton();
        asiDrugWeightVali = new javax.swing.JLabel();
        asiDrugPriceVali = new javax.swing.JLabel();
        asiDrugNameVali = new javax.swing.JLabel();
        asiDrugTypeVali = new javax.swing.JLabel();
        asiDrugCatVali = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(1765, 770));
        getContentPane().setLayout(null);

        AddStockItemPanel.setBackground(new java.awt.Color(0, 0, 0));
        AddStockItemPanel.setMaximumSize(new java.awt.Dimension(1765, 770));
        AddStockItemPanel.setMinimumSize(new java.awt.Dimension(1765, 770));
        AddStockItemPanel.setLayout(null);

        asiTitleLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        asiTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        asiTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        asiTitleLabel.setText("Add New Drug");
        AddStockItemPanel.add(asiTitleLabel);
        asiTitleLabel.setBounds(0, 30, 1760, 50);

        asiDrugCategoryLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        asiDrugCategoryLabel.setForeground(new java.awt.Color(255, 255, 255));
        asiDrugCategoryLabel.setText("Drug Category");
        AddStockItemPanel.add(asiDrugCategoryLabel);
        asiDrugCategoryLabel.setBounds(160, 170, 200, 30);

        asiDrugCategorySelector.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                asiDrugCategorySelectorItemStateChanged(evt);
            }
        });
        AddStockItemPanel.add(asiDrugCategorySelector);
        asiDrugCategorySelector.setBounds(380, 170, 300, 30);

        asiDrugNameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        asiDrugNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        asiDrugNameLabel.setText("Drug Name");
        AddStockItemPanel.add(asiDrugNameLabel);
        asiDrugNameLabel.setBounds(160, 240, 200, 30);

        asiDrugNameInput.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                asiDrugNameInputCaretUpdate(evt);
            }
        });
        AddStockItemPanel.add(asiDrugNameInput);
        asiDrugNameInput.setBounds(380, 240, 300, 30);

        asiDrugTypeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        asiDrugTypeLabel.setForeground(new java.awt.Color(255, 255, 255));
        asiDrugTypeLabel.setText("Drug Type");
        AddStockItemPanel.add(asiDrugTypeLabel);
        asiDrugTypeLabel.setBounds(160, 310, 200, 30);

        asiDrugTypeSelector.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                asiDrugTypeSelectorItemStateChanged(evt);
            }
        });
        AddStockItemPanel.add(asiDrugTypeSelector);
        asiDrugTypeSelector.setBounds(380, 310, 300, 30);

        asiDrugPriceLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        asiDrugPriceLabel.setForeground(new java.awt.Color(255, 255, 255));
        asiDrugPriceLabel.setText("Drug Price");
        AddStockItemPanel.add(asiDrugPriceLabel);
        asiDrugPriceLabel.setBounds(160, 380, 200, 30);

        asiDrugPriceInput.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                asiDrugPriceInputCaretUpdate(evt);
            }
        });
        AddStockItemPanel.add(asiDrugPriceInput);
        asiDrugPriceInput.setBounds(380, 380, 300, 30);
        AddStockItemPanel.add(asiRemarksInput);
        asiRemarksInput.setBounds(1310, 170, 300, 30);

        asiRemarksLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        asiRemarksLabel.setForeground(new java.awt.Color(255, 255, 255));
        asiRemarksLabel.setText("Remarks");
        AddStockItemPanel.add(asiRemarksLabel);
        asiRemarksLabel.setBounds(1090, 170, 200, 30);

        asiDrugLevelInput.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        AddStockItemPanel.add(asiDrugLevelInput);
        asiDrugLevelInput.setBounds(1310, 240, 300, 30);

        asiDrugLevelLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        asiDrugLevelLabel.setForeground(new java.awt.Color(255, 255, 255));
        asiDrugLevelLabel.setText("Drug Level");
        AddStockItemPanel.add(asiDrugLevelLabel);
        asiDrugLevelLabel.setBounds(1090, 240, 200, 30);

        asiReorderLevelInput.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        AddStockItemPanel.add(asiReorderLevelInput);
        asiReorderLevelInput.setBounds(1310, 310, 300, 30);

        asiReorderLevelLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        asiReorderLevelLabel.setForeground(new java.awt.Color(255, 255, 255));
        asiReorderLevelLabel.setText("Reorder Level");
        AddStockItemPanel.add(asiReorderLevelLabel);
        asiReorderLevelLabel.setBounds(1090, 310, 200, 30);

        asiDrugWeightInput.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                asiDrugWeightInputCaretUpdate(evt);
            }
        });
        AddStockItemPanel.add(asiDrugWeightInput);
        asiDrugWeightInput.setBounds(1310, 380, 300, 30);

        asiResetBtn.setText("Reset");
        asiResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiResetBtnActionPerformed(evt);
            }
        });
        AddStockItemPanel.add(asiResetBtn);
        asiResetBtn.setBounds(900, 670, 200, 40);

        asiInsertBtn.setText("Insert");
        asiInsertBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiInsertBtnActionPerformed(evt);
            }
        });
        AddStockItemPanel.add(asiInsertBtn);
        asiInsertBtn.setBounds(620, 670, 200, 40);

        asiDrugWeightLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        asiDrugWeightLabel1.setForeground(new java.awt.Color(255, 255, 255));
        asiDrugWeightLabel1.setText("Drug Weight");
        AddStockItemPanel.add(asiDrugWeightLabel1);
        asiDrugWeightLabel1.setBounds(1090, 380, 200, 30);

        asiUpdateRemoveCatBtn.setText("Update/Remove Selected");
        asiUpdateRemoveCatBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiUpdateRemoveCatBtnActionPerformed(evt);
            }
        });
        AddStockItemPanel.add(asiUpdateRemoveCatBtn);
        asiUpdateRemoveCatBtn.setBounds(840, 170, 190, 30);

        asiAddCatBtn.setText("Add New");
        asiAddCatBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiAddCatBtnActionPerformed(evt);
            }
        });
        AddStockItemPanel.add(asiAddCatBtn);
        asiAddCatBtn.setBounds(740, 170, 90, 30);

        asiAddTypeBtn.setText("Add New");
        asiAddTypeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiAddTypeBtnActionPerformed(evt);
            }
        });
        AddStockItemPanel.add(asiAddTypeBtn);
        asiAddTypeBtn.setBounds(740, 310, 90, 30);

        asiUpdateRemoveTypeBtn.setText("Update/Remove Selected");
        asiUpdateRemoveTypeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asiUpdateRemoveTypeBtnActionPerformed(evt);
            }
        });
        AddStockItemPanel.add(asiUpdateRemoveTypeBtn);
        asiUpdateRemoveTypeBtn.setBounds(840, 310, 190, 30);

        asiDrugWeightVali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/common/Wrong.png"))); // NOI18N
        AddStockItemPanel.add(asiDrugWeightVali);
        asiDrugWeightVali.setBounds(1640, 380, 30, 30);

        asiDrugPriceVali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/common/Wrong.png"))); // NOI18N
        AddStockItemPanel.add(asiDrugPriceVali);
        asiDrugPriceVali.setBounds(710, 380, 30, 30);

        asiDrugNameVali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/common/Wrong.png"))); // NOI18N
        AddStockItemPanel.add(asiDrugNameVali);
        asiDrugNameVali.setBounds(710, 240, 30, 30);

        asiDrugTypeVali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/common/Wrong.png"))); // NOI18N
        AddStockItemPanel.add(asiDrugTypeVali);
        asiDrugTypeVali.setBounds(710, 310, 30, 30);

        asiDrugCatVali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/common/Wrong.png"))); // NOI18N
        AddStockItemPanel.add(asiDrugCatVali);
        asiDrugCatVali.setBounds(710, 170, 30, 30);

        getContentPane().add(AddStockItemPanel);
        AddStockItemPanel.setBounds(0, 0, 1765, 770);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void asiInsertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiInsertBtnActionPerformed
        if (validateCategory() & validateName() & validateType() & validatePrice() & validateWeight()) {
            DrugCategoryModel selectedDrugCategory = (DrugCategoryModel) asiDrugCategorySelector.getSelectedItem();
            DrugTypeModel selectedDrugType = (DrugTypeModel) asiDrugTypeSelector.getSelectedItem();
            try {
                DrugModel drug = new DrugModel(asiDrugNameInput.getText(),
                        selectedDrugCategory.getId(),
                        selectedDrugType.getId(),
                        Integer.parseInt(asiDrugPriceInput.getText()),
                        asiRemarksInput.getText(),
                        Integer.parseInt(asiDrugLevelInput.getValue().toString()),
                        Integer.parseInt(asiReorderLevelInput.getValue().toString()),
                        asiDrugWeightInput.getText());
                DrugController.getInstance().save(drug);
                getMessageAlert(String.format(getXMLData("StockMsg", "message", "addedMsg"), "Drug"), "success");
                resetJframe();
            } catch (SQLException ex) {
                getMessageAlert(getXMLData("StockMsg", "message", "somethingWrong"), "error");
                LOG.error(ex);
            }
        }
    }//GEN-LAST:event_asiInsertBtnActionPerformed

    private void asiResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiResetBtnActionPerformed
        resetJframe();
    }//GEN-LAST:event_asiResetBtnActionPerformed

    private void asiDrugNameInputCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_asiDrugNameInputCaretUpdate
        validateName();
    }//GEN-LAST:event_asiDrugNameInputCaretUpdate

    private void asiDrugPriceInputCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_asiDrugPriceInputCaretUpdate
        validatePrice();
    }//GEN-LAST:event_asiDrugPriceInputCaretUpdate

    private void asiAddCatBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiAddCatBtnActionPerformed
        AddDrugCategory.getInstance().setVisible(true);
        MainJFrame.getInstance().GuiMainFrame.setEnabled(false);
        //this.setEnabled(false);
    }//GEN-LAST:event_asiAddCatBtnActionPerformed

    private void asiAddTypeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiAddTypeBtnActionPerformed
        new AddDrugType().setVisible(true);
        MainJFrame.getInstance().GuiMainFrame.setEnabled(false);
        //this.setEnabled(false);
    }//GEN-LAST:event_asiAddTypeBtnActionPerformed

    private void asiDrugCategorySelectorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_asiDrugCategorySelectorItemStateChanged
        validateCategory();
        if (asiDrugCategorySelector.getSelectedIndex() > 0 && LogIn.UserType.equalsIgnoreCase("admin")) {
            asiUpdateRemoveCatBtn.setEnabled(true);
        } else {
            asiUpdateRemoveCatBtn.setEnabled(false);
        }
    }//GEN-LAST:event_asiDrugCategorySelectorItemStateChanged

    private void asiDrugTypeSelectorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_asiDrugTypeSelectorItemStateChanged
        validateType();
        if (asiDrugTypeSelector.getSelectedIndex() > 0 && LogIn.UserType.equalsIgnoreCase("admin")) {
            asiUpdateRemoveTypeBtn.setEnabled(true);
        } else {
            asiUpdateRemoveTypeBtn.setEnabled(false);
        }
    }//GEN-LAST:event_asiDrugTypeSelectorItemStateChanged

    private void asiDrugWeightInputCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_asiDrugWeightInputCaretUpdate
        validateWeight();
    }//GEN-LAST:event_asiDrugWeightInputCaretUpdate

    private void asiUpdateRemoveCatBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiUpdateRemoveCatBtnActionPerformed
        new UpdateRemoveDrugCategory((DrugCategoryModel) asiDrugCategorySelector.getSelectedItem()).setVisible(true);
        MainJFrame.getInstance().GuiMainFrame.setEnabled(false);
    }//GEN-LAST:event_asiUpdateRemoveCatBtnActionPerformed

    private void asiUpdateRemoveTypeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asiUpdateRemoveTypeBtnActionPerformed
        new UpdateRemoveDrugType((DrugTypeModel) asiDrugTypeSelector.getSelectedItem()).setVisible(true);
        MainJFrame.getInstance().GuiMainFrame.setEnabled(false);
    }//GEN-LAST:event_asiUpdateRemoveTypeBtnActionPerformed

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
            java.util.logging.Logger.getLogger(AddDrugItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddDrugItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddDrugItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddDrugItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddDrugItem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddStockItemPanel;
    private javax.swing.JButton asiAddCatBtn;
    private javax.swing.JButton asiAddTypeBtn;
    public javax.swing.JLabel asiDrugCatVali;
    private javax.swing.JLabel asiDrugCategoryLabel;
    private javax.swing.JComboBox<DrugCategoryModel> asiDrugCategorySelector;
    private javax.swing.JSpinner asiDrugLevelInput;
    private javax.swing.JLabel asiDrugLevelLabel;
    private javax.swing.JTextField asiDrugNameInput;
    private javax.swing.JLabel asiDrugNameLabel;
    private javax.swing.JLabel asiDrugNameVali;
    private javax.swing.JTextField asiDrugPriceInput;
    private javax.swing.JLabel asiDrugPriceLabel;
    private javax.swing.JLabel asiDrugPriceVali;
    private javax.swing.JLabel asiDrugTypeLabel;
    private javax.swing.JComboBox<DrugTypeModel> asiDrugTypeSelector;
    public javax.swing.JLabel asiDrugTypeVali;
    private javax.swing.JTextField asiDrugWeightInput;
    private javax.swing.JLabel asiDrugWeightLabel1;
    private javax.swing.JLabel asiDrugWeightVali;
    private javax.swing.JButton asiInsertBtn;
    private javax.swing.JTextField asiRemarksInput;
    private javax.swing.JLabel asiRemarksLabel;
    private javax.swing.JSpinner asiReorderLevelInput;
    private javax.swing.JLabel asiReorderLevelLabel;
    private javax.swing.JButton asiResetBtn;
    private javax.swing.JLabel asiTitleLabel;
    private javax.swing.JButton asiUpdateRemoveCatBtn;
    private javax.swing.JButton asiUpdateRemoveTypeBtn;
    // End of variables declaration//GEN-END:variables
}
