package gof.creational.prototype;

import java.util.Hashtable;

public class ShapeCache {
    private static Hashtable<String, Shape> shapeHashtable = new Hashtable<>();

    public static Shape getShape(String shapeId) {
        Shape cachedShape = shapeHashtable.get(shapeId);
        return (Shape) cachedShape.clone();
    }

    /*
        For each shape run database query and create shape
        shapeMap.put(shapeKey, shape);
        for example, we are adding three shapes.
     */
    public static void loadCache() {
        Circle circle = new Circle();
//        Shape circle = new Circle(); // Works too.
        circle.setId("1");
        shapeHashtable.put(circle.getId(), circle);

        Square square = new Square();
//        Shape square = new Square(); // Works too.
        square.setId("2");
        shapeHashtable.put(square.getId(), square);

        Rectangle rectangle = new Rectangle();
//        Shape rectangle = new Rectangle(); // Works too.
        rectangle.setId("3");
        shapeHashtable.put(rectangle.getId(), rectangle);
    }
}
