package gof.creational.abstractfactory;

public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        // Get shape factory.
        AbstractFactory shapeFactory = FactoryProducer.getFactory(false);
        // Get an object of Shape Rectangle.
        Shape shape1 = shapeFactory.getShape("RECTANGLE");
        // Call draw method of Shape Rectangle.
        shape1.draw();
        // Get an object of Shape Square
        Shape shape2 = shapeFactory.getShape("SQUARE");
        // Call draw method of Shape Square.
        shape2.draw();
        // Get shape factory.
        AbstractFactory shapeFactory1 = FactoryProducer.getFactory(true);
        // Get an object of Shape Rectangle.
        Shape shape3 = shapeFactory1.getShape("RECTANGLE");
        // Call draw method of Shape Rectangle.
        shape3.draw();
        // Get an object of Shape Square.
        Shape shape4 = shapeFactory1.getShape("SQUARE");
        //call draw method of Shape Square
        shape4.draw();
    }
}
