package com.codedifferently.csvreader.services;

import com.codedifferently.csvreader.models.CSVModel;
import com.opencsv.exceptions.CsvException;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class UploadAnyCsvServiceTest {
    CSVModel csvModel;
    UploadAnyCsvService uploadAnyCsvService;
    MultipartFile result;
    Model model;

    @BeforeEach
    void setUp() {
        csvModel = new CSVModel();
        uploadAnyCsvService = new UploadAnyCsvService();

        Path path = Paths.get("src/main/resources/names2.csv");
        String name = "names2.csv";
        String originalFileName = "file.txt";
        String contentType = "text/plain";
        byte[] content = null;

        try {
            content = Files.readAllBytes(path);
        }
        catch (final IOException e) {
            System.out.println(e.getMessage());
        }
        result = new MockMultipartFile(name, originalFileName, contentType, content);
        model = mock(Model.class);
    }


    @Test
    void parseCSV() throws IOException, CsvException {
        List<CSVModel> actual = uploadAnyCsvService.parseCSV(result, model);
        String expected = "[CSVModel{id=0, properties={country=US, name=Mark Hamilton, id=100, email=mham@gmail.com, age=45}}, CSVModel{id=0, properties={country=FR, name=Susan Malihan, id=101, email=smalihan@yahoo.com, age=32}}, CSVModel{id=0, properties={country=PK, name=Kyle Adams, id=102, email=kad@gmail.com, age=22}}, CSVModel{id=0, properties={country=DE, name=Freddy Deska, id=103, email=deska1@gmail.com, age=21}}, CSVModel{id=0, properties={country=US, name=Avi Cruster, id=104, email=acru12@gmail.com, age=32}}]";
        System.out.println(actual);

        assertEquals(expected, actual.toString());
    }

    @Test
    void addUser() throws IOException, CsvException {
        String[] users = {"A", "B", "C"};
        String[] keys = {"1", "2", "3"};

        CSVModel csvModel = uploadAnyCsvService.addUser(users, keys);
        String modelData = "CSVModel{id=0, properties={A=1, B=2, C=3}}";
        System.out.println(csvModel);

       assertEquals(modelData, csvModel.toString());
    }
}