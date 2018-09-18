package Day14;

/*
     线性表
       1.
       2. 行为（通过接口定义）
       3. 定义构造方法，初始化成员变量


       //对于访问权限：在满足业务需要的前提下，给成员变量近可能小的访问权限
 */

import java.util.Arrays;
import java.util.Objects;

public class MySequentialList implements MyLinearList{
    //线性表中的元素都存储在data数组中
    //不希望外界直接来访问的
    private String[] elements;

    //表示当前线性表中的元素个数

    //也需要对外界隐藏(需要让外界读取到它的值，但是不能修改)
    protected int size;

    //定义默认的用来存储线性表元素的数据的大小
    private final static int DAFAULT_ARRAY_SIZE = 10;


    //线性表中元素个数的上限
    private final  static int MAX_ARRAY_SIZE = Integer.MAX_VALUE;


    //定义一个默认的构造方法
    //主要就是给那些不关心，elements数组的初试大小
    public MySequentialList() {
        //初始化数组和size

        //hard code
        elements = new String[DAFAULT_ARRAY_SIZE];

        //初始化，线性表的元素个数
        size = 0;
    }


    //按照用户指定的大小来初始化，elements数组
    public MySequentialList(int capacity) {
        // 合法的取值范围[0, MAX_ARRAY_SIZE]

        if(capacity < 0 ) {
            throw new IllegalArgumentException("illegal capacity , capacity = " + capacity);
        }

        //按照用户指定的大小，来初始化elements数组的大小
        elements = new String[capacity];

        size = 0;
    }


    @Override
    public boolean add(String e, int index) {

        //1.检验插入位序是否合法 [0,size]
            rangeCheckForAdd(index);

        //2.确保，elements数组有空间，添加这个元素
        //    如果在插入当前元素的时候，发现数组已经满了，扩容
        ensureCapacityInternal(size + 1);

        //3.向线性表的指定位置，插入，待插入元素 考虑移位

          //  [a, b]    b - a + 1  index 从0开始的
          //  (size - 1) - index + 1
          int moveNum = size  - index;

          if(moveNum != 0) {
              //当待插入元素，插入的位置，不是线性表中，最后一个元素之后的位置
              System.arraycopy(elements,index, elements,index + 1, moveNum);
          }

        //4.向线性表中放入带插入元素
        elements[index] = e;

        //5. size++;
        size++;

        return true;
    }

    private void ensureCapacityInternal(int minCapacity) {

        //1. 判断是否需要扩容
        if(minCapacity - elements.length > 0) {
            grow(minCapacity);
        }

    }

    // 扩充elements数组的容量，保证带插入元素，能够放入elements数组中
    private void grow(int minCapacity) {
       // 1. 一次扩容，扩多少呢？
        //    a. 一次扩容，给elements数组增加一次增加一个存储单元，
        //       带来一个效率问题，每次增加一个元素，都有可能引起扩容动作
        //       但是，从存储的角度，这种方式充分的利用了，数组的存储空间

        //    b. 一次扩容，直接，将elements数组的容量，直接扩充到，所允许的
        //       线性表的容量上限。这样做的好处是，不管向线性表中存储多少个元素
        //       总之，扩容操作只会执行一次，这样做的坏处是，从存储的角度来看
        //       很有可能，在很多的存储单元可能会闲置

        //    tradeoff  折中  一次扩容多少，扩容数组之前，容量的一半

        int oldCapacity = size;

        //根据olcCapacity 计算新的扩容容量
        // 右移运算的优先级，低于算数运算
        int newCapacity = oldCapacity + (oldCapacity >> 1);

        if( newCapacity - minCapacity < 0) {
            // 用户利用一参构造方法，初始化elements的时候 capacity 0，1
            newCapacity = minCapacity;
        }

        // overflow-conscious code
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            newCapacity = hugeCapacity(minCapacity);
        }

