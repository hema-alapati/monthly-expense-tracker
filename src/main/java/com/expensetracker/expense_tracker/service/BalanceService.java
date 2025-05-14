package com.expensetracker.expense_tracker.service;

import org.springframework.stereotype.Service;

@Service
public class BalanceService {
    private final IncomeService incomeService;
    private final ExpenseService expenseService;

    public BalanceService(IncomeService incomeService, ExpenseService expenseService) {
        this.incomeService = incomeService;
        this.expenseService = expenseService;
    }

    public double getRemainingBalance(Long userId) {
        double totalIncome = incomeService.getTotalIncome(userId);
        double totalExpense = expenseService.getTotalExpense(userId);
        return totalIncome - totalExpense;
    }
}