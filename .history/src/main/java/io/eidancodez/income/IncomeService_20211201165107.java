package io.eidancodez.income;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.eidancodez.util.CSVFileWriter;
import io.eidancodez.util.DateConverter;

@Service
public class IncomeService {

    private List<IncomeModel> incomeData = new ArrayList<>();
    private LocalDate currentDate;
    private String filePath = "src/main/resources/income.csv";
    private  String[] columns = {"ID", "Date", "Amount", "Payer", "Description"};

    public IncomeService(){
        currentDate = LocalDate.now();
        incomeData.add(new IncomeModel(1, currentDate, 54800, "Teresol", "Payment received for the month of November"));
    }

    public List<IncomeModel> getAll(){
        return incomeData;
    }

    public IncomeModel save(IncomeModel income){
        Integer id = this.incomeData.size() + 1;
        income.setId(id);
        this.incomeData.add(income);
        String[] row = {income.getId().toString(), income.getDate().toString(), income.getAmount().toString(), income.getPayer().toString(), income.getDescription().toString()};
        CSVFileWriter.writeToCSVFile(columns, row, filePath);
        return income;
    }

    public List<IncomeModel> getIncomeForToday(){
        return this.incomeData.stream().filter(ele -> ele.getDate().equals(currentDate)).collect(Collectors.toList()); 
    }

    public List<IncomeModel> getIncomeForThisWeek(){
        Map<String, LocalDate> currentWeek =  DateConverter.gerrentWeek();
        LocalDate monday = currentWeek.get("mondayOfTheWeek");
        LocalDate sunday = currentWeek.get("sundayOfTheWeek");
        return this.incomeData.stream().filter(ele -> ele.getDate().compareTo(monday) >= 0 && ele.getDate().compareTo(sunday) <=0 ).collect(Collectors.toList());
    }
    
    public List<IncomeModel> getIncomeForThisMonth(){
        LocalDate lastDateOfCurrentMonth = currentDate.withDayOfMonth(currentDate.getMonth().length(currentDate.isLeapYear()));
        return this.incomeData.stream().filter(
            ele -> ele.getDate().getMonthValue() == lastDateOfCurrentMonth.getMonthValue() && 
            ele.getDate().getDayOfMonth() <= lastDateOfCurrentMonth.getDayOfMonth()
            ).collect(Collectors.toList());
    }

    public Long getTotalIncome(){
        return this.incomeData.stream().mapToLong(IncomeModel:: getAmount).sum();
    }

    public List<IncomeDTO> readFile(){
        return CSVFileWriter.readCSVFile(filePath);
    }

}
