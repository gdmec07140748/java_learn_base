package com.mrz.primary.digit;

import com.mrz.primary.digit.character.IStringBuffer;

/**
 * 参考地址
 * https://how2j.cn/k/number-string/number-string-mystringbuilder/331.html#nowhere
 */
public class MyStringBuffer implements IStringBuffer {
    int capacity = 16;
    int length = 0;
    char[] value;

    public MyStringBuffer() {
        value = new char[capacity];
    }

    //有参构造方法
    public MyStringBuffer(String str) {
        if (null != str)
            value = str.toCharArray();

        length = value.length;

        if (capacity < value.length)
            capacity = value.length * 2;
    }

    @Override
    public void append(String str) {

    }

    @Override
    public void append(char c) {

    }

    @Override
    public void insert(int pos, char b) {


    }

    @Override
    public void insert(int pos, String b) {
//边界条件判断
        if (pos < 0)
            return;
        if (pos > length)
            return;
        if (null == b)
            return;

        //扩容
        while ((length + b.length()) < capacity) {
            capacity = (int) ((length + b.length()) * 1.5f);
            char[] newValue = new char[capacity];
            System.arraycopy(value, 0, newValue, 0, length);
            value = newValue;
        }
        char[] cs = b.toCharArray();
        //先把已经存在的数据往后移
        System.arraycopy(value, pos, value, pos + cs.length, length - pos);
        //把要插入的数据插入到指定位置
        System.arraycopy(cs, 0, value, pos, cs.length);
        length = length + cs.length;
    }

    @Override
    public void delete(int start) {

    }

    @Override
    public void delete(int start, int end) {

    }

    @Override
    public void reverse() {

        for (int i = 0; i < length / 2; i++) {
            char temp = value[i];
            value[i] = value[length - i - 1];
            value[length - i - 1] = temp;
        }
    }

    @Override
    public int length() {
        return 0;
    }

    public String toString() {
        char[] realValue = new char[length];
        System.arraycopy(value, 0, realValue, 0, length);
        return new String(realValue);
    }
}
