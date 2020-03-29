package com.mrz.theIntermediate.assemble.collection;

import java.util.ArrayList;
import java.util.List;

import com.mrz.primary.charactor.Hero;

/**
 * 集合基本使用
 */
public class TestCollection {

    public static void main(String args[]) {
    }

    // --- List

    /**
     * ArrayList实现了接口List
     */
    public void diffListCollection() {
        // 常见的写法会把引用声明为接口List类型
        // 注意：是java.util.List,而不是java.awt.List
        // 接口引用指向子类对象（多态）
        List herosList = new ArrayList();
        herosList.add(new Hero("盖伦"));
        System.out.println(herosList.size());
    }

    // --- 集合

    /**
     * 好处 自动增长，不用担心数组边界问题
     */
    public void arrayCollection() {
        ArrayList herosArrayList = new ArrayList();
        herosArrayList.add(new Hero("盖伦"));
        System.out.println(herosArrayList.size());
        herosArrayList.add(new Hero("盖伦2"));
        System.out.println(herosArrayList.size());

    }
}
