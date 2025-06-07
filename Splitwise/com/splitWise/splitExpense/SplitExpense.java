package splitWise.splitExpense;

import splitWise.Expense;
import splitWise.Group;
import splitWise.User;

import java.util.List;
import java.util.Map;

public interface SplitExpense {

    Map<User, List<Expense>> splitExpense(Group group, List<Expense> newExpenses);

}
