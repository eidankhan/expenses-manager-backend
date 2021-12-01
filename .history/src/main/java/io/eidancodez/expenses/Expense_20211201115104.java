package io.eidancodez.expenses;

import java.time.LocalDate;

public class Expense {
    private Integer id;
    private LocalDate date;
    private Integer amount;
    private String category;

    public Expense(){}

    public Expense(Integer id, LocalDate date, Integer amount, String category) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    
    
}
