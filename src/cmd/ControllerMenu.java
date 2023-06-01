/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cmd;
import db.ConnectionManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Menu;
/**
 *
 * @author user
 */
public class ControllerMenu {
    public List<Menu> getAllMenu() {
    List<Menu> lsMenu = new ArrayList<>();
    String query = "SELECT * FROM menu";
    ConnectionManager conMan = new ConnectionManager();
    Connection conn = conMan.logOn();
    try {
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(query);
        while (rs.next()) {
            int ID_menu = rs.getInt("ID_menu");
            String nama_menu = rs.getString("nama_menu");
            int harga = rs.getInt("harga");
            int stok = rs.getInt("stok");
            Menu menu = new Menu(ID_menu, nama_menu, harga, stok);
            lsMenu.add(menu);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ControllerMenu.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        conMan.logOff();
    }
    return lsMenu;
}

    public int saveMenu(Menu menu) {
        int hasil = 0;
        String query = "INSERT INTO menu(ID_menu, nama_menu, harga, stok) VALUES("
                + "'" + menu.getID_menu() + "', "
                + "'" + menu.getNama_menu() + "', "
                + "'" + menu.getHarga() + "', "
                + "'" + menu.getStok() + "')";

        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerMenu.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conMan.logOff();
        }
        return hasil;
    }

    public int deleteMenu(int ID_menu) {
        int hasil = 0;
        String query = "DELETE FROM menu WHERE ID_menu='" + ID_menu + "'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerMenu.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conMan.logOff();
        }
        return hasil;
    }

    public int updateMenu(Menu menu) {
        int hasil = 0;
        String[] attributes = {"nama_menu", "harga", "stok"};
        String ID_menu, attribute, value;
        attribute = "";
        value = "";

        ID_menu = JOptionPane.showInputDialog(null, "Enter the menu ID to update", "Update data", JOptionPane.PLAIN_MESSAGE);
        Integer option = JOptionPane.showOptionDialog(null, "Select the attribute to update", "Update Data", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, attributes, attributes[0]);

        if (ID_menu != null && option != null) {
            // All input fields are filled
            menu.setID_menu(Integer.parseInt(ID_menu));

            switch (option) {
                case 0:
                    attribute = "nama_menu";
                    break;
                case 1:
                    attribute = "harga";
                    break;
                case 2:
                    attribute = "stok";
                    break;
                default:
                    break;
            }

            value = JOptionPane.showInputDialog("Enter the new data for " + attribute);
        } else {
            // User canceled input or left input fields empty
            JOptionPane.showMessageDialog(null, "Update data canceled or empty fields.", "Canceled or Empty Fields", JOptionPane.INFORMATION_MESSAGE);
        }

        String query = "UPDATE menu SET " + attribute + "='" + value + "' WHERE ID_menu='" + ID_menu + "'";

        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerMenu.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conMan.logOff();
        }
        return hasil;
    }
}
