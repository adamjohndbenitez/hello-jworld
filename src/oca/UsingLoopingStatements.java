package oca;

import java.util.*;

public class UsingLoopingStatements {
    public static void main(String[] args) {
        // Describe looping statements = continually executes a block of statements while a particular condition is true

        // Use a for loop including an enhanced for loop
        forLoopDemo();
        enhanceForDemo();

        // Use a while loop
        whileDemo();

        // Use a do- while loop = do-while evaluates its expression at the bottom of the loop instead of the top.
        // Therefore, the statements within the do block are always executed at least once
        doWhileDemo();

        // Compare and contrast the for, while, and do-while loops
        /*
        The while and do-while statements continually execute a block of statements while a particular condition is true.
        The difference between do-while and while is that do-while evaluates its expression at the bottom of the loop instead of the top.
        Therefore, the statements within the do block are always executed at least once. The for statement provides a compact way to iterate over a range of values. It has two forms, one of which was designed for looping through collections and arrays.
         */

        // Develop code that uses break and continue (branching statements)
        breakDemo();
        breakWithLabelDemo();
        continueDemo();
        continueWithLabelDemo();

        // ITERATORS TO USE WITH COLLECTIONS IN JAVA

        /*
        LIST interface is the child interface of Collection interface. It inhibits a list type data structure in which we can store the ordered collection of objects. It can have duplicate values.
        List interface is implemented by the classes
        ArrayList,
        LinkedList,
        Vector,
        Stack.

            To instantiate the List interface, we must use :
            List <data-type> list1= new ArrayList();
            List <data-type> list2 = new LinkedList();
            List <data-type> list3 = new Vector();
            List <data-type> list4 = new Stack();
         */


        /*
        The ArrayList class implements the List interface.
        It uses a dynamic array to store the duplicate element of different data types.
        The ArrayList class maintains the insertion order and is non-synchronized.
        The elements stored in the ArrayList class can be randomly accessed.
         */
        List<String> list = new ArrayList<>();
        list.add("Ravi");
        list.add("Vijay");
        list.add("Ravi");
        list.add("Ajay");

        // Traversing list through Iterator
        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println("ArrayList name : " + itr.next());
        }

        /*
        LinkedList implements the Collection interface.
        It uses a doubly linked list internally to store the elements.
        It can store the duplicate elements.
        It maintains the insertion order and is not synchronized.
        In LinkedList, the manipulation is fast because no shifting is required.
         */
        List<String> list1 = new LinkedList<>();
        list1.add("Ravi");
        list1.add("Vijay");
        list1.add("Ravi");
        list1.add("Ajay");

        // Traversing list through Iterator
        Iterator itr1 = list1.iterator();
        while (itr1.hasNext()) {
            System.out.println("LinkedList name : " + itr1.next());
        }

        /*
        Vector uses a dynamic array to store the data elements.
        It is similar to ArrayList. However, It is synchronized and
        contains many methods that are not the part of Collection framework.
         */
        List<String> list2 = new Vector<>(); // "Vector"
        list2.add("Ravi");
        list2.add("Vijay");
        list2.add("Ravi");
        list2.add("Ajay");

        // Traversing list through Iterator
        Iterator itr2 = list2.iterator();
        while (itr2.hasNext()) {
            System.out.println("Vector name : " + itr2.next());
        }

        /*
        The stack is the subclass of Vector.
        It implements the last-in-first-out data structure, i.e., Stack.
        The stack contains all of the methods of Vector class and
        also provides its methods like
        boolean push(),
        boolean peek(),
        boolean push(object o),
        which defines its properties.
         */
        List<String> list3 = new Stack<>(); // "Stack"
        list3.add("Ravi");
        list3.add("Vijay");
        list3.add("Ravi");
        list3.add("Ajay");

        // Traversing list through Iterator
        Iterator itr3 = list3.iterator();
        while (itr3.hasNext()) {
            System.out.println("Stack name : " + itr3.next());
        }

