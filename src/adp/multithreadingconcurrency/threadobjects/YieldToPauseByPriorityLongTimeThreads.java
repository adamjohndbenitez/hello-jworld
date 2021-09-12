package adp.multithreadingconcurrency.threadobjects;

public class YieldToPauseByPriorityLongTimeThreads {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread();
        String[] importantInfo = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };

        for (String s : importantInfo) {
            t.yield();
            /*
            e.g. Suppose there are three threads t1, t2, and t3.
            Thread t1 gets the processor and starts its execution and
            thread t2 and t3 are in Ready/Runnable state.
            Completion time for thread t1 is 5 hour and
            completion time for t2 is 5 minutes.
            Since t1 will complete its execution after 5 hours,
            t2 has to wait for 5 hours to just finish 5 minutes job.

            so Pausing the longer time threads and give way to the
            shorter time threads or same level then after,
            longer time threads will follow.
             */
            //Print a message
            System.out.println(s);
        }
    }
}
