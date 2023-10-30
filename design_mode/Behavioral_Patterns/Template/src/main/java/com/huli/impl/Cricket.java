package com.huli.impl;

import com.huli.Game;

public class Cricket extends Game {
    @Override
    protected void initialize() {
        System.out.println("Cricket 开始");
    }

    @Override
    protected void startPlay() {
        System.out.println("Cricket游戏进行中");
    }

    @Override
    protected void endPlay() {
        System.out.println("Cricket游戏结束");
    }
}
