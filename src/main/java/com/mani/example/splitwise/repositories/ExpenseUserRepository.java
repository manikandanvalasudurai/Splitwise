package com.mani.example.splitwise.repositories;

import com.mani.example.splitwise.models.ExpenseUser;
import com.mani.example.splitwise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExpenseUserRepository extends JpaRepository<ExpenseUser, Long> {
    List<ExpenseUser> findByUser(User user);
}
