package com.mrz.primary.digit;

/**
 * immutable 是指不可改变的
 * 比如创建了一个字符串对象
 * String garen ="盖伦";
 * 不可改变的具体含义是指：
 * 不能增加长度
 * 不能减少长度
 * 不能插入字符
 * 不能删除字符
 * 不能修改字符
 * 一旦创建好这个字符串，里面的内容 永远 不能改变
 *
 * String 的表现就像是一个常量
 */
public class CharTest {

//    String 被修饰为final,所以是不能被继承的

    String garen ="盖伦"; //字面值,虚拟机碰到字面值就会创建一个字符串对象

    String teemo = new String("提莫"); //创建了两个字符串对象

    char[] cs = new char[]{'崔','斯','特'};

    String hero = new String(cs);//  通过字符数组创建一个字符串对象

    String hero3 = garen + teemo;//  通过+加号进行字符串拼接

    public static void main(String[] args) {
        CharTest charTest = new CharTest();
        charTest.outStringBase();

    }

    public void outStringBase() {
        System.out.println("使用空格无法达到对齐的效果");
        System.out.println("abc def");
        System.out.println("ab def");
        System.out.println("a def");

        System.out.println("使用\\t制表符可以达到对齐的效果");
        System.out.println("abc\tdef");
        System.out.println("ab\tdef");
        System.out.println("a\tdef");

        System.out.println("一个\\t制表符长度是8");
        System.out.println("12345678def");

        System.out.println("换行符 \\n");
        System.out.println("abc\ndef");

        System.out.println("单引号 \\'");
        System.out.println("abc\'def");
        System.out.println("双引号 \\\"");
        System.out.println("abc\"def");
        System.out.println("反斜杠本身 \\");
        System.out.println("abc\\def");
    }

    public void methodBase() {
        System.out.println(Character.isLetter('a'));//判断是否为字母
        System.out.println(Character.isDigit('a')); //判断是否为数字
        System.out.println(Character.isWhitespace(' ')); //是否是空白
        System.out.println(Character.isUpperCase('a')); //是否是大写
        System.out.println(Character.isLowerCase('a')); //是否是小写

        System.out.println(Character.toUpperCase('a')); //转换为大写
        System.out.println(Character.toLowerCase('A')); //转换为小写

//        String a = 'a'; //不能够直接把一个字符转换成字符串
        String a2 = Character.toString('a'); //转换为字符串
    }

    /**
     * 字符基本了解
     */
    public void charBase() {
        char c1 = 'a';
        char c2 = '1';//字符1,而非数字1
        char c3 = '中';//汉字字符
//        char c4 = 'ab'; //只能放一个字符 error

        Character c = c1; // 自动装箱
        c= c; // 自动拆箱
    }
}
