package oca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ArraysAndArrayLists {
    public static void main(String[] args) {
        // Use a one-dimensional array
        arrayDemo();
        declareArraysOfOtherTypes();
        multiDimArrayDemo();
        systemCopyingArraysDemo();
        arraysCopyOfRangeDemo();

        // Create and manipulate an ArrayList
        List<String> listOfStrings = new ArrayList<>();
        // Positional Access —
        listOfStrings = positionalAccess(listOfStrings);
        // Search —
        searchesForSpecifiedObject(listOfStrings);

        // Iteration —
        List<String> list = new ArrayList<>();
        list.add("Adam");
        list.add("Queenie");
        list.add("Dexter");
        list.add("Princess");
        iterationSemantics(list);

        int idx = indexOf("Dexter", list);
        System.out.println("indexOf() = " + idx);

        List<Person> siblings = new ArrayList<>();
        Person dodoi = new Person("Mishael");
        Person adam = new Person("Adam");
        Person queenie = new Person("Queenie");
        Person dexter = new Person("Dexter");
        Person princess = new Person("Princess");
        siblings.add(dodoi);
        siblings.add(adam);
        siblings.add(queenie);
        siblings.add(dexter);
        siblings.add(princess);

        // Set to replace.
        replace(siblings, adam, new Person("AJ"))
                .forEach(p -> System.out.println("siblings name : " + p.getName()));

        List<Person> cousins = new ArrayList<>();
        Person mariel = new Person("Mariel");
        Person carlo = new Person("Carlo");
        Person michael = new Person("Michael");
        cousins.add(mariel);
        cousins.add(carlo);
        cousins.add(michael);

        // Remove and Add to replace.
        replace(siblings, dodoi, cousins)
                .forEach(c -> System.out.println("cousins name : " + c.getName()));

        // Range-view —
        int fromIndex = 0;
        int toIndex = 2;
        // This method eliminates the need for explicit range operations (of the sort that commonly exist for arrays).
        // Any operation that expects a List can be used as a range operation by passing a subList view instead of a whole List.
        list.subList(fromIndex, toIndex).clear();

        System.out.println("Adam(element0) & Queenie(element1) are removed");
        list.forEach(System.out::println);

        int i = list.subList(fromIndex,toIndex).indexOf("Princess");
        System.out.println("Index of Princess : " + i);
        int j = list.subList(fromIndex, toIndex).lastIndexOf("Princess");
        System.out.println("Last Index of Princess : " + j);


    }

    /**
     * creates an array of integers,
     * puts some values in the array,
     * and prints each value to standard output.
     */
    private static void arrayDemo() {
        // declares an array of integers
        int[] anArray;

        // anArray = new int[10]; allocates memory for 10 integers
        anArray = new int[10];

        // Alternatively, you can use the shortcut syntax to create and initialize an array:
        /*
        int[] anArray = {
                100, 200, 300,
                400, 500, 600,
                700, 800, 900, 1000
        };
        */

        // initialize first element
        anArray[0] = 100;
        // initialize second element
        anArray[1] = 200;
        // and so forth
        anArray[2] = 300;
        anArray[3] = 400;
        anArray[4] = 500;
        anArray[5] = 600;
        anArray[6] = 700;
        anArray[7] = 800;
        anArray[8] = 900;
        anArray[9] = 1000;

        System.out.println("Element at index 0: "
                + anArray[0]);
        System.out.println("Element at index 1: "
                + anArray[1]);
        System.out.println("Element at index 2: "
                + anArray[2]);
        System.out.println("Element at index 3: "
                + anArray[3]);
        System.out.println("Element at index 4: "
                + anArray[4]);
        System.out.println("Element at index 5: "
                + anArray[5]);
        System.out.println("Element at index 6: "
                + anArray[6]);
        System.out.println("Element at index 7: "
                + anArray[7]);
        System.out.println("Element at index 8: "
                + anArray[8]);
        System.out.println("Element at index 9: "
                + anArray[9]);
    }

    /**
     * An array's type is written as type[], where type is the data type of the contained elements;
     * the brackets are special symbols indicating that this variable holds an array.
     * As with variables of other types, the declaration does not actually create an array;
     * it simply tells the compiler that this variable will hold an array of the specified type.
     */
    private static void declareArraysOfOtherTypes() {
        // Like declarations for variables of other types, an array declaration has two components:
        // the array's type and the array's name.
        byte[] anArrayOfBytes; // <array's_type>[] <array's_name>
        short[] anArrayOfShorts;
        long[] anArrayOfLongs;
        float[] anArrayOfFloats;
        double[] anArrayOfDoubles;
        boolean[] anArrayOfBooleans;
        char[] anArrayOfChars;
        String[] anArrayOfStrings;

        // this form is discouraged
        float anArrayOfFloats1[];
    }

    /**
     * a multidimensional array is an array whose components are themselves arrays.
     */
    private static void multiDimArrayDemo() {
        // You can also declare an array of arrays (also known as a multidimensional array)
        // by using two or more sets of brackets, such as String[][] names.
        String[][] names = {
                {"Mr. ", "Mrs. ", "Ms. "},
                {"Smith", "Jones"}
        };
        // Mr. Smith
        System.out.println(names[0][0] + names[1][0]);
        // Ms. Jones
        System.out.println(names[0][2] + names[1][1]);
    }

    /**
     * The System class has an arraycopy method that you can use to
     * efficiently copy data from one array into another:
     */
    private static void systemCopyingArraysDemo() {
        String[] copyFrom = {
                "Affogato", "Americano", "Cappuccino", "Corretto", "Cortado",
                "Doppio", "Espresso", "Frappucino", "Freddo", "Lungo", "Macchiato",
                "Marocchino", "Ristretto" };

        String[] copyTo = new String[7];

        /*
        public static void arraycopy(Object src, int srcPos,
                                     Object dest, int destPos, int length)
         */
        System.arraycopy(copyFrom, 2, copyTo, 0, 7);

        for (String coffee : copyTo) {
            System.out.print(coffee + " ");
        }
    }

    /**
     * Performing array manipulations (common tasks, such as copying, sorting and searching arrays)
     * in the java.util.Arrays class.
     *
     * The difference is that using the copyOfRange method does not require you to
     * create the destination array before calling the method, because the destination array
     * is returned by the method
     */
    private static void arraysCopyOfRangeDemo() {
        String[] copyFrom = {
                "Affogato", "Americano", "Cappuccino", "Corretto", "Cortado",
                "Doppio", "Espresso", "Frappucino", "Freddo", "Lungo", "Macchiato",
                "Marocchino", "Ristretto" };

        /*
        Note that the second parameter of the copyOfRange method is the initial index of the range
        to be copied, inclusively,
        while the third parameter is the final index of the range
        to be copied, exclusively.
        In this example, the range to be copied does not include the array element at index 9
        (which contains the string Lungo).
         */
        String[] copyTo = java.util.Arrays.copyOfRange(copyFrom, 2, 9);
        for (String coffee : copyTo) {
            System.out.print(coffee + " ");
        }
    }

    /*
    Some other useful operations provided by methods in the java.util.Arrays class are:
    Searching an array for a specific value to get the index at which it is placed (the binarySearch method).
    Comparing two arrays to determine if they are equal or not (the equals method).
    Filling an array to place a specific value at each index (the fill method).
    Sorting an array into ascending order. This can be done either sequentially, using the sort method, or concurrently, using the parallelSort method introduced in Java SE 8. Parallel sorting of large arrays on multiprocessor systems is faster than sequential array sorting.
    Creating a stream that uses an array as its source (the stream method). For example, the following statement prints the contents of the copyTo array in the same way as in the previous example:
    java.util.Arrays.stream(copyTo).map(coffee -> coffee + " ").forEach(System.out::print);
    See Aggregate Operations for more information about streams.
    Converting an array to a string. The toString method converts each element of the array to a string, separates them with commas, then surrounds them with brackets. For example, the following statement converts the copyTo array to a string and prints it:
    System.out.println(java.util.Arrays.toString(copyTo));
    This statement prints the following:[Cappuccino, Corretto, Cortado, Doppio, Espresso, Frappucino, Freddo]
     */

    // A List is an ordered Collection, it's operations inherited from Collection.

    /**
     * Positional access — manipulates elements based on their numerical position in the list.
     * This includes methods such as get, set, add, addAll, and remove.
     */
    private static List<String> positionalAccess(List<String> listOfStrings) {
        // Add
        listOfStrings.add("Adam John");
        listOfStrings.add("Leah");
        System.out.println("List of names : ");
        listOfStrings.forEach(System.out::println);

        // Get
        String name = listOfStrings.get(0);
        System.out.println("Name indexed at 0 : " + name);

        // Set
        listOfStrings.set(0, "AJ");
        System.out.println("List of names (after changed) : ");
        listOfStrings.forEach(System.out::println);

        // Add All
        List<String> anotherListOfStrings = Arrays.asList("Melvin Kenneth", "Tina", "Bruno");
        listOfStrings.addAll(anotherListOfStrings);

        // Remove
        boolean removed = listOfStrings.remove("Bruno");
        System.out.println(removed ? "Successfully Removed" : "The list does not contain the element");
        boolean removed1 = listOfStrings.remove("Raven");
        System.out.println(removed1 ? "Successfully Removed" : "The list does not contain the element");

        return listOfStrings;
    }

    /**
     * searches for a specified object in the list and returns its numerical position.
     * Search methods include indexOf and lastIndexOf.
     */
    private static void searchesForSpecifiedObject(List<String> listOfStrings) {
        // Index Of
        int found = listOfStrings.indexOf("AJ");
        System.out.println(found > 0 ? "Found name in index of - " + found : "The list does not contain the element");System.out.println(found > 0 ? "Found name in index " + found : "The list does not contain the element");System.out.println(found > 0 ? "Found name in index " + found : "The list does not contain the element");

        // Last Index Of
        int foundLastIndexOf = listOfStrings.lastIndexOf("Leah");
        System.out.println(foundLastIndexOf > 0 ? "Found name in last index of - " + found : "The list does not contain the element");System.out.println(found > 0 ? "Found name in index " + found : "The list does not contain the element");System.out.println(found > 0 ? "Found name in index " + found : "The list does not contain the element");
    }

    /**
     * extends Iterator semantics to take advantage of the list's sequential nature.
     * The listIterator methods provide this behavior.
     *
     * ListIterator, which allows you to traverse the list in either direction,
     * modify the list during iteration, and obtain the current position of the iterator.
     */
    private static void iterationSemantics(List<String> list) {
        // The three methods that ListIterator inherits from Iterator (hasNext, next, and remove)
        // The hasPrevious and the previous operations are exact analogues of hasNext and next.
        // The former operations refer to the element before the (implicit) cursor,
        // whereas the latter refer to the element after the cursor.
        // The previous operation moves the cursor backward, whereas next moves it forward.

        for (ListIterator<String> it = list.listIterator(list.size()); it.hasPrevious(); ) {
            String t = it.previous();
            System.out.println("name : " + t);
        }
    }

    private static int indexOf(String s, List<String> list) {
        /*
                    Adam       Queenie    Dexter     Princess
                    element(0) element(1) element(2) element(3)
                   ^          ^          ^          ^          ^
                   |          |          |          |          |
            index: 0          1          2          3          4
         */
        // Intuitively speaking, the cursor is always between two elements —
        // the one that would be returned by a call to previous and the one that would be returned by a call to next.
        for (ListIterator<String> it = list.listIterator(); it.hasNext(); )
            if (s == null ? it.next() == null : s.equals(it.next())) return it.previousIndex();

        // Element not found.
        return -1;
    }

    /**
     * The ListIterator interface provides two additional operations to modify the list — set and add.
     * The set method overwrites the last element returned by next or previous with the specified element.
     * The following polymorphic algorithm uses set to replace all occurrences of one specified value with another.
     * @param list
     * @param val
     * @param newVal
     * @param <E>
     * @return
     */
    private static <E> List<E> replace(List<E> list, E val, E newVal) {
        for (ListIterator<E> it = list.listIterator(); it.hasNext(); )
            // The only bit of trickiness in this example is the equality test between val and it.next.
            // You need to special-case a val value of null to prevent a NullPointerException.
            if (val == null ? it.next() == null : val.equals(it.next()))
                it.set(newVal);

        return list;
    }

    /**
     * The add method inserts a new element into the list immediately before the current cursor position.
     * This method is illustrated in the following polymorphic algorithm to replace all occurrences
     * of a specified value with the sequence of values contained in the specified list.
     * @param list
     * @param val
     * @param newVals
     * @param <E>
     * @return
     */
    private static <E> List<E> replace(List<E> list, E val, List<? extends E> newVals) {
        for (ListIterator<E> it = list.listIterator(); it.hasNext(); ) {
            if (val == null ? it.next() == null : val.equals(it.next())) {
                it.remove();

                for (E e : newVals) {
                    it.add(e);
                }
            }
        }

        return list;
    }

    /**
     * Here's a polymorphic algorithm whose implementation uses subList to deal a hand from a deck.
     * That is, it returns a new List (the "hand") containing the specified number of elements taken
     * from the end of the specified List (the "deck").
     * The elements returned in the hand are removed from the deck.
     * @param deck
     * @param n
     * @param <E>
     * @return
     */
    private static <E> List<E> dealHand(List<E> deck, int n) {
        int deckSize = deck.size();
        List<E> handView = deck.subList(deckSize - n, deckSize);
        List<E> hand = new ArrayList<E>(handView);
        handView.clear();
        return hand;
    }
}

class Person {
    private String name;

    Person(String name) {
        this.name = name;
    }

    protected String getName() {
        return this.name;
    }
}
