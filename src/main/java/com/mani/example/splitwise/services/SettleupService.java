package com.mani.example.splitwise.services;
import com.mani.example.splitwise.exceptions.UserNotFoundException;
import com.mani.example.splitwise.models.Expense;
import com.mani.example.splitwise.models.ExpenseUser;
import com.mani.example.splitwise.models.User;
import com.mani.example.splitwise.repositories.ExpenseUserRepository;
import com.mani.example.splitwise.repositories.UserRepository;
import com.mani.example.splitwise.strategy.SettleUpStrategy;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SettleupService {
    private UserRepository userRepository;
    private ExpenseUserRepository expenseUserRepository;
    private SettleUpStrategy settleUpStrategy;
    public SettleupService(UserRepository userRepository,ExpenseUserRepository expenseUserRepository,SettleUpStrategy settleUpStrategy) {
        this.userRepository = userRepository;
        this.expenseUserRepository = expenseUserRepository;
        this.settleUpStrategy = settleUpStrategy;
    }
    public List<Expense> settleUpUser(Long userId) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("The User with UserId --> " + userId + " is Not Found");
        }
        User user = optionalUser.get();
        /* fetch all the expenses where this User was present -> expenses table or  expense_users ?
        expenses table will tell only about description amount type but
        expense_users will give all the expenses about user who paid_by and had_to_pay with that will calculte the settleUp*/
        List<ExpenseUser> expenseUsers = expenseUserRepository.findByUser(user);
        Set<Expense> expensesToSettle = new HashSet<>();
        for(ExpenseUser expenseUserItem : expenseUsers){
            expensesToSettle.add(expenseUserItem.getExpense());
        }
        // convert Set of Expenses into List of Expenses using Stream
        List<Expense> transactions = settleUpStrategy.settleUp(expensesToSettle.stream().toList());
        /*  instead of returning all the transactions we should return
           only the transactions where the current user is present */
        List<Expense> transactionsToReturn = new ArrayList<>();
        for(Expense expense : transactions){
            for(ExpenseUser expenseUser : expense.getExpenseUsers()){
                if(expenseUser.getUser().equals(user)){
                    transactionsToReturn.add(expense);
                    break;
                }
            }
        }
        return transactionsToReturn;
    }
    public List<Expense> settleUpGroup(Long groupId) {
        /*
        1.get the group with the given group id
        2.get all expenses
        3.call the settleUp Strategy to settleUp all the expenses
         */
        return null;
    }
}