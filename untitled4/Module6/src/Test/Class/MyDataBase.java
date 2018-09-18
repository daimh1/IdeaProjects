package Test.Class;

import java.util.ArrayList;

public class MyDataBase {
    static ArrayList<Product> products;

    static {
        products=new ArrayList<Product>();
        String[] name={"数据结构","操作系统","组成原理","计算机网络","软件工程","数据库"};
        for (int i=0;i<name.length;i++){
            Product product=new Product();
            product.setProductId(i+"");
            product.setProductName(name[i]);
            product.setProductPrice("20rmb");
            product.setProductDesc(name[i]+"考研资料");
            products.add(product);
        }
    }

    public static ArrayList<Product> getAllProduct(){
        return products;
    }

    public static Product getProductByPid(int pid){
        if(pid>=0&&pid<products.size()) return products.get(pid);
        else return null;
    }

}
