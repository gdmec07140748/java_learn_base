package com.mrz.theIntermediate.multiplethread;

import com.mrz.primary.charactor.Hero;

/**
 * 常见的线程方法
 */
public class MethodThread {
    public static void main(String[] args) {
        MethodThread methodThread = new MethodThread();
        methodThread.daemonThred();
//        methodThread.yieldThred();
//        methodThread.priorityThred();
//        methodThread.joinThred();
//        methodThread.sleepThred();
    }

    /**
     * 守护线程的概念是：
     *    当一个进程里，所有的线程都是守护线程的时候，结束当前进程。
     */
    public void daemonThred() {
        Thread t1 = new Thread() {
            public void run() {
                int seconds =0;
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.printf("已经玩了LOL %d 秒%n", seconds++);
                }
            }
        };

        t1.setDaemon(true);
        t1.start();
    }
    /**
     * 当前线程，临时暂停，使得其他线程可以有更多的机会占用CPU资源
     */
    public void yieldThred() {
        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 61600;
        gareen.damage = 1;

        final Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 30000;
        teemo.damage = 1;

        final Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 50000;
        bh.damage = 1;

        final Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 45050;
        leesin.damage = 1;

        Thread t1 = new Thread() {
            public void run() {

                while (!teemo.isDead()) {
                    gareen.attackHeroNoStop(teemo);
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                while (!leesin.isDead()) {
//                    临时暂停，使得t1可以占用CPU资源
                    Thread.yield();
                    bh.attackHeroNoStop(leesin);
                }
            }
        };

        t1.setPriority(5);
        t2.setPriority(5);

        t1.start();
        t2.start();
    }

    /**
     * 线程优先级
     */
    public void priorityThred() {
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
                while (!teemo.isDead()) {
                    gareen.attackHeroNoStop(teemo);
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                while (!leesin.isDead()) {
                    bh.attackHeroNoStop(leesin);
                }
            }
        };

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
    }

    /**
     * 加入到当前线程中
     * 所有进程，至少会有一个线程即主线程，即main方法开始执行，就会有一个看不见的主线程存在。
     */
    public void joinThred() {
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
                while (!teemo.isDead()) {
                    gareen.attackHero(teemo);
                }
            }
        };

        t1.start();
        //代码执行到这里，一直是main线程在运行
        try {
            //t1线程加入到main线程中来，只有t1线程运行结束，才会继续往下走
//            在主线程中加入该线程
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread() {
            public void run() {
                while (!leesin.isDead()) {
                    bh.attackHero(leesin);
                }
            }
        };
        //会观察到盖伦把提莫杀掉后，才运行t2线程
        t2.start();
    }

    /**
     * 当前线程暂停
     */
    public void sleepThred() {
        Thread t1 = new Thread() {

            @Override
            public void run() {
                int second = 0;
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.printf("已经过去 %d 秒了%n", second++);
                }
            }
        };
        t1.start();
    }
}
