package Bank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
    private int balance;
    private final List<Transaction> transactions = new ArrayList<>();

    public Account(int initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
        transactions.add(new Transaction("Deposit", amount, new Date()));
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            transactions.add(new Transaction("Withdrawal", amount, new Date()));
        } else {
            System.out.println("Insufficient funds for withdrawal");
        }
    }

    public synchronized int getBalance() {
        return balance;
    }

    public synchronized List<Transaction> getTransactionHistory() {
        return new ArrayList<>(transactions);
    }
}
