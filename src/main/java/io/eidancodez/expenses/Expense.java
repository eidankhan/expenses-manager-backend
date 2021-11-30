package io.eidancodez.expenses;

public class Expense {
    private Integer id;
    private String date;
    private Integer amount;
    private String category;

    public Expense(){}

    public Expense(Integer id, String date, Integer amount, String category) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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
