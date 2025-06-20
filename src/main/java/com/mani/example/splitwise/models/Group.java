package com.mani.example.splitwise.models;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity(name = "groups")
public class Group extends BaseModel {
    private String name;
    @ManyToOne
    private User createdBy;
    @ManyToMany
    private List<User> members;
    @OneToMany
    private List<Expense> expenses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }
}

/*
   1        1
Group  - createdBy --> M : 1
    M       1

  1       M
Group - Members  --> M : M
  M       1

  1        M
Group - Expenses --> 1 : M
  1         1
 */
