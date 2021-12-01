package io.eidancodez.income;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.eidancodez.util.DateConverter;

@RestController
@CrossOrigin
@RequestMapping("/v1/income")
public class IncomeController {
    
    @Autowired
    private IncomeService incomeService;

    @GetMapping
    public Object getAll(){
        return incomeService.getAll();
    }

    @PostMapping
    public Object save(@RequestBody Income income){
        incomeService.getIncomeForThisMonth();
        return incomeService.save(income);
    }

    @GetMapping("/today")
    public Object getIncomeForToday(){
        return incomeService.getIncomeForToday();
    }

    @GetMapping("/thisWeek")
    public Object getIncomeForThisWeek(){
        return incomeService.getIncomeForThisWeek();
    }
}
