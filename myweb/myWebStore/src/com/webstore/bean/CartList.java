package com.webstore.bean;

public class CartList {
    String imgurl;
    String describtion;
    String num;
    String perprice;
    double totalprice;

    public CartList(String imgurl, String describtion, String num, String perprice, double totalprice) {
        this.imgurl = imgurl;
        this.describtion = describtion;
        this.num = num;
        this.perprice = perprice;
        this.totalprice = totalprice;
    }

    public CartList() {
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPerprice() {
        return perprice;
    }

    public void setPerprice(String perprice) {
        this.perprice = perprice;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    @Override
    public String toString() {
        return "CartList{" +
                "imgurl='" + imgurl + '\'' +
                ", describtion='" + describtion + '\'' +
                ", num='" + num + '\'' +
                ", perprice='" + perprice + '\'' +
                ", totalprice='" + totalprice + '\'' +
                '}';
    }
}
