package Bank;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final Map<Integer, Account> accounts = new HashMap<>();

    public void addAccount(int accountId, int initialBalance) {
        accounts.put(accountId, new Account(initialBalance));
    }

    public Account getAccount(int accountId) {
        return accounts.get(accountId);
    }
}
