package jfjca.chapter3;

class Account {
   String accountNumber;
   static int numberOfAccounts;
}

class AccountTest1 {
    public static void main(String[] args) {
        Account acct1 = new Account();
        acct1.accountNumber = "A1";
        Account.numberOfAccounts = Account.numberOfAccounts + 1;
        System.out.println("accountNumber: " + acct1);
        System.out.println("numberOfAccount: " + Account.numberOfAccounts);
        Account acct2 = new Account();
        acct2.accountNumber = "A2";
        Account.numberOfAccounts = Account.numberOfAccounts + 1;
    System.out.println("accountNumber: " + acct2);
    System.out.println("numberOfAccount: " + Account.numberOfAccounts);
    
    }
}