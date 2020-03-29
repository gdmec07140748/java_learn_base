package com.mrz.theIntermediate.multiplethread;

import com.mrz.theIntermediate.multiplethread.base.ThreadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池 测试
 */
public class TestPoolThread {
    public static void main(String[] args) {
        TestPoolThread testPoolThread = new TestPoolThread();
        testPoolThread.javaPool();
//        testPoolThread.runPool2();
//        testPoolThread.runPool();

    }


    /**
     *使用java自带线程池
     *
     *  第一个参数10 表示这个线程池初始化了10个线程在里面工作
     *  第二个参数15 表示如果10个线程不够用了，就会自动增加到最多15个线程
     *  第三个参数60 结合第四个参数TimeUnit.SECONDS，表示经过60秒，多出来的线程还没有接到活儿，就会回收，最后保持池子里就10个
     *  第四个参数TimeUnit.SECONDS 如上
     *  第五个参数 new LinkedBlockingQueue() 用来放任务的集合
     *
     * execute方法用于添加新的任务
     */
    public void javaPool() {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10, 15, 60,
                TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        poolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("任务1");
            }
        });
    }

    /**
     * 运行2
     * 创造一个情景，每个任务执行的时间都是1秒
     * 刚开始是间隔1秒钟向线程池中添加任务
     *
     * 然后间隔时间越来越短，执行任务的线程还没有来得及结束，新的任务又来了。
     * 就会观察到线程池里的其他线程被唤醒来执行这些任务
     */
    public void runPool2() {
        ThreadPool pool = new ThreadPool();
        int sleep = 1000;
        while (true) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
//
                    System.out.println("执行任务");
                    //任务可能是打印一句话
                    //可能是访问文件
                    //可能是做排序
                }
            };
            pool.add(task);
            try {
                Thread.sleep(sleep);
                sleep = sleep > 100 ? sleep - 100 : sleep;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 运行
     */
    public void runPool() {
        ThreadPool pool = new ThreadPool();

        for (int i = 0; i < 5; i++) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
//
                    System.out.println("执行任务");
                    //任务可能是打印一句话
                    //可能是访问文件
                    //可能是做排序
                }
            };
            pool.add(task);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
