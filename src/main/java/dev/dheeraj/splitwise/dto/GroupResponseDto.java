package dev.dheeraj.splitwise.dto;

import dev.dheeraj.splitwise.entity.Expense;
import dev.dheeraj.splitwise.entity.SettlementTransaction;
import dev.dheeraj.splitwise.entity.User;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class GroupResponseDto {
    private String name;

    private User createdBy;

    private double totalAmountSpent;

    private List<User> members;

    private List<Expense> expenses;
}
