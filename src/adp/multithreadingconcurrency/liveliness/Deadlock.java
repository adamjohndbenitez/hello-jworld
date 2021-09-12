package adp.multithreadingconcurrency.liveliness;

/**
 * Deadlock describes a situation where two or more threads are blocked forever, waiting for each other.
 *
 * Suppose Alphonse and Gaston are friends, and great believers in courtesy.
 * A strict rule of courtesy is that when you bow to a friend,
 * you must remain bowed until your friend has a chance to return the bow.
 * Unfortunately, this rule does not account for the possibility that
 * two friends might (bow to each other at the same time).
 * This example application, Deadlock, models this possibility:
 *
 * --Simulation--
 * Correct:
 *  - alphonse bows and waiting for gaston to bows back, then gaston bows back, can stop bowing and stand straight.
 *  - gaston bows and waiting for alphonse to bows back, then gaston bows back, can stop bowing and stand straight.
 * Deadlock:
 *  - alphonse and gaston bows at same time and both are waiting for each other to bows back forever.
 */
public class Deadlock {
    static class Friend {
        private final String name;

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s" + "  has bowed to me!%n", this.name, bower.getName());
            bower.bowBack(this); // this class Friend
            /*
            When Deadlock runs, it's extremely likely that both threads will block
            when they attempt to invoke bowBack. Neither block will ever end,
            because each thread is waiting for the other to exit bow.
             */
        }

        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s" + " has bowed back to me!%n", this.name, bower.getName());
        }
    }

    public static void main(String[] args) {
        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston = new Friend("Gaston");

//        new Thread(new Runnable() {
//            public void run() { alphonse.bow(gaston); }
//        }).start();
        // Replaced with lambda expression.
        new Thread(() -> alphonse.bow(gaston)).start();

//        new Thread(new Runnable() {
//            public void run() { gaston.bow(alphonse); }
//        }).start();
        // Replaced with lambda expression.
        new Thread(() -> gaston.bow(alphonse)).start();
    }
}
