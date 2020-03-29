package com.mrz.primary.digit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringCompareTest {
    StringCompare stringCompare;

    @Before
    public void setUp() throws Exception {
        stringCompare = new StringCompare();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void stringBufferRun2() {
        String str1 = "the";

        StringBuffer sb = new StringBuffer(str1);

        //内容长度
        assertEquals(3, sb.length());

        //总空间
        assertEquals(19, sb.capacity());
    }

    @Test
    public void stringBufferRun1() {
        String str1 = "let there ";

        StringBuffer sb = new StringBuffer(str1); //根据str1创建一个StringBuffer对象
        sb.append("be light"); //在最后追加

        assertEquals("let there be light", sb.toString());

        sb.delete(4, 10);//删除4-10之间的字符

        assertEquals("let be light", sb.toString());

        sb.insert(4, "there ");//在4这个位置插入 there

        assertEquals("let there be light", sb.toString());

        sb.reverse(); //反转

        assertEquals("thgil eb ereht tel", sb.toString());
    }

    @Test
    public void isStartsWhit() {
        String str1 = "the light";

        String start = "the";
        String end = "Ight";

        //以...开始
        assertTrue(str1.startsWith(start));

        //以...结束
        assertFalse(str1.endsWith(end));

    }

    @Test
    public void isSameObject() {
        String str1 = "the light";

        String str2 = new String(str1);

        String str3 = str1.toUpperCase();

        //==用于判断是否是同一个字符串对象
        assertFalse(str1 == str2);

        String str5 = "the light";
        String str6 = "the light";
//        内容已经存在，直接拿来用，没有再次创建
        assertTrue(str5 == str6);

        //完全一样返回true
        assertTrue(str1.equals(str2));

        //大小写不一样，返回false
        assertFalse(str1.equals(str3));

        //忽略大小写的比较，返回true
        assertTrue(str1.equalsIgnoreCase(str3));
    }
}