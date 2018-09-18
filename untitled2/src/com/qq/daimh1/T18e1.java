package com.qq.daimh1;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class T18e1 {
    public static void main(String args[]){
        String patternStr="(0?[1-9]|1[0-2]):([0-5]\\d)([a|p]m)";//0？不确定有没有0，无论有没有都在范围内
        String matcherStr="现在时间是01:15am点，营业时间是8:30am-5:30pm";
        Pattern pa=Pattern.compile(patternStr);
        Matcher ma=pa.matcher(matcherStr);
        StringBuffer sb=new StringBuffer();//目标字符串缓冲区
        int count = 0;
        System.out.println("初试字符串是：");
        System.out.println(matcherStr);

        while (ma.find()){
            StringBuffer temp=new StringBuffer();
            if(ma.group(3).equals("am")){
                temp.append(ma.group(1));
                temp.append(":");
                temp.append(ma.group(2));
            }
            else{
                int time=Integer.parseInt(ma.group(1));
                time=time+12;
                temp.append(time+":"+ma.group(2));
            }
            ma.appendReplacement(sb,temp.toString());
            System.out.println("["+(++count)+"]将"+ma.group(0)+"替换为"+temp.toString());
        }
        ma.appendTail(sb);

        System.out.println("最后的结果是");
        System.out.println(sb.toString());
    }
}
