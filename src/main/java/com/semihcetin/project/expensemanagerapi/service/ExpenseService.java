package com.semihcetin.project.expensemanagerapi.service;

import com.semihcetin.project.expensemanagerapi.entity.Expense;
import com.semihcetin.project.expensemanagerapi.repository.ExpenseRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense createExpense(@RequestBody Expense expense) {
        return expenseRepository.save(expense);
    }

    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id).orElse(null);
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    public Expense updateExpense(Long id, @RequestBody Expense expenseDetails) {
        Expense existingExpense = expenseRepository.findById(id).orElse(null);

        if (existingExpense != null) {
            existingExpense.setTitle(expenseDetails.getTitle());
            existingExpense.setDescription(expenseDetails.getDescription());
            existingExpense.setAmount(expenseDetails.getAmount());
            existingExpense.setDate(expenseDetails.getDate());

            return expenseRepository.save(existingExpense);
        }

        return null;
    }
}
