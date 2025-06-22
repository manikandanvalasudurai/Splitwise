package com.mani.example.splitwise.strategy;

import com.mani.example.splitwise.models.Expense;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class HeapSettleUpStrategy implements SettleUpStrategy {
    @Override
    public List<Expense> settleUp(List<Expense> expenses) {
        //Algo Using Min and Max Heap
        return new ArrayList<>(expenses);
    }
}
