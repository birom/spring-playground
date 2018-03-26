package com.example.demo.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Occupation {
    private String sbn3Code;
    private String sbn5Code;
    private String avamCode;

    public String getSbn3Code() {
        return sbn3Code;
    }

    public void setSbn3Code(String sbn3Code) {
        this.sbn3Code = sbn3Code;
    }

    public String getSbn5Code() {
        return sbn5Code;
    }

    public void setSbn5Code(String sbn5Code) {
        this.sbn5Code = sbn5Code;
    }

    public String getAvamCode() {
        return avamCode;
    }

    public void setAvamCode(String avamCode) {
        this.avamCode = avamCode;
    }
}
