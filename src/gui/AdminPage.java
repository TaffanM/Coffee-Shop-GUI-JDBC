/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;
import cmd.ControllerAccount;
import cmd.ControllerFeedback;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import model.Account;
import model.Feedback;
/**
 *
 * @author user
 */
public class AdminPage extends javax.swing.JFrame {

    /**
     * Creates new form AdminPage
     */
    public AdminPage() {
        initComponents();
        times();
    }
    
    Timer t;
    SimpleDateFormat st;
    
    private void times() {
        
        
        t = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                Date dt = new Date();
                st = new SimpleDateFormat("hh:mm:ss a");
                
                String tt = st.format(dt);
                lbl_clock.setText(tt);
            }
        });
        t.start();
    }
    
    private void displayAcc() {
        ControllerAccount cmdAcc = new ControllerAccount();
        List<Account> lsAcc = cmdAcc.getAllAccount();
        String[][] dtAcc = new String[lsAcc.size()][5]; // Updated size to [lsAcc.size()][5]
        int i = 0;
        for (Account acc : lsAcc) {
            dtAcc[i][0] = "" + acc.getID_pelanggan();
            dtAcc[i][1] = acc.getNama();
            dtAcc[i][2] = acc.getUsername();
            dtAcc[i][3] = acc.getPassword();
            dtAcc[i][4] = acc.getTipe();
            i++;
        }
        accountTable.setModel(new javax.swing.table.DefaultTableModel(
                dtAcc,
                new String[]{"ID pelanggan", "Nama", "Username", "Password", "Tipe"}
        ));
    }
    
    private void displayFeed() {
        ControllerFeedback cmdFeed = new ControllerFeedback();
        List<Feedback> lsFeed = cmdFeed.getAllFeedback();
        String[][] dtFeed = new String[lsFeed.size()][5]; // Updated size to [lsAcc.size()][5]
        int i = 0;
        for (Feedback feed : lsFeed) {
            dtFeed[i][0] = "" + feed.getID_feedback();
            dtFeed[i][1] = feed.getName();
            dtFeed[i][2] = feed.getFeedback();
            dtFeed[i][3] = feed.getAddress();
            dtFeed[i][4] = feed.getHandphone();
            i++;
        }
        accountTable2.setModel(new javax.swing.table.DefaultTableModel(
                dtFeed,
                new String[]{"ID feedback", "Name", "Feedback", "Address", "Handphone"}
        ));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        adminTabbed = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        accountTable = new javax.swing.JTable();
        display_btn = new javax.swing.JButton();
        create_btn = new javax.swing.JButton();
        update_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        accountTable1 = new javax.swing.JTable();
        display_btn1 = new javax.swing.JButton();
        create_btn1 = new javax.swing.JButton();
        update_btn1 = new javax.swing.JButton();
        delete_btn1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        accountTable2 = new javax.swing.JTable();
        display_btnFeed = new javax.swing.JButton();
        create_btnFeed = new javax.swing.JButton();
        update_btnFeed = new javax.swing.JButton();
        delete_btnFeed = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        logoff_btn = new javax.swing.JButton();
        menu_btn = new javax.swing.JButton();
        receipt_btn = new javax.swing.JButton();
        lbl_clock = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        accountTable.setForeground(new java.awt.Color(204, 153, 0));
        accountTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Pelanggan", "Nama", "Username", "Password", "Tipe"
            }
        ));
        jScrollPane1.setViewportView(accountTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 604, 472));

        display_btn.setText("Display");
        display_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                display_btnActionPerformed(evt);
            }
        });
        jPanel1.add(display_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 670, 103, 35));

        create_btn.setText("Create");
        create_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_btnActionPerformed(evt);
            }
        });
        jPanel1.add(create_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 670, 103, 35));

        update_btn.setText("Update");
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });
        jPanel1.add(update_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 670, 103, 35));

        delete_btn.setText("Delete");
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });
        jPanel1.add(delete_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 670, 103, 35));

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel1.setText("CRUD Account's Table");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 200, 40));

        adminTabbed.addTab("Account", jPanel1);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        accountTable1.setForeground(new java.awt.Color(204, 153, 0));
        accountTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Menu", "Nama Menu", "Additional", "Harga", "Stok"
            }
        ));
        jScrollPane2.setViewportView(accountTable1);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 604, 472));

        display_btn1.setText("Display");
        display_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                display_btn1ActionPerformed(evt);
            }
        });
        jPanel5.add(display_btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 670, 103, 35));

        create_btn1.setText("Create");
        create_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_btn1ActionPerformed(evt);
            }
        });
        jPanel5.add(create_btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 670, 103, 35));

        update_btn1.setText("Update");
        update_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btn1ActionPerformed(evt);
            }
        });
        jPanel5.add(update_btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 670, 103, 35));

        delete_btn1.setText("Delete");
        delete_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btn1ActionPerformed(evt);
            }
        });
        jPanel5.add(delete_btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 670, 103, 35));

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel2.setText("CRUD Menu's Table");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 200, 40));

        adminTabbed.addTab("Menu", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        accountTable2.setForeground(new java.awt.Color(204, 153, 0));
        accountTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Feedback", "Name", "Feedback", "Address", "Handphone"
            }
        ));
        jScrollPane3.setViewportView(accountTable2);

        jPanel6.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 604, 472));

        display_btnFeed.setText("Display");
        display_btnFeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                display_btnFeedActionPerformed(evt);
            }
        });
        jPanel6.add(display_btnFeed, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 670, 103, 35));

        create_btnFeed.setText("Create");
        create_btnFeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_btnFeedActionPerformed(evt);
            }
        });
        jPanel6.add(create_btnFeed, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 670, 103, 35));

        update_btnFeed.setText("Update");
        update_btnFeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnFeedActionPerformed(evt);
            }
        });
        jPanel6.add(update_btnFeed, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 670, 103, 35));

        delete_btnFeed.setText("Delete");
        delete_btnFeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnFeedActionPerformed(evt);
            }
        });
        jPanel6.add(delete_btnFeed, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 670, 103, 35));

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel3.setText("CRUD Feedback's Table");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 220, 40));

        adminTabbed.addTab("Feedback", jPanel6);

        jPanel2.setBackground(new java.awt.Color(255, 204, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoff_btn.setText("Logoff");
        logoff_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoff_btnActionPerformed(evt);
            }
        });
        jPanel2.add(logoff_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 480, 100, 50));

        menu_btn.setText("Menu");
        menu_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_btnActionPerformed(evt);
            }
        });
        jPanel2.add(menu_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 100, 50));

        receipt_btn.setText("Feedback");
        receipt_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receipt_btnActionPerformed(evt);
            }
        });
        jPanel2.add(receipt_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 100, 50));

        lbl_clock.setBackground(new java.awt.Color(255, 255, 255));
        lbl_clock.setFont(new java.awt.Font("Futura Bk BT", 0, 24)); // NOI18N
        lbl_clock.setForeground(new java.awt.Color(255, 255, 255));
        lbl_clock.setText("0");
        jPanel2.add(lbl_clock, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 170, 60));

        jLabel4.setFont(new java.awt.Font("Futura", 0, 24)); // NOI18N
        jLabel4.setText("Admin Page");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminTabbed, javax.swing.GroupLayout.PREFERRED_SIZE, 1034, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(adminTabbed, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void display_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_display_btnActionPerformed
        displayAcc();
    }//GEN-LAST:event_display_btnActionPerformed

    private void logoff_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoff_btnActionPerformed

        int choice = JOptionPane.showConfirmDialog(null, "Are you sure want to logout?", "Confirmation", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            // User confirmed, navigate back to the login page


            LoginCoffee login = new LoginCoffee();
            login.setVisible(true);


            // Close or hide the current form if needed
            this.dispose();

            JOptionPane.showMessageDialog(rootPane, "You are succesfully logout!");

        } else {
            System.out.println("Pengguna membatalkan logoff");
        }
        
        
    }//GEN-LAST:event_logoff_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        String ID_pelanggan;
        ID_pelanggan = JOptionPane.showInputDialog("Masukkan ID pelanggan yang akan dihapus : ");

        // Convert ID_pelanggan to int
        int ID_pelangganInt = Integer.parseInt(ID_pelanggan);

        ControllerAccount cmdAcc = new ControllerAccount();
        int result = cmdAcc.deleteAccount(ID_pelangganInt);
        
        if (result > 0) {
           displayAcc();
        } else {
           JOptionPane.showMessageDialog(null, "Terjadi kesalahan. Mohon ulang kembali", "Error", JOptionPane.ERROR_MESSAGE);

        }
        
    }//GEN-LAST:event_delete_btnActionPerformed

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
        ControllerAccount cmdAcc = new ControllerAccount();
        Account account = new Account();
        int result = cmdAcc.updateAccount(account);

        if (result > 0) {
            // Account updated successfully
            displayAcc();
        } else {
            // Error occurred while updating account
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan. Mohon ulang kembali", "Error", JOptionPane.ERROR_MESSAGE);
        }
        


    }//GEN-LAST:event_update_btnActionPerformed

    private void create_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_btnActionPerformed
        String nama, username, password, tipe;

        nama = JOptionPane.showInputDialog("Masukkan nama yang diinput : ");
        username = JOptionPane.showInputDialog("Masukkan username yang diinput : ");
        password = JOptionPane.showInputDialog("Masukkan password yang diinput : ");

        String[] choices = {"admin", "user"};
        tipe = (String) JOptionPane.showInputDialog(null, "Pilih tipe akun:", "Dropdown", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);

        if (nama != null && username != null && password != null && tipe != null) {
            // All input fields are filled
            Account account = new Account();
            account.setNama(nama);
            account.setUsername(username);
            account.setPassword(password);
            account.setTipe(tipe);

            ControllerAccount cmdAcc = new ControllerAccount();
            int result = cmdAcc.saveAccount(account);

            if (result > 0) {
                // Account saved successfully
                displayAcc();
            } else {
                // Error occurred while saving account
                JOptionPane.showMessageDialog(null, "Terjadi kesalahan. Mohon ulang kembali", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // User membatalkan input atau meninggalkan textfield kosong
            JOptionPane.showMessageDialog(null, "Pembuatan akun dibatalkan atau textfield kosong.", "Canceled or Empty Fields", JOptionPane.INFORMATION_MESSAGE);
        }
        
        displayAcc();
        
    }//GEN-LAST:event_create_btnActionPerformed

    private void menu_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_btnActionPerformed
        adminTabbed.setSelectedIndex(1);
    }//GEN-LAST:event_menu_btnActionPerformed

    private void receipt_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receipt_btnActionPerformed
        adminTabbed.setSelectedIndex(2);
    }//GEN-LAST:event_receipt_btnActionPerformed

    private void display_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_display_btn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_display_btn1ActionPerformed

    private void create_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_btn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_create_btn1ActionPerformed

    private void update_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_update_btn1ActionPerformed

    private void delete_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delete_btn1ActionPerformed

    private void display_btnFeedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_display_btnFeedActionPerformed
        displayFeed();
    }//GEN-LAST:event_display_btnFeedActionPerformed

    private void create_btnFeedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_btnFeedActionPerformed
        String name, feedback, address, handphone;

        name = JOptionPane.showInputDialog("Masukkan nama yang diinput : ");
        feedback = JOptionPane.showInputDialog("Masukkan feedback yang diinput : ");
        address = JOptionPane.showInputDialog("Masukkan address yang diinput : ");
        handphone = JOptionPane.showInputDialog("Masukkan handphone yang diinput : ");
        
        
        

        if (name != null && feedback != null && address != null && handphone != null) {
            
            Feedback feed = new Feedback();
            feed.setName(name);
            feed.setFeedback(feedback);
            feed.setAddress(address);
            feed.setHandphone(handphone);
            // All input fields are filled
            
            

            ControllerFeedback cmdFeed = new ControllerFeedback();
            int result = cmdFeed.saveFeedback(feed);

            if (result > 0) {
                // Account saved successfully
                displayAcc();
            } else {
                // Error occurred while saving account
                JOptionPane.showMessageDialog(null, "Terjadi kesalahan. Mohon ulang kembali", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // User membatalkan input atau meninggalkan textfield kosong
            JOptionPane.showMessageDialog(null, "Pembuatan akun dibatalkan atau textfield kosong.", "Canceled or Empty Fields", JOptionPane.INFORMATION_MESSAGE);
        }
        
        displayFeed();
    }//GEN-LAST:event_create_btnFeedActionPerformed

    private void update_btnFeedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnFeedActionPerformed
        ControllerFeedback cmdFeedback = new ControllerFeedback();
        Feedback feedback = new Feedback();
        int result = cmdFeedback.updateFeedback(feedback);

        if (result > 0) {
            // Feedback updated successfully
            displayFeed();
        } else {
            // Error occurred while updating feedback
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan. Mohon ulang kembali", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_update_btnFeedActionPerformed

    private void delete_btnFeedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnFeedActionPerformed
        String ID_feedback;
        ID_feedback = JOptionPane.showInputDialog("Masukkan ID feedback yang akan dihapus : ");

        // Convert ID_feedback to int
        int ID_feedbackInt = Integer.parseInt(ID_feedback);

        ControllerFeedback cmdFeedback = new ControllerFeedback();
        int result = cmdFeedback.deleteFeedback(ID_feedbackInt);

        if (result > 0) {
           displayFeed();
        } else {
           JOptionPane.showMessageDialog(null, "Terjadi kesalahan. Mohon ulang kembali", "Error", JOptionPane.ERROR_MESSAGE);
        }   
    }//GEN-LAST:event_delete_btnFeedActionPerformed

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
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable accountTable;
    private javax.swing.JTable accountTable1;
    private javax.swing.JTable accountTable2;
    private javax.swing.JTabbedPane adminTabbed;
    private javax.swing.JButton create_btn;
    private javax.swing.JButton create_btn1;
    private javax.swing.JButton create_btnFeed;
    private javax.swing.JButton delete_btn;
    private javax.swing.JButton delete_btn1;
    private javax.swing.JButton delete_btnFeed;
    private javax.swing.JButton display_btn;
    private javax.swing.JButton display_btn1;
    private javax.swing.JButton display_btnFeed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_clock;
    private javax.swing.JButton logoff_btn;
    private javax.swing.JButton menu_btn;
    private javax.swing.JButton receipt_btn;
    private javax.swing.JButton update_btn;
    private javax.swing.JButton update_btn1;
    private javax.swing.JButton update_btnFeed;
    // End of variables declaration//GEN-END:variables
}
