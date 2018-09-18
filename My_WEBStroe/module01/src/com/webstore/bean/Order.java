package com.webstore.bean;

public class Order {
    String oid;
    String money;
    String recipients;
    String tel;
    String address;
    String state;
    String ordertime;
    String uid;

    public Order(String oid, String money, String recipients, String tel, String address, String state, String ordertime, String uid) {
        this.oid = oid;
        this.money = money;
        this.recipients = recipients;
        this.tel = tel;
        this.address = address;
        this.state = state;
        this.ordertime = ordertime;
        this.uid = uid;
    }




    public Order() {
    }


    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getRecipients() {
        return recipients;
    }

    public void setRecipients(String recipients) {
        this.recipients = recipients;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid='" + oid + '\'' +
                ", money='" + money + '\'' +
                ", recipients='" + recipients + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", ordertime='" + ordertime + '\'' +
                ", uid='" + uid + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
