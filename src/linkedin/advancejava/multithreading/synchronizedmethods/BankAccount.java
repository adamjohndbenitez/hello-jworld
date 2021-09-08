package linkedin.advancejava.multithreading.synchronizedmethods;

/**
 *
 */
public class BankAccount {
    private int bal = 0; // Balance represents the amount of money in the account.
    private final int overdraft; // Overdraft represents the overdraft limit.

    public BankAccount(int overdraft) { // Constructor take number for the overdraft as an argument.
        this.overdraft = overdraft;
    }

    void topUp(int amount) {
        bal += amount;
    }

    void debit(int amount) {
        bal -= amount;
    }

    int getBalance() {
        return this.bal;
    }

    int getOverdraft() {
        return this.overdraft;
    }
}
