package dev.dheeraj.splitwise.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserExpenseDto {
    private int userId;
    private String description;
    private double amount;
}
