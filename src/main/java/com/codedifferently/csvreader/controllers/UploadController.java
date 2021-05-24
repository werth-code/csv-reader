package com.codedifferently.csvreader.controllers;

import com.codedifferently.csvreader.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.codedifferently.csvreader.services.UploadService;

@Controller
public class UploadController {

    @Autowired
    UploadService uploadService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/all-users") // show all of our user-data
    public Iterable<User> viewAllUsers() {
        return uploadService.getAllUsers();
    }

    @PostMapping("/upload-csv-file")
    public String uploadCSVFile(@RequestParam("file") MultipartFile file, Model model) {
        return uploadService.upload(file, model);
    }

}