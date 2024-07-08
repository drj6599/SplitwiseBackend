package dev.dheeraj.splitwise.service.strategy.settleupstrategy;

import dev.dheeraj.splitwise.dto.UserAmount;
import dev.dheeraj.splitwise.entity.Expense;
import dev.dheeraj.splitwise.entity.SettlementTransaction;
import dev.dheeraj.splitwise.entity.User;
import dev.dheeraj.splitwise.entity.UserExpense;
import dev.dheeraj.splitwise.entity.constant.UserExpenseType;

import java.util.*;

public class MinimumTransactionSettleUpStrategy implements SettleUpStrategy{
    @Override
    public List<SettlementTransaction> getSettlementTransactions(List<Expense> expenses) {
        HashMap<User,Double> outstandingBalances = getOutstandingBalances(expenses);

        Comparator<UserAmount> minHeapComparator = Comparator.comparingDouble(UserAmount::getAmount);
        Comparator<UserAmount> maxHeapComparator = Comparator.comparingDouble(UserAmount::getAmount).reversed();

        PriorityQueue<UserAmount> minHeap = new PriorityQueue<>(minHeapComparator);
        PriorityQueue<UserAmount> maxHeap = new PriorityQueue<>(maxHeapComparator);

        for(Map.Entry<User,Double> entry : outstandingBalances.entrySet()){
            if(entry.getValue() > 0){
                maxHeap.add(new UserAmount(entry.getKey(),entry.getValue()));
            } else if(entry.getValue() < 0){
                minHeap.add(new UserAmount(entry.getKey(),entry.getValue()));
            }else{
                System.out.println(entry.getKey() + " does not need to participate in settle up.");
            }
        }

        List<SettlementTransaction> settlementTransactions = new ArrayList<>();

        while(!minHeap.isEmpty() && !maxHeap.isEmpty()){
            UserAmount borrower = minHeap.poll();
            UserAmount lendor = maxHeap.poll();

            if(Math.abs(borrower.getAmount()) > lendor.getAmount()){
                borrower.setAmount(borrower.getAmount()+ lendor.getAmount());
                minHeap.add(borrower);
                SettlementTransaction settlementTransaction = new SettlementTransaction(borrower.getUser(),lendor.getUser(), lendor.getAmount());
                settlementTransactions.add(settlementTransaction);
            }else if(Math.abs(borrower.getAmount()) < lendor.getAmount()){
                lendor.setAmount(lendor.getAmount() + borrower.getAmount());
                maxHeap.add(lendor);
                SettlementTransaction settlementTransaction = new SettlementTransaction(borrower.getUser(), lendor.getUser(), Math.abs(borrower.getAmount()));
                settlementTransactions.add(settlementTransaction);
            }else{
                SettlementTransaction settlementTransaction = new SettlementTransaction(borrower.getUser(), lendor.getUser(), lendor.getAmount());
                settlementTransactions.add(settlementTransaction);
            }
        }

        return settlementTransactions;
    }

    private HashMap<User,Double> getOutstandingBalances(List<Expense> expenses){
        HashMap<User,Double> outstandingBalances = new HashMap<>();
        for(Expense expense : expenses){
            for (UserExpense userExpense : expense.getUserExpenses()){
                User participant = userExpense.getUser();
                double amount = userExpense.getAmount();
                if(outstandingBalances.containsKey(participant)){
                    if(userExpense.getUserExpenseType().equals(UserExpenseType.PAID)){
                        outstandingBalances.put(participant, outstandingBalances.get(participant) + amount);
                    }else {
                        outstandingBalances.put(participant,outstandingBalances.get(participant) - amount);
                    }
                }else {
                    if(userExpense.getUserExpenseType().equals(UserExpenseType.PAID)){
                        outstandingBalances.put(participant, 0 + amount);
                    }else {
                        outstandingBalances.put(participant,0 - amount);
                    }
                }
            }
        }
        return outstandingBalances;
    }
}
