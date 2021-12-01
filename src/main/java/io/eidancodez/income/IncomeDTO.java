package io.eidancodez.income;

public class IncomeDTO {
    private String id;
    private String date;
    private String amount;
    private String payer;
    private String description;

    public IncomeDTO(){}

    public IncomeDTO(String id, String date, String amount, String payer, String description) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.payer = payer;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
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
