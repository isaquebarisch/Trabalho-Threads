package Bank;

import java.util.Date;

public class Transaction {
    private final String type;
    private final int amount;
    private final Date date;

    public Transaction(String type, int amount, Date date) {
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    @Override
    public String toString() {
        return date + ": " + type + " of amount " + amount;
    }
}
