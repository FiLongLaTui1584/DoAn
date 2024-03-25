package com.example.doan.model;

import java.io.Serializable;
import java.util.ArrayList;

public class model_2 implements Serializable {
    private String tenSP,description,rate;
    private double dongia;
    private ArrayList<String> hinh;

    private int NumberinCart;

    public model_2() {
    }

    public model_2(String tenSP, String description, double dongia, String rate, ArrayList<String> hinh) {
        this.tenSP = tenSP;
        this.description = description;
        this.dongia = dongia;
        this.rate = rate;
        this.hinh = hinh;
    }

    public int getNumberinCart() {
        return NumberinCart;
    }

    public void setNumberinCart(int numberinCart) {
        NumberinCart = numberinCart;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public ArrayList<String> getHinh() {
        return hinh;
    }

    public void setHinh(ArrayList<String> hinh) {
        this.hinh = hinh;
    }
}
