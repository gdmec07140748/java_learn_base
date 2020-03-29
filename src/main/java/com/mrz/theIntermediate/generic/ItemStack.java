package com.mrz.theIntermediate.generic;

import com.mrz.primary.charactor.Hero;
import com.mrz.primary.charactor.HeroStack;
import com.mrz.primary.property.Item;

import java.util.LinkedList;

public class ItemStack {

    LinkedList<Item> items = new LinkedList<>();

    public void push(Item h) {
        items.addLast(h);
    }

    public Item pull() {
        return items.removeLast();
    }

    public Item peek() {
        return items.getLast();
    }

    public static void main(String[] args) {
        ItemStack itemStack = new ItemStack();
        for (int i = 0; i < 5; i++) {
            Item item = new Item("item name " + i);
            System.out.println("压入 item：" + item);
            itemStack.push(item);
        }
        for (int i = 0; i < 5; i++) {
            Item item = itemStack.pull();
            System.out.println("弹出 hero " + item);
        }
    }
}
