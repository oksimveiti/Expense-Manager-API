package com.semihcetin.project.expensemanagerapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Harcama basligi bos olamaz")
    private String title;

    private String description;

    @Column(nullable = false)
    @NotNull(message = "Miktar girilmelidir")
    @Positive(message = "Harcama miktari pozitif olmalidir")
    private BigDecimal amount;

    @NotNull(message = "Tarih bos olamaz")
    private LocalDate date;

    public Expense() {
    }

    public Expense(String title, String description, BigDecimal amount, LocalDate date) {
        this.title = title;
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
