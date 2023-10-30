package com.huli.impl;

import com.huli.Game;

public class Football extends Game {
    @Override
    protected void initialize() {
        System.out.println("足球比赛开始");
    }

    @Override
    protected void startPlay() {
        System.out.println("足球比赛进行中");
    }

    @Override
    protected void endPlay() {
        System.out.println("足球比赛结束");
    }
}
