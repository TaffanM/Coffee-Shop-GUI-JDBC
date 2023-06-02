package cmd;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import db.ConnectionManager;
import java.util.ArrayList;
import java.util.List;
import model.Menu;
import model.Account;
import model.OrderAcc;

public class ControllerOrder {
    public void Order(JComboBox<String> cb_patiserie, JComboBox<String> qty_patiserie, JComboBox<String> cb_drink, JComboBox<String> qty_drink) {
        Menu menu = new Menu();
        Account acc = new Account();
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();

        int choice = JOptionPane.showConfirmDialog(null, "Are you sure your data is correct?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            // Mendapatkan jenis makanan dan kuantitas
            String selectedPatisserie = cb_patiserie.getSelectedItem().toString();
            int patisserieQty = Integer.parseInt(qty_patiserie.getSelectedItem().toString());

            // Mendapatkan jenis minuman dan kuantitas
            String selectedDrink = cb_drink.getSelectedItem().toString();
            int drinkQty = Integer.parseInt(qty_drink.getSelectedItem().toString());

            int itemPrice = menu.getHarga();
            int itemStock = menu.getStok();

            int patisserieTotalPrice = patisserieQty * itemPrice;
            int drinkTotalPrice = drinkQty * itemPrice;
            int totalPrice = patisserieTotalPrice + drinkTotalPrice;

            String query = "INSERT INTO order_acc (ID_account, order_detail, total_price) VALUES (?, ?, ?)";

            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, acc.getID_pelanggan());
                ps.setString(2, selectedPatisserie + " - Quantity: " + patisserieQty + ", " + selectedDrink + " - Quantity: " + drinkQty);
                ps.setInt(3, totalPrice);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Order added successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to add order!");
                }

                // Commit the transaction
                conn.commit();
            } catch (SQLException ex) {
                Logger.getLogger(ControllerOrder.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                // Close the connection
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerOrder.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    public List<OrderAcc> getAllOrders() {
        List<OrderAcc> orderList = new ArrayList<>();
        String query = "SELECT * FROM order_acc";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                int ID_order = rs.getInt("ID_order");
                int ID_account = rs.getInt("ID_account");
                String orderDetail = rs.getString("order_detail");
                int totalPrice = rs.getInt("total_price");
                OrderAcc order = new OrderAcc(ID_order, ID_account, orderDetail, totalPrice);
                orderList.add(order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerOrder.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conMan.logOff();
        }
        return orderList;
}

    public int saveOrder(OrderAcc order) {
        int result = 0;
        String query = "INSERT INTO order_acc(ID_account, order_detail, total_price) VALUES (?, ?, ?)";

        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, order.getID_pelanggan());
            ps.setString(2, order.getOrder_detail());
            ps.setInt(3, order.getTotal());

            result = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControllerOrder.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conMan.logOff();
        }
        return result;
    }

    public int deleteOrder(int ID_order) {
        int result = 0;
        String query = "DELETE FROM order_acc WHERE ID_order = ?";

        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, ID_order);

            result = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControllerOrder.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conMan.logOff();
        }
        return result;
    }

    public int updateOrder(OrderAcc order) {
        int result = 0;
        String query = "UPDATE order_acc SET ID_account = ?, order_detail = ?, total_price = ? WHERE ID_order = ?";

        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, order.getID_pelanggan());
            ps.setString(2, order.getOrder_detail());
            ps.setInt(3, order.getTotal());
            ps.setInt(4, order.getID_order());

            result = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControllerOrder.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conMan.logOff();
        }
        return result;
    }

}
