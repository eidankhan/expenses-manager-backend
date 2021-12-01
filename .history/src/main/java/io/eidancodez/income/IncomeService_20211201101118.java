package io.eidancodez.income;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class IncomeService {

    private List<Income> incomeData = new ArrayList<>();
    private String currentDate;

    public IncomeService(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
        Date date = new Date();  
        currentDate = formatter.format(date).toString();
        incomeData.add(new Income(1, currentDate, 54800, "Teresol", "Payment received for the month of November"));
    }

    public List<Income> getAll(){
        return incomeData;
    }

    public Income save(Income income){
        Integer id = this.incomeData.size() + 1;
        income.setId(id);
        this.incomeData.add(income);
        return income;
    }

    public Object getIncomeForToday(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
        Date date = new Date();  
        String today = formatter.format(date).toString();
        return this.incomeData.stream().filter(ele -> ele.getDate().equals(today)).allMatch(u -> true);
    }

    public Long getTotalIncome(){
        return this.incomeData.stream().mapToLong(Income:: getAmount).sum();
    }

}
