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
import model.Feedback;


/**
 *
 * @author user
 */
public class ControllerFeedback {
    public List<Feedback> getAllFeedback() {
    List<Feedback> lsFeedback = new ArrayList<>();
    String query = "SELECT * FROM feedback";
    ConnectionManager conMan = new ConnectionManager();
    Connection conn = conMan.logOn();
    try {
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(query);
        while (rs.next()) {
            int ID_feedback = rs.getInt("ID_feedback");
            String name = rs.getString("name");
            String feedback = rs.getString("feedback");
            String address = rs.getString("address");
            String handphone = rs.getString("handphone");
            Feedback feedbackObj = new Feedback(ID_feedback, name, feedback, address, handphone);
            lsFeedback.add(feedbackObj);
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(ControllerFeedback.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        conMan.logOff();
    }
    return lsFeedback;
}

    public int saveFeedback(Feedback feedback) {
        int hasil = 0;
        String query = "INSERT INTO feedback(ID_feedback, name, feedback, address, handphone) VALUES("
                + "'" + feedback.getID_feedback() + "', "
                + "'" + feedback.getName() + "', "
                + "'" + feedback.getFeedback() + "', "
                + "'" + feedback.getAddress() + "', "
                + "'" + feedback.getHandphone() + "')";

        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerFeedback.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conMan.logOff();
        }
        return hasil;
    }

    public int deleteFeedback(int ID_feedback) {
        int hasil = 0;
        String query = "DELETE FROM feedback WHERE ID_feedback='" + ID_feedback + "'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerFeedback.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conMan.logOff();
        }
        return hasil;
    }

    public int updateFeedback(Feedback feedback) {
        int hasil = 0;
        String[] attributes = {"name", "feedback", "address", "handphone"};
        String ID_feedback, attribute, value;
        attribute = "";
        value = "";

        ID_feedback = JOptionPane.showInputDialog(null, "Enter the feedback ID to update", "Update data", JOptionPane.PLAIN_MESSAGE);
        Integer option = JOptionPane.showOptionDialog(null, "Select the attribute to update", "Update Data", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, attributes, attributes[0]);

        if (ID_feedback != null && option != null) {
            // All input fields are filled
            feedback.setID_feedback(Integer.parseInt(ID_feedback));

            switch (option) {
                case 0:
                    attribute = "name";
                    break;
                case 1:
                    attribute = "feedback";
                    break;
                case 2:
                    attribute = "address";
                    break;
                case 3:
                    attribute = "handphone";
                    break;
                default:
                    break;
            }

            value = JOptionPane.showInputDialog("Enter the new data for " + attribute);

        } else {
            // User canceled input or left input fields empty
            JOptionPane.showMessageDialog(null, "Update data canceled or empty fields.", "Canceled or Empty Fields", JOptionPane.INFORMATION_MESSAGE);
        }

        String query = "UPDATE feedback SET " + attribute + "='" + value + "' WHERE ID_feedback='" + ID_feedback + "'";

        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerFeedback.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conMan.logOff();
        }
        return hasil;
    }

}
