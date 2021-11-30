package io.eidancodez.income;

public class Income {
    private Integer id;
    private String date;
    private Double amount;
    private String payer;
    private String description;

    public Income(){

    }

    public Income(Integer id, String date, Double amount, String payer, String description) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
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
