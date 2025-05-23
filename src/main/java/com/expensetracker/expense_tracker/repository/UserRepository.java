package com.expensetracker.expense_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expensetracker.expense_tracker.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}