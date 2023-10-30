package com.huli;

import com.huli.factory.ClothesFactory;
import com.huli.interfaces.Clothes;
import com.huli.interfaces.impl.Cap;

public class Main {
    public static void main(String[] args) {
        System.out.println("欢迎来到工厂模式");

        ClothesFactory clothesFactory = new ClothesFactory();
        Clothes cap = clothesFactory.getClothes("cap");
        Clothes overcoat = clothesFactory.getClothes("overcoat");
        cap.clothesName();
        overcoat.clothesName();
    }
}