        /*
        QUEUE interface maintains the first-in-first-out order.
        It can be defined as an ordered list that is used to hold the elements
        which are about to be processed.
        There are various classes like
        PriorityQueue,
        Deque,
        ArrayDeque
        which implements the Queue interface.

            Queue interface can be instantiated as:
            Queue<String> q1 = new PriorityQueue();
            Queue<String> q2 = new ArrayDeque();
         */

        /*
        The PriorityQueue class implements the Queue interface.
        It holds the elements or objects which are to be processed
        by their priorities. PriorityQueue doesn't allow null values
        to be stored in the queue.
         */
        Queue<String> queue = new PriorityQueue<>(); // "PriorityQueue"
        queue.add("Ravi");
        queue.add("Vijay");
        queue.add("Ravi");
        queue.add("Ajay");
        System.out.println("head:"+queue.element());
        System.out.println("head:"+queue.peek());
        System.out.println("iterating the queue elements:");

        // Traversing list through Iterator
        Iterator itr4 = queue.iterator();
        while (itr4.hasNext()) {
            System.out.println("PriorityQueue name : " + itr4.next());
        }

        queue.remove(); // removes head, throws exception if queue empty
        queue.poll(); // removes head, NOT throws exception if queue empty, only return null
        System.out.println("after removing two elements:");
        Iterator<String> itr5 = queue.iterator();
        while(itr5.hasNext()){
            System.out.println(itr5.next());
        }

        /*
        Deque interface extends the Queue interface.
        In Deque, we can remove and add the elements from both the side.
        Deque stands for a double-ended queue which enables us to perform
        the operations at both the ends.
         */
        Queue<String> queue1 = new ArrayDeque<>(); // "Queue = ArrayDeque"
        Deque<String> queue2 = new ArrayDeque<>(); // "Deque = ArrayDeque"
        queue1.add("Ravi");
        queue1.add("Vijay");
        queue1.add("Ravi");
        queue1.add("Ajay");

        // Traversing list through Iterator
        Iterator itr6 = queue1.iterator();
        while (itr6.hasNext()) {
            System.out.println("ArrayDeque name : " + itr6.next());
        }

        /*
        SET Interface in Java is present in java.util package.
        It extends the Collection interface.
        It represents the unordered set of elements
        which doesn't allow us to store the duplicate items.
        We can store at most one null value in Set.
        Set is implemented by
        HashSet,
        LinkedHashSet,
        TreeSet.

            Set can be instantiated as:
            Set<data-type> s1 = new HashSet<data-type>();
            Set<data-type> s2 = new LinkedHashSet<data-type>();
            Set<data-type> s3 = new TreeSet<data-type>();
         */

        /*
        HashSet class implements Set Interface.
        It represents the collection that uses a hash table for storage.
        Hashing is used to store the elements in the HashSet.
        It contains unique items.
         */
        Set<String> set = new HashSet<>(); // "HashSet"
        set.add("Ravi");
        set.add("Vijay");
        set.add("Ravi");
        set.add("Ajay");

        // Traversing list through Iterator
        Iterator itr7 = set.iterator();
        while (itr7.hasNext()) {
            System.out.println("HashSet name : " + itr7.next());
        }

        /*
        LinkedHashSet class represents the LinkedList implementation of Set Interface.
        It extends the HashSet class and implements Set interface.
        Like HashSet, It also contains unique elements.
        It maintains the insertion order and permits null elements.
         */
        Set<String> set1 = new HashSet<>(); // "HashSet"
        set1.add("Ravi");
        set1.add("Vijay");
        set1.add("Ravi");
        set1.add("Ajay");

        // Traversing list through Iterator
        Iterator itr8 = set1.iterator();
        while (itr8.hasNext()) {
            System.out.println("Stack name : " + itr8.next());
        }

        /*
        SORTEDSET is the alternate of Set interface that provides a total ordering on its elements.
        The elements of the SortedSet are arranged in the increasing (ascending) order.
        The SortedSet provides the additional methods that inhibit the natural ordering of the elements.

            The SortedSet can be instantiated as:
            SortedSet<data-type> set = new TreeSet();
         */

