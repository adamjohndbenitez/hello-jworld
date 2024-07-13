package oca.studyguide;

import java.util.Objects;

public class Chapter11LambdaFunctionalInterface {
    public static void main(String[] args) {
        // Includes Lambda Expression
        Strummable instrument = () -> {
            System.out.println("strummed!"); // Lambda expressions must have functional interface.
        };
        instrument.strum();
    }
    @FunctionalInterface
    interface Strummable {
        void strum(); // S.A.M. Single Abstract Method.
    } // F.I. Functional Interface have 1-or-More default methods and 1-or-More static methods
    @FunctionalInterface
    public interface Predicate<T> {
        // Abstract Method:
        boolean test(T t); // Evaluates this predicate on the given argument.
        // Default Methods:
        default Predicate<T> and(Predicate<? super T> other) {
            Objects.requireNonNull(other);
            return t -> test(t) && other.test(t);
        }
        default Predicate<T> or(Predicate<? super T> other) {
            Objects.requireNonNull(other);
            return t -> test(t) || other.test(t);
        }
        default Predicate<T> negate() {
            return t -> !test(t);
        }
    }
}
