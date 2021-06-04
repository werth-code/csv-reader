package com.codedifferently.csvreader.services;
import com.codedifferently.csvreader.models.CSVModel;
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

@Service
public class UploadAnyCsvService {

    @Autowired
    UserRepository userRepository;

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

    public List<CSVModel> parseCSV(MultipartFile file, Model model) throws IOException, CsvException {
        try {

            CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream())); // CSV Reader plugin
            List<String[]> data = reader.readAll();

            List<CSVModel> users = new ArrayList<>();
            String[] keys = data.get(0);

            for (int i = 1; i < data.size(); i++) { // loop through all of the returned CSV data
                String[] current = data.get(i);    // our current array on this loop
                users.add(addUser(keys, current)); // add to user list the map returned from function --> calls function
            }

            model.addAttribute("users", users); // add our data List for time leaf
            model.addAttribute("keys", keys);
            model.addAttribute("status", true);

            users.forEach(System.out::println);

            return users;

        } catch (Exception e) {
            System.out.println(e);
            model.addAttribute("message", "An error occurred while processing the CSV file.");
            model.addAttribute("status", false);
        }
            return null;
    }

    public static CSVModel addUser(String[] keys, String[] user) {

        Logger log = LoggerFactory.getLogger(CsvMapService.class);
        Map<String, String> users = new HashMap<>();  // create new map
        CSVModel csvModel = new CSVModel(users);

        for (int i = 0; i < keys.length; i++) {  // loop through all keys
//            if(keys[i].equals("") || user[i].equals("")) {
//                log.error(users.get(keys[i]) + " | Missing Key Error");
//                continue;
//            }
            if (users.containsKey(keys[i])) {
                log.error(users.get(keys[i]) + " | Duplicate Key Error");
                continue;
            }
            users.put(keys[i], user[i]); // put in the map current key with current user
        }
        csvModel.setProperties(users);
        return csvModel;
    }

}
