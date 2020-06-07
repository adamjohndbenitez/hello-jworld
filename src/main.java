/*
This is a demo task.
Write a function:
    class Solution { public int solution(int[] A); }
that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
Given A = [1, 2, 3], the function should return 4.
Given A = [−1, −3], the function should return 1.
Write an efficient algorithm for the following assumptions:
        N is an integer within the range [1..100,000];
        each element of array A is an integer within the range [−1,000,000..1,000,000].
* */

import practice.*;
import practice.vertx.BasicVerticle;
import practice.vertx.rxjava.VertxRxJava;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        System.out.println("hello world!");
//        practice.Palindrome palindrome = new practice.Palindrome();
//        palindrome.checkPalindrome();

        // Run Length Encoding.
        RunLengthEncoding runLengthEncoding = new RunLengthEncoding();
        // Test various inputs
        String[] testInput = {"abcd", "aaabbccc", "abcdeedddeab"};
        for(String input : testInput) {
            System.out.println(String.format("practice.RunLengthEncoding input : %s, output : %s", input, runLengthEncoding.encode(input)));
        }

        // Amazon Demo :  Eight Houses
        AmazonDemo amazonDemo = new AmazonDemo();
        int[] cells1 = new int[]{1, 0, 0, 0, 0, 1, 0, 0}; // #1
        int[] cells2 = new int[]{1, 1, 1, 0, 1, 1, 1, 1}; // #2
        int days1 = 1, days2 = 2;
        System.out.println("#1 Eight Houses : input    " + Arrays.toString(cells1));
        System.out.println("#1 Eight Houses : expected " + Arrays.toString(new int[] {0,1,0,0,1,0,1,0}));
        System.out.println("#1 Eight Houses : ouput    " + amazonDemo.cellCompete(cells1, days1).toString() + "\n");

        System.out.println("#2 Eight Houses : input    " + Arrays.toString(cells2));
        System.out.println("#2 Eight Houses : expected " + Arrays.toString(new int[] {0, 0, 0, 0, 0, 1, 1, 0}));
        System.out.println("#2 Eight Houses : ouput    " + amazonDemo.cellCompete(cells2, days2).toString() + "\n");

        //input num = 5, arr [2, 3, 4, 5, 6]
        //input num = 5, arr [2, 4, 6, 8, 10]
        int[] arr1 = new int[]{2, 3, 4, 5, 6}; // #1
        int[] arr2 = new int[]{2, 4, 6, 8, 10}; // #2
        int num1 = 5, num2 = 5;

        System.out.println("#1 GCD : input    num1[" + num1 + "], arr1[" + Arrays.toString(arr1) + "]");
        System.out.println("#1 GCD : expected 1");
        System.out.println("#1 GCD : ouput    " + amazonDemo.generalizedGCD(num1, arr1) + "\n");

        System.out.println("#2 GCD : input    num2[" + num2 + "], arr2[" + Arrays.toString(arr2) + "]");
        System.out.println("#2 GCD : expected 2");
        System.out.println("#2 GCD : ouput    " + amazonDemo.generalizedGCD(num2, arr2) + "\n");

        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("Sorted array is");
        ob.printArray(arr);

        StringRecursionDemo stringRecursionDemo = new StringRecursionDemo();
        System.out.println(stringRecursionDemo.recursiveString("Sandy"));

        // Multithreading...
        // Threads can be created by using two mechanisms :
        // 1. Extending the Thread class
        // 2. Implementing the Runnable Interface
        MultiThreading1 multithreading1 = new MultiThreading1();
        multithreading1.numberOfThreads(4);
        multithreading1.numberOfThreads(8);

        MultiThreading2 multithreading2 = new MultiThreading2();
        multithreading2.numberOfThreads(4);
        multithreading2.numberOfThreads(8);

        //Thread Class vs Runnable Interface
        // 1. If we extend the Thread class, our class cannot extend any other class because Java doesn’t
        // support multiple inheritance. But, if we implement the Runnable interface,
        // our class can still extend other base classes.
        //
        // 2. We can achieve basic functionality of a thread by extending Thread class
        // because it provides some inbuilt methods like yield(), interrupt() etc.
        // that are not available in Runnable interface.


        System.out.println("Vertx...");
        // Vertx...
        // Vert.x is an open source, reactive, polyglot toolkit or platform running on the Java Virtual Machine.
        // You can think of Vert.x as an alternative to the Java Enterprise Edition but with a different approach
        // to solving the same problem - developing networked, highly concurrent applications.
        //
        // Vert.x as a Toolkit or Platform
        // Vert.x can be used like toolkit. You can embed Vert.x in your standalone Java application,
        // instantiate a Vertx object and call methods on it to get Vert.x to do what you need it to.
        // In toolkit mode your code controls Vert.x.
        //
        // Vert.x can also function like a platform.
        // You can startup Vert.x from the command line and tell it what components of yours to run.
        // This is similar to how you normally start up a Java EE application server.
        //
        // Vert.x is Reactive
        // Vert.x calls itself a reactive toolkit. Reactive applications consists of components that
        // send messages or events to each other. This is quite a different internal design than Java EE.
        // This internal design makes Vert.x suitable for different types of applications
        // than Java EE (for instance chat and game servers).
        // In fact, I would risk the bold claim that Vert.x is suitable for more types of applications than Java EE.
        //
        // source: http://tutorials.jenkov.com/vert.x/verticles.html#listening-for-messages
        BasicVerticle myVerticle = new BasicVerticle();
        myVerticle.vertxDeployVerticle();


        System.out.println("Vert.x API for RxJava");
        // Vert.x RxJava..
        // Vert.x API for RxJava
        //
        // RxJava is a popular library for composing asynchronous and event based programs using
        // observable sequences for the Java VM. Vert.x integrates naturally with RxJava,
        // allowing to use observable wherever you can use streams or asynchronous results.
        // There are two ways for using the RxJava API with Vert.x:
        // 1. via the original Vert.x API with the RxHelper helper class that provides static methods for converting objects between Vert.x core API and RxJava API.
        // 2. via the Rxified Vert.x API enhancing the core Vert.x API.
        //
        // source: https://vertx.io/docs/vertx-rx/java/
        VertxRxJava vertxRxJava = new VertxRxJava();
        vertxRxJava.readStreamSupport1();

    }
}


