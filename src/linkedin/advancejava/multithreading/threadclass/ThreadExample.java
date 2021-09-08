package linkedin.advancejava.multithreading.threadclass;

/**
 * There arer (2) two ways to use threads in java.
 * (1) is to use a class that extends the thread class.
 * In this example, I have a class called ThreadExample.
 * which extends the Thread class.
 */
public class ThreadExample extends Thread {
    @Override
    public void run() {
        int i = 1;
        while (i <= 100) {
            System.out.println(i + " " + this.getName());
            i++;
        }
    }
}
