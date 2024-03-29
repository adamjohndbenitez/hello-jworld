package adp.multithreadingconcurrency.highlevelconcurrencyobjects;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariables {

    class Counter {
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
    One way to make Counter safe from thread interference is to make
    its methods synchronized, as in SynchronizedCounter:
     */
    class SynchronizedCounter {
        private int c = 0;

        public synchronized void increment() {
            c++;
        }

        public synchronized void decrement() {
            c--;
        }

        public synchronized int value() {
            return c;
        }

    }

    /*
    The java.util.concurrent.atomic package defines classes that support atomic operations on single variables.
        e.g. java.util.concurrent.atomic.AtomicInteger

    All classes have get and set methods that work like reads and writes on volatile variables.
        class AtomicInteger ... {
           private volatile int value;
           public final int get() {
               return value;
           }
        }

    That is, a set has a happens-before relationship with any subsequent get on the same variable.
    The atomic compareAndSet() method also has these memory consistency features,
        class AtomicInteger ... {
            public final boolean compareAndSet(int expect, int update) {
                return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
            }
        }

    as do the simple atomic arithmetic methods that apply to integer atomic variables.
     */
    class AtomicCounter {
        /*
        For this simple class, synchronization is an acceptable solution.
        But for a more complicated class, we might want to avoid the liveness
        impact of unnecessary synchronization. Replacing the int field with
        an AtomicInteger allows us to prevent thread interference without resorting
        to synchronization, as in AtomicCounter:
         */
        private AtomicInteger c = new AtomicInteger(0);

        public void increment() {
            c.incrementAndGet();
        }

        public void decrement() {
            c.decrementAndGet();
        }

        public int value() {
            return c.get();
        }

    }
}
