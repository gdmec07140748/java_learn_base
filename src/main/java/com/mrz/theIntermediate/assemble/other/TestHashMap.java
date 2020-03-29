package com.mrz.theIntermediate.assemble.other;

import com.mrz.primary.charactor.Hero;

import java.util.HashMap;

/**
 * HashMap储存数据的方式是—— 键值对
 */
public class TestHashMap {
    public static void main(String[] args) {

        TestHashMap testHashMap = new TestHashMap();
        testHashMap.OnlyKey();
//        testHashMap.test();
    }

    /**
     * 键不能重复，值可以重复
     */
    public void OnlyKey() {
        HashMap<String, Hero> heroMap = new HashMap<>();

        heroMap.put("gareen", new Hero("gareen1"));

        //key为gareen已经有value了，再以gareen作为key放入数据，会导致原英雄，被覆盖
        //不会增加新的元素到Map中
        heroMap.put("gareen", new Hero("gareen2"));
        System.out.println(heroMap);

//        清空 map
        heroMap.clear();

        Hero gareen = new Hero("gareen");

//        同一对象可以作为值插入到 map 中，只要对应的 key 值不一样
        heroMap.put("hero1", gareen);
        heroMap.put("hero2", gareen);

        System.out.println(heroMap);



    }

    public void test() {
        HashMap<String, String > dictionary = new HashMap<>();
        dictionary.put("adc", "物理英雄");
        dictionary.put("ap", "魔法英雄");
        dictionary.put("t", "坦克");

        System.out.println(dictionary.get("t"));
    }
}
