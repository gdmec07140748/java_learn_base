package com.mrz.common;

/**
 * public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
 * 代码解释:
 * 　　Object src : 原数组
 *    int srcPos : 从元数据的起始位置开始
 * 　　Object dest : 目标数组
 * 　　int destPos : 目标数组的开始起始位置
 * 　　int length  : 要copy的数组的长度
 */
public class ArrayCopy {
    public static void main(String[] args) {
        /**
         * 比如 ：我们有一个数组数据 byte[]  srcBytes = new byte[]{2,4,0,0,0,0,0,10,15,50};  // 源数组
         *
         *                                     byte[] destBytes = new byte[5]; // 目标数组
         *
         * 我们使用System.arraycopy进行转换(copy)
         *
         * System.arrayCopy(srcBytes,0,destBytes ,0,5)
         * 上面这段代码就是 : 创建一个一维空数组,数组的总长度为 12位,然后将srcBytes源数组中 从0位 到 第5位之间的数值 copy 到 destBytes目标数组中,在目标数组的第0位开始放置.
         * 那么这行代码的运行效果应该是 2,4,0,0,0,
         */
        byte[]  srcBytes = new byte[]{2,4,0,0,0,0,0,10,15,50};  // 源数组
        byte[] destBytes = new byte[5]; // 目标数组
        System.arraycopy(srcBytes, 0, destBytes, 0, 5);

        char[] realValue = new char[srcBytes.length];
        System.arraycopy(destBytes, 0, realValue, 0, srcBytes.length);
        String  str =  new String(realValue);
        System.out.println(str);

    }
}
