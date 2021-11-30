package io.eidancodez.income;

import java.util.ArrayList;
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

}
