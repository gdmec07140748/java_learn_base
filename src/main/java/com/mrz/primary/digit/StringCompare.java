package com.mrz.primary.digit;

public class StringCompare {
    public static void main(String[] args) {
        String str1 = "the light";

        String str2 = new String(str1);

        //==用于判断是否是同一个字符串对象
        System.out.println(str1 == str2);
    }

    public void stringBufferRun2() {
        String str1 = "the";

        StringBuffer sb = new StringBuffer(str1);

        System.out.println(sb.length()); //内容长度

        System.out.println(sb.capacity());//总空间
    }

    /**
     * StringBuffer
     * 追加，插入，删除，反转
     */
    public void stringBufferRun1() {
        String str1 = "let there ";

        StringBuffer sb = new StringBuffer(str1); //根据str1创建一个StringBuffer对象
        sb.append("be light"); //在最后追加

        System.out.println(sb);

        sb.delete(4, 10);//删除4-10之间的字符

        System.out.println(sb);

        sb.insert(4, "there ");//在4这个位置插入 there

        System.out.println(sb);

        sb.reverse(); //反转

        System.out.println(sb);
    }

    /**
     * 是否以子字符串开始或者结束
     */
    public void isStartsWhit() {
        String str1 = "the light";

        String start = "the";
        String end = "Ight";

        System.out.println(str1.startsWith(start));//以...开始
        System.out.println(str1.endsWith(end));//以...结束
    }

    /**
     * 内容是否相同
     */
    public void isSameContent() {
        String str1 = "the light";

        String str2 = new String(str1);

        String str3 = str1.toUpperCase();

        //==用于判断是否是同一个字符串对象
        System.out.println(str1 == str2);

        System.out.println(str1.equals(str2));//完全一样返回true

        System.out.println(str1.equals(str3));//大小写不一样，返回false
        System.out.println(str1.equalsIgnoreCase(str3));//忽略大小写的比较，返回true

    }

    /**
     * 是否是同一个对象
     */
    public void isSameObject() {
        String str1 = "the light";

        String str2 = new String(str1);

        //==用于判断是否是同一个字符串对象
        System.out.println(str1 == str2);

    }
}
