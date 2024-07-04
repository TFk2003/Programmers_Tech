/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jframes;

/**
 *
 * @author HP
 */
public class CentralDataModel {
    private static CentralDataModel instance;
    private String username;
    private String account;
    private int balance;

    private CentralDataModel() {}

    public static synchronized CentralDataModel getInstance() {
        if (instance == null) {
            instance = new CentralDataModel();
        }
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}

