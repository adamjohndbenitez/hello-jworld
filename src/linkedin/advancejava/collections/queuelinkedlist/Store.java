package linkedin.advancejava.collections.queuelinkedlist;

import linkedin.advancejava.CustomerStore;

import java.util.LinkedList;

/**
 * Queues - first in first out data structure. Useful if you are controlling access to shared resources.
 * Ex. CPU scheduling or simulating planes for landing instructions.
 */
public class Store {
    public static void main(String[] args) {
        LinkedList<CustomerStore> queue = new LinkedList<>();
        queue.add(new CustomerStore( "Sally")); // ? Cannot access the CustomerStore Class when put inside 'queuelinkedlist' package.
        queue.add(new CustomerStore("Ben"));
        queue.add(new CustomerStore("Emma"));
        queue.add(new CustomerStore("Fred"));
        // add() method always adds elements to the end of the list - also known as the tail.
        System.out.println(queue); // When print out queue is in the same order that I added it.
        /*
        NOTE: There are a several classes that implements the Queue interface.
        One of these classes is LinkedList.
         */
        serveCustomer(queue);
        System.out.println(queue);
    }

    /**
     * This method behaves like a real customer being served in a real store.
     * When a customer has been served, they should be removed from the queue
     * and it should always be the first person who joins the queue that gets served first.
     * The Queue interface provides us with the method to do this called poll().
     * @param queue
     */
    static void serveCustomer(LinkedList<CustomerStore> queue) {
        CustomerStore c = queue.poll(); // poll() method gets the element from the queue.
        c.serve();
    }
}