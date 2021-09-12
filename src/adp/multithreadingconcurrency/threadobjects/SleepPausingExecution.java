package adp.multithreadingconcurrency.threadobjects;

/**
 * Thread.sleep causes the current thread to suspend execution for a specified period.
 * This is an efficient means of making processor time available to the other threads of an application
 * or other applications that might be running on a computer system.
 * The sleep method can also be used for pacing, as shown in the example that follows,
 * and waiting for another thread with duties that are understood to have time requirements.
 *
 * (2) Two overloaded versions of sleep are provided specifies the sleep time into:
 * 1 - millisecond
 * 2 - nanosecond
 *
 *
 */
public class SleepPausingExecution {
    /*
    Notice that main() method declares that it throws InterruptedException.
    This is an exception that sleep throws when another thread interrupts the current thread
    while sleep is active. Since this application has not defined another thread to cause the interrupt,
    it doesn't bother to catch InterruptedException.
     */
    public static void main(String[] args) throws InterruptedException {
        String[] importantInfo = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };

        for (String s : importantInfo) {
            //Pause for 4 seconds
            Thread.sleep(4000);
            //Print a message
            System.out.println(s);
        }
    }
}
