package com.mrz.theIntermediate.generic;

import com.mrz.primary.charactor.Hero;
import com.mrz.primary.property.Item;

import java.util.LinkedList;

/**
 * 在类的声明上，加上一个<T>，表示该类支持泛型。
 * T是type的缩写，也可以使用任何其他的合法的变量，比如A,B,X都可以，但是一般约定成俗使用T，代表类型。
 *
 * @param <T>
 */
public class MyStack<T> {

    LinkedList<T> values = new LinkedList<>();

    public void push(T t) {
        values.addLast(t);
    }

    public T pull() {
        return values.removeLast();
    }

    public T peek() {
        return values.getLast();
    }

    public static void main(String[] args) {
        MyStack<Hero> heroMyStack = new MyStack<>();
        heroMyStack.push(new Hero());
//        heroMyStack.push(new Item()); // error

    }
}
