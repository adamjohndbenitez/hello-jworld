package adp.multithreadingconcurrency.highlevelconcurrencyobjects;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock Objects:
 * Synchronized code relies on a simple kind of reentrant lock.
 * This kind of lock is easy to use, but has many limitations.
 * More sophisticated locking idioms are supported by the java.util.concurrent.locks package.
 * We won't examine this package in detail, but instead will focus on its most basic interface, "Lock".
 *
 * Lock objects work very much like the "implicit locks" used by synchronized code.
 * As with implicit locks, only one thread can own a Lock object at a time.
 * Lock objects also support a "wait/notify mechanism", through their associated Condition objects.
 *
 * The biggest advantage of Lock objects over implicit locks is their
 * (ability to "back out" of an attempt to acquire a lock).
 * The tryLock method backs out if the lock is not available immediately or
 * before a timeout expires (if specified).
 *
 * The lockInterruptibly() method "backs out" if another thread sends an interrupt
 * before the lock is acquired.
 *
 * This class LockObjects is a solution to Deadlock class w/c is a problem.
 *
 * Alphonse and Gaston have trained themselves to notice when a friend is about to bow.
 * We model this improvement by requiring that our Friend objects must acquire locks
 * for both participants before proceeding with the bow.
 *
 * Here is the source code for the improved model, Safelock class.
 * To demonstrate the versatility of this idiom,
 * we assume that Alphonse and Gaston are so infatuated with their
 * newfound ability to bow safely that they can't stop bowing to each other:
 */
public class LockObjects {
    public static class Safelock { // Safelock class is the improved model - by requiring that our Friend objects must acquire locks for both participants before proceeding with the bow.
        static class Friend {
            private final String name;
            private final Lock lock = new ReentrantLock(); // The biggest advantage of Lock objects over implicit locks is their ability to back out of an attempt to acquire a lock.

            public Friend(String name) {
                this.name = name;
            }

            public String getName() {
                return this.name;
            }

            public boolean impendingBow(Friend bower) {
                Boolean myLock = false;
                Boolean yourLock = false;
                try {
                    myLock = lock.tryLock(); // tryLock() method backs out if the lock is not available immediately or before a timeout expires (if specified).
                    yourLock = bower.lock.tryLock();
                } finally {
                    if (! (myLock && yourLock)) { // when both of friends are not lock OR either of one of them is lock.
                        if (myLock) { // the other friend is lock, unlock
                            lock.unlock();
                        }
                        if (yourLock) { // if lock, unlock
                            bower.lock.unlock();
                        }
                    }
                }
                return myLock && yourLock;
            }
            /*
            Test diff btwn conditions !(myLock && yourLock) VS. boolean b2 = true || true;
            boolean myLock = true;
            boolean yourLock = true;
            //boolean b1 = !(myLock && yourLock);
            boolean b2 = true || true;

            // b1 false false = true
            // b2 false false = true

            // b1 true false = true
            // b2 true false = true

            // b1 true true = true
            // b2 true true = false
             */

            public void bow(Friend bower) {
                if (impendingBow(bower)) { // bow() method invoke impending bow() w/c ONLY if both are lock.
                    try {
                        System.out.format("%s: %s has bowed to me!%n", this.name, bower.getName());
                        bower.bowBack(this);
                    } finally {
                        lock.unlock();
                        bower.lock.unlock();
                    }
                } else { // if both friends are unlock OR either one of them are unlock.
                    System.out.format("%s: %s started to bow to me, but saw that I was already bowing to him.%n",
                            this.name, bower.getName());
                }
            }

            public void bowBack(Friend bower) {
                System.out.format("%s: %s has bowed back to me!%n", this.name, bower.getName());
            }
        }

        static class BowLoop implements Runnable {
            private Friend bower;
            private Friend bowee;

            public BowLoop(Friend bower, Friend bowee) {
                this.bower = bower;
                this.bowee = bowee;
            }

            public void run() {
                Random random = new Random();
                for (;;) {
                    try {
                        Thread.sleep(random.nextInt(10));
                    } catch (InterruptedException e) {}
                    bowee.bow(bower);
                }
            }
        }


        public static void main(String[] args) {
            final Friend alphonse = new Friend("Alphonse");
            final Friend gaston = new Friend("Gaston");

            new Thread(new BowLoop(alphonse, gaston)).start();
            new Thread(new BowLoop(gaston, alphonse)).start();
        }
    }
}
