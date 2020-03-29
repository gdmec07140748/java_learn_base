package com.mrz.primary.charactor;

public class Hero {

	public String name;
	public float hp;

	public int damage;


	
	public Hero() {
	}

	public Hero(String name) {
		this.name = name;
	}

	//回血
	public void recover(){
		hp=hp+1;
	}

	//掉血
	public void hurt(){
		hp=hp-1;
	}

	/**
	 * 掉血线程
	 * @param h
	 */
	public void attackHeroThread(Hero h) {
		h.hp-=damage;
		System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n",name,h.name,h.name,h.hp);
		if(h.isDead())
			System.out.println(h.name +"死了！");
	}

	/**
	 * 攻击英雄
	 * @param h
	 */
	public void attackHero(Hero h) {

		try {
			//为了表示攻击需要时间，每次攻击暂停1000毫秒
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		h.hp-=damage;
		System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n",name,h.name,h.name,h.hp);

		if(h.isDead())
			System.out.println(h.name +"死了！");
	}

	/**
	 * 攻击英雄
	 * 去除暂停时间
	 * 把暂停时间去掉，多条线程各自会尽力去占有CPU资源
	 * @param h
	 */
	public void attackHeroNoStop(Hero h) {

		try {
			//为了表示攻击需要时间，每次攻击暂停1000毫秒
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		h.hp-=damage;
		System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n",name,h.name,h.name,h.hp);

		if(h.isDead())
			System.out.println(h.name +"死了！");
	}

	public boolean isDead() {
		return 0>=hp?true:false;
	}


	@Override
	public String toString() {
		return "Hero [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getHp() {
		return hp;
	}

	public void setHp(float hp) {
		this.hp = hp;
	}

}
