package com.huli.interfaces.impl;

import com.huli.interfaces.Clothes;

public class Cap implements Clothes {
    @Override
    public void clothesName() {
        System.out.println("工厂生产了一件帽子");
    }
}
