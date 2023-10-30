package com.huli.factory.impl;

import com.huli.factory.AbstractFactory;
import com.huli.interfaces.Color;
import com.huli.interfaces.Shape;
import com.huli.interfaces.impl.Gree;
import com.huli.interfaces.impl.Red;

public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(String colorName) {
        if (colorName == null){
            return null;
        }
        if (colorName.equalsIgnoreCase("Gree")){
            return new Gree();
        }else if (colorName.equalsIgnoreCase("Red")){
            return new Red();
        }

        return null;
    }

    @Override
    public Shape getShape(String shapeName) {
        return null;
    }
}
