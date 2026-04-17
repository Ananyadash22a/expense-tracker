package com.expense.tracker.service;

import com.expense.tracker.dto.ExpenseDTO;
import com.expense.tracker.entity.Expense;
import com.expense.tracker.entity.User;
import com.expense.tracker.repository.ExpenseRepository;
import com.expense.tracker.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserRepository userRepository;

    public Expense addExpense(ExpenseDTO dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Expense expense = new Expense();
        expense.setCategory(dto.getCategory());
        expense.setAmount(dto.getAmount());
        expense.setDate(LocalDate.now());
        expense.setUser(user);

        return expenseRepository.save(expense);
    }

    public List<Expense> getExpenses(Long userId) {
        return expenseRepository.findByUserId(userId);
    }
}