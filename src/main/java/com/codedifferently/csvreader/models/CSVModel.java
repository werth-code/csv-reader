package com.codedifferently.csvreader.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Map;

public class CSVModel {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Map<String,String> properties;

    public CSVModel() {}

    public CSVModel(Map<String, String> properties) {
        this.properties = properties;
    }

    public Map<String,String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String,String> properties) {
        this.properties = properties;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CSVModel{" +
                "id=" + id +
                ", properties=" + properties +
                '}';
    }
}
