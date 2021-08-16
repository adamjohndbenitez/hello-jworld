package oca;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class RandomAndMathClasses {
    public static void main(String[] args) {
        // Use the Random class.
        Random random = new Random();
        byte[] bytes = {0, 16, 32};
        random.nextBytes(bytes);

        int nextInt = random.nextInt();
        System.out.println("next Int value : " + nextInt);

        long nextLong = random.nextLong();
        System.out.println("next Long value : " + nextLong);

        boolean nextBoolean = random.nextBoolean();
        System.out.println("next Boolean value : " + nextBoolean);

        float nextFloat  = random.nextFloat();
        System.out.println("next Float value : " + nextFloat);

        double nextDouble  = random.nextDouble();
        System.out.println("next Float value : " + nextDouble);

        double nextGaussian  = random. nextGaussian();
        System.out.println("next Float value : " + nextGaussian);


        // Use the Math class.
        System.out.println("Math.E() = " + Math.E + " = The double value that is closer than any other to e, the base of the natural logarithms.");
        System.out.println("Math.PI() = " + Math.PI + " = The double value that is closer than any other to pi, the ratio of the circumference of a circle to its diameter..");
        System.out.println("Math.sin() = " + Math.sin(1.00) + " = the trigonometric sine of an angle.");
        System.out.println("Math.cos() = " + Math.cos(1.00) + " = the trigonometric cosine of an angle.");
        System.out.println("Math.tan() = " + Math.tan(1.00) + " = the trigonometric tangent of an angle.");
        System.out.println("Math.asin() = " + Math.asin(1.00) + " = the trigonometric arc sine of an angle.");
        System.out.println("Math.acos() = " + Math.acos(1.00) + " = the trigonometric arc cosine of an angle.");
        System.out.println("Math.atan() = " + Math.atan(1.00) + " = the trigonometric arc tangent of an angle.");
        System.out.println("Math.toRadians() = " + Math.toRadians(1.00) + " = Converts an angle measured in degrees to an approximately equivalent angle measured in radians. The conversion from degrees to radians is generally inexact.");
        System.out.println("Math.toDegrees() = " + Math.toDegrees(1.00) + " = Converts an angle measured in radians to an approximately equivalent angle measured in degrees. The conversion from degrees to radians is generally inexact.");
        System.out.println("Math.exp() = " + Math.exp(1.00) + " = Returns Euler's number e raised to the power of a double value.");
        System.out.println("Math.log() = " + Math.log(1.00) + " = Returns the natural logarithm (base e) of a double value.");
        System.out.println("Math.log10() = " + Math.log10(1.00) + " = Returns the base 10 logarithm (base e) of a double value.");
        System.out.println("Math.sqrt() = " + Math.sqrt(1.00) + " = Returns the correctly rounded positive square root of a double value.");
        System.out.println("Math.cbrt() = " + Math.cbrt(1.00) + " = Returns the cube root of a double value.");
        System.out.println("Math.IEEEremainder() = " + Math.IEEEremainder(1.00, 2.00) + " = Computes the remainder operation on two arguments as prescribed by the IEEE 754 standard.");
        System.out.println("Math.ceil() = " + Math.ceil(1.00) + " = Returns the smallest (closest to negative infinity) double value that is greater than or equal to the argument and is equal to a mathematical integer.");
        System.out.println("Math.floor() = " + Math.floor(1.00) + " = Returns the largest (closest to positive infinity) double value that is less than or equal to the argument and is equal to a mathematical integer.");
        System.out.println("Math.rint() = " + Math.rint(1.00) + " = Returns the double value that is closest in value to the argument and is equal to a mathematical integer.");
        System.out.println("Math.atan2() = " + Math.atan2(1.00, 2.00) + " = Returns the angle theta from the conversion of rectangular coordinates (x, y) to polar coordinates (r, theta).");
        System.out.println("Math.pow() = " + Math.pow(1.00, 2.00) + " = Returns the value of the first argument raised to the power of the second argument.");
        System.out.println("Math.round() = " + Math.round(1.00) + " = Returns the closest int to the argument");
        System.out.println("Math.round() = " + Math.round(1.00) + " = Returns the closest long to the argument, with ties rounding to positive infinity.");
        System.out.println("Math.random() = " + Math.random() + " = Returns a double value with a positive sign, greater than or equal to 0.0 and less than 1.0.");
        System.out.println("Math.addExact() = " + Math.addExact(1, 2) + " = Returns the sum of its arguments, throwing an exception if the result overflows an int.");
        System.out.println("Math.subtractExact() = " + Math.subtractExact(2, 1) + " = Returns the difference of its arguments, throwing an exception if the result overflows an int.");
        System.out.println("Math.multiplyExact() = " + Math.multiplyExact(2, 1) + " = Returns the product of its arguments, throwing an exception if the result overflows an int.");
        System.out.println("Math.incrementExact() = " + Math.incrementExact(1) + " = Returns the argument incremented by one, throwing an exception if the result overflows an int.");
        System.out.println("Math.decrementExact() = " + Math.decrementExact(1) + " = Returns the argument decremented by one, throwing an exception if the result overflows an int.");
        System.out.println("Math.negateExact() = " + Math.negateExact(1) + " = Returns the negation of the argument, throwing an exception if the result overflows an int.");
        System.out.println("Math.toIntExact() = " + Math.toIntExact(1) + " = Returns the value of the long argument; throwing an exception if the value overflows an int.");
        System.out.println("Math.floorDiv() = " + Math.floorDiv(1, 2) + " = Returns the largest (closest to positive infinity) int value that is less than or equal to the algebraic quotient.");
        System.out.println("Math.floorMod() = " + Math.floorMod(1, 2) + " = Returns the largest (closest to positive infinity) int value that is less than or equal to the algebraic quotient.");
        System.out.println("Math.abs() = " + Math.abs(-1) + " = RReturns the absolute value of an int value. If the argument is not negative, the argument is returned. If the argument is negative, the negation of the argument is returned.");
        System.out.println("Math.max() = " + Math.max(1, 2) + " = Returns the greater of two (int/long/float/double) values. That is, the result is the argument closer to the value of Integer.MAX_VALUE. If the arguments have the same value, the result is that same value.");
        System.out.println("Math.min() = " + Math.min(1, 2) + " = Returns the smaller of two float values. That is, the result is the value closer to negative infinity. If the arguments have the same value, the result is that same value.");
        System.out.println("Math.ulp() = " + Math.ulp(1.00) + " = Returns the size of an ulp of the argument. An ulp, unit in the last place, of a double value is the positive distance between this floating-point value and the double value next larger in magnitude.");
        System.out.println("Math.signum() = " + Math.signum(1.00) + " = Returns the signum function of the argument; zero if the argument is zero, 1.0 if the argument is greater than zero, -1.0 if the argument is less than zero.");
        System.out.println("Math.sinh() = " + Math.sinh(1.00) + " = Returns the hyperbolic sine of a double value. The hyperbolic sine of x is defined to be (ex - e-x)/2 where e is Euler's number.");
        System.out.println("Math.cosh() = " + Math.cosh(1.00) + " = Returns the hyperbolic cosine of a double value. The hyperbolic cosine of x is defined to be (ex + e-x)/2 where e is Euler's number.");
        System.out.println("Math.hypot() = " + Math.hypot(1.00, 2.00) + " = Returns sqrt(x2 +y2) without intermediate overflow or underflow.");
        System.out.println("Math.expm1() = " + Math.expm1(1.00) + " = Returns ex -1. Note that for values of x near 0, the exact sum of expm1(x) + 1 is much closer to the true result of ex than exp(x).");
        System.out.println("Math.log1p() = " + Math.log1p(1.00) + " = Returns the natural logarithm of the sum of the argument and 1. Note that for small values x, the result of log1p(x) is much closer to the true result of ln(1 + x) than the floating-point evaluation of log(1.0+x).");
        System.out.println("Math.copySign() = " + Math.copySign(1.00, -2.00) + " = Returns the first floating-point argument with the sign of the second floating-point argument. Note that unlike the StrictMath.copySign method, this method does not require NaN sign arguments to be treated as positive values; implementations are permitted to treat some NaN arguments as positive and other NaN arguments as negative to allow greater performance.");
        System.out.println("Math.getExponent() = " + Math.getExponent(1.00) + " = Returns the unbiased exponent used in the representation of a float.");
        System.out.println("Math.getExponent() = " + Math.getExponent(1.00) + " = Returns the unbiased exponent used in the representation of a double.");
        System.out.println("Math.getExponent() = " + Math.getExponent(1.00) + " = Returns the unbiased exponent used in the representation of a double.");
        System.out.println("Math.nextAfter() = " + Math.nextAfter(1.00, 2.00) + " = Returns the floating-point number adjacent to the first argument in the direction of the second argument. If both arguments compare as equal the second argument is returned.");
        System.out.println("Math.nextUp() = " + Math.nextUp(1.00) + " = Returns the floating-point value adjacent to d in the direction of positive infinity. This method is semantically equivalent to nextAfter(d, Double.POSITIVE_INFINITY); however, a nextUp implementation may run faster than its equivalent nextAfter call.");
        System.out.println("Math.nextDown() = " + Math.nextDown(1.00) + " = Returns the floating-point value adjacent to d in the direction of negative infinity. This method is semantically equivalent to nextAfter(d, Double.NEGATIVE_INFINITY); however, a nextDown implementation may run faster than its equivalent nextAfter call.");
        System.out.println("Math.scalb() = " + Math.scalb(1.00, 2) + " = Returns d × 2scaleFactor rounded as if performed by a single correctly rounded floating-point multiply to a member of the double value set. See the Java Language Specification for a discussion of floating-point value sets. If the exponent of the result is between Double.MIN_EXPONENT and Double.MAX_EXPONENT, the answer is calculated exactly. If the exponent of the result would be larger than Double.MAX_EXPONENT, an infinity is returned. Note that if the result is subnormal, precision may be lost; that is, when scalb(x, n) is subnormal, scalb(scalb(x, n), -n) may not equal x. When the result is non-NaN, the result has the same sign as d.");

        // Using Decision Statements
        // Use the decision making statement (if-then and if-then-else)
        ifThenStatements(true);
        ifThenElseStatements(true);
        ifThenElseIfStatements();

        // Use the switch statement
        switchStatement();
        switchFallThrough();
        switchDemo2();

        // Compare how == differs between primitives and objects
        primitiveTypeAndReferenceType();
        equalityAndComparison();
        equality();
        equalsAndHashCode();

        // Compare two String objects by using the compareTo and equals methods
        comparison();
        compareStringsCompareToAndEquals();
    }

    // The if-then statement is the most basic of all the control flow statements. It tells your program to execute a certain section of code only if a particular test evaluates to true.
    private static void ifThenStatements(boolean isMoving) {
        int currentSpeed = 20;
        System.out.println("Current Speed = " + currentSpeed);

        // the "if" clause: bicycle must be moving
        if (isMoving) {
            // the "then" clause: decrease current speed
            currentSpeed--;
            System.out.println("Moving Decrease = " + currentSpeed);
        }

        // The opening and closing braces are optional, provided that the "then" clause contains only one statement
        if (!isMoving) currentSpeed++;
    }

    // The if-then-else statement provides a secondary path of execution when an "if" clause evaluates to false.
    private static void ifThenElseStatements(boolean isMoving) {
        int currentSpeed = 20;
        System.out.println("Current Speed = " + currentSpeed);

        if (isMoving) {
            currentSpeed--;
        } else {
            System.err.println("The bicycle has already stopped!");
        }
    }

    private static void ifThenElseIfStatements() {
        int testscore = 76;
        char grade;

        if (testscore >= 90) {
            grade = 'A';
        } else if (testscore >= 80) {
            grade = 'B';
        } else if (testscore >= 70) { // Satisfy condition
            grade = 'C';
        } else if (testscore >= 60) { // Satisfy condition
            grade = 'D';
        } else {
            grade = 'F';
        }

        // However, once a condition is satisfied, the appropriate statements are executed (grade = 'C';) and the remaining conditions are not evaluated.
        System.out.println("Grade = " + grade);
    }

    /**
     * A switch works with the byte, short, char, and int primitive data types.
     * It also works with enumerated types (discussed in Enum Types),
     * the String class, and a few special classes that wrap certain primitive types:
     * Character, Byte, Short, and Integer (discussed in Numbers and Strings).
     *
     * NOTE: Deciding whether to use if-then-else statements or a switch statement is
     * based on readability and the expression that the statement is testing.
     * An if-then-else statement can test expressions based on ranges of values or conditions,
     * whereas a switch statement tests expressions based only on a single integer, enumerated value, or String object.
     */
    private static void switchStatement() {
        int month = 8;
        String monthString;
        switch (month) { // The body of a switch statement is known as a switch block. A statement in the switch block can be labeled with one or more case or default labels.
            case 1:  monthString = "January";
                break;
            case 2:  monthString = "February";
                break;
            case 3:  monthString = "March";
                break;
            case 4:  monthString = "April";
                break;
            case 5:  monthString = "May";
                break;
            case 6:  monthString = "June";
                break;
            case 7:  monthString = "July";
                break;
            case 8:  monthString = "August";
                break;
            case 9:  monthString = "September";
                break;
            case 10: monthString = "October";
                break;
            case 11: monthString = "November";
                break;
            case 12: monthString = "December";
                break;
            default: monthString = "Invalid month";
                break;
        }
        System.out.println(monthString);
    }

    /**
     * Another point of interest is the break statement.
     * Each break statement terminates the enclosing switch statement.
     * Control flow continues with the first statement following the switch block.
     * The break statements are necessary because without them,
     * statements in switch blocks fall through:
     * All statements after the matching case label are executed in sequence,
     * regardless of the expression of subsequent case labels, until a break statement is encountered.
     */
    private static void switchFallThrough() {
        java.util.ArrayList<String> futureMonths =
                new java.util.ArrayList<String>();

        int month = 8;

        switch (month) {
            case 1:  futureMonths.add("January");
            case 2:  futureMonths.add("February");
            case 3:  futureMonths.add("March");
            case 4:  futureMonths.add("April");
            case 5:  futureMonths.add("May");
            case 6:  futureMonths.add("June");
            case 7:  futureMonths.add("July");
            case 8:  futureMonths.add("August");
            case 9:  futureMonths.add("September");
            case 10: futureMonths.add("October");
            case 11: futureMonths.add("November");
            case 12: futureMonths.add("December");
                break; // All statements after the matching case label are executed in sequence, regardless of the expression of subsequent case labels
            default: break;
        }

        if (futureMonths.isEmpty()) {
            System.out.println("Invalid month number");
        } else {
            for (String monthName : futureMonths) {
                System.out.println(monthName);
            }
        }
    }

    private static void switchDemo2() {
        int month = 2;
        int year = 2000;
        int numDays = 0;

        switch (month) {
            case 1: case 3: case 5:
            case 7: case 8: case 10:
            case 12:
                numDays = 31;
                break;
            case 4: case 6:
            case 9: case 11:
                numDays = 30;
                break;
            case 2:
                if (((year % 4 == 0) &&
                        !(year % 100 == 0))
                        || (year % 400 == 0))
                    numDays = 29;
                else
                    numDays = 28;
                break;
            default: // The default section handles all values that are not explicitly handled by one of the case sections.
                System.out.println("Invalid month.");
                break;
        }
        System.out.println("Number of Days = "
                + numDays);
    }

    /**
     * The String in the switch expression is compared with the expressions associated with each case label
     * as if the String.equals method were being used. In order for the StringSwitchDemo example to accept
     * any month regardless of case, month is converted to lowercase (with the toLowerCase method),
     * and all the strings associated with the case labels are in lowercase.
     */
    private static void stringSwitch() {
        String month = "August";

        int monthNumber = 0;

        switch (month.toLowerCase()) {
            case "january":
                monthNumber = 1;
                break;
            case "february":
                monthNumber = 2;
                break;
            case "march":
                monthNumber = 3;
                break;
            case "april":
                monthNumber = 4;
                break;
            case "may":
                monthNumber = 5;
                break;
            case "june":
                monthNumber = 6;
                break;
            case "july":
                monthNumber = 7;
                break;
            case "august":
                monthNumber = 8;
                break;
            case "september":
                monthNumber = 9;
                break;
            case "october":
                monthNumber = 10;
                break;
            case "november":
                monthNumber = 11;
                break;
            case "december":
                monthNumber = 12;
                break;
            default:
                monthNumber = 0;
                break;
        }

        if (monthNumber == 0) {
            System.out.println("Invalid month");
        } else {
            System.out.println(monthNumber);
        }
    }

    /**
     * Java has a two-fold type system consisting of primitives such as int, boolean and
     * reference types such as Integer, Boolean. Every primitive type corresponds to a reference type.
     *
     * Every object contains a single value of the corresponding primitive type.
     * The wrapper classes are immutable (so that their state can't change once the object is constructed) and
     * are final (so that we can't inherit from them).
     */
    private static void primitiveTypeAndReferenceType() {
        // Under the hood, Java performs a conversion between the primitive and reference types
        // if an actual type is different from the declared one:
        Integer j = 1; // autoboxing
        int i = new Integer(1); // unboxing
        // The process of converting a primitive type to a reference one is called autoboxing,
        // the opposite process is called unboxing.
    }

    /**
     * The Java type system is two-fold, consisting of eight primitive data types
     * (boolean, byte, char, short, int, long, float, double), and object reference types.
     *
     * Primitives in Java can’t be uninitialized or null, they always have a default value.
     *
     *  Primitive | Default Value
     * -----------|---------------
     *  boolean   | false
     *  byte      | 0
     *  char      | '\u0000'
     *  short     | 0
     *  int       | 0
     *  long      | 0l
     *  float     | 0.0f
     *  double    | 0.0d
     *
     *  Every primitive data type has a corresponding wrapper class in java.lang,
     *  encapsulating its value in a Java object:
     *
     *  Primitive | Wrapper | Superclass
     * -----------|---------|------------
     *  boolean   | Boolean | Object
     *  byte      | Byte    | Number
     *  char      | Char    | Object
     *  short     | Short   | Number
     *  int       | Int     | Number
     *  long      | Long    | Number
     *  float     | Float   | Number
     *  double    | Double  | Number
     */
    private static void equalityAndComparison() {

        List<Integer> values = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            //values.add(Integer.valueOf(i)); // Autoboxing the i.
            values.add(i); // Boxing can be remove.
        }

        int result = 0;
        for (Integer summand: values) {
//            if (summand.intValue() % 2 == 0) {
//                result += summand.intValue();
//            }
            if (summand % 2 == 0) {
                result += summand; // The code compiles fine. Because the compiler unboxes the wrapper type.
            }
        }
        System.out.println("Result : " + result);
    }

    /**
     * Primitives are literals, fixed values in memory, that can be tested for equality with ==.
     */
    private static void equality() {
        // In contrast to the other primitive data types, the floating-point data types float
        // and double can’t reliably be checked for equality with ==, due to their storage method in memory.
        // They aren’t exact values:
        float value = 1.0f;
        value += 0.1f;      // 1.1f
        value += 0.1f;      // 1.2f
        value += 0.1f;      // 1.3000001f

        boolean isEqual = (value == 1.3f); // false
        System.out.println("isEqual = " + isEqual);

        // We’ve got two options to deal with this. Either by using java.util.BigDecimal, which is exact.
        // Or by using threshold-based comparisons:
        float THRESHOLD = 0.00001f;
        isEqual = Math.abs(value - 1.3f) < THRESHOLD; // true
        System.out.println("isEqual = " + isEqual);

        // If you compare objects with ==, it will also compare the value of the object.
        // The only problem here is that the value of an object is actually its reference,
        // hence the name object reference type.
        //

        String a = "a";
        String b = "b";
        String ab = "ab";

        boolean result1 = (a == "a");      // true
        boolean result2 = (ab == "ab");    // true
        boolean result3 = (a + b == "ab"); // false
        // This means two values are only equal if they point to the same object in memory.
        // The compiler and the JVM might optimize string constants, so result2 is true.
        // And result3 is false because a + b creates a new object in memory.
        // All of this can be implementation-dependent and differ between different JVMs.
        System.out.println("result1 : " + result1);
        System.out.println("result2 : " + result2);
        System.out.println("result3 : " + result3);

        // Another “not so obvious” pitfall can happen with primitive wrapper types:
        // The valueOf(...) methods of java.util.Integer and java.util.Long actually
        // cache values for specific ranges (-128 to 127), making a and b the same object,
        // but not c and d. And thanks to unboxing, equalAgain is true.
        Integer a1 = 127;
        Integer b1 = 127;
        Integer c = 128;
        Integer d = 128;
        boolean equal      = (a1 == b1); // true
        boolean notEqual   = (c == d); // false
        boolean equalAgain = (new Integer(128) == 128); // true
        System.out.println("equal : " + equal);
        System.out.println("notEqual : " + notEqual);
        System.out.println("equalAgain : " + equalAgain);
    }

    /**
     * By default, every one of our types inherits the “problematic” comparison of object references.
     * o be able to use equals for actual equality, we need to override it in our types, having certain properties:
     */
    private static void equalsAndHashCode() {
        MyClass a = new MyClass("title", 1);
        MyClass b = new MyClass("title", 1);
        MyClass c = new MyClass("title", 1);
        // Reflexive: An object should be equal with itself: obj.equals(obj) == true.
        System.out.println("Reflexive : " + a.equals(a));

        // Symmetric: If a.equals(b) == true, then b.equals(a) must also be true.
        System.out.println("Symmetric1 : " + a.equals(b));
        System.out.println("Symmetric2 : " + b.equals(a));
        System.out.println("Symmetric3 : " + (a.equals(b) && b.equals(a)));

        // Transitive: If a.equals(b) == true and b.equals(c) == true, then a.equals(c) should be true.
        System.out.println("Transitive1 : " + a.equals(b));
        System.out.println("Transitive2 : " + b.equals(c));
        System.out.println("Transitive3 : " + a.equals(c));

        // Consistent: a.equals(b) should always have the same value for unmodified objects.
        System.out.println("Consistent : " + a.equals(c)); // a.equals(new MyClass("title", 1)) ?

        // Null handling: a.equals(null) should be false.
        System.out.println("Null Handling : " + a.equals(null));

        // Hash code: Equal objects must have the same hash code.
        System.out.println("Hash code : " + (a.hashCode() == b.hashCode()));
        System.out.println("Hash code : " + (a.hashCode() == a.hashCode()));
    }

    /**
     * Comparison
     * Just testing for equality is seldom enough. The other significant kinds of operations are comparisons of values.
     *
     * Primitives
     * Like in other languages, we can compare the values of primitives with the <, >, <=, and >=operator.
     *
     * The same problems of floating-point data types apply to them, so be aware. Also, boolean isn’t comparable except for equality with == and !=.
     *
     * java.lang.Comparable
     * Objects don’t support these operators. To compare object types we need to implement the interface java.lang.Comparable<T> with its single method int compareTo(T).
     *
     * The result of left.compareTo(right) is supposed to be the following:
     *  Result | Meaning / Order
     * --------|---------------------------
     *    0    | left is the same as right
     *   -1    | left < right
     *    1    | left > right
     */
    private static void comparison() {
        MyClass1 myClass1 = new MyClass1();
        MyClass2 myClass2 = new MyClass2();
        System.out.println("compare myClass1 vs myClass2 : " + myClass1.compareTo(myClass2));
    }

    private static void compareStringsCompareToAndEquals() {
        String str1 = "Hello";
        String str2 = "Hello";

        System.out.println("str1.compareTo(str2) = " + str1.compareTo(str2));
        System.out.println("str1.equals(str2) = " + str1.equals(str2));
    }
}

class MyClass {

    private final String title;
    private final Integer value;

    public MyClass(String title, Integer value) {
        this.title = title;
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {

        // Reflexive - An object should be equal with itself: obj.equals(obj) == true.
        if (this == obj) {
            return true;
        }

        // Null-handling - a.equals(null) should be false.
        if (obj == null) {
            return false;
        }

        // Different types can't be equal
        if (getClass() != obj.getClass()) {
            return false;
        }
        MyClass other = (MyClass) obj;

        // Let the helper do the rest
        return Objects.equals(this.title, other.title) &&
                Objects.equals(this.value, other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.title,
                this.value);
    }
}

class MyClass1 extends MyClass3 implements Comparable<Object> {
    @Override
    public int compareTo(Object o) {
        if (this.hashCode() < o.hashCode()) {
            return -1;
        } else if (this.hashCode() > o.hashCode()) {
            return 1;
        } else  {
            return 0; // this.equals(o);
        }
    }
}
class MyClass2 extends MyClass3 implements Comparable<Object> {
    @Override
    public int compareTo(Object o) {
        // this.equals(o);
        return Integer.compare(this.hashCode(), o.hashCode());
    }
}

class MyClass3 {

}