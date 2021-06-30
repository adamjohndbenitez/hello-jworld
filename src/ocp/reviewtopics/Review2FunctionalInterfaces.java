package ocp.reviewtopics;

import ocp.reviewtopics.review.*;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


/*
    Create and use interfaces, identify functional interfaces,
    and utilize private, static, and default methods.
    Functional Interfaces Can Be Implemented by a Lambda Expression.
 */
public class Review2FunctionalInterfaces {
    MyFunctionalInterface lambda = () -> {
        System.out.println("Executing...");
    };
    /*
        A Java lambda expression implements a single method from a Java interface.
        In order to know what method the lambda expression implements,
        the interface can only contain a single unimplemented method.
        In other words, the interface must be a Java functional interface.
     */

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        // Function
        Function<Long, Long> adder1 = new AddThree(); // Creates AddThree instance.
        Long result = adder1.apply((long) 4);
        System.out.println("result = " + result); // Prints 7.

        Function<Long, Long> adder2 = (value) -> value + 3;
        Long resultLambda = adder2.apply((long) 8);
        System.out.println("resultLambda = " + resultLambda);
        /*
            the Function interface implementation is now inlined in the declaration
            of the adderLambda variable, rather than in a separate class.
         */

        // Predicate
        Predicate predicate1 = new CheckForNull(); // The same as the implementation above that uses a class.
        boolean resultPredict1 = predicate1.test(new Object());
        String str1 = resultPredict1 ? "not null" : "null";
        System.out.println("resultPredict = " + str1);

        Predicate predicate2 = (value) -> value != null; // The same as the implementation above that uses a class.
        boolean resultPredict2 = predicate2.test(new Object());
        String str2 = resultPredict2 ? "not null" : "null";
        System.out.println("resultPredict = " + str2);

        // UnaryOperator
        UnaryOperator<Person> unaryOperator = (person) -> {
           person.setName("New Name");
           person.setAge(18);
           return person;
        };
        UnaryOperator<Person> person = UnaryOperator.identity();

        /*
            The UnaryOperator interface can be used to represent an operation that
            takes a specific object as parameter, modifies that object, and returns
            it again - possibly as part of a functional stream processing chain.
         */

        // BinaryOperator - It represents a binary operator which takes two operands and operates on them to produce a result.
        // BiFunction's apply() method
        BinaryOperator<Integer> binOpMax1 = BinaryOperator.maxBy((a, b) -> (a > b) ? 1 : ((a == b) ? 0 : -1));
        System.out.println(binOpMax1.apply(98, 11));
        BinaryOperator<Integer> binOpMax2 = BinaryOperator.maxBy((a, b) -> a.compareTo(b));
        System.out.println(binOpMax2.apply(98, 11));
        BinaryOperator<Integer> binOpMax3 = BinaryOperator.maxBy(Integer::compareTo);
        System.out.println(binOpMax3.apply(98, 11));
        BinaryOperator<Integer> binOpMax4 = BinaryOperator.maxBy(Comparator.naturalOrder());
        System.out.println(binOpMax4.apply(98, 11));
        /*
            returns the greater of the two elements based on a given comparator
         */
        BinaryOperator<Integer> binOpMin1 = BinaryOperator.minBy((a, b) -> (a > b) ? 1 : ((a == b) ? 0 : -1));
        System.out.println(binOpMin1.apply(98, 11));
        BinaryOperator<Integer> binOpMin2 = BinaryOperator.minBy((a, b) -> a.compareTo(b));
        System.out.println(binOpMin2.apply(98, 11));
        BinaryOperator<Integer> binOpMin3 = BinaryOperator.minBy(Integer::compareTo);
        System.out.println(binOpMin3.apply(98, 11));
        BinaryOperator<Integer> binOpMin4 = BinaryOperator.minBy(Comparator.naturalOrder());
        System.out.println(binOpMin4.apply(98, 11));
        /*
            returns the lesser of the two elements based on a given comparator.
         */

        // BiFunction's addThen() method
        /*
            default <V>
                BiFunction<T, U, V>
                    andThen(Function<? super R, ? extends V> after)
         */
        BiFunction<Integer, Integer, Integer> composite1 = (a, b) -> a + b;
        composite1 = composite1.andThen(a -> 2 * a);
        System.out.println("Composite1 = " + composite1.apply(2, 3));
        // inputs 2 & 3, a(2) + b(3) = a(5), 2 * a(5) = 10

