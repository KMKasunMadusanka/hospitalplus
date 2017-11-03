/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static util.Util.getIcon;
import static util.Util.getScreenSizrRatio;
import view.layout.stockManagement.AddDrugItem;

/**
 *
 * @author EnTeRs
 */
public class messageAlert {

    static int ScreenW = (int) getScreenSizrRatio()[0];
    static int ScreenH = (int) getScreenSizrRatio()[1];
    static double screenWRatio = getScreenSizrRatio()[2];
    static double screenHRatio = getScreenSizrRatio()[3];

    public static void getMessageAlert(String message, String type) {
        JFrame msgFrame = new JFrame();
        msgFrame.setPreferredSize(new Dimension((int) screenWRatio * 800, (int) screenHRatio * 215));
        msgFrame.setSize((int) screenWRatio * 800, (int) screenHRatio * 215);

        JPanel backgroundPanel = new JPanel(new BorderLayout());

        String backgroundFile = "common/messagebox_error";
        Color typeColor = new Color(0, 39, 106);
        if ("error".equals(type)) {
            backgroundFile = "common/messagebox_error";
            typeColor = new Color(106, 0, 0);
        } else if ("success".equals(type)) {
            backgroundFile = "common/messagebox_success";
            typeColor = new Color(0, 39, 106);
        }
        Image resizedBackgroundImg = getIcon(messageAlert.class, backgroundFile).getImage()
                .getScaledInstance((int) (screenWRatio * 800),
                        (int) (screenHRatio * 215), java.awt.Image.SCALE_SMOOTH);
        ImageIcon resizedBackgroundImgIcon = new ImageIcon(resizedBackgroundImg);

        JLabel backgroundImgLabel = new JLabel();
        backgroundImgLabel.setIcon(resizedBackgroundImgIcon);
        backgroundPanel.add(backgroundImgLabel, BorderLayout.NORTH);

        JPanel msgPanel = new JPanel();
        msgPanel.setLayout(null);
        msgPanel.setSize((int) screenWRatio * 800, (int) screenHRatio * 215);
        msgPanel.setOpaque(false);
        
        JLabel messageLabel = new JLabel("<html>"+message+"</html>");
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setFont(new Font("", Font.PLAIN, 15));
        JButton okBtn = new JButton("OK");
        okBtn.requestFocus();
        okBtn.setBackground(typeColor);
        okBtn.setForeground(Color.WHITE);

        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                msgFrame.dispose();
            }
        });
        
        msgPanel.add(messageLabel);
        msgPanel.add(okBtn);

        messageLabel.setLocation((int) screenWRatio * 300, (int) screenHRatio * 55);
        okBtn.setLocation((int) screenWRatio * 400, (int) screenHRatio * 145);

        messageLabel.setSize((int) screenWRatio * 450, (int) screenHRatio * 100);
        okBtn.setSize((int) screenWRatio * 200, (int) screenHRatio * 35);

        msgFrame.add(msgPanel);
        msgFrame.add(backgroundPanel);
        msgFrame.getRootPane().setDefaultButton(okBtn);
        msgFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        msgFrame.setUndecorated(true);
        msgFrame.setVisible(true);
        msgFrame.setResizable(false);
        msgFrame.pack();
        msgFrame.setLocation((ScreenW - msgFrame.getWidth()) / 2, 
                (ScreenH - msgFrame.getHeight()) / 2);
        msgFrame.show();
    }
    
    private void formWindowClosed(java.awt.event.WindowEvent evt) {
        AddDrugItem.getInstance().setEnabled(true);
        AddDrugItem.getInstance().toFront();
    }
}