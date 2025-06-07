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
        StringBuilder sb = new StringBuilder();
        sb.append("Contributions{fixedContributions=");

        fixedContributions.forEach((user, amount) ->
                sb.append(user.getName()).append(": ").append(amount).append(", ")
        );

        // Remove trailing comma and space if present
        if (!fixedContributions.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }

        sb.append(", createdBy=").append(createdBy.getName());
        sb.append(", timeStamp=").append(timeStamp);
        sb.append('}');
        return sb.toString();
    }

}
