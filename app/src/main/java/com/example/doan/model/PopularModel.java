package com.example.doan.model;

import java.io.Serializable;

public class PopularModel implements Serializable {
    private String txtTensp;
    private int  ivhinh;
    private double txtDongia;
    private int txtDanhgia;
    private double txtDiem;


    public PopularModel() {
    }

    public PopularModel(String txtTensp, int ivhinh, double txtDongia, int txtDanhgia, double txtDiem) {
        this.txtTensp = txtTensp;
        this.ivhinh = ivhinh;
        this.txtDongia = txtDongia;
        this.txtDanhgia = txtDanhgia;
        this.txtDiem = txtDiem;
    }

    public String getTxtTensp() {
        return txtTensp;
    }

    public void setTxtTensp(String txtTensp) {
        this.txtTensp = txtTensp;
    }

    public int getIvhinh() {
        return ivhinh;
    }

    public void setIvhinh(int ivhinh) {
        this.ivhinh = ivhinh;
    }

    public double getTxtDongia() {
        return txtDongia;
    }

    public void setTxtDongia(double txtDongia) {
        this.txtDongia = txtDongia;
    }

    public int getTxtDanhgia() {
        return txtDanhgia;
    }

    public void setTxtDanhgia(int txtDanhgia) {
        this.txtDanhgia = txtDanhgia;
    }

    public double getTxtDiem() {
        return txtDiem;
    }

    public void setTxtDiem(double txtDiem) {
        this.txtDiem = txtDiem;
    }

}
