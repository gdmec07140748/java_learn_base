package com.mrz.theIntermediate.assemble.collection;

import com.mrz.primary.charactor.Hero;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 集合迭代方法
 */
public class IteratorCollection {

	public static void main(String args[]) {
	}

	// --- 遍历

	/**
	 * 增强型 for 循环
	 */
	public void strengthenForCollection() {

		List<Hero> heros = new ArrayList<Hero>();

		for (int i = 0; i < 5; i++) {
			heros.add(new Hero("hero name " + i));
		}

		for (Hero hero : heros) {
			System.out.println(hero);
		}
	}

	/**
	 * 迭代器遍历
	 */
	public void iteratorCollection() {
		List<Hero> heros = new ArrayList<Hero>();

		for (int i = 0; i < 5; i++) {
			heros.add(new Hero("hero name " + i));
		}
		Iterator<Hero> iterator = heros.iterator();
		// 从最开始的位置判断"下一个"位置是否有数据
		// 如果有就通过next取出来，并且把指针向下移动
		// 直到"下一个"位置没有数据
		while (iterator.hasNext()) {
			Hero hero = (Hero) iterator.next();
			System.out.println(hero);
		}

//		迭代器 for 写法
		for (Iterator<Hero> iterator2 = heros.iterator(); iterator2.hasNext();) {
			Hero hero = (Hero) iterator2.next();
			System.out.println(hero);

		}
	}

	/**
	 * for 循环
	 */
	public void forCollection() {
		List<Hero> heros = new ArrayList<Hero>();

		for (int i = 0; i < 5; i++) {
			heros.add(new Hero("hero name " + i));
		}

		for (int i = 0; i < heros.size(); i++) {
			Hero hero = heros.get(i);
			System.out.println(hero);
		}
	}
}
