package bean;

public class Cart {


    /**
     * 主键
     */
    int cid ;

    /**
     * 外键 ，（唯一）
     * 表示这个bean和外键表里的数据有个对应关系
     * 1：1
     * 一对一的关系
     * 从面相对象的角度去考虑bean里的字段设计，
     * 一个bean和另一个bean有一对一的关系
     * 以xx关联另一个xx
     * 规范的写法
     */

    //int  uid ;
     User user;


    //购物车的金额
    int money;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cid=" + cid +
                ", user=" + user +
                ", money=" + money +
                '}';
    }
}
