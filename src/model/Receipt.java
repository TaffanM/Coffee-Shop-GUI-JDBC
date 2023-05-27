/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class Receipt {
    private int ID_receipt;
    private String tipe_pembayaran;
    private int ID_menu;

    public Receipt() {
    }

    public Receipt(int ID_receipt, String tipe_pembayaran, int ID_menu) {
        this.ID_receipt = ID_receipt;
        this.tipe_pembayaran = tipe_pembayaran;
        this.ID_menu = ID_menu;
    }

    public int getID_receipt() {
        return ID_receipt;
    }

    public void setID_receipt(int ID_receipt) {
        this.ID_receipt = ID_receipt;
    }

    public String getTipe_pembayaran() {
        return tipe_pembayaran;
    }

    public void setTipe_pembayaran(String tipe_pembayaran) {
        this.tipe_pembayaran = tipe_pembayaran;
    }

    public int getID_menu() {
        return ID_menu;
    }

    public void setID_menu(int ID_menu) {
        this.ID_menu = ID_menu;
    }
    
    
}
