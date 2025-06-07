package splitWise;

import java.util.UUID;

public class Expense {

    private String expenseId;
    public User borrower;
    public User lender;
    public double amount;

    public Expense(User borrower, User lender, double amount) {
        expenseId = UUID.randomUUID().toString();

        this.borrower = borrower;
        this.lender = lender;
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        return expenseId.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Expense other = (Expense) obj;
        return expenseId.equals(other.expenseId);
    }

    @Override
    public String toString() {
        return String.format("Expense[id=%s, borrower=%s, lender=%s, amount=%.2f]",
                expenseId, borrower.getName(), lender.getName(), amount);
    }

}