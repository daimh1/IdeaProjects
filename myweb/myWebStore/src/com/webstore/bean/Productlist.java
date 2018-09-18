package com.webstore.bean;

import java.util.ArrayList;
import java.util.List;

public class Productlist {
    public ArrayList<String> productidList;
    public ArrayList<String> productNum;
    public ArrayList<String> oidList;

    public Productlist(ArrayList<String> productidList, ArrayList<String> productNum, ArrayList<String> oidList) {
        this.productidList = productidList;
        this.productNum = productNum;
        this.oidList = oidList;
    }

    public Productlist() {
    }

    public ArrayList<String> getProductidList() {
        return productidList;
    }

    public void setProductidList(ArrayList<String> productidList) {
        this.productidList = productidList;
    }

    public ArrayList<String> getProductNum() {
        return productNum;
    }

    public void setProductNum(ArrayList<String> productNum) {
        this.productNum = productNum;
    }

    public ArrayList<String> getOidList() {
        return oidList;
    }

    public void setOidList(ArrayList<String> oidList) {
        this.oidList = oidList;
    }
}