        //在计算除扩容容量之后，开始扩容 如果使我们自己来做
        // 1.new 出一个包含指定元素个数(newCapacity)的数组
//        String[] tmp = new String[newCapacity];
//
//        // 2.复制，elements数组中的线性表元素，到扩容的新数组中
//        for (int i = 0; i < size;i++ ) {
//            tmp[i] = elements[i];
//        }
//
//        //3. elments 引用变量指向新的扩容之后的数组
//        elements = tmp;

        // Arrays.copyOf

        /*
         * Copies the specified array, truncating or padding with zeros (if necessary)
         * so the copy has the specified length.  For all indices that are
         * valid in both the original array and the copy, the two arrays will
         * contain identical values.  For any indices that are valid in the
         * copy but not the original, the copy will contain <tt>0</tt>.
         * Such indices will exist if and only if the specified length
         * is greater than that of the original array
         */
        elements = Arrays.copyOf(elements, newCapacity);

    }

    private int hugeCapacity(int minCapacity) {

        if(minCapacity < 0) {
            // 当前数组的长度已经是MAX_ARRAY_SIZE(Integer.MAX_SIZE)
            throw new OutOfMemoryError();
        }

        // 说明，虽然根据公示计算出的newCapacity已经超出了int类型表示范围，但是还可以扩容
        return MAX_ARRAY_SIZE;
    }


    //检查插入位序，是否合法
    private void rangeCheckForAdd(int index) {
        if(index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException(outOfBoundMsg(index));
        }
    }

    private String outOfBoundMsg(int index) {

        return "size = " + size + ", index = " + index;
    }

    @Override
    public String remove(int index) {
        //1. 检查删除的位序是否合法
        rangeCheck(index);

        //2. 删除指定位序的元素

        //  (size-1) - (index + 1) + 1 = size - index -1
        int moveNum =  size - index - 1;

        String oldValue = elements[index];

        if(moveNum != 0) {
            System.arraycopy(elements, index + 1, elements, index, moveNum);
        }

        elements[size - 1] = null;
        size--;
        return oldValue;
    }


    //检查删除操作的合法位序
    private void rangeCheck(int index) {
        if(index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(outOfBoundMsg(index));
        }
    }

    @Override
    public void set(int index, String newValue) {
        //
        rangeCheck(index);

        elements[index] = newValue;
    }



    // indexOf 实现版本是，查找，线性表中，指定元素第一次出现的位置
    //  返回值为-1，说明，在当前线性表中没有找到带查找元素
    @Override
    public int indexOf(String e) {
        //遍历线性表中的每一个元素， 对每一个元素和指定元素进行比较
        //一旦发现当前线性表中的元素和带查找元素的值相等，返回该元素的下标

//        if(e == null) {
//            for (int i = 0; i < size; i++) {
//                if(elements[i] == null) {
//                    return i;
//                }
//            }
//        } else {
//            // e != null
//           // ["zs", "lisi", "wangwu", null, "zhaoliu"]
//            // "zhaoliu"
//            for (int i = 0; i < size; i++) {
//                // 注意表达式的写法，这种写法就能规避，空指针异常
//                if(e.equals(elements[i])) {
//                    return i;
//                }
//            }
//        }

        for (int i = 0; i < size; i++) {
            if(Objects.equals(e, elements[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }


    public int size() {
        return size;
    }



    /*
            1 2 3 4
            显示：
            [1, 2, 3, 4]
            []
            "[1, 2, 3, 4]"

            "[1,2,3,4]"
     */

    @Override
    public String toString() {
        if(size == 0) {
           return "[]";
        }

        //StringBuilder 一个可变的字符序列
        StringBuilder stringBuilder = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            stringBuilder.append(elements[i]);
            if(i != size - 1) {
                stringBuilder.append(",");
            }
        }

        stringBuilder.append("]");

        return stringBuilder.toString();
    }

    public String elementAt(int index){
        return elements[index];
    }
}
