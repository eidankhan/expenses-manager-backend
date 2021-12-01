package io.eidancodez.income;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.eidancodez.util.DateConverter;

@Service
public class IncomeService {

    private List<Income> incomeData = new ArrayList<>();
    private LocalDate currentDate;

    public IncomeService(){
        currentDate = LocalDate.now();
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

    public List<Income> getIncomeForToday(){
        return this.incomeData.stream().filter(ele -> ele.getDate().equals(currentDate)).collect(Collectors.toList()); 
    }

    public List<Income> getIncomeForThisWeek(){
        Map<String, LocalDate> currentWeek =  DateConverter.gerrentWeek();
        LocalDate monday = currentWeek.get("mondayOfTheWeek");
        LocalDate sunday = currentWeek.get("sundayOfTheWeek");
        return this.incomeData.stream().filter(ele -> ele.getDate().compareTo(monday) >= 0 && ele.getDate().compareTo(sunday) <=0 ).collect(Collectors.toList());
    }
    
    public List<Income> getIncomeForThisMonth(){
        LocalDate date = LocalDate.now();
        System.out.println(date.lengthOfMonth());
        date = date.withDayOfMonth(date.getMonth().length(date.isLeapYear()));
        System.out.println("Date:"+date.lengthOfMonth());
        return null;
    }

    public Long getTotalIncome(){
        return this.incomeData.stream().mapToLong(Income:: getAmount).sum();
    }

}
