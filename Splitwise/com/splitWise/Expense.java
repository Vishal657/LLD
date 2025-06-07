package splitWise;

import java.util.UUID;

public class Expense {

    private String expenseId;
    User borrower;
    User lender;
    double amount;

    Expense(User borrower, User lender, double amount) {
        expenseId = UUID.randomUUID().toString();
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
}