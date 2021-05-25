import play.AmazonDemo;
import play.lambdas.Lambdas;

import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author adamjohndbenitez
 * @since
 * @version
 * @see StartMainDriver_untidy#main(String[])
 */
public class StartMainDriver<T> {
    private static final List<Object> CLASS_LIST = new ArrayList<>(); // List of classes.

    static {
        addClasses(new AmazonDemo("1", "2", 1));
        addClasses(new Lambdas());
        //TODO: Add Classes here to reload upon start.
    }

    private static void addClasses(Object obj) {
        CLASS_LIST.add(obj);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("#####################");
        System.out.println("# hello java world! #");
        System.out.println("#####################");

        int sizeClass = 0;
        for (Object obj : CLASS_LIST) {
            System.out.println(String.format("[%s] <= Class [%s]", ++sizeClass, obj.getClass().getName())); // Print package first play.<inner_packages>.Classes
        }
        System.out.println("Pls Select a [number] of the class above: ");
        int ansClass = userInput(scan, sizeClass);//TODO: userInput should confirmation of the answer.

        Class<?> clazz = CLASS_LIST.get(ansClass - 1).getClass();
        System.out.println(String.format("Chose class => %s", clazz));

        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        System.out.println(String.format("It has %s constructors, see list below", constructors.length));
        Arrays.stream(constructors).forEach(System.out::println);
        printing(constructors);

        System.out.println("Pls Select a [number] of constructor above to instantiate:");
        int ansConstructor = userInput(scan, constructors.length);

        Constructor<?> newConstructor = constructors[ansConstructor - 1];
        System.out.println(String.format("Chose constructor => %s", newConstructor));
        System.out.println(String.format("It has %s parameter types, see list below", newConstructor.getParameterCount()));
        Arrays.stream(newConstructor.getParameterTypes()).forEach(System.out::println);
        System.out.println(String.format("Pls provide [%s] parameter type argument/s to put values on constructor [%s]",
                newConstructor.getParameterCount(), newConstructor));

        Object instConstructor;
        Method method;
        try {
            Object[] objs = parseParameters(scan, newConstructor);
            instConstructor = newConstructor.newInstance(objs);//FIXME#3: newInstance() is expecting to have the correct params. throws java.lang.IllegalArgumentException.
            Method[] methods = instConstructor.getClass().getDeclaredMethods();
            System.out.println(String.format("It has %s methods, see list below", methods.length));
            Arrays.stream(methods).forEach(System.out::println);
            printing(methods);

            System.out.println("Pls Select a [number] of method to invoke:");
            int ansMethod = userInput(scan, methods.length);

            Method newMethod = methods[ansMethod - 1];
            System.out.println("newMethod: [" + newMethod.getName() + "]");
            method = clazz.getDeclaredMethod(newMethod.getName(), newMethod.getParameterTypes());
            method.setAccessible(true);
            Object retval = method.invoke(clazz.newInstance(), parseParameters(scan, method));
            System.out.println("retval: [" + retval + "]");//FIXME: getStr returning null
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.out.println(String.format("Exception[%s], Error msg [%s]", e, e.getMessage()));
            e.printStackTrace();
        }

    }

    /**
     * Prints the name, number and parameter types of the object that was passed in.
     * @param type  any instance of an object as long as it extends {@code Executable}.
     */
    private static void printing(Executable[] type) {
        int sizeConstructor = 0;
        for (Executable exec : type) {
            System.out.println(String.format("[%s] %s => [%s]",
                    ++sizeConstructor, exec.getClass().getSimpleName(), exec.getName()));
            for (Class<?> parameterType : exec.getParameterTypes()) {
                System.out.println(String.format(" |__parameterType => %s", parameterType.getTypeName()));
            }
        }
    }

