package com.codedifferently.csvreader.services;
import com.codedifferently.csvreader.models.SensorData;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CsvTest {

        public static void main(String[] args) throws IOException, CsvException {

            List<Map<String, String>> allUsers = new ArrayList<>(); // List that contains all of our user map

            //"names 2.csv" // simple test data
            //"test1.csv" // real data with tweaks
            String fileName = "/Users/m21/dev/csv/test1.csv"; // this imports a csv list
            try (CSVReader reader = new CSVReader(new FileReader(fileName))) {  // CSV Reader plugin

                List<SensorData> sensorData = new ArrayList<>();
                String[] record = null;

                while( (record = reader.readNext() ) != null) {
                    SensorData sd = new SensorData();
                    sd.setName(record[0]);
                    sd.setDateShipped(record[1]);
                    sd.setDateReceived(record[2]);
                    sd.setSize(record[3]);
                    sensorData.add(sd);
                }

                System.out.println(sensorData.get(1));

            } catch (InvalidPropertiesFormatException e) {
                System.out.println(e);
            }
        }

//        public static Map<String, String> addUser(String[] keys, String[] user) {
//            // try/catch
//            Map<String, String> users = new HashMap<>();  // create new map
//            for (int i = 0; i < keys.length; i++) {  // loop through all keys
//                if (users.containsKey(keys[i])) continue;
//                users.put(keys[i], user[i]); // put in the map current key with current user
//            }
//            return users;
//        }
//
//        public static void printAllObjects(List<String[]> data) {
//            for (String[] a : data) {
//                System.out.println(Arrays.toString(a));
//            }
//        }


}
