package com.webstore.bean;

public class Product {
    String pid;
    String pname;
    String estoreprice;
    String markprice;
    String pnum;
    String cid;
    String imgurl;
    String descibe;


    public String getDescibe() {
        return descibe;
    }

    public void setDescibe(String descibe) {
        this.descibe = descibe;
    }


    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getEstoreprice() {
        return estoreprice;
    }

    public void setEstoreprice(String estoreprice) {
        this.estoreprice = estoreprice;
    }

    public String getMarkprice() {
        return markprice;
    }

    public void setMarkprice(String markprice) {
        this.markprice = markprice;
    }

    public String getPnum() {
        return pnum;
    }

    public void setPnum(String pnum) {
        this.pnum = pnum;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getdescibe() {
        return descibe;
    }

    public void setdescibe(String descibe) {
        this.descibe = descibe;
    }

    public Product() {
    }



    public Product(String pid, String pname, String estoreprice, String markprice, String pnum, String cid, String imgurl, String descibe) {
        this.pid = pid;
        this.pname = pname;
        this.estoreprice = estoreprice;
        this.markprice = markprice;
        this.pnum = pnum;
        this.cid = cid;
        this.imgurl = imgurl;
        this.descibe = descibe;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid='" + pid + '\'' +
                ", pname='" + pname + '\'' +
                ", estoreprice='" + estoreprice + '\'' +
                ", markprice='" + markprice + '\'' +
                ", pnum='" + pnum + '\'' +
                ", cid='" + cid + '\'' +
                ", imgurl='" + imgurl + '\'' +
                ", descibe='" + descibe + '\'' +
                '}';
    }
    /*public Category category(){
        return CategoryDao.findCatergoryByCid(this.cid);
    }*/
}
