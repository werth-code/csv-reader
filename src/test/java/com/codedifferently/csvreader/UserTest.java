package com.codedifferently.csvreader;

import com.codedifferently.csvreader.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user;

    @BeforeEach
    void setUp() {
        user = new User(103, "Matt", "matt@gmail.com", "US", 33);
    }

    @Test
    void getId() {
        Long expected = 103L;
        Long actual = user.getId();

        assertEquals(expected, actual);
    }

    @Test
    void setId() {
        user.setId(104L);
        Long expected = 104L;
        Long actual = user.getId();

        assertEquals(expected, actual);
    }

    @Test
    void getName() {
        String expected = "Matt";
        String actual = user.getName();

        assertEquals(expected, actual);
    }

    @Test
    void setName() {
        user.setName("Matthew");
        String expected = "Matthew";
        String actual = user.getName();

        assertEquals(expected, actual);
    }

    @Test
    void getEmail() {
        String expected = "matt@gmail.com";
        String actual = user.getEmail();

        assertEquals(expected, actual);
    }

    @Test
    void setEmail() {
        user.setEmail("matthewwerth@gmail.com");
        String expected = "matthewwerth@gmail.com";
        String actual = user.getEmail();

        assertEquals(expected, actual);
    }

    @Test
    void getCountryCode() {
        String expected = "US";
        String actual = user.getCountryCode();

        assertEquals(expected, actual);
    }

    @Test
    void setCountryCode() {
        user.setCountryCode("USA");
        String expected = "USA";
        String actual = user.getCountryCode();

        assertEquals(expected, actual);
    }

    @Test
    void getAge() {
        int expected = 33;
        int actual = user.getAge();

        assertEquals(expected, actual);
    }

    @Test
    void setAge() {
        user.setAge(35);
        int expected = 35;
        int actual = user.getAge();

        assertEquals(expected, actual);
    }
}