package splitWise.splitExpense;

import splitWise.Expense;
import splitWise.Group;
import splitWise.User;

import java.util.List;
import java.util.Map;

public class MinTransectionNeededSplit implements SplitExpense{


    @Override
    public Map<User, List<Expense>> splitExpense(Group group, List<Expense> newExpenses) {
        return Map.of();
    }
}
