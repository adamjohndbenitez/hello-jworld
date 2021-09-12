package adp.multithreadingconcurrency.liveliness;

import javax.swing.*;
import java.awt.*;

public class StarvationVsFairness {
    /*
    https://www.logicbig.com/tutorials/core-java-tutorial/java-multi-threading/thread-starvation.html
    In multithreaded application starvation is a situation when a thread is constantly ignored
    to gain possession of the intrinsic lock in favor of other threads.
     */

    /**
     * Starvation is much less common a problem than deadlock,
     * but are still problems that every designer of
     * concurrent software is likely to encounter.
     *
     * Starvation:
     * a situation where a thread is unable to gain regular access to shared resources and is unable to make progress.
     * This happens when shared resources are made unavailable for long periods by "greedy" threads.
     *
     * For example, suppose an object provides a synchronized method that often takes a long time to return.
     * If one thread invokes this method frequently,
     * other threads that also need frequent synchronized access to the same object will often be blocked.
     *
     * Let's understand that with an example.
     * We are going to create 5 threads and display progress of each thread on Swing JProgressBar:
     */
    // PROBLEM:
    static class Starvation {
        private static Object sharedObj = new Object();

        public static void main (String[] args) {
            JFrame frame = createFrame();
            frame.setLayout(new FlowLayout(FlowLayout.LEFT));

            for (int i = 0; i < 5; i++) {
                ProgressThread progressThread = new ProgressThread();
                frame.add(progressThread.getProgressComponent());
                progressThread.start();
            }

            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }

        private static JFrame createFrame () {
            JFrame frame = new JFrame("Starvation Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(new Dimension(300, 200));
            return frame;
        }

        private static class ProgressThread extends Thread {
            JProgressBar progressBar;

            ProgressThread () {
                progressBar = new JProgressBar();
                progressBar.setString(this.getName());
                progressBar.setStringPainted(true);
            }

            JComponent getProgressComponent () {
                return progressBar;
            }

            @Override
            public void run () {

                int c = 0;
                while (true) {
                    synchronized (sharedObj) {
                        if (c == 100) {
                            c = 0;
                        }
                        progressBar.setValue(++c);
                        try {
                            //sleep the thread to simulate long running task
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /**
     * Fairness:
     * is the situation when all threads are given equal opportunity for intrinsic lock acquisition.
     * As we saw in above example that the long running thread has more chances to acquire the lock again consecutively.
     *
     * In general we cannot predict how underlying thread scheduler (built in O.S.) chooses the next thread for the lock acquisition.
     * From developer perspective, the code should not hold the lock for a long time to make a thread greedy.
     * We can fix the above code by using wait() method which releases the lock but goes to waiting state
     * i.e. the scheduler cannot choose it for the lock acquisition again.
     * That way other threads are given the equal opportunity to run.
     */
    // SOLUTION:
    static class FairnessDemo {
        private static Object sharedObj = new Object();

        public static void main (String[] args) {
            JFrame frame = createFrame();
            frame.setLayout(new FlowLayout(FlowLayout.LEFT));

            for (int i = 0; i < 5; i++) {
                ProgressThread progressThread = new ProgressThread();
                frame.add(progressThread.getProgressComponent());
                progressThread.start();
            }

            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }

        private static JFrame createFrame () {
            JFrame frame = new JFrame("Fairness Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(new Dimension(300, 200));
            return frame;
        }

        private static class ProgressThread extends Thread {
            JProgressBar progressBar;

            ProgressThread () {
                progressBar = new JProgressBar();
                progressBar.setString(this.getName());
                progressBar.setStringPainted(true);
            }

            JComponent getProgressComponent () {
                return progressBar;
            }

            @Override
            public void run () {

                int c = 0;
                while (true) {
                    synchronized (sharedObj) {
                        if (c == 100) {
                            c = 0;
                        }
                        progressBar.setValue(++c);
                        try {
                            //simulate long running task with wait..
                            // releasing the lock for long running task gives
                            //fair chances to run other threads
                            sharedObj.wait(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}