package com.semihcetin.project.expensemanagerapi.service;

import com.semihcetin.project.expensemanagerapi.entity.Expense;
import com.semihcetin.project.expensemanagerapi.exception.ResourceNotFoundException;
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
        return expenseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Expense not found with id " + id));
    }

    public void deleteExpense(Long id) {
        Expense existingExpense = getExpenseById(id);
        expenseRepository.deleteById(id);
    }

    public Expense updateExpense(Long id, @RequestBody Expense expenseDetails) {
        Expense existingExpense = getExpenseById(id);

        existingExpense.setTitle(expenseDetails.getTitle());
        existingExpense.setDescription(expenseDetails.getDescription());
        existingExpense.setAmount(expenseDetails.getAmount());
        existingExpense.setDate(expenseDetails.getDate());

        return expenseRepository.save(existingExpense);
    }
}
