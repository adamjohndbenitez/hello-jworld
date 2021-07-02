package ocp.reviewtopics.review2classes;

import java.io.PrintWriter;

/*
    A functional interface in Java is an interface that contains only
    a single abstract (unimplemented) method. A functional interface
    can contain default and static methods which do have an implementation,
    in addition to the single unimplemented method.
 */
public interface MyFunctionalInterface {
    public void execute();

    // It can contain implementations in default methods, or in static methods.
    // This is functional interface since it only contains a single non-implemented method.
    public default void print(String text) {
        System.out.println(text);
    }

    public static void print(String text, PrintWriter writer) {
        writer.write(text);
    }
}
