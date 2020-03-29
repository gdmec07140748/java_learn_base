package com.mrz.theIntermediate.assemble.collection;

import com.mrz.primary.charactor.Hero;

import java.util.ArrayList;

/**
 * 集合常用操作方法
 */
public class HandleCollection {

	public static void main(String args[]) { 

	}

	// --- 集合 常用方法

	/**
	 * 清空
	 */
	public void clearCollection() {
		ArrayList herosArrayList = new ArrayList();
//		初始化 5 个对象
		for (int i = 0; i < 5; i++) {
			herosArrayList.add(new Hero("hero " + i));
		}
		System.out.println("herosArrayList :\t" + herosArrayList);

		System.out.println("使用 clear 清空");
		herosArrayList.clear();
		System.out.println("herosArrayList :\t" + herosArrayList);
	}

	/**
	 * 把另一个容器所有对象加入进来
	 */
	public void addAllCollection() {
		ArrayList herosArrayList = new ArrayList();
//		初始化 5 个对象
		for (int i = 0; i < 5; i++) {
			herosArrayList.add(new Hero("hero " + i));
		}
		System.out.println(herosArrayList);

		ArrayList anotherArrayList = new ArrayList();
		anotherArrayList.add(new Hero("hero a"));
		anotherArrayList.add(new Hero("hero b"));
		anotherArrayList.add(new Hero("hero c"));
		System.out.println("anotherHeros heros:\t" + anotherArrayList);
		herosArrayList.addAll(anotherArrayList);
		System.out.println("把另一个ArrayList的元素都加入到当前ArrayList:");
		System.out.println("ArrayList heros:\t" + herosArrayList);
	}

	/**
	 * 转换为数组 如果要转换为一个Hero数组，那么需要传递一个Hero数组类型的对象给toArray()，
	 * 这样toArray方法才知道，你希望转换为哪种类型的数组，否则只能转换为Object数组
	 */
	public void toArrayCollection() {
		ArrayList herosArrayList = new ArrayList();
//		初始化 5 个对象
		for (int i = 0; i < 5; i++) {
			herosArrayList.add(new Hero("hero " + i));
		}

		Hero specialHero = new Hero("Special hero");
		herosArrayList.add(specialHero);

		System.out.println(herosArrayList);
		Hero hs[] = (Hero[]) herosArrayList.toArray(new Hero[] {});
		System.out.println("数组：" + hs);
	}

	/**
	 * 获取大小
	 */
	public void getSizeCollection() {

		ArrayList herosArrayList = new ArrayList();
//		初始化 5 个对象
		for (int i = 0; i < 5; i++) {
			herosArrayList.add(new Hero("hero " + i));
		}

		Hero specialHero = new Hero("Special hero");
		herosArrayList.add(specialHero);

		System.out.println(herosArrayList);
		System.out.println("获取ArrayList的大小：");
		System.out.println(herosArrayList.size());
	}

	/**
	 * 替换指定位置的元素
	 */
	public void setCollection() {

		ArrayList herosArrayList = new ArrayList();
//		初始化 5 个对象
		for (int i = 0; i < 5; i++) {
			herosArrayList.add(new Hero("hero " + i));
		}

		Hero specialHero = new Hero("Special hero");
		herosArrayList.add(specialHero);

		System.out.println(herosArrayList);
		System.out.println("把下标是5的元素，替换为\"hero 5\"");
		herosArrayList.set(5, new Hero("hero 5"));
		System.out.println(herosArrayList);
	}

	/**
	 * 删除对象
	 */
	public void removeCollection() {
		ArrayList herosArrayList = new ArrayList();
//		初始化 5 个对象
		for (int i = 0; i < 5; i++) {
			herosArrayList.add(new Hero("hero " + i));
		}

		Hero specialHero = new Hero("Special hero");
		herosArrayList.add(specialHero);

		System.out.println(herosArrayList);
		herosArrayList.remove(2);
		System.out.println("删除下标 2 的对象");
		System.out.println(herosArrayList);
		System.out.println("删除special hero");
		herosArrayList.remove(specialHero);
		System.out.println(herosArrayList);
	}

	/**
	 * 获取对象所处的位置
	 */
	public void getIndexObjectCollection() {
		ArrayList herosArrayList = new ArrayList();
//		初始化 5 个对象
		for (int i = 0; i < 5; i++) {
			herosArrayList.add(new Hero("hero " + i));
		}

		Hero specialHero = new Hero("Special hero");
		herosArrayList.add(specialHero);

		System.out.println(herosArrayList);
		System.out.println("specialHero 所处的位置：" + herosArrayList.indexOf(specialHero));
		System.out.println("新的英雄，但是名字是\"hero 1\"所处的位置:" + herosArrayList.indexOf(new Hero("hero 1")));
	}

	/**
	 * 获取指定位置的对象
	 */
	public void getIndexCollection() {
		ArrayList herosArrayList = new ArrayList();
//		初始化 5 个对象
		for (int i = 0; i < 5; i++) {
			herosArrayList.add(new Hero("hero " + i));
		}

		Hero specialHero = new Hero("Special hero");
		herosArrayList.add(3, specialHero);
		System.out.println(herosArrayList.toString());
		// 获取指定位置的对象
		System.out.println(herosArrayList.get(5));
		// 如果超出了范围，依然会报错
		System.out.println(herosArrayList.get(9));
	}

	/**
	 * 是否存在，是否为同一个对象
	 */
	public void containsCollection() {
		ArrayList herosArrayList = new ArrayList();
//		初始化 5 个对象
		for (int i = 0; i < 5; i++) {
			herosArrayList.add(new Hero("hero " + i));
		}

		Hero specialHero = new Hero("Special hero");
		herosArrayList.add(3, specialHero);
		System.out.println(herosArrayList.toString());
		// 判断一个对象是否在容器中
		// 判断标准： 是否是同一个对象，而不是name是否相同
		System.out.print("虽然一个新的对象名字也叫 hero 1，但是contains的返回是:");
		System.out.println(herosArrayList.contains(new Hero("hero 1")));
		System.out.print("而对specialHero的判断，contains的返回是:");
		System.out.println(herosArrayList.contains(specialHero));
	}

	/**
	 * 对象添加
	 */
	public void addCollection() {
		ArrayList herosArrayList = new ArrayList();
		// 把 5 个对象加入到 ArrayList 中
		for (int i = 0; i < 5; i++) {
			herosArrayList.add(new Hero("hero " + i));
		}
		System.out.println(herosArrayList);

//		在指定位置添加对象
		Hero specialHero = new Hero("Special hero");
		herosArrayList.add(3, specialHero);
		System.out.println(herosArrayList.toString());
	}
}
