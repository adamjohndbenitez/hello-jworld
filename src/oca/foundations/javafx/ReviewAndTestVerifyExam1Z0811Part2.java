package oca.foundations.javafx;

import java.util.Random;

/**
 * CAPTURED Q:
 * for(; str.compareTo()
 * catch Exception, catch Arithmetic
 * post increment, pre iincrement
 * int var1; sout var
 * Random r1, Random r2 ==
 * Robust, platform dependent, garbage direct management java
 */
public class ReviewAndTestVerifyExam1Z0811Part2 {
    public static void main(String[] args) {
        //for(; str.compareTo()
        String str1 = "a";
        for(; str1.compareTo("aaa") == 0; str1 = str1 + "a") { // str1.compareTo("aaa") == 0 <- is always false
            System.out.print("length :" + str1.length() + " ");
        }
        System.out.print(str1 + " ");

        //catch Exception, catch Arithmetic
        int val;
        try {
            val = 1/0;
        } catch (Exception e) {
            System.out.println("Exception");
//        } catch (ArithmeticException ae) { // Compile error : Exception 'java.lang.ArithmeticException' has already been caught
            System.out.println("ArithmeticException");
        }

        int val1;
        try {
            val1 = 1/0;
        } catch (ArithmeticException ae) { // Correct, ide wants it to move first than Exception cuz it is already captured in Exception.
            System.out.println("ArithmeticException");
        } catch (Exception e) {
            System.out.println("Exception");
        }

        // int var1; sout var
        int var2;
        int var3;

//        System.out.println(var2);// Compile error : Variable 'var2' might not have been initialized

        //Random r1, Random r2 ==
        Random r1 = new Random(10);
        Random r2 = new Random(10);

        if (r1.nextInt() == r2.nextInt()) {
            System.out.println("Jack");
        } else {
            System.out.println("Queen");
        }

        // Tried to put 1 seed = "Jack", 5
        // if play "Jack", Queen if debug mode.
    }
}
