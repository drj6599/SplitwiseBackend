package dev.dheeraj.splitwise.controller;

import dev.dheeraj.splitwise.dto.UserExpenseDto;
import dev.dheeraj.splitwise.entity.Expense;
import dev.dheeraj.splitwise.mapper.EntityDTOManager;
import dev.dheeraj.splitwise.service.ExpenseService.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping("addExpense")
    public ResponseEntity addExpense(@RequestBody UserExpenseDto expense) {
        Expense newExpense = expenseService.addExpense(expense.getUserId(),expense.getDescription(),expense.getAmount());
        return ResponseEntity.ok(EntityDTOManager.toExpenseResponseDto(newExpense));
    }
}
