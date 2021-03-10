package play;

/**
 * Thread creation by implementing the Runnable Interface
 * We create a new class which implements java.lang.Runnable interface and override run() method.
 * Then we instantiate a Thread object and call start() method on this object.
 *
 * @author Adam John Benitez
 */
public class MultiThreading2 implements Runnable {

    public void numberOfThreads(int threads) {
        System.out.println("Displaying the thread is running: ");
        for (int i = 0; i < threads; i++) {
            // we instantiate a Thread object and call start() method on this object.
            Thread thread = new Thread(new MultiThreading2());
            // call start() method on this object.
            thread.start();
        }
    }

    public void run() {
        try {
            // Displaying the thread that is running
            System.out.println ("Thread " + Thread.currentThread().getId() + " is running");
        }
        catch (Exception e)
        {
            // Throwing an exception
            System.out.println ("Exception is caught");
        }
    }
}
