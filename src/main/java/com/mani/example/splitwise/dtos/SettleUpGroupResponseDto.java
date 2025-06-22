package com.mani.example.splitwise.dtos;

import com.mani.example.splitwise.models.Expense;

import java.util.List;

public class SettleUpGroupResponseDto {
    private List<Expense> expenses;

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }
}
