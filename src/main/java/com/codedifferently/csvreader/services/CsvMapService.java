package com.codedifferently.csvreader.services;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CsvMapService {

    public static void main(String[] args) throws IOException, CsvException {

        Logger log = LoggerFactory.getLogger(CsvMapService.class);

        List<Map<String, String>> allUsers = new ArrayList<>(); // List that contains all of our user maps

        //"names 2.csv" // simple test data
        //"test1.csv" // real data with tweaks
        //dataEmptyHeader.csv // data no header
        String fileName = "/Users/m21/dev/csv/test1.csv"; // this imports a csv list
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {  // CSV Reader plugin


            List<String[]> data = reader.readAll(); // What CSV Reader returns to us
            String[] keys = data.get(0); // From our returned values - take the first String[] - contains keys

            for (int i = 1; i < data.size(); i++) { // loop through all of the returned CSV data
                String[] current = data.get(i);    // our current array on this loop
                allUsers.add(addUser(keys, current)); // add to user list the map returned from function --> calls function
            }

            //log.info(Arrays.toString(keys)); // log our keys
            allUsers.get(allUsers.size() -1).forEach((s, s2) -> log.info("Key:  " + s + "  *|*  Value:  " + s2)); // log our mapped properties

        } catch (InvalidPropertiesFormatException e) {
            log.warn(e.toString());
        }
    }

    public static Map<String, String> addUser(String[] keys, String[] user) {
        Logger log = LoggerFactory.getLogger(CsvMapService.class);

        if(keys.length == 0 || user.length == 0) { // May not even happen - could all be "" empty strings?
            log.error("No Values");
            return null;
        }
        Map<String, String> users = new HashMap<>();  // create new map

        for (int i = 0; i < keys.length; i++) {  // loop through all keys
            if(keys[i].equals("") || user[i].equals("")) {
                log.error(users.get(keys[i]) + " | Missing Key Error");
                continue;
            }
            if (users.containsKey(keys[i])) {
                log.error(users.get(keys[i]) + " | Duplicate Key Error");
                continue;
            }
            users.put(keys[i], user[i]); // put in the map current key with current user
        }
        return users;
    }

    public static void printAllObjects(List<String[]> data) {
        Logger log = LoggerFactory.getLogger(CsvMapService.class);
        for (String[] a : data) {
            log.info(Arrays.toString(a));
        }
    }

}

//[Name, 1Name, 1Size, 1Style/Foot, 1Quantity, 1Code, 1Serial Number, 1Thickness (mm), 1Last , 1O/S, 1Season, 1Color, 1H. Height(BP),
// 1H.Height(Actual), 1Med Height(BP), 1Med Height(Actual), 1Lat Height(BP), 1Lat Height(Actual), 1Collar Apex(BP), 1Collar Apex(Actual),
// 1Throat Width(BP), 1Throat Width(Actual), 1Vamp Length(BP), 1Vamp Length(Actual), 1Forefoot, 1Midfoot, 1Rearfoot, 1Misc, 1, , , , , , , , ]