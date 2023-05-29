/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class Feedback {
    private int ID_feedback;
    private String name;
    private String feedback;
    private String address;
    private String handphone;

    public Feedback() {
    }

    public Feedback(int ID_feedback, String name, String feedback, String address, String handphone) {
        this.ID_feedback = ID_feedback;
        this.name = name;
        this.feedback = feedback;
        this.address = address;
        this.handphone = handphone;
    }

    public int getID_feedback() {
        return ID_feedback;
    }

    public void setID_feedback(int ID_feedback) {
        this.ID_feedback = ID_feedback;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHandphone() {
        return handphone;
    }

    public void setHandphone(String handphone) {
        this.handphone = handphone;
    }

    
    
    
   
}
