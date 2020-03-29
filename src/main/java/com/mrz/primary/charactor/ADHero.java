package com.mrz.primary.charactor;

import com.mrz.primary.charactor.intf.ADIntf;

public class ADHero extends Hero implements ADIntf {
    @Override
    public void physicAttack() {
        System.out.println("进行物理攻击");
    }
}
