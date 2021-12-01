package io.eidancodez.util;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import io.eidancodez.income.IncomeDTO;

public class OpenCSVFileParser {

    public static void writeToCSVFile(String[] columns, String[] row, String filePath){
        List<String[]> data = new ArrayList<>();
        
        // If file is empty then create columns for it in first line, else add new row to it
        if(isFileEmpty(filePath)){
            data.add(columns);
            data.add(row);
        }
        else{
            data.add(row);
        }

        try (
            CSVWriter csvWriter = new CSVWriter(new FileWriter(filePath, true))){
            csvWriter.writeAll(data);
            csvWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<IncomeDTO> readCSVFile(String filePath){
        List<IncomeDTO> incomeData = null;
        try (
            CSVReader reader = new CSVReader(new FileReader(filePath))){
                List<String[]> lines = reader.readAll();
                incomeData  = lines.stream().skip(1).map(line -> {
                    return new IncomeDTO(line[0], line[1], line[2], line[3], line[4]);
                }).collect(Collectors.toList());
        }   
        catch(Exception e){
            e.printStackTrace();
        }  
        return incomeData; 
    }

    private static Boolean isFileEmpty(String filePath){
        File file = new File(filePath);
        if(file.length() == 0)
            return true;
        return false;   
    }

    public Long getFileSize(String filePath){
        File file = new File(filePath);
        return file.length();
    }
}
