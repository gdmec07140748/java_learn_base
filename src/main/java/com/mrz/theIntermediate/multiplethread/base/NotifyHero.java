package com.mrz.theIntermediate.multiplethread.base;

/**
 * synchronized 同步线程 占有,释放后使用 notify() 通知
 * 其他线程进来调用 wait() 方法等通知
 */
public class NotifyHero {

    public String name;
    public float hp;

    public int damage;

    //回血
    public synchronized void recover() {
        hp = hp + 1;
        System.out.printf("%s 回血1点,增加血后，%s的血量是%.0f%n", name, name, hp);
//        通知那些等待在this对象上的线程，可以醒过来了，如第27行，等待着的减血线程，苏醒过来 wait()
        this.notify();
    }

    //掉血
    public void hurt() {
        if (hp == 1) {
            try {
//                让占有this的减血线程，暂时释放对this的占有，并等待
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hp = hp-1;
        System.out.printf("%s 减血1点,减少血后，%s的血量是%.0f%n", name, name, hp);
    }

    public void attackHero(NotifyHero h) {
        h.hp -= damage;
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n", name, h.name, h.name, h.hp);
        if (h.isDead())
            System.out.println(h.name + "死了！");
    }

    public boolean isDead() {
        return 0 >= hp ? true : false;
    }
}
