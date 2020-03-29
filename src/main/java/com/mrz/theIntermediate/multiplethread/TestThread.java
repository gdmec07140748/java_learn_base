package com.mrz.theIntermediate.multiplethread;

import com.mrz.primary.charactor.Hero;
import com.mrz.theIntermediate.multiplethread.base.Battle;
import com.mrz.theIntermediate.multiplethread.base.KillThread;

/**
 * 首先要理解进程(Processor)和线程(Thread)的区别
 * 进程：启动一个LOL.exe就叫一个进程。 接着又启动一个DOTA.exe，这叫两个进程。
 * 线程：线程是在进程内部同时做的事情，比如在LOL里，有很多事情要同时做，比如"盖伦” 击杀“提莫”，同时“赏金猎人”又在击杀“盲僧”，这就是由多线程来实现的。
 */
public class TestThread {

    public static void main(String[] args) {
        TestThread testThread = new TestThread();
        testThread.useNoClassThread();
//        testThread.useRunnableThread();
//        testThread.useThread();
//        testThread.noThread();
    }

    /**
     * 使用多线程的情况
     * 匿名类
     */
    private void useNoClassThread() {
        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;
        gareen.damage = 50;

        final Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;

        final Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;

        final Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 80;

        Thread t1 = new Thread() {
            public void run() {
                //匿名类中用到外部的局部变量teemo，必须把teemo声明为final
                //但是在JDK7以后，就不是必须加final的了
                while (!teemo.isDead()) {
                    gareen.attackHero(teemo);
                }
            }
        };
        t1.start();

        Thread t2= new Thread(){
            public void run(){
                while(!leesin.isDead()){
                    bh.attackHero(leesin);
                }
            }
        };
        t2.start();
    }

    /**
     * 使用多线程的情况
     * Runnable
     */
    private void useRunnableThread() {
        Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;
        gareen.damage = 50;

        Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;

        Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;

        Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 80;

        Battle battle1 = new Battle(gareen, teemo);
        new Thread(battle1).start();

        Battle battle2 = new Battle(bh, leesin);
        new Thread(battle2).start();
    }

    /**
     * 使用多线程的情况
     */
    private void useThread() {
        Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;
        gareen.damage = 50;

        Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;

        Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;

        Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 80;

        KillThread killThread1 = new KillThread(gareen, teemo);
        killThread1.start();
        KillThread killThread2 = new KillThread(bh, leesin);
        killThread2.start();

    }

    /**
     * 不使用多线程的情况
     */
    private void noThread() {
        Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;
        gareen.damage = 50;

        Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;

        Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;

        Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 80;

        //盖伦攻击提莫
        while (!teemo.isDead()) {
            gareen.attackHero(teemo);
        }

        //赏金猎人攻击盲僧
        while (!leesin.isDead()) {
            bh.attackHero(leesin);
        }
    }
}
