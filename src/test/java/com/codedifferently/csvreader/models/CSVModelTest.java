package com.codedifferently.csvreader.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CSVModelTest {

    CSVModel csvModel;
    Map<String, String> map;

    @BeforeEach
    void setUp() {
        csvModel = new CSVModel();
        map = new HashMap<>();
        map.put("A", "Adam");
        map.put("B", "Barbara");
    }

    @Test
    void setProperties() {
        csvModel.setProperties(map);
        Map<String, String> actual = csvModel.getProperties();
        String expected = csvModel.getProperties().toString();
        System.out.println(actual);

        assertEquals(expected, actual.toString());
    }

    @Test
    void getProperties() {
        csvModel.setProperties(map);
        Map<String, String> actual = csvModel.getProperties();
        String expected = csvModel.getProperties().toString();
        System.out.println(actual);

        assertEquals(expected, actual.toString());
    }

    @Test
    void setId() {
        csvModel.setId(1L);
        Long actual = csvModel.getId();
        Long expected = 1L;

        assertEquals(actual, expected);
    }


    @Test
    void getId() {
        csvModel.setId(1L);
        Long actual = csvModel.getId();
        Long expected = 1L;

        assertEquals(actual, expected);
    }

}