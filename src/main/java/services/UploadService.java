package services;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import repositories.UserRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Service
public class UploadService {

    @Autowired
    UserRepository userRepository;

    public String upload(MultipartFile file, Model model) {

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

    public List<User> parseCSV(MultipartFile file, Model model) {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                    .withType(User.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            // convert `CsvToBean` object to list of users
            List<User> users = csvToBean.parse();

            // save users list on model
            model.addAttribute("users", users);
            model.addAttribute("status", true);

            // save to database
            // saveUsers(users);

            return users;

        } catch (Exception ex) {
            model.addAttribute("message", "An error occurred while processing the CSV file.");
            model.addAttribute("status", false);
            return null;
        }
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void saveUsers(List<User> users) {
        userRepository.saveAll(users);
    }


}
