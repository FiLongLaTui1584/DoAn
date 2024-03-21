package com.example.doan.model;

public class model
{
    String tenSP,description,hinh,dongia,rate;


    public model() {
    }

    public model(String tenSP, String description, String hinh, String dongia, String rate) {
        this.tenSP = tenSP;
        this.description = description;
        this.hinh = hinh;
        this.dongia = dongia;
        this.rate = rate;
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

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getDongia() {
        return dongia;
    }

    public void setDongia(String dongia) {
        this.dongia = dongia;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
