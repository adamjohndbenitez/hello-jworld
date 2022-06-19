package oca.foundations.javafx;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.lang.Object;
//import com.sun.tools.javac.Main;

import java.io.Console;
import java.nio.charset.Charset;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import static java.lang.System.out;

public class ReviewAndTestVerifyExam1Z0811 implements Comparable<ReviewAndTestVerifyExam1Z0811>{
    {
        System.out.println("Hello World");
    }

    /*
    either order (public static or static public)
    You can name the argument anything you want,
    but most programmers choose "args" or "argv".


     */
//    static public void main(String[] argv) throws Exception {
    public static void main(String[] args) throws Exception {
        String s1 = new String("cat");
        String s2 = "cat";
        System.out.println("s1.equals(s2) : " + s1.equals(s2)); // true
        System.out.println("s1 == s2 : " + (s1 == s2)); // false
        System.out.println("s1.compareTo(s2) : " + s1.compareTo(s2)); // 0

        System.out.printf("%s friend is not a %s", s1, s2); //

        ReviewAndTestVerifyExam1Z0811 e = new ReviewAndTestVerifyExam1Z0811(); // worke

        // Random numbers only from 1-10
        Random r = new Random();
        System.out.println(Math.round(r.nextInt() % 9)); // not working
        System.out.println(Math.round(r.nextInt() * 10)); // not working
        System.out.println(Math.round(Math.random() * 10)); // working

        int[] a = new int[3];
        int[] b = {0,1};
        a = b;
        System.out.println("a size : " + a.length); // 2 (size of b)

        int c = 2;
        switch (c) {
            case 1:
                System.out.println("case: 1");
            case 2:
                System.out.println("case: 2");
            case 3:
                System.out.println("case: 3");
            default:
                System.out.println("default:");
        }

        try {
            method(1, 0);
        } catch (ArithmeticException ae) {
            System.out.println("Arithmetic"); // not this
        }

        int x = 10;
        int y = 20;
        int z = 30;

//        x++/10 ++y;

        /*
        Examination Score Report Feedbacks
         */
        //#1 Cast a value from one data type to another including automatic and manual promotion
        // Casting conversion (5.4) of a float literal to
        // type int. Without the cast operator, this would
        // be a compile-time error, because this is a
        // narrowing conversion (5.1.3):
        int i = (int)12.5f; //w/o cast (int) Error:(66, 17) java: incompatible types: possible lossy conversion from float to int
        // String conversion (5.4) of i's int value:
        System.out.println("(int)12.5f==" + i);
        // Assignment conversion (5.2) of i's value to type
        // float. This is a widening conversion (5.1.2):
        float f = i;
        // String conversion of f's float value:
        System.out.println("after float widening: " + f);
        // Numeric promotion (5.6) of i's value to type
        // float. This is a binary numeric promotion.
        // After promotion, the operation is float*float:
        System.out.print(f);
        f = f * i;
        // Two string conversions of i and f:
        System.out.println("*" + i + "==" + f);
        // Method invocation conversion (5.3) of f's value
        // to type double, needed because the method Math.sin
        // accepts only a double argument:
        double d = Math.sin(f);
        // Two string conversions of f and d:
        System.out.println("Math.sin(" + f + ")==" + d);

        // A widening conversion of an int
        // or a long value to float,
        // or of a long value to double,
        // may result in loss of precision
        // - that is, the result may lose
        // some of the least significant bits of the value.
        int big = 1234567890;
        float approx = big;
        System.out.println(big - (int)approx);

        // Narrowing Primitive Conversion
        float fmin = Float.NEGATIVE_INFINITY;
        float fmax = Float.POSITIVE_INFINITY;
        System.out.println("long: " + (long)fmin +
                ".." + (long)fmax);
        System.out.println("int: " + (int)fmin +
                ".." + (int)fmax);
        System.out.println("short: " + (short)fmin +
                ".." + (short)fmax);
        System.out.println("char: " + (int)(char)fmin +
                ".." + (int)(char)fmax);
        System.out.println("byte: " + (byte)fmin +
                ".." + (byte)fmax);
        /*
        The results for char, int, and long are unsurprising,
        producing the minimum and maximum representable values of the type.
        The results for byte and short lose information about the sign
        and magnitude of the numeric values and also lose precision.
        The results can be understood by examining the low order bits
        of the minimum and maximum int. The minimum int is, in hexadecimal,
        0x80000000, and the maximum int is 0x7fffffff.

        This explains the short results,
        which are the low 16 bits of these values,
        namely, 0x0000 and 0xffff;
        it explains the char results,
        which also are the low 16 bits of these values,
        namely, '\u0000' and '\uffff'; and it explains the byte results,
        which are the low 8 bits of these values, namely, 0x00 and 0xff.
         */

        // Narrowing Primitive Conversions that lose information
        // A narrowing of int to short loses high bits:
        System.out.println("(short)0x12345678==0x" +
                Integer.toHexString((short)0x12345678));
        // An int value too big for byte changes sign and magnitude:
        System.out.println("(byte)255==" + (byte)255);
        // A float value too big to fit gives largest int value:
        System.out.println("(int)1e20f==" + (int)1e20f);
        // A NaN converted to int yields zero:
        System.out.println("(int)NaN==" + (int)Float.NaN);
        // A double value too large for float yields infinity:
        System.out.println("(float)-1e100==" + (float)-1e100);
        // A double value too small for float underflows to zero:
        System.out.println("(float)1e-50==" + (float)1e-50);

        // Unary Numeric Promotion
        byte g = 2;
        int h[] = new int[g];  // dimension expression promotion
        char j = '\u0001';
        h[j] = 1;              // index expression promotion
        h[0] = -j;             // unary - promotion
        System.out.println("a: " + h[0] + "," + h[1]);
        g = -1;
        int k = ~g;            // bitwise complement promotion
        System.out.println("~0x" + Integer.toHexString(g)
                + "==0x" + Integer.toHexString(k));
        k = g << 4L;           // shift promotion (left operand)
        System.out.println("0x" + Integer.toHexString(g)
                + "<<4L==0x" + Integer.toHexString(k));

        // To be continue.... https://docs.oracle.com/javase/specs/jls/se7/html/jls-5.html#jls-5.6

        // Autoboxing is the automatic conversion of primitive types in their corresponding wrapper class
        List<Integer> values = new ArrayList<>();
        List<Integer> values1 = new ArrayList<>();

        for (int l = 0; l < 50; l++) {
            values.add(l);// compiler changing our code by autoboxing the i
            values1.add(Integer.valueOf(l));// safer than autoboxing.. read docs for benefits..
        }

        // Unboxing is the other direction
        int unboxedInt = sumEven(values);
        System.out.println("Unboxing From Integer to int = " + unboxedInt);

        int unboxedInt1 = sumEven(values);
        System.out.println("Actual From Integer to int = " + unboxedInt1);

        /*
        Primitives are literals, fixed values in memory, that can be tested for equality with ==.
        Except when they can’t.
        In contrast to the other primitive data types, the floating-point data types float
        and double can’t reliably be checked for equality with ==,
        due to their storage method in memory. They aren’t exact values:
         */
        float value = 1.0f;
        value += 0.1f;      // 1.1f
        System.out.println("value += 0.1f = " + value);
        value += 0.1f;      // 1.2f
        System.out.println("value += 0.1f = " + value);
        value += 0.1f;      // 1.3000001f
        System.out.println("value += 0.1f = " + value);

        boolean isEqual = (value == 1.3f); // false
        System.out.println("(value == 1.3f) = " + isEqual);
        // To solve this -
        // 2 options:
        // (1) Either by using java.util.BigDecimal, which is exact.
        // (2) Or by using threshold-based comparisons
        float THRESHOLD = 0.00001f;
        System.out.println("Math.abs(value - 1.3f) = " + Math.abs(value - 1.3f));
        boolean isEqual1 = Math.abs(value - 1.3f) < THRESHOLD; // true
        System.out.println("using threshold-based comparisons: isEqual = " + isEqual1);

        // value of an object is actually its reference, hence the name object reference type.
        String m = "a";
        String n = "b";
        String o = "ab";

        // compiler and the JVM might optimize string constants, so result1 & result2 is true
        boolean result1 = (m == "a");      // true
        System.out.println("result1 = (m == \"a\"): " + result1);
        boolean result2 = (o == "ab");    // true
        System.out.println("result2 = (o == \"ab\"): " + result2);
        boolean result3 = (m + n == "ab"); // false - bcuz creates a new object in memory
        System.out.println("result2 = (m + n == \"ab\"): " + result3);

        //
        Integer p = 127;
        Integer q = 127;
        Integer s = 128;
        Integer t = 128;
        boolean equal      = (p == q); // true
        System.out.println("(p == q): " + equal);
        boolean notEqual   = (s == t); // false
        // What? The valueOf(...) methods of java.util.Integer and
        // java.util.Long actually cache values for specific ranges (-128 to 127),
        System.out.println("(s == t): " + notEqual);
        boolean equalAgain = (new Integer(128) == 128); // true
        System.out.println("(new Integer(128) == 128): " + equalAgain);

        /*
        By default, every one of our types inherits the “problematic” comparison
        of object references. To be able to use equals for actual equality,
        we need to override it in our types, having certain properties:
         */
        Object obj = new Object();
        Object obj1 = obj;
        Object obj2 = obj1;
        System.out.println("Reflexive: " +
                "An object should be equal with itself: " +
                "obj.equals(obj) == true: " + obj.equals(obj)); // true
        System.out.println("Symmetric: " +
                "If a.equals(b) == true, " +
                "then b.equals(a) must also be true: " +
                (obj1.equals(obj) && obj.equals(obj1)) ); // true
        System.out.println("Transitive: " +
                "If a.equals(b) == true " +
                "and b.equals(c) == true, " +
                "then a.equals(c) should be true: " +
                ((obj1.equals(obj) && obj2.equals(obj1)) && (obj.equals(obj2)))); // true
        System.out.println("Consistent: " +
                ".equals(b) should always have " +
                "the same value for unmodified objects: " + obj1.equals(obj)); // true
        System.out.println("Null handling: " +
                "a.equals(null) should be false: " + obj.equals(null)); // false
        System.out.println("Hash code: " +
                "Equal objects must have the same hash code: " +
                "|" + obj.hashCode() + "|" +
                "|" + obj.hashCode() + "|" +
                (obj.hashCode() == obj.hashCode())); // true
//        System.out.println("obj1 != obj2 hashcode: " +
        System.out.println("obj1 == obj2 hashcode: " +
                "|" + obj1.hashCode() + "|" +
                "|" + obj2.hashCode() + "|" +
//                (obj1.hashCode() != obj2.hashCode())); // false
                (obj1.hashCode() == obj2.hashCode())); // true

        // If we need to work with decimal values and need absolute precision,
        // we should always use java.util.BigDecimal. But be aware that
        // its equals is based on its precision:
        BigDecimal u = new BigDecimal("2.0");
        BigDecimal v = new BigDecimal("2.0");
        BigDecimal w = new BigDecimal("2.00");

        boolean uEqualV    = u.equals(v); // true
        System.out.println("uEqualV : " + uEqualV);
        boolean uNotEqualW = u.equals(w); // false
        System.out.println("uNotEqualW : " + uNotEqualW);

        // more relaxed comparison, we can use compareTo
        BigDecimal a1 = new BigDecimal("2.0");
        BigDecimal b1 = new BigDecimal("2.0");
        BigDecimal c1 = new BigDecimal("2.00");

        boolean yEqual = a1.equals(b1);    // true
        System.out.println("yEqual : " + yEqual);
        int zResult    = a1.compareTo(c1); // 0, compareTo() consider .00 as .0;
        System.out.println("zResult : " + zResult);
        // NOTE: object should be implements Comparable<ReviewAndTestVerifyExam1Z0811> to use compareTo() method.
        // Then implements method compareTo() from java.lang.Comparable
        // But most of the wrapper primitive classes are already implemented in Comparable
        ReviewAndTestVerifyExam1Z0811 reviewAndTestVerifyExam1Z0811 = new ReviewAndTestVerifyExam1Z0811();
        reviewAndTestVerifyExam1Z0811.compareTo(reviewAndTestVerifyExam1Z0811);

        String[] nums = {"One", "Two", "Three", "Four", "Five", "Six", "Sev"};
        for (int d1 = 0; d1 < nums.length; d1++) { // d1=0; d1=2
            boolean cond = nums[d1++].length() % 3 == 0;
           if (cond) { //d++ : d1=1,true,skip; d1=3,false,stop;
               out.println(cond);
              continue;
           }
           System.out.println(nums[d1]); // nums[3] = "Four"
           break;
        }
        /* NOTE:
        for loop, starts with initial d1 = 0, - 1st execute block
        if condition passed then d1++ - next execute block
         */

        /* ^ skip by 1
        d1 : 0
        d1 : 2
        d1 : 4
        d1 : 6
         */

        /*
        format specifiers:
        d = formats an integer value as a decimal value.
        f = formats a floating point value as a decimal value.
        n = outputs a platform-specific line terminator.
        x = formats an integer as a hexadecimal value.
        s = formats any value as a string.
        tB = formats an integer as a locale-specific month name.
         */
        System.out.format("The square root of %d is %f.%n", 2, 1.414214);

        /*
        figure shows how the longer specifier breaks down into elements are all optional:
        % = Begin Format Specifier
        1$ = Argument Index
        +0 = Flags
        20 = Width
        .10 = Precision
        f = Conversion
         */
        System.out.format("%f, %1$+020.10f %n", Math.PI);
        /*
        The use of a side effect of i++ inside the condition expression in the
        if clause obfuscates the code. This potential confusion is central to this quiz
        question—and it demonstrates why side effects are generally discouraged in
        modern programming. Such side effects tend to get overlooked,
        and they make it harder to comprehend and debug code.
         */

        // Main (Java SE 9 & JDK 9 ) from package com.sun.tools.javac.Main
        // Difference betweeb main()
        //Main.main(new String[]{"ReviewAndTestVerifyExam1Z0811.java"});
        /* ^ FIXME: AJ -
        javac: file not found: ReviewAndTestVerifyExam1Z0811.java
        Usage: javac <options> <source files>
        use -help for a list of possible options
         */

        /*
        The main method accepts a single argument:
        an array of elements of type String.
            public static void main(String[] args)
        This array is the mechanism through which
        the runtime system passes information
        to your application. For example:
            $ java MyApp arg1 arg2
         */
        for (String arg : args) {
            System.out.println("Main Arguments : " + arg);
        }

        //Error: Could not find or load main class ReviewAndTestVerifyExam1Z0811

        Constructor[] ctors = Console.class.getDeclaredConstructors();
        Constructor ctor = null;
        for (int e1 = 0; e1 < ctors.length; e1++) {
            ctor = ctors[e1];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }

        try {
            ctor.setAccessible(true);
            Console f1 = (Console)ctor.newInstance();
            Field g1 = f1.getClass().getDeclaredField("cs");
            g1.setAccessible(true);
            out.format("Console charset         :  %s%n", g1.get(f1));
            out.format("Charset.defaultCharset():  %s%n",
                    Charset.defaultCharset());

            // production code should handle these exceptions more gracefully
        } catch (InstantiationException h1) {
            h1.printStackTrace();
        } catch (InvocationTargetException j1) {
            j1.printStackTrace();
        } catch (IllegalAccessException k1) {
            k1.printStackTrace();
        } catch (NoSuchFieldException l1) {
            l1.printStackTrace();
        }

    }

