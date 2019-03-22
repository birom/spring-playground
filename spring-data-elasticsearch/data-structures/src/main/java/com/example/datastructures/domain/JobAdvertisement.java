package com.example.datastructures.domain;

import static com.example.datastructures.domain.JobAdvertisement.INDEX_NAME;
import static com.example.datastructures.domain.JobAdvertisement.JOB_ADVERTISEMENT_DOCUMENT_TYPE;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = INDEX_NAME, type = JOB_ADVERTISEMENT_DOCUMENT_TYPE)
public class JobAdvertisement {

    public static final String INDEX_NAME = "parent-child-test-index";

    public static final String JOB_ADVERTISEMENT_DOCUMENT_TYPE = "job-advertisement";

    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String title;

    @Field(type = FieldType.Text)
    private String description;


    public String getId() {
        return id;
    }

    public JobAdvertisement setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public JobAdvertisement setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public JobAdvertisement setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "JobAdvertisement{" +
            "id='" + id + '\'' +
            ", title='" + title + '\'' +
            ", description='" + description + '\'' +
            '}';
    }
}
