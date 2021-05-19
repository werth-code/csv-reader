package com.codedifferently.csvreader.services;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.mappers.CsvWithHeaderMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnitParamsRunner.class)
class UploadServiceTest {

    UploadService uploadService;
    MultipartFile result;

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
        } catch (final IOException e) {
        }
        result = new MockMultipartFile(name,
                originalFileName, contentType, content);
    }


    @Test
    //@Parameters() // allows us to pass in custom parameters
    @FileParameters(value = "src/main/resources/names2.csv", mapper = CsvWithHeaderMapper.class)
    void upload() {
    }

    @Test
    void fileIsEmpty() {
        boolean actual = uploadService.fileIsEmpty(result);
        assertFalse(actual);
    }

    @Test
    void parseCSV() {

    }
}