package linkedin.advancejava.collections.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * if your using a normal hashmap, there is no guarantee that you can get the entries back.
 * in the same order that you put them in check - HashMapExample class.
 * <p>
 * However, when you use LinkedHashMap the order of the entries is retained.
 *
 */
public class LinkedHashMapExample {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> phonebook = new LinkedHashMap<>();
        phonebook.put("Kevin", 12345);
        phonebook.put("Jill", 98765);
        phonebook.put("Brenda", 123123);
        phonebook.put("Gary", 222222);
        System.out.println("Kevin's number: " + phonebook.get("Kevin"));

        System.out.println("\nList of contacts in phonebook: ");
        for (Map.Entry<String, Integer> entry : phonebook.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        /*
        NOTE: With LinkedHashMaps, if you want the elements to be retrieved
        in the order that they were added in, or in the order that they have been accessed in.
        To choose between these options, I need to alter the constructor I used when I created
        the LinkedHashMap, in the first line of the main method.

        At the moment, I don't pass any arguments to the constructor -
        new LinkedHashMap<>();
        but I can use a difference constructor, that takes (3) three arguments -
        new LinkedHashMap<>(4, 0.75f, false);
        1st argument: initial capacity of the map itself, ex. pass in 4 a linked hashmap with four entries will be created.
        2nd argument: is called the Load Factor, this specifies how full the map can be before it is made bigger,
                      ex. pass in .75f which actually the default value. This means when the map is 75% full
                      it will increase in size. In this case, I have specified that tthe capacity is 4 so
                      when there are 3 entries in the map i.e. it is 75% full, the map will get bigger.
        3rd argument: (optional) could use the same constructor with a normal HashMap, but with a linked HashMap, there is a third argument.
                      This is a Boolean Value, which specifies the ordering mode. I will set it to false.
                      If it is false, or not specified it will use the insertion order - this returns the elements in the orrder
                      that they were inserted into the map. However, if true instead of false, then it will use access order instead.
                      so the entry that ws modified the longest time ago is at the top and the most recent at the bottom.
                      so linked HashMaps arre different than normal HashMaps, in that tthey keep track of the order of entries.
                      They are also flexible, in that you have the choice of accessing elements by when they were added or when they were modified,
         */
        LinkedHashMap<String, Integer> phonebook1 = new LinkedHashMap<>(4, 0.75f, true);
        phonebook1.put("Kevin", 12345);
        phonebook1.put("Jill", 98765);
        phonebook1.put("Brenda", 123123);
        phonebook1.put("Gary", 222222);
        System.out.println("Kevin's number: " + phonebook1.get("Kevin"));

        System.out.println("\nList of contacts in phonebook with capacity, loadfactor and accessOrder: ");
        for (Map.Entry<String, Integer> entry : phonebook1.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
