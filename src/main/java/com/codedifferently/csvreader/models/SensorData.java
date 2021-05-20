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

    public long getTestId() {
        return testId;
    }

    public void setTestId(long testId) {
        this.testId = testId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public long getShoeId() {
        return shoeId;
    }

    public void setShoeId(long shoeId) {
        this.shoeId = shoeId;
    }

    public double getSensorReading1() {
        return sensorReading1;
    }

    public void setSensorReading1(double sensorReading1) {
        this.sensorReading1 = sensorReading1;
    }

    public double getSensorReading2() {
        return sensorReading2;
    }

    public void setSensorReading2(double sensorReading2) {
        this.sensorReading2 = sensorReading2;
    }
}
