package linkedin.advancejava.collections.hashmap;

import java.util.HashMap;

/**
 * HashMaps are common data structure. They allow you to store pairs of values together.
 * One example use for a HashMap is a PhoneBook - I could create a HashMap where the contacts
 * was the key, and the phone number was the value.
 */
public class HashMapExample {
    public static void main(String[] args) {
        HashMap<String, Integer> phonebook = new HashMap<>();
        phonebook.put("Kevin", 12345);
        phonebook.put("Jill", 98765);
        phonebook.put("Brenda", 123123);
        phonebook.put("Brenda", 222222); // Once we add same key, it will overwrite the previous value to the new value.
        phonebook.put(null, 000); // Once we add same key, it will overwrite the previous value to the new value.
        System.out.println(phonebook); // HashMaps also allow you to have null as the value for a key.
        /*
        NOTE: HashMaps are unordered, Entries are stored by their contents, not by their position.
        And another feature from HashMaps is they don't allow duplicate keys.

        This is useful because in a phone book it would be confusing to have multiple entries with the same name.
        The fact that hashmaps do not allow this to happen means I couldn't accidentally end up with two people called Brenda
        with different phone numbers in my phone book.
         */

        // We can also search for a key (name of contact) then delete this entry from the HashMap.
        if (phonebook.containsKey("Brenda")) {
            phonebook.remove("Brenda");
        }
        System.out.println(phonebook);

        // To remove all entries from the phonebook, just invoke clear()
        phonebook.clear();
        System.out.println(phonebook);
    }
}