        /*
        TreeSet class implements the Set interface that uses a tree for storage.
        Like HashSet, TreeSet also contains unique elements.
        However, the access and retrieval time of TreeSet is quite fast.
        The elements in TreeSet stored in ascending order.
         */
        SortedSet <String> set3 = new TreeSet<>(); // "TreeSet"
        set3.add("Ravi");
        set3.add("Vijay");
        set3.add("Ravi");
        set3.add("Ajay");

        // Traversing list through Iterator
        Iterator itr9 = set3.iterator();
        while (itr9.hasNext()) {
            System.out.println("TreeSet name : " + itr9.next());
        }
    }

    private static void forLoopDemo() {
        for (int i=1; i<11; i++) {
            System.out.println("Count is: " + i);
        }
    }

    // warning can't stop if invoke.
    private static void infiniteForLoop() {
        for ( ; ; ) {
            System.out.println("Infinity and beyond");
        }
    }

    private static void enhanceForDemo() {
        int[] numbers =
                {1,2,3,4,5,6,7,8,9,10};
        for (int item : numbers) {
            System.out.println("Count is: " + item);
        }
    }

    private static void whileDemo() {
        int count = 1;
        while (count < 11) {
            System.out.println("Count is: " + count);
            count++;
        }
    }

    private static void doWhileDemo() {
        int count = 1;
        do {
            System.out.println("Count is: " + count);
            count++;
        } while (count < 11);
    }

    // The break statement has two forms: labeled and unlabeled.
    private static void breakDemo() {
        int[] arrayOfInts =
                { 32, 87, 3, 589,
                        12, 1076, 2000,
                        8, 622, 127 };
        int searchfor = 12;

        int i;
        boolean foundIt = false;

        for (i = 0; i < arrayOfInts.length; i++) {
            if (arrayOfInts[i] == searchfor) {
                foundIt = true;
                break;
            }
        }

        if (foundIt) {
            System.out.println("Found " + searchfor + " at index " + i);
        } else {
            System.out.println(searchfor + " not in the array");
        }
    }

    private static void breakWithLabelDemo() {
        int[][] arrayOfInts = {
                { 32, 87, 3, 589 },
                { 12, 1076, 2000, 8 },
                { 622, 127, 77, 955 }
        };
        int searchfor = 12;

        int i;
        int j = 0;
        boolean foundIt = false;

        search: // When the value is found, a labeled break terminates the outer for loop (labeled "search")
        for (i = 0; i < arrayOfInts.length; i++) {
            for (j = 0; j < arrayOfInts[i].length;
                 j++) {
                if (arrayOfInts[i][j] == searchfor) {
                    foundIt = true;
                    break search;
                }
            }
        }

        if (foundIt) { // w/ "search:" it goes here if that goes into "break search;"
            System.out.println("Found " + searchfor + " at " + i + ", " + j);
        } else {
            System.out.println(searchfor + " not in the array");
        }
    }

    // The continue statement skips the current iteration.
    private static void continueDemo() {

        String searchMe = "peter piper picked a " + "peck of pickled peppers";
        int max = searchMe.length();
        int numPs = 0;

        for (int i = 0; i < max; i++) {
            // interested only in p's
            if (searchMe.charAt(i) != 'p')
                continue;

            // process p's
            numPs++;
        }
        System.out.println("Found " + numPs + " p's in the string.");
    }

    private static void continueWithLabelDemo() {
        String searchMe = "Look for a substring in me";
        String substring = "sub";
        boolean foundIt = false;

        int max = searchMe.length() -
                substring.length();

        test: //uses the labeled form of continue to skip an iteration in the outer loop.
        for (int i = 0; i <= max; i++) { // when "continue test;" execute, & w/ "test:" it goes to the outermost loop to skip by passing all inner/nested loop
            int n = substring.length();
            int j = i;
            int k = 0;
            while (n-- != 0) {
                if (searchMe.charAt(j++) != substring.charAt(k++)) {
                    continue test;
                }
            }
            foundIt = true;
            break test;
        }
        System.out.println(foundIt ? "Found it" : "Didn't find it");
    }

    private static int returnValue() {
        return 1;
    }

    private static void returnNoValue() {
        return;
    }
}
