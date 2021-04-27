import play.AmazonDemo;
import play.lambdas.Lambdas;

import java.util.ArrayList;
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
public class StartMainDriver {
    private static final List<Object> CLASS_LIST = new ArrayList<>(); // List of classes.

    static {
        addClasses(new AmazonDemo("1", "2", 1));
        addClasses(new Lambdas());
        //TODO: Add Classes here.
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
        int answerClass = userInput(scan, sizeClass);

        // Ensure/Secure user input choose between how much classes were added.
//        Class<?> clazz = CLASS_LIST.get(answerClass <= 0 ? answerClass - 1 : 0).getClass();
//        System.out.println("Chose class => " + clazz);
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
                    System.out.println("Try again [Invalid => " + strScan + "]");
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
}
