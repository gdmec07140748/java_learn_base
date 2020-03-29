package com.mrz.theIntermediate.generic;

import com.mrz.primary.charactor.ADHero;
import com.mrz.primary.charactor.Hero;

import java.util.ArrayList;

/**
 * 泛型转型
 */
public class TransformationOfGeneric {
    public static void main(String[] args) {
        TransformationOfGeneric transformation = new TransformationOfGeneric();
//        transformation
    }

    /**
     * 基本转型
     * 比较
     */
    public void test() {
        Hero h = new Hero();
        ADHero ad = new ADHero();

        ArrayList<Hero> hs = new ArrayList<>();
        ArrayList<ADHero> adHeroes = new ArrayList<>();

//        子类转父类
        h = ad;

//        hs = adHeroes; // error

    }
}
