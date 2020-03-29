package com.mrz.theIntermediate.generic;

import com.mrz.primary.charactor.ADHero;
import com.mrz.primary.charactor.APHero;
import com.mrz.primary.charactor.Hero;

import java.util.ArrayList;

public class KnowGeneric {

    public static void main(String[] args) {
        KnowGeneric knowGeneric = new KnowGeneric();
        knowGeneric.noGeneric();
    }

//    -------- 基础
    /**
     * 使用泛型
     */
    public void useGeneric() {
        ArrayList<APHero> heros = new ArrayList<APHero>();
        ArrayList<APHero> heros2 = new ArrayList<>(); // 后面空白 <> 是简写方式
        heros.add(new APHero());
//        heros.add(new ADHero()); // error

        APHero apHero = (APHero) heros.get(0);
    }

    /**
     * 没有使用泛型
     */
    public void noGeneric() {
        ArrayList heros = new ArrayList();
        heros.add(new APHero());
        heros.add(new ADHero());

        APHero apHero = (APHero) heros.get(0);
        ADHero adHero = (ADHero) heros.get(1);
//        ADHero adHero2 = (ADHero) heros.get(0);
    }
}
