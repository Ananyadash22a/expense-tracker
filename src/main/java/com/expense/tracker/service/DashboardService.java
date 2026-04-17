package com.expense.tracker.service;


import com.expense.tracker.dto.DashboardDTO;
import com.expense.tracker.entity.Expense;
import com.expense.tracker.entity.Income;
import com.expense.tracker.repository.ExpenseRepository;
import com.expense.tracker.repository.IncomeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private AnalyticsService analyticsService;

    public DashboardDTO getDashboard(Long userId) {

        List<Expense> expenses = expenseRepository.findByUserId(userId);
        List<Income> incomes = incomeRepository.findByUserId(userId);

        double totalExpense = expenses.stream()
                .mapToDouble(Expense::getAmount)
                .sum();

        double totalIncome = incomes.stream()
                .mapToDouble(Income::getAmount)
                .sum();

        double balance = totalIncome - totalExpense;

        double healthScore = analyticsService
                .calculateHealthScore(totalIncome, totalExpense);

        String suggestion = analyticsService
                .getSuggestion(totalExpense, totalIncome);

        DashboardDTO dto = new DashboardDTO();
        dto.setIncome(totalIncome);
        dto.setExpense(totalExpense);
        dto.setBalance(balance);
        dto.setHealthScore(healthScore);
        dto.setSuggestion(suggestion);

        return dto;
    }
}