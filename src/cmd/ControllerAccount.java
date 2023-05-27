/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cmd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import db.ConnectionManager;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControllerAccount {
    public List<Account> getAllAccount() {
        List<Account> lsAcc = new ArrayList<>();
        String query = "SELECT * FROM Account";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                int ID_pelanggan = rs.getInt("ID_pelanggan");
                String nama = rs.getString("nama");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String tipe = rs.getString("tipe");
                Account account = new Account(ID_pelanggan, nama, username, password, tipe);
                lsAcc.add(account);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerAccount.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conMan.logOff();
        }
        return lsAcc;
    }

    public int saveAccount(Account account) {
        int hasil = 0;
        String query = "INSERT INTO account(ID_pelanggan, nama, username, password, tipe) VALUES("
                + "'" + account.getID_pelanggan() + "', "
                + "'" + account.getNama() + "', "
                + "'" + account.getUsername() + "', "
                + "'" + account.getPassword() + "', "
                + "'" + account.getTipe() + "')";

        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerAccount.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conMan.logOff();
        }
        return hasil;
    }

    public int deleteAccount(int ID_pelanggan) {
        int hasil = 0;
        String query = "DELETE FROM account WHERE ID_pelanggan='" + ID_pelanggan + "'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerAccount.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conMan.logOff();
        }
        return hasil;
    }

    public int updateAccount(Account account) {
        int hasil = 0;
        // inisialisasi array dan variable
        String[] attribut = {"Nama", "Username", "password", "Tipe"};
//        String ID_pelanggan;

        // membuat JOptionPane sebagai interface pengubahan data
//        ID_pelanggan = JOptionPane.showInputDialog(null, "Masukkan ID pelanggan yang akan diubah", "Update data", JOptionPane.PLAIN_MESSAGE);


        String ID_pelanggan, attribute, value;
        attribute = "";
        value = "";

        ID_pelanggan = JOptionPane.showInputDialog(null, "Masukkan ID pelanggan yang akan diubah", "Update data", JOptionPane.PLAIN_MESSAGE);
        Integer opsi = JOptionPane.showOptionDialog(null, "Pilih atribut yang ingin diubah", "Ubah Data", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, attribut, attribut[0]);

       

        if (ID_pelanggan != null && value != null) {
            // All input fields are filled
            account.setID_pelanggan(Integer.parseInt(ID_pelanggan));
            

            switch (opsi) {
                case 0:
                    attribute = "nama";
                    break;
                case 1:
                    attribute = "username";
                    break;
                case 2:
                    attribute = "password";
                    break;
                case 3:
                    attribute = "tipe";
                    break;
                default:
                    break;
            }

            value = JOptionPane.showInputDialog("Masukkan data baru " + attribute);
            
        } else {
            // User canceled input or left input fields empty
            JOptionPane.showMessageDialog(null, "Pengubahan data dibatalkan atau terdapat field yang kosong.", "Canceled or Empty Fields", JOptionPane.INFORMATION_MESSAGE);
        }
        
        // query command SQL
        String query = "UPDATE account set "+attribute+"='"+value+"' WHERE ID_pelanggan='"+ID_pelanggan+"'";
        
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerAccount.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conMan.logOff();
        }
        return hasil;
    }
}
