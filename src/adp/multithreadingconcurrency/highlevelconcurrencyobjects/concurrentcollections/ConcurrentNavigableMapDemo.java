package adp.multithreadingconcurrency.highlevelconcurrencyobjects.concurrentcollections;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * https://www.geeksforgeeks.org/concurrentnavigablemap-interface-in-java/
 */
public class ConcurrentNavigableMapDemo {
    public static void main(String[] args) {
        System.out.println("--DEMONSTRATE THE CONCURRENTNAVIGABLEMAP--");
        demonstrateTheConcurrentNavigableMap();
        System.lineSeparator();

        System.out.println("--DEMONSTRATE THE CONCURRENTSKIPLISTMAP--");
        demonstrateTheConcurrentSkipListMap();
        System.lineSeparator();

        System.out.println("--ADD ELEMENTS TO A CONCURRENTNAVIGABLEMAP--");
        addElementsToAConcurrentNavigableMap();
        System.lineSeparator();

        System.out.println("--REMOVE ELEMENTS TO A CONCURRENTNAVIGABLEMAP--");
        removeElementsToAConcurrentNavigableMap();
        System.lineSeparator();

        System.out.println("--ACCESS THE ELEMENTS OF A CONCURRENTNAVIGABLEMAP--");
        accessTheElementsOfAConcurrentNavigableMap();
        System.lineSeparator();

        System.out.println("--TRAVERSE OVER THE ELEMENTS OF THE CONCURRENTNAVIGABLEMAP--");
        traverseOverTheElementsOfTheConcurrentNavigableMap();
        System.lineSeparator();


    }

    private static void demonstrateTheConcurrentNavigableMap() {
        // Instantiate an object
        // Since ConcurrentNavigableMap
        // is an interface so We use
        // ConcurrentSkipListMap
        ConcurrentNavigableMap<Integer, String> cnmap = new ConcurrentSkipListMap<>();


        // Add elements using put() method
        cnmap.put(1, "First");
        cnmap.put(2, "Second");
        cnmap.put(3, "Third");
        cnmap.put(4, "Fourth");

        // Print the contents on the console
        System.out.println(
                "Mappings of ConcurrentNavigableMap : "
                        + cnmap);

        System.out.println("HeadMap(3): "
                + cnmap.headMap(3));
        System.out.println("TailMap(3): "
                + cnmap.tailMap(3));
        System.out.println("SubMap(1, 3): "
                + cnmap.subMap(1, 3));
    }

    /**
     * The ConcurrentNavigableMap has one implementing class which is ConcurrentSkipListMap class.
     * The ConcurrentSkipListMap is a scalable implementation of the ConcurrentNavigableMap interface.
     * The keys in ConcurrentSkipListMap are sorted by natural order or by using a Comparator at the time
     * of construction of the object. The ConcurrentSkipListMap has the expected time cost of log(n)
     * for insertion, deletion, and searching operations. It is a thread-safe class, therefore,
     * all basic operations can be accomplished concurrently.
     */
    private static void demonstrateTheConcurrentSkipListMap() {
        // Instantiate an object of
        // ConcurrentSkipListMap named cslmap
        ConcurrentSkipListMap<Integer, String> cslmap
                = new ConcurrentSkipListMap<Integer, String>();

        // Add elements using put()
        cslmap.put(1, "Geeks");
        cslmap.put(2, "For");
        cslmap.put(3, "Geeks");

        // Print the contents on the console
        System.out.println(
                "The ConcurrentSkipListMap contains: "
                        + cslmap);

        // Print the key set using keySet()
        System.out.println(
                "\nThe ConcurrentSkipListMap key set: "
                        + cslmap.keySet());

        // Remove elements using remove()
        cslmap.remove(3);

        // Print the contents on the console
        System.out.println(
                "\nThe ConcurrentSkipListMap contains: "
                        + cslmap);
    }

