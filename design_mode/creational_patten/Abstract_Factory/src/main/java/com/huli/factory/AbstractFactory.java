package com.huli.factory;

import com.huli.interfaces.Color;
import com.huli.interfaces.Shape;

public abstract class AbstractFactory {
    public abstract Color getColor(String colorName);
    public abstract Shape getShape(String shapeName);
}
