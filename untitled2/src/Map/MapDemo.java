package Map;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String args[]){
        Map<Integer,String> map=new HashMap<>();

        map.put(0,"zs");
        map.put(1,"lisi");
        map.put(2,"wangwu");

        traverseMap1(map);
        traverseMap2(map);

    }
    public static void traverseMap1(Map<Integer,String> map){
        //String ge
        //for (Integer key)
        for (Map.Entry<Integer,String> entry:map.entrySet()){
            System.out.println("Key="+entry.getKey()+"   "+"value="+entry.getValue());
        }
    }

    public static void traverseMap2(Map<Integer,String> map) {
        for (Integer key:map.keySet()){
            System.out.println("Key="+key+"   "+"value="+map.get(key));
        }
    }

}
