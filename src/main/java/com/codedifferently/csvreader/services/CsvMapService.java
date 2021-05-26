package com.codedifferently.csvreader.services;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CsvMapService {

    public static void main(String[] args) throws IOException, CsvException {

        List<Map<String, String>> allUsers = new ArrayList<>(); // List that contains all of our user maps

        //"names 2.csv" // simple test data
        //"test1.csv" // real data with tweaks
        String fileName = "/Users/m21/dev/csv/testDuplicateHeader.csv"; // this imports a csv list
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {  // CSV Reader plugin

            List<String[]> data = reader.readAll(); // What CSV Reader returns to us
            String[] keys = data.get(0); // From our returned values - take the first String[] - contains keys

            for (int i = 1; i < data.size(); i++) { // loop through all of the returned CSV data
                String[] current = data.get(i);    // our current array on this loop
                allUsers.add(addUser(keys, current)); // add to user list the map returned from function --> calls function
            }

            // remove or limit empty properties?

            System.out.println(Arrays.toString(keys));
            printAllObjects(data);
            allUsers.forEach(System.out::println); // prints out all of our data
            System.out.println("\n");

            allUsers.get(allUsers.size() -1).forEach((s, s2) -> System.out.println("Key: " + s + " | Value: " + s2));

        } catch (InvalidPropertiesFormatException e) {
            System.out.println(e);
        }
    }

    public static Map<String, String> addUser(String[] keys, String[] user) {
        // exceptions?
        Map<String, String> users = new HashMap<>();  // create new map
        for (int i = 0; i < keys.length; i++) {  // loop through all keys
            if (users.containsKey(keys[i])) {
                System.out.println(users.get(keys[i]) + " | Duplicate Key Error");
                continue;
            }
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

//[Name, 1Name, 1Size, 1Style/Foot, 1Quantity, 1Code, 1Serial Number, 1Thickness (mm), 1Last , 1O/S, 1Season, 1Color, 1H. Height(BP),
// 1H.Height(Actual), 1Med Height(BP), 1Med Height(Actual), 1Lat Height(BP), 1Lat Height(Actual), 1Collar Apex(BP), 1Collar Apex(Actual),
// 1Throat Width(BP), 1Throat Width(Actual), 1Vamp Length(BP), 1Vamp Length(Actual), 1Forefoot, 1Midfoot, 1Rearfoot, 1Misc, 1, , , , , , , , ]