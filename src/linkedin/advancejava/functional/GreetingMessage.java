package linkedin.advancejava.functional;

/**
 * Lambdas represent the implementation of a functional interface.
 * So before learning how to implement lambdas, it's as useful to understand what a functional interface is.
 * A functional interface is an interface that has only one abstract method.
 *
 */
@FunctionalInterface // Annotate to show that it conforms to tthe rules of a functional interface
public interface GreetingMessage {
    public abstract void greet(String name); // SAM (Single Abstract Method) method called greet.
//    public abstract void test(String name); // ERROR => where annotation is declared, is no longer a functional interface cuz there are multiple non-overriding abstract method.
    /*
    ERROR on cursor hover at @FunctionalInterface annotation:
    Multiple non-overriding abstract methods found in interface linkedin.advancejava.functional.GreetingMessage
     */
}
