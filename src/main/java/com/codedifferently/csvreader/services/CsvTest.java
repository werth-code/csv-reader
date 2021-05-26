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
                    sd.setDateShipped(record[0]);

                    sensorData.add(sd);
                }

                System.out.println(sensorData);

//                List<String[]> data = reader.readAll(); // What CSV Reader returns to us
//
//                String[] keys = data.get(0); // From our returned values - take the first String[] - contains keys
//
//                for (int i = 1; i < data.size(); i++) { // loop through all of the returned CSV data
//                    String[] current = data.get(i);    // our current array on this loop
//                    allUsers.add(addUser(keys, current)); // add to user list the map returned from function --> calls function
//                }
//
//                printAllObjects(data);
//                allUsers.forEach(System.out::println); // prints out all of our data
//                System.out.println("\n");
//
//                allUsers.get(1).forEach((s, s2) -> System.out.println("Key: " + s + " | Value: " + s2));

            } catch (InvalidPropertiesFormatException e) {
                System.out.println(e);
            }
        }

        public static Map<String, String> addUser(String[] keys, String[] user) {
            // try/catch
            Map<String, String> users = new HashMap<>();  // create new map
            for (int i = 0; i < keys.length; i++) {  // loop through all keys
                if (users.containsKey(keys[i])) continue;
                users.put(keys[i], user[i]); // put in the map current key with current user
            }
            return users;
        }

        public static void printAllObjects(List<String[]> data) {
            for (String[] a : data) {
                System.out.println(Arrays.toString(a));
            }
        }


}
