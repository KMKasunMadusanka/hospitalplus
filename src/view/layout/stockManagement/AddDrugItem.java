/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.layout.stockManagement;

/**
 *
 * @author EnTeRs
 */
public class AddDrugItem extends javax.swing.JFrame {

    /**
     * Creates new form AddStockItem
     */
    public AddDrugItem() {
        initComponents();
    }

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
        jScrollPane1 = new javax.swing.JScrollPane();
        asiFormErrors = new javax.swing.JTextArea();
        asiUpdateRemoveCatBtn = new javax.swing.JButton();
        asiAddCatBtn = new javax.swing.JButton();
        asiAddTypeBtn = new javax.swing.JButton();
        asiUpdateRemoveTypeBtn = new javax.swing.JButton();

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

        asiDrugCategorySelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        AddStockItemPanel.add(asiDrugCategorySelector);
        asiDrugCategorySelector.setBounds(380, 170, 300, 30);

        asiDrugNameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        asiDrugNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        asiDrugNameLabel.setText("Drug Name");
        AddStockItemPanel.add(asiDrugNameLabel);
        asiDrugNameLabel.setBounds(160, 240, 200, 30);

        asiDrugNameInput.setText("jTextField1");
        AddStockItemPanel.add(asiDrugNameInput);
        asiDrugNameInput.setBounds(380, 240, 300, 30);

        asiDrugTypeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        asiDrugTypeLabel.setForeground(new java.awt.Color(255, 255, 255));
        asiDrugTypeLabel.setText("Drug Type");
        AddStockItemPanel.add(asiDrugTypeLabel);
        asiDrugTypeLabel.setBounds(160, 310, 200, 30);

        asiDrugTypeSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        AddStockItemPanel.add(asiDrugTypeSelector);
        asiDrugTypeSelector.setBounds(380, 310, 300, 30);

        asiDrugPriceLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        asiDrugPriceLabel.setForeground(new java.awt.Color(255, 255, 255));
        asiDrugPriceLabel.setText("Drug Price");
        AddStockItemPanel.add(asiDrugPriceLabel);
        asiDrugPriceLabel.setBounds(160, 380, 200, 30);

        asiDrugPriceInput.setText("jTextField1");
        AddStockItemPanel.add(asiDrugPriceInput);
        asiDrugPriceInput.setBounds(380, 380, 300, 30);

        asiRemarksInput.setText("jTextField1");
        AddStockItemPanel.add(asiRemarksInput);
        asiRemarksInput.setBounds(1310, 170, 300, 30);

        asiRemarksLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        asiRemarksLabel.setForeground(new java.awt.Color(255, 255, 255));
        asiRemarksLabel.setText("Remarks");
        AddStockItemPanel.add(asiRemarksLabel);
        asiRemarksLabel.setBounds(1090, 170, 200, 30);
        AddStockItemPanel.add(asiDrugLevelInput);
        asiDrugLevelInput.setBounds(1310, 240, 300, 30);

        asiDrugLevelLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        asiDrugLevelLabel.setForeground(new java.awt.Color(255, 255, 255));
        asiDrugLevelLabel.setText("Drug Level");
        AddStockItemPanel.add(asiDrugLevelLabel);
        asiDrugLevelLabel.setBounds(1090, 240, 200, 30);
        AddStockItemPanel.add(asiReorderLevelInput);
        asiReorderLevelInput.setBounds(1310, 310, 300, 30);

        asiReorderLevelLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        asiReorderLevelLabel.setForeground(new java.awt.Color(255, 255, 255));
        asiReorderLevelLabel.setText("Reorder Level");
        AddStockItemPanel.add(asiReorderLevelLabel);
        asiReorderLevelLabel.setBounds(1090, 310, 200, 30);

        asiDrugWeightInput.setText("jTextField1");
        AddStockItemPanel.add(asiDrugWeightInput);
        asiDrugWeightInput.setBounds(1310, 380, 300, 30);

        asiResetBtn.setText("Reset");
        AddStockItemPanel.add(asiResetBtn);
        asiResetBtn.setBounds(900, 670, 200, 40);

        asiInsertBtn.setText("Insert");
        AddStockItemPanel.add(asiInsertBtn);
        asiInsertBtn.setBounds(620, 670, 200, 40);

        asiDrugWeightLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        asiDrugWeightLabel1.setForeground(new java.awt.Color(255, 255, 255));
        asiDrugWeightLabel1.setText("Drug Weight");
        AddStockItemPanel.add(asiDrugWeightLabel1);
        asiDrugWeightLabel1.setBounds(1090, 380, 200, 30);

        asiFormErrors.setEditable(false);
        asiFormErrors.setBackground(new java.awt.Color(0, 0, 0));
        asiFormErrors.setColumns(20);
        asiFormErrors.setFont(new java.awt.Font("Getone-Reg", 0, 13)); // NOI18N
        asiFormErrors.setForeground(new java.awt.Color(255, 0, 0));
        asiFormErrors.setRows(5);
        asiFormErrors.setText("dfgdfhsfhdfhdhd");
        asiFormErrors.setBorder(null);
        jScrollPane1.setViewportView(asiFormErrors);

        AddStockItemPanel.add(jScrollPane1);
        jScrollPane1.setBounds(620, 476, 480, 120);

        asiUpdateRemoveCatBtn.setText("Update/Remove Selected");
        AddStockItemPanel.add(asiUpdateRemoveCatBtn);
        asiUpdateRemoveCatBtn.setBounds(810, 170, 190, 30);

        asiAddCatBtn.setText("Add New");
        AddStockItemPanel.add(asiAddCatBtn);
        asiAddCatBtn.setBounds(710, 170, 90, 30);

        asiAddTypeBtn.setText("Add New");
        AddStockItemPanel.add(asiAddTypeBtn);
        asiAddTypeBtn.setBounds(710, 310, 90, 30);

        asiUpdateRemoveTypeBtn.setText("Update/Remove Selected");
        AddStockItemPanel.add(asiUpdateRemoveTypeBtn);
        asiUpdateRemoveTypeBtn.setBounds(810, 310, 190, 30);

        getContentPane().add(AddStockItemPanel);
        AddStockItemPanel.setBounds(0, 0, 1765, 770);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JLabel asiDrugCategoryLabel;
    private javax.swing.JComboBox<String> asiDrugCategorySelector;
    private javax.swing.JSpinner asiDrugLevelInput;
    private javax.swing.JLabel asiDrugLevelLabel;
    private javax.swing.JTextField asiDrugNameInput;
    private javax.swing.JLabel asiDrugNameLabel;
    private javax.swing.JTextField asiDrugPriceInput;
    private javax.swing.JLabel asiDrugPriceLabel;
    private javax.swing.JLabel asiDrugTypeLabel;
    private javax.swing.JComboBox<String> asiDrugTypeSelector;
    private javax.swing.JTextField asiDrugWeightInput;
    private javax.swing.JLabel asiDrugWeightLabel1;
    private javax.swing.JTextArea asiFormErrors;
    private javax.swing.JButton asiInsertBtn;
    private javax.swing.JTextField asiRemarksInput;
    private javax.swing.JLabel asiRemarksLabel;
    private javax.swing.JSpinner asiReorderLevelInput;
    private javax.swing.JLabel asiReorderLevelLabel;
    private javax.swing.JButton asiResetBtn;
    private javax.swing.JLabel asiTitleLabel;
    private javax.swing.JButton asiUpdateRemoveCatBtn;
    private javax.swing.JButton asiUpdateRemoveTypeBtn;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}