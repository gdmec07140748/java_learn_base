package com.mrz.theIntermediate.multiplethread;

import com.mrz.primary.charactor.Hero;
import com.mrz.theIntermediate.multiplethread.base.NotifyHero;

/**
 * 交互
 *
 * wait方法和notify方法，并不是Thread线程上的方法，它们是Object上的方法。
 *  因为所有的Object都可以被用来作为同步对象，所以准确的讲，wait和notify是同步对象上的方法。
 *      wait()的意思是： 让占用了这个同步对象的线程，临时释放当前的占用，并且等待。 所以调用wait是有前提条件的，一定是在synchronized块里，否则就会出错。
 *      notify() 的意思是，通知一个等待在这个同步对象上的线程，你可以苏醒过来了，有机会重新占用当前对象了。
 *      notifyAll() 的意思是，通知所有的等待在这个同步对象上的线程，你们可以苏醒过来了，有机会重新占用当前对象了。
 */
public class InteractionThread {
    public static void main(String[] args) {
        InteractionThread interactionThread = new InteractionThread();
        interactionThread.useNotifyWait();
//        interactionThread.badThing();
    }

    /**
     * 使用wait和notify进行线程交互
     * NotifyHero 类里面使用
     */
    public void useNotifyWait() {
        final NotifyHero gareen = new NotifyHero();
        gareen.name = "盖伦";
        gareen.hp = 616;

        Thread t1 = new Thread() {

            @Override
            public void run() {
                while (true) {

//                    无需循环判断
//                    while (gareen.hp == 1) {
//                        continue;
//                    }
                    gareen.hurt();
                    System.out.printf("t1 为%s 减血1点,减少血后，%s的血量是%.0f%n",gareen.name,gareen.name,gareen.hp);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();

        Thread t2 = new Thread() {

            @Override
            public void run() {
                while (true) {
                    gareen.recover();
                    System.out.printf("t2 为%s 回血1点,增加血后，%s的血量是%.0f%n",gareen.name,gareen.name,gareen.hp);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t2.start();
    }
    /**
     * 不好的解决方式
     */
    public void badThing() {
        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;

        Thread t1 = new Thread() {

            @Override
            public void run() {
                while (true) {

                    //因为减血更快，所以盖伦的血量迟早会到达1
                    //使用while循环判断是否是1，如果是1就不停的循环
                    //直到加血线程回复了血量
                    while (gareen.hp == 1) {
                        continue;
                    }
                    gareen.hurt();
                    System.out.printf("t1 为%s 减血1点,减少血后，%s的血量是%.0f%n",gareen.name,gareen.name,gareen.hp);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();

        Thread t2 = new Thread() {

            @Override
            public void run() {
                while (true) {
                    gareen.recover();
                    System.out.printf("t2 为%s 回血1点,增加血后，%s的血量是%.0f%n",gareen.name,gareen.name,gareen.hp);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t2.start();

    }

}
