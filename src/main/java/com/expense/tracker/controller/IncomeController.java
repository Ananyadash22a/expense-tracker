package com.expense.tracker.controller;

import com.expense.tracker.dto.IncomeDTO;
import com.expense.tracker.entity.Income;
import com.expense.tracker.service.IncomeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/income")
@CrossOrigin
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    @PostMapping
    public Income addIncome(@RequestBody IncomeDTO dto) {
        return incomeService.addIncome(dto);
    }

    @GetMapping("/{userId}")
    public List<Income> getIncome(@PathVariable Long userId) {
        return incomeService.getIncome(userId);
    }
}