package gof.creational.abstractfactory;

import gof.creational.abstractfactory.Shape;

public class RoundedRectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Insdie RoundedRectangle::draw() method");
    }
}
