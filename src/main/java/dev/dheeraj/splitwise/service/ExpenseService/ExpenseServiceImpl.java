package dev.dheeraj.splitwise.service.ExpenseService;

import dev.dheeraj.splitwise.entity.Expense;
import dev.dheeraj.splitwise.entity.User;
import dev.dheeraj.splitwise.repository.ExpenseRepository;
import dev.dheeraj.splitwise.service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Currency;
@Service
public class ExpenseServiceImpl implements ExpenseService{

    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private UserService userService;

    @Override
    public Expense addExpense(int userId, String description, double amount) {
        Expense expense = new Expense();
        User user = userService.getById(userId);
        Currency c = Currency.getInstance("INR");
        expense.setDescription(description);
        expense.setCurrency(c);
        expense.setAmount(amount);
        expense.setUserExpenses(new ArrayList<>());
        expense.setExpenseTime(LocalDateTime.now());
        expense.setAddedBy(user);
        return expenseRepository.save(expense);
    }
}
