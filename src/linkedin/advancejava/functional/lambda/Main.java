package linkedin.advancejava.functional.lambda;

import linkedin.advancejava.functional.GreetingMessage;
import linkedin.advancejava.functional.MessagePrinter;

public class Main {
    public static void main(String[] args) {
        GreetingMessage gm = new GreetingMessage() {
            @Override
            public void greet(String name) {
                System.out.println("HELLO " + name);
            }
        };
        gm.greet("Adam!");
        /*
        NOTE: I implement a new greeting message instance using an anonymous inner class.
        Override greet message followed by name parsed in.
        <p>
        THE BETTER:
        Instead of using all this boiler plate code,
        I can use a lambda instead to make the code shorter and simpler,
         */

        /*
        1 - Place pair of brackets.
        2 - put same argument from the overriden method (SAM) inside brackets,
            we can omit type just variable name. but for the sake of readability you can also put type - String.
        3 - Put an arrow which is a dash followed by a closing angular bracket.
        4 - Then for define body of the method, use a pair of curly braces.
        5 - Then copy same print line to console to keep the method body the same.
        6 - Put a semi colon after the closing curly brace.

        NOTE: if there are multiple arguments, just add inside brackets just the same as I normally woudld when overwriting a method.
         */
        GreetingMessage gm1 = (String name) -> {
            System.out.println("HELLO " + name);
        };
        gm1.greet("Leah!");

        MessagePrinter mp = () -> { // no arguments from SAM of MessagePrinter
            System.out.println("This is a message");
        };
    }
    /*
    Functional Interface allows java programmers to pass code around as data.
    At the moment, the codes to implement my functional interface is quite long and messy
    considering all it does is provide one new line of functionality.
    <p>
    Lambdas are introduced to improve this.
    it provides short and simple way to implement functional interfaces in Java.
    <p>
    Lambdas are a quick and simple way of implementing functinal interfaces, they look quite different.
    They look different to anonymous inner classes, but the logic is the same.
     */
}
