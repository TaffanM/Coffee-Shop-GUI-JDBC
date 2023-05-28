/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cmd;
import db.ConnectionManager;
import gui.AdminPage;
import gui.LoginCoffee;
import gui.MainMenu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Account;
/**
 *
 * @author user
 */
public class ControllerLogin {
    
    public void autentikasi(String username, String password, LoginCoffee login) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        ConnectionManager conMan = new ConnectionManager();

        try {
            connection = conMan.logOn();
            String sql = "SELECT * FROM account WHERE username = ? AND password = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            rs = statement.executeQuery();

            if (rs.next()) {
                String dbUsername = rs.getString("username");
                String dbPassword = rs.getString("password");
                String dbTipe = rs.getString("tipe");

                if (dbTipe.equals("admin") && dbUsername.equals(username) && dbPassword.equals(password)) {
                    login.dispose();
                    // Membuat objek dari page baru
                    AdminPage admin = new AdminPage();
                    // atur visibilitas dari page baru
                    admin.setVisible(true);
                    JOptionPane.showMessageDialog(admin, "You are succesfully login, Welcome " + dbUsername, "Succeed!", JOptionPane.PLAIN_MESSAGE);
                } else if (dbTipe.equals("user") && dbUsername.equals(username) && dbPassword.equals(password)) {
                    login.dispose();
                    MainMenu menu = new MainMenu();
                    menu.setVisible(true);
                    JOptionPane.showMessageDialog(menu, "You are succesfully login, Welcome " + dbUsername, "Succeed!", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Username or password is wrong", "Login failed", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Username or password is wrong", "Login failed", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            Logger.getLogger(LoginCoffee.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    conMan.logOff();
                }
            } catch (SQLException e) {
                Logger.getLogger(LoginCoffee.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }


}
