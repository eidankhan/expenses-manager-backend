package io.eidancodez.util;

import java.util.ArrayList;
import java.util.List;

public class CSVFileWriter {
    
    private static List<String[]> createCSVFileHeaders(String[] headers){
        List<String[]> list = new ArrayList<>();
        list.add(headers);
        return list;
    }
}
