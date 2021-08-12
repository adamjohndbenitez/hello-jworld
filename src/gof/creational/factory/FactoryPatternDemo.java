package gof.creational.factory;

/**
 * Shape interface and concrete classes implementing the Shape interface.
 * A factory class ShapeFactory, ShapeFactory to get a Shape object.
 * It will pass information (CIRCLE / RECTANGLE / SQUARE) to ShapeFactory
 * to get the type of object it needs.
 */
public class FactoryPatternDemo {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        // Get an object of Circle and call its draw method.
        Shape shape1 = shapeFactory.getShape("CIRCLE");

        // Call draw method of Circle.
        shape1.draw();

        // Get an object of Rectangle and call its draw method.
        Shape shape2 = shapeFactory.getShape("RECTANGLE");

        // Call draw method of Rectangle.
        shape2.draw();

        // Get an object of Rectangle and call its draw method.
        Shape shape3 = shapeFactory.getShape("SQUARE");

        // Call draw method of Rectangle.
        shape3.draw();
    }
}

/*
-------------------------------------------------------------
|                                                           |           ______________
|                                                           |           |   Circle   |
|                      ______________                       |           --------------
|                      |   Circle   | <<interface>>         |           --------------
|                      --------------                       |           |+draw():void|
|                      --------------                       |           --------------
|                      |+draw():void|                       |                 |
|                      --------------                       |                 |
|                            ^                              |                 |
|           impl             |               impl           |                 |
|            ___________________________________            |                 |
|           /                | impl             \           |                 v
|     ______________   ______________    ______________     |  creates  ______________
|     |   Circle   |   |   Circle   |    |   Circle   |     |<-------   |   Circle   |
|     --------------   --------------    --------------     |           --------------
|     --------------   --------------    --------------     |           --------------
|     |+draw():void|   |+draw():void|    |+draw():void|     |           |+draw():void|
|     --------------   --------------    --------------     |           --------------
|                                                           |
|                                                           |
-------------------------------------------------------------
 */