package adp.multithreadingconcurrency.synchronization;

/**
 * When "Threads communicate" by "sharing access"
 * PROBLEM=> (1) thread interference & (2) memory consistency errors
 */
public class ThreadInterferenceAndMemoryConsistencyErrors {
    public class Counter {
        private int c = 0;

        public void increment() {
            c++;
        }

        public void decrement() {
            c--;
        }

        public int value() {
            return c;
        }
    }
    /*
    Thread Interference describes how errors are introduced when multiple threads access shared data.
    e.g. Assume a Counter object is referenced from multiple threads,
    interference between threads may prevent this from happening as expected.

    Interference happens when two operations, running in different threads,
    but acting on the same data, "interleave". This means that the two operations
    consist of multiple steps, and the sequences of steps "overlap".

    Suppose Thread A invokes increment at about the same time Thread B invokes decrement.
    If the initial value of c is 0, their interleaved actions might follow this sequence:

    Thread A: Retrieve c.
    Thread B: Retrieve c.
    Thread A: Increment retrieved value; result is 1.
    Thread B: Decrement retrieved value; result is -1.
    Thread A: Store result in c; c is now 1.
    Thread B: Store result in c; c is now -1.

    Thread A's result is lost, overwritten by Thread B.
    This particular interleaving is only one possibility.
    Under different circumstances it might be Thread B's result that gets lost, or
    there could be no error at all. Because they are unpredictable,
    thread interference bugs can be difficult to detect and fix.
     */

    /*
    Memory Consistency Errors describes errors that result from inconsistent views of shared memory.
    All that is needed is a strategy for avoiding them.

    The key to avoiding memory consistency errors is understanding the "happens-before relationship".
    This relationship is simply a guarantee that memory writes by
    "one specific statement" are visible to "another specific statement".

    Suppose a simple int field is defined and initialized:
        int counter = 0;

    The counter field is shared between two threads, A and B. Suppose thread A increments counter:
        counter++;

    Then, shortly afterwards, thread B prints out counter:
        System.out.println(counter);

    Suppose If the two statements had been executed in the same thread,
    it would be safe to assume that the value printed out would be "1".
    But if the two statements are executed in separate threads,
    the value printed out might well be "0",
    because there's no guarantee that thread A's change
    to counter will be visible to thread B
    — unless the programmer has established a happens-before relationship between these two statements.

    There are several actions that create happens-before relationships.
    One of them is synchronization, as we will see in the following sections.
    (1) When a statement invokes Thread.start(), every statement that has a happens-before relationship
        with that statement also has a happens-before relationship with every statement executed by the new thread.
        The effects of the code that led up to the creation of the new thread are visible to the new thread.
    (2) When a thread terminates and causes a Thread.join() in another thread to return,
        then all the statements executed by the terminated thread have a happens-before relationship
        with all the statements following the successful join.
        The effects of the code in the thread are now visible to the thread that performed the join.
     */

    // --SUMMARY--

    // Thread Interference:
    // -> threads access shared data
    // -> interleave == overlap
    // -> lost, overwritten

    // Memory Consistency Errors:
    // -> inconsistent views of shared memory
    // -> "happens-before relationship"
    // -> "one specific statement" are visible to "another specific statement".
    // -> invokes Thread.start(), creation of the new thread are visible to the new thread
    // -> thread terminates and causes a Thread.join() in another thread to return,
    //     thread are now visible to the thread that performed the join
}