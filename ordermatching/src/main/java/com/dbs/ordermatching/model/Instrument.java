package com.dbs.ordermatching.model;

 

import java.util.Date;

 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

 

@Entity(name="instrument")
public class Instrument {
    @Id
    @Column(name="instrumentid")
    private String instrumentId;
    @Column(name="instrumentname")
    private String instrumentName;
    @Column(name="facevalue")
    private double faceValue;
    @Column(name="expirydate")
    private  Date expiryDate;
    @Column(name="minquantity")
    private int minQuantity;
    public String getInstrumentId() {
        return instrumentId;
    }
    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
    }
    public String getInstrumentName() {
        return instrumentName;
    }
    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }
    public double getFaceValue() {
        return faceValue;
    }
    public void setFaceValue(double faceValue) {
        this.faceValue = faceValue;
    }
    public Date getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
    public int getMinQuantity() {
        return minQuantity;
    }
    public void setMinQuantity(int minQuantity) {
        this.minQuantity = minQuantity;
    }
    public Instrument() {
        
    }
    public Instrument(String instrumentId, String instrumentName, double faceValue, Date expiryDate, int minQuantity) {
        super();
        this.instrumentId = instrumentId;
        this.instrumentName = instrumentName;
        this.faceValue = faceValue;
        this.expiryDate = expiryDate;
        this.minQuantity = minQuantity;
    }
    @Override
    public String toString() {
        return "Instrument [instrumentId=" + instrumentId + ", instrumentName=" + instrumentName + ", faceValue="
                + faceValue + ", expiryDate=" + expiryDate + ", minQuantity=" + minQuantity + "]";
    }

}