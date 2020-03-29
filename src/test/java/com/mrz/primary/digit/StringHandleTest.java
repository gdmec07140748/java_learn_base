package com.mrz.primary.digit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringHandleTest {

    StringHandle stringHandle;

    @Before
    public void setUp() throws Exception {
        stringHandle = new StringHandle();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void charBaseAcharAt() {
        String sentence = "盖伦,在进行了连续8次击杀后,获得了 超神 的称号";
        char c = sentence.charAt(0);
        assertEquals('盖', c);
    }

    @Test
    public void charBaseAsubstring() {
        String sentence = "盖伦,在进行了连续8次击杀后,获得了 超神 的称号";

        //截取从第3个开始的字符串 （基0）
        String subString1 = sentence.substring(3);

        assertEquals("在进行了连续8次击杀后,获得了 超神 的称号", subString1);

        //截取从第3个开始的字符串 （基0）
        //到5-1的位置的字符串
        //左闭右开
        String subString2 = sentence.substring(3, 5);

        assertEquals("在进", subString2);
    }

    @Test
    public void charBaseAsplit() {
        String sentence = "盖伦,在进行了连续8次击杀后,获得了 超神 的称号";

        //根据,进行分割，得到3个子字符串
        String subSentences[] = sentence.split(",");
        String subSentences2[] = {"盖伦", "在进行了连续8次击杀后", "获得了 超神 的称号"};
        assertEquals(subSentences, subSentences2);
    }

    @Test
    public void charBaseAtrim() {
        String sentence = "        盖伦,在进行了连续8次击杀后,获得了 超神 的称号      ";

        assertEquals("        盖伦,在进行了连续8次击杀后,获得了 超神 的称号      ", sentence);
        //去掉首尾空格
        assertEquals("盖伦,在进行了连续8次击杀后,获得了 超神 的称号", sentence.trim());
    }

    @Test
    public void charBaseAtoLowerCase() {
        String sentence = "Garen";

        //全部变成小写
        assertEquals("garen", sentence.toLowerCase());
        //全部变成大写
        assertEquals("GAREN", sentence.toUpperCase());
    }

    @Test
    public void charBaseAindexOf() {
        String sentence = "盖伦,在进行了连续8次击杀后,获得了超神 的称号";

        /**
         * indexOf 判断字符或者子字符串出现的位置
         * contains 是否包含子字符串
         */
        //字符第一次出现的位置
        assertEquals(9, sentence.indexOf('8'));

        //字符串第一次出现的位置
        assertEquals(18, sentence.indexOf("超神"));

        //字符串最后出现的位置
        assertEquals(17, sentence.lastIndexOf("了"));

        //从位置5开始，出现的第一次,的位置
        assertEquals(14, sentence.indexOf(',', 5));

        //是否包含字符串"击杀"
        assertTrue(sentence.contains("击杀"));
    }

    @Test
    public void charBaseA() {
        String sentence = "盖伦,在进行了连续8次击杀后,获得了超神 的称号";

        String temp = sentence.replaceAll("击杀", "被击杀"); //替换所有的

        temp = temp.replaceAll("超神", "超鬼");

        assertEquals("盖伦,在进行了连续8次被击杀后,获得了超鬼 的称号", temp);

        temp = sentence.replaceFirst(",","");//只替换第一个

        assertEquals("盖伦在进行了连续8次击杀后,获得了超神 的称号", temp);
    }
}