package ocp.reviewtopics;

/**
 * Create and use subclasses and superclasses, including abstract classes.
 * An abstract class is a class that is declared abstract—it may or may not include abstract methods.
 * Abstract classes cannot be instantiated, but they can be subclassed.
 */
public abstract class Review3SubSupAbsClasses {
    // An abstract method is a method that is declared without an implementation (without braces, and followed by a semicolon), like this:
    abstract void moveTo(double deltaX, double deltaY);
    // If a class includes abstract methods, then the class itself must be declared abstract, as in:
    abstract void draw();
    /*
        abstract classes, you can declare fields that are not static and final,
        and define public, protected, and private concrete methods.
     */
    public int number;
    protected String str;

    private void concrete() {

    }


}

/**
 * When an abstract class is subclassed (extends Review3SubSupAbsClasses), the subclass usually
 * provides implementations for all of the abstract methods in its parent class.
 */
class SubClass extends Review3SubSupAbsClasses {

    @Override
    void moveTo(double deltaX, double deltaY) {
        // Implementation.
    }

    @Override
    void draw() {
        // Implementation.
    }
}

/**
 * However, if it does not, then the subclass must also be declared abstract.
 */
abstract class AbstractSubClass extends Review3SubSupAbsClasses {
    // No implementations for all of the abstract methods of it's parent class.
}

/**
 * Methods in an interface (see the Interfaces section) that are not declared as
 * default or static are implicitly abstract, so the abstract modifier is not used
 * with interface methods. (It can be used, but it is unnecessary.)
 *
 *  With interfaces, all fields are automatically public, static, and final,
 *  and all methods that you declare or define (as default methods) are public.
 */
interface Interface {
    // constant declarations, if any
    String str1 = "str1";

    // implicitly abstract / method signatures
    // Note that the method signatures have no braces and are terminated with a semicolon.
    void method1();
    void method2();

    // explicitly abstract
    // Method bodies exist only for default methods and static methods.
    default void method3() {
        // default method in interface must add method body of implementation.
    }

    static void method4() {
        // static method in interface must add method body of implementation.
    }
}
/*
    NOTE: an interface is a reference type, similar to a class, that can contain only constants,
    method signatures, default methods, static methods, and nested types.
 */

// Interfaces cannot be instantiated—
// they can only be implemented by classes or
class Class1 implements Interface {

    @Override
    public void method1() {

    }

    @Override
    public void method2() {

    }
}

// extended by other interfaces.
interface Interface1 extends Interface {

}

// abstract - you can extend only one class. (not sure?)
class Class2 extends Review3SubSupAbsClasses{

    @Override
    void moveTo(double deltaX, double deltaY) {

    }

    @Override
    void draw() {

    }
}

// whereas you can implement any number of interfaces.
interface Interface2 extends Interface {

}

/*
    Which should you use, abstract classes or interfaces?

    Consider using abstract classes if any of these statements apply to your situation:
        - You want to share code among several closely related classes.
        - You expect that classes that extend your abstract class have many common methods or fields, or require access modifiers other than public (such as protected and private).
        - You want to declare non-static or non-final fields. This enables you to define methods that can access and modify the state of the object to which they belong.
    Consider using interfaces if any of these statements apply to your situation:
        - You expect that unrelated classes would implement your interface. For example, the interfaces Comparable and Cloneable are implemented by many unrelated classes.
        - You want to specify the behavior of a particular data type, but not concerned about who implements its behavior.
        - You want to take advantage of multiple inheritance of type.
 */

/*
    An Abstract Class Example:

                Graphic Object
        ______________|____________
        |         |       |       |
    Rectangle   Line    Bezier  Circle

    All GraphicObjects must be able to draw or resize themselves; they just differ in how they do it.
    This is a perfect situation for an abstract superclass. You can take advantage of the similarities
    and declare all the graphic objects to inherit from the same abstract parent object (for example, GraphicObject)
 */

abstract class GraphicObject {
    int x, y;
    // provide member variables and methods that are wholly shared by all subclasses,
    // such as the current position and the moveTo method.
    void moveTo(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }
    // abstract methods for methods, such as draw or resize, that need to be implemented
    // by all subclasses but must be implemented in different ways.
    abstract void draw();
    abstract void resize();
}
/*
    Circle and Rectangle, must provide implementations for the draw and resize methods:
 */
class Circle extends GraphicObject {

    @Override
    void draw() {
        // Implementation
    }

    @Override
    void resize() {
        // Implementation
    }
}
class Rectangle extends GraphicObject {

    @Override
    void draw() {
        // Implementation
    }

    @Override
    void resize() {
        // Implementation
    }
}

interface Y {
    void processY();
    void processX();
    void processZ();
}
/*
    declared the class to be abstract,
    to define a class that does not implement all of the interface's methods.
    class X must be abstract because it does not fully implement Y,
    but class XX does, in fact, implement Y.
 */
abstract class X implements Y {
    @Override
    public void processX() {

    }
}
class XX extends X {

    @Override
    public void processY() {

    }

    @Override
    public void processX() {

    }

    @Override
    public void processZ() {

    }
}