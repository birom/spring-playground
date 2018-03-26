package com.example.demo.domain;

import java.util.Objects;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class JobAdvertisement {

    @Id
    private String jobAdvertisementId;
    private String fingerPrint;
    @Embedded
    private JobContent jobContent;

    public String getJobAdvertisementId() {
        return jobAdvertisementId;
    }

    public void setJobAdvertisementId(String jobAdvertisementId) {
        this.jobAdvertisementId = jobAdvertisementId;
    }

    public String getFingerPrint() {
        return fingerPrint;
    }

    public void setFingerPrint(String fingerPrint) {
        this.fingerPrint = fingerPrint;
    }

    public JobContent getJobContent() {
        return jobContent;
    }

    public void setJobContent(JobContent jobContent) {
        this.jobContent = jobContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        JobAdvertisement that = (JobAdvertisement) o;
        return Objects.equals(jobAdvertisementId, that.jobAdvertisementId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobAdvertisementId);
    }
}
