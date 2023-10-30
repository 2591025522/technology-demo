package com.huli.factoryproduer;

import com.huli.factory.AbstractFactory;
import com.huli.factory.impl.ColorFactory;
import com.huli.factory.impl.ShapeFactory;

public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if (choice.equalsIgnoreCase("shape")){
            return new ShapeFactory();
        }else if (choice.equalsIgnoreCase("color")){
            return new ColorFactory();
        }
        return null;
    }
}
