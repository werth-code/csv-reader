package services;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.mappers.CsvWithHeaderMapper;
import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
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