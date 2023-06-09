/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import cmd.ControllerRegister;

/**
 *
 * @author user
 */
public class RegisterPage extends javax.swing.JFrame {

    /**
     * Creates new form RegisterPage
     */
    public RegisterPage() {
        initComponents();
        setDecorImage();
    }

    private void setDecorImage(){
        ImageIcon image = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/projectcoffeeshop/img/decor.png")));
        Image img1 = image.getImage();
        Image img2 = img1.getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_DEFAULT);
        ImageIcon i = new ImageIcon(img2);
        jLabel2.setIcon(i);
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_confpassword = new javax.swing.JTextField();
        tf_nama = new javax.swing.JTextField();
        tf_username = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tf_password = new javax.swing.JTextField();
        finish_btn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 102));

        jLabel1.setFont(new java.awt.Font("Futura", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Register Account");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabel1)
                .addContainerGap(137, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, -1));

        jPanel2.setBackground(new java.awt.Color(255, 204, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Futura", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Please fill the form below to register!");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 25, -1, -1));

        jLabel4.setFont(new java.awt.Font("Futura", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Name");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel5.setFont(new java.awt.Font("Futura", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Confirm Pass");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        jLabel6.setFont(new java.awt.Font("Futura", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Username");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));
        jPanel2.add(tf_confpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 180, -1));
        jPanel2.add(tf_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 180, -1));
        jPanel2.add(tf_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 180, -1));

        jLabel7.setFont(new java.awt.Font("Futura", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Password");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));
        jPanel2.add(tf_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 180, -1));

        finish_btn.setBackground(new java.awt.Color(255, 153, 51));
        finish_btn.setFont(new java.awt.Font("Futura Bk BT", 0, 12)); // NOI18N
        finish_btn.setForeground(new java.awt.Color(255, 255, 255));
        finish_btn.setText("Finish");
        finish_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finish_btnActionPerformed(evt);
            }
        });
        jPanel2.add(finish_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, 90, 35));

        jButton3.setBackground(new java.awt.Color(255, 153, 102));
        jButton3.setFont(new java.awt.Font("Futura Bk BT", 0, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Return");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 90, 35));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 126, 430, 460));

        jPanel3.setBackground(new java.awt.Color(255, 153, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectcoffeeshop/img/decor.png"))); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(120, 120));
        jLabel2.setMinimumSize(new java.awt.Dimension(300, 300));
        jLabel2.setPreferredSize(new java.awt.Dimension(200, 200));
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 210, 170));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 585, 430, 180));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void finish_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finish_btnActionPerformed
        String name = tf_nama.getText();
        String username = tf_username.getText();
        String password = tf_password.getText();
        String confirmPassword = tf_confpassword.getText();

        ControllerRegister ctrl = new ControllerRegister();
        int result = ctrl.registerUser(name, username, password, confirmPassword);
        LoginCoffee login = new LoginCoffee();

        switch (result) {
            case -1:
                JOptionPane.showMessageDialog(this, "Please fill in all the fields", "Error", JOptionPane.ERROR_MESSAGE);
                break;
            case -2:
                JOptionPane.showMessageDialog(this, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
                break;
            case -3:
                break;
            case 0:
                JOptionPane.showMessageDialog(this, "Failed to register user", "Error", JOptionPane.ERROR_MESSAGE);
                break;
            default:
                JOptionPane.showMessageDialog(this, "Registration successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                login.setVisible(true);
                break;
        }

        
    }//GEN-LAST:event_finish_btnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
        LoginCoffee login = new LoginCoffee();
        login.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton finish_btn;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField tf_confpassword;
    private javax.swing.JTextField tf_nama;
    private javax.swing.JTextField tf_password;
    private javax.swing.JTextField tf_username;
    // End of variables declaration//GEN-END:variables
}
