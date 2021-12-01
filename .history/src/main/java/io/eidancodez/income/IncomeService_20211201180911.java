package io.eidancodez.income;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.eidancodez.util.OpenCSVFileParser;
import io.eidancodez.util.DateConverter;

@Service
public class IncomeService {

    private LocalDate currentDate;
    private String filePath = "src/main/resources/income.csv";
    private  String[] columns = {"ID", "Date", "Amount", "Payer", "Description"};

    public IncomeService(){
        currentDate = LocalDate.now();
    }

    public List<IncomeDTO> getAll(){
        return OpenCSVFileParser.readCSVFile(filePath);
    }

    public IncomeDTO save(IncomeModel income){
        List<IncomeDTO> listDTO =  OpenCSVFileParser.readCSVFile(filePath);
        Integer fileSize = 0;
        if(listDTO != null)
            fileSize = listDTO.size();
        Integer id = fileSize+1;
        income.setId(id);
        String[] row = {income.getId().toString(), income.getDate().toString(), income.getAmount().toString(), income.getPayer().toString(), income.getDescription().toString()};
        OpenCSVFileParser.writeToCSVFile(columns, row, filePath);
        return IncomeTransformer.transformToDTO(income);
    }

    public List<IncomeDTO> getIncomeForToday(){
        List<IncomeDTO> listDTO =  OpenCSVFileParser.readCSVFile(filePath);
        List<IncomeModel> listModel = transformToModel(listDTO);
        listModel =  listModel.stream().filter(ele -> ele.getDate().equals(currentDate)).collect(Collectors.toList()); 
        return transformToDTO(listModel);
    }

    public List<IncomeDTO> getIncomeForThisWeek(){
        Map<String, LocalDate> currentWeek =  DateConverter.gerrentWeek();
        LocalDate monday = currentWeek.get("mondayOfTheWeek");
        LocalDate sunday = currentWeek.get("sundayOfTheWeek");

        List<IncomeDTO> listDTO =  OpenCSVFileParser.readCSVFile(filePath);
        List<IncomeModel> listModel = transformToModel(listDTO);
        listModel = listModel.stream().filter(ele -> ele.getDate().compareTo(monday) >= 0 && ele.getDate().compareTo(sunday) <=0 ).collect(Collectors.toList());
        return transformToDTO(listModel);
    }
    
    public List<IncomeDTO> getIncomeForThisMonth(){
        LocalDate lastDateOfCurrentMonth = currentDate.withDayOfMonth(currentDate.getMonth().length(currentDate.isLeapYear()));
        List<IncomeDTO> listDTO =  OpenCSVFileParser.readCSVFile(filePath);
        List<IncomeModel> listModel = transformToModel(listDTO);
        listModel = listModel.stream().filter(
            ele -> ele.getDate().getMonthValue() == lastDateOfCurrentMonth.getMonthValue() && 
            ele.getDate().getDayOfMonth() <= lastDateOfCurrentMonth.getDayOfMonth()
        ).collect(Collectors.toList());
        return transformToDTO(listModel);
    }

    public Long getTotalIncome(){
        List<IncomeDTO> listDTO =  OpenCSVFileParser.readCSVFile(filePath);
        List<IncomeModel> listModel = transformToModel(listDTO);
        return listModel.stream().mapToLong(IncomeModel:: getAmount).sum();
    }

    public List<IncomeDTO> readFile(){
        return OpenCSVFileParser.readCSVFile(filePath);
    }

    private List<IncomeModel> transformToModel(List<IncomeDTO> listDTO){
        return listDTO.stream().map(ele -> { 
            return IncomeTransformer.transformToModel(ele);
        }).collect(Collectors.toList());
    }

    private List<IncomeDTO> transformToDTO(List<IncomeModel> listModel){
        return listModel.stream().map(ele -> { 
            return IncomeTransformer.transformToDTO(ele);
        }).collect(Collectors.toList());
    }

}
