package gof.creational.prototype;

/**
 * Prototype pattern refers to creating duplicate object while keeping performance in mind.
 *
 * This pattern involves implementing a prototype interface which tells to create a clone of
 * the current object. This pattern is used when creation of object directly is costly.
 * For example, an object is to be created after a costly database operation.
 * We can cache the object, returns its clone on next request and update the database
 * as and when needed thus reducing database calls.
 */
public class PrototypePatternDemo {
    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape cloneShape = ShapeCache.getShape("1");
        System.out.println("Shape : " + cloneShape.getType());
        Shape cloneShape2 = ShapeCache.getShape("2");
        System.out.println("Shape : " + cloneShape2.getType());
        Shape cloneShape3 = ShapeCache.getShape("3");
        System.out.println("Shape : " + cloneShape3.getType());
    }
}
