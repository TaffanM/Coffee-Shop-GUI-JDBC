/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mac
 */
public class OrderAcc {
    private int ID_order;
    private int ID_pelanggan;
    private String order_detail;
    private int total;

    public OrderAcc() {
    }

    public OrderAcc(int ID_order, int ID_pelanggan, String order_detail, int total) {
        this.ID_order = ID_order;
        this.ID_pelanggan = ID_pelanggan;
        this.order_detail = order_detail;
        this.total = total;
    }

    public int getID_order() {
        return ID_order;
    }

    public void setID_order(int ID_order) {
        this.ID_order = ID_order;
    }

    public int getID_pelanggan() {
        return ID_pelanggan;
    }

    public void setID_pelanggan(int ID_pelanggan) {
        this.ID_pelanggan = ID_pelanggan;
    }

    public String getOrder_detail() {
        return order_detail;
    }

    public void setOrder_detail(String order_detail) {
        this.order_detail = order_detail;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
}
