package com.qq.daimh1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class T20e1 {
    public static void main(String args[]){
        Collection<String> collstr=new ArrayList<String>();
        collstr.add("张三");
        collstr.add("李四");
        collstr.add("王五");
        collstr.add("赵六");
        System.out.println(collstr);
        Object[] arrayo=collstr.toArray();
        Collection<String> coll = new ArrayList<String>();
        coll.add("赵刚");
        coll.add("莉莉");
        coll.addAll(collstr);
        System.out.println(coll);
        System.out.println(coll.contains("赵刚"));
        System.out.println(coll.containsAll(collstr));

        coll.retainAll(collstr);
        System.out.println();

        System.out.println(coll);
        coll.add("赵刚");
        Iterator it=coll.iterator();
        System.out.print("[");
        while (it.hasNext()) System.out.print(it.next()+", ");
        System.out.print("]");
        coll.retainAll(collstr);
        collstr.clear();
        System.out.print("clear后："+collstr);
    }
}
