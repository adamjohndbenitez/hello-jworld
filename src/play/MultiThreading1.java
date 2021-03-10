package play;

/**
 * Multithreading is a Java feature that allows concurrent execution of two or more parts of a program
 * for maximum utilization of CPU. Each part of such program is called a thread.
 * So, threads are light-weight processes within a process.
 *
 * Thread creation by extending the Thread class. A thread begins its life inside run() method.
 *
 * We create a class that extends the java.lang.Thread class.
 * This class overrides the run() method available in the Thread class.
 *
 * @author Adam John Benitez
 */
public class MultiThreading1 extends Thread {

    /**
     * Method with number of threads. We create an object of our new class and call start() method
     * to start the execution of a thread. start() invokes the run() method on the Thread object.
     *
     * @param threads
     */
    public void numberOfThreads(int threads) {
        System.out.println("Displaying the thread is running: ");
        for (int i = 0; i < threads; i++) {
            // We create an object of our new class and call start() method to start the execution of a thread
            MultiThreading1 multithreading = new MultiThreading1();
            // start() invokes the run() method on the Thread object
            multithreading.start();
        }
    }

    /**
     * This class overrides the run() method available in the Thread class.
     * A thread begins its life inside run() method.
     */
    public void run() {
        try {
            // Displaying the thread is running
            System.out.println("Thread " + Thread.currentThread().getId() + " is running");
        } catch (Exception e) {
            // Throwing an exception
            System.out.println(e);
        }
    }
}