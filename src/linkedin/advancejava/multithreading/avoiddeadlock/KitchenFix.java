package linkedin.advancejava.multithreading.avoiddeadlock;

/**
 * Fix but not recommended, best to avoid, but if there are scenarios force to have a deadlock structure.
 * Maybe we can use this FIX! But consult and code review with others.
 */
public class KitchenFix {
    public static Object spoon = new Object();
    public static Object bowl = new Object();

    public static void main(String[] args) {
        Thread cook = new Thread(() -> {
            synchronized (spoon) {
                System.out.println("Cook1: Holding the spoon...");
                System.out.println("Cook1: Waiting for the bowl...");

                synchronized (bowl) {
                    System.out.println("Cook1: Holding the spoon and the bowl...");
                }
            }
        });

        /*
        one way to fix it is to make both cooks try and pick up the same object first.
        So I will make the second cook pick up the spoon. and then the bowl
         */
        Thread cook1 = new Thread(() -> {
//            synchronized (bowl) { // #1 - Fix it is to make both cooks try and pick up the same object first.
            synchronized (spoon) {
                System.out.println("Cook2: Holding the spoon...");
                System.out.println("Cook2: Waiting for the bowl...");

//                synchronized (spoon) { // #2 - make both cooks try and pick up the bowl.
                synchronized (bowl) {
                    System.out.println("Cook2: Holding the spoon and the bowl...");
                }
            }
        });

        cook.start();
        cook1.start();

        /*
        Now, when re run the program, both cooks end up holding both items one after another.

        Unsure but For me,  I think in reality, Both cooks are using same bowl but the other waits until the other finish.
        then when other pick up and try spoon the other waits until it finish.

        In this way, both cooks synchronized in using items
         */
    }
}
