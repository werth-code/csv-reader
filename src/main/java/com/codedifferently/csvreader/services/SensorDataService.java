package com.codedifferently.csvreader.services;

import com.codedifferently.csvreader.models.SensorData;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SensorDataService {
    public static void main(String[] args) throws FileNotFoundException {

        // Hashmap to map CSV data to
        // Bean attributes.
        Map<String, String> mapping = new HashMap<>();
        mapping.put("name", "Name");
        mapping.put("rollno", "RollNo");
        mapping.put("department", "Department");
        mapping.put("result", "Result");
        mapping.put("cgpa", "Pointer");

        HeaderColumnNameTranslateMappingStrategy<SensorData> strategy = new HeaderColumnNameTranslateMappingStrategy<>();
        strategy.setType(SensorData.class);
        strategy.setColumnMapping(mapping);

        try {
            CsvToBeanBuilder<SensorData> beanBuilder = new CsvToBeanBuilder<SensorData>(new CSVReader(new FileReader("/Users/m21/dev/csv/names 2.csv")));
            beanBuilder.withType(SensorData.class);
            List<SensorData> data = beanBuilder.build().parse();

            for (SensorData e : data) {
                System.out.println(e.toString());
            }
        }
        catch(FileNotFoundException e) {
            System.out.println(e);
        }

    }
}
