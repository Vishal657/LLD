package splitWise;

import java.time.Instant;
import java.util.Date;

public class Transection {

    User borrower;
    User lender;
    double amount;
    Instant timeStamp;

    public Transection(User borrower, User lender, double amount) {
        this.amount = amount;
        this.borrower = borrower;
        this.lender = lender;

        this.timeStamp = Instant.now();
    }

    @Override
    public String toString() {
        return "Transection{" +
                "borrower=" + borrower.getName() +
                ", lender=" + lender.getName() +
                ", amount=" + amount +
                ", date=" + timeStamp +
                '}';
    }

}
