package adp.multithreadingconcurrency.highlevelconcurrencyobjects;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Concurrent Random Numbers:
 *
 * In JDK 7, java.util.concurrent includes a convenience class, ThreadLocalRandom,
 * for applications that expect to use random numbers from multiple threads or ForkJoinTasks.
 *
 * For concurrent access, using ThreadLocalRandom instead of Math.random() results
 * in less contention and, ultimately, better performance.
 *
 * All you need to do is call ThreadLocalRandom.current(),
 * then call one of its methods to retrieve a random number.
 * Here is one example:
 *    int r = ThreadLocalRandom.current() .nextInt(4, 77);
 */
public class ConcurrentRandomNumbers {
    public static void main(String[] args) {
        System.out.println("Display Concurrent Random Numbers: ");
        for (int i = 0; i < 10; i++) {
            System.out.format("# %d - %d%n", i, ThreadLocalRandom.current().nextInt(4, 77));
        }
    }
}
