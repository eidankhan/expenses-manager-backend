package io.eidancodez.income;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class IncomeService {

    private List<Income> incomeData = new ArrayList<>();

    public IncomeService(){

    }

    public void initializeIncomeData(){
        incomeData.add(new Income(1, "30-11-2021", 54800.00, "Teresol", "Payment received for the month of November"));
    }

}
