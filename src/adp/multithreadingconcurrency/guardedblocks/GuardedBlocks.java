package adp.multithreadingconcurrency.guardedblocks;

/**
 * Guarded Blocks:
 * Threads often have to coordinate their actions.
 * The most common coordination idiom is the guarded block.
 * Such a block begins by polling a condition that must be true before the block can proceed.
 * There are a number of steps to follow in order to do this correctly.
 */
public class GuardedBlocks {
    private boolean joy;

    /*
    Suppose, for example guardedJoy is a method that must not proceed until a shared variable joy
    has been set by another thread. Such a method could, in theory, simply loop until the condition
    is satisfied, but that loop is wasteful, since it executes continuously while waiting.
     */
    // PROBLEM:
    public void guardedJoy() {
        // Simple loop guard. Wastes
        // processor time. Don't do this!
        while(!joy) {}
        System.out.println("Joy has been achieved!");
    }

    /**
     * A more efficient guard invokes "Object.wait()" to suspend the current thread.
     * The invocation of wait does not return until another thread has issued a notification
     * that some special event may have occurred — though not necessarily the event
     * this thread is waiting for:
     *
     * Why is this version of guardedJoy synchronized?
     * Suppose d is the object we're using to invoke wait.
     * When a thread invokes d.wait(), it must own the intrinsic
     * lock for d — otherwise an error is thrown.
     * Invoking wait inside a synchronized method
     * is a simple way to acquire the intrinsic lock.
     */
    // SOLUTION:
    public synchronized void guardedJoy1() {
        // This guard only loops once for each special event, which may not
        // be the event we're waiting for.
        while(!joy) {
            try {
                wait(); // Invoking Object.wait() inside a synchronized method is a simple way to acquire the intrinsic lock.
            } catch (InterruptedException e) {}
        }
        System.out.println("Joy and efficiency have been achieved!");
    }
    /*
    NOTE: Always invoke wait inside a loop that tests for the condition being waited for.
          Don't assume that the interrupt was for the particular condition you were waiting for,
          or that the condition is still true.
     */

    /**
     * When wait is invoked, the thread releases the lock and suspends execution.
     * At some future time, another thread will acquire the same lock and invoke Object.notifyAll(),
     * informing all threads waiting on that lock that something important has happened:
     */
    public synchronized void notifyJoy2() {
        joy = true;
        notifyAll();
    }
    /*
    NOTE: There is a second notification method, notify, which wakes up a single thread.
          Because notify doesn't allow you to specify the thread that is woken up,
          it is useful only in massively parallel applications — that is,
          programs with a large number of threads, all doing similar chores.
          In such an application, you don't care which thread gets woken up.
     */
}
