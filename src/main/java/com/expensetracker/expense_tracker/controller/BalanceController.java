package com.expensetracker.expense_tracker.controller;

import com.expensetracker.expense_tracker.service.BalanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/balance")
public class BalanceController {

    @Autowired
    private BalanceService balanceService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<Double> getRemainingBalance(@PathVariable Long userId) {
        return ResponseEntity.ok(balanceService.getRemainingBalance(userId));
    }
}
