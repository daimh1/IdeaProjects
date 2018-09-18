package Utils;

import Utils.DBUtils;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedList;

public class MyDBConnPool {

    static LinkedList<Connection> pool;

    static {
        pool=new LinkedList<>();

        for(int i=0;i<10;i++){
            Connection connection=DBUtils.getConnection();
            pool.add(connection);
        }
    }

    public static Connection getConntionFromPool(){
        if(pool.size()>0){
            return pool.removeFirst();
        }
        return null;
    }
    public static void returnConnToPool(Connection connection){
        pool.addLast(connection);
    }
}
