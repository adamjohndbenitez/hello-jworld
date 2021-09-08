package linkedin.advancejava.multithreading.avoiddeadlock;

/**
 * The deadlock can occur when two or more threats get blocked forever.
 * This can happen when (2) two threads are waiting for resources held by each other.
 *
 */
public class Kitchen {
    public static Object spoon = new Object();
    public static Object bowl = new Object();

    public static void main(String[] args) {
        /*
        In this example, I am simulating a situatin with (2) cooks in a kitchen.
        Imagine if both cooks wanted to mix some ingredients.
        so they both need a spoon and a bowl.
        However, there is only (1) spoon and (1) bowl.
        The first cook picks up the spoon and at the same time,
        the second cook picks up the bowl.
        Now both cooks are waiting for the other one
        to put down their object so they can pick it up.
        This is a deadlock.
         */
        Thread cook = new Thread(() -> {
            synchronized (spoon) {
                System.out.println("Cook1: Holding the spoon...");
                System.out.println("Cook1: Waiting for the bowl...");

                synchronized (bowl) {
                    System.out.println("Cook1: Holding the spoon and the bowl...");
                }
            }
        });

        Thread cook1 = new Thread(() -> {
            synchronized (bowl) {
                System.out.println("Cook2: Holding the spoon...");
                System.out.println("Cook2: Waiting for the bowl...");

                synchronized (spoon) {
                    System.out.println("Cook2: Holding the spoon and the bowl...");
                }
            }
        });
        /*
        To simulate this, Kitchen class, (2) two objects spoon and bowl.
        which represent the (2) two cooks.
        A synchronized block or synchronized statement is a section
        of codes that only one thread can enter at a time.
        This means that you can have a synchronized code
        inside a non synchronized method.
        The objects in brrackets is kknown as a monitor object -
        synchronized (spoon) {...
        synchronized (bowl) {...
        And this means that if a thread is inside the synchronized block
        no other thread can do anything with that object.
        The (1st) first tthread, cook one,
        has a synchronized block with a spoon as the monitor object.
        it then tries to enter a second synchronized block
        with bowl as the monitor object.
        When it does start the thread has both the spoon and the bowl.
        The (2nd) second thread, cook two, does exactly the same
        except it uses the bowl as the monitor lock firstt
        and the spoon second.
        And then cause start on both of the threads.
        so that they run at the same time.

         */
        cook.start();
        cook1.start();

        /* when rerun - the program don't stop.
        Cook1: Holding the spoon...
        Cook1: Waiting for the bowl...
        Cook1: Holding the spoon...
        Cook1: Waiting for the bowl...

        What happends is that the thread called cook one.
        has entered the synchronized block
        with the spoon as the monitor objectt.

        At the same time, cook two has locked the bowl object.
        So now cook one has the spoon and is waiting for the bowl object to be free.
        But cook two has the bowl object and is waiting for the spoon object to be free.
        So both threads will be waiting forever.

        The program is still running so that is now in deadlock state.
        stop running the program.

        This is a situation when people caught up when they start using threads.
        How to fic this depends on the situation and the context.
        In general it is better to avoid nested blocks of synchronized code like this.
         */


    }
}
