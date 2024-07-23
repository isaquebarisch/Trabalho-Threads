import Bank.Account;
import Bank.Bank;
import Bank.CustomerThread;
import Bank.Transaction;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        for (int i = 0; i < 5; i++) {
            bank.addAccount(i, 2500);
        }

        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new CustomerThread(bank, i % 5);
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 5; i++) {
            Account account = bank.getAccount(i);
            System.out.println("Account " + i + " balance: " + account.getBalance());
            for (Transaction transaction : account.getTransactionHistory()) {
                System.out.println(transaction);
            }
        }
    }
}
