package splitWise;

import splitWise.splitExpense.MinTransectionNeededSplit;
import splitWise.splitExpense.SimpleSplit;

import java.util.*;

public class SplitWise {

    Set<User> users;
    List<Group> groups;

    SplitWise() {
        users = new HashSet<>();
        groups = new ArrayList<>();
    }

    User addUser(String name, String email) throws Exception {
        User user = new User(name, email);
        if (users.contains(user)) {
            throw new Exception("User already present");
        }
        users.add(user);
        return user;
    }

    Group createGroup(User user) {
        Group group = new Group(new SimpleSplit());
        group.addUser(user);
        groups.add(group);
        return group;
    }

    public static void main(String[] args) throws Exception {
        SplitWise splitWise = new SplitWise();
        User userA = splitWise.addUser("A", "A@gamil.com");
        User userB = splitWise.addUser("B", "B@gamil.com");

        Group party = splitWise.createGroup(userA);
        party.addUser(userB);

        party.addExpense(userA, Map.of(userB, 20.0));
        System.out.println(userB.getAllExpenses());

        party.addExpense(userB, Map.of(userA, 10.0));
        System.out.println(userB.getAllExpenses());
        System.out.println(userA.getAllExpenses());

        List<Expense> expenses = party.getUserExpenses(userB);
        party.settleExpense(expenses.get(0));

        party.printGroupTransections();
    }

}
