package linkedin.advancejava.multithreading.synchronizedmethods;

/**
 * This class has an account with an overdraft limit of $50.
 * In the main method of the class,
 */
public class Users {
    static final BankAccount acc = new BankAccount(50);
    static final BankAccount acc1 = new BankAccount(50);

    // Program that simulates withdrawing money from a bank account.
    public static void main(String[] args) {
        acc.topUp(100); // They have $100 in their account and an overdraft of $50. so they can spend upto $150 without being overdrawn.
        acc1.topUp(100);

        /*
        Assuming that in this account I can have two cards associated with it.
        So there could be a scenario where two people try to
        withdraw money from the accountt at exactly the same time.
        To represent this situation, I have two threads running at the same time.
         */

        // 1st thread, someone goes to an ATM tries to withdraw $100.
        Thread thr = new Thread(() -> {
            ATM.withdraw(acc,100, "1");
        });

        // 2nd thread, and also 2nd person tries to withdraw $100.
        Thread thr1 = new Thread(() -> {
            ATM.withdraw(acc,100, "2");
        });

        thr.start();
        thr1.start();
        /*
        THE PROBLEM: There is no knowing which order the threads will execute the lines in the method in,
        so sometimes it may work perfectly fine, but sometimes, like this time, it doesn't.
        This may seem like a complex problem to solve. but it's actually very simple.

        1st test-run:
        $100 successfully withdrawn
        Current Balance: -100
        $100 successfully withdrawn
        Current Balance: -100

        2nd test-run:
        $100 successfully withdrawn
        Current Balance: 0
        Transaction denied!
        Current Balance: 0

        <p>

        THE SOLUTION: All I have to do is add the synchronized keyword to the signature of the ATM.withdraw() method
        right before the return type. This means that now only one thread can enter this method at a time.

        so what happens is, first thread enters the method, get the balance, which will be $100, then withdraw $100.
        so the balance is now $0.
        second thread can only enter the method, when the first thread has finished. so when it calls the getBalance method,
        it will be $0.
        Withdrawing $100 would take it over the $50 overdraft limit, so tthe transaction will be denied.
        If I rerun the program, I can now see tthat it works as intended.
         */

        Thread thr2 = new Thread(() -> {
            ATM.withdrawCorrect(acc1,100, "1");
        });
        Thread thr3 = new Thread(() -> {
            ATM.withdrawCorrect(acc1,100, "2");
        });
        thr2.start();
        thr3.start();
    }
}
