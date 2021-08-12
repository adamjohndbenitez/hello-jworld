package gof.creational.abstractfactory;

public class FactoryProducer {
    public static AbstractFactory getFactory(boolean isRounded) {
        if (isRounded) return new RoundedShapeFactory();
        else return new ShapeFactory();
    }
}
