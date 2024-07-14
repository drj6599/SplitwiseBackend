package dev.dheeraj.splitwise.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ExpenseResponseDto {
    private String description;
    private double amount;
    private LocalDateTime expenseTime;
}
