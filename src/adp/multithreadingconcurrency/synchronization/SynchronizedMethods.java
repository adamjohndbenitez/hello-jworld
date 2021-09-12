package adp.multithreadingconcurrency.synchronization;

/**
 * (2) two basic synchronization idioms: synchronized methods and synchronized statements.
 *
 * Synchronized methods enable a simple strategy for preventing thread interference and memory consistency errors:
 * if an object is visible to more than one thread, all reads or writes to that object's variables are done through synchronized methods.
 *
 * (An important exception: final fields, which cannot be modified after the object is constructed,
 * can be safely read through non-synchronized methods, once the object is constructed)
 *
 * This strategy is effective, but can present problems with "liveness".
 */
public class SynchronizedMethods {
    public class SynchronizedCounter {
        private int count = 0;
        /**
         *  If count is an instance of SynchronizedCounter,
         *  then making these methods synchronized has two effects:
         *  1. First, it is not possible for two invocations of synchronized methods on the same object
         *     to interleave. When one thread is executing a synchronized method for an object,
         *     all other threads that invoke synchronized methods for the same object block (suspend execution)
         *     until the first thread is done with the object.
         *  2. Second, when a synchronized method exits, it automatically establishes a happens-before relationship
         *     with any subsequent invocation of a synchronized method for the same object.
         *     This guarantees that changes to the state of the object are visible to all threads.
         */
        public synchronized void increment() {
            count++;
        }

        public synchronized void decrement() {
            count--;
        }

        public synchronized int value() {
            return count;
        }
    }

    /*
    NOTE: that constructors cannot be synchronized — using the synchronized keyword with a constructor
          is a syntax error. Synchronizing constructors doesn't make sense,
          because only the thread that creates an object should have access to it while it is being constructed.

    WARNING: When constructing an object that will be shared between threads,
             be very careful that a reference to the object does not "leak" prematurely.

             For example, suppose you want to maintain a List called instances
             containing every instance of class.
             You might be tempted to add the following line to your constructor:
                 instances.add(this);
             But then other threads can use instances to access the object
             before construction of the object is complete.
     */
}
