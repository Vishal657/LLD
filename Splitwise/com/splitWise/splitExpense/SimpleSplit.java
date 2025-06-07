package splitWise.splitExpense;

import splitWise.Expense;
import splitWise.Group;
import splitWise.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SimpleSplit implements SplitExpense {


    @Override
    public Map<User, List<Expense>> splitExpense(Group group, List<Expense> newExpenses) {
        if (newExpenses == null || newExpenses.isEmpty()) {
            return group.userExpenses;
        }
        Map<User, List<Expense>> expenses = group.userExpenses;
        User lander = newExpenses.get(0).lender;

        List<Expense> landerExpenses = group.getUserExpenses(lander);

        for (Expense expense : newExpenses) {
            User borrower = expense.borrower;
            Optional<Expense> landerExpenseToBorrowerOptional = landerExpenses.stream().filter((e) -> e.lender.equals(borrower)).findFirst();
            if(landerExpenseToBorrowerOptional.isPresent()) {
                Expense landerExpenseToBorrower = landerExpenseToBorrowerOptional.get();
                if (landerExpenseToBorrower.amount > expense.amount) {
                    landerExpenseToBorrower.amount = landerExpenseToBorrower.amount - expense.amount;
                } else if (landerExpenseToBorrower.amount == expense.amount){
                    group.removeExpense(landerExpenseToBorrower);
                } else {
                    List<Expense> expenses1 = expenses.getOrDefault(borrower, new ArrayList<>());
                    Expense newExpense = new Expense(borrower, lander, landerExpenseToBorrower.amount - expense.amount);
                    expenses1.add(newExpense);
                    expenses.put(borrower, newExpenses);

                    group.removeExpense(landerExpenseToBorrower);
                }
            } else {
                List<Expense> expenses1 = expenses.getOrDefault(borrower, new ArrayList<>());
                Expense newExpense = new Expense(borrower, lander, expense.amount);
                expenses1.add(newExpense);
                expenses.put(borrower, newExpenses);
            }
        }

        return expenses;
    }
}