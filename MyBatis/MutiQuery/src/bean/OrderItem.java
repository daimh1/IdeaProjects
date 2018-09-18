package bean;

public class OrderItem {

    int id;
    int pnumber;
    String pname;

    /**
     * 表示一个订单项关联一个Order
     */
    Order order;

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", pnumber=" + pnumber +
                ", pname='" + pname + '\'' +
                ", order=" + order +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPnumber() {
        return pnumber;
    }

    public void setPnumber(int pnumber) {
        this.pnumber = pnumber;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
