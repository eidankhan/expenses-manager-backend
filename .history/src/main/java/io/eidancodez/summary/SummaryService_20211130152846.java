package io.eidancodez.summary;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.eidancodez.expenses.ExpenseService;
import io.eidancodez.income.IncomeService;

@Service
public class SummaryService {

    @Autowired
    private IncomeService incomeService;
    @Autowired 
    private ExpenseService expenseService;

    private List<Object> accountSummaryForToday = new ArrayList<>();
    private String currentDate;
    private Long balance;

    public SummaryService(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
        Date date = new Date();  
        currentDate = formatter.format(date).toString();
        balance = incomeService.getTotalIncome();
    }
    public Object getAccountSummaryForToday(){
        Object incomeForToday = incomeService.getIncomeForToday();
        Object expensesForToday = expenseService.getExpenesForToday();
        accountSummaryForToday.add(incomeForToday);
        accountSummaryForToday.add(expensesForToday);
        return null;
    }
}
