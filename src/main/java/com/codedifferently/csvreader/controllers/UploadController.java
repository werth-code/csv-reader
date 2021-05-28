package com.codedifferently.csvreader.controllers;

import com.codedifferently.csvreader.models.User;
import com.codedifferently.csvreader.services.UploadAnyCsvService;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.codedifferently.csvreader.services.UploadService;

import java.io.IOException;

@Controller
public class UploadController {

    @Autowired
    UploadAnyCsvService uploadAnyCsvService;
    @Autowired
    UploadService uploadService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/upload-csv-file")
    public String upload(@RequestParam("file") MultipartFile file, Model model) throws IOException, CsvException {
        return uploadService.upload(file, model);
    }

    @PostMapping("/upload")
    public String upload2(@RequestParam("file") MultipartFile file, Model model) throws IOException, CsvException {
        return uploadAnyCsvService.upload(file, model);
    }

}
