package com.mrz.primary.digit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class NumberTestTest {
    NumberTest numberTest;
    ByteArrayOutputStream bytes;

    @Before
    public void setUp() throws Exception {
        numberTest = new NumberTest();
        bytes = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bytes));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void formatBase2() {
        numberTest.formatBase2();
        String s = new String("2020\n" +
                "    2020\n" +
                "2020    \n" +
                "00002020\n" +
                "20,200,000\n" +
                "3.14\n" +
                "31 415,93\n" +
                "31,415.93\n" +
                "31,415.93\n");
        assertEquals(s, bytes.toString());


    }

    @Test
    public void formatBase() {
        numberTest.formatBase();
        String s = new String("盖伦 在进行了连续 8 次击杀后，获得了 超神 的称号\n" +
                "盖伦 在进行了连续 8 次击杀后，获得了 超神 的称号 \n" +
                "这是换行符\n" +
                "这是换行符\n" +
                "盖伦 在进行了连续 8 次击杀后，获得了 超神 的称号 \n" +
                "2020\n");
        assertEquals(s, bytes.toString());
    }

    @Test
    public void mathBase() {
        numberTest.mathBase();
        String s = new String("5\n" +
                "6\n" +
                "3.0\n" +
                "16.0\n" +
                "3.141592653589793\n" +
                "2.718281828459045\n");
        assertEquals(s, bytes.toString());
    }

    @Test
    public void string2int() {
        numberTest.string2int();
        String s = new String("9999\n");
        assertEquals(s, bytes.toString());
    }

    @Test
    public void int2string() {
        numberTest.int2string();
        String s = new String("");
        assertEquals(s, bytes.toString());
    }

    @Test
    public void baseInt() {
        numberTest.baseInt();
        String s = new String("true\n" +
                "2147483647\n" +
                "-2147483648\n");
        assertEquals(s, bytes.toString());
    }
}