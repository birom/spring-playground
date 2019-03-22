package com.example.datastructures.domain;

import static com.example.datastructures.domain.FavouriteItem.FAVOURITE_ITEM_DOCUMENT_TYPE;
import static com.example.datastructures.domain.JobAdvertisement.INDEX_NAME;
import static com.example.datastructures.domain.JobAdvertisement.JOB_ADVERTISEMENT_DOCUMENT_TYPE;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Parent;

@Document(indexName = INDEX_NAME, type = FAVOURITE_ITEM_DOCUMENT_TYPE)
public class FavouriteItem {

    public static final String FAVOURITE_ITEM_DOCUMENT_TYPE = "favourite-item";

    @Id
    private String id;

    @Field(type = FieldType.Text, store = true)
    @Parent(type = JOB_ADVERTISEMENT_DOCUMENT_TYPE)
    private String parentId;

    @Field(type = FieldType.Text)
    private String note;


    public String getId() {
        return id;
    }

    public FavouriteItem setId(String id) {
        this.id = id;
        return this;
    }

    public String getParentId() {
        return parentId;
    }

    public FavouriteItem setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getNote() {
        return note;
    }

    public FavouriteItem setNote(String note) {
        this.note = note;
        return this;
    }

    @Override
    public String toString() {
        return "FavouriteItem{" +
            "id='" + id + '\'' +
            ", parentId='" + parentId + '\'' +
            ", note='" + note + '\'' +
            '}';
    }
}
