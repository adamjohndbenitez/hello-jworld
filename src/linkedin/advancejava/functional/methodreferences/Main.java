package linkedin.advancejava.functional.methodreferences;

import linkedin.advancejava.functional.Shapes;
import linkedin.advancejava.functional.Square;

/**
 * Method References are a shorthand way of writing a certain type of lambda expression.
 * If you have a lambda expression that passes in a variable and then calls a metthod on that variable,
 * you can replace it with method reference.
 */
public class Main {
    public static void main(String[] args) {
        Square s = new Square(4);

        Shapes shapes = (Square square) -> {
            return square.calculateArea();
        };

        System.out.println("Area: " + shapes.getArea(s));

        /*
        SHORTER & SIMPLER: Use Method Reference.
        We can do this cuz all I'm using the lambda for is calling a single method on the squarer object that I am passing in.
        The syntax for a method reference is to
        1 - begin with the name of tthe class
        2 - followed by (2) two colons followed by the name of the method.
        <p>
        So Remove lambdaInstead write Square, which is the class object the I was passing in.
        And then (2) two colons Then just write the method name, calculate area. Don't need to put any bracket.
         */
        Shapes shapes1 = Square::calculateArea;
        System.out.println("Area: " + shapes1.getArea(s));
    }
}
