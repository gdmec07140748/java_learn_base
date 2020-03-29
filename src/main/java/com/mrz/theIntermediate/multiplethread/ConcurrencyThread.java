package com.mrz.theIntermediate.multiplethread;

import com.mrz.primary.charactor.Hero;
import com.mrz.theIntermediate.multiplethread.base.SynchronizedHero;
import com.mrz.theIntermediate.multiplethread.base.SynchronizedHeroMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 多线程 同步
 * <p>
 * 总体解决思路是： 在增加线程访问hp期间，其他线程不可以访问hp
 * 1. 增加线程获取到hp的值，并进行运算
 * 2. 在运算期间，减少线程试图来获取hp的值，但是不被允许
 * 3. 增加线程运算结束，并成功修改hp的值为10001
 * 4. 减少线程，在增加线程做完后，才能访问hp的值，即10001
 * 5. 减少线程运算，并得到新的值10000
 * <p>
 * <p>
 * synchronized表示当前线程，独占 对象 someObject
 * 当前线程独占 了对象someObject，如果有其他线程试图占有对象someObject，就会等待，直到当前线程释放对someObject的占用。
 * someObject 又叫同步对象，所有的对象，都可以作为同步对象
 * 为了达到同步的效果，必须使用同一个同步对象
 * <p>
 * 释放同步对象的方式： synchronized 块自然结束，或者有异常抛出
 */
public class ConcurrencyThread {
    public static String now() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    public static void main(String[] args) {
        ConcurrencyThread concurrencyThread = new ConcurrencyThread();
//        concurrencyThread.knowSynchronized();
        concurrencyThread.directUseBeforeMehtod();
//        concurrencyThread.theProblem();
    }

    /**
     * synchronized 同步对象概念
     */
    public void knowSynchronized() {
        final Object someObject = new Object();

        Thread t1 = new Thread() {

            @Override
            public void run() {
                try {
                    System.out.println(now() + "t1 线程已经在运行");
                    System.out.println(now() + this.getName() + "试图占有对象：someObject");
                    synchronized (someObject) {
                        System.out.println(now() + this.getName() + "占有对象：someObject");
                        Thread.sleep(5000);
                        System.out.println(now() + this.getName() + "释放对象：someObject");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.setName(" t1");
        t1.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println(now() + "t2 线程已经在运行");
                    System.out.println(now() + this.getName() + "试图占有对象：someObject");
                    synchronized (someObject) {
                        System.out.println(now() + this.getName() + "占有对象：someObject");
                        Thread.sleep(5000);
                        System.out.println(now() + this.getName() + "释放对象：someObject");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t2.setName(" t2");
        t2.start();
    }

    /**
     * 在方法前，加上修饰符synchronized
     * 外部线程访问gareen的方法，就不需要额外使用synchronized 了
     */
    public void directUseBeforeMehtod() {
        final SynchronizedHeroMethod gareen = new SynchronizedHeroMethod();
        gareen.name = "盖伦";
        gareen.hp = 10000;
        System.out.printf("盖伦的初始血量是 %.0f%n", gareen.hp);

        //n个线程增加盖伦的hp
        int n = 16000;
//        加血
        Thread[] addThreads = new Thread[n];
//        减血
        Thread[] reduceThreads = new Thread[n];

        for (int i = 0; i < n; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    gareen.recover();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            addThreads[i] = t;
        }

        //n个线程减少盖伦的hp
        for (int i = 0; i < n; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    gareen.hurt();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            reduceThreads[i] = t;
        }

//        等待所有增加的线程结束
        for (Thread t : addThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        等待所有减少的线程结束
        for (Thread t : reduceThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("%d个增加线程和%d个减少线程结束后%n盖伦的血量变成了 %.0f%n", n, n, gareen.hp);
    }


    /**
     * 使用 hero 作为同步对象
     */
    public void directUseOfHero() {

        final SynchronizedHero gareen = new SynchronizedHero();
        gareen.name = "盖伦";
        gareen.hp = 10000;
        System.out.printf("盖伦的初始血量是 %.0f%n", gareen.hp);
        //n个线程增加盖伦的hp
        int n = 16000;
//        加血
        Thread[] addThreads = new Thread[n];
//        减血
        Thread[] reduceThreads = new Thread[n];

        for (int i = 0; i < n; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    //使用gareen作为synchronized
                    synchronized (gareen) {
                        gareen.recover();
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            addThreads[i] = t;
        }

        //n个线程减少盖伦的hp
        for (int i = 0; i < n; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
//                    使用gareen作为synchronized
                    //在方法hurt中有synchronized(this)
                    gareen.hurt();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            reduceThreads[i] = t;
        }

//        等待所有增加的线程结束
        for (Thread t : addThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        等待所有减少的线程结束
        for (Thread t : reduceThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("%d个增加线程和%d个减少线程结束后%n盖伦的血量变成了 %.0f%n", n, n, gareen.hp);
    }

    /**
     * 使用 Object 作为对象
     */
    public void directUseOfSynchronized() {

//        创建一个同步对象
        final Object someObject = new Object();
        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 10000;
        System.out.printf("盖伦的初始血量是 %.0f%n", gareen.hp);
        //n个线程增加盖伦的hp
        int n = 16000;
//        加血
        Thread[] addThreads = new Thread[n];
//        减血
        Thread[] reduceThreads = new Thread[n];

        for (int i = 0; i < n; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    //任何线程要修改hp的值，必须先占用someObject
                    synchronized (someObject) {
                        gareen.recover();
                    }

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            addThreads[i] = t;
        }

        //n个线程减少盖伦的hp
        for (int i = 0; i < n; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    //任何线程要修改hp的值，必须先占用someObject
                    synchronized (someObject) {
                        gareen.hurt();
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            reduceThreads[i] = t;
        }

//        等待所有增加的线程结束
        for (Thread t : addThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        等待所有减少的线程结束
        for (Thread t : reduceThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("%d个增加线程和%d个减少线程结束后%n盖伦的血量变成了 %.0f%n", n, n, gareen.hp);
    }

    /**
     * 展示问题
     */
    public void theProblem() {

        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 10000;
        System.out.printf("盖伦的初始血量是 %.0f%n", gareen.hp);

        //多线程同步问题指的是多个线程同时修改一个数据的时候，导致的问题
        //假设盖伦有10000滴血，并且在基地里，同时又被对方多个英雄攻击
        //用JAVA代码来表示，就是有多个线程在减少盖伦的hp
        //同时又有多个线程在恢复盖伦的hp

        //n个线程增加盖伦的hp
        int n = 16000;
//        加血
        Thread[] addThreads = new Thread[n];
//        减血
        Thread[] reduceThreads = new Thread[n];

        for (int i = 0; i < n; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    gareen.recover();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            addThreads[i] = t;
        }

        //n个线程减少盖伦的hp
        for (int i = 0; i < n; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    gareen.hurt();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            reduceThreads[i] = t;
        }

//        等待所有增加的线程结束
        for (Thread t : addThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        等待所有减少的线程结束
        for (Thread t : reduceThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //代码执行到这里，所有增加和减少线程都结束了
        //增加和减少线程的数量是一样的，每次都增加，减少1.
        //那么所有线程都结束后，盖伦的hp应该还是初始值 正在做增加运算的时候，还没有来得及修改hp的值，减少线程来了
        //但是事实上观察到的是： 最后的值就是9999
        System.out.printf("%d个增加线程和%d个减少线程结束后%n盖伦的血量变成了 %.0f%n", n, n, gareen.hp);


    }
}
