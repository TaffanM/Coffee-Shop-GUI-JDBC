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
/**
 *
 * @author user
 */
public class ControllerLogin {
    
    public boolean autentikasi(String username, String password){
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
                
                if (dbUsername.equals("admin") && dbPassword.equals("morningadm")) {
                    return true;
                }
            }
            
            return false;
        } catch (SQLException e){
            Logger.getLogger(LoginCoffee.class.getName()).log(Level.SEVERE, null, e);
            return false;
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
