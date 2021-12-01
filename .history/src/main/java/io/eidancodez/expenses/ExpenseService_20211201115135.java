package io.eidancodez.expenses;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    private List<Expense> expenses = new ArrayList<>();
    LocalDate currentDate;

    public ExpenseService(){
        currentDate = LocalDate.now();
        expenses.add(new Expense(1, currentDate, 2500, "Food"));
    }

    public List<Expense> getAllExpenses(){
        return this.expenses;
    }

    public Object getExpenesForToday(){
        return this.expenses.stream().filter(ele -> ele.getDate().equals(currentDate)).findAny();
    }
   
}
