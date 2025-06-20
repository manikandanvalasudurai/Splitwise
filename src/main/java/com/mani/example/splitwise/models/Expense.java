package com.mani.example.splitwise.models;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "expenses")
public class Expense extends BaseModel{
    private String description;
    private int amount;
    @ManyToOne
    private User createdBy;
    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType;
    @OneToMany
    private List<ExpenseUser> expenseUsers;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }

    public List<ExpenseUser> getExpenseUsers() {
        return expenseUsers;
    }

    public void setExpenseUsers(List<ExpenseUser> expenseUsers) {
        this.expenseUsers = expenseUsers;
    }
}

/*
    1       1
Expenses - Users -> 1 : M
    M       1

    1           1
Expense   - ExpenseUser      1:M
    M           1

 */
