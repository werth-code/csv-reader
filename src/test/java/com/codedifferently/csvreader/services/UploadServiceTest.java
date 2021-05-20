package com.codedifferently.csvreader.services;

import com.codedifferently.csvreader.models.User;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.mappers.CsvWithHeaderMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
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

@RunWith(JUnitParamsRunner.class)
class UploadServiceTest {

    UploadService uploadService;
    MultipartFile result;
    Model model;

    @BeforeEach
    void setUp() {
        uploadService = new UploadService();

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
    //@Parameters() // allows us to pass in custom parameters
    @FileParameters(value = "src/main/resources/names2.csv", mapper = CsvWithHeaderMapper.class)
    void upload() {
        String actual = uploadService.upload(result, model);
        String expected = "file-upload-status";
        System.out.println(actual);

        assertEquals(expected, actual);
    }

    @Test
    void fileIsEmpty() {
        boolean actual = uploadService.fileIsEmpty(result);
        System.out.println(actual);

        assertFalse(actual);
    }

    @Test
    void parseCSV() {
        List<User> users = uploadService.parseCSV(result, model);
        System.out.println(users);

        assertNull(users);
    }
}