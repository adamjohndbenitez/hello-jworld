package adp.multithreadingconcurrency.highlevelconcurrencyobjects.executors;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Executor Interfaces: define the three executor object types.
 * The java.util.concurrent package defines (3) three executor interfaces:
 *
 * 1. Executor, a simple interface that supports launching new tasks.
 * 2. ExecutorService, a subinterface of Executor,
 *    which adds features that help manage the life cycle,
 *    both of the individual tasks and of the executor itself.
 * 3. ScheduledExecutorService, a subinterface of ExecutorService,
 *    supports future and/or periodic execution of tasks.
 *
 * Typically, variables that refer to executor objects are declared
 * as "one of these three interface types", not with an executor class type.
 *
 *
 */
public class ExecutorInterfaces {
    public static void main(String[] args) {
        // https://www.tabnine.com/code/java/methods/java.util.concurrent.ExecutorService/%3Cinit%3E
        Executor e = Executors.newSingleThreadExecutor(); // For single thread execution
        Executor e1 = Executors.newCachedThreadPool(); // For cached
        Executor e2 = Executors.newFixedThreadPool(3); // For specific number of threads.

        RunnableExample r = new RunnableExample();
        /*
        The Executor interface provides a single method, execute, designed to be a drop-in replacement for a common thread-creation idiom. If r is a Runnable object, and e is an Executor object you can replace
            (new Thread(r)).start();
        with
            e.execute(r);
         */
        (new Thread(r)).start();
        e.execute(r);
        /*
        However, the definition of execute is less specific.
        The low-level idiom creates a new thread and launches it immediately.
        Depending on the Executor Interface implementation, execute() method may do the same thing,
        but is more likely to use an existing worker thread to run r,
        or to place r in a queue to wait for a worker thread to become available.
        (We'll describe worker threads in the section on Thread Pools.)
         */

        /*
        The executor implementations in (java.util.concurrent.*) are designed to make full use of the
        more advanced "ExecutorService" and "ScheduledExecutorService" interfaces,
        although they also work with the base Executor interface.
         */

        ExecutorService es1 = Executors.newSingleThreadExecutor();
        ExecutorService es = Executors.newCachedThreadPool();
        ExecutorService es2 = Executors.newFixedThreadPool(3);

        /*
        The ExecutorService Interface:
        supplements execute with a similar, but more versatile submit method.
        Like execute, submit accepts Runnable objects, but also accepts Callable objects,
        which allow the task to return a value.

        The submit() method returns a Future object,
        which is used to retrieve the Callable return value and
        to manage the status of both Callable and Runnable tasks.
         */
        es1.submit(new RunnableExample());

        /*
        ExecutorService also provides methods for submitting large collections of Callable objects.
        Finally, ExecutorService provides a number of methods for managing the shutdown of the executor.
        To support immediate shutdown, tasks should handle interrupts correctly.
         */

        // ----

        /*
        The ScheduledExecutorService Interface:
        supplements the methods of its parent ExecutorService with schedule,
        which executes a Runnable or Callable task after a specified delay.
        In addition, the interface defines
         - scheduleAtFixedRate()
         - scheduleWithFixedDelay()
        which executes specified tasks repeatedly, at defined intervals.
         */
        ScheduledExecutorService schedExecServ = Executors.newSingleThreadScheduledExecutor();
        ScheduledExecutorService schedExecServ1 = Executors.newScheduledThreadPool(2);

        schedExecServ.scheduleAtFixedRate(r, 1, 1, TimeUnit.MILLISECONDS);
        schedExecServ.scheduleWithFixedDelay(r, 1, 1, TimeUnit.MILLISECONDS);
    }

    public static class RunnableExample implements Runnable {

        @Override
        public void run() {
            int i = 0;
            while (i <= 100) {
                System.out.println(i + " " + Thread.currentThread().getName());
                i++;
            }
        }
    }
}
