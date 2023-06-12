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
import javax.swing.Timer;
import model.Account;
import model.OrderAcc;
import gui.ConfirmationPage;
import gui.OrderPage;

public class ControllerOrder {
    public void Order(Account loggedInAccount, JComboBox<String> cb_patiserie, JComboBox<String> qty_patiserie, JComboBox<String> cb_drink, JComboBox<String> qty_drink) {
        
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        ConfirmationPage conf = new ConfirmationPage();
        OrderPage order = new OrderPage();
        
        
        int ID_pelanggan = loggedInAccount.getID_pelanggan();
        
        String pilihPatisserie = cb_patiserie.getSelectedItem().toString();
        String pilihDrink = cb_drink.getSelectedItem().toString();
        
        if (pilihPatisserie.equals("None") && pilihDrink.equals("None")) {
            JOptionPane.showMessageDialog(order, "Please order minimal one of our menu");
            return;
        } else {
            
            int choice = JOptionPane.showConfirmDialog(order, "Are you sure your data is correct?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {

                // Mendapatkan jenis makanan dan kuantitas
                String selectedPatisserie = cb_patiserie.getSelectedItem().toString();
                int patisserieQty = Integer.parseInt(qty_patiserie.getSelectedItem().toString());
                int patisseriePrice = patisseriePriceDatabase(selectedPatisserie, conn);
                
                // Mendapatkan jenis minuman dan kuantitas
                String selectedDrink = cb_drink.getSelectedItem().toString();
                int drinkQty = Integer.parseInt(qty_drink.getSelectedItem().toString());
                int drinkPrice = drinkPriceDatabase(selectedDrink, conn);
                

                int patisserieTotalPrice = patisserieQty * patisseriePrice;
                int drinkTotalPrice = drinkQty * drinkPrice;
                int totalPrice = patisserieTotalPrice + drinkTotalPrice;
                
                
                try {
                    // Mendapatkan stok terakhir di database
                    int patisserieStock = getPatisserieStock(selectedPatisserie, conn);
                    int drinkStock = getDrinkStock(selectedDrink, conn);
                    System.out.println(patisserieStock);
                    System.out.println(drinkStock);
                    // cek apakah stok tersedia
                    if (!pilihPatisserie.equals("None") && patisserieQty > patisserieStock) {
                        JOptionPane.showMessageDialog(order, "Sorry, the selected patisserie is out of stock");
                        return;
                    }
                    if (!pilihDrink.equals("None") && drinkQty > drinkStock) {
                        JOptionPane.showMessageDialog(order, "Sorry, the selected drink is out of stock");
                        return;
                    }

                    
                    // Operasi untuk mengurangi stok
                    int updatedPatisserieStock = patisserieStock - patisserieQty;
                    int updatedDrinkStock = drinkStock - drinkQty;

                    // Update tabel menu dengan stok yang baru
                    updatePatisserieStock(selectedPatisserie, updatedPatisserieStock, conn);
                    updateDrinkStock(selectedDrink, updatedDrinkStock, conn);
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerOrder.class.getName()).log(Level.SEVERE, null, ex);
                }
                
               

                String query = "INSERT INTO order_acc (ID_pelanggan, order_detail, total) VALUES (?, ?, ?)";

                try {
                    // Cek akun sebelum order
                    String accountQuery = "SELECT ID_pelanggan FROM account WHERE ID_pelanggan = ?";
                    PreparedStatement accountPs = conn.prepareStatement(accountQuery);
                    accountPs.setInt(1, ID_pelanggan);
                    ResultSet accountRs = accountPs.executeQuery();
                    if (!accountRs.next()) {
                        JOptionPane.showMessageDialog(null, "Account does not exist!");
                        System.out.println(ID_pelanggan);
                        return;
                    }

                    PreparedStatement ps = conn.prepareStatement(query);
                    ps.setInt(1, ID_pelanggan);
                    ps.setString(2, selectedPatisserie + " - Quantity: " + patisserieQty + ", " + selectedDrink + " - Quantity: " + drinkQty);
                    ps.setInt(3, totalPrice);

                    int baris = ps.executeUpdate();
                    if (baris > 0) {
                        conf.setLocationRelativeTo(order);
                        conf.setVisible(true);
                        Timer timer = new Timer(5000, e -> conf.dispose());
                        timer.setRepeats(false);
                        timer.start();
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to add order!");
                    }

                    // Commit transaksi
                    conn.commit();
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerOrder.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    // tutup koneksi
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
    }
    
    
    
    
    
    // method untuk mendapatkan dan membedakan stok patisserie
    private int getPatisserieStock(String patisserieName, Connection conn) throws SQLException {
        String query = "SELECT stok FROM menu WHERE nama_menu = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, patisserieName);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt("stok");
        }
        return 0;
    }

    // method untuk mendapatkan dan membedakan stok drink
    private int getDrinkStock(String drinkName, Connection conn) throws SQLException {
        String query = "SELECT stok FROM menu WHERE nama_menu = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, drinkName);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt("stok");
        }
        return 0;
    }

    // method untuk update dan membedakan stok patisserie
    private void updatePatisserieStock(String patisserieName, int newStock, Connection conn) throws SQLException {
        String query = "UPDATE menu SET stok = ? WHERE nama_menu = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, newStock);
        ps.setString(2, patisserieName);
        ps.executeUpdate();
    }

    // method untuk update dan membedakan stok drink
    private void updateDrinkStock(String drinkName, int newStock, Connection conn) throws SQLException {
        String query = "UPDATE menu SET stok = ? WHERE nama_menu = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, newStock);
        ps.setString(2, drinkName);
        ps.executeUpdate();
    }

    // method untuk mendapatkan dan membedakan harga patisserie menu
    private int patisseriePriceDatabase(String selectedPatisserie, Connection conn) {
        int patisseriePrice = 0;
        try {
            String query = "SELECT harga FROM menu WHERE nama_menu = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, selectedPatisserie);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                patisseriePrice = rs.getInt("harga");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return patisseriePrice;
    }

    // method untuk mendapatkan dan membedakan harga drink menu
    private int drinkPriceDatabase(String selectedDrink, Connection conn) {
        int drinkPrice = 0;
        try {
            String query = "SELECT harga FROM menu WHERE nama_menu = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, selectedDrink);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                drinkPrice = rs.getInt("harga");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return drinkPrice;
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
                int ID_pelanggan = rs.getInt("ID_pelanggan");
                String orderDetail = rs.getString("order_detail");
                int totalPrice = rs.getInt("total");
                OrderAcc order = new OrderAcc(ID_order, ID_pelanggan, orderDetail, totalPrice);
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
        String query = "INSERT INTO order_acc(ID_pelanggan, order_detail, total) VALUES (?, ?, ?)";

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
        String query = "UPDATE order_acc SET ID_pelanggan = ?, order_detail = ?, total = ? WHERE ID_order = ?";

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
