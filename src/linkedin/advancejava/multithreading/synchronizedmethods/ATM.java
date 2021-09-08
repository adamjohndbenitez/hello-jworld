package linkedin.advancejava.multithreading.synchronizedmethods;

public class ATM {
    /**
     * Checks if the amount being withdrawn would take the money in the account over the overdraft limit.
     * If it does, then it prints out a warning message and doesn't remove any money from the account.
     * Otherwise, it debits the account by the amount specified.
     * @param account  account the money is being withdrawn from
     * @param amount   amount to be withdrawn
     */
    static void withdraw(BankAccount account, int amount, String person) {
        System.lineSeparator();
        System.out.println("Person - " + person + " this will expect to be randomly print anywhere");
        int balance = account.getBalance();
        // Check if withdrawing the money from the account will make it overdrawn.
        if ((balance - amount) < - account.getOverdraft()) { // ? < -
            System.out.println("Transaction denied!");
        } else {
            account.debit(amount);
            System.out.println("$" + amount + " successfully withdrawn");
        }
        System.out.println("Current Balance: " + account.getBalance());
    }

    // THE SOLUTION: add synchronized before method signature, before method type to be specific.
    static synchronized void withdrawCorrect(BankAccount account, int amount, String person) {
        System.out.println("\nCorrect Solution with synchronized: ");
        System.out.println("Person - " + person);
        int balance = account.getBalance();
        // Check if withdrawing the money from the account will make it overdrawn.
        if ((balance - amount) < - account.getOverdraft()) { // ? < -
            System.out.println("Transaction denied!");
        } else {
            account.debit(amount);
            System.out.println("$" + amount + " successfully withdrawn");
        }
        System.out.println("Current Balance: " + account.getBalance());
    }

    /*
    So synchronized methods are a simple and effective way to stop threads from interfering
    with object data at the same time.
     */
}
