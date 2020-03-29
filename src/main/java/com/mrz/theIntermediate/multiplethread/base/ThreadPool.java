package com.mrz.theIntermediate.multiplethread.base;

import java.util.LinkedList;

/**
 * 线程池的思路和生产者消费者模型是很接近的。
 *
 * 1. 准备一个任务容器
 * 2. 一次性启动10个 消费者线程
 * 3. 刚开始任务容器是空的，所以线程都wait在上面。
 * 4. 直到一个外部线程往这个任务容器中扔了一个“任务”，就会有一个消费者线程被唤醒notify
 * 5. 这个消费者线程取出“任务”，并且执行这个任务，执行完毕后，继续等待下一次任务的到来。
 * 6. 如果短时间内，有较多的任务加入，那么就会有多个线程被唤醒，去执行这些任务。
 */
public class ThreadPool {
//    线程大小
    int threadPoolSize;

//    线程容器
    LinkedList<Runnable> tasks = new LinkedList<>();

//试图消费任务的线程
    public ThreadPool() {
        threadPoolSize=10;
//        启动 10 个任务消费者线程
        synchronized (tasks) {
            for (int i = 0; i < threadPoolSize; i++) {
                new TaskConsumeThread("任务消费线程 " + i).start();
            }
        }
    }

    public void add(Runnable r) {
        synchronized (tasks) {
            tasks.add(r);
//            唤醒等待的任务消费者线程
            tasks.notifyAll();
        }
    }

    class TaskConsumeThread extends Thread{
        public TaskConsumeThread(String name) {
            super(name);
        }

        Runnable task;

        @Override
        public void run() {
            System.out.println("启动：" + this.getName());
            while (true) {
                synchronized (tasks) {
                    while (tasks.isEmpty()) {
                        try {
                            tasks.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    task = tasks.removeLast();
                    tasks.notifyAll();
                }
                System.out.println(this.getName()+" 获取到任务，并执行");
                task.run();
            }
        }
    }

}