    private static void method(int a, int b) {
        int ans = 0;
        try {
            ans = a / b;
        } catch (Exception e) {
            System.out.println("Exception"); // this print
        }
    }

    /**
     * Even though we use operators like % and + that aren’t available
     * to the object type Integer, the code compiles fine.
     * Because the compiler unboxes the wrapper type.
     * @param values
     * @return
     */
    static int sumEven(List<Integer> values) {
        int result = 0;
        for (Integer summand: values) {
            if (summand % 2 == 0) {
                result += summand;
            }
        }
        return result;
    }

    /**
     * The actual compiled code looks more like this w/o unboxes the wrapper type
     * @param values
     * @return
     */
    static int sumEven1(List<Integer> values) {
        int result = 0;
        for (Integer summand: values) {
            int i = summand.intValue(); // It actually unbox first before it first
            if (i % 2 == 0) {
                result += i;
            }
        }
        return result;
    }

    /**
     * The java.lang.Object class provides an equals method for all its subclasses - Object.equals(Object other)
     * @param obj
     * @return
     */
    public boolean equals(Object obj) {
        return (this == obj);
    }


    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
     * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
     * <tt>y.compareTo(x)</tt> throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
     * <tt>x.compareTo(z)&gt;0</tt>.
     *
     * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
     * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
     * all <tt>z</tt>.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
     * class that implements the <tt>Comparable</tt> interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(ReviewAndTestVerifyExam1Z0811 o) {
        return this == o ? 0 : 1;
    }
}
