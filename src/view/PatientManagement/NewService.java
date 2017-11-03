/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.PatientManagement;

import Controller.PatientManagement.ServiceController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBUtil;
import static util.DBUtil.LOG;
import util.messageAlert;

/**
 *
 * @author Y4SHVINE
 */
public class NewService extends javax.swing.JFrame {

    /**
     * Creates new form NewService
     */
    public NewService() {
        initComponents();
        LOG = org.apache.log4j.Logger.getLogger(NewService.class);
        serviceNameErr.setVisible(false);
    }

    private void changeprop(String Key, String val) {
        try {
            ServiceController.getInstance().setKeyValue(Key, val);
        } catch (IOException ex) {
            messageAlert.getMessageAlert(DBUtil.getXMLData("PatientMsg", "message", "Err_Something_Went_Wrong"), "error");
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

        jPanel1 = new javax.swing.JPanel();
        patientManagementLbl = new javax.swing.JLabel();
        signupFNameLbl2 = new javax.swing.JLabel();
        newServiceType = new javax.swing.JComboBox<>();
        signupFNameLbl3 = new javax.swing.JLabel();
        newServiceName = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        serviceNameErr = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(770, 400));
        setMinimumSize(new java.awt.Dimension(770, 400));
        setPreferredSize(new java.awt.Dimension(770, 400));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(null);

        patientManagementLbl.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        patientManagementLbl.setForeground(new java.awt.Color(255, 255, 255));
        patientManagementLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientManagementLbl.setText("New Service");
        jPanel1.add(patientManagementLbl);
        patientManagementLbl.setBounds(0, 10, 770, 60);

        signupFNameLbl2.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        signupFNameLbl2.setForeground(new java.awt.Color(255, 255, 255));
        signupFNameLbl2.setText("Service Type");
        signupFNameLbl2.setMaximumSize(new java.awt.Dimension(200, 35));
        signupFNameLbl2.setMinimumSize(new java.awt.Dimension(200, 35));
        signupFNameLbl2.setPreferredSize(new java.awt.Dimension(200, 35));
        jPanel1.add(signupFNameLbl2);
        signupFNameLbl2.setBounds(140, 100, 200, 35);

        newServiceType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CheckUp Service", "Operation Service" }));
        jPanel1.add(newServiceType);
        newServiceType.setBounds(340, 100, 300, 35);

        signupFNameLbl3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        signupFNameLbl3.setForeground(new java.awt.Color(255, 255, 255));
        signupFNameLbl3.setText("Service Name");
        signupFNameLbl3.setMaximumSize(new java.awt.Dimension(200, 35));
        signupFNameLbl3.setMinimumSize(new java.awt.Dimension(200, 35));
        signupFNameLbl3.setPreferredSize(new java.awt.Dimension(200, 35));
        jPanel1.add(signupFNameLbl3);
        signupFNameLbl3.setBounds(140, 175, 200, 35);

        newServiceName.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                newServiceNameCaretUpdate(evt);
            }
        });
        jPanel1.add(newServiceName);
        newServiceName.setBounds(340, 175, 300, 35);

        jButton1.setText("Add New Service");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(340, 260, 200, 35);

        serviceNameErr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/common/Wrong.png"))); // NOI18N
        jPanel1.add(serviceNameErr);
        serviceNameErr.setBounds(650, 180, 15, 35);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 770, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!newServiceName.getText().isEmpty()) {
            String Type = newServiceType.getSelectedItem().toString();
            if (Type.equals("CheckUp Service")) {
                changeprop("CheckUpTypes", newServiceName.getText());
            } else if (Type.equals("Operation Service")) {
                changeprop("OperationTypes", newServiceName.getText());
            }
            messageAlert.getMessageAlert(DBUtil.getXMLData("PatientMsg", "message", "Msg_Succesfully_Added"), "success");
        }else{
             serviceNameErr.setVisible(true);
             serviceNameErr.setToolTipText("Can not be Empty");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void newServiceNameCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_newServiceNameCaretUpdate
        if (!newServiceName.getText().isEmpty()) {
            serviceNameErr.setVisible(false);
        }else{
            serviceNameErr.setVisible(true);
        }
    }//GEN-LAST:event_newServiceNameCaretUpdate

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
            java.util.logging.Logger.getLogger(NewService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewService().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField newServiceName;
    private javax.swing.JComboBox<String> newServiceType;
    private javax.swing.JLabel patientManagementLbl;
    private javax.swing.JLabel serviceNameErr;
    private javax.swing.JLabel signupFNameLbl2;
    private javax.swing.JLabel signupFNameLbl3;
    // End of variables declaration//GEN-END:variables
}