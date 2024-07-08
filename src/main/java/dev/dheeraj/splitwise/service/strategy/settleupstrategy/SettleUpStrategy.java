package dev.dheeraj.splitwise.service.strategy.settleupstrategy;

import dev.dheeraj.splitwise.entity.Expense;
import dev.dheeraj.splitwise.entity.SettlementTransaction;

import java.util.List;

public interface SettleUpStrategy {
    List<SettlementTransaction> getSettlementTransactions(List<Expense> expenses);
}
