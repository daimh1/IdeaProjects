package com.webstore.bean;

public class ShoppingCart {
    String id;
    String uid;
    String pid;
    String pnum;

    public ShoppingCart() {
    }

    public ShoppingCart(String id, String uid, String pid, String pnum) {
        this.id = id;
        this.uid = uid;
        this.pid = pid;
        this.pnum = pnum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPnum() {
        return pnum;
    }

    public void setPnum(String pnum) {
        this.pnum = pnum;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id='" + id + '\'' +
                ", uid='" + uid + '\'' +
                ", pid='" + pid + '\'' +
                ", pnum='" + pnum + '\'' +
                '}';
    }
}
