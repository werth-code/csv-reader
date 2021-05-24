package com.codedifferently.csvreader.services;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CsvMapService {
    public static void main(String[] args) throws IOException, CsvException {

        List<Map<String, String>> allUsers = new ArrayList<>();

        Long idNum = 100L;

        String fileName = "/Users/m21/dev/csv-reader/src/main/resources/csvNullData.csv";
            try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
                List<String[]> data = reader.readAll();

                String[] keys = data.get(0);

                for(int i = 1; i < data.size(); i++) {
                    String[] current = data.get(i);
                    allUsers.add(addUser(keys, current));
                }
                allUsers.forEach(System.out::println);
            }
        }

        public static Map<String, String> addUser(String[] keys, String[] user) {
            //try/catch
            Map<String, String> users = new HashMap<>();
            for(int i = 0; i < keys.length; i++) {
                users.put(keys[i], user[i]);
            }
            return users;
        }
    }


