package com.mrz.theIntermediate.assemble.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections是一个类，容器的工具类,就如同Arrays是数组的工具类
 */
public class TestCollections {
    public static void main(String[] args) {
        TestCollections testCollections = new TestCollections();
        testCollections.shuffleTest();
//        testCollections.reverseTest();

    }

    public void safeThread() {
        List<Integer> numbers = new ArrayList<>();

        System.out.println("把非线程安全的List转换为线程安全的List");
        List<Integer> synchronizedNumbers = (List<Integer>) Collections.synchronizedList(numbers);
    }

    /**
     * shuffle 混淆List中数据的顺序
     */
    public void shuffleTest() {
//      初始化集合numbers
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        System.out.println("集合中的数据:");
        System.out.println(numbers);

        Collections.shuffle(numbers);
        System.out.println("混淆后集合中的数据");
        System.out.println(numbers);

        Collections.sort(numbers);
        System.out.println("排序后集合中的数据");
        System.out.println(numbers);

        Collections.swap(numbers, 0 ,5);
        System.out.println("交换 0 和 5 下标的数据后，集合中的数据：");
        System.out.println(numbers);

        Collections.sort(numbers);
        System.out.println(numbers);
        Collections.rotate(numbers, 2);
        System.out.println("把集合向右滚动 2 个单位，集合中的数据：");
        System.out.println(numbers);


    }
    /**
     * 反转
     */
    public void reverseTest() {
//      初始化集合numbers
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }

        System.out.println("集合中的数据:");
        System.out.println(numbers);

        Collections.reverse(numbers);
        System.out.println(numbers);
    }
}
