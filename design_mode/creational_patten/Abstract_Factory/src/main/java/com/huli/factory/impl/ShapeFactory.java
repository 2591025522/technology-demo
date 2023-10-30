package com.huli.factory.impl;

import com.huli.factory.AbstractFactory;
import com.huli.interfaces.Color;
import com.huli.interfaces.Shape;
import com.huli.interfaces.impl.Rectangle;
import com.huli.interfaces.impl.Square;

public class ShapeFactory extends AbstractFactory {
    @Override
    public Color getColor(String colorName) {
        return null;
    }

    @Override
    public Shape getShape(String shapeName) {
        if (shapeName == null){
            return null;
        }
        if (shapeName.equalsIgnoreCase("Rectangle")){
            return new Rectangle();
        }else if (shapeName.equalsIgnoreCase("Square")){
            return new Square();
        }
        return null;
    }
}
