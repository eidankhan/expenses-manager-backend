package io.eidancodez.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

public class CSVFileWriter {

    public static void writeToCSVFile(String[] headers, String[] row, String filePath){
        List<String[]> data = new ArrayList<>();
        
        // If file is empty then create headers for it in first line
        if(isFileEmpty(filePath)){
            data.add(headers);
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

    private static Boolean isFileEmpty(String filePath){
        File file = new File(filePath);
        if(file.length() == 0)
            return true;
        return false;   
    }
}