        BiFunction<Integer, Integer, Integer> composite2 = (a, b) -> a * b;
        composite2 = composite2.andThen(a -> 3 * a);
        System.out.println("Composite2 = " + composite2.apply(2, 3));
        // inputs 2 & 3, a(2) * b(3) = a(6), 3 * a(6) = 18

        // To demonstrate when NullPointerException is returned.
        BiFunction<Integer, Integer, Integer> composite3 = (a, b) -> a + b;
        try {
            composite3 = composite3.andThen(null); // throws NullPointerException.
            System.out.println("Composite3 = " + composite3.apply(2, 3));
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }

        // To demonstrate how an Exception in the after function is returned and handled.
        BiFunction<Integer, Integer, Integer> composite4 = (a, b) -> a + b;
        composite4 = composite4.andThen(a -> a / (a - 5)); // throws NullPointerException.
        try {
            System.out.println("Composite4 = " + composite4.apply(2, 3));
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }

        List<String> list1 = Arrays.asList("a", "b", "c");
        List<Integer> list2 = Arrays.asList(1, 2, 3);

        List<String> results = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            results.add(list1.get(i) + list2.get(i));
        }

        // Supplier
        // a functional interface; it takes no arguments and returns a result.
        // The Supplier interface can also be thought of as a factory interface.
        // This example uses Supplier to return a current date-time.
        Supplier<LocalDateTime> supLocDate = () -> LocalDateTime.now();
        LocalDateTime time1 = supLocDate.get();
        System.out.println("time1 = " + time1);

        Supplier<String> supStrFormat = () -> dtf.format(LocalDateTime.now());
        String time2 = supStrFormat.get();
        System.out.println("time2 = " + time2);

        String product = "Android";
        double price = 888.50;

        // Example with lambda expression.
        Supplier<Boolean> booleanSupplier = () -> product.length() == 10;
        Supplier<Integer> integerSupplier = () -> product.length() - 2;
        Supplier<String> stringSupplier = () -> product.toUpperCase();

        System.out.println("booleanSupplier = " + booleanSupplier.get());
        System.out.println("integerSupplier = " + integerSupplier.get());
        System.out.println("stringSupplier = " + stringSupplier.get());

        // Supplier with method reference example.
        Supplier<Integer> supplier1 = Review2FunctionalInterfaces::getTwoDigitRandom;
        System.out.println("supplier1 = " + supplier1.get());

        // Primitive specialization for Supplier interface.
        /*
            The supplier interface has its primitive variants such:
            IntSupplier  – Represents a supplier of int-valued results. Having one method getAsInt().
            LongSupplier – Represents a supplier of long-valued results. Having one method getAsLong().
            DoubleSupplier – Represents a supplier of double-valued results. Having one method getAsDouble().
            BooleanSupplier  – Represents a supplier of boolean-valued results. Having one method getAsBoolean().
         */
        BooleanSupplier booleanSupplier1 = () -> product.length() == 10;
        IntSupplier intSupplier1 = () -> product.length() - 2;
        DoubleSupplier doubleSupplier1 = () -> price - 20;
        LongSupplier longSupplier1 = () -> new Date().getTime();
        Supplier<String> stringSupplier1 = () -> product.toUpperCase();

        System.out.println("booleanSupplier1 = " + booleanSupplier1.getAsBoolean());
        System.out.println("intSupplier1 = " + intSupplier1.getAsInt());
        System.out.println("doubleSupplier1 = " + doubleSupplier1.getAsDouble());
        System.out.println("longSupplier1 = " + longSupplier1.getAsLong());
        System.out.println("stringSupplier1 = " + stringSupplier1.get());

        // Function
        /*
            is more of a generic one that takes one argument and produces a result.
            This has a Single Abstract Method (SAM) apply which accepts an argument of a type T
            and produces a result of type R. One of the common use cases of this interface is Stream.map method.

            One of the usages of the Function type in the standard library is the Map.computeIfAbsent method.
            This method returns a value from a map by key, but calculates a value if a key is not already present in a map.
            To calculate a value, it uses the passed Function implementation:
         */
        Map<String, Integer> nameMap = new HashMap<>();
        Integer value1 = nameMap.computeIfAbsent("John", s -> s.length());
        /*
            In this case, we will calculate a value by applying a function to a key,
            put inside a map, and also returned from a method call.
         */
        Integer value2 = nameMap.computeIfAbsent("John", String::length);
        // Replace the lambda with a method reference.

        // Supplier interface is a functional interface that represents an function that supplies a value of some sorts.
        // The Supplier interface can also be thought of as a factory interface.
        Supplier<Integer> supplier2 = () -> new Integer((int) (Math.random() * 1000D));
        Supplier<Integer> supplier3 = () -> (int) (Math.random() * 1000D); // Remove boxing.
        System.out.println("supplier2 = " + supplier1.get());
        System.out.println("supplier3 = " + supplier2.get());

        // Primitive Function Specializations
        /*
            1- IntFunction, LongFunction, DoubleFunction: arguments are of specified type, return type is parameterized.
            2- ToIntFunction, ToLongFunction, ToDoubleFunction: return type is of specified type, arguments are parameterized.
            3- DoubleToIntFunction, DoubleToLongFunction, IntToDoubleFunction, IntToLongFunction, LongToIntFunction, LongToDoubleFunction:
               having both argument and return type defined as primitive types, as specified by their names.
         */
        IntFunction<Double> intFunc = a -> a / 2.0;
        System.out.println("IntFunction<Double> = " + intFunc.apply(3));
        LongFunction<Double> longFunc = a -> a / 2.0;
        System.out.println("LongFunction<Double> = " + longFunc.apply(3));
        DoubleFunction<Double> doubleFunc = a -> a / 2.0;
        System.out.println("DoubleFunction<Double> = " + doubleFunc.apply(3));

        ToIntFunction<Double> tif = a -> (int) (a * 10);
        System.out.println("ToIntFunction<Double> = " + tif.applyAsInt(3.2d));
        ToLongFunction<Double> tlf = a -> (int) (a * 10);
        System.out.println("ToLongFunction<Double> = " + tlf.applyAsLong(3.2d));
        ToDoubleFunction<Double> tdf = a -> (int) (a * 10);
        System.out.println("ToDoubleFunction<Double> = " + tdf.applyAsDouble(3.2d));

        DoubleToIntFunction dtif = a -> (int) a;
        System.out.println("DoubleToIntFunction = " + dtif.applyAsInt(10.6d));
        DoubleToLongFunction dtlf = a -> (long) a;
        System.out.println("DoubleToLongFunction = " + dtlf.applyAsLong(10.6d));
        IntToDoubleFunction itdf = a -> (double) a;
        System.out.println("IntToDoubleFunction = " + itdf.applyAsDouble(10));
        IntToLongFunction itlf = a -> (long) a;
        System.out.println("IntToLongFunction = " + itlf.applyAsLong(10));
        LongToIntFunction ltif = a -> (int) a;
        System.out.println("LongToIntFunction = " + ltif.applyAsInt(10L));
        LongToDoubleFunction ltdf = a -> (double) a;
        System.out.println("LongToDoubleFunction = " + ltdf.applyAsDouble(10L));

        // Two-Arity Function Specializations
        /*
            To define lambdas with two arguments, we have to use additional interfaces that contain
            “Bi” keyword in their names: BiFunction, ToDoubleBiFunction, ToIntBiFunction, and ToLongBiFunction.

            BiFunction has both arguments and a return type generified,
            while ToDoubleBiFunction and others allow us to return a primitive value.

            One of the typical examples of using this interface in the standard API is in the Map.replaceAll method,
            which allows replacing all values in a map with some computed value.
         */
        Map<String, Integer> salaries = new HashMap<>();
        salaries.put("John", 40000);
        salaries.put("Freddy", 30000);
        salaries.put("Samuel", 50000);

        salaries.replaceAll((name, oldValue) -> name.equals("Freddy") ? oldValue : (oldValue + 10000));
        for (Map.Entry<String, Integer> m : salaries.entrySet()) {
            System.out.println("key = " + m.getKey() + "; " + "value = " + m.getValue());
        }

        BiFunction<Integer, Integer, Integer> biFunction1 = (a, b) -> a + b;
        System.out.println("1 + 1 = " + biFunction1.apply(1, 1));
        BiFunction<Integer, Integer, Integer> biFunction2 = Integer::sum; //method reference
        System.out.println("1 + 1 = " + biFunction2.apply(1, 1));

        ToDoubleBiFunction<Integer, Integer> toDoubleBiFunction1 = (a, b) -> a + b;
        System.out.println("1 + 1 = " + toDoubleBiFunction1.applyAsDouble(1, 1));
        ToDoubleBiFunction<Integer, Integer> toDoubleBiFunction2 = Integer::sum;
        System.out.println("1 + 1 = " + toDoubleBiFunction2.applyAsDouble(1, 1)); //method reference

        ToIntBiFunction<Double, Double> toIntBiFunction1 = (a, b) -> (int) (a + b);
        System.out.println("1.0d + 1.0d = " + toIntBiFunction1.applyAsInt(1.0d, 1.0d));
        ToIntBiFunction<Integer, Integer> toIntBiFunction2 = Integer::sum;
        System.out.println("1 + 1 = " + toIntBiFunction2.applyAsInt(1, 1));

        ToLongBiFunction<Integer, Integer> toLongBiFunction1 = Integer::sum;
        System.out.println("1 + 1 = " + toLongBiFunction1.applyAsLong(1, 1));
    }

    public static Integer getTwoDigitRandom() {
        int random = new Random().nextInt(100);
        if (random < 10) return 10;
        return random;
    }

    /**
     * Generalize the Function.
     * We can generalize this specialized function using a BiFunction as the combiner.
     */
    private static <T, U, R> List<R> listCombiner(List<T> list1, List<U> list2, BiFunction<T, U, R> combiner) {
        List<R> result = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            result.add(combiner.apply(list1.get(i), list2.get(i)));
        }
        return result;
    }

    @Test
    public void testCallingGeneralizeFunc() {
        List<String> listA1 = Arrays.asList("a", "b", "c");
        List<Integer> listA2 = Arrays.asList(1, 2, 3);
        List<String> resultA = listCombiner(listA1, listA2, (a, b) -> a + b);
        assertThat(resultA).containsExactly("a1", "b2", "c3");

        List<Double> listB1 = Arrays.asList(1.0d, 2.1d, 3.3d);
        List<Float> listB2 = Arrays.asList(0.1f, 0.2f, 4f);
        List<Boolean> resultB = listCombiner(listB1, listB2, this::firstIsGreaterThanSecond); // method reference
        assertThat(resultB).containsExactly(true, true, false);

        List<Float> listC1 = Arrays.asList(0.1f, 0.2f, 4f);
        List<Float> listC2 = Arrays.asList(0.1f, 0.2f, 4f);
        List<Boolean> resultC1 = listCombiner(listC1, listC2, (a, b) -> a.equals(b));
        assertThat(resultC1).containsExactly(true, true, true);
        // Actual simplification of the solution w/ method reference. Same as (a, b) -> a.equals(b)
        List<Boolean> resultC2 = listCombiner(listC1, listC2, Float::equals);
        assertThat(resultC2).containsExactly(true, true, true);
        /*
            This is because the equals function in Float has the same signature as a BiFunction.
            It takes an implicit first parameter of this, an object of type Float.
            The second parameter, other, of type Object, is the value to compare.
         */

        List<Double> listD1 = Arrays.asList(1.0d, 2.1d, 3.3d);
        List<Double> listD2 = Arrays.asList(0.1d, 0.2d, 4d);
        List<Integer> resultD = listCombiner(listD1, listD2, Double::compareTo);
        assertThat(resultD).containsExactly(1, 1, -1);
        /*
            returns an Integer, rather than the original Boolean.
            This is because the compareTo method in Double returns Integer.
         */

        // Composing BiFunctions.
        // using andThen to compose a function.
        List<Double> listE1 = Arrays.asList(1.0d, 2.1d, 3.3d);
        List<Double> listE2 = Arrays.asList(0.1d, 0.2d, 4d);
        List<Boolean> resultE = listCombiner(listE1, listE2, asBiFunction(Double::compareTo).andThen(i -> i > 0));
        assertThat(resultE).containsExactly(true, true, false);
    }

    /**
     * A lambda or method reference only becomes a BiFunction after it has been converted by a method invocation.
     * @param function
     * @param <T>       denotes the type of the first argument to the function
     * @param <U>       denotes the type of the second argument to the function
     * @param <R>       denotes the return type of the function
     * @return
     */
    private static <T, U, R> BiFunction<T, U, R> asBiFunction(BiFunction<T, U, R> function) {
        return function;
    }

    private boolean firstIsGreaterThanSecond(Double a, Float b) {
        return a > b;
    }

    // Consumer
    // accepts a single input and returns no output. consumes the input supplied to it.
    /*
        two (2) methods:
        1- void accept(T t);
        2- default Consumer<T> andThen(Consumer<? super T> after);
        The accept method is the Single Abstract Method (SAM) which accepts a single argument of type T.
        Whereas, the other one andThen is a default method used for composition.
     */
    @Test
    public void whenNamesPresentConsumeAll() {
        Consumer<String> printConsumer = t -> System.out.println(t);
        Stream<String> cities = Stream.of("Sydney", "Dhaka", "New York", "London");
        cities.forEach(printConsumer);
    }
    // Usage of composing multiple consumer implementations to make a chain of consumers.

    @Test
    public void whenNamesPresentUseBothConsumer() {
        List<String> cities = Arrays.asList("Sydney", "Dhaka", "New York", "London");
        Consumer<List<String>> upperCaseConsumer = list -> {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i).toUpperCase());
            }
        };
        Consumer<List<String>> printConsumer = list -> list.stream().forEach(System.out::println);
        upperCaseConsumer.andThen(printConsumer).accept(cities);
    }

    // Predicate
    /*
        represents a boolean-valued-function of an argument.
        mainly used to filter data from a Java Stream.
        The filter method of a stream accepts a predicate
        to filter the data and return a new stream satisfying the predicate.
     */
    @Test
    public void testPredicate() {
        List<String> names = Arrays.asList("John", "Smith", "Samuel", "Catley", "Sie");
        Predicate<String> nameStartWithS = str -> str.startsWith("S");
        names.stream().filter(nameStartWithS).forEach(System.out::println);
    }

    /*
        Predicate also provides a few default and
        static method for composition and other purposes:
        1- default Predicate<T> and(Predicate<? super T> other);
        2- default Predicate<T> or(Predicate<? super T> other);
        3- static <T> Predicate<T> isEquals(Object targetRef);
        4- default Predicate<T> negate();
     */
    @Test
    public void testPredicateAndComposition() {
        List<String> names = Arrays.asList("John", "Smith", "Samuel", "Catley", "Sie");
        Predicate<String> nameStartWithS = str -> str.startsWith("S");
        Predicate<String> lengthPredicate = str -> str.length() >= 5;
        names.stream().filter(nameStartWithS.and(lengthPredicate)).forEach(System.out::println);
    }

    @Test
    public void test() {
        /*
            an object we invoke the method on is, in fact, the implicit first argument of a method.
            This allows us to cast an instance method length reference to a Function interface
         */
        Function<Integer, String> intToString = Objects::toString;
        Function<String, String> quote = s -> "'" + s + "'";
        Function<Integer, String> quoteIntToString = quote.compose(intToString);
        assertEquals("'5'", quoteIntToString.apply(5));
    }

    public byte[] transformArray(short[] array, ShortToByteFunction function) {
        byte[] transformedArray = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            transformedArray[i] = function.applyAsByte(array[i]);
        }
        return transformedArray;
    }

    @Test
    public void testTransformArray() {
        short[] shorts = {(short) 1, (short) 2, (short) 3};
        byte[] newBytes = transformArray(shorts, s -> (byte) (s * 2));
        assertArrayEquals(new byte[]{(byte) 2, (byte) 4, (byte) 6}, newBytes);
    }
}

// Writing our own cuz no out-of-the-box functional interface for a function.
@FunctionalInterface
interface ShortToByteFunction {
    byte applyAsByte(short s);
}