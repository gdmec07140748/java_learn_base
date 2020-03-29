package com.mrz.theIntermediate.multiplethread;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1. Lock是一个接口，而synchronized是Java中的关键字，synchronized是内置的语言实现，Lock是代码层面的实现。
 * 2. Lock可以选择性的获取锁，如果一段时间获取不到，可以放弃。synchronized不行，会一根筋一直获取下去。 借助Lock的这个特性，就能够规避死锁，
 *      synchronized必须通过谨慎和良好的设计，才能减少死锁的发生。
 * 3. synchronized在发生异常和同步块结束的时候，会自动释放锁。而Lock必须手动释放， 所以如果忘记了释放锁，一样会造成死锁。
 */
public class LockThread {
    public static String now() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    public static void log(String msg) {
        System.out.printf("%s %s %s %n", now(), Thread.currentThread().getName(), msg);
    }

    public static void main(String[] args) {
        LockThread lockThread = new LockThread();
        lockThread.threadNInteraction();
//        lockThread.useTryLock();
//        lockThread.useLock();
//        lockThread.test();
    }

    /**
     * 线程交互
     * 使用synchronized方式进行线程交互，用到的是同步对象的wait,notify和notifyAll方法
     * Lock也提供了类似的解决办法，首先通过lock对象得到一个Condition对象，然后分别调用这个Condition对象的：await, signal,signalAll 方法
     */
    public void threadNInteraction() {
        final Lock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    log("线程启动");
                    log("试图占有对象：lock");
                    lock.lock();

                    log("占有对象：lock");
                    log("进行 5 秒的业务操作");
                    Thread.sleep(5000);

                    log("释放对象 lock，并等待");
                    condition.await();
                    log("重新占有对象 lock,并进行 5 秒的业务操作");
                    Thread.sleep(5000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    log("释放对象：lock");
                }
                log("线程结束");
            }
        };
        t1.setName("t1");
        t1.start();

        try {
//            先让 t1 飞 2 秒
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2 = new Thread() {
            @Override
            public void run() {
                boolean locked = false;
                try {
                    log("线程启动");
                    log("试图占有对象：lock");

                    lock.lock();

                    log("占有对象：lock");
                    log("进行 5 秒的业务操作");
                    Thread.sleep(5000);
                    log("唤醒等待中的线程");
                    condition.signal();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    log("释放对象：lock");
                    lock.unlock();
                }
                log("线程结束");
            }
        };
        t2.setName("t2");
        t2.start();

    }

    /**
     * synchronized 是不占用到手不罢休的，会一直试图占用下去。
     * 与 synchronized 的钻牛角尖不一样，Lock接口还提供了一个trylock方法。
     * trylock会在指定时间范围内试图占用，占成功了，就啪啪啪。 如果时间到了，还占用不成功，扭头就走~
     * <p>
     * 注意： 因为使用trylock有可能成功，有可能失败，所以后面unlock释放锁的时候，需要判断是否占用成功了，如果没占用成功也unlock,就会抛出异常
     */

    public void useTryLock() {
        final Lock lock = new ReentrantLock();

        Thread t1 = new Thread() {
            @Override
            public void run() {

                boolean locked = false;
                try {
                    log("线程启动");
                    log("试图占有对象：lock");

                    locked = lock.tryLock(1, TimeUnit.SECONDS);

                    if (locked) {
                        log("占有对象：lock");
                        log("进行 5 秒的业务操作");
                        Thread.sleep(5000);
                    } else {
                        log("经过1秒钟的努力，还没有占有对象，放弃占有");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (locked) {
                        log("释放对象：lock");
                        lock.unlock();
                    }
                }
                log("线程结束");
            }
        };
        t1.setName("t1");
        t1.start();

        try {
//            先让 t1 飞 2 秒
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2 = new Thread() {
            @Override
            public void run() {
                boolean locked = false;
                try {
                    log("线程启动");
                    log("试图占有对象：lock");

                    locked = lock.tryLock(1, TimeUnit.SECONDS);

                    if (locked) {
                        log("占有对象：lock");
                        log("进行 5 秒的业务操作");
                        Thread.sleep(5000);
                    } else {
                        log("经过1秒钟的努力，还没有占有对象，放弃占有");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (locked) {
                        log("释放对象：lock");
                        lock.unlock();
                    }
                }
                log("线程结束");
            }
        };
        t2.setName("t2");
        t2.start();

    }

    /**
     * 使用Lock对象实现同步效果
     */
    public void useLock() {
        final Lock lock = new ReentrantLock();

        Thread t1 = new Thread() {
            @Override
            public void run() {

                try {
                    log("线程启动");
                    log("试图占有对象：lock");
                    lock.lock();
                    log("占有对象：lock");
                    log("进行 5 秒的业务操作");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.setName("t1");
        t1.start();

        try {
//            先让 t1 飞 2 秒
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    log("线程启动");
                    log("试图占有对象：lock");
                    lock.lock();
                    log("占有对象：lock");
                    log("进行 5 秒的业务操作");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t2.setName("t2");
        t2.start();

    }

    /**
     * synchronized
     * 测试效果
     */
    public void test() {
        final Object someObject = new Object();

        Thread t1 = new Thread() {
            public void run() {
                try {
                    System.out.println(now() + " t1 线程已经运行");
                    System.out.println(now() + this.getName() + " 试图占有对象：someObject");
                    synchronized (someObject) {

                        System.out.println(now() + this.getName() + " 占有对象：someObject");
                        Thread.sleep(5000);
                        System.out.println(now() + this.getName() + " 释放对象：someObject");
                    }
                    System.out.println(now() + " t1 线程结束");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
        t1.setName(" t1");
        t1.start();
        Thread t2 = new Thread() {

            public void run() {
                try {
                    System.out.println(now() + " t2 线程已经运行");
                    System.out.println(now() + this.getName() + " 试图占有对象：someObject");
                    synchronized (someObject) {
                        System.out.println(now() + this.getName() + " 占有对象：someObject");
                        Thread.sleep(5000);
                        System.out.println(now() + this.getName() + " 释放对象：someObject");
                    }
                    System.out.println(now() + " t2 线程结束");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
        t2.setName(" t2");
        t2.start();
    }
}
