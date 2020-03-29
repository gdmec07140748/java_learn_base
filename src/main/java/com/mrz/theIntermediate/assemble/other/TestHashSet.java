package com.mrz.theIntermediate.assemble.other;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Set中的元素，不能重复
 *
 * Set中的元素，没有顺序。
 * 严格的说，是没有按照元素的插入顺序排列
 *
 * HashSet的具体顺序，既不是按照插入顺序，也不是按照hashcode的顺序
 */
public class TestHashSet {
    public static void main(String[] args) {
        TestHashSet testHashSet = new TestHashSet();
        testHashSet.forTest();
//        testHashSet.intTest();
//        testHashSet.test();
    }

    /**
     * 遍历
     */
    public void forTest() {
        HashSet<Integer> numbers = new HashSet<>();

//        添加数据
        for (int i = 0; i < 20; i++) {
            numbers.add(i);
        }

        //Set不提供get方法来获取指定位置的元素
        //numbers.get(0)

        //遍历Set可以采用迭代器iterator
        for (Iterator<Integer> iterator = numbers.iterator(); iterator.hasNext();) {
            Integer i = (Integer) iterator.next();
            System.out.println(i);
        }

//        采用增强型 for 循环
        for (Integer i : numbers) {
            System.out.println(i);
        }
    }
    /**
     * 没有顺序
     */
    public void intTest() {
        HashSet<Integer> numbers = new HashSet<>();

        numbers.add(9);
        numbers.add(5);
        numbers.add(1);

//        Set 中的元素排列，不是按照插入顺序
        System.out.println(numbers);
    }

    public void test() {
        HashSet<String> names = new HashSet<>();

        names.add("gareen");
        System.out.println(names);

        // 第二次插入同样的数据，是插入不进去的，容器中只会保留一个
        names.add("gareen1");
        names.add("gareen");
        System.out.println(names);
    }
}
