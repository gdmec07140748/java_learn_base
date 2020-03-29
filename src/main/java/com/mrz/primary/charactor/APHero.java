package com.mrz.primary.charactor;

import com.mrz.primary.charactor.intf.APIntf;

public class APHero extends Hero implements APIntf {

    @Override
    public void magicAttack() {
        System.out.println("进行魔法攻击");
    }
}
