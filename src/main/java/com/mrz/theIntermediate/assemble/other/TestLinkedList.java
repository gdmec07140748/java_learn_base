package com.mrz.theIntermediate.assemble.other;

import com.mrz.primary.charactor.Hero;

import java.util.LinkedList;
import java.util.Queue;

public class TestLinkedList {
    public static void main(String[] args) {
        TestLinkedList testDeque = new TestLinkedList();

        testDeque.queueTest();
//        testDeque.dequeTest();

    }

    /**
     * LinkedList 除了实现了List和Deque外，还实现了Queue接口(队列)。
     * Queue是先进先出队列 FIFO，常用方法：
     *  offer 在最后添加元素
     *  poll 取出第一个元素
     *  peek 查看第一个元素
     */
    public void queueTest() {
        //LinkedList是一个双向链表结构的list
        LinkedList<Hero> ll = new LinkedList<>();

        Queue<Hero> q = new LinkedList<>();

        System.out.println("初始化队列: \t");
        q.offer(new Hero("Hero 1"));
        q.offer(new Hero("Hero 2"));
        q.offer(new Hero("Hero 3"));

        System.out.println(q);

        System.out.print("把第一个元素取poll()出来:\t");
        //取出第一个Hero，FIFO 先进先出
        Hero h = q.poll();
        System.out.println(h);
        System.out.println("取出第一个元素后的队列：\t");
        System.out.println(q);

        //把第一个拿出来看一看，但是不取出来
        h  = q.peek();
        System.out.print("查看peek()第一个元素:\t");
        System.out.println(h);
        System.out.print("查看并不会导致第一个元素被取出来:\t");
        System.out.println(q);
    }

    /**
     * 除了实现了List接口外，LinkedList还实现了双向链表结构Deque，可以很方便的在头尾插入删除数据
     */
    public void dequeTest() {
        //LinkedList是一个双向链表结构的list
        LinkedList<Hero> ll = new LinkedList<>();

        //所以可以很方便的在头部和尾部插入数据
        //在最后插入新的英雄
        ll.addLast(new Hero("hero1"));
        ll.addLast(new Hero("hero2"));
        ll.addLast(new Hero("hero3"));
        System.out.println(ll);

        //在最前面插入新的英雄
        ll.addFirst(new Hero("hero XX"));
        System.out.println(ll);

        //查看最前面的英雄
        System.out.println(ll.getFirst());
        // 查看最后面的英雄
        System.out.println(ll.getLast());

//        查看是否会导致英雄删除
        System.out.println(ll);
        //取出最后面的英雄
        System.out.println(ll.removeLast());

//        取出会导致英雄删除
        System.out.println(ll);

    }
}
