package com.codedifferently.csvreader.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CsvMapServiceTest {
    String[] keys;
    String[] users;

    @BeforeEach
    void setUp() {
        keys = new String[]{"a", "b", "c"};
        users = new String[]{"andy", "beth", "cathy"};
    }

    @Test
    void addUser() {
        Map<String, String> userData = CsvMapService.addUser(keys, users);
        System.out.println(userData.get("a"));

        assertEquals(userData.get("a"), "andy");
    }

    @Test
    void printAllObjects() {
        CsvMapService.printAllObjects(Collections.singletonList(users));
    }
}