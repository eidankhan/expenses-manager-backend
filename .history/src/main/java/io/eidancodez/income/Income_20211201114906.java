package io.eidancodez.income;

import java.time.LocalDate;

public class Income {
    private Integer id;
    private LocalDate date;
    private Integer amount;
    private String payer;
    private String description;

    public Income(){

    }

    public Income(Integer id, LocalDate date, Integer amount, String payer, String description) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.payer = payer;
        this.description = description;
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

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    
}
