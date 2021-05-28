package com.codedifferently.csvreader.services;

import com.codedifferently.csvreader.models.User;
import com.codedifferently.csvreader.repositories.UserRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;

//@Service
public class UploadAnyCsvService {

    //@Autowired
    //UserRepository userRepository;

    public String upload(MultipartFile file, Model model) throws IOException, CsvException {

        if (fileIsEmpty(file)) {
            model.addAttribute("message", "Please select a CSV file to upload.");
            model.addAttribute("status", false);
        }
        else parseCSV(file, model);
        return "file-upload-status";
    }

    public boolean fileIsEmpty(MultipartFile file) {
        return file.isEmpty();
    }

    public void parseCSV(MultipartFile file, Model model) throws IOException, CsvException {
        List<Map<String, String>> allUsers = new ArrayList<>();

        CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream())); // CSV Reader plugin

        List<String[]> data = reader.readAll();

        model.addAttribute("users", data); // add our data List for time leaf
        model.addAttribute("status", true);

        String[] keys = data.get(0);

        for (int i = 1; i < data.size(); i++) { // loop through all of the returned CSV data
            String[] current = data.get(i);    // our current array on this loop
            allUsers.add(addUser(keys, current)); // add to user list the map returned from function --> calls function
        }

    }

    public static Map<String, String> addUser(String[] keys, String[] user) {

        Logger log = LoggerFactory.getLogger(CsvMapService.class);
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
