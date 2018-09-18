package com.qq.daimh1;

import java.util.*;

public class T20e4 {

    public static void main(String[] args){
        hashSetResult();
        treeSetResult();
        linkedHashSetResult();
        Set hashSet=new HashSet();
        addSetElement(hashSet);
        hashSet.add("a");
        hashSet.add("b");
        System.out.println("\n hashSet加入a，b后元素为：");
        showElement(hashSet);
        List list=new ArrayList();
        list.add("a");
        list.add("c");
        list.add("d");
        hashSet.addAll(list);
        System.out.println("\nhashSet添加一个集合的所有元素后");
        showElement(hashSet);
        hashSet.retainAll(list);
        System.out.println("\nhashSet删除列表集合之外的元素后：");
        showElement(hashSet);
    }
    public static void hashSetResult(){
        Set hashSet=new HashSet();
        addSetElement(hashSet);
        System.out.println("使用hashset存储元素：");
        showElement(hashSet);
    }
    public static void treeSetResult(){
        Set treeSet=new TreeSet();
        addSetElement(treeSet);
        System.out.println("\n使用TreeSet存储数据元素如下：");
        showElement(treeSet);
    }
    public static void linkedHashSetResult(){
        Set linkedHashSet=new LinkedHashSet();
        addSetElement(linkedHashSet);
        System.out.println("\n使用LinkedHashSet存储数据元素如下：");
        showElement(linkedHashSet);
    }
    public static void addSetElement(Set set){
        if(set!=null){
            set.add("a");
            set.add("b");
            set.add("c");
            set.add("d");
            set.add("e");
        }
    }
    public static void showElement(Set set){
        if(set!=null&&set.size()>0){
            Iterator it=set.iterator();
            while (it.hasNext()){
                System.out.print(it.next()+" ");
            }

        }else {
            System.out.println();
        }
    }
}
