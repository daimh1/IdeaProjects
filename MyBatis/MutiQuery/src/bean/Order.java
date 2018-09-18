package bean;

import java.util.List;

public class Order {

    int oid ;
    String addr;
    String name ;
    String telephone;

    //从面向对象表示 一个订单关联多个订单项
    //一个订单里关联的多个订单项
    //1：n
    List<OrderItem> orderItems;

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", addr='" + addr + '\'' +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", orderItems=" + orderItems +
                '}';
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
