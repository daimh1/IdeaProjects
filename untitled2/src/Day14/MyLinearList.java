package Day14;

/*
        接口，从某种意义上来讲，就相当于是一种协议

        简单起见，假定操作的数据类型是String
 */


public interface MyLinearList {

    /**
     *
     * @param e  表示带插入线性表中的元素
     * @param index 指定带插入元素，在线性表中的位序
     * @return  表示，插入操作是否成功，成功返回true，否则返回false
     */
    boolean add(String e, int index);


    /**
     *
     *
     * @param index  指定待删除元素，在线性表中的位序
     * @return  返回线性表中待删除元素的值
     */

    String remove(int index);



    // 修改线性表中的元素值
    void  set(int index, String newValue);


    // 查找指定元素在线性表中的位序
    int indexOf(String e);


    //判断线性表中的元素集合是否为空
    boolean isEmpty();

    int size();

}
