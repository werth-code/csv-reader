package com.codedifferently.csvreader.models;

import com.opencsv.bean.CsvBindByName;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {


    //@GeneratedValue(strategy = GenerationType.AUTO) // may need config
    @CsvBindByName
    @Id
    private long id;
    @CsvBindByName
    private String name;
    @CsvBindByName
    private String email;
    @CsvBindByName(column = "country")
    private String country;
    @CsvBindByName
    private int age;

    public User() {}

//    public User(long id, String name, String email, String countryCode, int age) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.countryCode = countryCode;
//        this.age = age;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountryCode() {
        return country;
    }

    public void setCountryCode(String countryCode) {
        this.country = countryCode;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", countryCode='" + country + '\'' +
                ", age=" + age +
                '}';
    }
}
