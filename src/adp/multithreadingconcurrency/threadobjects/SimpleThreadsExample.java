package adp.multithreadingconcurrency.threadobjects;

/**
 * The following example brings together some of the concepts of this section.
 * SimpleThreads consists of two threads. (1) first - main thread, (2) second - MessageLoop thread.
 * The first is the main thread that every Java application has.
 *
 * The main thread creates a new thread from the Runnable object, MessageLoop, and waits for it to finish.
 *
 * If the MessageLoop thread takes too long to finish, the main thread interrupts it.
 *
 * The MessageLoop thread prints out a series of messages.
 * If interrupted before it has printed all its messages,
 * the MessageLoop thread prints a message and exits.
 */
public class SimpleThreadsExample {
    // Display a message, preceded by
    // the name of the current thread
    static void threadMessage(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.format("%s: %s%n", threadName, message);
    }

    private static class MessageLoop implements Runnable {
        public void run() {
            String importantInfo[] = {
                    "Mares eat oats",
                    "Does eat oats",
                    "Little lambs eat ivy",
                    "A kid will eat ivy too"
            };
            try {
                for (int i = 0; i < importantInfo.length; i++) {
                    // Pause for 4 seconds
                    Thread.sleep(4000);
                    // Print a message
                    threadMessage(importantInfo[i]);
                }
            } catch (InterruptedException e) {
                threadMessage("I wasn't done!");
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {
        args = new String[]{"50"}; // increased "100" the patience to wait. "1" will tired of waiting.
        // Delay, in milliseconds before
        // we interrupt MessageLoop
        // thread (default one hour).
        long patience = 1000 * 60 * 60; // Q? 1hr, 60min, 60sec ?

        // If command line argument
        // present, gives patience
        // in seconds.
        if (args.length > 0) {
            try {
                patience = Long.parseLong(args[0]) * 1000;
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer.");
                System.exit(1);
            }
        }

        threadMessage("Starting MessageLoop thread");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop()); // t is second - MessageLoop thread.
        t.start();

        threadMessage("Waiting for MessageLoop thread to finish");
        // loop until MessageLoop
        // thread exits
        while (t.isAlive()) {
            threadMessage("Still waiting...");
            // Wait maximum of 1 second
            // for MessageLoop thread
            // to finish.
            t.join(1000);
            if (((System.currentTimeMillis() - startTime) > patience)
                    && t.isAlive()) {
                threadMessage("Tired of waiting!");
                t.interrupt(); // After this, invoke MessageLoop.run(), then displays "I wasn't done!"
                // Shouldn't be long now
                // -- wait indefinitely
                t.join();
            }
        }
        threadMessage("Finally!");
    }
}

/*
TEST #1: test with small amount of patience.
args = new String[]{"1"};
CONSOLE:
    main: Starting MessageLoop thread
    main: Waiting for MessageLoop thread to finish
    main: Still waiting...
    main: Tired of waiting!
    Thread-0: I wasn't done!
    main: Finally!

TEST #2: test with huge amount of patience.
args = new String[]{"50"};
CONSOLE:
    main: Starting MessageLoop thread
    main: Waiting for MessageLoop thread to finish
    main: Still waiting...
    main: Still waiting...
    main: Still waiting...
    main: Still waiting...
    Thread-0: Mares eat oats
    main: Still waiting...
    main: Still waiting...
    main: Still waiting...
    main: Still waiting...
    Thread-0: Does eat oats
    main: Still waiting...
    main: Still waiting...
    main: Still waiting...
    main: Still waiting...
    Thread-0: Little lambs eat ivy
    main: Still waiting...
    main: Still waiting...
    main: Still waiting...
    main: Still waiting...
    Thread-0: A kid will eat ivy too
    main: Finally!
 */
