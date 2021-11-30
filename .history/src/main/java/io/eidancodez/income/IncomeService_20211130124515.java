package io.eidancodez.income;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class IncomeService {

    private List<Income> incomeData = new ArrayList<>();

    public IncomeService(){
        incomeData.add(new Income(1, "30-11-2021", 54800, "Teresol", "Payment received for the month of November"));
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

    public void getIncomeForToday(){
        String date = LocalDate.now().toString();
        System.out.println("Date:"+date);
        this.incomeData.stream().filter(ele -> ele.getDate().equals("date")).findAny();
    }

}
