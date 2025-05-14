package com.expensetracker.expense_tracker.controller;

import com.expensetracker.expense_tracker.model.Income;
import com.expensetracker.expense_tracker.service.IncomeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/income")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Income>> getUserIncomes(@PathVariable Long userId) {
        return ResponseEntity.ok(incomeService.getIncomesByUser(userId));
    }

    @PostMapping("/add")
    public ResponseEntity<Income> addIncome(@RequestBody Income income) {
        Income savedIncome = incomeService.addIncome(income);
        return ResponseEntity.ok(savedIncome);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Income> updateIncome(@PathVariable Long id, @RequestBody Income updatedIncome) {
        Income income = incomeService.updateIncome(id, updatedIncome);
        return ResponseEntity.ok(income);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncome(@PathVariable Long id) {
        incomeService.deleteIncome(id);
        return ResponseEntity.noContent().build();
    }
}