    /**
     * To add elements to a ConcurrentNavigableMap we can use any methods of the Map interface.
     * The code below shows how to use them.
     * You can observe in the code that when no Comparator is provided at the time of construction,
     * the natural order is followed.
     */
    private static void addElementsToAConcurrentNavigableMap() {
        // Instantiate an object
        // Since ConcurrentNavigableMap is an interface
        // We use ConcurrentSkipListMap
        ConcurrentNavigableMap<Integer, String> cnmap
                = new ConcurrentSkipListMap<Integer, String>();

        // Add elements using put()
        cnmap.put(8, "Third");
        cnmap.put(6, "Second");
        cnmap.put(3, "First");

        // Print the contents on the console
        System.out.println(
                "Mappings of ConcurrentNavigableMap : "
                        + cnmap);
    }

    /**
     * To remove elements as well we use methods of the Map interface,
     * as ConcurrentNavigableMap is a descendent of Map.
     */
    private static void removeElementsToAConcurrentNavigableMap() {
        // Instantiate an object
        // Since ConcurrentNavigableMap
        // is an interface
        // We use ConcurrentSkipListMap
        ConcurrentNavigableMap<Integer, String> cnmap
                = new ConcurrentSkipListMap<Integer, String>();

        // Add elements using put()
        cnmap.put(8, "Third");
        cnmap.put(6, "Second");
        cnmap.put(3, "First");
        cnmap.put(11, "Fourth");

        // Print the contents on the console
        System.out.println(
                "Mappings of ConcurrentNavigableMap : "
                        + cnmap);

        // Remove elements using remove()
        cnmap.remove(6);
        cnmap.remove(8);

        // Print the contents on the console
        System.out.println(
                "\nConcurrentNavigableMap, after remove operation : "
                        + cnmap);

        // Clear the entire map using clear()
        cnmap.clear();
        System.out.println(
                "\nConcurrentNavigableMap, after clear operation : "
                        + cnmap);
    }

    /**
     * We can access the elements of a ConcurrentNavigableMap using get() method,
     * the example of this is given below.
     */
    private static void accessTheElementsOfAConcurrentNavigableMap() {
        // Instantiate an object
        // Since ConcurrentNavigableMap is an interface
        // We use ConcurrentSkipListMap
        ConcurrentNavigableMap<Integer, String> cnmap
                = new ConcurrentSkipListMap<Integer, String>();

        // Add elements using put()
        cnmap.put(8, "Third");
        cnmap.put(6, "Second");
        cnmap.put(3, "First");
        cnmap.put(11, "Fourth");

        // Accessing the elements using get()
        // with key as a parameter
        System.out.println(cnmap.get(3));
        System.out.println(cnmap.get(6));
        System.out.println(cnmap.get(8));
        System.out.println(cnmap.get(11));

        // Display the set of keys using keySet()
        System.out.println(
                "\nThe ConcurrentNavigableMap key set: "
                        + cnmap.keySet());
    }

    /**
     * We can use the Iterator interface to traverse over any structure of the Collection Framework.
     * Since Iterators work with one type of data we use .Entry< ? , ? >
     * to resolve the two separate types into a compatible format.
     * Then using the next() method we print the elements of the ConcurrentNavigableMap.
     */
    private static void traverseOverTheElementsOfTheConcurrentNavigableMap() {
        // Instantiate an object
        // Since ConcurrentNavigableMap is an interface
        // We use ConcurrentSkipListMap
        ConcurrentNavigableMap<Integer, String> cnmap
                = new ConcurrentSkipListMap<Integer, String>();

        // Add elements using put()
        cnmap.put(8, "Third");
        cnmap.put(6, "Second");
        cnmap.put(3, "First");
        cnmap.put(11, "Fourth");

        // Create an Iterator over the
        // ConcurrentNavigableMap

        // The hasNext() method is used to check if there is
        // a next element The next() method is used to
        // retrieve the next element
        for (ConcurrentNavigableMap.Entry<Integer, String> entry : cnmap.entrySet()) {
            System.out.println("Key = " + entry.getKey()
                    + ", Value = "
                    + entry.getValue());
        }
    }
}
