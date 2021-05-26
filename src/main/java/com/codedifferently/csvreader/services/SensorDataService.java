package com.codedifferently.csvreader.services;

import com.codedifferently.csvreader.models.SensorData;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SensorDataService {
    public static void main(String[] args) throws FileNotFoundException {

        HeaderColumnNameTranslateMappingStrategy<SensorData> strategy = new HeaderColumnNameTranslateMappingStrategy<>();
        strategy.setType(SensorData.class);

        try {
            CsvToBeanBuilder<SensorData> beanBuilder = new CsvToBeanBuilder<SensorData>(
                    new CSVReader(new FileReader("/Users/m21/dev/csv/test1.csv")));
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
