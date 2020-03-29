package com.mrz.primary.property;

/**
 * 物品类
 */
public class Item {

    String name;
    int price;


    public Item() {

    }

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item [name=" + name + "]";
    }
}
