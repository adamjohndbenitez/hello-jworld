package linkedin.advancejava.multithreading;

import linkedin.advancejava.multithreading.runnableinterface.RunnableExample;
import linkedin.advancejava.multithreading.threadclass.ThreadExample;

public class Main {
    public static void main(String[] args) { // actually, main() method when run will start a thread.
        // ThreadExample class
        /*
        Every time you run any Java program, it creattes at least one thread without any code.
        We can demonstrate this by putting print line statement in my Main method then call
        Thread.activeCount()
         */
        System.out.println(Thread.activeCount());

        ThreadExample thread = new ThreadExample();
        thread.setName("My Firrst thread");
        thread.start(); // When I call the start method the thread is said to be alive. it then start the run method for me.
        /*
        When it is finished running the code inside the rrun method, at that point the thread is terminated.
        If I run this code, I can see that it executes the code in my run method and prints out the numbers.
        1 -to- 100 with the name of the thread, the thread name displayed is "thread-0"
        If I wantted to, I could rename it.
         */
        ThreadExample thread1 = new ThreadExample();
        thread1.setName("My Second thread");
        thread1.start();
        /*
        Now when rerun, I can see that both threads are calling the run method at the same time.
        The out put shows that numbers are being printted by my first thread and my second thread.
        So I have a multi-threaded application.
         */

        // RunnableExample class
        Thread thread2 = new Thread(new RunnableExample()); // There is a constructor of a Thread class which takes a rrunnable as argument, so I can pass in a new instance of my RunnableExample class.
        thread2.start();
        // it is not really necessary for me to create a separate class to implement the runnable interface,
        // especially as my implementation is so short and only has one method in it, the run method.

        // I can also create a new instance of Runnable which I will pass in as an argument to the thread constructor.
        // IDE usually auto-completes the rest for me, creating a run method.
        Thread thread3 = new Thread(new Runnable() { // when hover over Runnable, IDE tells me - "Anonymous new Runnable() can be replaced with lambda" - it's cuz Runnable is a functional interface and has a (1) one abstract method, I can replace with Lambda.
            @Override
            public void run() {
                int i = 0;
                while (i <= 100) {
                    System.out.println(i + " " + Thread.currentThread().getName());
                    i++;
                }
            }
        });
        thread3.start();

        // when hover over Runnable, IDE tells me - "Anonymous new Runnable() can be replaced with lambda" - it's cuz Runnable is a functional interface and has a (1) one abstract method, I can replace with Lambda.
        Thread thread4 = new Thread(() -> {
            int i = 0;
            while (i <= 100) {
                System.out.println(i + " " + Thread.currentThread().getName());
                i++;
            }
        });
        thread4.start();
    }
}
