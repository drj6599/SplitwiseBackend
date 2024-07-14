package dev.dheeraj.splitwise.service.ExpenseService;

import dev.dheeraj.splitwise.entity.Expense;

public interface ExpenseService {
    Expense addExpense(int userId, String description, double amount);
}
