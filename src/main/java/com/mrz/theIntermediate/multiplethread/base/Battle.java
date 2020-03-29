package com.mrz.theIntermediate.multiplethread.base;

import com.mrz.primary.charactor.Hero;

/**
 * 但是直接调用run方法，并不会启动一个新的线程。
 * 必须，借助一个线程对象的start()方法，才会启动一个新的线程。
 */
public class Battle implements Runnable {
    private Hero h1;
    private Hero h2;

    public Battle(Hero h1, Hero h2){
        this.h1 = h1;
        this.h2 = h2;
    }

    @Override
    public void run() {
        while (!h2.isDead()) {
            h1.attackHero(h2);
        }
    }

}
