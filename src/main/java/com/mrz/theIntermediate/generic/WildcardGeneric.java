package com.mrz.theIntermediate.generic;

import com.mrz.primary.charactor.ADHero;
import com.mrz.primary.charactor.APHero;
import com.mrz.primary.charactor.Hero;
import com.mrz.primary.property.Item;

import java.util.ArrayList;

/**
 * 通配符
 * 如果希望只取出，不插入，就使用? extends Hero
 * 如果希望只插入，不取出，就使用? super Hero
 * 如果希望，又能插入，又能取出，就不要用通配符？
 */
public class WildcardGeneric {

    /**
     * ?泛型通配符，表示任意泛型
     */
    public void anyGeneric() {
        ArrayList<APHero> apHeroArrayList = new ArrayList<>();

//        ?
        ArrayList<?> generalList = apHeroArrayList;

//        ?的缺陷1： 既然?代表任意泛型，那么换句话说，你就不知道这个容器里面是什么类型
        //所以只能以Object的形式取出来
        Object o = generalList.get(0);

//        ?的缺陷2： 既然?代表任意泛型，那么既有可能是Hero,也有可能是Item
        //所以，放哪种对象进去，都有风险，结果就什么什么类型的对象，都不能放进去
//        下面编译都出现错误
//        generalList.add(new Item());
//        generalList.add(new Hero());
//        generalList.add(new APHero());
    }

    /**
     * ArrayList heroList<? super Hero> 表示这是一个Hero泛型或者其父类泛型
     * heroList的泛型可能是Hero
     * heroList的泛型可能是Object
     */
    public void superGeneric() {
        ArrayList<? super Hero> heroList = new ArrayList<Object>();

//        可以插入 Hero
        heroList.add(new Hero());

//        也可以插入 Hero 的子类
        heroList.add(new APHero());
        heroList.add(new ADHero());

//        但是，不能从里面取数据出来，因为其泛型可能是 Object，而 Object 强转 Hero 会失败
//        Hero h = heroList.get(0); // error
    }

    /**
     * ? extends Hero
     * 使用
     */
    public void extendsGeneric() {
        ArrayList<APHero> apHeroArrayList = new ArrayList<>();
        apHeroArrayList.add(new APHero());

        ArrayList<? extends Hero> heroeList = apHeroArrayList;

        // ? extends Hero 表示这是一个 Hero 泛型的子类泛型

        //heroList 的泛型可以是Hero
        //heroList 的泛型可以使APHero
        //heroList 的泛型可以使ADHero

        //可以确凿的是，从heroList取出来的对象，一定是可以转型成Hero的

        Hero h = heroeList.get(0);

//        但是，不能往里面放东西
//        heroeList.add(new ADHero()); // error 编译错误，因为heroList的泛型 有可能是APHero
    }

}
