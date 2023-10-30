package com.huli;

import com.huli.impl.Cricket;
import com.huli.impl.Football;

public class Main {
    public static void main(String[] args) {
        System.out.println("欢迎来到模板模式");

        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();

    }
}