package io.eidancodez.income;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/v1/income")
public class IncomeController {
    
    @Autowired
    private IncomeService incomeService;

    @GetMapping
    public Object getAll(){
        List<IncomeDTO> incomeData =  incomeService.getAll();
        if(incomeData == null)
            return "NO DATA FOUND";
        return incomeService.getAll();
    }

    @PostMapping
    public Object save(@RequestBody IncomeModel income){
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

    @GetMapping("/thisMonth")
    public Object getIncomeForThisMonth(){
        return incomeService.getIncomeForThisMonth();
    }
}
