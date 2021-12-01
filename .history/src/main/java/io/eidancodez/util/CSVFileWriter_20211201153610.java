package io.eidancodez.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

public class CSVFileWriter {
    
    private static List<String[]> createCSVFileHeaders(String[] headers){
        List<String[]> list = new ArrayList<>();
        list.add(headers);
        return list;
    }

    public static void writeToCSVFile(String[] headers, String[] row){
        List<String[]> csvFileSample =  createCSVFileHeaders(headers);
        csvFileSample.add(row);
        String filePath = "src/main/resources/income.csv";
        System.out.println(isFileEmpty(filePath));
        try (
            CSVWriter csvWriter = new CSVWriter(new FileWriter(filePath, true))){
        
            System.out.println("File Writer");
            csvWriter.writeAll(csvFileSample);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Boolean isFileEmpty(String path){
        File file = new File(path);
        if(file.length() == 0)
            return true;
        return false;   
    }
}
