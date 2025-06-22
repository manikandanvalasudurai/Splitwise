package com.mani.example.splitwise.strategy;

import com.mani.example.splitwise.models.Expense;
import org.springframework.stereotype.Component;
import java.util.List;


public interface SettleUpStrategy {
    List<Expense> settleUp(List<Expense> expenses);
}
