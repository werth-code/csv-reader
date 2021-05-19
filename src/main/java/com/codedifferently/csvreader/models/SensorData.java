package com.codedifferently.csvreader.models;

import com.opencsv.bean.CsvBindByName;

public class SensorData {
    @CsvBindByName
    private long testId;
    @CsvBindByName
    private String companyName;
    @CsvBindByName
    private long shoeId;
    @CsvBindByName
    private double sensorReading1;
    @CsvBindByName
    private double sensorReading2;

    public SensorData() {
    }

    public SensorData(long testId, String companyName, long shoeId, double sensorReading1, double sensorReading2) {
        this.testId = testId;
        this.companyName = companyName;
        this.shoeId = shoeId;
        this.sensorReading1 = sensorReading1;
        this.sensorReading2 = sensorReading2;
    }



}
