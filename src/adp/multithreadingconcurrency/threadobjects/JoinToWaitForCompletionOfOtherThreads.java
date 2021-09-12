package adp.multithreadingconcurrency.threadobjects;

/**
 * The join method allows one thread to wait for the completion of another.
 * Overloads of join allow the programmer to specify a waiting period.
 * However, as with sleep, join is dependent on the OS for timing,
 * so you should not assume that join will wait exactly as long as you specify.
 *
 * Like sleep, join responds to an interrupt by exiting with an InterruptedException.
 */
public class JoinToWaitForCompletionOfOtherThreads {
//public class JoinToWaitForCompletionOfOtherThreads implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread();
        String[] importantInfo = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };

        for (String s : importantInfo) {
            // If t is a Thread object whose thread is currently executing,
            // causes the current thread to pause execution until t's thread terminates.
            t.join(); // e.g. 2 threads executing: t = executing, t1 = pause execution until t terminates.
            /*
            Suppose there are two threads T1 and T2.
            If a Thread T1 executes T2.join()
            then T1 should go for waiting state until completing T2.
             */
            //Print a message
            System.out.println(s);
        }
    }
//--------------
//    public void run() {
//        Thread t = Thread.currentThread();
//        System.out.println("Current thread: "
//                + t.getName());
//
//        // checks if current thread is alive
//        System.out.println("Is Alive? "
//                + t.isAlive());
//    }
//
//    public static void main(String args[]) throws Exception {
//        Thread t = new Thread(new JoinToWaitForCompletionOfOtherThreads());
//        t.start();
//
//        // Waits for 1000ms this thread to die.
//        t.join(1000);
//        /*
//        e.g. If any executing thread t1 calls join() on t2;
//        t2.join() then immediately t1 will enter into waiting state until t2 completes its execution.
//         */
//
//        System.out.println("\nJoining after 1000"+
//                " milliseconds: \n");
//        System.out.println("Current thread: " +
//                t.getName());
//
//
//        // Checks if this thread is alive
//        System.out.println("Is alive? " + t.isAlive());
//    }

}
/*
Q: Vaguely understand it's concept??? what's the diff btwn sleep vs join. check and see SimpleThreadsExample class.
 */