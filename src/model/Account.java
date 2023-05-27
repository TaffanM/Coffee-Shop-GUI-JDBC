/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class Account {
    
    public enum AccountType {
        admin,
        user;
    }
    
    private int ID_pelanggan;
    private String nama;
    private String username;
    private String password;
    private String tipe;

    public Account() {
    }

    public Account(int ID_pelanggan, String nama, String username, String password, String tipe) {
        this.ID_pelanggan = ID_pelanggan;
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.tipe = tipe;
    }

    public int getID_pelanggan() {
        return ID_pelanggan;
    }

    public void setID_pelanggan(int ID_pelanggan) {
        this.ID_pelanggan = ID_pelanggan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    
}
