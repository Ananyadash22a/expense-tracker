package com.expense.tracker.controller;

import com.expense.tracker.dto.DashboardDTO;
import com.expense.tracker.service.DashboardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/{userId}")
    public DashboardDTO getDashboard(@PathVariable Long userId) {
        return dashboardService.getDashboard(userId);
    }
}