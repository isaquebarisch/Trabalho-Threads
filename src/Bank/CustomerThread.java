package Bank;

public class CustomerThread extends Thread {
    private final Bank bank;
    private final int accountId;

    public CustomerThread(Bank bank, int accountId) {
        this.bank = bank;
        this.accountId = accountId;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Account account = bank.getAccount(accountId);
            int transactionType = (int) (Math.random() * 2);
            int amount = (int) (Math.random() * 100) + 1;

            if (transactionType == 0) {
                account.deposit(amount);
                System.out.println("Deposited " + amount + " to account " + accountId);
            } else {
                account.withdraw(amount);
                System.out.println("Withdrew " + amount + " from account " + accountId);
            }

            try {
                Thread.sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
