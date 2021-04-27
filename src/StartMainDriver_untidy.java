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

import play.*;
import play.lambdas.Lambdas;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.math.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StartMainDriver_untidy {
    public static void mainx(String[] args) {
        System.out.println("hello world!");
//        play.Palindrome palindrome = new play.Palindrome();
//        palindrome.checkPalindrome();

        // Run Length Encoding.
        RunLengthEncoding runLengthEncoding = new RunLengthEncoding();
        // Test various inputs
        String[] testInput = {"abcd", "aaabbccc", "abcdeedddeab"};
        for(String input : testInput) {
            System.out.println(String.format("play.RunLengthEncoding input : %s, output : %s", input, runLengthEncoding.encode(input)));
        }

        // Amazon Demo :  Eight Houses
        AmazonDemo amazonDemo = new AmazonDemo("s1", "s2", 1);
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
//        BasicVerticle myVerticle = new BasicVerticle();
//        myVerticle.vertxDeployVerticle();


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
//        VertxRxJava vertxRxJava = new VertxRxJava();
//        vertxRxJava.readStreamSupport1();

    }

    private static final List<Object> CLASS_LIST = new ArrayList<>(); // List of classes.
    static {
        addClasses(new AmazonDemo("1", "2", 1));
        addClasses(new Lambdas());
    }
    private static void addClasses(Object obj) {
        CLASS_LIST.add(obj);
    }

    //TODO: migrate the contents here in main driver.
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("#####################");
        System.out.println("# hello java world! #");
        System.out.println("#####################");
        int sizeClz = 0;
        for (Object obj: CLASS_LIST) {
            System.out.println(String.format("[%s] Class name => [%s]", ++sizeClz, obj.getClass().getName())); // Print package first play.<inner_packages>.Classes
        }
        System.out.println("Pls Select a [number] of class above: ");
        int ansClz = userInput(scan, sizeClz);
        // Ensure/Secure user input choose between how much classes were added.
        Class<?> clazz = CLASS_LIST.get(ansClz - 1).getClass();
        System.out.println("Chose class => " + clazz);

        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        System.out.println(String.format("It has %s constructors", constructors.length));
        int sizeConstructor = 0;
        for (Constructor<?> c : constructors) {
            System.out.println(String.format("[%s] constructor => [%s]", ++sizeConstructor, c.getName()));
            for (Class<?> parameterType : c.getParameterTypes()) {
                System.out.println(" |__parameterType => " + parameterType.getTypeName());
            }
        }

        System.out.println("Select a [number] of constructor above to instantiate:");
        int ansConstructor = userInput(scan, sizeConstructor);
        Constructor<?> newConstructor = constructors[ansConstructor - 1];
        System.out.println(String.format("Enter [%s] parameter type arguments to put values on constructor [%s]",
                newConstructor.getParameterCount(), newConstructor));

        String str;
        Object[] objs = new Object[newConstructor.getParameterCount()];
        for (int i=0; i < newConstructor.getParameterCount(); i++) {
            System.out.print(String.format("Input parameter type for [%s] >",
                    newConstructor.getParameterTypes()[i].getName()));
            switch (newConstructor.getParameterTypes()[i].getName()) {
                case "int" :
                    if (scan.hasNextInt()) objs[i] = Integer.parseInt(scan.next());
                    break;
                case "double" :
                    if (scan.hasNextDouble()) objs[i] = Double.parseDouble(scan.next());
                    break;
                case "float" :
                    if (scan.hasNextFloat()) objs[i] = Float.parseFloat(scan.next());
                    break;
                case "java.math.BigDecimal" :
                    if (scan.hasNextBigDecimal()) objs[i] = new BigDecimal(scan.next());
                    break;
                case "java.math.BigInteger" :
                    if (scan.hasNextBigInteger()) objs[i] = new BigDecimal(scan.next());
                    break;
                default:
                    str = scan.next(); //Default to string
                    objs[i] = str;
            }
        }
        Object instConstructor = newConstructor.newInstance(objs);

        Method[] methods = instConstructor.getClass().getDeclaredMethods(); // Gets all methods except inherited methods.
        int sizeMethods = 0;
        System.out.println(String.format("It has [%s] methods.", methods.length));
        for (Method method : methods) {
            System.out.println(String.format("[%s] methods => [%s]", ++sizeMethods, method.getName()));
            for (Class<?> argsType : method.getParameterTypes()) {
                System.out.println(" |__argumentType => " + argsType.getTypeName());
            }
        }
        System.out.println("Select a [number] of method to invoke:");
        int ansMethod = userInput(scan, sizeMethods);
        System.out.println("Chose method => " + methods[ansMethod - 1]);
//        int sizeArgs = 0;
//        for (Class<?> cl : methods[ansMethod - 1].getParameterTypes()) {
//            System.out.println(String.format("[%s] argument => [%s]", ++sizeArgs, cl.getTypeName()));
//        }
        Method newMethod = methods[ansMethod - 1];
        Class<?>[] methodParamTypes = newMethod.getParameterTypes();
        System.out.println(String.format("Enter [%s] parameter type arguments to put values on method [%s]",
                methodParamTypes.length, newMethod));

        String str1;
        Object[] objs2 = new Object[newMethod.getParameterCount()];
        for (int i = 0; i < newMethod.getParameterCount(); i++) {
            System.out.print(String.format("Input parameter type for [%s] >",
                    newMethod.getParameterTypes()[i].getName()));
            switch (newMethod.getParameterTypes()[i].getName()) {
                case "int" :
                    if (scan.hasNextInt()) objs2[i] = Integer.parseInt(scan.next());
                    break;
                case "int[]" :
                    if (scan.hasNext(",")) {
                        scan.useDelimiter(",");

                    }
                    break;
                case "double" :
                    if (scan.hasNextDouble()) objs2[i] = Double.parseDouble(scan.next());
                    break;
                case "float" :
                    if (scan.hasNextFloat()) objs2[i] = Float.parseFloat(scan.next());
                    break;
                case "java.math.BigDecimal" :
                    if (scan.hasNextBigDecimal()) objs2[i] = new BigDecimal(scan.next());
                    break;
                case "java.math.BigInteger" :
                    if (scan.hasNextBigInteger()) objs2[i] = new BigDecimal(scan.next());
                    break;
                default:
                    str1 = scan.next(); //Default to string
                    objs2[i] = str1;
            }
        }


        /*
        private static Object accessMethod(Object obj, Class<?> clazz, Object[] args, String methodName, Class<?>... parameterTypes)
            throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Method method = clazz.getDeclaredMethod(methodName, parameterTypes);
        method.setAccessible(true);
        if (args != null) {
            return method.invoke(obj, args);
        } else {
            return method.invoke(obj);
        }
    }
         */


//        //TODO: User Input method.
//        System.out.println(String.format("Now select a [number] of a method of %s to run & show output: ", constructor));
//        System.out.print(">");
//        int ansMethod = scan.nextInt();
//        // Ensure/Secure user input choose between how much methods were added and transform it into index (starts [0])
//        System.out.println(String.format("Chose [%s] method = %s", ansMethod, methods[sizeMethods <= ansMethod || ansMethod >= 1 ? ansMethod-1 : 0]));

        //TODO: Once selected the class will fire up/run through the methods.
        //      -OR- interactively ask User Inputs to feed arguments to methods.
        //      -OR- list down first the methods of the Class to run and ask User Input for arguments.

        scan.close();
    }

    private static List<Object> putValuesOnArguments(Scanner scan, String argsType) {
        List<Object> retVal = new ArrayList<>();
        switch (argsType) {
            case "int":
                System.out.println("input int type value to fill in:");
                retVal.add(userInput(scan, 0));
                break;
            case "int[]":
                System.out.println("input string of integer like 1,2,3,4");
                //TODO: create a function that transform string into array of integers
                retVal.add(transformIntoIntArray(argsType));
        }
        return retVal;
    }

    /**
     * Converts the string of array which is separated by comma into numbers.
     * @param str  String to be cut/split by comma.
     * @return     array of integers.
     */
    private static int[] transformIntoIntArray(String str) {
        String[] cutStrings = str.split(",");
        int[] retVal = new int[cutStrings.length];
        for (int i = 0; i < cutStrings.length; i++) {
            retVal[i] = Integer.parseInt(cutStrings[i]);
        }
        return retVal;
    }

    /**
     * User input must be <code>int</code> if it's not it will ask again &
     * It validates the negative value or value that is out of size then ask again.
     * Exits the program when user input "quit".
     * @param scan  A simple text scanner which can parse primitive types.
     * @param size  number of classes or constructors or methods.
     * @return      user input of integer type.
     */
    private static int userInput(Scanner scan, int size) {
        boolean isInt;
        boolean isAbove = false;
        int input = 0;

        do {
            System.out.print(">");
            isInt = scan.hasNextInt();
            String strScan = scan.next();
            if (strScan.equalsIgnoreCase("quit")) {
                System.exit(0);
            } else {
                if (isInt) {
                    input = Integer.parseInt(strScan);
                    isAbove = size < input || input < 0;
                    if (isAbove) {
                        System.out.println("Try again [Input => " + input + " is out, we only have => " + size + " Classes]");
                    }
                } else {
                    System.out.println("Try again [Invalid => " + scan.next() + "]");
                }
            }
        } while (!isInt || isAbove);

        return input;
    }


}


