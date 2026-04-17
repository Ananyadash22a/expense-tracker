package com.expense.tracker.service;

import org.springframework.stereotype.Service;

@Service
public class AnalyticsService {

    public double calculateHealthScore(double income, double expense) {

        if (income == 0) return 0;

        double savings = income - expense;
        double ratio = (savings / income) * 100;

        if (ratio >= 50) return 90;
        else if (ratio >= 30) return 75;
        else if (ratio >= 10) return 60;
        else return 40;
    }

    public String getSuggestion(double expense, double income) {

        if (expense > income) {
            return "Overspending! Reduce expenses immediately.";
        }

        if (expense > income * 0.7) {
            return "Try reducing unnecessary spending by 15%.";
        }

        return "Good financial control. Keep saving!";
    }
}