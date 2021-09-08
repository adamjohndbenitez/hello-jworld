package linkedin.advancejava.collections.linkedlists;

import java.util.LinkedList;

/**
 * A linked list is a doubly linked collection of elements.
 * Each entry in the listt also holds a reference to the address of the next and previous item.
 * The main advantage of using a linked list is that they are very quick and removing elements in the middle of list.
 *
 */
public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> myList = new LinkedList<>();
        myList.add("A");
        myList.add("B");
        // Insert a string in a specific location in the list.
        myList.add(1, "C");
        System.out.println(myList);
        // Remove string in list
        myList.remove("B");
        System.out.println(myList);

        /*
        NOTE: There are similarities about LinkedList and ArrayList cuz they implement List interface.
        However, there are obvious diff when dealing with huge amount of elements.
        If I want to insert a lot of elements in the middle of list or remove from the middle -
        LinkedList is much more faster.
        On the otherhand,
        If I want to get a lot of elements from the list, then an array list would be much faster.

        NOTE: LinkedLists als take up more memory than ArrayLists.
        cuz in LinkedList list each entry contains a reference to elements in tthe list and also to the next and previous elements.

        For most cases, if you have to choose array list and linked list, the better choice is array list.
        In doubt, if you know that you will need to add or remove - better to use LinkedList.
         */
    }
}