    /**
     * Parse a next input of parameter type on whatever type it was interpreted for it.
     * @param scan    input type base on what name it belongs but by default it converted into String.
     * @param newObj  an new instance of underlying object that could be any as long as it extends {@code Executable}.
     * @return        a new instance with an array of objects to be passed as arguments.
     */
    private static Object[] parseParameters(Scanner scan, Executable newObj) {
        String str;
        Object[] objs = new Object[newObj.getParameterCount()];

        for (int i = 0; i < newObj.getParameterCount(); i++) {
            boolean incorrect = false;
            String typeName = newObj.getParameterTypes()[i].getTypeName();
            System.out.print(String.format("Input parameter type for [%s] >", typeName));

            do {
                if (scan.hasNext()) scan = scan.reset(); //Clears explicit state after re-entering incorrect input.

                switch (typeName) {
                    case "int[]":
                        System.out.print("input string of integer like (1,2,3,4)");
                        objs[i] = transformIntoIntArray(scan.next());
                        break;
                    case "int":
                        if (incorrect) {
                            System.out.print("Invalid input. Try again >");
                            String reEnter = scan.next();
                            if (isParsable(reEnter, typeName)) {
                                objs[i] = Integer.parseInt(reEnter);
                                incorrect = false;
                            } else {
                                incorrect = true;
                            }
                        } else {
                            if (scan.hasNextInt()) {
                                objs[i] = Integer.parseInt(scan.next());
                                incorrect = false;
                            } else {
                                incorrect = true;
                            }
                        }
                        break;
                    case "double":
                        if (incorrect) {
                            System.out.print("Invalid input. Try again >");
                            String reEnter = scan.next();
                            if (isParsable(reEnter, typeName)) {
                                objs[i] = Double.parseDouble(reEnter);
                                incorrect = false;
                            } else {
                                incorrect = true;
                            }
                        } else {
                            if (scan.hasNextInt()) {
                                objs[i] = Double.parseDouble(scan.next());
                                incorrect = false;
                            } else {
                                incorrect = true;
                            }
                        }
                        break;
                    case "float":
                        if (incorrect) {
                            System.out.print("Invalid input. Try again >");
                            String reEnter = scan.next();
                            if (isParsable(reEnter, typeName)) {
                                objs[i] = Float.parseFloat(reEnter);
                                incorrect = false;
                            } else {
                                incorrect = true;
                            }
                        } else {
                            if (scan.hasNextInt()) {
                                objs[i] = Float.parseFloat(scan.next());
                                incorrect = false;
                            } else {
                                incorrect = true;
                            }
                        }
                        break;
                    case "java.math.BigDecimal": //TODO: handle incorrect big decimal
                        if (scan.hasNextBigDecimal()) objs[i] = new BigDecimal(scan.next());
                        else incorrect = true;
                        break;
                    case "java.math.BigInteger": //TODO: handle incorrect big integer?
                        if (scan.hasNextBigInteger()) objs[i] = new BigDecimal(scan.next());
                        else incorrect = true;
                        break;
                    default:
                        str = scan.next(); //Default to string
                        objs[i] = str;
                }

            } while (incorrect == true);
        }

        return objs;
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
                    isAbove = size < input || input <= 0;
                    if (isAbove) {
                        System.out.println("Try again [Input => " + strScan + " is out, we only have => " + size + " Classes]");
                    }
                } else {
                    System.out.println("Try again [Input => " + strScan + " is not a number]");
                }
            }
        } while (!isInt || isAbove);

        return input;
    }

    /**
     * Parses string input into integer using {@code Pattern} to compile representation of a digit "\d" regular expression.
     * Followed by "+" matches between one and unlimited times, as many times as possible, (greedy).
     * Once compiled pattern then using {@code Matcher} that will match the given input against this pattern.
     * @param strScan  input token from user using {@code Scanner}.
     * @return         {@code null} when empty/null otherwise returns parse Integer.
     */
    private static Integer parseStringToInt(String strScan) {
        if (strScan == null || strScan.isEmpty()) return null;

        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(strScan);
        if (m.matches()) return Integer.parseInt(m.group());
        else return null;
    }

    /**
     * Determines that the string can be a numeric number.
     * @param str  Re-enter value after invalid.
     * @return     boolean value that it's parsable or not.
     */
    private static boolean isParsable(String str, String typeStr) {
        if (str == null) return false;

        try {
            if (typeStr.equals("int")) Integer.parseInt(str);
            if (typeStr.equals("double")) Double.parseDouble(str);
            if (typeStr.equals("float")) Float.parseFloat(str);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }
}
