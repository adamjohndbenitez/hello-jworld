package linkedin.advancejava.generics.varargs;

/**
 * Sometimes, we want to write a method that takes a variable number of arguments.
 * In Java there is a feature called variable-length arguments,
 * or varargs for short, which allows you to do this.
 */
public class VarArgs {
    public static void main(String[] args) {
        String item = "Apples";
        String item1 = "Oranges";
        String item2 = "Pears";
        // We can also get rid of this array of Strings declaration, just pass this in varargs method - will just create an array for us anyway.
        String[] shopping = {"Bread", "Milk", "Eggs", "Bananas"};
        printShoppingListCorrect("Bread", "Milk", "Eggs", "Bananas");
//        printShoppingList(item1, item2);
//        printShoppingList(item, item1, item2);
//        printShoppingList(shopping);
        // All above methods can just be replace with this -
        printShoppingListCorrect(item1, item2);
        printShoppingListCorrect(item, item1, item2);
        printShoppingListCorrect(shopping);
    }

    // Overloading method - 2 parameter arguments
    private static void printShoppingList(String s1, String s2) {
        System.out.println("SHOPPING LIST:");
        System.out.println("1. " + s1);
        System.out.println("2. " + s2);
    }

    // Overloading method - 3 parameter arguments
    private static void printShoppingList(String s1, String s2, String s3) {
        System.out.println("SHOPPING LIST:");
        System.out.println("1. " + s1);
        System.out.println("2. " + s2);
        System.out.println("3. " + s3);
    }

    /**
     * If same method name and parameter argument of
     * void printShoppingList(String[] s)
     * - OR -
     * void printShoppingList(String... s)
     * ERROR => 'printShoppingList(String[])' is already defined in 'linkedin.advancejava.generics.varargs.VarArgs'
     * Java treat them as equal
     * And all of the overloading methods can just be used to rreplace all of those including printShoppingList(String[] s)
     * @param s
     */
    private static void printShoppingList(String[] s) { // (Improved) Overloading method - lists of parameter arguments
        System.out.println("SHOPPING LIST:");
        for (int i = 0; i < s.length; i++) {
            System.out.println(i + ". " + s[i]);
        }
    }
//    private static void printShoppingList(String... s) {
//        System.out.println("SHOPPING LIST:");
//        for (int i = 0; i < s.length; i++) {
//            System.out.println(i + ". " + s[i]);
//        }
//    }

    /*
    THE PROBLEM: with these approach - overloading methods - each time I add new item in parameter arguments.
    the method will also get long if there were lots of items.
     */

    /*
    THE SOLUTION: Use varargs
    Using the vararg method made my code shorter and simpler, but it is still easy to read and understand.
    And if I run this all again, I can see that I get exactly the same output.
     */

    /**
     * Replace String[] w/ String... saying that I cannot have this method and the method that takes an arrray in the same class.
     * This is because both methods are functionally the same. When I use the variable arguments, the separate itmes are added into an array for me.
     * Using the varargs version of the method, we can pass in 1, 2, no items (like it's optional) or an array of items.
     * @param s
     */
    private static void printShoppingListCorrect(String... s) {
        System.out.println("SHOPPING LIST:");
        for (int i = 0; i < s.length; i++) {
            System.out.println(i + ". " + s[i]);
        }
    }
}
