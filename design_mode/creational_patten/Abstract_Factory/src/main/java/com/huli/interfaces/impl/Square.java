package com.huli.interfaces.impl;

import com.huli.interfaces.Shape;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square");
    }
}
