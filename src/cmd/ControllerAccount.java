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
        String query = "INSERT INTO Account(ID_pelanggan, nama, username, password, tipe) VALUES("
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
        String query = "DELETE FROM Account WHERE ID_pelanggan='" + ID_pelanggan + "'";
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
        String query = "UPDATE Account SET "
                + "nama='" + account.getNama() + "', "
                + "username='" + account.getUsername() + "', "
                + "password='" + account.getPassword() + "', "
                + "tipe='" + account.getTipe() + "' "
                + "WHERE ID_pelanggan='" + account.getID_pelanggan() + "'";
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
