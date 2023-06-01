/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cmd;


import javax.swing.JOptionPane;
import model.Account;

/**
 *
 * @author user
 */
public class ControllerRegister {
     public int registerUser(String name, String username, String password, String confirmPassword) {
        if (name.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            return -1;
        } else if (!password.equals(confirmPassword)) {
            return -2; 
        } else {
            int choice = JOptionPane.showConfirmDialog(null, "Are you sure your data is correct?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                String tipe = "user";
                Account acc = new Account(name, username, password, tipe);
                ControllerAccount ctrl = new ControllerAccount();
                return ctrl.saveAccount(acc);
            }
        }
        return -3;
    }
}
