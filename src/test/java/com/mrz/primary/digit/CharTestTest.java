package com.mrz.primary.digit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CharTestTest {

    CharTest charTest;
    @Before
    public void setUp() throws Exception {
        charTest = new CharTest();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void methodBase() {
        //判断是否为字母
        assertTrue(Character.isLetter('a'));
        //判断是否为数字
        assertFalse(Character.isDigit('a'));
        //是否是空白
        assertTrue(Character.isWhitespace(' '));
        //是否是大写
        assertFalse(Character.isUpperCase('a'));
        //是否是小写
        assertTrue(Character.isLowerCase('a'));

        //转换为大写
        assertEquals('A',Character.toUpperCase('a'));
        //转换为小写
        assertEquals('a', Character.toLowerCase('A'));
    }
    @Test
    public void charBase() {
    }
}