package adp.multithreadingconcurrency;

/**
 * An interrupt is an indication to a thread that it should stop what it is doing and do something else.
 * it is very common for the thread "to terminate".
 *
 */
public class InterruptToStopToTerminate {
    public static void main(String[] args) throws InterruptedException {
        String[] importantInfo = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };

        /*
        Supporting Interruption:
        If the thread is frequently invoking methods that throw InterruptedException,
        it simply returns from the run method after it catches that exception.
         */
        for (int i = 0; i < importantInfo.length; i++) {
            try {
                // Pause for 4 seconds
                Thread.sleep(4000); // Many methods that throw InterruptedException, such as sleep, are designed to cancel their current operation and return immediately when an interrupt is received.

                /*
                The Interrupt Status Flag: mechanism is implemented using an internal flag known as the "interrupt status".
                Invoking Thread.interrupt() sets this flag. When a thread checks for an interrupt by invoking the
                static method Thread.interrupted(), interrupt status is cleared. The non-static isInterrupted method,
                which is used by one thread to query the interrupt status of another, does not change the interrupt status flag.

                What if a thread goes a long time without invoking a method that throws InterruptedException?
                Then "it must periodically invoke Thread.interrupted", which returns true if an interrupt has been received.
                That is why it's better to throw InterruptedException cuz it will periodically invoke Thread.interrupted,

                NOTE: By convention, any method that exits by throwing an InterruptedException clears interrupt status
                when it does so. However, it's always possible that interrupt status will immediately be set again,
                by another thread invoking interrupt.
                 */
                if (Thread.interrupted()) {
                    throw new InterruptedException(); // In more complex applications, it might make more sense to throw an InterruptedException. This allows interrupt handling code to be centralized in a catch clause.
//                    return; // We've been interrupted: no more crunching.
                }
            } catch (InterruptedException e) {
                return; // We've been interrupted: no more messages.
            }
            // Print a message
            System.out.println(importantInfo[i]);
        }
    }
}
