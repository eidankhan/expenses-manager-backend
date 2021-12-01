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

        try (
            CSVWriter csvWriter = new CSVWriter(new FileWriter("income.csv", true))){
            
            System.out.println("File Writer");
            csvWriter.writeAll(csvFileSample);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
