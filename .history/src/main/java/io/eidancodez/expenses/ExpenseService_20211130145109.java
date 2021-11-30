package io.eidancodez.expenses;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ExpenseService {
    private List<Expense> expenses = new ArrayList<>();
    String currentDate;

    public ExpenseService(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
        Date date = new Date();  
        currentDate = formatter.format(date).toString();
        expenses.add(new Expense(1, currentDate, 2500, "Food"));
    }

    public List<Expense> getAllExpenses(){
        return this.expenses;
    }


}
