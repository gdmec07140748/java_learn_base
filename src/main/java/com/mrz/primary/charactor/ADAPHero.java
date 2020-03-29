package com.mrz.primary.charactor;

import com.mrz.primary.charactor.intf.ADIntf;
import com.mrz.primary.charactor.intf.APIntf;

public class ADAPHero extends Hero implements APIntf, ADIntf {

    @Override
    public void magicAttack() {
        System.out.println("进行魔法攻击");
    }

    @Override
    public void physicAttack() {
        System.out.println("进行物理攻击");
    }
}
