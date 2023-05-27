/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class Menu {
    private int ID_menu;
    private String nama_menu;
    private String additional;
    private int harga;

    public Menu() {
    }

    public Menu(int ID_menu, String nama_menu, String additional, int harga) {
        this.ID_menu = ID_menu;
        this.nama_menu = nama_menu;
        this.additional = additional;
        this.harga = harga;
    }

    public int getID_menu() {
        return ID_menu;
    }

    public void setID_menu(int ID_menu) {
        this.ID_menu = ID_menu;
    }

    public String getNama_menu() {
        return nama_menu;
    }

    public void setNama_menu(String nama_menu) {
        this.nama_menu = nama_menu;
    }

    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
    
    
    

    
    
}
