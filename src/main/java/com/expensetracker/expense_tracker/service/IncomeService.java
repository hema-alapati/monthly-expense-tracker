package com.expensetracker.expense_tracker.service;

import com.expensetracker.expense_tracker.model.Income;
import com.expensetracker.expense_tracker.repository.IncomeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeService {
    private final IncomeRepository incomeRepository;

    public IncomeService(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    public Income addIncome(Income income) {
        return incomeRepository.save(income);
    }

    public List<Income> getIncomeByUserId(Long userId) {
        return incomeRepository.findByUserId(userId);
    }

    public double getTotalIncome(Long userId) {
        return getIncomeByUserId(userId)
                .stream()
                .mapToDouble(Income::getAmount)
                .sum();
    }

    public List<Income> getIncomesByUser(Long userId) {
        return incomeRepository.findByUserId(userId);
    }
    
    public Income updateIncome(Long id, Income updatedIncome) {
        Income existingIncome = incomeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Income not found with id: " + id));

        existingIncome.setAmount(updatedIncome.getAmount());
        existingIncome.setDescription(updatedIncome.getDescription());
        existingIncome.setCategoryName(updatedIncome.getCategoryName());
        existingIncome.setUser(updatedIncome.getUser());

        return incomeRepository.save(existingIncome);
    }

    public void deleteIncome(Long id) {
        if (!incomeRepository.existsById(id)) {
            throw new RuntimeException("Income not found with id: " + id);
        }
        incomeRepository.deleteById(id);
    }
}
