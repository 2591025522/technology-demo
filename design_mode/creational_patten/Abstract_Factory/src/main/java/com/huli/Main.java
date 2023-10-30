package com.huli;

import com.huli.factory.AbstractFactory;
import com.huli.factoryproduer.FactoryProducer;
import com.huli.interfaces.Color;
import com.huli.interfaces.Shape;

public class Main {
    public static void main(String[] args) {
        System.out.println("欢迎来到抽象工厂模式");

        AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
        Shape shape1 = shapeFactory.getShape("Rectangle");
        shape1.draw();
        AbstractFactory colorFactory = FactoryProducer.getFactory("color");
        Color color1 = colorFactory.getColor("Gree");
        color1.fill();

        Shape shape2 = shapeFactory.getShape("Square");
        shape2.draw();
        Color color2 = colorFactory.getColor("Red");
        color2.fill();


    }
}