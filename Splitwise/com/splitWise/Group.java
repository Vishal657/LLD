package splitWise;

import splitWise.splitExpense.SplitExpense;

import java.util.*;

public class Group {

    private String groupId;
    List<User> users;
    Map<User, List<Expense>> userExpenses;
    SplitExpense splitExpense;

    private List<Contributions> contributionTransections;
    private List<Transection> userTransections;

    public Group(SplitExpense splitExpense) {
        this.splitExpense = splitExpense;

        users = new ArrayList<>();
        userExpenses = new HashMap<>();
        contributionTransections = new ArrayList<>();
        userTransections = new ArrayList<>();

        groupId = UUID.randomUUID().toString();
    }

    public String getGroupId() {
        return groupId;
    }

    public synchronized void addUser(User user) {
        if (user != null && users.stream().noneMatch((u) -> u.equals(user))) {
            users.add(user);
            user.addGroup(this);
        } else {
            System.out.println("User already present!!");
        }
    }

    // In reality these methods will be called by UI
    // So UI will convert things into fixed values and will call the backend
    public synchronized void addExpense(User createdBy, Map<User, Double> fixedContributions) {
        List<Expense> newExpenses = new ArrayList<>();
        for (User user : fixedContributions.keySet()) {
            if (createdBy != null && !createdBy.equals(user) && fixedContributions.get(user) != null) {
                newExpenses.add(new Expense(user, createdBy, fixedContributions.get(user)));
            }
        }
        userExpenses = splitExpense.splitExpense(this, newExpenses);
        contributionTransections.add(new Contributions(fixedContributions, createdBy));
    }

    public List<User> getAllUsers() {
        return users;
    }

    public List<Expense> getUserExpenses(User user) {
        return userExpenses.get(user);
    }

    public List<Expense> getUserReceivables(User user) {
        List<Expense> receivables = new ArrayList<>();
        for(User key: userExpenses.keySet()) {
            if(!key.equals(user)) {
                for(Expense expense: userExpenses.get(key)) {
                    if(expense.lender.equals(user)) {
                        receivables.add(expense);
                    }
                }
            }
        }
        return receivables;
    }

    public synchronized void sattleExpense(Expense expense) {
        List<Expense> borrowerExpenses = userExpenses.get(expense.borrower);
        if (borrowerExpenses != null) {
            List<Expense> newBorrowerExpenses = borrowerExpenses.stream().filter((ex) -> ex.equals(expense)).toList();
            userExpenses.put(expense.borrower, newBorrowerExpenses);
            userTransections.add(new Transection(expense.borrower, expense.lender, expense.amount));
        }
    }

    public void printGroupTransections() {
        int ci = 0, ui = 0;

        while (ci < contributionTransections.size() && ui < userTransections.size()) {
            Contributions contributions = contributionTransections.get(ci);
            Transection userTransection = userTransections.get(ui);
            int compareRes = contributions.timeStamp.compareTo(userTransection.timeStamp);
            if (compareRes < 0) {
                System.out.println(contributions);
                ci++;
            } else {
                System.out.println(userTransection);
                ui++;
            }
        }

        while (ci < contributionTransections.size()) {
            System.out.println(contributionTransections.get(ci++));
        }

        while (ui < userTransections.size()) {
            System.out.println(userTransections.get(ui++));
        }

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(groupId, group.groupId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(groupId);
    }
}
