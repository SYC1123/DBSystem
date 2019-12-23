package com.example.dbsystem.Model;

import java.io.Serializable;

public class User implements Serializable {
    private String tel;
    private String name;
    private String address;
    private String date;
    private String password;
    private int status;

    public User(String tel, String name, String address, String date, String password, int status) {
        this.address=address;
        this.date=date;
        this.name=name;
        this.password=password;
        this.status=status;
        this.tel=tel;
    }

    public String getTel() {
        return tel;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getDate() {
        return date;
    }

    public String getPassword() {
        return password;
    }

    public int getStatus() {
        return status;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
