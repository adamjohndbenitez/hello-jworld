package adp.multithreadingconcurrency.highlevelconcurrencyobjects.concurrentcollections;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Source: https://www.geeksforgeeks.org/concurrenthashmap-in-java/
 *
 *
 */
public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        System.out.println("--CONCURRENTHASHMAP DEMO--");
        simpleConcurrentHashMapDemo();
        System.lineSeparator();

        System.out.println("--ADDING ELEMENTS TO CONCURRENTHASHMAP DEMO--");
        AddingElementsToConcuurentHashMap();
        System.lineSeparator();

        System.out.println("--ACCESSING ELEMENTS OF CONCURRENTHASHMAP DEMO--");
        accessingElementsOfConcurrentHashMap();
        System.lineSeparator();

        System.out.println("--TRAVERSING CONCURRENTHASHMAP DEMO--");
        traversingConcurrentHashMap();
        System.lineSeparator();
    }

    private static void simpleConcurrentHashMapDemo() {
        // create an instance of
        // ConcurrentHashMap
        ConcurrentHashMap<Integer, String> m
                = new ConcurrentHashMap<>();

        // Insert mappings using
        // put method
        m.put(100, "Hello");
        m.put(101, "Geeks");
        m.put(102, "Geeks");

        // Here we cant add Hello because 101 key
        // is already present in ConcurrentHashMap object
        m.putIfAbsent(101, "Hello");

        // We can remove entry because 101 key
        // is associated with For value
        m.remove(101, "Geeks");

        // Now we can add Hello
        m.putIfAbsent(103, "Hello");

        // We cant replace Hello with For
        m.replace(101, "Hello", "For");
        System.out.println(m);
    }

    private static void AddingElementsToConcuurentHashMap() {
        // Creating ConcurrentHashMap
        ConcurrentHashMap<String, String> my_cmmap
                = new ConcurrentHashMap<String, String>();

        // Adding elements to the map
        // using put() method
        my_cmmap.put("1", "1");
        my_cmmap.put("2", "1");
        my_cmmap.put("3", "1");
        my_cmmap.put("4", "1");
        my_cmmap.put("5", "1");
        my_cmmap.put("6", "1");

        // Printing the map
        System.out.println("Mappings of my_cmmap : "
                + my_cmmap);

        // create another concurrentHashMap
        ConcurrentHashMap<String, String> new_chm
                = new ConcurrentHashMap<>();

        // copy mappings from my_cmmap to new_chm
        new_chm.putAll(my_cmmap);

        // Displaying the new map
        System.out.println("New mappings are: " + new_chm);
    }

    private static void accessingElementsOfConcurrentHashMap() {
        // Creating ConcurrentHashMap
        Map<String, String> my_cmmap
                = new ConcurrentHashMap<String, String>();

        // Adding elements to the map
        // using put() method
        my_cmmap.put("1", "1");
        my_cmmap.put("2", "1");
        my_cmmap.put("3", "1");
        my_cmmap.put("4", "1");
        my_cmmap.put("5", "1");
        my_cmmap.put("6", "1");

        // Printing the map
        System.out.println("Map: " + my_cmmap);
        System.out.println();

        // Removing the mapping
        // with existing key 6
        // using remove() method
        String valueRemoved = my_cmmap.remove("6");

        // Printing the map after remove()
        System.out.println(
                "After removing mapping with key 6:");
        System.out.println("Map: " + my_cmmap);
        System.out.println("Value removed: "
                + valueRemoved);
        System.out.println();

        // Removing the mapping
        // with non-existing key 10
        // using remove() method
        valueRemoved = my_cmmap.remove("10");

        // Printing the map after remove()
        System.out.println(
                "After removing mapping with key 10:");
        System.out.println("Map: " + my_cmmap);
        System.out.println("Value removed: "
                + valueRemoved);
        System.out.println();

        // Now clear the map using clear()
        my_cmmap.clear();

        // Print the clea Map
        System.out.println("Map after use of clear(): "
                + my_cmmap);
    }

    private static void traversingConcurrentHashMap() {
        // create an instance of ConcurrentHashMap
        ConcurrentHashMap<Integer, String> chmap
                = new ConcurrentHashMap<Integer, String>();

        // Add elements using put()
        chmap.put(8, "Third");
        chmap.put(6, "Second");
        chmap.put(3, "First");
        chmap.put(11, "Fourth");

        // Create an Iterator over the
        // ConcurrentHashMap
        Iterator<ConcurrentHashMap.Entry<Integer, String> >
                itr = chmap.entrySet().iterator();

        // The hasNext() method is used to check if there is
        // a next element The next() method is used to
        // retrieve the next element
        while (itr.hasNext()) {
            ConcurrentHashMap.Entry<Integer, String> entry
                    = itr.next();
            System.out.println("Key = " + entry.getKey()
                    + ", Value = "
                    + entry.getValue());
        }
    }
}
