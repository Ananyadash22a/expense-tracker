package com.expense.tracker.dto;
public class IncomeDTO {

    private double amount;
    private String source;
    private Long userId;

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}