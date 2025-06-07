package splitWise;

import java.time.Instant;
import java.util.Date;
import java.util.Map;

public class Contributions {

    Map<User, Double> fixedContributions;
    User createdBy;
    Instant timeStamp;

    public Contributions(Map<User, Double> fixedContributions, User createdBy) {
        this.fixedContributions = fixedContributions;
        this.createdBy = createdBy;
        this.timeStamp = Instant.now();
    }

    @Override
    public String toString() {
        return "Contributions{" +
                "fixedContributions=" + fixedContributions +
                ", createdBy=" + createdBy.getName() +
                ", timeStamp=" + timeStamp +
                '}';
    }

}
