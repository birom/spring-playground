package com.example.demo.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Location {
    private String remarks;
    private String city;
    private String postalCode;


    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Location{" +
            "remarks='" + remarks + '\'' +
            ", city='" + city + '\'' +
            ", postalCode='" + postalCode + '\'' +
            '}';
    }
}
