package com.mrz.primary.digit;

import java.util.Locale;

/**
 * Number
 * Byte
 * Integer
 * Double
 * Short
 * Float
 * Long
 */
public class NumberTest {
    public static void main(String[] args) {
        NumberTest numberTest = new NumberTest();
        numberTest.baseInt();
    }

    /**
     * format
     * 格式化输出内容
     */
    public void formatBase2() {
        int year = 2020;
//        总长度，左对齐，补0，千位分隔符，小数点位数，本地化表达
        //直接打印数字
        System.out.format("%d%n", year);
        //总长度是8,默认右对齐
        System.out.format("%8d%n", year);
        //总长度是8,左对齐
        System.out.format("%-8d%n", year);
        //总长度是8,不够补0
        System.out.format("%08d%n", year);
        //千位分隔符
        System.out.format("%,8d%n", year * 10000);

        //小数点位数
        System.out.format("%.2f%n", Math.PI);

        //不同国家的千位分隔符
        System.out.format(Locale.FRANCE, "%,.2f%n", Math.PI * 10000);
        System.out.format(Locale.US, "%,.2f%n", Math.PI * 10000);
        System.out.format(Locale.UK, "%,.2f%n", Math.PI * 10000);
    }

    /**
     * 基本语句输出
     */
    public void formatBase() {
        String name = "盖伦";
        int kill = 8;
        String title = "超神";
//直接使用+进行字符串连接，编码感觉会比较繁琐，并且维护性差,易读性差
        String sentence = name + " 在进行了连续 " + kill + " 次击杀后，获得了 " + title + " 的称号";

        System.out.println(sentence);

        //使用格式化输出
        //%s表示字符串，%d表示数字,%n表示换行
        String sentenceFormat = "%s 在进行了连续 %d 次击杀后，获得了 %s 的称号 %n";
        System.out.printf(sentenceFormat, name, kill, title);
        /**
         * 换行符就是另起一行 --- '\n' 换行（newline）
         * 回车符就是回到一行的开头 --- '\r' 回车（return）
         * （1）在DOS和Windows中，每行结尾是 “\r\n”；
         * （2）Linux系统里，每行结尾只有 “\n”；
         * （3）Mac系统里，每行结尾是只有 "\r"。
         * java 使用%n，就可以做到平台无关的换行
         *  printf
         */
        System.out.printf("这是换行符%n");
        System.out.printf("这是换行符%n");


//        format 跟 printf 一样的效果
        System.out.format(sentenceFormat, name, kill, title);

        int year = 2020;
//        总长度，左对齐，补0，千位分隔符，小数点位数，本地化表达
        System.out.printf("%d%n", year);
    }

    /**
     * 数字方法
     */
    public void mathBase() {
        float f1 = 5.4f;
        float f2 = 5.5f;
        //5.4四舍五入即5
        System.out.println(Math.round(f1));
        //5.5四舍五入即6
        System.out.println(Math.round(f2));

        //得到一个0-1之间的随机浮点数（取不到1）
        float f = (float)Math.random();
//        System.out.println(Math.random());

        //得到一个0-10之间的随机整数 （取不到10）
        int i =(int) (Math.random() * 10);

        //开方
        System.out.println(Math.sqrt(9));
        //次方（2的4次方）
        System.out.println(Math.pow(2, 4));

        //π
        System.out.println(Math.PI);

        //自然常数
        System.out.println(Math.E);
    }

    /**
     * 字符串转数字
     */
    public void string2int() {
        String str = "9999";
        int i = Integer.parseInt(str);
        System.out.println(i);
    }

    /**
     * 数字转字符串
     */
    public void int2string() {
        int i = 5;
        // 1
        String str = String.valueOf(5);
        // 2
        Integer it = i;
        String str2 = it.toString();
    }

    /**
     * 初步了解 int
     */
    public void baseInt() {
        int i = 5;
        Integer it = new Integer(i);
//        自动装箱
        Integer it2 = i;

//        true
        System.out.println(it instanceof Number);

        int i2 = it.intValue();
//        自动拆箱
        int i3 = it;

//        int 最大值
        System.out.println(Integer.MAX_VALUE);
//        int 最小值
        System.out.println(Integer.MIN_VALUE);
    }
}
