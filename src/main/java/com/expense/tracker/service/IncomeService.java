
package com.expense.tracker.service;

import com.expense.tracker.dto.IncomeDTO;
import com.expense.tracker.entity.Income;
import com.expense.tracker.entity.User;
import com.expense.tracker.repository.IncomeRepository;
import com.expense.tracker.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private UserRepository userRepository;

    public Income addIncome(IncomeDTO dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Income income = new Income();
        income.setAmount(dto.getAmount());
        income.setSource(dto.getSource());
        income.setDate(LocalDate.now());
        income.setUser(user);

        return incomeRepository.save(income);
    }

    public List<Income> getIncome(Long userId) {
        return incomeRepository.findByUserId(userId);
    }
}