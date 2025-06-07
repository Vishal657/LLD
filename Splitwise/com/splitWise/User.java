package splitWise;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class User {

    String name;
    String email;
    List<Group> groups;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        groups=new ArrayList<>();
    }

    // this will not be called by ui, Ui can only add people in groups
    void addGroup(Group group) {
        if (group != null && groups.stream().noneMatch((g) -> g.equals(group))) {
            groups.add(group);
        } else {
            System.out.println("User already present in given group!!");
        }
    }

    List<Expense> getAllExpenses() {
        List<Expense> expenses = new ArrayList<>();
        for (Group group: groups) {
            expenses.addAll(group.getUserExpenses(this));
        }
        return expenses;
    }

    List<Expense> getAllReceivables() {
        List<Expense> receivables = new ArrayList<>();
        for (Group group: groups) {
            receivables.addAll(group.getUserReceivables(this));
        }
        return receivables;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }
}
