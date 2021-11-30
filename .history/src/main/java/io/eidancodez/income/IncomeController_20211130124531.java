package io.eidancodez.income;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/income")
public class IncomeController {
    
    @Autowired
    private IncomeService incomeService;

    @GetMapping
    public Object getAll(){
        incomeService.getIncomeForToday();
        return incomeService.getAll();
    }

    @PostMapping
    public Object save(@RequestBody Income income){
        return incomeService.save(income);
    }

    @GetMapping("/today")
    public Object getIncomeForToday(){
        return null;
    }
}
