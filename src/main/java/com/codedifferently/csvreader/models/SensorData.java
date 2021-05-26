package com.codedifferently.csvreader.models;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

import javax.persistence.Column;

public class SensorData {
    private static final long serialVersionUID = 1L;

    @CsvBindByName(column = "Name")
    @CsvBindByPosition(position = 0)
    public String name;
    public String
            dateShipped,
            dateReceived,
            size,
            styleFoot,
            price,
            quantity,
            codeDurometer,
            serialNumber,
            last,
            model,
            upc,
            os,
            season,
            color,
            HheightBP,
            HheightActual,
            MedHeightBP,
            MedHeightActual,
            latHeightBP,
            latHeightActual,
            collarApexBP,
            collarApexActual,
            throatWidthBP,
            throatWidthActual,
            vampLengthBP,
            vampLengthActual,
            forefoot,
            midfoot,
            rearfoot,
            misc;

    public SensorData() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateShipped() {
        return dateShipped;
    }

    public void setDateShipped(String dateShipped) {
        this.dateShipped = dateShipped;
    }

    public String getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(String dateReceived) {
        this.dateReceived = dateReceived;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getStyleFoot() {
        return styleFoot;
    }

    public void setStyleFoot(String styleFoot) {
        this.styleFoot = styleFoot;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getCodeDurometer() {
        return codeDurometer;
    }

    public void setCodeDurometer(String codeDurometer) {
        this.codeDurometer = codeDurometer;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHheightBP() {
        return HheightBP;
    }

    public void setHheightBP(String hheightBP) {
        HheightBP = hheightBP;
    }

    public String getHheightActual() {
        return HheightActual;
    }

    public void setHheightActual(String hheightActual) {
        HheightActual = hheightActual;
    }

    public String getMedHeightBP() {
        return MedHeightBP;
    }

    public void setMedHeightBP(String medHeightBP) {
        MedHeightBP = medHeightBP;
    }

    public String getMedHeightActual() {
        return MedHeightActual;
    }

    public void setMedHeightActual(String medHeightActual) {
        MedHeightActual = medHeightActual;
    }

    public String getLatHeightBP() {
        return latHeightBP;
    }

    public void setLatHeightBP(String latHeightBP) {
        this.latHeightBP = latHeightBP;
    }

    public String getLatHeightActual() {
        return latHeightActual;
    }

    public void setLatHeightActual(String latHeightActual) {
        this.latHeightActual = latHeightActual;
    }

    public String getCollarApexBP() {
        return collarApexBP;
    }

    public void setCollarApexBP(String collarApexBP) {
        this.collarApexBP = collarApexBP;
    }

    public String getCollarApexActual() {
        return collarApexActual;
    }

    public void setCollarApexActual(String collarApexActual) {
        this.collarApexActual = collarApexActual;
    }

    public String getThroatWidthBP() {
        return throatWidthBP;
    }

    public void setThroatWidthBP(String throatWidthBP) {
        this.throatWidthBP = throatWidthBP;
    }

    public String getThroatWidthActual() {
        return throatWidthActual;
    }

    public void setThroatWidthActual(String throatWidthActual) {
        this.throatWidthActual = throatWidthActual;
    }

    public String getVampLengthBP() {
        return vampLengthBP;
    }

    public void setVampLengthBP(String vampLengthBP) {
        this.vampLengthBP = vampLengthBP;
    }

    public String getVampLengthActual() {
        return vampLengthActual;
    }

    public void setVampLengthActual(String vampLengthActual) {
        this.vampLengthActual = vampLengthActual;
    }

    public String getForefoot() {
        return forefoot;
    }

    public void setForefoot(String forefoot) {
        this.forefoot = forefoot;
    }

    public String getMidfoot() {
        return midfoot;
    }

    public void setMidfoot(String midfoot) {
        this.midfoot = midfoot;
    }

    public String getRearfoot() {
        return rearfoot;
    }

    public void setRearfoot(String rearfoot) {
        this.rearfoot = rearfoot;
    }

    public String getMisc() {
        return misc;
    }

    public void setMisc(String misc) {
        this.misc = misc;
    }

    @Override
    public String toString() {
        return "SensorData{" +
                "name='" + name + '\'' +
                ", dateShipped='" + dateShipped + '\'' +
                ", dateReceived='" + dateReceived + '\'' +
                ", size='" + size + '\'' +
                ", styleFoot='" + styleFoot + '\'' +
                ", price='" + price + '\'' +
                ", quantity='" + quantity + '\'' +
                ", codeDurometer='" + codeDurometer + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", last='" + last + '\'' +
                ", model='" + model + '\'' +
                ", upc='" + upc + '\'' +
                ", os='" + os + '\'' +
                ", season='" + season + '\'' +
                ", color='" + color + '\'' +
                ", HheightBP='" + HheightBP + '\'' +
                ", HheightActual='" + HheightActual + '\'' +
                ", MedHeightBP='" + MedHeightBP + '\'' +
                ", MedHeightActual='" + MedHeightActual + '\'' +
                ", latHeightBP='" + latHeightBP + '\'' +
                ", latHeightActual='" + latHeightActual + '\'' +
                ", collarApexBP='" + collarApexBP + '\'' +
                ", collarApexActual='" + collarApexActual + '\'' +
                ", throatWidthBP='" + throatWidthBP + '\'' +
                ", throatWidthActual='" + throatWidthActual + '\'' +
                ", vampLengthBP='" + vampLengthBP + '\'' +
                ", vampLengthActual='" + vampLengthActual + '\'' +
                ", forefoot='" + forefoot + '\'' +
                ", midfoot='" + midfoot + '\'' +
                ", rearfoot='" + rearfoot + '\'' +
                ", misc='" + misc + '\'' +
                '}';
    }
}

