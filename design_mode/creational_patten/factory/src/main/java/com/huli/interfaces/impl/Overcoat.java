package com.huli.interfaces.impl;

import com.huli.interfaces.Clothes;

public class Overcoat implements Clothes {
    @Override
    public void clothesName() {
        System.out.println("工厂创建了一件大衣");
    }
}
